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

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the EmployeePosition service. Represents a row in the &quot;ESTORE_EmployeePosition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.wz.testtask.estore.model.impl.EmployeePositionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.wz.testtask.estore.model.impl.EmployeePositionImpl</code>.
 * </p>
 *
 * @author wz
 * @see EmployeePosition
 * @generated
 */
@ProviderType
public interface EmployeePositionModel
	extends BaseModel<EmployeePosition>, MVCCModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee position model instance should use the {@link EmployeePosition} interface instead.
	 */

	/**
	 * Returns the primary key of this employee position.
	 *
	 * @return the primary key of this employee position
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee position.
	 *
	 * @param primaryKey the primary key of this employee position
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this employee position.
	 *
	 * @return the mvcc version of this employee position
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this employee position.
	 *
	 * @param mvccVersion the mvcc version of this employee position
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this employee position.
	 *
	 * @return the uuid of this employee position
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this employee position.
	 *
	 * @param uuid the uuid of this employee position
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the position ID of this employee position.
	 *
	 * @return the position ID of this employee position
	 */
	public long getPositionId();

	/**
	 * Sets the position ID of this employee position.
	 *
	 * @param positionId the position ID of this employee position
	 */
	public void setPositionId(long positionId);

	/**
	 * Returns the group ID of this employee position.
	 *
	 * @return the group ID of this employee position
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this employee position.
	 *
	 * @param groupId the group ID of this employee position
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee position.
	 *
	 * @return the company ID of this employee position
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee position.
	 *
	 * @param companyId the company ID of this employee position
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the name of this employee position.
	 *
	 * @return the name of this employee position
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this employee position.
	 *
	 * @param name the name of this employee position
	 */
	public void setName(String name);

}