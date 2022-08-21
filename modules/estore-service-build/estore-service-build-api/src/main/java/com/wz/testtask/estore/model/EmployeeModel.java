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
 * The base model interface for the Employee service. Represents a row in the &quot;ESTORE_Employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.wz.testtask.estore.model.impl.EmployeeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.wz.testtask.estore.model.impl.EmployeeImpl</code>.
 * </p>
 *
 * @author wz
 * @see Employee
 * @generated
 */
@ProviderType
public interface EmployeeModel
	extends BaseModel<Employee>, MVCCModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee model instance should use the {@link Employee} interface instead.
	 */

	/**
	 * Returns the primary key of this employee.
	 *
	 * @return the primary key of this employee
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee.
	 *
	 * @param primaryKey the primary key of this employee
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this employee.
	 *
	 * @return the mvcc version of this employee
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this employee.
	 *
	 * @param mvccVersion the mvcc version of this employee
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this employee.
	 *
	 * @return the uuid of this employee
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this employee.
	 *
	 * @param uuid the uuid of this employee
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the employee ID of this employee.
	 *
	 * @return the employee ID of this employee
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee.
	 *
	 * @param employeeId the employee ID of this employee
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the group ID of this employee.
	 *
	 * @return the group ID of this employee
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this employee.
	 *
	 * @param groupId the group ID of this employee
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee.
	 *
	 * @return the company ID of this employee
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee.
	 *
	 * @param companyId the company ID of this employee
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the last name of this employee.
	 *
	 * @return the last name of this employee
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this employee.
	 *
	 * @param lastName the last name of this employee
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the first name of this employee.
	 *
	 * @return the first name of this employee
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this employee.
	 *
	 * @param firstName the first name of this employee
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the patronymic of this employee.
	 *
	 * @return the patronymic of this employee
	 */
	@AutoEscape
	public String getPatronymic();

	/**
	 * Sets the patronymic of this employee.
	 *
	 * @param patronymic the patronymic of this employee
	 */
	public void setPatronymic(String patronymic);

	/**
	 * Returns the birth date of this employee.
	 *
	 * @return the birth date of this employee
	 */
	public Date getBirthDate();

	/**
	 * Sets the birth date of this employee.
	 *
	 * @param birthDate the birth date of this employee
	 */
	public void setBirthDate(Date birthDate);

	/**
	 * Returns the position ID of this employee.
	 *
	 * @return the position ID of this employee
	 */
	public long getPositionId();

	/**
	 * Sets the position ID of this employee.
	 *
	 * @param positionId the position ID of this employee
	 */
	public void setPositionId(long positionId);

	/**
	 * Returns the gender of this employee.
	 *
	 * @return the gender of this employee
	 */
	public int getGender();

	/**
	 * Sets the gender of this employee.
	 *
	 * @param gender the gender of this employee
	 */
	public void setGender(int gender);

}