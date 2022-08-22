/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.wz.testtask.estore.service.impl;

import com.liferay.portal.aop.AopService;

import com.wz.testtask.estore.model.Purchase;
import com.wz.testtask.estore.service.base.PurchaseLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author wz
 */
@Component(
	property = "model.class.name=com.wz.testtask.estore.model.Purchase",
	service = AopService.class
)
public class PurchaseLocalServiceImpl extends PurchaseLocalServiceBaseImpl {
	
	public List<Purchase> getPurchasesForEmployee(long groupId, long employeeId){
		return purchasePersistence.findByGroupIdEmployeeId(groupId, employeeId);
	}
	
	public int getPurchasesForEmployeeCount(long groupId, long employeeId){
		return purchasePersistence.countByGroupIdEmployeeId(groupId, employeeId);
	}
	
	public List<Purchase> getPurchasesOfDevice(long groupId, long deviceId){
		return purchasePersistence.findByGroupIdDeviceId(groupId, deviceId);
	}
	
	public int getPurchasesOfDeviceCount(long groupId, long deviceId){
		return purchasePersistence.countByGroupIdDeviceId(groupId, deviceId);
	}
}