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

import com.wz.testtask.estore.model.DeviceType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the device type service. This utility wraps <code>com.wz.testtask.estore.service.persistence.impl.DeviceTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author wz
 * @see DeviceTypePersistence
 * @generated
 */
public class DeviceTypeUtil {

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
	public static void clearCache(DeviceType deviceType) {
		getPersistence().clearCache(deviceType);
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
	public static Map<Serializable, DeviceType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DeviceType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DeviceType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DeviceType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DeviceType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DeviceType update(DeviceType deviceType) {
		return getPersistence().update(deviceType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DeviceType update(
		DeviceType deviceType, ServiceContext serviceContext) {

		return getPersistence().update(deviceType, serviceContext);
	}

	/**
	 * Returns all the device types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching device types
	 */
	public static List<DeviceType> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<DeviceType> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<DeviceType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DeviceType> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<DeviceType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DeviceType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first device type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	public static DeviceType findByUuid_First(
			String uuid, OrderByComparator<DeviceType> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceTypeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first device type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public static DeviceType fetchByUuid_First(
		String uuid, OrderByComparator<DeviceType> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last device type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	public static DeviceType findByUuid_Last(
			String uuid, OrderByComparator<DeviceType> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceTypeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last device type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public static DeviceType fetchByUuid_Last(
		String uuid, OrderByComparator<DeviceType> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the device types before and after the current device type in the ordered set where uuid = &#63;.
	 *
	 * @param deviceTypeId the primary key of the current device type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device type
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	public static DeviceType[] findByUuid_PrevAndNext(
			long deviceTypeId, String uuid,
			OrderByComparator<DeviceType> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceTypeException {

		return getPersistence().findByUuid_PrevAndNext(
			deviceTypeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the device types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of device types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching device types
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the device type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDeviceTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	public static DeviceType findByUUID_G(String uuid, long groupId)
		throws com.wz.testtask.estore.exception.NoSuchDeviceTypeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the device type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public static DeviceType fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the device type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public static DeviceType fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the device type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the device type that was removed
	 */
	public static DeviceType removeByUUID_G(String uuid, long groupId)
		throws com.wz.testtask.estore.exception.NoSuchDeviceTypeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of device types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching device types
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the device types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching device types
	 */
	public static List<DeviceType> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<DeviceType> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<DeviceType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DeviceType> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<DeviceType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DeviceType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first device type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	public static DeviceType findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DeviceType> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceTypeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first device type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public static DeviceType fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DeviceType> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last device type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	public static DeviceType findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DeviceType> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceTypeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last device type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public static DeviceType fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DeviceType> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static DeviceType[] findByUuid_C_PrevAndNext(
			long deviceTypeId, String uuid, long companyId,
			OrderByComparator<DeviceType> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceTypeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			deviceTypeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the device types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of device types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching device types
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the device types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching device types
	 */
	public static List<DeviceType> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<DeviceType> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<DeviceType> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DeviceType> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

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
	public static List<DeviceType> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DeviceType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first device type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	public static DeviceType findByGroupId_First(
			long groupId, OrderByComparator<DeviceType> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceTypeException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first device type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public static DeviceType fetchByGroupId_First(
		long groupId, OrderByComparator<DeviceType> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last device type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	public static DeviceType findByGroupId_Last(
			long groupId, OrderByComparator<DeviceType> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceTypeException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last device type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public static DeviceType fetchByGroupId_Last(
		long groupId, OrderByComparator<DeviceType> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the device types before and after the current device type in the ordered set where groupId = &#63;.
	 *
	 * @param deviceTypeId the primary key of the current device type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device type
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	public static DeviceType[] findByGroupId_PrevAndNext(
			long deviceTypeId, long groupId,
			OrderByComparator<DeviceType> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchDeviceTypeException {

		return getPersistence().findByGroupId_PrevAndNext(
			deviceTypeId, groupId, orderByComparator);
	}

	/**
	 * Removes all the device types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of device types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching device types
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the device type in the entity cache if it is enabled.
	 *
	 * @param deviceType the device type
	 */
	public static void cacheResult(DeviceType deviceType) {
		getPersistence().cacheResult(deviceType);
	}

	/**
	 * Caches the device types in the entity cache if it is enabled.
	 *
	 * @param deviceTypes the device types
	 */
	public static void cacheResult(List<DeviceType> deviceTypes) {
		getPersistence().cacheResult(deviceTypes);
	}

	/**
	 * Creates a new device type with the primary key. Does not add the device type to the database.
	 *
	 * @param deviceTypeId the primary key for the new device type
	 * @return the new device type
	 */
	public static DeviceType create(long deviceTypeId) {
		return getPersistence().create(deviceTypeId);
	}

	/**
	 * Removes the device type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deviceTypeId the primary key of the device type
	 * @return the device type that was removed
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	public static DeviceType remove(long deviceTypeId)
		throws com.wz.testtask.estore.exception.NoSuchDeviceTypeException {

		return getPersistence().remove(deviceTypeId);
	}

	public static DeviceType updateImpl(DeviceType deviceType) {
		return getPersistence().updateImpl(deviceType);
	}

	/**
	 * Returns the device type with the primary key or throws a <code>NoSuchDeviceTypeException</code> if it could not be found.
	 *
	 * @param deviceTypeId the primary key of the device type
	 * @return the device type
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	public static DeviceType findByPrimaryKey(long deviceTypeId)
		throws com.wz.testtask.estore.exception.NoSuchDeviceTypeException {

		return getPersistence().findByPrimaryKey(deviceTypeId);
	}

	/**
	 * Returns the device type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deviceTypeId the primary key of the device type
	 * @return the device type, or <code>null</code> if a device type with the primary key could not be found
	 */
	public static DeviceType fetchByPrimaryKey(long deviceTypeId) {
		return getPersistence().fetchByPrimaryKey(deviceTypeId);
	}

	/**
	 * Returns all the device types.
	 *
	 * @return the device types
	 */
	public static List<DeviceType> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<DeviceType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<DeviceType> findAll(
		int start, int end, OrderByComparator<DeviceType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<DeviceType> findAll(
		int start, int end, OrderByComparator<DeviceType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the device types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of device types.
	 *
	 * @return the number of device types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of employees associated with the device type.
	 *
	 * @param pk the primary key of the device type
	 * @return long[] of the primaryKeys of employees associated with the device type
	 */
	public static long[] getEmployeePrimaryKeys(long pk) {
		return getPersistence().getEmployeePrimaryKeys(pk);
	}

	/**
	 * Returns all the device type associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @return the device types associated with the employee
	 */
	public static List<DeviceType> getEmployeeDeviceTypes(long pk) {
		return getPersistence().getEmployeeDeviceTypes(pk);
	}

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
	public static List<DeviceType> getEmployeeDeviceTypes(
		long pk, int start, int end) {

		return getPersistence().getEmployeeDeviceTypes(pk, start, end);
	}

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
	public static List<DeviceType> getEmployeeDeviceTypes(
		long pk, int start, int end,
		OrderByComparator<DeviceType> orderByComparator) {

		return getPersistence().getEmployeeDeviceTypes(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employees associated with the device type.
	 *
	 * @param pk the primary key of the device type
	 * @return the number of employees associated with the device type
	 */
	public static int getEmployeesSize(long pk) {
		return getPersistence().getEmployeesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the employee is associated with the device type.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePK the primary key of the employee
	 * @return <code>true</code> if the employee is associated with the device type; <code>false</code> otherwise
	 */
	public static boolean containsEmployee(long pk, long employeePK) {
		return getPersistence().containsEmployee(pk, employeePK);
	}

	/**
	 * Returns <code>true</code> if the device type has any employees associated with it.
	 *
	 * @param pk the primary key of the device type to check for associations with employees
	 * @return <code>true</code> if the device type has any employees associated with it; <code>false</code> otherwise
	 */
	public static boolean containsEmployees(long pk) {
		return getPersistence().containsEmployees(pk);
	}

	/**
	 * Adds an association between the device type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePK the primary key of the employee
	 */
	public static void addEmployee(long pk, long employeePK) {
		getPersistence().addEmployee(pk, employeePK);
	}

	/**
	 * Adds an association between the device type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employee the employee
	 */
	public static void addEmployee(
		long pk, com.wz.testtask.estore.model.Employee employee) {

		getPersistence().addEmployee(pk, employee);
	}

	/**
	 * Adds an association between the device type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePKs the primary keys of the employees
	 */
	public static void addEmployees(long pk, long[] employeePKs) {
		getPersistence().addEmployees(pk, employeePKs);
	}

	/**
	 * Adds an association between the device type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employees the employees
	 */
	public static void addEmployees(
		long pk, List<com.wz.testtask.estore.model.Employee> employees) {

		getPersistence().addEmployees(pk, employees);
	}

	/**
	 * Clears all associations between the device type and its employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type to clear the associated employees from
	 */
	public static void clearEmployees(long pk) {
		getPersistence().clearEmployees(pk);
	}

	/**
	 * Removes the association between the device type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePK the primary key of the employee
	 */
	public static void removeEmployee(long pk, long employeePK) {
		getPersistence().removeEmployee(pk, employeePK);
	}

	/**
	 * Removes the association between the device type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employee the employee
	 */
	public static void removeEmployee(
		long pk, com.wz.testtask.estore.model.Employee employee) {

		getPersistence().removeEmployee(pk, employee);
	}

	/**
	 * Removes the association between the device type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePKs the primary keys of the employees
	 */
	public static void removeEmployees(long pk, long[] employeePKs) {
		getPersistence().removeEmployees(pk, employeePKs);
	}

	/**
	 * Removes the association between the device type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employees the employees
	 */
	public static void removeEmployees(
		long pk, List<com.wz.testtask.estore.model.Employee> employees) {

		getPersistence().removeEmployees(pk, employees);
	}

	/**
	 * Sets the employees associated with the device type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePKs the primary keys of the employees to be associated with the device type
	 */
	public static void setEmployees(long pk, long[] employeePKs) {
		getPersistence().setEmployees(pk, employeePKs);
	}

	/**
	 * Sets the employees associated with the device type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employees the employees to be associated with the device type
	 */
	public static void setEmployees(
		long pk, List<com.wz.testtask.estore.model.Employee> employees) {

		getPersistence().setEmployees(pk, employees);
	}

	public static DeviceTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile DeviceTypePersistence _persistence;

}