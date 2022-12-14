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

import com.wz.testtask.estore.model.DeviceType;
import com.wz.testtask.estore.service.DeviceTypeLocalService;
import com.wz.testtask.estore.service.DeviceTypeLocalServiceUtil;
import com.wz.testtask.estore.service.persistence.DevicePersistence;
import com.wz.testtask.estore.service.persistence.DeviceTypePersistence;
import com.wz.testtask.estore.service.persistence.EmployeePersistence;
import com.wz.testtask.estore.service.persistence.EmployeePositionPersistence;
import com.wz.testtask.estore.service.persistence.EmployeeWithSummaryFinder;
import com.wz.testtask.estore.service.persistence.PurchasePersistence;
import com.wz.testtask.estore.service.persistence.PurchaseTypePersistence;
import com.wz.testtask.estore.service.persistence.StatisticsHolderFinder;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the device type local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.wz.testtask.estore.service.impl.DeviceTypeLocalServiceImpl}.
 * </p>
 *
 * @author wz
 * @see com.wz.testtask.estore.service.impl.DeviceTypeLocalServiceImpl
 * @generated
 */
public abstract class DeviceTypeLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, DeviceTypeLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DeviceTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DeviceTypeLocalServiceUtil</code>.
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DeviceType addDeviceType(DeviceType deviceType) {
		deviceType.setNew(true);

		return deviceTypePersistence.update(deviceType);
	}

	/**
	 * Creates a new device type with the primary key. Does not add the device type to the database.
	 *
	 * @param deviceTypeId the primary key for the new device type
	 * @return the new device type
	 */
	@Override
	@Transactional(enabled = false)
	public DeviceType createDeviceType(long deviceTypeId) {
		return deviceTypePersistence.create(deviceTypeId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DeviceType deleteDeviceType(long deviceTypeId)
		throws PortalException {

		return deviceTypePersistence.remove(deviceTypeId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DeviceType deleteDeviceType(DeviceType deviceType) {
		return deviceTypePersistence.remove(deviceType);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			DeviceType.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return deviceTypePersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return deviceTypePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return deviceTypePersistence.findWithDynamicQuery(
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
		return deviceTypePersistence.countWithDynamicQuery(dynamicQuery);
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

		return deviceTypePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DeviceType fetchDeviceType(long deviceTypeId) {
		return deviceTypePersistence.fetchByPrimaryKey(deviceTypeId);
	}

	/**
	 * Returns the device type matching the UUID and group.
	 *
	 * @param uuid the device type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching device type, or <code>null</code> if a matching device type could not be found
	 */
	@Override
	public DeviceType fetchDeviceTypeByUuidAndGroupId(
		String uuid, long groupId) {

		return deviceTypePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the device type with the primary key.
	 *
	 * @param deviceTypeId the primary key of the device type
	 * @return the device type
	 * @throws PortalException if a device type with the primary key could not be found
	 */
	@Override
	public DeviceType getDeviceType(long deviceTypeId) throws PortalException {
		return deviceTypePersistence.findByPrimaryKey(deviceTypeId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(deviceTypeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DeviceType.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("deviceTypeId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			deviceTypeLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(DeviceType.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"deviceTypeId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(deviceTypeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DeviceType.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("deviceTypeId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return deviceTypePersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return deviceTypeLocalService.deleteDeviceType(
			(DeviceType)persistedModel);
	}

	public BasePersistence<DeviceType> getBasePersistence() {
		return deviceTypePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return deviceTypePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the device types matching the UUID and company.
	 *
	 * @param uuid the UUID of the device types
	 * @param companyId the primary key of the company
	 * @return the matching device types, or an empty list if no matches were found
	 */
	@Override
	public List<DeviceType> getDeviceTypesByUuidAndCompanyId(
		String uuid, long companyId) {

		return deviceTypePersistence.findByUuid_C(uuid, companyId);
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
	public List<DeviceType> getDeviceTypesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DeviceType> orderByComparator) {

		return deviceTypePersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public DeviceType getDeviceTypeByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return deviceTypePersistence.findByUUID_G(uuid, groupId);
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
	public List<DeviceType> getDeviceTypes(int start, int end) {
		return deviceTypePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of device types.
	 *
	 * @return the number of device types
	 */
	@Override
	public int getDeviceTypesCount() {
		return deviceTypePersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DeviceType updateDeviceType(DeviceType deviceType) {
		return deviceTypePersistence.update(deviceType);
	}

	/**
	 */
	@Override
	public void addEmployeeDeviceType(long employeeId, long deviceTypeId) {
		employeePersistence.addDeviceType(employeeId, deviceTypeId);
	}

	/**
	 */
	@Override
	public void addEmployeeDeviceType(long employeeId, DeviceType deviceType) {
		employeePersistence.addDeviceType(employeeId, deviceType);
	}

	/**
	 */
	@Override
	public void addEmployeeDeviceTypes(long employeeId, long[] deviceTypeIds) {
		employeePersistence.addDeviceTypes(employeeId, deviceTypeIds);
	}

	/**
	 */
	@Override
	public void addEmployeeDeviceTypes(
		long employeeId, List<DeviceType> deviceTypes) {

		employeePersistence.addDeviceTypes(employeeId, deviceTypes);
	}

	/**
	 */
	@Override
	public void clearEmployeeDeviceTypes(long employeeId) {
		employeePersistence.clearDeviceTypes(employeeId);
	}

	/**
	 */
	@Override
	public void deleteEmployeeDeviceType(long employeeId, long deviceTypeId) {
		employeePersistence.removeDeviceType(employeeId, deviceTypeId);
	}

	/**
	 */
	@Override
	public void deleteEmployeeDeviceType(
		long employeeId, DeviceType deviceType) {

		employeePersistence.removeDeviceType(employeeId, deviceType);
	}

	/**
	 */
	@Override
	public void deleteEmployeeDeviceTypes(
		long employeeId, long[] deviceTypeIds) {

		employeePersistence.removeDeviceTypes(employeeId, deviceTypeIds);
	}

	/**
	 */
	@Override
	public void deleteEmployeeDeviceTypes(
		long employeeId, List<DeviceType> deviceTypes) {

		employeePersistence.removeDeviceTypes(employeeId, deviceTypes);
	}

	/**
	 * Returns the employeeIds of the employees associated with the device type.
	 *
	 * @param deviceTypeId the deviceTypeId of the device type
	 * @return long[] the employeeIds of employees associated with the device type
	 */
	@Override
	public long[] getEmployeePrimaryKeys(long deviceTypeId) {
		return deviceTypePersistence.getEmployeePrimaryKeys(deviceTypeId);
	}

	/**
	 */
	@Override
	public List<DeviceType> getEmployeeDeviceTypes(long employeeId) {
		return deviceTypePersistence.getEmployeeDeviceTypes(employeeId);
	}

	/**
	 */
	@Override
	public List<DeviceType> getEmployeeDeviceTypes(
		long employeeId, int start, int end) {

		return deviceTypePersistence.getEmployeeDeviceTypes(
			employeeId, start, end);
	}

	/**
	 */
	@Override
	public List<DeviceType> getEmployeeDeviceTypes(
		long employeeId, int start, int end,
		OrderByComparator<DeviceType> orderByComparator) {

		return deviceTypePersistence.getEmployeeDeviceTypes(
			employeeId, start, end, orderByComparator);
	}

	/**
	 */
	@Override
	public int getEmployeeDeviceTypesCount(long employeeId) {
		return employeePersistence.getDeviceTypesSize(employeeId);
	}

	/**
	 */
	@Override
	public boolean hasEmployeeDeviceType(long employeeId, long deviceTypeId) {
		return employeePersistence.containsDeviceType(employeeId, deviceTypeId);
	}

	/**
	 */
	@Override
	public boolean hasEmployeeDeviceTypes(long employeeId) {
		return employeePersistence.containsDeviceTypes(employeeId);
	}

	/**
	 */
	@Override
	public void setEmployeeDeviceTypes(long employeeId, long[] deviceTypeIds) {
		employeePersistence.setDeviceTypes(employeeId, deviceTypeIds);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DeviceTypeLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		deviceTypeLocalService = (DeviceTypeLocalService)aopProxy;

		_setLocalServiceUtilService(deviceTypeLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DeviceTypeLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DeviceType.class;
	}

	protected String getModelClassName() {
		return DeviceType.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = deviceTypePersistence.getDataSource();

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
		DeviceTypeLocalService deviceTypeLocalService) {

		try {
			Field field = DeviceTypeLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, deviceTypeLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected DevicePersistence devicePersistence;

	protected DeviceTypeLocalService deviceTypeLocalService;

	@Reference
	protected DeviceTypePersistence deviceTypePersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected EmployeePositionPersistence employeePositionPersistence;

	@Reference
	protected EmployeeWithSummaryFinder employeeWithSummaryFinder;

	@Reference
	protected PurchasePersistence purchasePersistence;

	@Reference
	protected PurchaseTypePersistence purchaseTypePersistence;

	@Reference
	protected StatisticsHolderFinder statisticsHolderFinder;

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