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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.wz.testtask.estore.service.http.PurchaseTypeServiceSoap}.
 *
 * @author wz
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PurchaseTypeSoap implements Serializable {

	public static PurchaseTypeSoap toSoapModel(PurchaseType model) {
		PurchaseTypeSoap soapModel = new PurchaseTypeSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setPurchaseTypeId(model.getPurchaseTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static PurchaseTypeSoap[] toSoapModels(PurchaseType[] models) {
		PurchaseTypeSoap[] soapModels = new PurchaseTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PurchaseTypeSoap[][] toSoapModels(PurchaseType[][] models) {
		PurchaseTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PurchaseTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PurchaseTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PurchaseTypeSoap[] toSoapModels(List<PurchaseType> models) {
		List<PurchaseTypeSoap> soapModels = new ArrayList<PurchaseTypeSoap>(
			models.size());

		for (PurchaseType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PurchaseTypeSoap[soapModels.size()]);
	}

	public PurchaseTypeSoap() {
	}

	public long getPrimaryKey() {
		return _purchaseTypeId;
	}

	public void setPrimaryKey(long pk) {
		setPurchaseTypeId(pk);
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

	public long getPurchaseTypeId() {
		return _purchaseTypeId;
	}

	public void setPurchaseTypeId(long purchaseTypeId) {
		_purchaseTypeId = purchaseTypeId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _purchaseTypeId;
	private long _groupId;
	private long _companyId;
	private String _name;

}