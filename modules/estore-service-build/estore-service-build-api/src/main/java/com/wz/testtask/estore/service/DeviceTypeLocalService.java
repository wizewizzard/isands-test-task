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

import com.wz.testtask.estore.model.DeviceType;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DeviceType. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author wz
 * @see DeviceTypeLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DeviceTypeLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.wz.testtask.estore.service.impl.DeviceTypeLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the device type local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DeviceTypeLocalServiceUtil} if injection and service tracking are not available.
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
	public DeviceType addDeviceType(DeviceType deviceType);

	public DeviceType addDeviceType(String name, ServiceContext serviceContext)
		throws PortalException;

	public void addEmployeeDeviceType(long employeeId, DeviceType deviceType);

	public void addEmployeeDeviceType(long employeeId, long deviceTypeId);

	public void addEmployeeDeviceTypes(
		long employeeId, List<DeviceType> deviceTypes);

	public void addEmployeeDeviceTypes(long employeeId, long[] deviceTypeIds);

	public void clearEmployeeDeviceTypes(long employeeId);

	/**
	 * Creates a new device type with the primary key. Does not add the device type to the database.
	 *
	 * @param deviceTypeId the primary key for the new device type
	 * @return the new device type
	 */
	@Transactional(enabled = false)
	public DeviceType createDeviceType(long deviceTypeId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public DeviceType delete(DeviceType deviceType) throws PortalException;

	public DeviceType deleteById(long purchaseTypeId) throws PortalException;

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
	public DeviceType deleteDeviceType(DeviceType deviceType);

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
	public DeviceType deleteDeviceType(long deviceTypeId)
		throws PortalException;

	public void deleteEmployeeDeviceType(
		long employeeId, DeviceType deviceType);

	public void deleteEmployeeDeviceType(long employeeId, long deviceTypeId);

	public void deleteEmployeeDeviceTypes(
		long employeeId, List<DeviceType> deviceTypes);

	public void deleteEmployeeDeviceTypes(
		long employeeId, long[] deviceTypeIds);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.DeviceTypeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.DeviceTypeModelImpl</code>.
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
	public DeviceType fetchDeviceType(long deviceTypeId);

	/**
	 * Returns the device type matching the UUID and group.
	 *
	 * @param uuid the device type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching device type, or <code>null</code> if a matching device type could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DeviceType fetchDeviceTypeByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the device type with the primary key.
	 *
	 * @param deviceTypeId the primary key of the device type
	 * @return the device type
	 * @throws PortalException if a device type with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DeviceType getDeviceType(long deviceTypeId) throws PortalException;

	/**
	 * Returns the device type matching the UUID and group.
	 *
	 * @param uuid the device type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching device type
	 * @throws PortalException if a matching device type could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DeviceType getDeviceTypeByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DeviceType> getDeviceTypes(int start, int end);

	/**
	 * Returns all the device types matching the UUID and company.
	 *
	 * @param uuid the UUID of the device types
	 * @param companyId the primary key of the company
	 * @return the matching device types, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DeviceType> getDeviceTypesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DeviceType> getDeviceTypesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DeviceType> orderByComparator);

	/**
	 * Returns the number of device types.
	 *
	 * @return the number of device types
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDeviceTypesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DeviceType> getEmployeeDeviceTypes(long employeeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DeviceType> getEmployeeDeviceTypes(
		long employeeId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DeviceType> getEmployeeDeviceTypes(
		long employeeId, int start, int end,
		OrderByComparator<DeviceType> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEmployeeDeviceTypesCount(long employeeId);

	/**
	 * Returns the employeeIds of the employees associated with the device type.
	 *
	 * @param deviceTypeId the deviceTypeId of the device type
	 * @return long[] the employeeIds of employees associated with the device type
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getEmployeePrimaryKeys(long deviceTypeId);

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DeviceType> getPurchaseTypes(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DeviceType> getPurchaseTypes(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DeviceType> getPurchaseTypes(
		long groupId, int start, int end, OrderByComparator<DeviceType> obc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPurchaseTypesCount(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasEmployeeDeviceType(long employeeId, long deviceTypeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasEmployeeDeviceTypes(long employeeId);

	public void setEmployeeDeviceTypes(long employeeId, long[] deviceTypeIds);

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
	public DeviceType updateDeviceType(DeviceType deviceType);

	public DeviceType updatePurchaseType(
			long deviceTypeId, String name, ServiceContext serviceContext)
		throws PortalException;

}