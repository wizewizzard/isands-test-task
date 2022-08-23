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
import com.wz.testtask.estore.model.Employee;
import com.wz.testtask.estore.service.EmployeeLocalServiceUtil;
import com.wz.testtask.estore.web.constants.EmployeePortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

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
    
    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        
        super.render(renderRequest, renderResponse);
    }
    
    public void addEmployee(ActionRequest request, ActionResponse response) throws PortalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        String firstName = ParamUtil.getString(request, "firstName");
        String lastName = ParamUtil.getString(request, "lastName");
        String patronymic = ParamUtil.getString(request, "patronymic");
        String gender = ParamUtil.getString(request, "gender");
        long positionId = ParamUtil.getLong(request, "positionId");
        int dayParam = ParamUtil.getInteger(request, "dayParam");
        int monthParam = ParamUtil.getInteger(request, "monthParam");
        int yearParam = ParamUtil.getInteger(request, "yearParam");

        GregorianCalendar calendar = new GregorianCalendar(yearParam, monthParam, dayParam);
        Date birthDate = calendar.getTime();
        logger.info(String.format("addEmployee params are: " +
                        "firstName: %s, lastName: %s, patronymic: %s, gender: %s, positionId: %d, birthDate: %s",
                firstName, lastName, patronymic, gender, positionId, birthDate));

        try {
            EmployeeLocalServiceUtil.addEmployee(firstName, lastName, patronymic,
                    birthDate, gender, positionId, serviceContext);
            SessionMessages.add(request, "employee-added");
            logger.info("Employee was created");
        } catch (PortalException t) {
            logger.error("Error occurred!", t);
            SessionErrors.add(request, "error-key");
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
        int dayParam = ParamUtil.getInteger(request, "dayParam");
        int monthParam = ParamUtil.getInteger(request, "monthParam");
        int yearParam = ParamUtil.getInteger(request, "yearParam");
    
        GregorianCalendar calendar = new GregorianCalendar(yearParam, monthParam, dayParam);
        Date birthDate = calendar.getTime();
        logger.info(String.format("updateEmployee params are: " +
                        "firstName: %s, lastName: %s, patronymic: %s, gender: %s, positionId: %d, birthDate: %s ",
                firstName, lastName, patronymic, gender, positionId, birthDate));
    
        try {
            EmployeeLocalServiceUtil.updateEmployee(employeeId, firstName, lastName, patronymic,
                    birthDate, gender, positionId, serviceContext);
            SessionMessages.add(request, "employee-updated");
            logger.info("Employee was updated");
        } catch (PortalException t) {
            logger.error("Error occurred!", t);
            SessionErrors.add(request, "error-key");
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
            logger.error("Trying to remove a user who has purchase types he consults about attached!");
            SessionErrors.add(request, "consistency-violation-key");
        } catch (PortalException t) {
            logger.error("Error occurred!", t);
            SessionErrors.add(request, "error-key");
        }
    }
}