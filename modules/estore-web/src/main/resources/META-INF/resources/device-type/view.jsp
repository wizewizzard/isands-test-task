<%@ page import="com.wz.testtask.estore.service.DeviceTypeLocalServiceUtil" %>
<%@ include file="../init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p>
    <b><liferay-ui:message key="device.type.caption"/></b>
</p>

<aui:button-row cssClass="crud-buttons">

    <portlet:renderURL var="addDeviceTypeURL">
        <portlet:param name="mvcPath" value="/device-type/edit.jsp" />
    </portlet:renderURL>

    <aui:button onClick="<%=addDeviceTypeURL.toString()%>" value="Add device type"></aui:button>

</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-data.caption"
        total="<%=DeviceTypeLocalServiceUtil.getDeviceTypesCount(themeDisplay.getScopeGroupId())%>">
    <liferay-ui:search-container-results
            results="<%=DeviceTypeLocalServiceUtil.getDeviceTypes(scopeGroupId,
                    searchContainer.getStart(),
                    searchContainer.getEnd())%>" />

    <liferay-ui:search-container-row
            className="com.wz.testtask.estore.model.DeviceType" modelVar="deviceType">

        <liferay-ui:search-container-column-text
                name="Name"
                value="<%=deviceType.getName()%>"
        />

        <liferay-ui:search-container-column-jsp
                name="Manage"
                path="/device-type/actions.jsp" />
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>