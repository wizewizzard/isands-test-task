
<%@ include file="../init.jsp" %>
<%
	DeviceType tv = null;
	try{
		tv = DeviceTypeLocalServiceUtil.getDeviceTypeByName(themeDisplay.getScopeGroupId(), "TV");
	}
	catch (Exception ignored){

	}
	Calendar calendar = GregorianCalendar.getInstance();
	Date until = new Date();
	Calendar c = Calendar.getInstance();
	c.setTime(until);
	c.add(Calendar.MONTH, -3);
	Date from = c.getTime();
%>
<p>
	<b><liferay-ui:message key="besttvsellers.caption"/></b>
</p>

<liferay-ui:search-container emptyResultsMessage="no-data.caption">
	<liferay-ui:search-container-results
			results="<%= tv != null ? EmployeeWithSummaryLocalServiceUtil.findBestDeviceTypeSellers(
					scopeGroupId, tv.getDeviceTypeId(),
					from, until,
                    searchContainer.getStart(),
                    searchContainer.getEnd())
                    : null%>"/>

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
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator/>

</liferay-ui:search-container>



