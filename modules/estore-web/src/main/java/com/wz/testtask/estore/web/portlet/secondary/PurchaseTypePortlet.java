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
import com.wz.testtask.estore.service.PurchaseTypeLocalServiceUtil;
import com.wz.testtask.estore.web.constants.PurchasePortletKeys;
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
                "com.liferay.portlet.display-category=testtask",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Purchase type",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/purchase-type/view.jsp",
                "javax.portlet.name=" + PurchasePortletKeys.PURCHASE_TYPE,
                "javax.portlet.resource-bundle=content.Language"
                //"javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class PurchaseTypePortlet extends MVCPortlet {
    private static Log logger = LogFactoryUtil.getLog(PurchaseTypePortlet.class);
    
    public void addPurchaseType(ActionRequest request, ActionResponse response)
            throws PortalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        
        String purchaseTypeName = ParamUtil.getString(request, "name");
        
        try {
            PurchaseTypeLocalServiceUtil.addPurchaseType(purchaseTypeName, serviceContext);
            SessionMessages.add(request, "purchase-type-added");
            logger.info("Purchase type was created");
        }
        catch (EmptyFieldException exception){
            SessionErrors.add(request, "empty-name");
            logger.error("Given name is empty");
            response.setRenderParameter("mvcPath", "/purchase-type/edit.jsp");
        }
        catch (Exception e) {
            SessionErrors.add(request, "portal-error");
            logger.error("Purchase type creation ended up with an error", e);
            response.setRenderParameter("mvcPath", "/error.jsp");
        }
    }
    
    public void updatePurchaseType(ActionRequest request, ActionResponse response)
            throws PortalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        
        String purchaseTypeName = ParamUtil.getString(request, "name");
        long purchaseTypeId = ParamUtil.getLong(request, "purchaseTypeId");
        
        try {
            PurchaseTypeLocalServiceUtil.updatePurchaseType(purchaseTypeId, purchaseTypeName, serviceContext);
            SessionMessages.add(request, "purchase-type-updated");
            logger.info("Purchase type was updated");
        }
        catch (EmptyFieldException exception){
            SessionErrors.add(request, "empty-name");
            logger.error("Given name is empty");
            response.setRenderParameter("mvcPath", "/purchase-type/edit.jsp");
        }
        catch (Exception e) {
            SessionErrors.add(request, "portal-error");
            logger.error("Purchase type creation ended up with an error", e);
            response.setRenderParameter("mvcPath", "/error.jsp");
        }
    }
}
