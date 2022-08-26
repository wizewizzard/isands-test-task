<%@ page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.wz.testtask.estore.purchase.comparator.PurchaseDateComparator" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p>
    <b><liferay-ui:message key="purchase.caption"/></b>
</p>

<aui:button-row cssClass="crud-buttons">

    <portlet:renderURL var="editPurchaseURL">
        <portlet:param name="mvcPath" value="/edit.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%=editPurchaseURL.toString()%>" value="Make purchase"></aui:button>

</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-data.caption"
                             total="<%=PurchaseLocalServiceUtil.getPurchasesCount(themeDisplay.getScopeGroupId())%>">
    <liferay-ui:search-container-results>
        <%

            String sortByType = ParamUtil.getString(request, "orderByType");
            boolean desc = true;
            if(sortByType != null)
                desc = sortByType.equals("desc");

            List<Purchase> purchases = PurchaseLocalServiceUtil.getPurchases(scopeGroupId,
                    searchContainer.getStart(),
                    searchContainer.getEnd(),
                    OrderByComparatorFactoryUtil.create("ESTORE_Purchase", "purchasedDate", !desc)
            );

            pageContext.setAttribute("results", purchases);
            pageContext.setAttribute("total", purchases.size());
        %>
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row
            className="com.wz.testtask.estore.model.Purchase" modelVar="purchase">

        <%
            Employee employee = null;
            try {
                employee = EmployeeLocalServiceUtil.getEmployee(purchase.getEmployeeId());
            } catch (Exception ignored) {

            }
            String employeeName = employee == null ? "Unknown" : employee.getLastName() + " " + employee.getFirstName();
        %>

        <%
            Device device = null;
            try {
                device = DeviceLocalServiceUtil.getDevice(purchase.getDeviceId());
            } catch (Exception ignored) {

            }
            String deviceName = device == null ? "Unknown" : device.getName();
        %>

        <%
            PurchaseType purchaseType = null;
            try {
                purchaseType = PurchaseTypeLocalServiceUtil.getPurchaseType(purchase.getPurchaseTypeId());
            } catch (Exception ignored) {

            }
            String purchaseTypeName = purchaseType == null ? "Unknown" : purchaseType.getName();
        %>

        <%
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        %>

        <liferay-ui:search-container-column-text
                name="date"
                orderable="true"
                value="<%= sdf.format(purchase.getPurchasedDate()) %>"
        />

        <liferay-ui:search-container-column-text
                name="Name"
                value="<%=employeeName%>"
        />

        <liferay-ui:search-container-column-text
                name="Device"
                value="<%=deviceName%>"
        />

        <liferay-ui:search-container-column-text
                name="Purchase type"
                value="<%=purchaseTypeName%>"
        />

        <liferay-ui:search-container-column-text
                name="Count"
                value="<%=String.valueOf(purchase.getCount())%>"
        />

        <liferay-ui:search-container-column-text
                name="Sum"
                value="<%=String.valueOf(purchase.getCount() * device.getPrice())%>"
        />

        <liferay-ui:search-container-column-jsp
                name="Manage"
                path="/actions.jsp"/>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>

</liferay-ui:search-container>