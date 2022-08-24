<%@ page import="java.util.Date" %>
<%@include file="../init.jsp" %>

<%
    Date today = new Date();

    long employeeId = ParamUtil.getLong(request, "employeeId");
    int startDay, startMonth, startYear;
    Employee employee = null;
    List<DeviceType> employeeConsultingDeviceTypes = null;
    ;
    if (employeeId > 0) {
        employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
        startDay = employee.getBirthDate().getDate();
        startMonth = employee.getBirthDate().getMonth();
        startYear = employee.getBirthDate().getYear() + 1900;
        employeeConsultingDeviceTypes = DeviceTypeLocalServiceUtil.getEmployeeDeviceTypes(employeeId);
    } else {
        startDay = today.getDate();
        startMonth = today.getMonth();
        startYear = today.getYear() + 1900 - 18;
    }
%>

<portlet:renderURL var="viewURL">

    <portlet:param name="mvcPath" value="/employee/view.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="<%= employee == null ? "addEmployee" : "updateEmployee"%>"
                   var="editEmployeeURL"></portlet:actionURL>


<aui:form action="<%= editEmployeeURL %>" name="<portlet:namespace />fm" method="post">
    <h3><%= employee == null ? "Add new employee" : "Edit existing employee"%>
    </h3>
    <aui:fieldset>
        <aui:input name="employeeId" type="hidden" value='<%= employee == null ? "" : employee.getEmployeeId() %>'/>

        <aui:input name="firstName" value='<%= employee == null ? "" : employee.getFirstName() %>'/>

        <aui:input name="lastName" value='<%= employee == null ? "" : employee.getLastName() %>'/>

        <aui:input name="patronymic" value='<%= employee == null ? "" : employee.getPatronymic() %>'/>

        <liferay-ui:input-date name="birthDate"
                               dayParam="dayParam"
                               monthParam="monthParam"
                               yearParam="yearParam"
                               lastEnabledDate="<%= today%>"
                               dayValue="<%=startDay%>"
                               monthValue="<%=startMonth%>"
                               yearValue="<%=startYear%>"
        >
        </liferay-ui:input-date>

        <%
            for (DeviceType deviceType : DeviceTypeLocalServiceUtil.getDeviceTypes(themeDisplay.getScopeGroupId())) {
                boolean checked = false;
                if (employeeConsultingDeviceTypes != null)
                    checked = employeeConsultingDeviceTypes.stream().anyMatch(dt -> dt.getDeviceTypeId() == deviceType.getDeviceTypeId());
        %>
        <input type="checkbox" name="<portlet:namespace/>deviceTypes"
               <%= checked ? "checked" : null %>
               value="<%= deviceType.getDeviceTypeId()%>">
        <%= deviceType.getName()%>
        <br>
        <%
            }
        %>

        <aui:select name="gender"
                    value='<%= employee == null ? "" : EmployeeLocalServiceUtil.getGenderById(employee.getGender()) %>'>
            <c:forEach items="<%=EmployeeLocalServiceUtil.getGenderList()%>" var="gender">
                <aui:option value="${gender}">${gender}</aui:option>
            </c:forEach>
        </aui:select>

        <aui:select name="positionId" value='<%= employee == null ? "" : employee.getPositionId() %>'>
            <c:forEach
                    items="<%=EmployeePositionLocalServiceUtil.getEmployeePositions( themeDisplay.getScopeGroupId())%>"
                    var="position">
                <aui:option value="${position.positionId}">${position.name}</aui:option>
            </c:forEach>
        </aui:select>
    </aui:fieldset>
    <aui:button-row>

        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

    </aui:button-row>
</aui:form>