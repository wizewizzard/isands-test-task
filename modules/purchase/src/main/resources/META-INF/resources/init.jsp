<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.wz.testtask.estore.model.Device" %>
<%@ page import="com.wz.testtask.estore.model.Employee" %>
<%@ page import="com.wz.testtask.estore.model.Purchase" %>
<%@ page import="com.wz.testtask.estore.model.PurchaseType" %>
<%@ page import="com.wz.testtask.estore.service.DeviceLocalServiceUtil" %>
<%@ page import="com.wz.testtask.estore.service.EmployeeLocalServiceUtil" %>
<%@ page import="com.wz.testtask.estore.service.PurchaseLocalServiceUtil" %>
<%@ page import="com.wz.testtask.estore.service.PurchaseTypeLocalServiceUtil" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />