<%@ include file="../init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p>
    <b><liferay-ui:message key="employee.position.caption"/></b>
</p>

<aui:button-row cssClass="crud-buttons">

    <portlet:renderURL var="addEmployeePosURL">
        <portlet:param name="mvcPath" value="/employee-pos/edit.jsp" />
    </portlet:renderURL>

    <aui:button onClick="<%=addEmployeePosURL.toString()%>" value="Add employee position"></aui:button>

</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-data.caption"
        total="<%=EmployeePositionLocalServiceUtil.getEmployeePositionsCount(themeDisplay.getScopeGroupId())%>">
    <liferay-ui:search-container-results
            results="<%=EmployeePositionLocalServiceUtil.getEmployeePositions(scopeGroupId,
                    searchContainer.getStart(),
                    searchContainer.getEnd())%>" />

    <liferay-ui:search-container-row
            className="com.wz.testtask.estore.model.EmployeePosition" modelVar="employeePosition">

        <liferay-ui:search-container-column-text
                name="Name"
                value="<%= employeePosition.getName()%>"
        />

        <liferay-ui:search-container-column-jsp
                name="Manage"
                path="/employee-pos/actions.jsp" />
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>