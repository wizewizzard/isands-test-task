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
import com.wz.testtask.estore.exception.EmptyFieldException;
import com.wz.testtask.estore.exception.IllegalReferenceException;
import com.wz.testtask.estore.exception.NoSuchPurchaseTypeException;
import com.wz.testtask.estore.model.EmployeePosition;
import com.wz.testtask.estore.service.base.EmployeePositionLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author wz
 */
@Component(
        property = "model.class.name=com.wz.testtask.estore.model.EmployeePosition",
        service = AopService.class
)
public class EmployeePositionLocalServiceImpl
        extends EmployeePositionLocalServiceBaseImpl {
    public EmployeePosition addEmployeePosition(String name, ServiceContext serviceContext) throws PortalException {
        long positionId = counterLocalService.increment();
        EmployeePosition employeePosition = employeePositionLocalService.createEmployeePosition(positionId);
        employeePosition.setGroupId(serviceContext.getScopeGroupId());
        employeePosition.setName(name);
        employeePosition.setCompanyId(serviceContext.getCompanyId());
        employeePosition.setUuid(serviceContext.getUuid());
        validate(employeePosition);
        return employeePositionPersistence.update(employeePosition);
    }
    
    public EmployeePosition updateEmployeePosition(long positionId,
                                                   String name,
                                                   ServiceContext serviceContext) throws PortalException {
        EmployeePosition employeePosition = employeePositionPersistence.findByPrimaryKey(positionId);
        employeePosition.setName(name);
        validate(employeePosition);
        return employeePositionPersistence.update(employeePosition);
    }
    
    public EmployeePosition deleteById(long positionId) throws PortalException {
        return delete(employeePositionPersistence.findByPrimaryKey(positionId));
    }
    
    public EmployeePosition delete(EmployeePosition employeePosition) throws PortalException {
        return employeePositionPersistence.remove(employeePosition);
    }
    
    public List<EmployeePosition> getEmployeePositions(long groupId) {
        
        return employeePositionPersistence.findByGroupId(groupId);
    }
    
    public List<EmployeePosition> getEmployeePositions(long groupId, int start, int end,
                                                       OrderByComparator<EmployeePosition> obc) {
        
        return employeePositionPersistence.findByGroupId(groupId, start, end, obc);
    }
    
    public List<EmployeePosition> getEmployeePositions(long groupId, int start, int end) {
        
        return employeePositionPersistence.findByGroupId(groupId, start, end);
    }
    
    public int getEmployeePositionsCount(long groupId) {
        
        return employeePositionPersistence.countByGroupId(groupId);
    }
    
    public EmployeePosition getEmployeePositionByName(long groupId, String name) throws NoSuchPurchaseTypeException {
        
        return employeePositionPersistence.fetchByGroupIdName(groupId, name);
    }
    
    protected void validate(EmployeePosition employeePosition)
            throws PortalException {
        if (Validator.isNull(employeePosition)) {
            throw new IllegalReferenceException();
        }
        
        if (Validator.isNull(employeePosition.getName()) || Validator.isBlank(employeePosition.getName())) {
            throw new EmptyFieldException();
        }
    }
}