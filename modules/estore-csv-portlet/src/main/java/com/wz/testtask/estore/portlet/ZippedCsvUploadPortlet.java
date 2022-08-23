package com.wz.testtask.estore.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.wz.testtask.estore.constants.ZippedCsvUploadPortletKeys;
import org.osgi.service.component.annotations.Component;

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
                "javax.portlet.display-name=ZippedCsvUpload",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + ZippedCsvUploadPortletKeys.ZIPPEDCSVUPLOAD,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class ZippedCsvUploadPortlet extends MVCPortlet {
    
}