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
 * This class is a wrapper for {@link EmployeePosition}.
 * </p>
 *
 * @author wz
 * @see EmployeePosition
 * @generated
 */
public class EmployeePositionWrapper
	extends BaseModelWrapper<EmployeePosition>
	implements EmployeePosition, ModelWrapper<EmployeePosition> {

	public EmployeePositionWrapper(EmployeePosition employeePosition) {
		super(employeePosition);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("positionId", getPositionId());
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

		Long positionId = (Long)attributes.get("positionId");

		if (positionId != null) {
			setPositionId(positionId);
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
	 * Returns the company ID of this employee position.
	 *
	 * @return the company ID of this employee position
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this employee position.
	 *
	 * @return the group ID of this employee position
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the mvcc version of this employee position.
	 *
	 * @return the mvcc version of this employee position
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this employee position.
	 *
	 * @return the name of this employee position
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the position ID of this employee position.
	 *
	 * @return the position ID of this employee position
	 */
	@Override
	public long getPositionId() {
		return model.getPositionId();
	}

	/**
	 * Returns the primary key of this employee position.
	 *
	 * @return the primary key of this employee position
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this employee position.
	 *
	 * @return the uuid of this employee position
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
	 * Sets the company ID of this employee position.
	 *
	 * @param companyId the company ID of this employee position
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this employee position.
	 *
	 * @param groupId the group ID of this employee position
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the mvcc version of this employee position.
	 *
	 * @param mvccVersion the mvcc version of this employee position
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this employee position.
	 *
	 * @param name the name of this employee position
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the position ID of this employee position.
	 *
	 * @param positionId the position ID of this employee position
	 */
	@Override
	public void setPositionId(long positionId) {
		model.setPositionId(positionId);
	}

	/**
	 * Sets the primary key of this employee position.
	 *
	 * @param primaryKey the primary key of this employee position
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this employee position.
	 *
	 * @param uuid the uuid of this employee position
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected EmployeePositionWrapper wrap(EmployeePosition employeePosition) {
		return new EmployeePositionWrapper(employeePosition);
	}

}