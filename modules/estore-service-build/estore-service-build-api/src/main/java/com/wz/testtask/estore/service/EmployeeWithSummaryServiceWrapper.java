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
 * Provides a wrapper for {@link EmployeeWithSummaryService}.
 *
 * @author wz
 * @see EmployeeWithSummaryService
 * @generated
 */
public class EmployeeWithSummaryServiceWrapper
	implements EmployeeWithSummaryService,
			   ServiceWrapper<EmployeeWithSummaryService> {

	public EmployeeWithSummaryServiceWrapper(
		EmployeeWithSummaryService employeeWithSummaryService) {

		_employeeWithSummaryService = employeeWithSummaryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeWithSummaryService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeWithSummaryService getWrappedService() {
		return _employeeWithSummaryService;
	}

	@Override
	public void setWrappedService(
		EmployeeWithSummaryService employeeWithSummaryService) {

		_employeeWithSummaryService = employeeWithSummaryService;
	}

	private EmployeeWithSummaryService _employeeWithSummaryService;

}