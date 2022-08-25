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

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author wz
 * @generated
 */
@ProviderType
public interface EmployeeWithSummaryFinder {

	public java.util.List<com.wz.testtask.estore.model.EmployeeWithSummary>
			findBestEmployeesByDevicesSoldSummary(
				long groupId, long positionId, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException;

	public java.util.List<com.wz.testtask.estore.model.EmployeeWithSummary>
			findBestEmployeesByDevicesSoldCount(
				long groupId, long positionId, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException;

	public java.util.List<com.wz.testtask.estore.model.EmployeeWithSummary>
			findBestDeviceSellersDuringPeriod(
				long groupId, long deviceTypeId, java.util.Date from,
				java.util.Date until, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException;

}