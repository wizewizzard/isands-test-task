package com.wz.testtask.estore.bestemployee.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.wz.testtask.estore.bestemployee.constants.BestEmployeePortletKeys;
import com.wz.testtask.estore.model.EmployeeWithSummary;
import com.wz.testtask.estore.service.EmployeeWithSummaryLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import java.io.IOException;
import java.util.List;

/**
 * @author aleksei
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=BestEmployee",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/best-empl/view.jsp",
                "javax.portlet.name=" + BestEmployeePortletKeys.BESTEMPLOYEE,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class BestEmployeePortlet extends MVCPortlet {
    private static final Log logger = LogFactoryUtil.getLog(BestEmployeePortlet.class);
    
	public void getBestEmployees(ActionRequest request, ActionResponse response) throws PortalException {
	
	}
}