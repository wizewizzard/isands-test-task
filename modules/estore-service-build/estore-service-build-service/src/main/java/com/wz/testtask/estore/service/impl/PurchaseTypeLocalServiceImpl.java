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
import com.wz.testtask.estore.model.PurchaseType;
import com.wz.testtask.estore.service.base.PurchaseTypeLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author wz
 */
@Component(
        property = "model.class.name=com.wz.testtask.estore.model.PurchaseType",
        service = AopService.class
)
public class PurchaseTypeLocalServiceImpl
        extends PurchaseTypeLocalServiceBaseImpl {
    
    public PurchaseType addPurchaseType(String name, ServiceContext serviceContext) throws PortalException {
        long purchaseTypeId = counterLocalService.increment();
        PurchaseType purchaseType = purchaseTypeLocalService.createPurchaseType(purchaseTypeId);
        purchaseType.setGroupId(serviceContext.getScopeGroupId());
        purchaseType.setName(name);
        purchaseType.setCompanyId(serviceContext.getCompanyId());
        purchaseType.setUuid(serviceContext.getUuid());
        validate(purchaseType);
        return purchaseTypePersistence.update(purchaseType);
    }
    
    public PurchaseType updatePurchaseType(long purchaseTypeId,
                                           String name,
                                           ServiceContext serviceContext) throws PortalException {
        PurchaseType purchaseType = purchaseTypePersistence.findByPrimaryKey(purchaseTypeId);
        purchaseType.setName(name);
        validate(purchaseType);
        return purchaseTypePersistence.update(purchaseType);
    }
    
    public PurchaseType deleteById(long purchaseTypeId) throws PortalException {
        return delete(purchaseTypePersistence.findByPrimaryKey(purchaseTypeId));
    }
    
    public PurchaseType delete(PurchaseType purchaseType) throws PortalException {
        return purchaseTypePersistence.remove(purchaseType);
    }
    
    public List<PurchaseType> getPurchaseTypes(long groupId) {
        
        return purchaseTypePersistence.findByGroupId(groupId);
    }
    
    public List<PurchaseType> getPurchaseTypes(long groupId, int start, int end,
                                               OrderByComparator<PurchaseType> obc) {
        
        return purchaseTypePersistence.findByGroupId(groupId, start, end, obc);
    }
    
    public List<PurchaseType> getPurchaseTypes(long groupId, int start, int end) {
        
        return purchaseTypePersistence.findByGroupId(groupId, start, end);
    }
    
    public int getPurchaseTypesCount(long groupId) {
        
        return purchaseTypePersistence.countByGroupId(groupId);
    }
    
    protected void validate(PurchaseType purchaseType)
            throws PortalException {
        if (Validator.isNull(purchaseType)) {
            throw new IllegalReferenceException();
        }
        
        if (Validator.isNull(purchaseType.getName()) || Validator.isBlank(purchaseType.getName())) {
            throw new EmptyFieldException("Purchase type name can not be empty");
        }
    }
}