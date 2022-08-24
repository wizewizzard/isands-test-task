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

package com.wz.testtask.estore.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.wz.testtask.estore.service.http.PurchaseServiceSoap}.
 *
 * @author wz
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PurchaseSoap implements Serializable {

	public static PurchaseSoap toSoapModel(Purchase model) {
		PurchaseSoap soapModel = new PurchaseSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setPurchaseId(model.getPurchaseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setDeviceId(model.getDeviceId());
		soapModel.setPurchasedDate(model.getPurchasedDate());
		soapModel.setCount(model.getCount());
		soapModel.setPurchaseTypeId(model.getPurchaseTypeId());

		return soapModel;
	}

	public static PurchaseSoap[] toSoapModels(Purchase[] models) {
		PurchaseSoap[] soapModels = new PurchaseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PurchaseSoap[][] toSoapModels(Purchase[][] models) {
		PurchaseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PurchaseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PurchaseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PurchaseSoap[] toSoapModels(List<Purchase> models) {
		List<PurchaseSoap> soapModels = new ArrayList<PurchaseSoap>(
			models.size());

		for (Purchase model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PurchaseSoap[soapModels.size()]);
	}

	public PurchaseSoap() {
	}

	public long getPrimaryKey() {
		return _purchaseId;
	}

	public void setPrimaryKey(long pk) {
		setPurchaseId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPurchaseId() {
		return _purchaseId;
	}

	public void setPurchaseId(long purchaseId) {
		_purchaseId = purchaseId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getDeviceId() {
		return _deviceId;
	}

	public void setDeviceId(long deviceId) {
		_deviceId = deviceId;
	}

	public Date getPurchasedDate() {
		return _purchasedDate;
	}

	public void setPurchasedDate(Date purchasedDate) {
		_purchasedDate = purchasedDate;
	}

	public int getCount() {
		return _count;
	}

	public void setCount(int count) {
		_count = count;
	}

	public long getPurchaseTypeId() {
		return _purchaseTypeId;
	}

	public void setPurchaseTypeId(long purchaseTypeId) {
		_purchaseTypeId = purchaseTypeId;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _purchaseId;
	private long _groupId;
	private long _companyId;
	private long _employeeId;
	private long _deviceId;
	private Date _purchasedDate;
	private int _count;
	private long _purchaseTypeId;

}