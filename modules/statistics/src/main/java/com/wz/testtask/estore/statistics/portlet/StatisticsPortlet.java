package com.wz.testtask.estore.statistics.portlet;

import com.wz.testtask.estore.statistics.constants.StatisticsPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author aleksei
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=testtask",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Statistics",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + StatisticsPortletKeys.STATISTICS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StatisticsPortlet extends MVCPortlet {

}