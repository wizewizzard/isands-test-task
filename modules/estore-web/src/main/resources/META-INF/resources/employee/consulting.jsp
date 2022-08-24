<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@include file="../init.jsp"%>

<%
    ResultRow row = (ResultRow) request
            .getAttribute("SEARCH_CONTAINER_RESULT_ROW");

    Employee employee = (Employee) row.getObject();
    List<DeviceType> employeeConsultingDeviceTypes = DeviceTypeLocalServiceUtil.getEmployeeDeviceTypes(employee.getEmployeeId());
%>

<%
    for(DeviceType deviceType : employeeConsultingDeviceTypes){
    %>
    <%= deviceType.getName() %> <br>
    <%}%>