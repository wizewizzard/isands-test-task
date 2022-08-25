<%@ include file="../init.jsp" %>
<%
	List<EmployeePosition> employeePositions = EmployeePositionLocalServiceUtil.getEmployeePositions(themeDisplay.getScopeGroupId());
%>
<p>
	<b><liferay-ui:message key="bestemployee.caption"/></b>
</p>

<portlet:actionURL name="getBestEmployees" var="getBestEmployeesURL"/>

<%
	String criteria = ParamUtil.getString(request, "criteria");
	long positionId = ParamUtil.getLong(request, "positionId");
%>

<aui:form action="<%= getBestEmployeesURL %>" name="<portlet:namespace />fm" method="post">

	<aui:select name="criteria">
		<aui:option value="sum">Amount of money</aui:option>
		<aui:option value="count">Count of devices</aui:option>
	</aui:select>

	<aui:select name="positionId">
		<c:forEach items="<%=employeePositions%>" var="position">
			<aui:option value="${position.positionId}">${position.name}</aui:option>
		</c:forEach>
	</aui:select>

	<aui:button-row cssClass="crud-buttons">
		<aui:button type="submit" value="Get employees"></aui:button>
	</aui:button-row>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-data.caption"
							 total="<%=EmployeeLocalServiceUtil.getEmployeesCount(scopeGroupId)%>">
	<liferay-ui:search-container-results
			results="<%=EmployeeWithSummaryLocalServiceUtil.findBestEmployees(criteria, scopeGroupId, positionId,
                    searchContainer.getStart(),
                    searchContainer.getEnd())%>"/>

	<liferay-ui:search-container-row
			className="com.wz.testtask.estore.model.EmployeeWithSummaryModel" modelVar="employee">
		<liferay-ui:search-container-column-text
				name="Name"
				value="<%=employee.getEmployeeFullName()%>"
		/>

		<liferay-ui:search-container-column-text
				name="Devices count"
				value="<%=String.valueOf(employee.getDeviceCount())%>"
		/>

		<liferay-ui:search-container-column-text
				name="Sold devices on"
				value="<%=String.valueOf(employee.getSoldDevicesOn())%>"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator/>

</liferay-ui:search-container>



