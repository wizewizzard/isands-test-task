package com.wz.testtask.estore.web.portlet.primary;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.wz.testtask.estore.exception.ConsistencyViolationException;
import com.wz.testtask.estore.exception.EmptyFieldException;
import com.wz.testtask.estore.exception.EmptyPersonNameException;
import com.wz.testtask.estore.exception.InvalidBirthDateException;
import com.wz.testtask.estore.model.DeviceType;
import com.wz.testtask.estore.model.Employee;
import com.wz.testtask.estore.service.DeviceTypeLocalServiceUtil;
import com.wz.testtask.estore.service.EmployeeLocalServiceUtil;
import com.wz.testtask.estore.service.EmployeePositionLocalServiceUtil;
import com.wz.testtask.estore.web.constants.EmployeePortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aleksei
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Employees",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/employee/view.jsp",
                "javax.portlet.name=" + EmployeePortletKeys.EMPLOYEE,
                "javax.portlet.resource-bundle=content.Language"
                //"javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class EmployeeCRUDPortlet extends MVCPortlet {
    private static Log logger = LogFactoryUtil.getLog(EmployeeCRUDPortlet.class);
    
    public void addEmployee(ActionRequest request, ActionResponse response) throws PortalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        String firstName = ParamUtil.getString(request, "firstName");
        String lastName = ParamUtil.getString(request, "lastName");
        String patronymic = ParamUtil.getString(request, "patronymic");
        String gender = ParamUtil.getString(request, "gender");
        Date birthDate = ParamUtil.getDate(request, "birthDate", new SimpleDateFormat("dd/MM/yyyy"));
        long positionId = ParamUtil.getLong(request, "positionId");
        
        List<Long> consultedDeviceTypeIds = Arrays
                .stream(ParamUtil.getLongValues(request, "deviceTypes"))
                .boxed()
                .collect(Collectors.toList());

        logger.info(String.format("addEmployee params are: " +
                        "firstName: %s, lastName: %s, patronymic: %s, gender: %s, positionId: %d, birthDate: %s. Type checks: %s",
                firstName, lastName, patronymic, gender, positionId, birthDate, consultedDeviceTypeIds));

        try {
            Employee employee = EmployeeLocalServiceUtil.addEmployee(firstName, lastName, patronymic,
                    birthDate, gender, positionId, serviceContext);
            for(Long deviceTypeId : consultedDeviceTypeIds )
                DeviceTypeLocalServiceUtil.addEmployeeDeviceType(employee.getEmployeeId(), deviceTypeId);
            SessionMessages.add(request, "employee-added");
            logger.info("Employee was created");
        }
        catch (EmptyPersonNameException exception){
            SessionErrors.add(request, "empty-person-name");
            logger.error("Names must not be empty");
            response.setRenderParameter("mvcPath", "/employee/edit.jsp");
        }
        catch (EmptyFieldException exception){
            SessionErrors.add(request, "required-field-empty");
            logger.error("Given birth date is not valid");
            response.setRenderParameter("mvcPath", "/employee/edit.jsp");
        }
        catch (InvalidBirthDateException exception){
            SessionErrors.add(request, "invalid-birth-date");
            logger.error("Given birth date is not valid");
            response.setRenderParameter("mvcPath", "/employee/edit.jsp");
        }
        catch (PortalException exception) {
            logger.error("Error occurred!", exception);
            SessionErrors.add(request, "portal-error");
            response.setRenderParameter("mvcPath", "/error.jsp");
        }
    }
    
    public void updateEmployee(ActionRequest request, ActionResponse response) throws PortalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        long employeeId = ParamUtil.getLong(request, "employeeId");
        String firstName = ParamUtil.getString(request, "firstName");
        String lastName = ParamUtil.getString(request, "lastName");
        String patronymic = ParamUtil.getString(request, "patronymic");
        String gender = ParamUtil.getString(request, "gender");
        long positionId = ParamUtil.getLong(request, "positionId");
        Date birthDate = ParamUtil.getDate(request, "birthDate", new SimpleDateFormat("dd/MM/yyyy"));
        
        List<Long> consultedDeviceTypeIds = Arrays
                .stream(ParamUtil.getLongValues(request, "deviceTypes"))
                .boxed()
                .collect(Collectors.toList());
        
        logger.info(String.format("updateEmployee params are: " +
                        "firstName: %s, lastName: %s, patronymic: %s, gender: %s, positionId: %d, birthDate: %s ",
                firstName, lastName, patronymic, gender, positionId, birthDate));
    
        try {
            Employee employee = EmployeeLocalServiceUtil.updateEmployee(employeeId, firstName, lastName, patronymic,
                    birthDate, gender, positionId, serviceContext);
            List<DeviceType> consultedDeviceTypes = DeviceTypeLocalServiceUtil.getEmployeeDeviceTypes(employee.getEmployeeId());
            for(Long deviceTypeId : consultedDeviceTypeIds ){
                if(consultedDeviceTypes.stream().noneMatch(dt -> dt.getDeviceTypeId() == deviceTypeId))
                    DeviceTypeLocalServiceUtil.addEmployeeDeviceType(employee.getEmployeeId(), deviceTypeId);
                else
                    consultedDeviceTypes.removeIf(dt -> dt.getDeviceTypeId() == deviceTypeId);
            }
            for(DeviceType deviceType : consultedDeviceTypes){
                DeviceTypeLocalServiceUtil.deleteEmployeeDeviceType(employee.getEmployeeId(), deviceType.getDeviceTypeId());
            }
            SessionMessages.add(request, "employee-updated");
            logger.info("Employee was updated");
        }
        catch (EmptyPersonNameException exception){
            SessionErrors.add(request, "empty-person-name");
            logger.error("Names must not be empty");
            response.setRenderParameter("mvcPath", "/employee/edit.jsp");
        }
        catch (EmptyFieldException exception){
            SessionErrors.add(request, "required-field-empty");
            logger.error("Given birth date is not valid");
            response.setRenderParameter("mvcPath", "/employee/edit.jsp");
        }
        catch (InvalidBirthDateException exception){
            SessionErrors.add(request, "invalid-birth-date");
            logger.error("Given birth date is not valid");
            response.setRenderParameter("mvcPath", "/employee/edit.jsp");
        }
        catch (PortalException exception) {
            logger.error("Error occurred!", exception);
            SessionErrors.add(request, "portal-error");
            response.setRenderParameter("mvcPath", "/error.jsp");
        }
    }
    
    public void deleteEmployee(ActionRequest request, ActionResponse response) throws PortalException {
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
            long employeeId = ParamUtil.getLong(request, "employeeId");
            EmployeeLocalServiceUtil.deleteById(employeeId, serviceContext);
            SessionMessages.add(request, "employee-deleted");
            logger.info("Employee was deleted");
        } catch (ConsistencyViolationException exception) {
            logger.error("Trying to remove a user who has purchases attached to him");
            SessionErrors.add(request, "consistency-violation");
        } catch (PortalException t) {
            logger.error("Error occurred when deleting employee!", t);
            SessionErrors.add(request, "error-key");
            response.setRenderParameter("mvcPath", "/error.jsp");
        }
    }
}