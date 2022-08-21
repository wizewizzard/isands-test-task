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

package com.wz.testtask.estore.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import com.wz.testtask.estore.model.Employee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author wz
 * @generated
 */
public class EmployeeCacheModel
	implements CacheModel<Employee>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeCacheModel)) {
			return false;
		}

		EmployeeCacheModel employeeCacheModel = (EmployeeCacheModel)object;

		if ((employeeId == employeeCacheModel.employeeId) &&
			(mvccVersion == employeeCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, employeeId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", patronymic=");
		sb.append(patronymic);
		sb.append(", birthDate=");
		sb.append(birthDate);
		sb.append(", positionId=");
		sb.append(positionId);
		sb.append(", gender=");
		sb.append(gender);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			employeeImpl.setUuid("");
		}
		else {
			employeeImpl.setUuid(uuid);
		}

		employeeImpl.setEmployeeId(employeeId);
		employeeImpl.setGroupId(groupId);
		employeeImpl.setCompanyId(companyId);

		if (lastName == null) {
			employeeImpl.setLastName("");
		}
		else {
			employeeImpl.setLastName(lastName);
		}

		if (firstName == null) {
			employeeImpl.setFirstName("");
		}
		else {
			employeeImpl.setFirstName(firstName);
		}

		if (patronymic == null) {
			employeeImpl.setPatronymic("");
		}
		else {
			employeeImpl.setPatronymic(patronymic);
		}

		if (birthDate == Long.MIN_VALUE) {
			employeeImpl.setBirthDate(null);
		}
		else {
			employeeImpl.setBirthDate(new Date(birthDate));
		}

		employeeImpl.setPositionId(positionId);
		employeeImpl.setGender(gender);

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		employeeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		lastName = objectInput.readUTF();
		firstName = objectInput.readUTF();
		patronymic = objectInput.readUTF();
		birthDate = objectInput.readLong();

		positionId = objectInput.readLong();

		gender = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (patronymic == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(patronymic);
		}

		objectOutput.writeLong(birthDate);

		objectOutput.writeLong(positionId);

		objectOutput.writeInt(gender);
	}

	public long mvccVersion;
	public String uuid;
	public long employeeId;
	public long groupId;
	public long companyId;
	public String lastName;
	public String firstName;
	public String patronymic;
	public long birthDate;
	public long positionId;
	public int gender;

}