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
 * Provides a wrapper for {@link PurchaseLocalService}.
 *
 * @author wz
 * @see PurchaseLocalService
 * @generated
 */
public class PurchaseLocalServiceWrapper
	implements PurchaseLocalService, ServiceWrapper<PurchaseLocalService> {

	public PurchaseLocalServiceWrapper(
		PurchaseLocalService purchaseLocalService) {

		_purchaseLocalService = purchaseLocalService;
	}

	@Override
	public com.wz.testtask.estore.model.Purchase addPurchase(
			long employeeId, long deviceId, int count,
			java.util.Date purchaseDate, long purchaseTypeId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseLocalService.addPurchase(
			employeeId, deviceId, count, purchaseDate, purchaseTypeId,
			serviceContext);
	}

	/**
	 * Adds the purchase to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchase the purchase
	 * @return the purchase that was added
	 */
	@Override
	public com.wz.testtask.estore.model.Purchase addPurchase(
		com.wz.testtask.estore.model.Purchase purchase) {

		return _purchaseLocalService.addPurchase(purchase);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new purchase with the primary key. Does not add the purchase to the database.
	 *
	 * @param purchaseId the primary key for the new purchase
	 * @return the new purchase
	 */
	@Override
	public com.wz.testtask.estore.model.Purchase createPurchase(
		long purchaseId) {

		return _purchaseLocalService.createPurchase(purchaseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the purchase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase that was removed
	 * @throws PortalException if a purchase with the primary key could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.Purchase deletePurchase(long purchaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseLocalService.deletePurchase(purchaseId);
	}

	/**
	 * Deletes the purchase from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchase the purchase
	 * @return the purchase that was removed
	 */
	@Override
	public com.wz.testtask.estore.model.Purchase deletePurchase(
		com.wz.testtask.estore.model.Purchase purchase) {

		return _purchaseLocalService.deletePurchase(purchase);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _purchaseLocalService.dynamicQuery();
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

		return _purchaseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.PurchaseModelImpl</code>.
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

		return _purchaseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.PurchaseModelImpl</code>.
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

		return _purchaseLocalService.dynamicQuery(
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

		return _purchaseLocalService.dynamicQueryCount(dynamicQuery);
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

		return _purchaseLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.wz.testtask.estore.model.Purchase fetchPurchase(
		long purchaseId) {

		return _purchaseLocalService.fetchPurchase(purchaseId);
	}

	/**
	 * Returns the purchase matching the UUID and group.
	 *
	 * @param uuid the purchase's UUID
	 * @param groupId the primary key of the group
	 * @return the matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.Purchase fetchPurchaseByUuidAndGroupId(
		String uuid, long groupId) {

		return _purchaseLocalService.fetchPurchaseByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _purchaseLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _purchaseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _purchaseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the purchase with the primary key.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase
	 * @throws PortalException if a purchase with the primary key could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.Purchase getPurchase(long purchaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseLocalService.getPurchase(purchaseId);
	}

	/**
	 * Returns the purchase matching the UUID and group.
	 *
	 * @param uuid the purchase's UUID
	 * @param groupId the primary key of the group
	 * @return the matching purchase
	 * @throws PortalException if a matching purchase could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.Purchase getPurchaseByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseLocalService.getPurchaseByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of purchases
	 */
	@Override
	public java.util.List<com.wz.testtask.estore.model.Purchase> getPurchases(
		int start, int end) {

		return _purchaseLocalService.getPurchases(start, end);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Purchase> getPurchases(
		long groupId) {

		return _purchaseLocalService.getPurchases(groupId);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Purchase> getPurchases(
		long groupId, int start, int end) {

		return _purchaseLocalService.getPurchases(groupId, start, end);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Purchase> getPurchases(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.wz.testtask.estore.model.Purchase> obc) {

		return _purchaseLocalService.getPurchases(groupId, start, end, obc);
	}

	/**
	 * Returns all the purchases matching the UUID and company.
	 *
	 * @param uuid the UUID of the purchases
	 * @param companyId the primary key of the company
	 * @return the matching purchases, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.wz.testtask.estore.model.Purchase>
		getPurchasesByUuidAndCompanyId(String uuid, long companyId) {

		return _purchaseLocalService.getPurchasesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of purchases matching the UUID and company.
	 *
	 * @param uuid the UUID of the purchases
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching purchases, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.wz.testtask.estore.model.Purchase>
		getPurchasesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.wz.testtask.estore.model.Purchase> orderByComparator) {

		return _purchaseLocalService.getPurchasesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of purchases.
	 *
	 * @return the number of purchases
	 */
	@Override
	public int getPurchasesCount() {
		return _purchaseLocalService.getPurchasesCount();
	}

	@Override
	public int getPurchasesCount(long groupId) {
		return _purchaseLocalService.getPurchasesCount(groupId);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Purchase>
		getPurchasesForEmployee(long groupId, long employeeId) {

		return _purchaseLocalService.getPurchasesForEmployee(
			groupId, employeeId);
	}

	@Override
	public int getPurchasesForEmployeeCount(long groupId, long employeeId) {
		return _purchaseLocalService.getPurchasesForEmployeeCount(
			groupId, employeeId);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Purchase>
		getPurchasesOfDevice(long groupId, long deviceId) {

		return _purchaseLocalService.getPurchasesOfDevice(groupId, deviceId);
	}

	@Override
	public int getPurchasesOfDeviceCount(long groupId, long deviceId) {
		return _purchaseLocalService.getPurchasesOfDeviceCount(
			groupId, deviceId);
	}

	@Override
	public void makePurchase(
			long employeeId, long deviceId, int count, long purchaseTypeId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_purchaseLocalService.makePurchase(
			employeeId, deviceId, count, purchaseTypeId, serviceContext);
	}

	@Override
	public void updatePurchase(
			long purchaseId, long employeeId, long deviceId, int count,
			long purchaseTypeId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_purchaseLocalService.updatePurchase(
			purchaseId, employeeId, deviceId, count, purchaseTypeId,
			serviceContext);
	}

	/**
	 * Updates the purchase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchase the purchase
	 * @return the purchase that was updated
	 */
	@Override
	public com.wz.testtask.estore.model.Purchase updatePurchase(
		com.wz.testtask.estore.model.Purchase purchase) {

		return _purchaseLocalService.updatePurchase(purchase);
	}

	@Override
	public PurchaseLocalService getWrappedService() {
		return _purchaseLocalService;
	}

	@Override
	public void setWrappedService(PurchaseLocalService purchaseLocalService) {
		_purchaseLocalService = purchaseLocalService;
	}

	private PurchaseLocalService _purchaseLocalService;

}