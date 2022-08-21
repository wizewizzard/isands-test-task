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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Purchase}.
 * </p>
 *
 * @author wz
 * @see Purchase
 * @generated
 */
public class PurchaseWrapper
	extends BaseModelWrapper<Purchase>
	implements ModelWrapper<Purchase>, Purchase {

	public PurchaseWrapper(Purchase purchase) {
		super(purchase);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("purchaseId", getPurchaseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("deviceId", getDeviceId());
		attributes.put("purchasedDate", getPurchasedDate());
		attributes.put("purchaseTypeId", getPurchaseTypeId());

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

		Long purchaseId = (Long)attributes.get("purchaseId");

		if (purchaseId != null) {
			setPurchaseId(purchaseId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long deviceId = (Long)attributes.get("deviceId");

		if (deviceId != null) {
			setDeviceId(deviceId);
		}

		Date purchasedDate = (Date)attributes.get("purchasedDate");

		if (purchasedDate != null) {
			setPurchasedDate(purchasedDate);
		}

		Long purchaseTypeId = (Long)attributes.get("purchaseTypeId");

		if (purchaseTypeId != null) {
			setPurchaseTypeId(purchaseTypeId);
		}
	}

	/**
	 * Returns the company ID of this purchase.
	 *
	 * @return the company ID of this purchase
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the device ID of this purchase.
	 *
	 * @return the device ID of this purchase
	 */
	@Override
	public long getDeviceId() {
		return model.getDeviceId();
	}

	/**
	 * Returns the employee ID of this purchase.
	 *
	 * @return the employee ID of this purchase
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this purchase.
	 *
	 * @return the group ID of this purchase
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the mvcc version of this purchase.
	 *
	 * @return the mvcc version of this purchase
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this purchase.
	 *
	 * @return the primary key of this purchase
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the purchased date of this purchase.
	 *
	 * @return the purchased date of this purchase
	 */
	@Override
	public Date getPurchasedDate() {
		return model.getPurchasedDate();
	}

	/**
	 * Returns the purchase ID of this purchase.
	 *
	 * @return the purchase ID of this purchase
	 */
	@Override
	public long getPurchaseId() {
		return model.getPurchaseId();
	}

	/**
	 * Returns the purchase type ID of this purchase.
	 *
	 * @return the purchase type ID of this purchase
	 */
	@Override
	public long getPurchaseTypeId() {
		return model.getPurchaseTypeId();
	}

	/**
	 * Returns the uuid of this purchase.
	 *
	 * @return the uuid of this purchase
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
	 * Sets the company ID of this purchase.
	 *
	 * @param companyId the company ID of this purchase
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the device ID of this purchase.
	 *
	 * @param deviceId the device ID of this purchase
	 */
	@Override
	public void setDeviceId(long deviceId) {
		model.setDeviceId(deviceId);
	}

	/**
	 * Sets the employee ID of this purchase.
	 *
	 * @param employeeId the employee ID of this purchase
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this purchase.
	 *
	 * @param groupId the group ID of this purchase
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the mvcc version of this purchase.
	 *
	 * @param mvccVersion the mvcc version of this purchase
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this purchase.
	 *
	 * @param primaryKey the primary key of this purchase
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the purchased date of this purchase.
	 *
	 * @param purchasedDate the purchased date of this purchase
	 */
	@Override
	public void setPurchasedDate(Date purchasedDate) {
		model.setPurchasedDate(purchasedDate);
	}

	/**
	 * Sets the purchase ID of this purchase.
	 *
	 * @param purchaseId the purchase ID of this purchase
	 */
	@Override
	public void setPurchaseId(long purchaseId) {
		model.setPurchaseId(purchaseId);
	}

	/**
	 * Sets the purchase type ID of this purchase.
	 *
	 * @param purchaseTypeId the purchase type ID of this purchase
	 */
	@Override
	public void setPurchaseTypeId(long purchaseTypeId) {
		model.setPurchaseTypeId(purchaseTypeId);
	}

	/**
	 * Sets the uuid of this purchase.
	 *
	 * @param uuid the uuid of this purchase
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected PurchaseWrapper wrap(Purchase purchase) {
		return new PurchaseWrapper(purchase);
	}

}