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
 * Provides a wrapper for {@link EmployeeLocalService}.
 *
 * @author wz
 * @see EmployeeLocalService
 * @generated
 */
public class EmployeeLocalServiceWrapper
	implements EmployeeLocalService, ServiceWrapper<EmployeeLocalService> {

	public EmployeeLocalServiceWrapper(
		EmployeeLocalService employeeLocalService) {

		_employeeLocalService = employeeLocalService;
	}

	@Override
	public void addDeviceTypeEmployee(
		long deviceTypeId, com.wz.testtask.estore.model.Employee employee) {

		_employeeLocalService.addDeviceTypeEmployee(deviceTypeId, employee);
	}

	@Override
	public void addDeviceTypeEmployee(long deviceTypeId, long employeeId) {
		_employeeLocalService.addDeviceTypeEmployee(deviceTypeId, employeeId);
	}

	@Override
	public void addDeviceTypeEmployees(
		long deviceTypeId,
		java.util.List<com.wz.testtask.estore.model.Employee> employees) {

		_employeeLocalService.addDeviceTypeEmployees(deviceTypeId, employees);
	}

	@Override
	public void addDeviceTypeEmployees(long deviceTypeId, long[] employeeIds) {
		_employeeLocalService.addDeviceTypeEmployees(deviceTypeId, employeeIds);
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
	@Override
	public com.wz.testtask.estore.model.Employee addEmployee(
		com.wz.testtask.estore.model.Employee employee) {

		return _employeeLocalService.addEmployee(employee);
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
	@Override
	public com.wz.testtask.estore.model.Employee addEmployee(
			String firstName, String lastName, String patronymic,
			java.util.Date birthDate, String gender, long positionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.addEmployee(
			firstName, lastName, patronymic, birthDate, gender, positionId,
			serviceContext);
	}

	@Override
	public void clearDeviceTypeEmployees(long deviceTypeId) {
		_employeeLocalService.clearDeviceTypeEmployees(deviceTypeId);
	}

	/**
	 * Creates a new employee with the primary key. Does not add the employee to the database.
	 *
	 * @param employeeId the primary key for the new employee
	 * @return the new employee
	 */
	@Override
	public com.wz.testtask.estore.model.Employee createEmployee(
		long employeeId) {

		return _employeeLocalService.createEmployee(employeeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public com.wz.testtask.estore.model.Employee delete(
			com.wz.testtask.estore.model.Employee employee,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.delete(employee, serviceContext);
	}

	@Override
	public com.wz.testtask.estore.model.Employee deleteById(
			long employeeId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.deleteById(employeeId, serviceContext);
	}

	@Override
	public void deleteDeviceTypeEmployee(
		long deviceTypeId, com.wz.testtask.estore.model.Employee employee) {

		_employeeLocalService.deleteDeviceTypeEmployee(deviceTypeId, employee);
	}

	@Override
	public void deleteDeviceTypeEmployee(long deviceTypeId, long employeeId) {
		_employeeLocalService.deleteDeviceTypeEmployee(
			deviceTypeId, employeeId);
	}

	@Override
	public void deleteDeviceTypeEmployees(
		long deviceTypeId,
		java.util.List<com.wz.testtask.estore.model.Employee> employees) {

		_employeeLocalService.deleteDeviceTypeEmployees(
			deviceTypeId, employees);
	}

	@Override
	public void deleteDeviceTypeEmployees(
		long deviceTypeId, long[] employeeIds) {

		_employeeLocalService.deleteDeviceTypeEmployees(
			deviceTypeId, employeeIds);
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
	@Override
	public com.wz.testtask.estore.model.Employee deleteEmployee(
		com.wz.testtask.estore.model.Employee employee) {

		return _employeeLocalService.deleteEmployee(employee);
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
	@Override
	public com.wz.testtask.estore.model.Employee deleteEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.deleteEmployee(employeeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeLocalService.dynamicQuery();
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

		return _employeeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _employeeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _employeeLocalService.dynamicQuery(
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

		return _employeeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.wz.testtask.estore.model.Employee fetchEmployee(
		long employeeId) {

		return _employeeLocalService.fetchEmployee(employeeId);
	}

	/**
	 * Returns the employee matching the UUID and group.
	 *
	 * @param uuid the employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.Employee fetchEmployeeByUuidAndGroupId(
		String uuid, long groupId) {

		return _employeeLocalService.fetchEmployeeByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Employee>
		getDeviceTypeEmployees(long deviceTypeId) {

		return _employeeLocalService.getDeviceTypeEmployees(deviceTypeId);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Employee>
		getDeviceTypeEmployees(long deviceTypeId, int start, int end) {

		return _employeeLocalService.getDeviceTypeEmployees(
			deviceTypeId, start, end);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Employee>
		getDeviceTypeEmployees(
			long deviceTypeId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.wz.testtask.estore.model.Employee> orderByComparator) {

		return _employeeLocalService.getDeviceTypeEmployees(
			deviceTypeId, start, end, orderByComparator);
	}

	@Override
	public int getDeviceTypeEmployeesCount(long deviceTypeId) {
		return _employeeLocalService.getDeviceTypeEmployeesCount(deviceTypeId);
	}

	/**
	 * Returns the deviceTypeIds of the device types associated with the employee.
	 *
	 * @param employeeId the employeeId of the employee
	 * @return long[] the deviceTypeIds of device types associated with the employee
	 */
	@Override
	public long[] getDeviceTypePrimaryKeys(long employeeId) {
		return _employeeLocalService.getDeviceTypePrimaryKeys(employeeId);
	}

	/**
	 * Returns the employee with the primary key.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee
	 * @throws PortalException if a employee with the primary key could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.Employee getEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getEmployee(employeeId);
	}

	/**
	 * Returns the employee matching the UUID and group.
	 *
	 * @param uuid the employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee
	 * @throws PortalException if a matching employee could not be found
	 */
	@Override
	public com.wz.testtask.estore.model.Employee getEmployeeByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getEmployeeByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.wz.testtask.estore.model.Employee> getEmployees(
		int start, int end) {

		return _employeeLocalService.getEmployees(start, end);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Employee> getEmployees(
		long groupId) {

		return _employeeLocalService.getEmployees(groupId);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Employee> getEmployees(
		long groupId, int start, int end) {

		return _employeeLocalService.getEmployees(groupId, start, end);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Employee> getEmployees(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.wz.testtask.estore.model.Employee> obc) {

		return _employeeLocalService.getEmployees(groupId, start, end, obc);
	}

	/**
	 * Returns all the employees matching the UUID and company.
	 *
	 * @param uuid the UUID of the employees
	 * @param companyId the primary key of the company
	 * @return the matching employees, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.wz.testtask.estore.model.Employee>
		getEmployeesByUuidAndCompanyId(String uuid, long companyId) {

		return _employeeLocalService.getEmployeesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.wz.testtask.estore.model.Employee>
		getEmployeesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.wz.testtask.estore.model.Employee> orderByComparator) {

		return _employeeLocalService.getEmployeesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employees.
	 *
	 * @return the number of employees
	 */
	@Override
	public int getEmployeesCount() {
		return _employeeLocalService.getEmployeesCount();
	}

	@Override
	public int getEmployeesCount(long groupId) {
		return _employeeLocalService.getEmployeesCount(groupId);
	}

	@Override
	public String getGenderById(int genderId) {
		return _employeeLocalService.getGenderById(genderId);
	}

	@Override
	public java.util.List<String> getGenderList() {
		return _employeeLocalService.getGenderList();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasDeviceTypeEmployee(long deviceTypeId, long employeeId) {
		return _employeeLocalService.hasDeviceTypeEmployee(
			deviceTypeId, employeeId);
	}

	@Override
	public boolean hasDeviceTypeEmployees(long deviceTypeId) {
		return _employeeLocalService.hasDeviceTypeEmployees(deviceTypeId);
	}

	@Override
	public void setDeviceTypeEmployees(long deviceTypeId, long[] employeeIds) {
		_employeeLocalService.setDeviceTypeEmployees(deviceTypeId, employeeIds);
	}

	@Override
	public com.wz.testtask.estore.model.Employee setEmployeePosition(
			long employeeId, long positionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.setEmployeePosition(
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
	@Override
	public com.wz.testtask.estore.model.Employee updateEmployee(
		com.wz.testtask.estore.model.Employee employee) {

		return _employeeLocalService.updateEmployee(employee);
	}

	@Override
	public com.wz.testtask.estore.model.Employee updateEmployee(
			long employeeId, String firstName, String lastName,
			String patronymic, java.util.Date birthDate, String gender,
			long positionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.updateEmployee(
			employeeId, firstName, lastName, patronymic, birthDate, gender,
			positionId, serviceContext);
	}

	@Override
	public EmployeeLocalService getWrappedService() {
		return _employeeLocalService;
	}

	@Override
	public void setWrappedService(EmployeeLocalService employeeLocalService) {
		_employeeLocalService = employeeLocalService;
	}

	private EmployeeLocalService _employeeLocalService;

}