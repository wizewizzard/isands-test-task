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

import com.wz.testtask.estore.model.Device;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Device in entity cache.
 *
 * @author wz
 * @generated
 */
public class DeviceCacheModel
	implements CacheModel<Device>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DeviceCacheModel)) {
			return false;
		}

		DeviceCacheModel deviceCacheModel = (DeviceCacheModel)object;

		if ((deviceId == deviceCacheModel.deviceId) &&
			(mvccVersion == deviceCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, deviceId);

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
		StringBundler sb = new StringBundler(25);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", deviceId=");
		sb.append(deviceId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", deviceTypeId=");
		sb.append(deviceTypeId);
		sb.append(", price=");
		sb.append(price);
		sb.append(", count=");
		sb.append(count);
		sb.append(", inStock=");
		sb.append(inStock);
		sb.append(", archive=");
		sb.append(archive);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Device toEntityModel() {
		DeviceImpl deviceImpl = new DeviceImpl();

		deviceImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			deviceImpl.setUuid("");
		}
		else {
			deviceImpl.setUuid(uuid);
		}

		deviceImpl.setDeviceId(deviceId);
		deviceImpl.setGroupId(groupId);
		deviceImpl.setCompanyId(companyId);

		if (name == null) {
			deviceImpl.setName("");
		}
		else {
			deviceImpl.setName(name);
		}

		deviceImpl.setDeviceTypeId(deviceTypeId);
		deviceImpl.setPrice(price);
		deviceImpl.setCount(count);
		deviceImpl.setInStock(inStock);
		deviceImpl.setArchive(archive);

		if (description == null) {
			deviceImpl.setDescription("");
		}
		else {
			deviceImpl.setDescription(description);
		}

		deviceImpl.resetOriginalValues();

		return deviceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		deviceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		name = objectInput.readUTF();

		deviceTypeId = objectInput.readLong();

		price = objectInput.readLong();

		count = objectInput.readInt();

		inStock = objectInput.readBoolean();

		archive = objectInput.readBoolean();
		description = objectInput.readUTF();
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

		objectOutput.writeLong(deviceId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(deviceTypeId);

		objectOutput.writeLong(price);

		objectOutput.writeInt(count);

		objectOutput.writeBoolean(inStock);

		objectOutput.writeBoolean(archive);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long mvccVersion;
	public String uuid;
	public long deviceId;
	public long groupId;
	public long companyId;
	public String name;
	public long deviceTypeId;
	public long price;
	public int count;
	public boolean inStock;
	public boolean archive;
	public String description;

}