package com.wz.testtask.estore.service.persistence.impl;


import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.wz.testtask.estore.model.EmployeeWithSummary;
import com.wz.testtask.estore.model.impl.EmployeeWithSummaryImpl;
import com.wz.testtask.estore.service.persistence.EmployeeWithSummaryFinder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component(service = EmployeeWithSummaryFinder.class)
public class EmployeeWithSummaryFinderImpl extends EmployeeWithSummaryFinderBaseImpl
        implements EmployeeWithSummaryFinder {
    
    public static final String FIND_BEST_EMPLOYEE_BY_DEVICES_SOLD_SUMMARY =
            EmployeeWithSummaryFinder.class.getName() +
                    ".findBestEmployeesByDevicesSoldSummary";
    
    public static final String FIND_BEST_EMPLOYEE_BY_DEVICES_SOLD_COUNT =
            EmployeeWithSummaryFinder.class.getName() +
                    ".findBestEmployeesByDevicesSoldCount";
    
    public static final String FIND_BEST_SELLERS_OF_DEVICE_FOR_PERIOD =
            EmployeeWithSummaryFinder.class.getName() +
                    ".findBestEmployeesByDevicesSoldCountInPeriod";
    
    private static final Log logger = LogFactoryUtil.getLog(EmployeeWithSummaryFinderImpl.class);
    
    @Reference(unbind = "-")
    private CustomSQL _customSQL;
    
    protected EmployeeWithSummary mapRow(Object[] row){
        long employeeId = (long) row[0];
        String employeeFullName = (String) row[1];
        int count = (int) row[2];
        long amount = (long) row[3];
        EmployeeWithSummaryImpl employeeWithSummary = new EmployeeWithSummaryImpl();
        employeeWithSummary.setEmployeeId(employeeId);
        employeeWithSummary.setEmployeeFullName(employeeFullName);
        employeeWithSummary.setDeviceCount(count);
        employeeWithSummary.setSoldDevicesOn(amount);
        return employeeWithSummary;
    }
    
    public List<EmployeeWithSummary> findBestEmployeesByDevicesSoldSummary(long groupId, long positionId,
                                                                           int begin, int end) throws PortalException {
        logger.info(String.format("Querying best employees based on sum of money of sold devices. " +
                        "Params grId: %d, posId %d, beg: %d, end: %d",
                groupId, positionId, begin, end));
        Session session = null;
        try {
            session = openSession();
    
            String sql = _customSQL.get(
                    getClass(),
                    FIND_BEST_EMPLOYEE_BY_DEVICES_SOLD_SUMMARY);
    
            SQLQuery q = session.createSQLQuery(sql);
            q.addScalar("employeeId", Type.LONG);
            q.addScalar("employeefullname", Type.STRING);
            q.addScalar("solddevicescount", Type.INTEGER);
            q.addScalar("solddeviceson", Type.LONG);
    
            QueryPos qPos = QueryPos.getInstance(q);
            qPos.add(groupId);
            qPos.add(positionId);
    
            List<Object[]> list = (List<Object[]>) QueryUtil.list(q, getDialect(), begin, end);
            List<EmployeeWithSummary> results = new ArrayList<>();
            for (Object[] row : list) {
                logger.info(String.format("Rows are: %s, %s, %s, %s", row[0], row[1], row[2], row[3]));
                results.add(mapRow(row));
            }
            return results;
        } catch (Exception e) {
            logger.error("Exception fired when querying best employees by sum", e);
            throw new PortalException("Error performing database query", e);
        } finally {
            closeSession(session);
        }
    }
    
    public List<EmployeeWithSummary> findBestEmployeesByDevicesSoldCount(long groupId, long positionId,
                                                                           int begin, int end) throws PortalException {
        logger.info(String.format("Querying best employees  based on count of sold devices. Params grId: %d, posId %d, beg: %d, end: %d",
                groupId, positionId, begin, end));
        Session session = null;
        try {
            session = openSession();
            
            String sql = _customSQL.get(
                    getClass(),
                    FIND_BEST_EMPLOYEE_BY_DEVICES_SOLD_COUNT);
            
            SQLQuery q = session.createSQLQuery(sql);
            q.addScalar("employeeId", Type.LONG);
            q.addScalar("employeefullname", Type.STRING);
            q.addScalar("solddevicescount", Type.INTEGER);
            q.addScalar("solddeviceson", Type.LONG);
            
            QueryPos qPos = QueryPos.getInstance(q);
            qPos.add(groupId);
            qPos.add(positionId);
            
            List<Object[]> list = (List<Object[]>)QueryUtil.list(q, getDialect(), begin, end);
            List<EmployeeWithSummary> results = new ArrayList<>();
            for (Object[] row : list) {
                logger.info(String.format("Rows are: %s, %s, %s, %s", row[0], row[1], row[2], row[3]));
                results.add(mapRow(row));
            }
            return results;
        } catch (Exception e) {
            logger.error("Exception fired when querying best employees by count of devices", e);
            throw new PortalException("Error performing database query", e);
        } finally {
            closeSession(session);
        }
    }
    
    public List<EmployeeWithSummary> findBestDeviceSellersDuringPeriod(long groupId,
                                                                         long deviceTypeId,
                                                                         Date from, Date until,
                                                                         int begin, int end) throws PortalException {
        logger.info(String.format("Querying best employees based on count of sold devices of specific type for a period" +
                        ". Params grId: %d, beg: %d, end: %d",
                groupId, begin, end));
        Session session = null;
        try {
            session = openSession();
            
            String sql = _customSQL.get(
                    getClass(),
                    FIND_BEST_SELLERS_OF_DEVICE_FOR_PERIOD);
            
            SQLQuery q = session.createSQLQuery(sql);
            q.addScalar("employeeId", Type.LONG);
            q.addScalar("employeefullname", Type.STRING);
            q.addScalar("solddevicescount", Type.INTEGER);
            q.addScalar("solddeviceson", Type.LONG);
            
            QueryPos qPos = QueryPos.getInstance(q);
            qPos.add(groupId);
            qPos.add(deviceTypeId);
            qPos.add(from);
            qPos.add(until);
            
            List<Object[]> list = (List<Object[]>)QueryUtil.list(q, getDialect(), begin, end);
            List<EmployeeWithSummary> results = new ArrayList<>();
            for (Object[] row : list) {
                logger.info(String.format("Rows are: %s, %s, %s, %s", row[0], row[1], row[2], row[3]));
                results.add(mapRow(row));
            }
            return results;
        } catch (Exception e) {
            logger.error("Exception fired when querying best employees by count of devices in period", e);
            throw new PortalException("Error performing database query", e);
        } finally {
            closeSession(session);
        }
    }
}
