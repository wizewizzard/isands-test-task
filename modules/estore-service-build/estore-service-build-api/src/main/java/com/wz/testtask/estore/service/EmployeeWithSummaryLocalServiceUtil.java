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

import com.liferay.portal.kernel.exception.PortalException;

import com.wz.testtask.estore.model.EmployeeWithSummary;

import java.util.List;

/**
 * Provides the local service utility for EmployeeWithSummary. This utility wraps
 * <code>com.wz.testtask.estore.service.impl.EmployeeWithSummaryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author wz
 * @see EmployeeWithSummaryLocalService
 * @generated
 */
public class EmployeeWithSummaryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.wz.testtask.estore.service.impl.EmployeeWithSummaryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static List<EmployeeWithSummary> findBestDeviceTypeSellers(
			long groupId, long deviceTypeId, java.util.Date from,
			java.util.Date until, int begin, int end)
		throws PortalException {

		return getService().findBestDeviceTypeSellers(
			groupId, deviceTypeId, from, until, begin, end);
	}

	public static List<EmployeeWithSummary> findBestEmployees(
			String criteria, long groupId, long positionId, int begin, int end)
		throws PortalException {

		return getService().findBestEmployees(
			criteria, groupId, positionId, begin, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static EmployeeWithSummaryLocalService getService() {
		return _service;
	}

	private static volatile EmployeeWithSummaryLocalService _service;

}