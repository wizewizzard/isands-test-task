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
import com.wz.testtask.estore.service.EmployeePositionLocalServiceUtil;
import com.wz.testtask.estore.web.constants.EmployeePortletKeys;
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
                "javax.portlet.display-name=Employee Position",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/employee-pos/view.jsp",
                "javax.portlet.name=" + EmployeePortletKeys.EMPLOYEE_POSITION,
                "javax.portlet.resource-bundle=content.Language"
                //"javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class EmployeePositionPortlet extends MVCPortlet {
    private static Log logger = LogFactoryUtil.getLog(EmployeePositionPortlet.class);
    
    public void addPosition(ActionRequest request, ActionResponse response)
            throws PortalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        String positionName = ParamUtil.getString(request, "name");
        
        try {
            EmployeePositionLocalServiceUtil.addEmployeePosition(positionName, serviceContext);
            SessionMessages.add(request, "employee-position-added");
            logger.info("Employee position was updated");
        }
        catch (EmptyFieldException exception){
            SessionErrors.add(request, "empty-name");
            logger.error("Given name is empty");
            response.setRenderParameter("mvcPath", "/employee-pos/edit.jsp");
        }
        catch (PortalException e) {
            SessionErrors.add(request, e.getClass());
            logger.error("Employee position creation ended up with an error", e);
            response.setRenderParameter("mvcPath", "/error.jsp");
        }
    }
    
    public void updatePosition(ActionRequest request, ActionResponse response)
            throws PortalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        String positionName = ParamUtil.getString(request, "name");
        long positionId = ParamUtil.getLong(request, "positionId");
        
        try {
            EmployeePositionLocalServiceUtil.updateEmployeePosition(positionId, positionName, serviceContext);
            SessionMessages.add(request, "employee-position-updated");
            logger.info("Employee position was updated");
        }
        catch (EmptyFieldException exception){
            SessionErrors.add(request, "empty-name");
            logger.error("Given name is empty");
            response.setRenderParameter("mvcPath", "/employee-pos/edit.jsp");
        }
        catch (PortalException e) {
            SessionErrors.add(request, e.getClass());
            logger.error("Employee position creation ended up with an error", e);
            response.setRenderParameter("mvcPath", "/error.jsp");
        }
    }
}
