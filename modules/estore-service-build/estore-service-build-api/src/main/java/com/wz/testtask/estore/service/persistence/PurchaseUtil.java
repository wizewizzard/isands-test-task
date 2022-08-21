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

package com.wz.testtask.estore.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.wz.testtask.estore.model.Purchase;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the purchase service. This utility wraps <code>com.wz.testtask.estore.service.persistence.impl.PurchasePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author wz
 * @see PurchasePersistence
 * @generated
 */
public class PurchaseUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Purchase purchase) {
		getPersistence().clearCache(purchase);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Purchase> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Purchase> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Purchase> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Purchase> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Purchase update(Purchase purchase) {
		return getPersistence().update(purchase);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Purchase update(
		Purchase purchase, ServiceContext serviceContext) {

		return getPersistence().update(purchase, serviceContext);
	}

	/**
	 * Returns all the purchases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching purchases
	 */
	public static List<Purchase> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the purchases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	public static List<Purchase> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the purchases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	public static List<Purchase> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the purchases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	public static List<Purchase> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public static Purchase findByUuid_First(
			String uuid, OrderByComparator<Purchase> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByUuid_First(
		String uuid, OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public static Purchase findByUuid_Last(
			String uuid, OrderByComparator<Purchase> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByUuid_Last(
		String uuid, OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where uuid = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	public static Purchase[] findByUuid_PrevAndNext(
			long purchaseId, String uuid,
			OrderByComparator<Purchase> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().findByUuid_PrevAndNext(
			purchaseId, uuid, orderByComparator);
	}

	/**
	 * Removes all the purchases where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of purchases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching purchases
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the purchase where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPurchaseException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public static Purchase findByUUID_G(String uuid, long groupId)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the purchase where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the purchase where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the purchase where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the purchase that was removed
	 */
	public static Purchase removeByUUID_G(String uuid, long groupId)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of purchases where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching purchases
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the purchases where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching purchases
	 */
	public static List<Purchase> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the purchases where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	public static List<Purchase> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the purchases where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	public static List<Purchase> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the purchases where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	public static List<Purchase> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first purchase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public static Purchase findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Purchase> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first purchase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last purchase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public static Purchase findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Purchase> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last purchase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	public static Purchase[] findByUuid_C_PrevAndNext(
			long purchaseId, String uuid, long companyId,
			OrderByComparator<Purchase> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().findByUuid_C_PrevAndNext(
			purchaseId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the purchases where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of purchases where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching purchases
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the purchases where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching purchases
	 */
	public static List<Purchase> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the purchases where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	public static List<Purchase> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	public static List<Purchase> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	public static List<Purchase> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public static Purchase findByGroupId_First(
			long groupId, OrderByComparator<Purchase> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByGroupId_First(
		long groupId, OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public static Purchase findByGroupId_Last(
			long groupId, OrderByComparator<Purchase> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByGroupId_Last(
		long groupId, OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where groupId = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	public static Purchase[] findByGroupId_PrevAndNext(
			long purchaseId, long groupId,
			OrderByComparator<Purchase> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().findByGroupId_PrevAndNext(
			purchaseId, groupId, orderByComparator);
	}

	/**
	 * Removes all the purchases where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of purchases where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching purchases
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the purchases where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @return the matching purchases
	 */
	public static List<Purchase> findByGroupIdEmployeeId(
		long groupId, long employeeId) {

		return getPersistence().findByGroupIdEmployeeId(groupId, employeeId);
	}

	/**
	 * Returns a range of all the purchases where groupId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	public static List<Purchase> findByGroupIdEmployeeId(
		long groupId, long employeeId, int start, int end) {

		return getPersistence().findByGroupIdEmployeeId(
			groupId, employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	public static List<Purchase> findByGroupIdEmployeeId(
		long groupId, long employeeId, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().findByGroupIdEmployeeId(
			groupId, employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	public static List<Purchase> findByGroupIdEmployeeId(
		long groupId, long employeeId, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupIdEmployeeId(
			groupId, employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public static Purchase findByGroupIdEmployeeId_First(
			long groupId, long employeeId,
			OrderByComparator<Purchase> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().findByGroupIdEmployeeId_First(
			groupId, employeeId, orderByComparator);
	}

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByGroupIdEmployeeId_First(
		long groupId, long employeeId,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().fetchByGroupIdEmployeeId_First(
			groupId, employeeId, orderByComparator);
	}

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public static Purchase findByGroupIdEmployeeId_Last(
			long groupId, long employeeId,
			OrderByComparator<Purchase> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().findByGroupIdEmployeeId_Last(
			groupId, employeeId, orderByComparator);
	}

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByGroupIdEmployeeId_Last(
		long groupId, long employeeId,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().fetchByGroupIdEmployeeId_Last(
			groupId, employeeId, orderByComparator);
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	public static Purchase[] findByGroupIdEmployeeId_PrevAndNext(
			long purchaseId, long groupId, long employeeId,
			OrderByComparator<Purchase> orderByComparator)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().findByGroupIdEmployeeId_PrevAndNext(
			purchaseId, groupId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the purchases where groupId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 */
	public static void removeByGroupIdEmployeeId(
		long groupId, long employeeId) {

		getPersistence().removeByGroupIdEmployeeId(groupId, employeeId);
	}

	/**
	 * Returns the number of purchases where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @return the number of matching purchases
	 */
	public static int countByGroupIdEmployeeId(long groupId, long employeeId) {
		return getPersistence().countByGroupIdEmployeeId(groupId, employeeId);
	}

	/**
	 * Caches the purchase in the entity cache if it is enabled.
	 *
	 * @param purchase the purchase
	 */
	public static void cacheResult(Purchase purchase) {
		getPersistence().cacheResult(purchase);
	}

	/**
	 * Caches the purchases in the entity cache if it is enabled.
	 *
	 * @param purchases the purchases
	 */
	public static void cacheResult(List<Purchase> purchases) {
		getPersistence().cacheResult(purchases);
	}

	/**
	 * Creates a new purchase with the primary key. Does not add the purchase to the database.
	 *
	 * @param purchaseId the primary key for the new purchase
	 * @return the new purchase
	 */
	public static Purchase create(long purchaseId) {
		return getPersistence().create(purchaseId);
	}

	/**
	 * Removes the purchase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase that was removed
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	public static Purchase remove(long purchaseId)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().remove(purchaseId);
	}

	public static Purchase updateImpl(Purchase purchase) {
		return getPersistence().updateImpl(purchase);
	}

	/**
	 * Returns the purchase with the primary key or throws a <code>NoSuchPurchaseException</code> if it could not be found.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	public static Purchase findByPrimaryKey(long purchaseId)
		throws com.wz.testtask.estore.exception.NoSuchPurchaseException {

		return getPersistence().findByPrimaryKey(purchaseId);
	}

	/**
	 * Returns the purchase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase, or <code>null</code> if a purchase with the primary key could not be found
	 */
	public static Purchase fetchByPrimaryKey(long purchaseId) {
		return getPersistence().fetchByPrimaryKey(purchaseId);
	}

	/**
	 * Returns all the purchases.
	 *
	 * @return the purchases
	 */
	public static List<Purchase> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of purchases
	 */
	public static List<Purchase> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of purchases
	 */
	public static List<Purchase> findAll(
		int start, int end, OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of purchases
	 */
	public static List<Purchase> findAll(
		int start, int end, OrderByComparator<Purchase> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the purchases from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of purchases.
	 *
	 * @return the number of purchases
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PurchasePersistence getPersistence() {
		return _persistence;
	}

	private static volatile PurchasePersistence _persistence;

}