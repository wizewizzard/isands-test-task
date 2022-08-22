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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.wz.testtask.estore.model.Device;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Device. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author wz
 * @see DeviceLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DeviceLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.wz.testtask.estore.service.impl.DeviceLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the device local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DeviceLocalServiceUtil} if injection and service tracking are not available.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	public Device addDevice(Device device);

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
	public Device addDevice(
			String name, long price, long deviceTypeId, int count,
			boolean inStock, boolean archive, String description,
			ServiceContext serviceContext)
		throws PortalException;

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
	public Device addDevice(
			String name, long price, long deviceTypeId, int count,
			boolean archive, String description, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Creates a new device with the primary key. Does not add the device to the database.
	 *
	 * @param deviceId the primary key for the new device
	 * @return the new device
	 */
	@Transactional(enabled = false)
	public Device createDevice(long deviceId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public Device delete(Device device, ServiceContext serviceContext)
		throws PortalException;

	public Device deleteById(long deviceId, ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public Device deleteDevice(Device device);

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
	@Indexable(type = IndexableType.DELETE)
	public Device deleteDevice(long deviceId) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Device fetchDevice(long deviceId);

	/**
	 * Returns the device matching the UUID and group.
	 *
	 * @param uuid the device's UUID
	 * @param groupId the primary key of the group
	 * @return the matching device, or <code>null</code> if a matching device could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Device fetchDeviceByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the device with the primary key.
	 *
	 * @param deviceId the primary key of the device
	 * @return the device
	 * @throws PortalException if a device with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Device getDevice(long deviceId) throws PortalException;

	/**
	 * Returns the device matching the UUID and group.
	 *
	 * @param uuid the device's UUID
	 * @param groupId the primary key of the group
	 * @return the matching device
	 * @throws PortalException if a matching device could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Device getDeviceByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Device> getDevices(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Device> getDevices(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Device> getDevices(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Device> getDevices(
		long groupId, int start, int end, OrderByComparator<Device> obc);

	/**
	 * Returns all the devices matching the UUID and company.
	 *
	 * @param uuid the UUID of the devices
	 * @param companyId the primary key of the company
	 * @return the matching devices, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Device> getDevicesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Device> getDevicesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Device> orderByComparator);

	/**
	 * Returns the number of devices.
	 *
	 * @return the number of devices
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDevicesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDevicesCount(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Checks if given amount of devices is available to purchase
	 *
	 * @param deviceId       - device id
	 * @param count          - number of devices
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isAvailable(
			long deviceId, int count, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Sets device's archived state.
	 *
	 * @param deviceId       - device Id
	 * @param archive        - archived state false - not archived, true - archived
	 * @param serviceContext - service context
	 * @return updated device
	 * @throws PortalException if device with given id does not exist
	 */
	public Device setArchiveState(
			long deviceId, boolean archive, ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public Device updateDevice(Device device);

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
	public Device updateDevice(
			long deviceId, String name, long price, long deviceTypeId,
			int count, boolean inStock, boolean archive, String description,
			ServiceContext serviceContext)
		throws PortalException;

	public Device updateDevice(
			long deviceId, String name, long price, long deviceTypeId,
			int count, boolean archive, String description,
			ServiceContext serviceContext)
		throws PortalException;

}