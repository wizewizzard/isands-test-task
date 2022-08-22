<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.wz.testtask.estore.model.*" %>
<%@include file="../init.jsp" %>

<% Date today = new Date();

    long deviceId = ParamUtil.getLong(request, "deviceId");
    Device device = null;
    if (deviceId > 0) {
        try {
            device = DeviceLocalServiceUtil.getDevice(deviceId);
        } catch (PortalException ignored) {
        }
    }
%>

<portlet:renderURL var="viewURL">

    <portlet:param name="mvcPath" value="/device/view.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="<%= device == null ? "addDevice" : "updateDevice"%>" var="editDeviceURL"></portlet:actionURL>


<aui:form action="<%= editDeviceURL %>" name="<portlet:namespace />fm" method="post">

    <aui:fieldset>
        <aui:input name="deviceId" type="hidden" value='<%= device == null ? "" : device.getDeviceId() %>'/>

        <aui:input label="Device name" name="name"  value='<%= device == null ? "" : device.getName() %>'/>

        <aui:input label="Price" name="price" min="0" value='<%= device == null ? "" : device.getPrice() %>'/>

        <aui:select label="Device type" name="deviceTypeId"
                    value='<%= device == null ? "" : device.getDeviceTypeId() %>'>
            <c:forEach items="<%=DeviceTypeLocalServiceUtil.getDeviceTypes(themeDisplay.getScopeGroupId())%>" var="deviceType">
                <aui:option value="${deviceType.getDeviceTypeId()}">${deviceType.getName()}</aui:option>
            </c:forEach>
        </aui:select>

        <aui:input label="Count in stock" type="text" min="0" name="count" value='<%= device == null ? "" : device.getCount() %>'/>

        <aui:input label="Archive" type="checkbox" name="archive" value='<%=device != null && device.getArchive() %>'/>

        <aui:input label="Description" type="textarea" name="description"
                   value='<%= device == null ? "" : device.getDescription() %>'/>

    </aui:fieldset>
    <aui:button-row>

        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

    </aui:button-row>
</aui:form>