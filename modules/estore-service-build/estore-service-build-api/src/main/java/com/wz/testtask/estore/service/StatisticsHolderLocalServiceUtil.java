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

import com.wz.testtask.estore.model.StatisticsHolder;

/**
 * Provides the local service utility for StatisticsHolder. This utility wraps
 * <code>com.wz.testtask.estore.service.impl.StatisticsHolderLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author wz
 * @see StatisticsHolderLocalService
 * @generated
 */
public class StatisticsHolderLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.wz.testtask.estore.service.impl.StatisticsHolderLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static StatisticsHolder getAmountOfMoneyPaidWithCard(long groupId)
		throws PortalException {

		return getService().getAmountOfMoneyPaidWithCard(groupId);
	}

	public static StatisticsHolder getCostOfArchivedTvAndSmartphones(
			long groupId)
		throws PortalException {

		return getService().getCostOfArchivedTvAndSmartphones(groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static StatisticsHolderLocalService getService() {
		return _service;
	}

	private static volatile StatisticsHolderLocalService _service;

}