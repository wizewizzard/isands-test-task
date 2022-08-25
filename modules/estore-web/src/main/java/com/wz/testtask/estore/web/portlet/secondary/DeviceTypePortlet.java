package com.wz.testtask.estore.web.portlet.secondary;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.wz.testtask.estore.exception.EmptyFieldException;
import com.wz.testtask.estore.service.DeviceTypeLocalServiceUtil;
import com.wz.testtask.estore.web.constants.DevicePortletKeys;
import com.wz.testtask.estore.web.portlet.primary.EmployeeCRUDPortlet;
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
                "javax.portlet.display-name=Device type",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/device-type/view.jsp",
                "javax.portlet.name=" + DevicePortletKeys.DEVICE_TYPE,
                "javax.portlet.resource-bundle=content.Language"
                //"javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class DeviceTypePortlet extends MVCPortlet {
    private static Log logger = LogFactoryUtil.getLog(EmployeeCRUDPortlet.class);
    
    public void addDeviceType(ActionRequest request, ActionResponse response)
            throws PortalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        
        String deviceTypeName = ParamUtil.getString(request, "name");
    
        try {
            DeviceTypeLocalServiceUtil.addDeviceType(deviceTypeName, serviceContext);
            SessionMessages.add(request, "device-type-added");
            logger.info("Device type was created");
        }
        catch (EmptyFieldException exception){
            SessionErrors.add(request, "empty-name");
            logger.error("Given name is empty");
            response.setRenderParameter("mvcPath", "/device-type/edit.jsp");
        }
        catch (PortalException e) {
            SessionErrors.add(request, "portal-error");
            logger.error("Device type creation ended up with an error", e);
            
        }
    }
    
    public void updateDeviceType(ActionRequest request, ActionResponse response)
            throws PortalException{
        
        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        String deviceTypeName = ParamUtil.getString(request, "name");
        long deviceTypeId = ParamUtil.getLong(request, "deviceTypeId");
        
        try{
            DeviceTypeLocalServiceUtil.updateDeviceType(deviceTypeId, deviceTypeName, serviceContext);
            SessionMessages.add(request, "device-type-updated");
            logger.info("Device type was updated");
        }
        catch (EmptyFieldException exception){
            SessionErrors.add(request, "empty-name");
            logger.error("Given name is empty");
            response.setRenderParameter("mvcPath", "/device-type/edit.jsp");
        }
        catch (PortalException e) {
            SessionErrors.add(request, "portal-error");
            logger.error("Device type creation ended up with an error", e);
        }
    }
}
