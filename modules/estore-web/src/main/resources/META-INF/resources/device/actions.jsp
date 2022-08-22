<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.wz.testtask.estore.model.*" %>
<%@include file="../init.jsp"%>

<%
    ResultRow row = (ResultRow) request
            .getAttribute("SEARCH_CONTAINER_RESULT_ROW");

    Device device = (Device) row.getObject();
%>

<liferay-ui:icon-menu>

    <portlet:renderURL var="editURL">
        <portlet:param name="deviceId"
                       value="<%=String.valueOf(device.getDeviceId()) %>" />
        <portlet:param name="mvcPath"
                       value="/device/edit.jsp" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit"
                     url="<%=editURL.toString() %>" />

    <portlet:actionURL name="deleteDevice" var="deleteURL">
        <portlet:param name="deviceId"
                       value="<%= String.valueOf(device.getDeviceId()) %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

</liferay-ui:icon-menu>
