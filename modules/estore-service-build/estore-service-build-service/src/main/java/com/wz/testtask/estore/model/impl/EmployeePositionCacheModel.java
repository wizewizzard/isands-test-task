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

import com.wz.testtask.estore.model.EmployeePosition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EmployeePosition in entity cache.
 *
 * @author wz
 * @generated
 */
public class EmployeePositionCacheModel
	implements CacheModel<EmployeePosition>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeePositionCacheModel)) {
			return false;
		}

		EmployeePositionCacheModel employeePositionCacheModel =
			(EmployeePositionCacheModel)object;

		if ((positionId == employeePositionCacheModel.positionId) &&
			(mvccVersion == employeePositionCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, positionId);

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
		StringBundler sb = new StringBundler(13);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", positionId=");
		sb.append(positionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeePosition toEntityModel() {
		EmployeePositionImpl employeePositionImpl = new EmployeePositionImpl();

		employeePositionImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			employeePositionImpl.setUuid("");
		}
		else {
			employeePositionImpl.setUuid(uuid);
		}

		employeePositionImpl.setPositionId(positionId);
		employeePositionImpl.setGroupId(groupId);
		employeePositionImpl.setCompanyId(companyId);

		if (name == null) {
			employeePositionImpl.setName("");
		}
		else {
			employeePositionImpl.setName(name);
		}

		employeePositionImpl.resetOriginalValues();

		return employeePositionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		positionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		name = objectInput.readUTF();
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

		objectOutput.writeLong(positionId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long mvccVersion;
	public String uuid;
	public long positionId;
	public long groupId;
	public long companyId;
	public String name;

}