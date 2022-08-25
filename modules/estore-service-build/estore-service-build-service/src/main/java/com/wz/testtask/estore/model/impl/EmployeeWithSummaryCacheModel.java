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

import com.wz.testtask.estore.model.EmployeeWithSummary;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EmployeeWithSummary in entity cache.
 *
 * @author wz
 * @generated
 */
public class EmployeeWithSummaryCacheModel
	implements CacheModel<EmployeeWithSummary>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeWithSummaryCacheModel)) {
			return false;
		}

		EmployeeWithSummaryCacheModel employeeWithSummaryCacheModel =
			(EmployeeWithSummaryCacheModel)object;

		if ((employeeId == employeeWithSummaryCacheModel.employeeId) &&
			(mvccVersion == employeeWithSummaryCacheModel.mvccVersion)) {

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
		StringBundler sb = new StringBundler(11);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", employeeFullName=");
		sb.append(employeeFullName);
		sb.append(", deviceCount=");
		sb.append(deviceCount);
		sb.append(", soldDevicesOn=");
		sb.append(soldDevicesOn);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeWithSummary toEntityModel() {
		EmployeeWithSummaryImpl employeeWithSummaryImpl =
			new EmployeeWithSummaryImpl();

		employeeWithSummaryImpl.setMvccVersion(mvccVersion);
		employeeWithSummaryImpl.setEmployeeId(employeeId);

		if (employeeFullName == null) {
			employeeWithSummaryImpl.setEmployeeFullName("");
		}
		else {
			employeeWithSummaryImpl.setEmployeeFullName(employeeFullName);
		}

		employeeWithSummaryImpl.setDeviceCount(deviceCount);
		employeeWithSummaryImpl.setSoldDevicesOn(soldDevicesOn);

		employeeWithSummaryImpl.resetOriginalValues();

		return employeeWithSummaryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		employeeId = objectInput.readLong();
		employeeFullName = objectInput.readUTF();

		deviceCount = objectInput.readInt();

		soldDevicesOn = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(employeeId);

		if (employeeFullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeFullName);
		}

		objectOutput.writeInt(deviceCount);

		objectOutput.writeLong(soldDevicesOn);
	}

	public long mvccVersion;
	public long employeeId;
	public String employeeFullName;
	public int deviceCount;
	public long soldDevicesOn;

}