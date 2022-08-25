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
 * Provides a wrapper for {@link EmployeeService}.
 *
 * @author wz
 * @see EmployeeService
 * @generated
 */
public class EmployeeServiceWrapper
	implements EmployeeService, ServiceWrapper<EmployeeService> {

	public EmployeeServiceWrapper(EmployeeService employeeService) {
		_employeeService = employeeService;
	}

	@Override
	public com.wz.testtask.estore.model.Employee getEmployeeById(
			long employeeId)
		throws com.wz.testtask.estore.exception.NoSuchEmployeeException {

		return _employeeService.getEmployeeById(employeeId);
	}

	@Override
	public java.util.List<com.wz.testtask.estore.model.Employee> getEmployees(
		long groupId) {

		return _employeeService.getEmployees(groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeService getWrappedService() {
		return _employeeService;
	}

	@Override
	public void setWrappedService(EmployeeService employeeService) {
		_employeeService = employeeService;
	}

	private EmployeeService _employeeService;

}