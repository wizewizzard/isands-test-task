<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@include file="../init.jsp"%>

<%
    ResultRow row = (ResultRow) request
            .getAttribute("SEARCH_CONTAINER_RESULT_ROW");

    EmployeePosition employeePosition = (EmployeePosition) row.getObject();
%>

<liferay-ui:icon-menu>

    <portlet:renderURL var="editURL">
        <portlet:param name="positionId"
                       value="<%=String.valueOf(employeePosition.getPositionId()) %>" />
        <portlet:param name="mvcPath"
                       value="/employee-pos/edit.jsp" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit"
                     url="<%=editURL.toString() %>" />

</liferay-ui:icon-menu>
