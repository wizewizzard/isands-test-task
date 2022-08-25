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
 * This class is a wrapper for {@link EmployeeWithSummary}.
 * </p>
 *
 * @author wz
 * @see EmployeeWithSummary
 * @generated
 */
public class EmployeeWithSummaryWrapper
	extends BaseModelWrapper<EmployeeWithSummary>
	implements EmployeeWithSummary, ModelWrapper<EmployeeWithSummary> {

	public EmployeeWithSummaryWrapper(EmployeeWithSummary employeeWithSummary) {
		super(employeeWithSummary);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("employeeFullName", getEmployeeFullName());
		attributes.put("deviceCount", getDeviceCount());
		attributes.put("soldDevicesOn", getSoldDevicesOn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String employeeFullName = (String)attributes.get("employeeFullName");

		if (employeeFullName != null) {
			setEmployeeFullName(employeeFullName);
		}

		Integer deviceCount = (Integer)attributes.get("deviceCount");

		if (deviceCount != null) {
			setDeviceCount(deviceCount);
		}

		Long soldDevicesOn = (Long)attributes.get("soldDevicesOn");

		if (soldDevicesOn != null) {
			setSoldDevicesOn(soldDevicesOn);
		}
	}

	/**
	 * Returns the device count of this employee with summary.
	 *
	 * @return the device count of this employee with summary
	 */
	@Override
	public int getDeviceCount() {
		return model.getDeviceCount();
	}

	/**
	 * Returns the employee full name of this employee with summary.
	 *
	 * @return the employee full name of this employee with summary
	 */
	@Override
	public String getEmployeeFullName() {
		return model.getEmployeeFullName();
	}

	/**
	 * Returns the employee ID of this employee with summary.
	 *
	 * @return the employee ID of this employee with summary
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the mvcc version of this employee with summary.
	 *
	 * @return the mvcc version of this employee with summary
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this employee with summary.
	 *
	 * @return the primary key of this employee with summary
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sold devices on of this employee with summary.
	 *
	 * @return the sold devices on of this employee with summary
	 */
	@Override
	public long getSoldDevicesOn() {
		return model.getSoldDevicesOn();
	}

	/**
	 * Sets the device count of this employee with summary.
	 *
	 * @param deviceCount the device count of this employee with summary
	 */
	@Override
	public void setDeviceCount(int deviceCount) {
		model.setDeviceCount(deviceCount);
	}

	/**
	 * Sets the employee full name of this employee with summary.
	 *
	 * @param employeeFullName the employee full name of this employee with summary
	 */
	@Override
	public void setEmployeeFullName(String employeeFullName) {
		model.setEmployeeFullName(employeeFullName);
	}

	/**
	 * Sets the employee ID of this employee with summary.
	 *
	 * @param employeeId the employee ID of this employee with summary
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the mvcc version of this employee with summary.
	 *
	 * @param mvccVersion the mvcc version of this employee with summary
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this employee with summary.
	 *
	 * @param primaryKey the primary key of this employee with summary
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sold devices on of this employee with summary.
	 *
	 * @param soldDevicesOn the sold devices on of this employee with summary
	 */
	@Override
	public void setSoldDevicesOn(long soldDevicesOn) {
		model.setSoldDevicesOn(soldDevicesOn);
	}

	@Override
	protected EmployeeWithSummaryWrapper wrap(
		EmployeeWithSummary employeeWithSummary) {

		return new EmployeeWithSummaryWrapper(employeeWithSummary);
	}

}