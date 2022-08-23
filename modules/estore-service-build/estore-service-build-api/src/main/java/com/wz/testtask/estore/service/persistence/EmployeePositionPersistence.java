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

import com.wz.testtask.estore.exception.NoSuchEmployeePositionException;
import com.wz.testtask.estore.model.EmployeePosition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author wz
 * @see EmployeePositionUtil
 * @generated
 */
@ProviderType
public interface EmployeePositionPersistence
	extends BasePersistence<EmployeePosition> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeePositionUtil} to access the employee position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee positions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee positions
	 */
	public java.util.List<EmployeePosition> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee positions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @return the range of matching employee positions
	 */
	public java.util.List<EmployeePosition> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee positions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee positions
	 */
	public java.util.List<EmployeePosition> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee positions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee positions
	 */
	public java.util.List<EmployeePosition> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee position in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee position
	 * @throws NoSuchEmployeePositionException if a matching employee position could not be found
	 */
	public EmployeePosition findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
				orderByComparator)
		throws NoSuchEmployeePositionException;

	/**
	 * Returns the first employee position in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee position, or <code>null</code> if a matching employee position could not be found
	 */
	public EmployeePosition fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator);

	/**
	 * Returns the last employee position in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee position
	 * @throws NoSuchEmployeePositionException if a matching employee position could not be found
	 */
	public EmployeePosition findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
				orderByComparator)
		throws NoSuchEmployeePositionException;

	/**
	 * Returns the last employee position in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee position, or <code>null</code> if a matching employee position could not be found
	 */
	public EmployeePosition fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator);

	/**
	 * Returns the employee positions before and after the current employee position in the ordered set where uuid = &#63;.
	 *
	 * @param positionId the primary key of the current employee position
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee position
	 * @throws NoSuchEmployeePositionException if a employee position with the primary key could not be found
	 */
	public EmployeePosition[] findByUuid_PrevAndNext(
			long positionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
				orderByComparator)
		throws NoSuchEmployeePositionException;

	/**
	 * Removes all the employee positions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee positions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee positions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee position where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeePositionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee position
	 * @throws NoSuchEmployeePositionException if a matching employee position could not be found
	 */
	public EmployeePosition findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeePositionException;

	/**
	 * Returns the employee position where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee position, or <code>null</code> if a matching employee position could not be found
	 */
	public EmployeePosition fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee position where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee position, or <code>null</code> if a matching employee position could not be found
	 */
	public EmployeePosition fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee position where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee position that was removed
	 */
	public EmployeePosition removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeePositionException;

	/**
	 * Returns the number of employee positions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee positions
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee positions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee positions
	 */
	public java.util.List<EmployeePosition> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee positions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @return the range of matching employee positions
	 */
	public java.util.List<EmployeePosition> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee positions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee positions
	 */
	public java.util.List<EmployeePosition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee positions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee positions
	 */
	public java.util.List<EmployeePosition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee position in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee position
	 * @throws NoSuchEmployeePositionException if a matching employee position could not be found
	 */
	public EmployeePosition findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
				orderByComparator)
		throws NoSuchEmployeePositionException;

	/**
	 * Returns the first employee position in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee position, or <code>null</code> if a matching employee position could not be found
	 */
	public EmployeePosition fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator);

	/**
	 * Returns the last employee position in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee position
	 * @throws NoSuchEmployeePositionException if a matching employee position could not be found
	 */
	public EmployeePosition findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
				orderByComparator)
		throws NoSuchEmployeePositionException;

	/**
	 * Returns the last employee position in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee position, or <code>null</code> if a matching employee position could not be found
	 */
	public EmployeePosition fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator);

	/**
	 * Returns the employee positions before and after the current employee position in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param positionId the primary key of the current employee position
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee position
	 * @throws NoSuchEmployeePositionException if a employee position with the primary key could not be found
	 */
	public EmployeePosition[] findByUuid_C_PrevAndNext(
			long positionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
				orderByComparator)
		throws NoSuchEmployeePositionException;

	/**
	 * Removes all the employee positions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee positions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee positions
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the employee positions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching employee positions
	 */
	public java.util.List<EmployeePosition> findByGroupId(long groupId);

	/**
	 * Returns a range of all the employee positions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @return the range of matching employee positions
	 */
	public java.util.List<EmployeePosition> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the employee positions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee positions
	 */
	public java.util.List<EmployeePosition> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee positions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee positions
	 */
	public java.util.List<EmployeePosition> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee position in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee position
	 * @throws NoSuchEmployeePositionException if a matching employee position could not be found
	 */
	public EmployeePosition findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
				orderByComparator)
		throws NoSuchEmployeePositionException;

	/**
	 * Returns the first employee position in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee position, or <code>null</code> if a matching employee position could not be found
	 */
	public EmployeePosition fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator);

	/**
	 * Returns the last employee position in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee position
	 * @throws NoSuchEmployeePositionException if a matching employee position could not be found
	 */
	public EmployeePosition findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
				orderByComparator)
		throws NoSuchEmployeePositionException;

	/**
	 * Returns the last employee position in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee position, or <code>null</code> if a matching employee position could not be found
	 */
	public EmployeePosition fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator);

	/**
	 * Returns the employee positions before and after the current employee position in the ordered set where groupId = &#63;.
	 *
	 * @param positionId the primary key of the current employee position
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee position
	 * @throws NoSuchEmployeePositionException if a employee position with the primary key could not be found
	 */
	public EmployeePosition[] findByGroupId_PrevAndNext(
			long positionId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
				orderByComparator)
		throws NoSuchEmployeePositionException;

	/**
	 * Removes all the employee positions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of employee positions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching employee positions
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the employee positions where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching employee positions
	 */
	public java.util.List<EmployeePosition> findByGroupIdName(
		long groupId, String name);

	/**
	 * Returns a range of all the employee positions where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @return the range of matching employee positions
	 */
	public java.util.List<EmployeePosition> findByGroupIdName(
		long groupId, String name, int start, int end);

	/**
	 * Returns an ordered range of all the employee positions where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee positions
	 */
	public java.util.List<EmployeePosition> findByGroupIdName(
		long groupId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee positions where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee positions
	 */
	public java.util.List<EmployeePosition> findByGroupIdName(
		long groupId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee position in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee position
	 * @throws NoSuchEmployeePositionException if a matching employee position could not be found
	 */
	public EmployeePosition findByGroupIdName_First(
			long groupId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
				orderByComparator)
		throws NoSuchEmployeePositionException;

	/**
	 * Returns the first employee position in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee position, or <code>null</code> if a matching employee position could not be found
	 */
	public EmployeePosition fetchByGroupIdName_First(
		long groupId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator);

	/**
	 * Returns the last employee position in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee position
	 * @throws NoSuchEmployeePositionException if a matching employee position could not be found
	 */
	public EmployeePosition findByGroupIdName_Last(
			long groupId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
				orderByComparator)
		throws NoSuchEmployeePositionException;

	/**
	 * Returns the last employee position in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee position, or <code>null</code> if a matching employee position could not be found
	 */
	public EmployeePosition fetchByGroupIdName_Last(
		long groupId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator);

	/**
	 * Returns the employee positions before and after the current employee position in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param positionId the primary key of the current employee position
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee position
	 * @throws NoSuchEmployeePositionException if a employee position with the primary key could not be found
	 */
	public EmployeePosition[] findByGroupIdName_PrevAndNext(
			long positionId, long groupId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
				orderByComparator)
		throws NoSuchEmployeePositionException;

	/**
	 * Removes all the employee positions where groupId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 */
	public void removeByGroupIdName(long groupId, String name);

	/**
	 * Returns the number of employee positions where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching employee positions
	 */
	public int countByGroupIdName(long groupId, String name);

	/**
	 * Caches the employee position in the entity cache if it is enabled.
	 *
	 * @param employeePosition the employee position
	 */
	public void cacheResult(EmployeePosition employeePosition);

	/**
	 * Caches the employee positions in the entity cache if it is enabled.
	 *
	 * @param employeePositions the employee positions
	 */
	public void cacheResult(java.util.List<EmployeePosition> employeePositions);

	/**
	 * Creates a new employee position with the primary key. Does not add the employee position to the database.
	 *
	 * @param positionId the primary key for the new employee position
	 * @return the new employee position
	 */
	public EmployeePosition create(long positionId);

	/**
	 * Removes the employee position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param positionId the primary key of the employee position
	 * @return the employee position that was removed
	 * @throws NoSuchEmployeePositionException if a employee position with the primary key could not be found
	 */
	public EmployeePosition remove(long positionId)
		throws NoSuchEmployeePositionException;

	public EmployeePosition updateImpl(EmployeePosition employeePosition);

	/**
	 * Returns the employee position with the primary key or throws a <code>NoSuchEmployeePositionException</code> if it could not be found.
	 *
	 * @param positionId the primary key of the employee position
	 * @return the employee position
	 * @throws NoSuchEmployeePositionException if a employee position with the primary key could not be found
	 */
	public EmployeePosition findByPrimaryKey(long positionId)
		throws NoSuchEmployeePositionException;

	/**
	 * Returns the employee position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param positionId the primary key of the employee position
	 * @return the employee position, or <code>null</code> if a employee position with the primary key could not be found
	 */
	public EmployeePosition fetchByPrimaryKey(long positionId);

	/**
	 * Returns all the employee positions.
	 *
	 * @return the employee positions
	 */
	public java.util.List<EmployeePosition> findAll();

	/**
	 * Returns a range of all the employee positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @return the range of employee positions
	 */
	public java.util.List<EmployeePosition> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee positions
	 */
	public java.util.List<EmployeePosition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePositionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee positions
	 * @param end the upper bound of the range of employee positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee positions
	 */
	public java.util.List<EmployeePosition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePosition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee positions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee positions.
	 *
	 * @return the number of employee positions
	 */
	public int countAll();

}