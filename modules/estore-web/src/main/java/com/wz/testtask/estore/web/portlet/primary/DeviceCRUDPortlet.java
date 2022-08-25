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
import com.wz.testtask.estore.exception.IllegalDeviceCountValueException;
import com.wz.testtask.estore.exception.IllegalPriceValueException;
import com.wz.testtask.estore.service.DeviceLocalServiceUtil;
import com.wz.testtask.estore.service.EmployeeLocalServiceUtil;
import com.wz.testtask.estore.web.constants.DevicePortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

/**
 * @author aleksei
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Devices",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/device/view.jsp",
                "javax.portlet.name=" + DevicePortletKeys.DEVICE,
                "javax.portlet.resource-bundle=content.Language"
                //"javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class DeviceCRUDPortlet extends MVCPortlet {
    private static Log logger = LogFactoryUtil.getLog(EmployeeCRUDPortlet.class);
    
    public void addDevice(ActionRequest request, ActionResponse response) throws PortalException {
        String name = ParamUtil.getString(request, "name");
        long price = ParamUtil.getLong(request, "price");
        int count = ParamUtil.getInteger(request, "count");
        boolean archive = ParamUtil.getBoolean(request, "archive");
        long deviceTypeId = ParamUtil.getLong(request, "deviceTypeId");
        String description = ParamUtil.getString(request, "description");
        
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
            DeviceLocalServiceUtil.addDevice(name, price, deviceTypeId,
                    count, archive, description, serviceContext);
            SessionMessages.add(request, "device-added");
            logger.info("Device was created");
        }
        catch (EmptyFieldException exception){
            SessionErrors.add(request, "required-field-empty");
            logger.error("One or more of the fields are empty");
            response.setRenderParameter("mvcPath", "/device/edit.jsp");
        }
        catch (IllegalPriceValueException exception){
            SessionErrors.add(request, "invalid-device-price");
            logger.error("Device's price can not be less than 0");
            response.setRenderParameter("mvcPath", "/device/edit.jsp");
        }
        catch (IllegalDeviceCountValueException exception){
            SessionErrors.add(request, "invalid-device-count");
            logger.error("Device count can not be less than 0");
            response.setRenderParameter("mvcPath", "/device/edit.jsp");
        }
        catch (PortalException exception) {
            logger.error("Portal error occurred!", exception);
            SessionErrors.add(request, "portal-error");
            response.setRenderParameter("mvcPath", "/error.jsp");
        }
    }
    
    public void updateDevice(ActionRequest request, ActionResponse response) throws PortalException {
        long deviceId = ParamUtil.getLong(request, "deviceId");
        String name = ParamUtil.getString(request, "name");
        long price = ParamUtil.getLong(request, "price");
        int count = ParamUtil.getInteger(request, "count");
        boolean archive = ParamUtil.getBoolean(request, "archive");
        long deviceTypeId = ParamUtil.getLong(request, "deviceTypeId");
        String description = ParamUtil.getString(request, "description");
        
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
            DeviceLocalServiceUtil.updateDevice(deviceId, name, price, deviceTypeId,
                    count, archive, description, serviceContext);
            SessionMessages.add(request, "device-updated");
            logger.info("Device was created");
        }
        catch (EmptyFieldException exception){
            SessionErrors.add(request, "required-field-empty");
            logger.error("One or more of the fields are empty");
            response.setRenderParameter("mvcPath", "/device/edit.jsp");
        }
        catch (IllegalPriceValueException exception){
            SessionErrors.add(request, "invalid-device-price");
            logger.error("Device's price can not be less than 0");
            response.setRenderParameter("mvcPath", "/device/edit.jsp");
        }
        catch (IllegalDeviceCountValueException exception){
            SessionErrors.add(request, "invalid-device-count");
            logger.error("Device count can not be less than 0");
            response.setRenderParameter("mvcPath", "/device/edit.jsp");
        }
        catch (PortalException exception) {
            logger.error("Portal error occurred!", exception);
            SessionErrors.add(request, "portal-error");
            response.setRenderParameter("mvcPath", "/error.jsp");
        }
    }
    
    public void deleteDevice(ActionRequest request, ActionResponse response) {
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
            long deviceId = ParamUtil.getLong(request, "employeeId");
            EmployeeLocalServiceUtil.deleteById(deviceId, serviceContext);
            SessionMessages.add(request, "device-deleted");
            logger.info("Employee was deleted");
        } catch (ConsistencyViolationException exception) {
            logger.error("Trying to remove the devices that has purchases he consults about attached!");
            SessionErrors.add(request, "consistency-violation");
        } catch (PortalException exception) {
            logger.error("Error occurred!", exception);
            SessionErrors.add(request, "error-key");
        }
    }
}
