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

package com.wz.testtask.estore.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.wz.testtask.estore.model.Device;
import com.wz.testtask.estore.service.DeviceLocalService;
import com.wz.testtask.estore.service.DeviceLocalServiceUtil;
import com.wz.testtask.estore.service.persistence.DevicePersistence;
import com.wz.testtask.estore.service.persistence.DeviceTypePersistence;
import com.wz.testtask.estore.service.persistence.EmployeePersistence;
import com.wz.testtask.estore.service.persistence.EmployeePositionPersistence;
import com.wz.testtask.estore.service.persistence.PurchasePersistence;
import com.wz.testtask.estore.service.persistence.PurchaseTypePersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the device local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.wz.testtask.estore.service.impl.DeviceLocalServiceImpl}.
 * </p>
 *
 * @author wz
 * @see com.wz.testtask.estore.service.impl.DeviceLocalServiceImpl
 * @generated
 */
public abstract class DeviceLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, DeviceLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DeviceLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DeviceLocalServiceUtil</code>.
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
	@Override
	public Device addDevice(Device device) {
		device.setNew(true);

		return devicePersistence.update(device);
	}

	/**
	 * Creates a new device with the primary key. Does not add the device to the database.
	 *
	 * @param deviceId the primary key for the new device
	 * @return the new device
	 */
	@Override
	@Transactional(enabled = false)
	public Device createDevice(long deviceId) {
		return devicePersistence.create(deviceId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Device deleteDevice(long deviceId) throws PortalException {
		return devicePersistence.remove(deviceId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Device deleteDevice(Device device) {
		return devicePersistence.remove(device);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Device.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return devicePersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return devicePersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return devicePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return devicePersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return devicePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Device fetchDevice(long deviceId) {
		return devicePersistence.fetchByPrimaryKey(deviceId);
	}

	/**
	 * Returns the device matching the UUID and group.
	 *
	 * @param uuid the device's UUID
	 * @param groupId the primary key of the group
	 * @return the matching device, or <code>null</code> if a matching device could not be found
	 */
	@Override
	public Device fetchDeviceByUuidAndGroupId(String uuid, long groupId) {
		return devicePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the device with the primary key.
	 *
	 * @param deviceId the primary key of the device
	 * @return the device
	 * @throws PortalException if a device with the primary key could not be found
	 */
	@Override
	public Device getDevice(long deviceId) throws PortalException {
		return devicePersistence.findByPrimaryKey(deviceId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(deviceLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Device.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("deviceId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(deviceLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Device.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("deviceId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(deviceLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Device.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("deviceId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return devicePersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return deviceLocalService.deleteDevice((Device)persistedModel);
	}

	public BasePersistence<Device> getBasePersistence() {
		return devicePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return devicePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the devices matching the UUID and company.
	 *
	 * @param uuid the UUID of the devices
	 * @param companyId the primary key of the company
	 * @return the matching devices, or an empty list if no matches were found
	 */
	@Override
	public List<Device> getDevicesByUuidAndCompanyId(
		String uuid, long companyId) {

		return devicePersistence.findByUuid_C(uuid, companyId);
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
	public List<Device> getDevicesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Device> orderByComparator) {

		return devicePersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public Device getDeviceByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return devicePersistence.findByUUID_G(uuid, groupId);
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
	public List<Device> getDevices(int start, int end) {
		return devicePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of devices.
	 *
	 * @return the number of devices
	 */
	@Override
	public int getDevicesCount() {
		return devicePersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Device updateDevice(Device device) {
		return devicePersistence.update(device);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DeviceLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		deviceLocalService = (DeviceLocalService)aopProxy;

		_setLocalServiceUtilService(deviceLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DeviceLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Device.class;
	}

	protected String getModelClassName() {
		return Device.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = devicePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		DeviceLocalService deviceLocalService) {

		try {
			Field field = DeviceLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, deviceLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected DeviceLocalService deviceLocalService;

	@Reference
	protected DevicePersistence devicePersistence;

	@Reference
	protected DeviceTypePersistence deviceTypePersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected EmployeePositionPersistence employeePositionPersistence;

	@Reference
	protected PurchasePersistence purchasePersistence;

	@Reference
	protected PurchaseTypePersistence purchaseTypePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}