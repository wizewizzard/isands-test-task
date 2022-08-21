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

package com.wz.testtask.estore.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.wz.testtask.estore.exception.NoSuchDeviceTypeException;
import com.wz.testtask.estore.model.DeviceType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the device type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author wz
 * @see DeviceTypeUtil
 * @generated
 */
@ProviderType
public interface DeviceTypePersistence extends BasePersistence<DeviceType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DeviceTypeUtil} to access the device type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the device types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching device types
	 */
	public java.util.List<DeviceType> findByUuid(String uuid);

	/**
	 * Returns a range of all the device types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @return the range of matching device types
	 */
	public java.util.List<DeviceType> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the device types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching device types
	 */
	public java.util.List<DeviceType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the device types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching device types
	 */
	public java.util.List<DeviceType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first device type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	public DeviceType findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
				orderByComparator)
		throws NoSuchDeviceTypeException;

	/**
	 * Returns the first device type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public DeviceType fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator);

	/**
	 * Returns the last device type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	public DeviceType findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
				orderByComparator)
		throws NoSuchDeviceTypeException;

	/**
	 * Returns the last device type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public DeviceType fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator);

	/**
	 * Returns the device types before and after the current device type in the ordered set where uuid = &#63;.
	 *
	 * @param deviceTypeId the primary key of the current device type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device type
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	public DeviceType[] findByUuid_PrevAndNext(
			long deviceTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
				orderByComparator)
		throws NoSuchDeviceTypeException;

	/**
	 * Removes all the device types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of device types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching device types
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the device type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDeviceTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	public DeviceType findByUUID_G(String uuid, long groupId)
		throws NoSuchDeviceTypeException;

	/**
	 * Returns the device type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public DeviceType fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the device type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public DeviceType fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the device type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the device type that was removed
	 */
	public DeviceType removeByUUID_G(String uuid, long groupId)
		throws NoSuchDeviceTypeException;

	/**
	 * Returns the number of device types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching device types
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the device types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching device types
	 */
	public java.util.List<DeviceType> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the device types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @return the range of matching device types
	 */
	public java.util.List<DeviceType> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the device types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching device types
	 */
	public java.util.List<DeviceType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the device types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching device types
	 */
	public java.util.List<DeviceType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first device type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	public DeviceType findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
				orderByComparator)
		throws NoSuchDeviceTypeException;

	/**
	 * Returns the first device type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public DeviceType fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator);

	/**
	 * Returns the last device type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	public DeviceType findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
				orderByComparator)
		throws NoSuchDeviceTypeException;

	/**
	 * Returns the last device type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public DeviceType fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator);

	/**
	 * Returns the device types before and after the current device type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param deviceTypeId the primary key of the current device type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device type
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	public DeviceType[] findByUuid_C_PrevAndNext(
			long deviceTypeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
				orderByComparator)
		throws NoSuchDeviceTypeException;

	/**
	 * Removes all the device types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of device types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching device types
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the device types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching device types
	 */
	public java.util.List<DeviceType> findByGroupId(long groupId);

	/**
	 * Returns a range of all the device types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @return the range of matching device types
	 */
	public java.util.List<DeviceType> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the device types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching device types
	 */
	public java.util.List<DeviceType> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the device types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching device types
	 */
	public java.util.List<DeviceType> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first device type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	public DeviceType findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
				orderByComparator)
		throws NoSuchDeviceTypeException;

	/**
	 * Returns the first device type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public DeviceType fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator);

	/**
	 * Returns the last device type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	public DeviceType findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
				orderByComparator)
		throws NoSuchDeviceTypeException;

	/**
	 * Returns the last device type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public DeviceType fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator);

	/**
	 * Returns the device types before and after the current device type in the ordered set where groupId = &#63;.
	 *
	 * @param deviceTypeId the primary key of the current device type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device type
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	public DeviceType[] findByGroupId_PrevAndNext(
			long deviceTypeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
				orderByComparator)
		throws NoSuchDeviceTypeException;

	/**
	 * Removes all the device types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of device types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching device types
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the device type in the entity cache if it is enabled.
	 *
	 * @param deviceType the device type
	 */
	public void cacheResult(DeviceType deviceType);

	/**
	 * Caches the device types in the entity cache if it is enabled.
	 *
	 * @param deviceTypes the device types
	 */
	public void cacheResult(java.util.List<DeviceType> deviceTypes);

	/**
	 * Creates a new device type with the primary key. Does not add the device type to the database.
	 *
	 * @param deviceTypeId the primary key for the new device type
	 * @return the new device type
	 */
	public DeviceType create(long deviceTypeId);

	/**
	 * Removes the device type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deviceTypeId the primary key of the device type
	 * @return the device type that was removed
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	public DeviceType remove(long deviceTypeId)
		throws NoSuchDeviceTypeException;

	public DeviceType updateImpl(DeviceType deviceType);

	/**
	 * Returns the device type with the primary key or throws a <code>NoSuchDeviceTypeException</code> if it could not be found.
	 *
	 * @param deviceTypeId the primary key of the device type
	 * @return the device type
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	public DeviceType findByPrimaryKey(long deviceTypeId)
		throws NoSuchDeviceTypeException;

	/**
	 * Returns the device type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deviceTypeId the primary key of the device type
	 * @return the device type, or <code>null</code> if a device type with the primary key could not be found
	 */
	public DeviceType fetchByPrimaryKey(long deviceTypeId);

	/**
	 * Returns all the device types.
	 *
	 * @return the device types
	 */
	public java.util.List<DeviceType> findAll();

	/**
	 * Returns a range of all the device types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @return the range of device types
	 */
	public java.util.List<DeviceType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the device types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of device types
	 */
	public java.util.List<DeviceType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the device types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of device types
	 */
	public java.util.List<DeviceType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the device types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of device types.
	 *
	 * @return the number of device types
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of employees associated with the device type.
	 *
	 * @param pk the primary key of the device type
	 * @return long[] of the primaryKeys of employees associated with the device type
	 */
	public long[] getEmployeePrimaryKeys(long pk);

	/**
	 * Returns all the device type associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @return the device types associated with the employee
	 */
	public java.util.List<DeviceType> getEmployeeDeviceTypes(long pk);

	/**
	 * Returns all the device type associated with the employee.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the employee
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of device types associated with the employee
	 */
	public java.util.List<DeviceType> getEmployeeDeviceTypes(
		long pk, int start, int end);

	/**
	 * Returns all the device type associated with the employee.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the employee
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of device types associated with the employee
	 */
	public java.util.List<DeviceType> getEmployeeDeviceTypes(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeviceType>
			orderByComparator);

	/**
	 * Returns the number of employees associated with the device type.
	 *
	 * @param pk the primary key of the device type
	 * @return the number of employees associated with the device type
	 */
	public int getEmployeesSize(long pk);

	/**
	 * Returns <code>true</code> if the employee is associated with the device type.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePK the primary key of the employee
	 * @return <code>true</code> if the employee is associated with the device type; <code>false</code> otherwise
	 */
	public boolean containsEmployee(long pk, long employeePK);

	/**
	 * Returns <code>true</code> if the device type has any employees associated with it.
	 *
	 * @param pk the primary key of the device type to check for associations with employees
	 * @return <code>true</code> if the device type has any employees associated with it; <code>false</code> otherwise
	 */
	public boolean containsEmployees(long pk);

	/**
	 * Adds an association between the device type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePK the primary key of the employee
	 */
	public void addEmployee(long pk, long employeePK);

	/**
	 * Adds an association between the device type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employee the employee
	 */
	public void addEmployee(
		long pk, com.wz.testtask.estore.model.Employee employee);

	/**
	 * Adds an association between the device type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePKs the primary keys of the employees
	 */
	public void addEmployees(long pk, long[] employeePKs);

	/**
	 * Adds an association between the device type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employees the employees
	 */
	public void addEmployees(
		long pk,
		java.util.List<com.wz.testtask.estore.model.Employee> employees);

	/**
	 * Clears all associations between the device type and its employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type to clear the associated employees from
	 */
	public void clearEmployees(long pk);

	/**
	 * Removes the association between the device type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePK the primary key of the employee
	 */
	public void removeEmployee(long pk, long employeePK);

	/**
	 * Removes the association between the device type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employee the employee
	 */
	public void removeEmployee(
		long pk, com.wz.testtask.estore.model.Employee employee);

	/**
	 * Removes the association between the device type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePKs the primary keys of the employees
	 */
	public void removeEmployees(long pk, long[] employeePKs);

	/**
	 * Removes the association between the device type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employees the employees
	 */
	public void removeEmployees(
		long pk,
		java.util.List<com.wz.testtask.estore.model.Employee> employees);

	/**
	 * Sets the employees associated with the device type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePKs the primary keys of the employees to be associated with the device type
	 */
	public void setEmployees(long pk, long[] employeePKs);

	/**
	 * Sets the employees associated with the device type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employees the employees to be associated with the device type
	 */
	public void setEmployees(
		long pk,
		java.util.List<com.wz.testtask.estore.model.Employee> employees);

}