<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@include file="../init.jsp"%>

<%
    ResultRow row = (ResultRow) request
            .getAttribute("SEARCH_CONTAINER_RESULT_ROW");

    PurchaseType purchaseType = (PurchaseType) row.getObject();
%>

<liferay-ui:icon-menu>

    <portlet:renderURL var="editURL">
        <portlet:param name="purchaseTypeId"
                       value="<%=String.valueOf(purchaseType.getPurchaseTypeId()) %>" />
        <portlet:param name="mvcPath"
                       value="/purchase-type/edit.jsp" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit"
                     url="<%=editURL.toString() %>" />

</liferay-ui:icon-menu>
