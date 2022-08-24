package com.wz.testtask.estore.purchase.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.wz.testtask.estore.exception.*;
import com.wz.testtask.estore.purchase.constants.PurchasePortletKeys;
import com.wz.testtask.estore.service.PurchaseLocalServiceUtil;
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
                "javax.portlet.display-name=Purchase",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + PurchasePortletKeys.PURCHASE,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class PurchasePortlet extends MVCPortlet {
    private static final Log logger = LogFactoryUtil.getLog(PurchasePortlet.class);
    
    public void makePurchase(ActionRequest request, ActionResponse response) throws PortalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        long employeeId = ParamUtil.getLong(request, "employeeId");
        long deviceId = ParamUtil.getLong(request, "deviceId");
        int count = ParamUtil.getInteger(request, "count");
        int purchaseTypeId = ParamUtil.getInteger(request, "purchaseTypeId");
        
        try {
            PurchaseLocalServiceUtil.makePurchase(employeeId, deviceId, count,
                    purchaseTypeId, serviceContext);
            SessionMessages.add(request, "purchase-success");
        } catch (WrongAmountOfDevicesException exception) {
            SessionErrors.add(request, "wrong-amount");
            logger.error("Wrong number of devices given");
            response.setRenderParameter("mvcPath", "/edit.jsp");
        } catch (EmployeeIsNotResponsibleException exception) {
            SessionErrors.add(request, "employee-not-responsible");
            logger.error("Employee is not able to sign this purchase");
            response.setRenderParameter("mvcPath", "/edit.jsp");
        } catch (DeviceIsArchivedException exception) {
            SessionErrors.add(request, "device-is-archived");
            logger.error("Device is archived. No way to buy it");
            response.setRenderParameter("mvcPath", "/edit.jsp");
        } catch (NoSuchDeviceException exception) {
            SessionErrors.add(request, "no-such-device");
            logger.error("No such device was found");
            response.setRenderParameter("mvcPath", "/edit.jsp");
        } catch (DeviceIsOutOfStockException exception) {
            SessionErrors.add(request, "not-enough-devices-in-stock");
            logger.error("There are not enough devices in stock to make purchase");
            response.setRenderParameter("mvcPath", "/edit.jsp");
        } catch (NoSuchPurchaseTypeException exception) {
            SessionErrors.add(request, "no-such-purchase-type");
            logger.error("No such purchase type was found");
            response.setRenderParameter("mvcPath", "/edit.jsp");
        } catch (PortalException exception) {
            SessionErrors.add(request, "portal-error");
            logger.error("Portal exception when making purchase", exception);
            response.setRenderParameter("jspPage", "/error.jsp");
        }
    }
    
    public void updatePurchase(ActionRequest request, ActionResponse response) throws PortalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        long purchaseId = ParamUtil.getLong(request, "purchaseId");
        long employeeId = ParamUtil.getLong(request, "employeeId");
        long deviceId = ParamUtil.getLong(request, "deviceId");
        int count = ParamUtil.getInteger(request, "count");
        int purchaseTypeId = ParamUtil.getInteger(request, "purchaseTypeId");
        
        try {
            PurchaseLocalServiceUtil.updatePurchase(purchaseId, employeeId, deviceId, count,
                    purchaseTypeId, serviceContext);
            SessionMessages.add(request, "purchase-success");
        } catch (WrongAmountOfDevicesException exception) {
            SessionErrors.add(request, "wrong-amount");
            logger.error("Wrong number of devices given");
            response.setRenderParameter("mvcPath", "/edit.jsp");
        } catch (EmployeeIsNotResponsibleException exception) {
            SessionErrors.add(request, "employee-not-responsible");
            logger.error("Employee is not able to sign this purchase");
            response.setRenderParameter("mvcPath", "/edit.jsp");
        } catch (DeviceIsArchivedException exception) {
            SessionErrors.add(request, "device-is-archived");
            logger.error("Device is archived. No way to buy it");
            response.setRenderParameter("mvcPath", "/edit.jsp");
        } catch (NoSuchDeviceException exception) {
            SessionErrors.add(request, "no-such-device");
            logger.error("No such device was found");
            response.setRenderParameter("mvcPath", "/edit.jsp");
        } catch (DeviceIsOutOfStockException exception) {
            SessionErrors.add(request, "not-enough-devices-in-stock");
            logger.error("There are not enough devices in stock to make purchase");
            response.setRenderParameter("mvcPath", "/edit.jsp");
        } catch (NoSuchPurchaseTypeException exception) {
            SessionErrors.add(request, "no-such-purchase-type");
            logger.error("No such purchase type was found");
            response.setRenderParameter("mvcPath", "/edit.jsp");
        } catch (PortalException exception) {
            SessionErrors.add(request, "portal-error");
            logger.error("Portal exception when making purchase", exception);
            response.setRenderParameter("jspPage", "/error.jsp");
        }
    }
    
}