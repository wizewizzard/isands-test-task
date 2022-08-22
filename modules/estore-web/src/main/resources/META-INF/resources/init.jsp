<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%@ page import="com.wz.testtask.estore.service.PurchaseTypeLocalServiceUtil" %>
<%@ page import="com.wz.testtask.estore.service.EmployeeLocalServiceUtil" %>
<%@ page import="com.wz.testtask.estore.service.DeviceTypeLocalServiceUtil" %>
<%@ page import="com.wz.testtask.estore.service.EmployeePositionLocalServiceUtil" %>
<%@ page import="com.wz.testtask.estore.service.DeviceLocalServiceUtil" %>

<%@ page import="com.wz.testtask.estore.model.EmployeePosition" %>
<%@ page import="com.wz.testtask.estore.model.PurchaseType" %>
<%@ page import="com.wz.testtask.estore.model.DeviceType" %>
<%@ page import="com.wz.testtask.estore.model.Employee" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />