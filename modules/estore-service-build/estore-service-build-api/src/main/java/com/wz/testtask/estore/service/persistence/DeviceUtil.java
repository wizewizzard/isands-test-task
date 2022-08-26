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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.wz.testtask.estore.model.Device;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the device service. This utility wraps <code>com.wz.testtask.estore.service.persistence.impl.DevicePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author wz
 * @see DevicePersistence
 * @generated
 */
public class DeviceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Device device) {
		getPersistence().clearCache(device);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Device> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Device> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Device> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Device> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Device> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Device update(Device device) {
		return getPersistence().update(device);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Device update(Device device, ServiceContext serviceContext) {
		return getPersistence().update(device, serviceContext);
	}

	/**
	 * Returns all the devices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching devices
	 */
	public static List<Device> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Device> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Device> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Device> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Device> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Device> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first device in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public static Device findByUuid_First(
			String uuid, OrderByComparator<Device> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first device in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device, or <code>null</code> if a matching device could not be found
	 */
	public static Device fetchByUuid_First(
		String uuid, OrderByComparator<Device> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last device in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public static Device findByUuid_Last(
			String uuid, OrderByComparator<Device> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last device in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device, or <code>null</code> if a matching device could not be found
	 */
	public static Device fetchByUuid_Last(
		String uuid, OrderByComparator<Device> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the devices before and after the current device in the ordered set where uuid = &#63;.
	 *
	 * @param deviceId the primary key of the current device
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	public static Device[] findByUuid_PrevAndNext(
			long deviceId, String uuid,
			OrderByComparator<Device> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByUuid_PrevAndNext(
			deviceId, uuid, orderByComparator);
	}

	/**
	 * Removes all the devices where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of devices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching devices
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the device where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDeviceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public static Device findByUUID_G(String uuid, long groupId)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the device where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching device, or <code>null</code> if a matching device could not be found
	 */
	public static Device fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the device where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching device, or <code>null</code> if a matching device could not be found
	 */
	public static Device fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the device where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the device that was removed
	 */
	public static Device removeByUUID_G(String uuid, long groupId)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of devices where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching devices
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the devices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching devices
	 */
	public static List<Device> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Device> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Device> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Device> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Device> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Device> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first device in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public static Device findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Device> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first device in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device, or <code>null</code> if a matching device could not be found
	 */
	public static Device fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Device> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last device in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public static Device findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Device> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last device in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device, or <code>null</code> if a matching device could not be found
	 */
	public static Device fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Device> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static Device[] findByUuid_C_PrevAndNext(
			long deviceId, String uuid, long companyId,
			OrderByComparator<Device> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByUuid_C_PrevAndNext(
			deviceId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the devices where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of devices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching devices
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the devices where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching devices
	 */
	public static List<Device> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<Device> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<Device> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Device> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

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
	public static List<Device> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Device> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first device in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public static Device findByGroupId_First(
			long groupId, OrderByComparator<Device> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first device in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device, or <code>null</code> if a matching device could not be found
	 */
	public static Device fetchByGroupId_First(
		long groupId, OrderByComparator<Device> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last device in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public static Device findByGroupId_Last(
			long groupId, OrderByComparator<Device> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last device in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device, or <code>null</code> if a matching device could not be found
	 */
	public static Device fetchByGroupId_Last(
		long groupId, OrderByComparator<Device> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the devices before and after the current device in the ordered set where groupId = &#63;.
	 *
	 * @param deviceId the primary key of the current device
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	public static Device[] findByGroupId_PrevAndNext(
			long deviceId, long groupId,
			OrderByComparator<Device> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByGroupId_PrevAndNext(
			deviceId, groupId, orderByComparator);
	}

	/**
	 * Removes all the devices where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of devices where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching devices
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the device where groupId = &#63; and name = &#63; or throws a <code>NoSuchDeviceException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public static Device findByName(long groupId, String name)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByName(groupId, name);
	}

	/**
	 * Returns the device where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching device, or <code>null</code> if a matching device could not be found
	 */
	public static Device fetchByName(long groupId, String name) {
		return getPersistence().fetchByName(groupId, name);
	}

	/**
	 * Returns the device where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching device, or <code>null</code> if a matching device could not be found
	 */
	public static Device fetchByName(
		long groupId, String name, boolean useFinderCache) {

		return getPersistence().fetchByName(groupId, name, useFinderCache);
	}

	/**
	 * Removes the device where groupId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the device that was removed
	 */
	public static Device removeByName(long groupId, String name)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().removeByName(groupId, name);
	}

	/**
	 * Returns the number of devices where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching devices
	 */
	public static int countByName(long groupId, String name) {
		return getPersistence().countByName(groupId, name);
	}

	/**
	 * Returns all the devices where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @return the matching devices
	 */
	public static List<Device> findByDeviceType(
		long groupId, long deviceTypeId) {

		return getPersistence().findByDeviceType(groupId, deviceTypeId);
	}

	/**
	 * Returns a range of all the devices where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @return the range of matching devices
	 */
	public static List<Device> findByDeviceType(
		long groupId, long deviceTypeId, int start, int end) {

		return getPersistence().findByDeviceType(
			groupId, deviceTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the devices where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching devices
	 */
	public static List<Device> findByDeviceType(
		long groupId, long deviceTypeId, int start, int end,
		OrderByComparator<Device> orderByComparator) {

		return getPersistence().findByDeviceType(
			groupId, deviceTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the devices where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching devices
	 */
	public static List<Device> findByDeviceType(
		long groupId, long deviceTypeId, int start, int end,
		OrderByComparator<Device> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDeviceType(
			groupId, deviceTypeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first device in the ordered set where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public static Device findByDeviceType_First(
			long groupId, long deviceTypeId,
			OrderByComparator<Device> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByDeviceType_First(
			groupId, deviceTypeId, orderByComparator);
	}

	/**
	 * Returns the first device in the ordered set where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device, or <code>null</code> if a matching device could not be found
	 */
	public static Device fetchByDeviceType_First(
		long groupId, long deviceTypeId,
		OrderByComparator<Device> orderByComparator) {

		return getPersistence().fetchByDeviceType_First(
			groupId, deviceTypeId, orderByComparator);
	}

	/**
	 * Returns the last device in the ordered set where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	public static Device findByDeviceType_Last(
			long groupId, long deviceTypeId,
			OrderByComparator<Device> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByDeviceType_Last(
			groupId, deviceTypeId, orderByComparator);
	}

	/**
	 * Returns the last device in the ordered set where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device, or <code>null</code> if a matching device could not be found
	 */
	public static Device fetchByDeviceType_Last(
		long groupId, long deviceTypeId,
		OrderByComparator<Device> orderByComparator) {

		return getPersistence().fetchByDeviceType_Last(
			groupId, deviceTypeId, orderByComparator);
	}

	/**
	 * Returns the devices before and after the current device in the ordered set where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * @param deviceId the primary key of the current device
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	public static Device[] findByDeviceType_PrevAndNext(
			long deviceId, long groupId, long deviceTypeId,
			OrderByComparator<Device> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByDeviceType_PrevAndNext(
			deviceId, groupId, deviceTypeId, orderByComparator);
	}

	/**
	 * Removes all the devices where groupId = &#63; and deviceTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 */
	public static void removeByDeviceType(long groupId, long deviceTypeId) {
		getPersistence().removeByDeviceType(groupId, deviceTypeId);
	}

	/**
	 * Returns the number of devices where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @return the number of matching devices
	 */
	public static int countByDeviceType(long groupId, long deviceTypeId) {
		return getPersistence().countByDeviceType(groupId, deviceTypeId);
	}

	/**
	 * Caches the device in the entity cache if it is enabled.
	 *
	 * @param device the device
	 */
	public static void cacheResult(Device device) {
		getPersistence().cacheResult(device);
	}

	/**
	 * Caches the devices in the entity cache if it is enabled.
	 *
	 * @param devices the devices
	 */
	public static void cacheResult(List<Device> devices) {
		getPersistence().cacheResult(devices);
	}

	/**
	 * Creates a new device with the primary key. Does not add the device to the database.
	 *
	 * @param deviceId the primary key for the new device
	 * @return the new device
	 */
	public static Device create(long deviceId) {
		return getPersistence().create(deviceId);
	}

	/**
	 * Removes the device with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deviceId the primary key of the device
	 * @return the device that was removed
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	public static Device remove(long deviceId)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().remove(deviceId);
	}

	public static Device updateImpl(Device device) {
		return getPersistence().updateImpl(device);
	}

	/**
	 * Returns the device with the primary key or throws a <code>NoSuchDeviceException</code> if it could not be found.
	 *
	 * @param deviceId the primary key of the device
	 * @return the device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	public static Device findByPrimaryKey(long deviceId)
		throws com.wz.testtask.estore.exception.NoSuchDeviceException {

		return getPersistence().findByPrimaryKey(deviceId);
	}

	/**
	 * Returns the device with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deviceId the primary key of the device
	 * @return the device, or <code>null</code> if a device with the primary key could not be found
	 */
	public static Device fetchByPrimaryKey(long deviceId) {
		return getPersistence().fetchByPrimaryKey(deviceId);
	}

	/**
	 * Returns all the devices.
	 *
	 * @return the devices
	 */
	public static List<Device> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Device> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Device> findAll(
		int start, int end, OrderByComparator<Device> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Device> findAll(
		int start, int end, OrderByComparator<Device> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the devices from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of devices.
	 *
	 * @return the number of devices
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DevicePersistence getPersistence() {
		return _persistence;
	}

	private static volatile DevicePersistence _persistence;

}