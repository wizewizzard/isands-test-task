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

import com.wz.testtask.estore.model.Employee;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Employee. This utility wraps
 * <code>com.wz.testtask.estore.service.impl.EmployeeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author wz
 * @see EmployeeLocalService
 * @generated
 */
public class EmployeeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.wz.testtask.estore.service.impl.EmployeeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addDeviceTypeEmployee(
		long deviceTypeId, Employee employee) {

		getService().addDeviceTypeEmployee(deviceTypeId, employee);
	}

	public static void addDeviceTypeEmployee(
		long deviceTypeId, long employeeId) {

		getService().addDeviceTypeEmployee(deviceTypeId, employeeId);
	}

	public static void addDeviceTypeEmployees(
		long deviceTypeId, List<Employee> employees) {

		getService().addDeviceTypeEmployees(deviceTypeId, employees);
	}

	public static void addDeviceTypeEmployees(
		long deviceTypeId, long[] employeeIds) {

		getService().addDeviceTypeEmployees(deviceTypeId, employeeIds);
	}

	/**
	 * Adds the employee to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employee the employee
	 * @return the employee that was added
	 */
	public static Employee addEmployee(Employee employee) {
		return getService().addEmployee(employee);
	}

	/**
	 * @param firstName      employee's first name
	 * @param lastName       employee's last name
	 * @param patronymic     employee's patronymic
	 * @param birthDate      employee's birth date
	 * @param gender         a value from {@link com.wz.testtask.estore.service.persistence.impl.constants.EmployeeConstants.GENDER}
	 representing person's gender
	 * @param serviceContext
	 * @return created instance
	 */
	public static Employee addEmployee(
			String firstName, String lastName, String patronymic,
			java.time.LocalDate birthDate, String gender, long positionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addEmployee(
			firstName, lastName, patronymic, birthDate, gender, positionId,
			serviceContext);
	}

	public static void clearDeviceTypeEmployees(long deviceTypeId) {
		getService().clearDeviceTypeEmployees(deviceTypeId);
	}

	/**
	 * Creates a new employee with the primary key. Does not add the employee to the database.
	 *
	 * @param employeeId the primary key for the new employee
	 * @return the new employee
	 */
	public static Employee createEmployee(long employeeId) {
		return getService().createEmployee(employeeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static Employee delete(
			Employee employee,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().delete(employee, serviceContext);
	}

	public static Employee deleteById(
			long employeeId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().deleteById(employeeId, serviceContext);
	}

	public static void deleteDeviceTypeEmployee(
		long deviceTypeId, Employee employee) {

		getService().deleteDeviceTypeEmployee(deviceTypeId, employee);
	}

	public static void deleteDeviceTypeEmployee(
		long deviceTypeId, long employeeId) {

		getService().deleteDeviceTypeEmployee(deviceTypeId, employeeId);
	}

	public static void deleteDeviceTypeEmployees(
		long deviceTypeId, List<Employee> employees) {

		getService().deleteDeviceTypeEmployees(deviceTypeId, employees);
	}

	public static void deleteDeviceTypeEmployees(
		long deviceTypeId, long[] employeeIds) {

		getService().deleteDeviceTypeEmployees(deviceTypeId, employeeIds);
	}

	/**
	 * Deletes the employee from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employee the employee
	 * @return the employee that was removed
	 */
	public static Employee deleteEmployee(Employee employee) {
		return getService().deleteEmployee(employee);
	}

	/**
	 * Deletes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee that was removed
	 * @throws PortalException if a employee with the primary key could not be found
	 */
	public static Employee deleteEmployee(long employeeId)
		throws PortalException {

		return getService().deleteEmployee(employeeId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.EmployeeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.EmployeeModelImpl</code>.
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

	public static Employee fetchEmployee(long employeeId) {
		return getService().fetchEmployee(employeeId);
	}

	/**
	 * Returns the employee matching the UUID and group.
	 *
	 * @param uuid the employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchEmployeeByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEmployeeByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Employee> getDeviceTypeEmployees(long deviceTypeId) {
		return getService().getDeviceTypeEmployees(deviceTypeId);
	}

	public static List<Employee> getDeviceTypeEmployees(
		long deviceTypeId, int start, int end) {

		return getService().getDeviceTypeEmployees(deviceTypeId, start, end);
	}

	public static List<Employee> getDeviceTypeEmployees(
		long deviceTypeId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getService().getDeviceTypeEmployees(
			deviceTypeId, start, end, orderByComparator);
	}

	public static int getDeviceTypeEmployeesCount(long deviceTypeId) {
		return getService().getDeviceTypeEmployeesCount(deviceTypeId);
	}

	/**
	 * Returns the deviceTypeIds of the device types associated with the employee.
	 *
	 * @param employeeId the employeeId of the employee
	 * @return long[] the deviceTypeIds of device types associated with the employee
	 */
	public static long[] getDeviceTypePrimaryKeys(long employeeId) {
		return getService().getDeviceTypePrimaryKeys(employeeId);
	}

	/**
	 * Returns the employee with the primary key.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee
	 * @throws PortalException if a employee with the primary key could not be found
	 */
	public static Employee getEmployee(long employeeId) throws PortalException {
		return getService().getEmployee(employeeId);
	}

	/**
	 * Returns the employee matching the UUID and group.
	 *
	 * @param uuid the employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee
	 * @throws PortalException if a matching employee could not be found
	 */
	public static Employee getEmployeeByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEmployeeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.wz.testtask.estore.model.impl.EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of employees
	 */
	public static List<Employee> getEmployees(int start, int end) {
		return getService().getEmployees(start, end);
	}

	public static List<Employee> getEmployees(long groupId) {
		return getService().getEmployees(groupId);
	}

	public static List<Employee> getEmployees(
		long groupId, int start, int end) {

		return getService().getEmployees(groupId, start, end);
	}

	public static List<Employee> getEmployees(
		long groupId, int start, int end, OrderByComparator<Employee> obc) {

		return getService().getEmployees(groupId, start, end, obc);
	}

	/**
	 * Returns all the employees matching the UUID and company.
	 *
	 * @param uuid the UUID of the employees
	 * @param companyId the primary key of the company
	 * @return the matching employees, or an empty list if no matches were found
	 */
	public static List<Employee> getEmployeesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEmployeesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of employees matching the UUID and company.
	 *
	 * @param uuid the UUID of the employees
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employees, or an empty list if no matches were found
	 */
	public static List<Employee> getEmployeesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getService().getEmployeesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employees.
	 *
	 * @return the number of employees
	 */
	public static int getEmployeesCount() {
		return getService().getEmployeesCount();
	}

	public static int getEmployeesCount(long groupId) {
		return getService().getEmployeesCount(groupId);
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

	public static boolean hasDeviceTypeEmployee(
		long deviceTypeId, long employeeId) {

		return getService().hasDeviceTypeEmployee(deviceTypeId, employeeId);
	}

	public static boolean hasDeviceTypeEmployees(long deviceTypeId) {
		return getService().hasDeviceTypeEmployees(deviceTypeId);
	}

	public static void setDeviceTypeEmployees(
		long deviceTypeId, long[] employeeIds) {

		getService().setDeviceTypeEmployees(deviceTypeId, employeeIds);
	}

	public static Employee setEmployeePosition(
			long employeeId, long positionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setEmployeePosition(
			employeeId, positionId, serviceContext);
	}

	/**
	 * Updates the employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employee the employee
	 * @return the employee that was updated
	 */
	public static Employee updateEmployee(Employee employee) {
		return getService().updateEmployee(employee);
	}

	public static Employee updateEmployee(
			long employeeId, String firstName, String lastName,
			String patronymic, java.time.LocalDate birthDate, String gender,
			long positionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateEmployee(
			employeeId, firstName, lastName, patronymic, birthDate, gender,
			positionId, serviceContext);
	}

	public static EmployeeLocalService getService() {
		return _service;
	}

	private static volatile EmployeeLocalService _service;

}