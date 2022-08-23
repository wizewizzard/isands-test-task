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

import com.wz.testtask.estore.exception.NoSuchPurchaseTypeException;
import com.wz.testtask.estore.model.EmployeePosition;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for EmployeePosition. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author wz
 * @see EmployeePositionLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EmployeePositionLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.wz.testtask.estore.service.impl.EmployeePositionLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the employee position local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EmployeePositionLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the employee position to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePositionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePosition the employee position
	 * @return the employee position that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EmployeePosition addEmployeePosition(
		EmployeePosition employeePosition);

	public EmployeePosition addEmployeePosition(
			String name, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Creates a new employee position with the primary key. Does not add the employee position to the database.
	 *
	 * @param positionId the primary key for the new employee position
	 * @return the new employee position
	 */
	@Transactional(enabled = false)
	public EmployeePosition createEmployeePosition(long positionId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public EmployeePosition delete(EmployeePosition employeePosition)
		throws PortalException;

	public EmployeePosition deleteById(long positionId) throws PortalException;

	/**
	 * Deletes the employee position from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePositionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePosition the employee position
	 * @return the employee position that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public EmployeePosition deleteEmployeePosition(
		EmployeePosition employeePosition);

	/**
	 * Deletes the employee position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePositionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param positionId the primary key of the employee position
	 * @return the employee position that was removed
	 * @throws PortalException if a employee position with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public EmployeePosition deleteEmployeePosition(long positionId)
		throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.EmployeePositionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.EmployeePositionModelImpl</code>.
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
	public EmployeePosition fetchEmployeePosition(long positionId);

	/**
	 * Returns the employee position matching the UUID and group.
	 *
	 * @param uuid the employee position's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee position, or <code>null</code> if a matching employee position could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeePosition fetchEmployeePositionByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the employee position with the primary key.
	 *
	 * @param positionId the primary key of the employee position
	 * @return the employee position
	 * @throws PortalException if a employee position with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeePosition getEmployeePosition(long positionId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeePosition getEmployeePositionByName(long groupId, String name)
		throws NoSuchPurchaseTypeException;

	/**
	 * Returns the employee position matching the UUID and group.
	 *
	 * @param uuid the employee position's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee position
	 * @throws PortalException if a matching employee position could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeePosition getEmployeePositionByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the employee positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @return the range of employee positions
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeePosition> getEmployeePositions(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeePosition> getEmployeePositions(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeePosition> getEmployeePositions(
		long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeePosition> getEmployeePositions(
		long groupId, int start, int end,
		OrderByComparator<EmployeePosition> obc);

	/**
	 * Returns all the employee positions matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee positions
	 * @param companyId the primary key of the company
	 * @return the matching employee positions, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeePosition> getEmployeePositionsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of employee positions matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee positions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee positions, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeePosition> getEmployeePositionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeePosition> orderByComparator);

	/**
	 * Returns the number of employee positions.
	 *
	 * @return the number of employee positions
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEmployeePositionsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEmployeePositionsCount(long groupId);

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
	 * Updates the employee position in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePositionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePosition the employee position
	 * @return the employee position that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EmployeePosition updateEmployeePosition(
		EmployeePosition employeePosition);

	public EmployeePosition updateEmployeePosition(
			long positionId, String name, ServiceContext serviceContext)
		throws PortalException;

}