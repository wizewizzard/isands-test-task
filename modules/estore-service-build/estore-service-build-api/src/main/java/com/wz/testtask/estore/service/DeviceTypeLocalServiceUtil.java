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

package com.wz.testtask.estore.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.wz.testtask.estore.model.DeviceType;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DeviceType. This utility wraps
 * <code>com.wz.testtask.estore.service.impl.DeviceTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author wz
 * @see DeviceTypeLocalService
 * @generated
 */
public class DeviceTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.wz.testtask.estore.service.impl.DeviceTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the device type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeviceTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deviceType the device type
	 * @return the device type that was added
	 */
	public static DeviceType addDeviceType(DeviceType deviceType) {
		return getService().addDeviceType(deviceType);
	}

	public static DeviceType addDeviceType(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addDeviceType(name, serviceContext);
	}

	public static void addEmployeeDeviceType(
		long employeeId, DeviceType deviceType) {

		getService().addEmployeeDeviceType(employeeId, deviceType);
	}

	public static void addEmployeeDeviceType(
		long employeeId, long deviceTypeId) {

		getService().addEmployeeDeviceType(employeeId, deviceTypeId);
	}

	public static void addEmployeeDeviceTypes(
		long employeeId, List<DeviceType> deviceTypes) {

		getService().addEmployeeDeviceTypes(employeeId, deviceTypes);
	}

	public static void addEmployeeDeviceTypes(
		long employeeId, long[] deviceTypeIds) {

		getService().addEmployeeDeviceTypes(employeeId, deviceTypeIds);
	}

	public static void clearEmployeeDeviceTypes(long employeeId) {
		getService().clearEmployeeDeviceTypes(employeeId);
	}

	/**
	 * Creates a new device type with the primary key. Does not add the device type to the database.
	 *
	 * @param deviceTypeId the primary key for the new device type
	 * @return the new device type
	 */
	public static DeviceType createDeviceType(long deviceTypeId) {
		return getService().createDeviceType(deviceTypeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static DeviceType delete(DeviceType deviceType)
		throws PortalException {

		return getService().delete(deviceType);
	}

	public static DeviceType deleteById(long purchaseTypeId)
		throws PortalException {

		return getService().deleteById(purchaseTypeId);
	}

	/**
	 * Deletes the device type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeviceTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deviceType the device type
	 * @return the device type that was removed
	 */
	public static DeviceType deleteDeviceType(DeviceType deviceType) {
		return getService().deleteDeviceType(deviceType);
	}

	/**
	 * Deletes the device type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeviceTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deviceTypeId the primary key of the device type
	 * @return the device type that was removed
	 * @throws PortalException if a device type with the primary key could not be found
	 */
	public static DeviceType deleteDeviceType(long deviceTypeId)
		throws PortalException {

		return getService().deleteDeviceType(deviceTypeId);
	}

	public static void deleteEmployeeDeviceType(
		long employeeId, DeviceType deviceType) {

		getService().deleteEmployeeDeviceType(employeeId, deviceType);
	}

	public static void deleteEmployeeDeviceType(
		long employeeId, long deviceTypeId) {

		getService().deleteEmployeeDeviceType(employeeId, deviceTypeId);
	}

	public static void deleteEmployeeDeviceTypes(
		long employeeId, List<DeviceType> deviceTypes) {

		getService().deleteEmployeeDeviceTypes(employeeId, deviceTypes);
	}

	public static void deleteEmployeeDeviceTypes(
		long employeeId, long[] deviceTypeIds) {

		getService().deleteEmployeeDeviceTypes(employeeId, deviceTypeIds);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static DeviceType fetchDeviceType(long deviceTypeId) {
		return getService().fetchDeviceType(deviceTypeId);
	}

	/**
	 * Returns the device type matching the UUID and group.
	 *
	 * @param uuid the device type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching device type, or <code>null</code> if a matching device type could not be found
	 */
	public static DeviceType fetchDeviceTypeByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDeviceTypeByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the device type with the primary key.
	 *
	 * @param deviceTypeId the primary key of the device type
	 * @return the device type
	 * @throws PortalException if a device type with the primary key could not be found
	 */
	public static DeviceType getDeviceType(long deviceTypeId)
		throws PortalException {

		return getService().getDeviceType(deviceTypeId);
	}

	/**
	 * Returns the device type matching the UUID and group.
	 *
	 * @param uuid the device type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching device type
	 * @throws PortalException if a matching device type could not be found
	 */
	public static DeviceType getDeviceTypeByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDeviceTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the device types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @return the range of device types
	 */
	public static List<DeviceType> getDeviceTypes(int start, int end) {
		return getService().getDeviceTypes(start, end);
	}

	/**
	 * Returns all the device types matching the UUID and company.
	 *
	 * @param uuid the UUID of the device types
	 * @param companyId the primary key of the company
	 * @return the matching device types, or an empty list if no matches were found
	 */
	public static List<DeviceType> getDeviceTypesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDeviceTypesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of device types matching the UUID and company.
	 *
	 * @param uuid the UUID of the device types
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching device types, or an empty list if no matches were found
	 */
	public static List<DeviceType> getDeviceTypesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DeviceType> orderByComparator) {

		return getService().getDeviceTypesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of device types.
	 *
	 * @return the number of device types
	 */
	public static int getDeviceTypesCount() {
		return getService().getDeviceTypesCount();
	}

	public static List<DeviceType> getEmployeeDeviceTypes(long employeeId) {
		return getService().getEmployeeDeviceTypes(employeeId);
	}

	public static List<DeviceType> getEmployeeDeviceTypes(
		long employeeId, int start, int end) {

		return getService().getEmployeeDeviceTypes(employeeId, start, end);
	}

	public static List<DeviceType> getEmployeeDeviceTypes(
		long employeeId, int start, int end,
		OrderByComparator<DeviceType> orderByComparator) {

		return getService().getEmployeeDeviceTypes(
			employeeId, start, end, orderByComparator);
	}

	public static int getEmployeeDeviceTypesCount(long employeeId) {
		return getService().getEmployeeDeviceTypesCount(employeeId);
	}

	/**
	 * Returns the employeeIds of the employees associated with the device type.
	 *
	 * @param deviceTypeId the deviceTypeId of the device type
	 * @return long[] the employeeIds of employees associated with the device type
	 */
	public static long[] getEmployeePrimaryKeys(long deviceTypeId) {
		return getService().getEmployeePrimaryKeys(deviceTypeId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static List<DeviceType> getPurchaseTypes(long groupId) {
		return getService().getPurchaseTypes(groupId);
	}

	public static List<DeviceType> getPurchaseTypes(
		long groupId, int start, int end) {

		return getService().getPurchaseTypes(groupId, start, end);
	}

	public static List<DeviceType> getPurchaseTypes(
		long groupId, int start, int end, OrderByComparator<DeviceType> obc) {

		return getService().getPurchaseTypes(groupId, start, end, obc);
	}

	public static int getPurchaseTypesCount(long groupId) {
		return getService().getPurchaseTypesCount(groupId);
	}

	public static boolean hasEmployeeDeviceType(
		long employeeId, long deviceTypeId) {

		return getService().hasEmployeeDeviceType(employeeId, deviceTypeId);
	}

	public static boolean hasEmployeeDeviceTypes(long employeeId) {
		return getService().hasEmployeeDeviceTypes(employeeId);
	}

	public static void setEmployeeDeviceTypes(
		long employeeId, long[] deviceTypeIds) {

		getService().setEmployeeDeviceTypes(employeeId, deviceTypeIds);
	}

	/**
	 * Updates the device type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeviceTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deviceType the device type
	 * @return the device type that was updated
	 */
	public static DeviceType updateDeviceType(DeviceType deviceType) {
		return getService().updateDeviceType(deviceType);
	}

	public static DeviceType updatePurchaseType(
			long deviceTypeId, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updatePurchaseType(
			deviceTypeId, name, serviceContext);
	}

	public static DeviceTypeLocalService getService() {
		return _service;
	}

	private static volatile DeviceTypeLocalService _service;

}