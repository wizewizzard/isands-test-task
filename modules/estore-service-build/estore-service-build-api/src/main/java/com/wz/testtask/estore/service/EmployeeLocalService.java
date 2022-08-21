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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.wz.testtask.estore.model.Employee;

import java.io.Serializable;

import java.time.LocalDate;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Employee. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author wz
 * @see EmployeeLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EmployeeLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.wz.testtask.estore.service.impl.EmployeeLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the employee local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EmployeeLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void addDeviceTypeEmployee(long deviceTypeId, Employee employee);

	public void addDeviceTypeEmployee(long deviceTypeId, long employeeId);

	public void addDeviceTypeEmployees(
		long deviceTypeId, List<Employee> employees);

	public void addDeviceTypeEmployees(long deviceTypeId, long[] employeeIds);

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
	@Indexable(type = IndexableType.REINDEX)
	public Employee addEmployee(Employee employee);

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
	public Employee addEmployee(
			String firstName, String lastName, String patronymic,
			LocalDate birthDate, String gender, long positionId,
			ServiceContext serviceContext)
		throws PortalException;

	public void clearDeviceTypeEmployees(long deviceTypeId);

	/**
	 * Creates a new employee with the primary key. Does not add the employee to the database.
	 *
	 * @param employeeId the primary key for the new employee
	 * @return the new employee
	 */
	@Transactional(enabled = false)
	public Employee createEmployee(long employeeId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public Employee delete(Employee employee, ServiceContext serviceContext)
		throws PortalException;

	public Employee deleteById(long employeeId, ServiceContext serviceContext)
		throws PortalException;

	public void deleteDeviceTypeEmployee(long deviceTypeId, Employee employee);

	public void deleteDeviceTypeEmployee(long deviceTypeId, long employeeId);

	public void deleteDeviceTypeEmployees(
		long deviceTypeId, List<Employee> employees);

	public void deleteDeviceTypeEmployees(
		long deviceTypeId, long[] employeeIds);

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
	@Indexable(type = IndexableType.DELETE)
	public Employee deleteEmployee(Employee employee);

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
	@Indexable(type = IndexableType.DELETE)
	public Employee deleteEmployee(long employeeId) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Employee fetchEmployee(long employeeId);

	/**
	 * Returns the employee matching the UUID and group.
	 *
	 * @param uuid the employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Employee fetchEmployeeByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Employee> getDeviceTypeEmployees(long deviceTypeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Employee> getDeviceTypeEmployees(
		long deviceTypeId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Employee> getDeviceTypeEmployees(
		long deviceTypeId, int start, int end,
		OrderByComparator<Employee> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDeviceTypeEmployeesCount(long deviceTypeId);

	/**
	 * Returns the deviceTypeIds of the device types associated with the employee.
	 *
	 * @param employeeId the employeeId of the employee
	 * @return long[] the deviceTypeIds of device types associated with the employee
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getDeviceTypePrimaryKeys(long employeeId);

	/**
	 * Returns the employee with the primary key.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee
	 * @throws PortalException if a employee with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Employee getEmployee(long employeeId) throws PortalException;

	/**
	 * Returns the employee matching the UUID and group.
	 *
	 * @param uuid the employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee
	 * @throws PortalException if a matching employee could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Employee getEmployeeByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Employee> getEmployees(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Employee> getEmployees(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Employee> getEmployees(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Employee> getEmployees(
		long groupId, int start, int end, OrderByComparator<Employee> obc);

	/**
	 * Returns all the employees matching the UUID and company.
	 *
	 * @param uuid the UUID of the employees
	 * @param companyId the primary key of the company
	 * @return the matching employees, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Employee> getEmployeesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Employee> getEmployeesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Employee> orderByComparator);

	/**
	 * Returns the number of employees.
	 *
	 * @return the number of employees
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEmployeesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEmployeesCount(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasDeviceTypeEmployee(long deviceTypeId, long employeeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasDeviceTypeEmployees(long deviceTypeId);

	public void setDeviceTypeEmployees(long deviceTypeId, long[] employeeIds);

	public Employee setEmployeePosition(
			long employeeId, long positionId, ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public Employee updateEmployee(Employee employee);

	public Employee updateEmployee(
			long employeeId, String firstName, String lastName,
			String patronymic, LocalDate birthDate, String gender,
			long positionId, ServiceContext serviceContext)
		throws PortalException;

}