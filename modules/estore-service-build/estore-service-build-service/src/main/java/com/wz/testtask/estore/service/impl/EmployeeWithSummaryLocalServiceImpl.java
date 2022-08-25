/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.wz.testtask.estore.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.wz.testtask.estore.model.EmployeeWithSummary;
import com.wz.testtask.estore.service.base.EmployeeWithSummaryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author wz
 */
@Component(
        property = "model.class.name=com.wz.testtask.estore.model.EmployeeWithSummary",
        service = AopService.class
)
public class EmployeeWithSummaryLocalServiceImpl
        extends EmployeeWithSummaryLocalServiceBaseImpl {
    private static final Log logger = LogFactoryUtil.getLog(EmployeeWithSummaryLocalServiceImpl.class);
    
    public List<EmployeeWithSummary> findBestEmployees(String criteria, long groupId, long positionId, int begin, int end) throws PortalException {
        return employeeWithSummaryFinder.findBestEmployeesByDevicesSoldSummary(groupId, positionId, begin, end);
    }
    
    public List<EmployeeWithSummary> findBestDeviceTypeSellers(long groupId, long deviceTypeId, Date from, Date until, int begin, int end) throws PortalException {
        logger.debug(String.format("Called service to find best employees with params: %d, %d, %s, %s, %d, %d",
                groupId, deviceTypeId, from, until, begin, end));
        return employeeWithSummaryFinder.findBestDeviceSellersDuringPeriod(groupId, deviceTypeId, from, until, begin, end);
    }
}