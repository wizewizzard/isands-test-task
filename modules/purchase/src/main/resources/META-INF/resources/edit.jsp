<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    long purchaseTypeId = ParamUtil.getLong(request, "purchaseId");
    Purchase purchase = null;
    if (purchaseTypeId > 0) {
        try {
            purchase = PurchaseLocalServiceUtil.getPurchase(purchaseTypeId);
        } catch (Exception ignored) {
        }
    }

    List<Employee> employees = EmployeeLocalServiceUtil.getEmployees(themeDisplay.getScopeGroupId());
    List<Device> devices = DeviceLocalServiceUtil.getDevices(themeDisplay.getScopeGroupId());
    List<PurchaseType> purchaseTypes = PurchaseTypeLocalServiceUtil.getPurchaseTypes(themeDisplay.getScopeGroupId());

%>

<portlet:renderURL var="viewURL">

    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="<%= purchase == null ? "makePurchase" : "updatePurchase"%>" var="makePurchaseURL"/>

<aui:form action="<%= makePurchaseURL %>" name="<portlet:namespace />fm" method="post">
    <h3><%= "Making purchase" %>
    </h3>
    <liferay-ui:error key="employee-not-responsible" message="purchase.failure.employee-not-responsible"/>
    <liferay-ui:error key="device-is-archived" message="purchase.failure.device-is-archived"/>
    <liferay-ui:error key="wrong-amount" message="purchase.failure.wrong-amount"/>
    <liferay-ui:error key="no-such-device" message="purchase.failure.no-such-device"/>
    <liferay-ui:error key="not-enough-devices-in-stock" message="purchase.failure.not-enough-devices-in-stock"/>
    <liferay-ui:error key="no-such-purchase-type" message="purchase.failure.no-such-purchase-type"/>
    <liferay-ui:error key="portal-error" message="purchase.failure.portal-error"/>
    <aui:fieldset>

        <aui:input name="purchaseId" type="hidden" value='<%= purchase == null ? "" : purchase.getPurchaseId() %>'/>


        <aui:select name="employeeId"
                    value='<%= purchase == null ? "" : purchase.getEmployeeId() %>'
        >
            <c:forEach items="<%=employees%>" var="employee">
                <aui:option
                        value="${employee.employeeId}">${employee.firstName.concat(" ").concat(employee.firstName) }</aui:option>
            </c:forEach>
        </aui:select>

        <aui:select name="deviceId"
                    value='<%= purchase == null ? "" : purchase.getDeviceId() %>'
        >
            <c:forEach items="<%=devices%>" var="device">
                <aui:option value="${device.deviceId}">${device.name}</aui:option>
            </c:forEach>
        </aui:select>

        <aui:select name="purchaseTypeId"
                    value='<%= purchase == null ? "" : purchase.getPurchaseTypeId() %>'
        >
            <c:forEach items="<%=purchaseTypes%>" var="purchaseType">
                <aui:option value="${purchaseType.purchaseTypeId}">${purchaseType.name}</aui:option>
            </c:forEach>
        </aui:select>

        <aui:input name="count" value='<%= purchase == null ? "1" : purchase.getCount() %>'>
            <aui:validator name="min">1</aui:validator>
        </aui:input>

    </aui:fieldset>


    <aui:button-row>

        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

    </aui:button-row>
</aui:form>