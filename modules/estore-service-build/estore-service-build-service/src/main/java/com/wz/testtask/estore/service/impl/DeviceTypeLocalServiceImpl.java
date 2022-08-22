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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.wz.testtask.estore.exception.ConsistencyViolationException;
import com.wz.testtask.estore.exception.EmptyFieldException;
import com.wz.testtask.estore.exception.IllegalReferenceException;
import com.wz.testtask.estore.model.DeviceType;
import com.wz.testtask.estore.service.EmployeeLocalServiceUtil;
import com.wz.testtask.estore.service.base.DeviceTypeLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author wz
 */
@Component(
        property = "model.class.name=com.wz.testtask.estore.model.DeviceType",
        service = AopService.class
)
public class DeviceTypeLocalServiceImpl extends DeviceTypeLocalServiceBaseImpl {
    public DeviceType addDeviceType(String name, ServiceContext serviceContext) throws PortalException {
        long deviceTypeId = counterLocalService.increment();
        DeviceType deviceType = deviceTypeLocalService.createDeviceType(deviceTypeId);
        deviceType.setGroupId(serviceContext.getScopeGroupId());
        deviceType.setCompanyId(serviceContext.getCompanyId());
        deviceType.setName(name);
        deviceType.setCompanyId(serviceContext.getCompanyId());
        deviceType.setUuid(serviceContext.getUuid());
        validate(deviceType);
        return deviceTypePersistence.update(deviceType);
    }
    
    public DeviceType updateDeviceType(long deviceTypeId,
                                         String name,
                                         ServiceContext serviceContext) throws PortalException {
        DeviceType deviceType = deviceTypePersistence.findByPrimaryKey(deviceTypeId);
        deviceType.setName(name);
        validate(deviceType);
        return deviceTypePersistence.update(deviceType);
    }
    
    public DeviceType deleteById(long purchaseTypeId) throws PortalException {
        return delete(deviceTypePersistence.findByPrimaryKey(purchaseTypeId));
    }
    
    public DeviceType delete(DeviceType deviceType) throws PortalException {
        if (EmployeeLocalServiceUtil.getDeviceTypeEmployeesCount(deviceType.getDeviceTypeId()) == 0)
            return deviceTypePersistence.remove(deviceType);
        else
            throw new ConsistencyViolationException("You are not allowed to remove a category until " +
                    "there are employees in it");
    }
    
    public List<DeviceType> getDeviceTypes(long groupId) {
        return deviceTypePersistence.findByGroupId(groupId);
    }
    
    public List<DeviceType> getDeviceTypes(long groupId, int start, int end,
                                             OrderByComparator<DeviceType> obc) {
        return deviceTypePersistence.findByGroupId(groupId, start, end, obc);
    }
    
    public List<DeviceType> getDeviceTypes(long groupId, int start, int end) {
        return deviceTypePersistence.findByGroupId(groupId, start, end);
    }
    
    public int getDeviceTypesCount(long groupId) {
        return deviceTypePersistence.countByGroupId(groupId);
    }
    
    protected void validate(DeviceType deviceType)
            throws PortalException {
        if (Validator.isNull(deviceType)) {
            throw new IllegalReferenceException();
        }
        
        if (Validator.isNull(deviceType.getName()) || Validator.isBlank(deviceType.getName())) {
            throw new EmptyFieldException("Type name cannot be empty");
        }
    }
}