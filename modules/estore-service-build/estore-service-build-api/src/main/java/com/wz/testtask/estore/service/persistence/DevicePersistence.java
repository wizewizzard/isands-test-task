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

import com.wz.testtask.estore.exception.NoSuchDeviceException;
import com.wz.testtask.estore.model.Device;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the device service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author wz
 * @see DeviceUtil
 * @generated
 */
@ProviderType
public interface DevicePersistence extends BasePersistence<Device> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DeviceUtil} to access the device persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the devices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching devices
	 */
	public java.util.List<Device> findByUuid(String uuid);

	/**
	 * Returns a range of all the devices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @return the range of matching devices
	 */
	public java.util.List<Device> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the devices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching devices
	 */
	public java.util.List<Device> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator);

	/**
	 * Returns an ordered range of all the devices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching devices
	 */
	public java.util.List<Device> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first device in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public Device findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Device>
				orderByComparator)
		throws NoSuchDeviceException;

	/**
	 * Returns the first device in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device, or <code>null</code> if a matching device could not be found
	 */
	public Device fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator);

	/**
	 * Returns the last device in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public Device findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Device>
				orderByComparator)
		throws NoSuchDeviceException;

	/**
	 * Returns the last device in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device, or <code>null</code> if a matching device could not be found
	 */
	public Device fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator);

	/**
	 * Returns the devices before and after the current device in the ordered set where uuid = &#63;.
	 *
	 * @param deviceId the primary key of the current device
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	public Device[] findByUuid_PrevAndNext(
			long deviceId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Device>
				orderByComparator)
		throws NoSuchDeviceException;

	/**
	 * Removes all the devices where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of devices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching devices
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the device where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDeviceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public Device findByUUID_G(String uuid, long groupId)
		throws NoSuchDeviceException;

	/**
	 * Returns the device where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching device, or <code>null</code> if a matching device could not be found
	 */
	public Device fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the device where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching device, or <code>null</code> if a matching device could not be found
	 */
	public Device fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the device where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the device that was removed
	 */
	public Device removeByUUID_G(String uuid, long groupId)
		throws NoSuchDeviceException;

	/**
	 * Returns the number of devices where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching devices
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the devices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching devices
	 */
	public java.util.List<Device> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the devices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @return the range of matching devices
	 */
	public java.util.List<Device> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the devices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching devices
	 */
	public java.util.List<Device> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator);

	/**
	 * Returns an ordered range of all the devices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching devices
	 */
	public java.util.List<Device> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first device in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public Device findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Device>
				orderByComparator)
		throws NoSuchDeviceException;

	/**
	 * Returns the first device in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device, or <code>null</code> if a matching device could not be found
	 */
	public Device fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator);

	/**
	 * Returns the last device in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public Device findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Device>
				orderByComparator)
		throws NoSuchDeviceException;

	/**
	 * Returns the last device in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device, or <code>null</code> if a matching device could not be found
	 */
	public Device fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator);

	/**
	 * Returns the devices before and after the current device in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param deviceId the primary key of the current device
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	public Device[] findByUuid_C_PrevAndNext(
			long deviceId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Device>
				orderByComparator)
		throws NoSuchDeviceException;

	/**
	 * Removes all the devices where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of devices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching devices
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the devices where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching devices
	 */
	public java.util.List<Device> findByName(long groupId, String name);

	/**
	 * Returns a range of all the devices where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @return the range of matching devices
	 */
	public java.util.List<Device> findByName(
		long groupId, String name, int start, int end);

	/**
	 * Returns an ordered range of all the devices where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching devices
	 */
	public java.util.List<Device> findByName(
		long groupId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator);

	/**
	 * Returns an ordered range of all the devices where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching devices
	 */
	public java.util.List<Device> findByName(
		long groupId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first device in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public Device findByName_First(
			long groupId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Device>
				orderByComparator)
		throws NoSuchDeviceException;

	/**
	 * Returns the first device in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device, or <code>null</code> if a matching device could not be found
	 */
	public Device fetchByName_First(
		long groupId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator);

	/**
	 * Returns the last device in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public Device findByName_Last(
			long groupId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Device>
				orderByComparator)
		throws NoSuchDeviceException;

	/**
	 * Returns the last device in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device, or <code>null</code> if a matching device could not be found
	 */
	public Device fetchByName_Last(
		long groupId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator);

	/**
	 * Returns the devices before and after the current device in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param deviceId the primary key of the current device
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	public Device[] findByName_PrevAndNext(
			long deviceId, long groupId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Device>
				orderByComparator)
		throws NoSuchDeviceException;

	/**
	 * Removes all the devices where groupId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 */
	public void removeByName(long groupId, String name);

	/**
	 * Returns the number of devices where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching devices
	 */
	public int countByName(long groupId, String name);

	/**
	 * Returns all the devices where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching devices
	 */
	public java.util.List<Device> findByGroupId(long groupId);

	/**
	 * Returns a range of all the devices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @return the range of matching devices
	 */
	public java.util.List<Device> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the devices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching devices
	 */
	public java.util.List<Device> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator);

	/**
	 * Returns an ordered range of all the devices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching devices
	 */
	public java.util.List<Device> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first device in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public Device findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Device>
				orderByComparator)
		throws NoSuchDeviceException;

	/**
	 * Returns the first device in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device, or <code>null</code> if a matching device could not be found
	 */
	public Device fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator);

	/**
	 * Returns the last device in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public Device findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Device>
				orderByComparator)
		throws NoSuchDeviceException;

	/**
	 * Returns the last device in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device, or <code>null</code> if a matching device could not be found
	 */
	public Device fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator);

	/**
	 * Returns the devices before and after the current device in the ordered set where groupId = &#63;.
	 *
	 * @param deviceId the primary key of the current device
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	public Device[] findByGroupId_PrevAndNext(
			long deviceId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Device>
				orderByComparator)
		throws NoSuchDeviceException;

	/**
	 * Removes all the devices where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of devices where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching devices
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the device in the entity cache if it is enabled.
	 *
	 * @param device the device
	 */
	public void cacheResult(Device device);

	/**
	 * Caches the devices in the entity cache if it is enabled.
	 *
	 * @param devices the devices
	 */
	public void cacheResult(java.util.List<Device> devices);

	/**
	 * Creates a new device with the primary key. Does not add the device to the database.
	 *
	 * @param deviceId the primary key for the new device
	 * @return the new device
	 */
	public Device create(long deviceId);

	/**
	 * Removes the device with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deviceId the primary key of the device
	 * @return the device that was removed
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	public Device remove(long deviceId) throws NoSuchDeviceException;

	public Device updateImpl(Device device);

	/**
	 * Returns the device with the primary key or throws a <code>NoSuchDeviceException</code> if it could not be found.
	 *
	 * @param deviceId the primary key of the device
	 * @return the device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	public Device findByPrimaryKey(long deviceId) throws NoSuchDeviceException;

	/**
	 * Returns the device with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deviceId the primary key of the device
	 * @return the device, or <code>null</code> if a device with the primary key could not be found
	 */
	public Device fetchByPrimaryKey(long deviceId);

	/**
	 * Returns all the devices.
	 *
	 * @return the devices
	 */
	public java.util.List<Device> findAll();

	/**
	 * Returns a range of all the devices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @return the range of devices
	 */
	public java.util.List<Device> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the devices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of devices
	 */
	public java.util.List<Device> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator);

	/**
	 * Returns an ordered range of all the devices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of devices
	 */
	public java.util.List<Device> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Device>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the devices from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of devices.
	 *
	 * @return the number of devices
	 */
	public int countAll();

}