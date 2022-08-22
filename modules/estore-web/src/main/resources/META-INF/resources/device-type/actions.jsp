<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@include file="../init.jsp"%>

<%
    ResultRow row = (ResultRow) request
            .getAttribute("SEARCH_CONTAINER_RESULT_ROW");

    DeviceType deviceType = (DeviceType) row.getObject();
%>

<liferay-ui:icon-menu>

    <portlet:renderURL var="editURL">
        <portlet:param name="deviceTypeId"
                       value="<%=String.valueOf(deviceType.getDeviceTypeId()) %>" />
        <portlet:param name="mvcPath"
                       value="/device-type/edit.jsp" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit"
                     url="<%=editURL.toString() %>" />

</liferay-ui:icon-menu>
