<%@ include file="/init.jsp" %>

<p>
    <b><liferay-ui:message key="statistics.caption"/></b>
</p>

<%
    long paidWithCreditCard = 0;
    long costOfArchivedTvAndSmartphones = 0;
    try {
        paidWithCreditCard = StatisticsHolderLocalServiceUtil
                .getAmountOfMoneyPaidWithCard(themeDisplay.getScopeGroupId()).getResult();
    } catch (PortalException ignored) {
        SessionErrors.add(request, "card-error");
    }

    try {
        costOfArchivedTvAndSmartphones = StatisticsHolderLocalServiceUtil
                .getCostOfArchivedTvAndSmartphones(themeDisplay.getScopeGroupId()).getResult();
    } catch (PortalException ignored) {
        SessionErrors.add(request, "archived-error");
    }
%>

<liferay-ui:error key="card-error" message="failure.card-error"/>
<liferay-ui:error key="archived-error" message="failure.archived-error"/>
<h4>Paid with credit card: <%= paidWithCreditCard%></h4>
<h4>Cost of archived TVs and smartphones: <%= costOfArchivedTvAndSmartphones%></h4>