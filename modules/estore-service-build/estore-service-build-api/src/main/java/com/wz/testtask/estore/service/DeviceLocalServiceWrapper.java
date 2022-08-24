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
 * Provides a wrapper for {@link DeviceLocalService}.
 *
 * @author wz
 * @see DeviceLocalService
 * @generated
 */
public class DeviceLocalServiceWrapper
	implements DeviceLocalService, ServiceWrapper<DeviceLocalService> {

	public DeviceLocalServiceWrapper(DeviceLocalService deviceLocalService) {
		_deviceLocalService = deviceLocalService;
	}

	/**
	 * Adds the device to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeviceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param device the device
	 * @return the device that was added
	 */
	@Override
	public com.wz.testtask.estore.model.Device addDevice(
		com.wz.testtask.estore.model.Device device) {

		return _deviceLocalService.addDevice(device);
	}

	/**
	 * Creates new record of device
	 *
	 * @param name
	 * @param price
	 * @param deviceTypeId
	 * @param count
	 * @param inStock
	 * @param archive
	 * @param description
	 * @param serviceContext
	 * @return
	 * @throws PortalException if device type with given id does not exist or when validation fails
	 */
	@Override
	public com.wz.testtask.estore.model.Device addDevice(
			String name, long price, long deviceTypeId, int count,
			boolean inStock, boolean archive, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceLocalService.addDevice(
			name, price, deviceTypeId, count, inStock, archive, description,
			serviceContext);
	}

	/**
	 * Creates new record of device, set inStock state true if count is greater than 0
	 *
	 * @param name
	 * @param price
	 * @param deviceTypeId
	 * @param count
	 * @param archive
	 * @param description
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	@Override
	public com.wz.testtask.estore.model.Device addDevice(
			String name, long price, long deviceTypeId, int count,
			boolean archive, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceLocalService.addDevice(
			name, price, deviceTypeId, count, archive, description,
			serviceContext);
	}

	/**
	 * Creates a new device with the primary key. Does not add the device to the database.
	 *
	 * @param deviceId the primary key for the new device
	 * @return the new device
	 */
	@Override
	public com.wz.testtask.estore.model.Device createDevice(long deviceId) {
		return _deviceLocalService.createDevice(deviceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public com.wz.testtask.estore.model.Device delete(
			com.wz.testtask.estore.model.Device device,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceLocalService.delete(device, serviceContext);
	}

	@Override
	public com.wz.testtask.estore.model.Device deleteById(
			long deviceId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceLocalService.deleteById(deviceId, serviceContext);
	}

	/**
	 * Deletes the device from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeviceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param device the device
	 * @return the device that was removed
	 */
	@Override
	public com.wz.testtask.estore.model.Device deleteDevice(
		com.wz.testtask.estore.model.Device device) {

		return _deviceLocalService.deleteDevice(device);
	}

	/**
	 * Deletes the device with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeviceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deviceId the primary key of the device
	 * @return the device that was removed
	 * @throws PortalException if a device with the primary key could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.Device deleteDevice(long deviceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceLocalService.deleteDevice(deviceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _deviceLocalService.dynamicQuery();
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

		return _deviceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.DeviceModelImpl</code>.
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

		return _deviceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.DeviceModelImpl</code>.
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

		return _deviceLocalService.dynamicQuery(
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

		return _deviceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _deviceLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.wz.testtask.estore.model.Device fetchDevice(long deviceId) {
		return _deviceLocalService.fetchDevice(deviceId);
	}

	/**
	 * Returns the device matching the UUID and group.
	 *
	 * @param uuid the device's UUID
	 * @param groupId the primary key of the group
	 * @return the matching device, or <code>null</code> if a matching device could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.Device fetchDeviceByUuidAndGroupId(
		String uuid, long groupId) {

		return _deviceLocalService.fetchDeviceByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _deviceLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the device with the primary key.
	 *
	 * @param deviceId the primary key of the device
	 * @return the device
	 * @throws PortalException if a device with the primary key could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.Device getDevice(long deviceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceLocalService.getDevice(deviceId);
	}

	/**
	 * Returns the device matching the UUID and group.
	 *
	 * @param uuid the device's UUID
	 * @param groupId the primary key of the group
	 * @return the matching device
	 * @throws PortalException if a matching device could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.Device getDeviceByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceLocalService.getDeviceByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the devices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @return the range of devices
	 */
	@Override
	public java.util.List<com.wz.testtask.estore.model.Device> getDevices(
		int start, int end) {

		return _deviceLocalService.getDevices(start, end);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Device> getDevices(
		long groupId) {

		return _deviceLocalService.getDevices(groupId);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Device> getDevices(
		long groupId, int start, int end) {

		return _deviceLocalService.getDevices(groupId, start, end);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Device> getDevices(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.wz.testtask.estore.model.Device> obc) {

		return _deviceLocalService.getDevices(groupId, start, end, obc);
	}

	/**
	 * Returns all the devices matching the UUID and company.
	 *
	 * @param uuid the UUID of the devices
	 * @param companyId the primary key of the company
	 * @return the matching devices, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.wz.testtask.estore.model.Device>
		getDevicesByUuidAndCompanyId(String uuid, long companyId) {

		return _deviceLocalService.getDevicesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of devices matching the UUID and company.
	 *
	 * @param uuid the UUID of the devices
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching devices, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.wz.testtask.estore.model.Device>
		getDevicesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.wz.testtask.estore.model.Device> orderByComparator) {

		return _deviceLocalService.getDevicesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of devices.
	 *
	 * @return the number of devices
	 */
	@Override
	public int getDevicesCount() {
		return _deviceLocalService.getDevicesCount();
	}

	@Override
	public int getDevicesCount(long groupId) {
		return _deviceLocalService.getDevicesCount(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _deviceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _deviceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Sets device's archived state.
	 *
	 * @param deviceId       - device Id
	 * @param archive        - archived state false - not archived, true - archived
	 * @param serviceContext - service context
	 * @return updated device
	 * @throws PortalException if device with given id does not exist
	 */
	@Override
	public com.wz.testtask.estore.model.Device setArchiveState(
			long deviceId, boolean archive,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceLocalService.setArchiveState(
			deviceId, archive, serviceContext);
	}

	/**
	 * Updates the device in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeviceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param device the device
	 * @return the device that was updated
	 */
	@Override
	public com.wz.testtask.estore.model.Device updateDevice(
		com.wz.testtask.estore.model.Device device) {

		return _deviceLocalService.updateDevice(device);
	}

	/**
	 * @param deviceId
	 * @param name
	 * @param price
	 * @param deviceTypeId
	 * @param count
	 * @param inStock
	 * @param archive
	 * @param description
	 * @param serviceContext
	 * @return
	 * @throws PortalException if device or device type with given id does not exist
	 */
	@Override
	public com.wz.testtask.estore.model.Device updateDevice(
			long deviceId, String name, long price, long deviceTypeId,
			int count, boolean inStock, boolean archive, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceLocalService.updateDevice(
			deviceId, name, price, deviceTypeId, count, inStock, archive,
			description, serviceContext);
	}

	@Override
	public com.wz.testtask.estore.model.Device updateDevice(
			long deviceId, String name, long price, long deviceTypeId,
			int count, boolean archive, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deviceLocalService.updateDevice(
			deviceId, name, price, deviceTypeId, count, archive, description,
			serviceContext);
	}

	@Override
	public DeviceLocalService getWrappedService() {
		return _deviceLocalService;
	}

	@Override
	public void setWrappedService(DeviceLocalService deviceLocalService) {
		_deviceLocalService = deviceLocalService;
	}

	private DeviceLocalService _deviceLocalService;

}