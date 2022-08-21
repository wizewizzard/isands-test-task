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
 * This class is a wrapper for {@link DeviceType}.
 * </p>
 *
 * @author wz
 * @see DeviceType
 * @generated
 */
public class DeviceTypeWrapper
	extends BaseModelWrapper<DeviceType>
	implements DeviceType, ModelWrapper<DeviceType> {

	public DeviceTypeWrapper(DeviceType deviceType) {
		super(deviceType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("deviceTypeId", getDeviceTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("name", getName());

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

		Long deviceTypeId = (Long)attributes.get("deviceTypeId");

		if (deviceTypeId != null) {
			setDeviceTypeId(deviceTypeId);
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
	}

	/**
	 * Returns the company ID of this device type.
	 *
	 * @return the company ID of this device type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the device type ID of this device type.
	 *
	 * @return the device type ID of this device type
	 */
	@Override
	public long getDeviceTypeId() {
		return model.getDeviceTypeId();
	}

	/**
	 * Returns the group ID of this device type.
	 *
	 * @return the group ID of this device type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the mvcc version of this device type.
	 *
	 * @return the mvcc version of this device type
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this device type.
	 *
	 * @return the name of this device type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this device type.
	 *
	 * @return the primary key of this device type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this device type.
	 *
	 * @return the uuid of this device type
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this device type.
	 *
	 * @param companyId the company ID of this device type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the device type ID of this device type.
	 *
	 * @param deviceTypeId the device type ID of this device type
	 */
	@Override
	public void setDeviceTypeId(long deviceTypeId) {
		model.setDeviceTypeId(deviceTypeId);
	}

	/**
	 * Sets the group ID of this device type.
	 *
	 * @param groupId the group ID of this device type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the mvcc version of this device type.
	 *
	 * @param mvccVersion the mvcc version of this device type
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this device type.
	 *
	 * @param name the name of this device type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this device type.
	 *
	 * @param primaryKey the primary key of this device type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this device type.
	 *
	 * @param uuid the uuid of this device type
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected DeviceTypeWrapper wrap(DeviceType deviceType) {
		return new DeviceTypeWrapper(deviceType);
	}

}