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

import com.wz.testtask.estore.model.EmployeePosition;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EmployeePosition. This utility wraps
 * <code>com.wz.testtask.estore.service.impl.EmployeePositionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author wz
 * @see EmployeePositionLocalService
 * @generated
 */
public class EmployeePositionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.wz.testtask.estore.service.impl.EmployeePositionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	public static EmployeePosition addEmployeePosition(
		EmployeePosition employeePosition) {

		return getService().addEmployeePosition(employeePosition);
	}

	public static EmployeePosition addEmployeePosition(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addEmployeePosition(name, serviceContext);
	}

	/**
	 * Creates a new employee position with the primary key. Does not add the employee position to the database.
	 *
	 * @param positionId the primary key for the new employee position
	 * @return the new employee position
	 */
	public static EmployeePosition createEmployeePosition(long positionId) {
		return getService().createEmployeePosition(positionId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static EmployeePosition delete(EmployeePosition employeePosition)
		throws PortalException {

		return getService().delete(employeePosition);
	}

	public static EmployeePosition deleteById(long positionId)
		throws PortalException {

		return getService().deleteById(positionId);
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
	public static EmployeePosition deleteEmployeePosition(
		EmployeePosition employeePosition) {

		return getService().deleteEmployeePosition(employeePosition);
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
	public static EmployeePosition deleteEmployeePosition(long positionId)
		throws PortalException {

		return getService().deleteEmployeePosition(positionId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.EmployeePositionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.EmployeePositionModelImpl</code>.
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

	public static EmployeePosition fetchEmployeePosition(long positionId) {
		return getService().fetchEmployeePosition(positionId);
	}

	/**
	 * Returns the employee position matching the UUID and group.
	 *
	 * @param uuid the employee position's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee position, or <code>null</code> if a matching employee position could not be found
	 */
	public static EmployeePosition fetchEmployeePositionByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEmployeePositionByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the employee position with the primary key.
	 *
	 * @param positionId the primary key of the employee position
	 * @return the employee position
	 * @throws PortalException if a employee position with the primary key could not be found
	 */
	public static EmployeePosition getEmployeePosition(long positionId)
		throws PortalException {

		return getService().getEmployeePosition(positionId);
	}

	public static EmployeePosition getEmployeePositionByName(
			long groupId, String name)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseTypeException {

		return getService().getEmployeePositionByName(groupId, name);
	}

	/**
	 * Returns the employee position matching the UUID and group.
	 *
	 * @param uuid the employee position's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee position
	 * @throws PortalException if a matching employee position could not be found
	 */
	public static EmployeePosition getEmployeePositionByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEmployeePositionByUuidAndGroupId(uuid, groupId);
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
	public static List<EmployeePosition> getEmployeePositions(
		int start, int end) {

		return getService().getEmployeePositions(start, end);
	}

	public static List<EmployeePosition> getEmployeePositions(long groupId) {
		return getService().getEmployeePositions(groupId);
	}

	public static List<EmployeePosition> getEmployeePositions(
		long groupId, int start, int end) {

		return getService().getEmployeePositions(groupId, start, end);
	}

	public static List<EmployeePosition> getEmployeePositions(
		long groupId, int start, int end,
		OrderByComparator<EmployeePosition> obc) {

		return getService().getEmployeePositions(groupId, start, end, obc);
	}

	/**
	 * Returns all the employee positions matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee positions
	 * @param companyId the primary key of the company
	 * @return the matching employee positions, or an empty list if no matches were found
	 */
	public static List<EmployeePosition> getEmployeePositionsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEmployeePositionsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<EmployeePosition> getEmployeePositionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeePosition> orderByComparator) {

		return getService().getEmployeePositionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee positions.
	 *
	 * @return the number of employee positions
	 */
	public static int getEmployeePositionsCount() {
		return getService().getEmployeePositionsCount();
	}

	public static int getEmployeePositionsCount(long groupId) {
		return getService().getEmployeePositionsCount(groupId);
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
	public static EmployeePosition updateEmployeePosition(
		EmployeePosition employeePosition) {

		return getService().updateEmployeePosition(employeePosition);
	}

	public static EmployeePosition updateEmployeePosition(
			long positionId, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateEmployeePosition(
			positionId, name, serviceContext);
	}

	public static EmployeePositionLocalService getService() {
		return _service;
	}

	private static volatile EmployeePositionLocalService _service;

}