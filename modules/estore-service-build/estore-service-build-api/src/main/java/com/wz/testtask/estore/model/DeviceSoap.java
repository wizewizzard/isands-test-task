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
 * This class is used by SOAP remote services, specifically {@link com.wz.testtask.estore.service.http.DeviceServiceSoap}.
 *
 * @author wz
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DeviceSoap implements Serializable {

	public static DeviceSoap toSoapModel(Device model) {
		DeviceSoap soapModel = new DeviceSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setDeviceId(model.getDeviceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setName(model.getName());
		soapModel.setDeviceTypeId(model.getDeviceTypeId());
		soapModel.setPrice(model.getPrice());
		soapModel.setCount(model.getCount());
		soapModel.setInStock(model.isInStock());
		soapModel.setArchive(model.isArchive());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static DeviceSoap[] toSoapModels(Device[] models) {
		DeviceSoap[] soapModels = new DeviceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DeviceSoap[][] toSoapModels(Device[][] models) {
		DeviceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DeviceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DeviceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DeviceSoap[] toSoapModels(List<Device> models) {
		List<DeviceSoap> soapModels = new ArrayList<DeviceSoap>(models.size());

		for (Device model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DeviceSoap[soapModels.size()]);
	}

	public DeviceSoap() {
	}

	public long getPrimaryKey() {
		return _deviceId;
	}

	public void setPrimaryKey(long pk) {
		setDeviceId(pk);
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

	public long getDeviceId() {
		return _deviceId;
	}

	public void setDeviceId(long deviceId) {
		_deviceId = deviceId;
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

	public long getDeviceTypeId() {
		return _deviceTypeId;
	}

	public void setDeviceTypeId(long deviceTypeId) {
		_deviceTypeId = deviceTypeId;
	}

	public long getPrice() {
		return _price;
	}

	public void setPrice(long price) {
		_price = price;
	}

	public int getCount() {
		return _count;
	}

	public void setCount(int count) {
		_count = count;
	}

	public boolean getInStock() {
		return _inStock;
	}

	public boolean isInStock() {
		return _inStock;
	}

	public void setInStock(boolean inStock) {
		_inStock = inStock;
	}

	public boolean getArchive() {
		return _archive;
	}

	public boolean isArchive() {
		return _archive;
	}

	public void setArchive(boolean archive) {
		_archive = archive;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _deviceId;
	private long _groupId;
	private long _companyId;
	private String _name;
	private long _deviceTypeId;
	private long _price;
	private int _count;
	private boolean _inStock;
	private boolean _archive;
	private String _description;

}