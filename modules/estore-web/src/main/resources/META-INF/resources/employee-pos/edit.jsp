<%@include file="../init.jsp" %>

<%
    long positionId = ParamUtil.getLong(request, "positionId");
    EmployeePosition employeePosition = null;
    if(positionId > 0){
        try{
            employeePosition = EmployeePositionLocalServiceUtil.getEmployeePosition(positionId);
        }
        catch (Exception ignored){
        }
    }

%>

<portlet:renderURL var="viewURL">

    <portlet:param name="mvcPath" value="/employee-pos/view.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="<%= employeePosition == null ? "addPosition" : "updatePosition"%>" var="editPositionURL" />

<aui:form action="<%= editPositionURL %>" name="<portlet:namespace />fm" method="post">
    <h3><%= employeePosition == null ? "Create employee position" : "Edit employee position"%></h3>
    <liferay-ui:error key="empty-name" message="failure.empty-name"/>
    <aui:fieldset>
        <aui:input name="positionId"
                   type="hidden"
                   value='<%= employeePosition == null ? "" : employeePosition.getPositionId() %>'/>

        <aui:input label="Position name"
                   name="name"
                   value='<%= employeePosition == null ? "" : employeePosition.getName() %>'
        >
            <aui:validator name="maxLength">100</aui:validator>
        </aui:input>
    </aui:fieldset>

    <aui:button-row>

        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

    </aui:button-row>
</aui:form>