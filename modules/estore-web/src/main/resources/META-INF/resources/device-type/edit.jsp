<%@include file="../init.jsp" %>

<%
    long deviceTypeId = ParamUtil.getLong(request, "deviceTypeId");
    DeviceType deviceType = null;
    if(deviceTypeId > 0){
        try{
            deviceType = DeviceTypeLocalServiceUtil.getDeviceType(deviceTypeId);
        }
        catch (Exception ignored){
        }
    }

%>

<portlet:renderURL var="viewURL">

    <portlet:param name="mvcPath" value="/device-type/view.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="<%= deviceType == null ? "addDeviceType" : "updateDeviceType"%>" var="editDeviceTypeURL" />

<aui:form action="<%= editDeviceTypeURL %>" name="<portlet:namespace />fm">
    <h3><%= deviceType == null ? "Create device type" : "Edit device type"%></h3>
    <aui:input name="deviceTypeId"
               type="hidden"
               value='<%= deviceType == null ? "" : deviceType.getDeviceTypeId() %>'/>

    <aui:fieldset>
        <aui:input
                name="name"
                value='<%= deviceType == null ? "" : deviceType.getName() %>'
        />
    </aui:fieldset>

    <aui:button-row>

        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

    </aui:button-row>
</aui:form>