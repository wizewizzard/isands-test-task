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

<%
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
%>

<portlet:renderURL var="viewURL">

    <portlet:param name="mvcPath" value="/employee/view.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="<%= employee == null ? "addEmployee" : "updateEmployee"%>"
                   var="editEmployeeURL"></portlet:actionURL>


<aui:form action="<%= editEmployeeURL %>" name="<portlet:namespace />fm" method="post">
    <h3><%= employee == null ? "Add new employee" : "Edit existing employee"%></h3>
    <liferay-ui:error key="empty-person-name" message="failure.empty-person-name"/>
    <liferay-ui:error key="required-field-empty" message="failure.required-field-empty"/>
    <liferay-ui:error key="invalid-birth-date" message="failure.invalid-birth-date"/>
    <aui:fieldset>
        <aui:input name="employeeId" type="hidden" value='<%= employee == null ? "" : employee.getEmployeeId() %>'/>

        <aui:input name="firstName" value='<%= employee == null ? "" : employee.getFirstName() %>'>
            <aui:validator name="maxLength">100</aui:validator>
        </aui:input>

        <aui:input name="lastName" value='<%= employee == null ? "" : employee.getLastName() %>'>
            <aui:validator name="maxLength">100</aui:validator>
        </aui:input>

        <aui:input name="patronymic" value='<%= employee == null ? "" : employee.getPatronymic() %>'>
            <aui:validator name="maxLength">100</aui:validator>
        </aui:input>

        <aui:input name="birthDate" label="Birth date" value="<%= employee == null ? sdf.format(new Date()) : sdf.format(employee.getBirthDate()) %>" />

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