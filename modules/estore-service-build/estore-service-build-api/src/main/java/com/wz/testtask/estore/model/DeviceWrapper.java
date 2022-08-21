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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Device}.
 * </p>
 *
 * @author wz
 * @see Device
 * @generated
 */
public class DeviceWrapper
	extends BaseModelWrapper<Device> implements Device, ModelWrapper<Device> {

	public DeviceWrapper(Device device) {
		super(device);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("deviceId", getDeviceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("name", getName());
		attributes.put("deviceTypeId", getDeviceTypeId());
		attributes.put("price", getPrice());
		attributes.put("count", getCount());
		attributes.put("inStock", isInStock());
		attributes.put("archive", isArchive());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long deviceId = (Long)attributes.get("deviceId");

		if (deviceId != null) {
			setDeviceId(deviceId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long deviceTypeId = (Long)attributes.get("deviceTypeId");

		if (deviceTypeId != null) {
			setDeviceTypeId(deviceTypeId);
		}

		Long price = (Long)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Integer count = (Integer)attributes.get("count");

		if (count != null) {
			setCount(count);
		}

		Boolean inStock = (Boolean)attributes.get("inStock");

		if (inStock != null) {
			setInStock(inStock);
		}

		Boolean archive = (Boolean)attributes.get("archive");

		if (archive != null) {
			setArchive(archive);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the archive of this device.
	 *
	 * @return the archive of this device
	 */
	@Override
	public boolean getArchive() {
		return model.getArchive();
	}

	/**
	 * Returns the company ID of this device.
	 *
	 * @return the company ID of this device
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the count of this device.
	 *
	 * @return the count of this device
	 */
	@Override
	public int getCount() {
		return model.getCount();
	}

	/**
	 * Returns the description of this device.
	 *
	 * @return the description of this device
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the device ID of this device.
	 *
	 * @return the device ID of this device
	 */
	@Override
	public long getDeviceId() {
		return model.getDeviceId();
	}

	/**
	 * Returns the device type ID of this device.
	 *
	 * @return the device type ID of this device
	 */
	@Override
	public long getDeviceTypeId() {
		return model.getDeviceTypeId();
	}

	/**
	 * Returns the group ID of this device.
	 *
	 * @return the group ID of this device
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the in stock of this device.
	 *
	 * @return the in stock of this device
	 */
	@Override
	public boolean getInStock() {
		return model.getInStock();
	}

	/**
	 * Returns the mvcc version of this device.
	 *
	 * @return the mvcc version of this device
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this device.
	 *
	 * @return the name of this device
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the price of this device.
	 *
	 * @return the price of this device
	 */
	@Override
	public long getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this device.
	 *
	 * @return the primary key of this device
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this device.
	 *
	 * @return the uuid of this device
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this device is archive.
	 *
	 * @return <code>true</code> if this device is archive; <code>false</code> otherwise
	 */
	@Override
	public boolean isArchive() {
		return model.isArchive();
	}

	/**
	 * Returns <code>true</code> if this device is in stock.
	 *
	 * @return <code>true</code> if this device is in stock; <code>false</code> otherwise
	 */
	@Override
	public boolean isInStock() {
		return model.isInStock();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this device is archive.
	 *
	 * @param archive the archive of this device
	 */
	@Override
	public void setArchive(boolean archive) {
		model.setArchive(archive);
	}

	/**
	 * Sets the company ID of this device.
	 *
	 * @param companyId the company ID of this device
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the count of this device.
	 *
	 * @param count the count of this device
	 */
	@Override
	public void setCount(int count) {
		model.setCount(count);
	}

	/**
	 * Sets the description of this device.
	 *
	 * @param description the description of this device
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the device ID of this device.
	 *
	 * @param deviceId the device ID of this device
	 */
	@Override
	public void setDeviceId(long deviceId) {
		model.setDeviceId(deviceId);
	}

	/**
	 * Sets the device type ID of this device.
	 *
	 * @param deviceTypeId the device type ID of this device
	 */
	@Override
	public void setDeviceTypeId(long deviceTypeId) {
		model.setDeviceTypeId(deviceTypeId);
	}

	/**
	 * Sets the group ID of this device.
	 *
	 * @param groupId the group ID of this device
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this device is in stock.
	 *
	 * @param inStock the in stock of this device
	 */
	@Override
	public void setInStock(boolean inStock) {
		model.setInStock(inStock);
	}

	/**
	 * Sets the mvcc version of this device.
	 *
	 * @param mvccVersion the mvcc version of this device
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this device.
	 *
	 * @param name the name of this device
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the price of this device.
	 *
	 * @param price the price of this device
	 */
	@Override
	public void setPrice(long price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this device.
	 *
	 * @param primaryKey the primary key of this device
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this device.
	 *
	 * @param uuid the uuid of this device
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected DeviceWrapper wrap(Device device) {
		return new DeviceWrapper(device);
	}

}