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

import com.wz.testtask.estore.model.PurchaseType;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PurchaseType. This utility wraps
 * <code>com.wz.testtask.estore.service.impl.PurchaseTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author wz
 * @see PurchaseTypeLocalService
 * @generated
 */
public class PurchaseTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.wz.testtask.estore.service.impl.PurchaseTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the purchase type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchaseType the purchase type
	 * @return the purchase type that was added
	 */
	public static PurchaseType addPurchaseType(PurchaseType purchaseType) {
		return getService().addPurchaseType(purchaseType);
	}

	public static PurchaseType addPurchaseType(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addPurchaseType(name, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new purchase type with the primary key. Does not add the purchase type to the database.
	 *
	 * @param purchaseTypeId the primary key for the new purchase type
	 * @return the new purchase type
	 */
	public static PurchaseType createPurchaseType(long purchaseTypeId) {
		return getService().createPurchaseType(purchaseTypeId);
	}

	public static PurchaseType delete(PurchaseType purchaseType)
		throws PortalException {

		return getService().delete(purchaseType);
	}

	public static PurchaseType deleteById(long purchaseTypeId)
		throws PortalException {

		return getService().deleteById(purchaseTypeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the purchase type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchaseTypeId the primary key of the purchase type
	 * @return the purchase type that was removed
	 * @throws PortalException if a purchase type with the primary key could not be found
	 */
	public static PurchaseType deletePurchaseType(long purchaseTypeId)
		throws PortalException {

		return getService().deletePurchaseType(purchaseTypeId);
	}

	/**
	 * Deletes the purchase type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchaseType the purchase type
	 * @return the purchase type that was removed
	 */
	public static PurchaseType deletePurchaseType(PurchaseType purchaseType) {
		return getService().deletePurchaseType(purchaseType);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.PurchaseTypeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.PurchaseTypeModelImpl</code>.
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

	public static PurchaseType fetchPurchaseType(long purchaseTypeId) {
		return getService().fetchPurchaseType(purchaseTypeId);
	}

	/**
	 * Returns the purchase type matching the UUID and group.
	 *
	 * @param uuid the purchase type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	public static PurchaseType fetchPurchaseTypeByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPurchaseTypeByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the purchase type with the primary key.
	 *
	 * @param purchaseTypeId the primary key of the purchase type
	 * @return the purchase type
	 * @throws PortalException if a purchase type with the primary key could not be found
	 */
	public static PurchaseType getPurchaseType(long purchaseTypeId)
		throws PortalException {

		return getService().getPurchaseType(purchaseTypeId);
	}

	public static PurchaseType getPurchaseTypeByName(
		long groupId, String name) {

		return getService().getPurchaseTypeByName(groupId, name);
	}

	/**
	 * Returns the purchase type matching the UUID and group.
	 *
	 * @param uuid the purchase type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching purchase type
	 * @throws PortalException if a matching purchase type could not be found
	 */
	public static PurchaseType getPurchaseTypeByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getPurchaseTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the purchase types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @return the range of purchase types
	 */
	public static List<PurchaseType> getPurchaseTypes(int start, int end) {
		return getService().getPurchaseTypes(start, end);
	}

	public static List<PurchaseType> getPurchaseTypes(long groupId) {
		return getService().getPurchaseTypes(groupId);
	}

	public static List<PurchaseType> getPurchaseTypes(
		long groupId, int start, int end) {

		return getService().getPurchaseTypes(groupId, start, end);
	}

	public static List<PurchaseType> getPurchaseTypes(
		long groupId, int start, int end, OrderByComparator<PurchaseType> obc) {

		return getService().getPurchaseTypes(groupId, start, end, obc);
	}

	/**
	 * Returns all the purchase types matching the UUID and company.
	 *
	 * @param uuid the UUID of the purchase types
	 * @param companyId the primary key of the company
	 * @return the matching purchase types, or an empty list if no matches were found
	 */
	public static List<PurchaseType> getPurchaseTypesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPurchaseTypesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of purchase types matching the UUID and company.
	 *
	 * @param uuid the UUID of the purchase types
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching purchase types, or an empty list if no matches were found
	 */
	public static List<PurchaseType> getPurchaseTypesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PurchaseType> orderByComparator) {

		return getService().getPurchaseTypesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of purchase types.
	 *
	 * @return the number of purchase types
	 */
	public static int getPurchaseTypesCount() {
		return getService().getPurchaseTypesCount();
	}

	public static int getPurchaseTypesCount(long groupId) {
		return getService().getPurchaseTypesCount(groupId);
	}

	public static PurchaseType updatePurchaseType(
			long purchaseTypeId, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updatePurchaseType(
			purchaseTypeId, name, serviceContext);
	}

	/**
	 * Updates the purchase type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchaseType the purchase type
	 * @return the purchase type that was updated
	 */
	public static PurchaseType updatePurchaseType(PurchaseType purchaseType) {
		return getService().updatePurchaseType(purchaseType);
	}

	public static PurchaseTypeLocalService getService() {
		return _service;
	}

	private static volatile PurchaseTypeLocalService _service;

}