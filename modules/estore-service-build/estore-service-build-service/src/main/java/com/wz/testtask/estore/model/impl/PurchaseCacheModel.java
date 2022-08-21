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

import com.wz.testtask.estore.model.Purchase;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Purchase in entity cache.
 *
 * @author wz
 * @generated
 */
public class PurchaseCacheModel
	implements CacheModel<Purchase>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PurchaseCacheModel)) {
			return false;
		}

		PurchaseCacheModel purchaseCacheModel = (PurchaseCacheModel)object;

		if ((purchaseId == purchaseCacheModel.purchaseId) &&
			(mvccVersion == purchaseCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, purchaseId);

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
		StringBundler sb = new StringBundler(19);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", purchaseId=");
		sb.append(purchaseId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", deviceId=");
		sb.append(deviceId);
		sb.append(", purchasedDate=");
		sb.append(purchasedDate);
		sb.append(", purchaseTypeId=");
		sb.append(purchaseTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Purchase toEntityModel() {
		PurchaseImpl purchaseImpl = new PurchaseImpl();

		purchaseImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			purchaseImpl.setUuid("");
		}
		else {
			purchaseImpl.setUuid(uuid);
		}

		purchaseImpl.setPurchaseId(purchaseId);
		purchaseImpl.setGroupId(groupId);
		purchaseImpl.setCompanyId(companyId);
		purchaseImpl.setEmployeeId(employeeId);
		purchaseImpl.setDeviceId(deviceId);

		if (purchasedDate == Long.MIN_VALUE) {
			purchaseImpl.setPurchasedDate(null);
		}
		else {
			purchaseImpl.setPurchasedDate(new Date(purchasedDate));
		}

		purchaseImpl.setPurchaseTypeId(purchaseTypeId);

		purchaseImpl.resetOriginalValues();

		return purchaseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		purchaseId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		employeeId = objectInput.readLong();

		deviceId = objectInput.readLong();
		purchasedDate = objectInput.readLong();

		purchaseTypeId = objectInput.readLong();
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

		objectOutput.writeLong(purchaseId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(deviceId);
		objectOutput.writeLong(purchasedDate);

		objectOutput.writeLong(purchaseTypeId);
	}

	public long mvccVersion;
	public String uuid;
	public long purchaseId;
	public long groupId;
	public long companyId;
	public long employeeId;
	public long deviceId;
	public long purchasedDate;
	public long purchaseTypeId;

}