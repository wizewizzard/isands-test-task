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
 * Provides a wrapper for {@link PurchaseTypeLocalService}.
 *
 * @author wz
 * @see PurchaseTypeLocalService
 * @generated
 */
public class PurchaseTypeLocalServiceWrapper
	implements PurchaseTypeLocalService,
			   ServiceWrapper<PurchaseTypeLocalService> {

	public PurchaseTypeLocalServiceWrapper(
		PurchaseTypeLocalService purchaseTypeLocalService) {

		_purchaseTypeLocalService = purchaseTypeLocalService;
	}

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
	@Override
	public com.wz.testtask.estore.model.PurchaseType addPurchaseType(
		com.wz.testtask.estore.model.PurchaseType purchaseType) {

		return _purchaseTypeLocalService.addPurchaseType(purchaseType);
	}

	@Override
	public com.wz.testtask.estore.model.PurchaseType addPurchaseType(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseTypeLocalService.addPurchaseType(name, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new purchase type with the primary key. Does not add the purchase type to the database.
	 *
	 * @param purchaseTypeId the primary key for the new purchase type
	 * @return the new purchase type
	 */
	@Override
	public com.wz.testtask.estore.model.PurchaseType createPurchaseType(
		long purchaseTypeId) {

		return _purchaseTypeLocalService.createPurchaseType(purchaseTypeId);
	}

	@Override
	public com.wz.testtask.estore.model.PurchaseType delete(
			com.wz.testtask.estore.model.PurchaseType purchaseType)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseTypeLocalService.delete(purchaseType);
	}

	@Override
	public com.wz.testtask.estore.model.PurchaseType deleteById(
			long purchaseTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseTypeLocalService.deleteById(purchaseTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseTypeLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.wz.testtask.estore.model.PurchaseType deletePurchaseType(
			long purchaseTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseTypeLocalService.deletePurchaseType(purchaseTypeId);
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
	@Override
	public com.wz.testtask.estore.model.PurchaseType deletePurchaseType(
		com.wz.testtask.estore.model.PurchaseType purchaseType) {

		return _purchaseTypeLocalService.deletePurchaseType(purchaseType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _purchaseTypeLocalService.dynamicQuery();
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

		return _purchaseTypeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _purchaseTypeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _purchaseTypeLocalService.dynamicQuery(
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

		return _purchaseTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _purchaseTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.wz.testtask.estore.model.PurchaseType fetchPurchaseType(
		long purchaseTypeId) {

		return _purchaseTypeLocalService.fetchPurchaseType(purchaseTypeId);
	}

	/**
	 * Returns the purchase type matching the UUID and group.
	 *
	 * @param uuid the purchase type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.PurchaseType
		fetchPurchaseTypeByUuidAndGroupId(String uuid, long groupId) {

		return _purchaseTypeLocalService.fetchPurchaseTypeByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _purchaseTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _purchaseTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _purchaseTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the purchase type with the primary key.
	 *
	 * @param purchaseTypeId the primary key of the purchase type
	 * @return the purchase type
	 * @throws PortalException if a purchase type with the primary key could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.PurchaseType getPurchaseType(
			long purchaseTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseTypeLocalService.getPurchaseType(purchaseTypeId);
	}

	/**
	 * Returns the purchase type matching the UUID and group.
	 *
	 * @param uuid the purchase type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching purchase type
	 * @throws PortalException if a matching purchase type could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.PurchaseType
			getPurchaseTypeByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseTypeLocalService.getPurchaseTypeByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.wz.testtask.estore.model.PurchaseType>
		getPurchaseTypes(int start, int end) {

		return _purchaseTypeLocalService.getPurchaseTypes(start, end);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.PurchaseType>
		getPurchaseTypes(long groupId) {

		return _purchaseTypeLocalService.getPurchaseTypes(groupId);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.PurchaseType>
		getPurchaseTypes(long groupId, int start, int end) {

		return _purchaseTypeLocalService.getPurchaseTypes(groupId, start, end);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.PurchaseType>
		getPurchaseTypes(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.wz.testtask.estore.model.PurchaseType> obc) {

		return _purchaseTypeLocalService.getPurchaseTypes(
			groupId, start, end, obc);
	}

	/**
	 * Returns all the purchase types matching the UUID and company.
	 *
	 * @param uuid the UUID of the purchase types
	 * @param companyId the primary key of the company
	 * @return the matching purchase types, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.wz.testtask.estore.model.PurchaseType>
		getPurchaseTypesByUuidAndCompanyId(String uuid, long companyId) {

		return _purchaseTypeLocalService.getPurchaseTypesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.wz.testtask.estore.model.PurchaseType>
		getPurchaseTypesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.wz.testtask.estore.model.PurchaseType> orderByComparator) {

		return _purchaseTypeLocalService.getPurchaseTypesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of purchase types.
	 *
	 * @return the number of purchase types
	 */
	@Override
	public int getPurchaseTypesCount() {
		return _purchaseTypeLocalService.getPurchaseTypesCount();
	}

	@Override
	public int getPurchaseTypesCount(long groupId) {
		return _purchaseTypeLocalService.getPurchaseTypesCount(groupId);
	}

	@Override
	public com.wz.testtask.estore.model.PurchaseType updatePurchaseType(
			long purchaseTypeId, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseTypeLocalService.updatePurchaseType(
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
	@Override
	public com.wz.testtask.estore.model.PurchaseType updatePurchaseType(
		com.wz.testtask.estore.model.PurchaseType purchaseType) {

		return _purchaseTypeLocalService.updatePurchaseType(purchaseType);
	}

	@Override
	public PurchaseTypeLocalService getWrappedService() {
		return _purchaseTypeLocalService;
	}

	@Override
	public void setWrappedService(
		PurchaseTypeLocalService purchaseTypeLocalService) {

		_purchaseTypeLocalService = purchaseTypeLocalService;
	}

	private PurchaseTypeLocalService _purchaseTypeLocalService;

}