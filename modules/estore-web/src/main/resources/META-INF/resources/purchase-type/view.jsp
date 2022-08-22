<%@ include file="../init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p>
    <b><liferay-ui:message key="purchase.type.caption"/></b>
</p>

<aui:button-row cssClass="crud-buttons">

    <portlet:renderURL var="addPurchaseTypeURL">
        <portlet:param name="mvcPath" value="/purchase-type/edit.jsp" />
    </portlet:renderURL>

    <aui:button onClick="<%=addPurchaseTypeURL.toString()%>" value="Add purchase type"></aui:button>

</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-data.caption"
        total="<%=PurchaseTypeLocalServiceUtil.getPurchaseTypesCount(themeDisplay.getScopeGroupId())%>">
    <liferay-ui:search-container-results
            results="<%=PurchaseTypeLocalServiceUtil.getPurchaseTypes(scopeGroupId,
                    searchContainer.getStart(),
                    searchContainer.getEnd())%>" />

    <liferay-ui:search-container-row
            className="com.wz.testtask.estore.model.PurchaseType" modelVar="purchaseType">

        <liferay-ui:search-container-column-text
                name="Name"
                value="<%=purchaseType.getName()%>"
        />

        <liferay-ui:search-container-column-jsp
                name="Manage"
                path="/purchase-type/actions.jsp" />
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>