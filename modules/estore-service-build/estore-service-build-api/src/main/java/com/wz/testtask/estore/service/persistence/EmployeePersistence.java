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

import com.wz.testtask.estore.exception.NoSuchEmployeeException;
import com.wz.testtask.estore.model.Employee;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author wz
 * @see EmployeeUtil
 * @generated
 */
@ProviderType
public interface EmployeePersistence extends BasePersistence<Employee> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeUtil} to access the employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employees
	 */
	public java.util.List<Employee> findByUuid(String uuid);

	/**
	 * Returns a range of all the employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public java.util.List<Employee> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public java.util.List<Employee> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public java.util.List<Employee> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public Employee findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Returns the first employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public Employee fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns the last employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public Employee findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Returns the last employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public Employee fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns the employees before and after the current employee in the ordered set where uuid = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public Employee[] findByUuid_PrevAndNext(
			long employeeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Removes all the employees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employees
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public Employee findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeException;

	/**
	 * Returns the employee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public Employee fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public Employee fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee that was removed
	 */
	public Employee removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeException;

	/**
	 * Returns the number of employees where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employees
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employees
	 */
	public java.util.List<Employee> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public java.util.List<Employee> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public java.util.List<Employee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public java.util.List<Employee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public Employee findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Returns the first employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public Employee fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns the last employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public Employee findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Returns the last employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public Employee fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns the employees before and after the current employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public Employee[] findByUuid_C_PrevAndNext(
			long employeeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Removes all the employees where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employees
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the employees where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching employees
	 */
	public java.util.List<Employee> findByGroupId(long groupId);

	/**
	 * Returns a range of all the employees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public java.util.List<Employee> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the employees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public java.util.List<Employee> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public java.util.List<Employee> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public Employee findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Returns the first employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public Employee fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns the last employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public Employee findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Returns the last employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public Employee fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns the employees before and after the current employee in the ordered set where groupId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public Employee[] findByGroupId_PrevAndNext(
			long employeeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Removes all the employees where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of employees where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching employees
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the employee where groupId = &#63; and firstName = &#63; and lastName = &#63; and patronymic = &#63; or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param patronymic the patronymic
	 * @return the matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public Employee findByByFullName(
			long groupId, String firstName, String lastName, String patronymic)
		throws NoSuchEmployeeException;

	/**
	 * Returns the employee where groupId = &#63; and firstName = &#63; and lastName = &#63; and patronymic = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param patronymic the patronymic
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public Employee fetchByByFullName(
		long groupId, String firstName, String lastName, String patronymic);

	/**
	 * Returns the employee where groupId = &#63; and firstName = &#63; and lastName = &#63; and patronymic = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param patronymic the patronymic
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public Employee fetchByByFullName(
		long groupId, String firstName, String lastName, String patronymic,
		boolean useFinderCache);

	/**
	 * Removes the employee where groupId = &#63; and firstName = &#63; and lastName = &#63; and patronymic = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param patronymic the patronymic
	 * @return the employee that was removed
	 */
	public Employee removeByByFullName(
			long groupId, String firstName, String lastName, String patronymic)
		throws NoSuchEmployeeException;

	/**
	 * Returns the number of employees where groupId = &#63; and firstName = &#63; and lastName = &#63; and patronymic = &#63;.
	 *
	 * @param groupId the group ID
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param patronymic the patronymic
	 * @return the number of matching employees
	 */
	public int countByByFullName(
		long groupId, String firstName, String lastName, String patronymic);

	/**
	 * Returns all the employees where groupId = &#63; and positionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param positionId the position ID
	 * @return the matching employees
	 */
	public java.util.List<Employee> findByGroupIdPositionId(
		long groupId, long positionId);

	/**
	 * Returns a range of all the employees where groupId = &#63; and positionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param positionId the position ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public java.util.List<Employee> findByGroupIdPositionId(
		long groupId, long positionId, int start, int end);

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and positionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param positionId the position ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public java.util.List<Employee> findByGroupIdPositionId(
		long groupId, long positionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and positionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param positionId the position ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public java.util.List<Employee> findByGroupIdPositionId(
		long groupId, long positionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee in the ordered set where groupId = &#63; and positionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param positionId the position ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public Employee findByGroupIdPositionId_First(
			long groupId, long positionId,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Returns the first employee in the ordered set where groupId = &#63; and positionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param positionId the position ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public Employee fetchByGroupIdPositionId_First(
		long groupId, long positionId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and positionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param positionId the position ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public Employee findByGroupIdPositionId_Last(
			long groupId, long positionId,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and positionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param positionId the position ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public Employee fetchByGroupIdPositionId_Last(
		long groupId, long positionId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns the employees before and after the current employee in the ordered set where groupId = &#63; and positionId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param positionId the position ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public Employee[] findByGroupIdPositionId_PrevAndNext(
			long employeeId, long groupId, long positionId,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Removes all the employees where groupId = &#63; and positionId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param positionId the position ID
	 */
	public void removeByGroupIdPositionId(long groupId, long positionId);

	/**
	 * Returns the number of employees where groupId = &#63; and positionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param positionId the position ID
	 * @return the number of matching employees
	 */
	public int countByGroupIdPositionId(long groupId, long positionId);

	/**
	 * Caches the employee in the entity cache if it is enabled.
	 *
	 * @param employee the employee
	 */
	public void cacheResult(Employee employee);

	/**
	 * Caches the employees in the entity cache if it is enabled.
	 *
	 * @param employees the employees
	 */
	public void cacheResult(java.util.List<Employee> employees);

	/**
	 * Creates a new employee with the primary key. Does not add the employee to the database.
	 *
	 * @param employeeId the primary key for the new employee
	 * @return the new employee
	 */
	public Employee create(long employeeId);

	/**
	 * Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee that was removed
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public Employee remove(long employeeId) throws NoSuchEmployeeException;

	public Employee updateImpl(Employee employee);

	/**
	 * Returns the employee with the primary key or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public Employee findByPrimaryKey(long employeeId)
		throws NoSuchEmployeeException;

	/**
	 * Returns the employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee, or <code>null</code> if a employee with the primary key could not be found
	 */
	public Employee fetchByPrimaryKey(long employeeId);

	/**
	 * Returns all the employees.
	 *
	 * @return the employees
	 */
	public java.util.List<Employee> findAll();

	/**
	 * Returns a range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of employees
	 */
	public java.util.List<Employee> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employees
	 */
	public java.util.List<Employee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employees
	 */
	public java.util.List<Employee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employees from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employees.
	 *
	 * @return the number of employees
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of device types associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @return long[] of the primaryKeys of device types associated with the employee
	 */
	public long[] getDeviceTypePrimaryKeys(long pk);

	/**
	 * Returns all the employee associated with the device type.
	 *
	 * @param pk the primary key of the device type
	 * @return the employees associated with the device type
	 */
	public java.util.List<Employee> getDeviceTypeEmployees(long pk);

	/**
	 * Returns all the employee associated with the device type.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the device type
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @return the range of employees associated with the device type
	 */
	public java.util.List<Employee> getDeviceTypeEmployees(
		long pk, int start, int end);

	/**
	 * Returns all the employee associated with the device type.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the device type
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employees associated with the device type
	 */
	public java.util.List<Employee> getDeviceTypeEmployees(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns the number of device types associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @return the number of device types associated with the employee
	 */
	public int getDeviceTypesSize(long pk);

	/**
	 * Returns <code>true</code> if the device type is associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @param deviceTypePK the primary key of the device type
	 * @return <code>true</code> if the device type is associated with the employee; <code>false</code> otherwise
	 */
	public boolean containsDeviceType(long pk, long deviceTypePK);

	/**
	 * Returns <code>true</code> if the employee has any device types associated with it.
	 *
	 * @param pk the primary key of the employee to check for associations with device types
	 * @return <code>true</code> if the employee has any device types associated with it; <code>false</code> otherwise
	 */
	public boolean containsDeviceTypes(long pk);

	/**
	 * Adds an association between the employee and the device type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param deviceTypePK the primary key of the device type
	 */
	public void addDeviceType(long pk, long deviceTypePK);

	/**
	 * Adds an association between the employee and the device type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param deviceType the device type
	 */
	public void addDeviceType(
		long pk, com.wz.testtask.estore.model.DeviceType deviceType);

	/**
	 * Adds an association between the employee and the device types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param deviceTypePKs the primary keys of the device types
	 */
	public void addDeviceTypes(long pk, long[] deviceTypePKs);

	/**
	 * Adds an association between the employee and the device types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param deviceTypes the device types
	 */
	public void addDeviceTypes(
		long pk,
		java.util.List<com.wz.testtask.estore.model.DeviceType> deviceTypes);

	/**
	 * Clears all associations between the employee and its device types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee to clear the associated device types from
	 */
	public void clearDeviceTypes(long pk);

	/**
	 * Removes the association between the employee and the device type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param deviceTypePK the primary key of the device type
	 */
	public void removeDeviceType(long pk, long deviceTypePK);

	/**
	 * Removes the association between the employee and the device type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param deviceType the device type
	 */
	public void removeDeviceType(
		long pk, com.wz.testtask.estore.model.DeviceType deviceType);

	/**
	 * Removes the association between the employee and the device types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param deviceTypePKs the primary keys of the device types
	 */
	public void removeDeviceTypes(long pk, long[] deviceTypePKs);

	/**
	 * Removes the association between the employee and the device types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param deviceTypes the device types
	 */
	public void removeDeviceTypes(
		long pk,
		java.util.List<com.wz.testtask.estore.model.DeviceType> deviceTypes);

	/**
	 * Sets the device types associated with the employee, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param deviceTypePKs the primary keys of the device types to be associated with the employee
	 */
	public void setDeviceTypes(long pk, long[] deviceTypePKs);

	/**
	 * Sets the device types associated with the employee, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param deviceTypes the device types to be associated with the employee
	 */
	public void setDeviceTypes(
		long pk,
		java.util.List<com.wz.testtask.estore.model.DeviceType> deviceTypes);

}