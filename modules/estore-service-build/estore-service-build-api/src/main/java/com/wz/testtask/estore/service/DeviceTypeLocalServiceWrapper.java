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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DeviceTypeLocalService}.
 *
 * @author wz
 * @see DeviceTypeLocalService
 * @generated
 */
public class DeviceTypeLocalServiceWrapper
	implements DeviceTypeLocalService, ServiceWrapper<DeviceTypeLocalService> {

	public DeviceTypeLocalServiceWrapper(
		DeviceTypeLocalService deviceTypeLocalService) {

		_deviceTypeLocalService = deviceTypeLocalService;
	}

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
	@Override
	public com.wz.testtask.estore.model.DeviceType addDeviceType(
		com.wz.testtask.estore.model.DeviceType deviceType) {

		return _deviceTypeLocalService.addDeviceType(deviceType);
	}

	@Override
	public com.wz.testtask.estore.model.DeviceType addDeviceType(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceTypeLocalService.addDeviceType(name, serviceContext);
	}

	@Override
	public void addEmployeeDeviceType(
		long employeeId, com.wz.testtask.estore.model.DeviceType deviceType) {

		_deviceTypeLocalService.addEmployeeDeviceType(employeeId, deviceType);
	}

	@Override
	public void addEmployeeDeviceType(long employeeId, long deviceTypeId) {
		_deviceTypeLocalService.addEmployeeDeviceType(employeeId, deviceTypeId);
	}

	@Override
	public void addEmployeeDeviceTypes(
		long employeeId,
		java.util.List<com.wz.testtask.estore.model.DeviceType> deviceTypes) {

		_deviceTypeLocalService.addEmployeeDeviceTypes(employeeId, deviceTypes);
	}

	@Override
	public void addEmployeeDeviceTypes(long employeeId, long[] deviceTypeIds) {
		_deviceTypeLocalService.addEmployeeDeviceTypes(
			employeeId, deviceTypeIds);
	}

	@Override
	public void clearEmployeeDeviceTypes(long employeeId) {
		_deviceTypeLocalService.clearEmployeeDeviceTypes(employeeId);
	}

	/**
	 * Creates a new device type with the primary key. Does not add the device type to the database.
	 *
	 * @param deviceTypeId the primary key for the new device type
	 * @return the new device type
	 */
	@Override
	public com.wz.testtask.estore.model.DeviceType createDeviceType(
		long deviceTypeId) {

		return _deviceTypeLocalService.createDeviceType(deviceTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public com.wz.testtask.estore.model.DeviceType delete(
			com.wz.testtask.estore.model.DeviceType deviceType)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceTypeLocalService.delete(deviceType);
	}

	@Override
	public com.wz.testtask.estore.model.DeviceType deleteById(
			long purchaseTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceTypeLocalService.deleteById(purchaseTypeId);
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
	@Override
	public com.wz.testtask.estore.model.DeviceType deleteDeviceType(
		com.wz.testtask.estore.model.DeviceType deviceType) {

		return _deviceTypeLocalService.deleteDeviceType(deviceType);
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
	@Override
	public com.wz.testtask.estore.model.DeviceType deleteDeviceType(
			long deviceTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceTypeLocalService.deleteDeviceType(deviceTypeId);
	}

	@Override
	public void deleteEmployeeDeviceType(
		long employeeId, com.wz.testtask.estore.model.DeviceType deviceType) {

		_deviceTypeLocalService.deleteEmployeeDeviceType(
			employeeId, deviceType);
	}

	@Override
	public void deleteEmployeeDeviceType(long employeeId, long deviceTypeId) {
		_deviceTypeLocalService.deleteEmployeeDeviceType(
			employeeId, deviceTypeId);
	}

	@Override
	public void deleteEmployeeDeviceTypes(
		long employeeId,
		java.util.List<com.wz.testtask.estore.model.DeviceType> deviceTypes) {

		_deviceTypeLocalService.deleteEmployeeDeviceTypes(
			employeeId, deviceTypes);
	}

	@Override
	public void deleteEmployeeDeviceTypes(
		long employeeId, long[] deviceTypeIds) {

		_deviceTypeLocalService.deleteEmployeeDeviceTypes(
			employeeId, deviceTypeIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _deviceTypeLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _deviceTypeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _deviceTypeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _deviceTypeLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _deviceTypeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _deviceTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.wz.testtask.estore.model.DeviceType fetchDeviceType(
		long deviceTypeId) {

		return _deviceTypeLocalService.fetchDeviceType(deviceTypeId);
	}

	/**
	 * Returns the device type matching the UUID and group.
	 *
	 * @param uuid the device type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching device type, or <code>null</code> if a matching device type could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.DeviceType
		fetchDeviceTypeByUuidAndGroupId(String uuid, long groupId) {

		return _deviceTypeLocalService.fetchDeviceTypeByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _deviceTypeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the device type with the primary key.
	 *
	 * @param deviceTypeId the primary key of the device type
	 * @return the device type
	 * @throws PortalException if a device type with the primary key could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.DeviceType getDeviceType(
			long deviceTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceTypeLocalService.getDeviceType(deviceTypeId);
	}

	/**
	 * Returns the device type matching the UUID and group.
	 *
	 * @param uuid the device type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching device type
	 * @throws PortalException if a matching device type could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.DeviceType
			getDeviceTypeByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceTypeLocalService.getDeviceTypeByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.wz.testtask.estore.model.DeviceType>
		getDeviceTypes(int start, int end) {

		return _deviceTypeLocalService.getDeviceTypes(start, end);
	}

	/**
	 * Returns all the device types matching the UUID and company.
	 *
	 * @param uuid the UUID of the device types
	 * @param companyId the primary key of the company
	 * @return the matching device types, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.wz.testtask.estore.model.DeviceType>
		getDeviceTypesByUuidAndCompanyId(String uuid, long companyId) {

		return _deviceTypeLocalService.getDeviceTypesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.wz.testtask.estore.model.DeviceType>
		getDeviceTypesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.wz.testtask.estore.model.DeviceType> orderByComparator) {

		return _deviceTypeLocalService.getDeviceTypesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of device types.
	 *
	 * @return the number of device types
	 */
	@Override
	public int getDeviceTypesCount() {
		return _deviceTypeLocalService.getDeviceTypesCount();
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.DeviceType>
		getEmployeeDeviceTypes(long employeeId) {

		return _deviceTypeLocalService.getEmployeeDeviceTypes(employeeId);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.DeviceType>
		getEmployeeDeviceTypes(long employeeId, int start, int end) {

		return _deviceTypeLocalService.getEmployeeDeviceTypes(
			employeeId, start, end);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.DeviceType>
		getEmployeeDeviceTypes(
			long employeeId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.wz.testtask.estore.model.DeviceType> orderByComparator) {

		return _deviceTypeLocalService.getEmployeeDeviceTypes(
			employeeId, start, end, orderByComparator);
	}

	@Override
	public int getEmployeeDeviceTypesCount(long employeeId) {
		return _deviceTypeLocalService.getEmployeeDeviceTypesCount(employeeId);
	}

	/**
	 * Returns the employeeIds of the employees associated with the device type.
	 *
	 * @param deviceTypeId the deviceTypeId of the device type
	 * @return long[] the employeeIds of employees associated with the device type
	 */
	@Override
	public long[] getEmployeePrimaryKeys(long deviceTypeId) {
		return _deviceTypeLocalService.getEmployeePrimaryKeys(deviceTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _deviceTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _deviceTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.DeviceType>
		getPurchaseTypes(long groupId) {

		return _deviceTypeLocalService.getPurchaseTypes(groupId);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.DeviceType>
		getPurchaseTypes(long groupId, int start, int end) {

		return _deviceTypeLocalService.getPurchaseTypes(groupId, start, end);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.DeviceType>
		getPurchaseTypes(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.wz.testtask.estore.model.DeviceType> obc) {

		return _deviceTypeLocalService.getPurchaseTypes(
			groupId, start, end, obc);
	}

	@Override
	public int getPurchaseTypesCount(long groupId) {
		return _deviceTypeLocalService.getPurchaseTypesCount(groupId);
	}

	@Override
	public boolean hasEmployeeDeviceType(long employeeId, long deviceTypeId) {
		return _deviceTypeLocalService.hasEmployeeDeviceType(
			employeeId, deviceTypeId);
	}

	@Override
	public boolean hasEmployeeDeviceTypes(long employeeId) {
		return _deviceTypeLocalService.hasEmployeeDeviceTypes(employeeId);
	}

	@Override
	public void setEmployeeDeviceTypes(long employeeId, long[] deviceTypeIds) {
		_deviceTypeLocalService.setEmployeeDeviceTypes(
			employeeId, deviceTypeIds);
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
	@Override
	public com.wz.testtask.estore.model.DeviceType updateDeviceType(
		com.wz.testtask.estore.model.DeviceType deviceType) {

		return _deviceTypeLocalService.updateDeviceType(deviceType);
	}

	@Override
	public com.wz.testtask.estore.model.DeviceType updatePurchaseType(
			long deviceTypeId, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceTypeLocalService.updatePurchaseType(
			deviceTypeId, name, serviceContext);
	}

	@Override
	public DeviceTypeLocalService getWrappedService() {
		return _deviceTypeLocalService;
	}

	@Override
	public void setWrappedService(
		DeviceTypeLocalService deviceTypeLocalService) {

		_deviceTypeLocalService = deviceTypeLocalService;
	}

	private DeviceTypeLocalService _deviceTypeLocalService;

}