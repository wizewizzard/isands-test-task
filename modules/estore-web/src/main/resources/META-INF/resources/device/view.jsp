<%@ page import="com.wz.testtask.estore.service.*" %>
<%@ include file="../init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p>
    <b><liferay-ui:message key="device.caption"/></b>
</p>
<liferay-ui:error key="consistency-violation" message="failure.consistency-violation"/>

<aui:button-row cssClass="crud-buttons">

    <portlet:renderURL var="addDeviceURL">
        <portlet:param name="mvcPath" value="/device/edit.jsp" />
    </portlet:renderURL>

    <aui:button onClick="<%=addDeviceURL.toString()%>" value="Add device"></aui:button>

</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-data.caption"
                             total="<%=DeviceLocalServiceUtil.getDevicesCount(themeDisplay.getScopeGroupId())%>">
    <liferay-ui:search-container-results
            results="<%=DeviceLocalServiceUtil.getDevices(scopeGroupId,
                    searchContainer.getStart(),
                    searchContainer.getEnd())%>" />

    <liferay-ui:search-container-row
            className="com.wz.testtask.estore.model.Device" modelVar="device">
        <%
            String deviceTypeName = "UNKNOWN";
            try {
                deviceTypeName = DeviceTypeLocalServiceUtil.getDeviceType(device.getDeviceTypeId()).getName();
            } catch (Exception e) {
            }
        %>
        <liferay-ui:search-container-column-text
                name="Name"
                value="<%=device.getName()%>"
        />
        <liferay-ui:search-container-column-text
                name="Price"
        >
        ${device.getPrice()}
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text
                name="Number of devices in stock"
        >${device.getCount()}
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text
                name="Available is stock"
                value="<%=device.getInStock() ? "In stock" : "Out of stock"%>"
        />
        <liferay-ui:search-container-column-text
                name="Device type"
                value="<%=deviceTypeName%>"
        />
        <liferay-ui:search-container-column-text
                name="Archived"
                value="<%=device.getArchive() ? "Atchived" : "Not archived"%>"
        />
        <liferay-ui:search-container-column-text
                name="Description"
                value="<%=device.getDescription()%>"
        />

        <liferay-ui:search-container-column-jsp
                name="Manage"
                path="/device/actions.jsp" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>