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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Purchase service. Represents a row in the &quot;ESTORE_Purchase&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.wz.testtask.estore.model.impl.PurchaseModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.wz.testtask.estore.model.impl.PurchaseImpl</code>.
 * </p>
 *
 * @author wz
 * @see Purchase
 * @generated
 */
@ProviderType
public interface PurchaseModel
	extends BaseModel<Purchase>, MVCCModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a purchase model instance should use the {@link Purchase} interface instead.
	 */

	/**
	 * Returns the primary key of this purchase.
	 *
	 * @return the primary key of this purchase
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this purchase.
	 *
	 * @param primaryKey the primary key of this purchase
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this purchase.
	 *
	 * @return the mvcc version of this purchase
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this purchase.
	 *
	 * @param mvccVersion the mvcc version of this purchase
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this purchase.
	 *
	 * @return the uuid of this purchase
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this purchase.
	 *
	 * @param uuid the uuid of this purchase
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the purchase ID of this purchase.
	 *
	 * @return the purchase ID of this purchase
	 */
	public long getPurchaseId();

	/**
	 * Sets the purchase ID of this purchase.
	 *
	 * @param purchaseId the purchase ID of this purchase
	 */
	public void setPurchaseId(long purchaseId);

	/**
	 * Returns the group ID of this purchase.
	 *
	 * @return the group ID of this purchase
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this purchase.
	 *
	 * @param groupId the group ID of this purchase
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this purchase.
	 *
	 * @return the company ID of this purchase
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this purchase.
	 *
	 * @param companyId the company ID of this purchase
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the employee ID of this purchase.
	 *
	 * @return the employee ID of this purchase
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this purchase.
	 *
	 * @param employeeId the employee ID of this purchase
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the device ID of this purchase.
	 *
	 * @return the device ID of this purchase
	 */
	public long getDeviceId();

	/**
	 * Sets the device ID of this purchase.
	 *
	 * @param deviceId the device ID of this purchase
	 */
	public void setDeviceId(long deviceId);

	/**
	 * Returns the purchased date of this purchase.
	 *
	 * @return the purchased date of this purchase
	 */
	public Date getPurchasedDate();

	/**
	 * Sets the purchased date of this purchase.
	 *
	 * @param purchasedDate the purchased date of this purchase
	 */
	public void setPurchasedDate(Date purchasedDate);

	/**
	 * Returns the purchase type ID of this purchase.
	 *
	 * @return the purchase type ID of this purchase
	 */
	public long getPurchaseTypeId();

	/**
	 * Sets the purchase type ID of this purchase.
	 *
	 * @param purchaseTypeId the purchase type ID of this purchase
	 */
	public void setPurchaseTypeId(long purchaseTypeId);

}