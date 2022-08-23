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
 * Provides a wrapper for {@link EmployeePositionLocalService}.
 *
 * @author wz
 * @see EmployeePositionLocalService
 * @generated
 */
public class EmployeePositionLocalServiceWrapper
	implements EmployeePositionLocalService,
			   ServiceWrapper<EmployeePositionLocalService> {

	public EmployeePositionLocalServiceWrapper(
		EmployeePositionLocalService employeePositionLocalService) {

		_employeePositionLocalService = employeePositionLocalService;
	}

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
	@Override
	public com.wz.testtask.estore.model.EmployeePosition addEmployeePosition(
		com.wz.testtask.estore.model.EmployeePosition employeePosition) {

		return _employeePositionLocalService.addEmployeePosition(
			employeePosition);
	}

	@Override
	public com.wz.testtask.estore.model.EmployeePosition addEmployeePosition(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePositionLocalService.addEmployeePosition(
			name, serviceContext);
	}

	/**
	 * Creates a new employee position with the primary key. Does not add the employee position to the database.
	 *
	 * @param positionId the primary key for the new employee position
	 * @return the new employee position
	 */
	@Override
	public com.wz.testtask.estore.model.EmployeePosition createEmployeePosition(
		long positionId) {

		return _employeePositionLocalService.createEmployeePosition(positionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePositionLocalService.createPersistedModel(
			primaryKeyObj);
	}

	@Override
	public com.wz.testtask.estore.model.EmployeePosition delete(
			com.wz.testtask.estore.model.EmployeePosition employeePosition)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePositionLocalService.delete(employeePosition);
	}

	@Override
	public com.wz.testtask.estore.model.EmployeePosition deleteById(
			long positionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePositionLocalService.deleteById(positionId);
	}

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
	@Override
	public com.wz.testtask.estore.model.EmployeePosition deleteEmployeePosition(
		com.wz.testtask.estore.model.EmployeePosition employeePosition) {

		return _employeePositionLocalService.deleteEmployeePosition(
			employeePosition);
	}

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
	@Override
	public com.wz.testtask.estore.model.EmployeePosition deleteEmployeePosition(
			long positionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePositionLocalService.deleteEmployeePosition(positionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePositionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeePositionLocalService.dynamicQuery();
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

		return _employeePositionLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _employeePositionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _employeePositionLocalService.dynamicQuery(
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

		return _employeePositionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeePositionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.wz.testtask.estore.model.EmployeePosition fetchEmployeePosition(
		long positionId) {

		return _employeePositionLocalService.fetchEmployeePosition(positionId);
	}

	/**
	 * Returns the employee position matching the UUID and group.
	 *
	 * @param uuid the employee position's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee position, or <code>null</code> if a matching employee position could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.EmployeePosition
		fetchEmployeePositionByUuidAndGroupId(String uuid, long groupId) {

		return _employeePositionLocalService.
			fetchEmployeePositionByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeePositionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee position with the primary key.
	 *
	 * @param positionId the primary key of the employee position
	 * @return the employee position
	 * @throws PortalException if a employee position with the primary key could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.EmployeePosition getEmployeePosition(
			long positionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePositionLocalService.getEmployeePosition(positionId);
	}

	@Override
	public com.wz.testtask.estore.model.EmployeePosition
			getEmployeePositionByName(long groupId, String name)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseTypeException {

		return _employeePositionLocalService.getEmployeePositionByName(
			groupId, name);
	}

	/**
	 * Returns the employee position matching the UUID and group.
	 *
	 * @param uuid the employee position's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee position
	 * @throws PortalException if a matching employee position could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.EmployeePosition
			getEmployeePositionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePositionLocalService.
			getEmployeePositionByUuidAndGroupId(uuid, groupId);
	}

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
	@Override
	public java.util.List<com.wz.testtask.estore.model.EmployeePosition>
		getEmployeePositions(int start, int end) {

		return _employeePositionLocalService.getEmployeePositions(start, end);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.EmployeePosition>
		getEmployeePositions(long groupId) {

		return _employeePositionLocalService.getEmployeePositions(groupId);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.EmployeePosition>
		getEmployeePositions(long groupId, int start, int end) {

		return _employeePositionLocalService.getEmployeePositions(
			groupId, start, end);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.EmployeePosition>
		getEmployeePositions(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.wz.testtask.estore.model.EmployeePosition> obc) {

		return _employeePositionLocalService.getEmployeePositions(
			groupId, start, end, obc);
	}

	/**
	 * Returns all the employee positions matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee positions
	 * @param companyId the primary key of the company
	 * @return the matching employee positions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.wz.testtask.estore.model.EmployeePosition>
		getEmployeePositionsByUuidAndCompanyId(String uuid, long companyId) {

		return _employeePositionLocalService.
			getEmployeePositionsByUuidAndCompanyId(uuid, companyId);
	}

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
	@Override
	public java.util.List<com.wz.testtask.estore.model.EmployeePosition>
		getEmployeePositionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.wz.testtask.estore.model.EmployeePosition>
					orderByComparator) {

		return _employeePositionLocalService.
			getEmployeePositionsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee positions.
	 *
	 * @return the number of employee positions
	 */
	@Override
	public int getEmployeePositionsCount() {
		return _employeePositionLocalService.getEmployeePositionsCount();
	}

	@Override
	public int getEmployeePositionsCount(long groupId) {
		return _employeePositionLocalService.getEmployeePositionsCount(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeePositionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeePositionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePositionLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public com.wz.testtask.estore.model.EmployeePosition updateEmployeePosition(
		com.wz.testtask.estore.model.EmployeePosition employeePosition) {

		return _employeePositionLocalService.updateEmployeePosition(
			employeePosition);
	}

	@Override
	public com.wz.testtask.estore.model.EmployeePosition updateEmployeePosition(
			long positionId, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePositionLocalService.updateEmployeePosition(
			positionId, name, serviceContext);
	}

	@Override
	public EmployeePositionLocalService getWrappedService() {
		return _employeePositionLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeePositionLocalService employeePositionLocalService) {

		_employeePositionLocalService = employeePositionLocalService;
	}

	private EmployeePositionLocalService _employeePositionLocalService;

}