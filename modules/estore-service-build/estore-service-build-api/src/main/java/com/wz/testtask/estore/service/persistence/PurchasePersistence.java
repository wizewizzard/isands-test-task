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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.wz.testtask.estore.exception.NoSuchPurchaseException;
import com.wz.testtask.estore.model.Purchase;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the purchase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author wz
 * @see PurchaseUtil
 * @generated
 */
@ProviderType
public interface PurchasePersistence extends BasePersistence<Purchase> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PurchaseUtil} to access the purchase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the purchases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching purchases
	 */
	public java.util.List<Purchase> findByUuid(String uuid);

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
	public java.util.List<Purchase> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Purchase> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

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
	public java.util.List<Purchase> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public Purchase findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Returns the first purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public Purchase fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

	/**
	 * Returns the last purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public Purchase findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Returns the last purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public Purchase fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where uuid = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	public Purchase[] findByUuid_PrevAndNext(
			long purchaseId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Removes all the purchases where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of purchases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching purchases
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the purchase where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPurchaseException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public Purchase findByUUID_G(String uuid, long groupId)
		throws NoSuchPurchaseException;

	/**
	 * Returns the purchase where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public Purchase fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the purchase where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public Purchase fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the purchase where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the purchase that was removed
	 */
	public Purchase removeByUUID_G(String uuid, long groupId)
		throws NoSuchPurchaseException;

	/**
	 * Returns the number of purchases where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching purchases
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the purchases where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching purchases
	 */
	public java.util.List<Purchase> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Purchase> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Purchase> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

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
	public java.util.List<Purchase> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first purchase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public Purchase findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Returns the first purchase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public Purchase fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

	/**
	 * Returns the last purchase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public Purchase findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Returns the last purchase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public Purchase fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

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
	public Purchase[] findByUuid_C_PrevAndNext(
			long purchaseId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Removes all the purchases where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of purchases where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching purchases
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the purchases where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching purchases
	 */
	public java.util.List<Purchase> findByGroupId(long groupId);

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
	public java.util.List<Purchase> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Purchase> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

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
	public java.util.List<Purchase> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public Purchase findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public Purchase fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public Purchase findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public Purchase fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where groupId = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	public Purchase[] findByGroupId_PrevAndNext(
			long purchaseId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Removes all the purchases where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of purchases where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching purchases
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the purchases where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @return the matching purchases
	 */
	public java.util.List<Purchase> findByGroupIdEmployeeId(
		long groupId, long employeeId);

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
	public java.util.List<Purchase> findByGroupIdEmployeeId(
		long groupId, long employeeId, int start, int end);

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
	public java.util.List<Purchase> findByGroupIdEmployeeId(
		long groupId, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

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
	public java.util.List<Purchase> findByGroupIdEmployeeId(
		long groupId, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public Purchase findByGroupIdEmployeeId_First(
			long groupId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public Purchase fetchByGroupIdEmployeeId_First(
		long groupId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public Purchase findByGroupIdEmployeeId_Last(
			long groupId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public Purchase fetchByGroupIdEmployeeId_Last(
		long groupId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

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
	public Purchase[] findByGroupIdEmployeeId_PrevAndNext(
			long purchaseId, long groupId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Removes all the purchases where groupId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 */
	public void removeByGroupIdEmployeeId(long groupId, long employeeId);

	/**
	 * Returns the number of purchases where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @return the number of matching purchases
	 */
	public int countByGroupIdEmployeeId(long groupId, long employeeId);

	/**
	 * Returns all the purchases where groupId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @return the matching purchases
	 */
	public java.util.List<Purchase> findByGroupIdDeviceId(
		long groupId, long deviceId);

	/**
	 * Returns a range of all the purchases where groupId = &#63; and deviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	public java.util.List<Purchase> findByGroupIdDeviceId(
		long groupId, long deviceId, int start, int end);

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63; and deviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	public java.util.List<Purchase> findByGroupIdDeviceId(
		long groupId, long deviceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63; and deviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	public java.util.List<Purchase> findByGroupIdDeviceId(
		long groupId, long deviceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public Purchase findByGroupIdDeviceId_First(
			long groupId, long deviceId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public Purchase fetchByGroupIdDeviceId_First(
		long groupId, long deviceId,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public Purchase findByGroupIdDeviceId_Last(
			long groupId, long deviceId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public Purchase fetchByGroupIdDeviceId_Last(
		long groupId, long deviceId,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where groupId = &#63; and deviceId = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	public Purchase[] findByGroupIdDeviceId_PrevAndNext(
			long purchaseId, long groupId, long deviceId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Removes all the purchases where groupId = &#63; and deviceId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 */
	public void removeByGroupIdDeviceId(long groupId, long deviceId);

	/**
	 * Returns the number of purchases where groupId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @return the number of matching purchases
	 */
	public int countByGroupIdDeviceId(long groupId, long deviceId);

	/**
	 * Returns all the purchases where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @return the matching purchases
	 */
	public java.util.List<Purchase> findByGroupIdEmployeeIdDeviceId(
		long groupId, long employeeId, long deviceId);

	/**
	 * Returns a range of all the purchases where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	public java.util.List<Purchase> findByGroupIdEmployeeIdDeviceId(
		long groupId, long employeeId, long deviceId, int start, int end);

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	public java.util.List<Purchase> findByGroupIdEmployeeIdDeviceId(
		long groupId, long employeeId, long deviceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	public java.util.List<Purchase> findByGroupIdEmployeeIdDeviceId(
		long groupId, long employeeId, long deviceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public Purchase findByGroupIdEmployeeIdDeviceId_First(
			long groupId, long employeeId, long deviceId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public Purchase fetchByGroupIdEmployeeIdDeviceId_First(
		long groupId, long employeeId, long deviceId,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public Purchase findByGroupIdEmployeeIdDeviceId_Last(
			long groupId, long employeeId, long deviceId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public Purchase fetchByGroupIdEmployeeIdDeviceId_Last(
		long groupId, long employeeId, long deviceId,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	public Purchase[] findByGroupIdEmployeeIdDeviceId_PrevAndNext(
			long purchaseId, long groupId, long employeeId, long deviceId,
			com.liferay.portal.kernel.util.OrderByComparator<Purchase>
				orderByComparator)
		throws NoSuchPurchaseException;

	/**
	 * Removes all the purchases where groupId = &#63; and employeeId = &#63; and deviceId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 */
	public void removeByGroupIdEmployeeIdDeviceId(
		long groupId, long employeeId, long deviceId);

	/**
	 * Returns the number of purchases where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @return the number of matching purchases
	 */
	public int countByGroupIdEmployeeIdDeviceId(
		long groupId, long employeeId, long deviceId);

	/**
	 * Caches the purchase in the entity cache if it is enabled.
	 *
	 * @param purchase the purchase
	 */
	public void cacheResult(Purchase purchase);

	/**
	 * Caches the purchases in the entity cache if it is enabled.
	 *
	 * @param purchases the purchases
	 */
	public void cacheResult(java.util.List<Purchase> purchases);

	/**
	 * Creates a new purchase with the primary key. Does not add the purchase to the database.
	 *
	 * @param purchaseId the primary key for the new purchase
	 * @return the new purchase
	 */
	public Purchase create(long purchaseId);

	/**
	 * Removes the purchase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase that was removed
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	public Purchase remove(long purchaseId) throws NoSuchPurchaseException;

	public Purchase updateImpl(Purchase purchase);

	/**
	 * Returns the purchase with the primary key or throws a <code>NoSuchPurchaseException</code> if it could not be found.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	public Purchase findByPrimaryKey(long purchaseId)
		throws NoSuchPurchaseException;

	/**
	 * Returns the purchase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase, or <code>null</code> if a purchase with the primary key could not be found
	 */
	public Purchase fetchByPrimaryKey(long purchaseId);

	/**
	 * Returns all the purchases.
	 *
	 * @return the purchases
	 */
	public java.util.List<Purchase> findAll();

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
	public java.util.List<Purchase> findAll(int start, int end);

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
	public java.util.List<Purchase> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator);

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
	public java.util.List<Purchase> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the purchases from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of purchases.
	 *
	 * @return the number of purchases
	 */
	public int countAll();

}