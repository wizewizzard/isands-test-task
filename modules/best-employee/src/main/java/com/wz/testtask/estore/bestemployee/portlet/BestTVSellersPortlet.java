package com.wz.testtask.estore.bestemployee.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.wz.testtask.estore.bestemployee.constants.BestEmployeePortletKeys;
import org.osgi.service.component.annotations.Component;

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
                "javax.portlet.display-name=BestTvSellers",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/best-tv-sell/view.jsp",
                "javax.portlet.name=" + BestEmployeePortletKeys.BEST_TV_SELLERS,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class BestTVSellersPortlet extends MVCPortlet {
    private static final Log logger = LogFactoryUtil.getLog(BestTVSellersPortlet.class);
    
}
