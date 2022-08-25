<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@
        taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@
        taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@
        taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.wz.testtask.estore.model.DeviceType" %>
<%@ page import="com.wz.testtask.estore.model.EmployeePosition" %>
<%@ page import="com.wz.testtask.estore.service.DeviceTypeLocalServiceUtil" %>
<%@ page import="com.wz.testtask.estore.service.EmployeeLocalServiceUtil" %>
<%@ page import="com.wz.testtask.estore.service.EmployeePositionLocalServiceUtil" %>
<%@ page import="com.wz.testtask.estore.service.EmployeeWithSummaryLocalServiceUtil" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.List" %>

<liferay-theme:defineObjects/>

<portlet:defineObjects/>