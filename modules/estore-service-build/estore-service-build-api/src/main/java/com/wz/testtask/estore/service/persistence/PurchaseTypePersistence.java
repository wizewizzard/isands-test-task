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

import com.wz.testtask.estore.exception.NoSuchPurchaseTypeException;
import com.wz.testtask.estore.model.PurchaseType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the purchase type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author wz
 * @see PurchaseTypeUtil
 * @generated
 */
@ProviderType
public interface PurchaseTypePersistence extends BasePersistence<PurchaseType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PurchaseTypeUtil} to access the purchase type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the purchase types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching purchase types
	 */
	public java.util.List<PurchaseType> findByUuid(String uuid);

	/**
	 * Returns a range of all the purchase types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @return the range of matching purchase types
	 */
	public java.util.List<PurchaseType> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the purchase types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchase types
	 */
	public java.util.List<PurchaseType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the purchase types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchase types
	 */
	public java.util.List<PurchaseType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase type
	 * @throws NoSuchPurchaseTypeException if a matching purchase type could not be found
	 */
	public PurchaseType findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
				orderByComparator)
		throws NoSuchPurchaseTypeException;

	/**
	 * Returns the first purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	public PurchaseType fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
			orderByComparator);

	/**
	 * Returns the last purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase type
	 * @throws NoSuchPurchaseTypeException if a matching purchase type could not be found
	 */
	public PurchaseType findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
				orderByComparator)
		throws NoSuchPurchaseTypeException;

	/**
	 * Returns the last purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	public PurchaseType fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
			orderByComparator);

	/**
	 * Returns the purchase types before and after the current purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param purchaseTypeId the primary key of the current purchase type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase type
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	public PurchaseType[] findByUuid_PrevAndNext(
			long purchaseTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
				orderByComparator)
		throws NoSuchPurchaseTypeException;

	/**
	 * Removes all the purchase types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of purchase types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching purchase types
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the purchase type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPurchaseTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching purchase type
	 * @throws NoSuchPurchaseTypeException if a matching purchase type could not be found
	 */
	public PurchaseType findByUUID_G(String uuid, long groupId)
		throws NoSuchPurchaseTypeException;

	/**
	 * Returns the purchase type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	public PurchaseType fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the purchase type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	public PurchaseType fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the purchase type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the purchase type that was removed
	 */
	public PurchaseType removeByUUID_G(String uuid, long groupId)
		throws NoSuchPurchaseTypeException;

	/**
	 * Returns the number of purchase types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching purchase types
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the purchase types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching purchase types
	 */
	public java.util.List<PurchaseType> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the purchase types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @return the range of matching purchase types
	 */
	public java.util.List<PurchaseType> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the purchase types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchase types
	 */
	public java.util.List<PurchaseType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the purchase types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchase types
	 */
	public java.util.List<PurchaseType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first purchase type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase type
	 * @throws NoSuchPurchaseTypeException if a matching purchase type could not be found
	 */
	public PurchaseType findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
				orderByComparator)
		throws NoSuchPurchaseTypeException;

	/**
	 * Returns the first purchase type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	public PurchaseType fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
			orderByComparator);

	/**
	 * Returns the last purchase type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase type
	 * @throws NoSuchPurchaseTypeException if a matching purchase type could not be found
	 */
	public PurchaseType findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
				orderByComparator)
		throws NoSuchPurchaseTypeException;

	/**
	 * Returns the last purchase type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	public PurchaseType fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
			orderByComparator);

	/**
	 * Returns the purchase types before and after the current purchase type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param purchaseTypeId the primary key of the current purchase type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase type
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	public PurchaseType[] findByUuid_C_PrevAndNext(
			long purchaseTypeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
				orderByComparator)
		throws NoSuchPurchaseTypeException;

	/**
	 * Removes all the purchase types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of purchase types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching purchase types
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the purchase types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching purchase types
	 */
	public java.util.List<PurchaseType> findByGroupId(long groupId);

	/**
	 * Returns a range of all the purchase types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @return the range of matching purchase types
	 */
	public java.util.List<PurchaseType> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the purchase types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchase types
	 */
	public java.util.List<PurchaseType> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the purchase types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchase types
	 */
	public java.util.List<PurchaseType> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first purchase type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase type
	 * @throws NoSuchPurchaseTypeException if a matching purchase type could not be found
	 */
	public PurchaseType findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
				orderByComparator)
		throws NoSuchPurchaseTypeException;

	/**
	 * Returns the first purchase type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	public PurchaseType fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
			orderByComparator);

	/**
	 * Returns the last purchase type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase type
	 * @throws NoSuchPurchaseTypeException if a matching purchase type could not be found
	 */
	public PurchaseType findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
				orderByComparator)
		throws NoSuchPurchaseTypeException;

	/**
	 * Returns the last purchase type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	public PurchaseType fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
			orderByComparator);

	/**
	 * Returns the purchase types before and after the current purchase type in the ordered set where groupId = &#63;.
	 *
	 * @param purchaseTypeId the primary key of the current purchase type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase type
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	public PurchaseType[] findByGroupId_PrevAndNext(
			long purchaseTypeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
				orderByComparator)
		throws NoSuchPurchaseTypeException;

	/**
	 * Removes all the purchase types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of purchase types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching purchase types
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the purchase type where groupId = &#63; and name = &#63; or throws a <code>NoSuchPurchaseTypeException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching purchase type
	 * @throws NoSuchPurchaseTypeException if a matching purchase type could not be found
	 */
	public PurchaseType findByGroupIdName(long groupId, String name)
		throws NoSuchPurchaseTypeException;

	/**
	 * Returns the purchase type where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	public PurchaseType fetchByGroupIdName(long groupId, String name);

	/**
	 * Returns the purchase type where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	public PurchaseType fetchByGroupIdName(
		long groupId, String name, boolean useFinderCache);

	/**
	 * Removes the purchase type where groupId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the purchase type that was removed
	 */
	public PurchaseType removeByGroupIdName(long groupId, String name)
		throws NoSuchPurchaseTypeException;

	/**
	 * Returns the number of purchase types where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching purchase types
	 */
	public int countByGroupIdName(long groupId, String name);

	/**
	 * Caches the purchase type in the entity cache if it is enabled.
	 *
	 * @param purchaseType the purchase type
	 */
	public void cacheResult(PurchaseType purchaseType);

	/**
	 * Caches the purchase types in the entity cache if it is enabled.
	 *
	 * @param purchaseTypes the purchase types
	 */
	public void cacheResult(java.util.List<PurchaseType> purchaseTypes);

	/**
	 * Creates a new purchase type with the primary key. Does not add the purchase type to the database.
	 *
	 * @param purchaseTypeId the primary key for the new purchase type
	 * @return the new purchase type
	 */
	public PurchaseType create(long purchaseTypeId);

	/**
	 * Removes the purchase type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purchaseTypeId the primary key of the purchase type
	 * @return the purchase type that was removed
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	public PurchaseType remove(long purchaseTypeId)
		throws NoSuchPurchaseTypeException;

	public PurchaseType updateImpl(PurchaseType purchaseType);

	/**
	 * Returns the purchase type with the primary key or throws a <code>NoSuchPurchaseTypeException</code> if it could not be found.
	 *
	 * @param purchaseTypeId the primary key of the purchase type
	 * @return the purchase type
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	public PurchaseType findByPrimaryKey(long purchaseTypeId)
		throws NoSuchPurchaseTypeException;

	/**
	 * Returns the purchase type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param purchaseTypeId the primary key of the purchase type
	 * @return the purchase type, or <code>null</code> if a purchase type with the primary key could not be found
	 */
	public PurchaseType fetchByPrimaryKey(long purchaseTypeId);

	/**
	 * Returns all the purchase types.
	 *
	 * @return the purchase types
	 */
	public java.util.List<PurchaseType> findAll();

	/**
	 * Returns a range of all the purchase types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @return the range of purchase types
	 */
	public java.util.List<PurchaseType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the purchase types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of purchase types
	 */
	public java.util.List<PurchaseType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the purchase types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of purchase types
	 */
	public java.util.List<PurchaseType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PurchaseType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the purchase types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of purchase types.
	 *
	 * @return the number of purchase types
	 */
	public int countAll();

}