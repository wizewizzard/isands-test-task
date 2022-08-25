package com.wz.testtask.estore.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.wz.testtask.estore.model.EmployeeWithSummary;
import com.wz.testtask.estore.model.StatisticsHolder;
import com.wz.testtask.estore.model.impl.StatisticsHolderImpl;
import com.wz.testtask.estore.service.persistence.StatisticsHolderFinder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Component(service = StatisticsHolderFinder.class)
public class StatisticsHolderFinderImpl extends StatisticsHolderFinderBaseImpl
        implements StatisticsHolderFinder {
    
    private static final Log logger = LogFactoryUtil.getLog(EmployeeWithSummaryFinderImpl.class);
    
    public static final String GET_AMOUNT_PAID_WITH_CARD =
            StatisticsHolderFinder.class.getName() +
                    ".getAmountOfMoneyPaidWithCard";
    
    public static final String GET_COST_OF_ARCHIVED_TV_AND_SMARTPHONES =
            StatisticsHolderFinder.class.getName() +
                    ".getCostOfArchivedTvAndSmartphones";
    
    @Reference(unbind = "-")
    private CustomSQL _customSQL;
    
    public StatisticsHolder getAmountOfMoneyPaidWithCard(long groupId) throws PortalException {
        logger.info(String.format("Querying statistics to get sum of money from purchases paid with card %d",
                groupId));
        return performQuery("paidWithCard", groupId);
    }
    
    private StatisticsHolder performQuery(String mode, long groupId) throws PortalException {
        Session session = null;
        try {
            session = openSession();
        
            String sql = _customSQL.get(
                    getClass(),
                    mode.equals("paidWithCard") ? GET_AMOUNT_PAID_WITH_CARD : GET_COST_OF_ARCHIVED_TV_AND_SMARTPHONES);
        
            SQLQuery q = session.createSQLQuery(sql);
            q.addScalar("result", Type.LONG);
        
            QueryPos qPos = QueryPos.getInstance(q);
            qPos.add(groupId);
        
            Object[] result = (Object[]) q.uniqueResult();
            StatisticsHolder statisticsHolder = new StatisticsHolderImpl();
            statisticsHolder.setStatName("payWithCard");
            statisticsHolder.setResult((long)result[0]);
            return statisticsHolder;
        } catch (Exception e) {
            logger.error("Exception fired when querying best employees by count of devices", e);
            throw new PortalException("Error performing database query", e);
        } finally {
            closeSession(session);
        }
    }
    
    public StatisticsHolder getCostOfArchivedTvAndSmartphones(long groupId) throws PortalException {
        logger.info(String.format("Querying statistics to get sum of money of archived smartphones and TVs %d",
                groupId));
        return performQuery("archivedCost", groupId);
    }
}
