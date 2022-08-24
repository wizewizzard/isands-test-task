<%@ page import="java.util.EnumSet" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="../init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p>
    <b><liferay-ui:message key="employee.caption"/></b>
</p>

<aui:button-row cssClass="crud-buttons">

    <portlet:renderURL var="addEmployeeURL">
        <portlet:param name="mvcPath" value="/employee/edit.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%=addEmployeeURL.toString()%>" value="Add employee"></aui:button>

</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-data.caption"
        total="<%=EmployeeLocalServiceUtil.getEmployeesCount(themeDisplay.getScopeGroupId())%>">
    <liferay-ui:search-container-results
            results="<%=EmployeeLocalServiceUtil.getEmployees(scopeGroupId,
                    searchContainer.getStart(),
                    searchContainer.getEnd())%>"/>

    <liferay-ui:search-container-row
            className="com.wz.testtask.estore.model.Employee" modelVar="employee">
        <%
            String positionName = "UNKNOWN";
            try {
                positionName = EmployeePositionLocalServiceUtil.getEmployeePosition(employee.getPositionId()).getName();
            } catch (Exception e) {
            }
        %>

        <%
            String genderName = EmployeeLocalServiceUtil.getGenderById(employee.getGender());
        %>
        <liferay-ui:search-container-column-text
                name="First name"
                value="<%= employee.getFirstName() %>"
        />
        <liferay-ui:search-container-column-text
                name="Last name"
                value="<%= employee.getLastName() %>"
        />
        <liferay-ui:search-container-column-text
                name="Patronymic"
                value="<%= employee.getPatronymic() %>"
        />

        <liferay-ui:search-container-column-text
                name="Gender"
                value="<%= genderName %>"
        />

        <%
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        %>

        <liferay-ui:search-container-column-text
                name="date"
                value="<%= sdf.format(employee.getBirthDate()) %>"
        />

        <liferay-ui:search-container-column-text
                name="Position"
                value="<%= positionName %>" />

        <liferay-ui:search-container-column-jsp
                name="Consults about"
                path="/employee/consulting.jsp" />

        <liferay-ui:search-container-column-jsp
                name="Manage"
                path="/employee/actions.jsp" />
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>

</liferay-ui:search-container>