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

package com.wz.testtask.estore.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;

import com.wz.testtask.estore.model.EmployeeWithSummary;
import com.wz.testtask.estore.service.EmployeeWithSummaryService;
import com.wz.testtask.estore.service.EmployeeWithSummaryServiceUtil;
import com.wz.testtask.estore.service.persistence.DevicePersistence;
import com.wz.testtask.estore.service.persistence.DeviceTypePersistence;
import com.wz.testtask.estore.service.persistence.EmployeePersistence;
import com.wz.testtask.estore.service.persistence.EmployeePositionPersistence;
import com.wz.testtask.estore.service.persistence.EmployeeWithSummaryFinder;
import com.wz.testtask.estore.service.persistence.PurchasePersistence;
import com.wz.testtask.estore.service.persistence.PurchaseTypePersistence;

import java.lang.reflect.Field;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the employee with summary remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.wz.testtask.estore.service.impl.EmployeeWithSummaryServiceImpl}.
 * </p>
 *
 * @author wz
 * @see com.wz.testtask.estore.service.impl.EmployeeWithSummaryServiceImpl
 * @generated
 */
public abstract class EmployeeWithSummaryServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, EmployeeWithSummaryService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EmployeeWithSummaryService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>EmployeeWithSummaryServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EmployeeWithSummaryService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		employeeWithSummaryService = (EmployeeWithSummaryService)aopProxy;

		_setServiceUtilService(employeeWithSummaryService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EmployeeWithSummaryService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EmployeeWithSummary.class;
	}

	protected String getModelClassName() {
		return EmployeeWithSummary.class.getName();
	}

	private void _setServiceUtilService(
		EmployeeWithSummaryService employeeWithSummaryService) {

		try {
			Field field = EmployeeWithSummaryServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, employeeWithSummaryService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected DevicePersistence devicePersistence;

	@Reference
	protected DeviceTypePersistence deviceTypePersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected EmployeePositionPersistence employeePositionPersistence;

	@Reference
	protected com.wz.testtask.estore.service.EmployeeWithSummaryLocalService
		employeeWithSummaryLocalService;

	protected EmployeeWithSummaryService employeeWithSummaryService;

	@Reference
	protected EmployeeWithSummaryFinder employeeWithSummaryFinder;

	@Reference
	protected PurchasePersistence purchasePersistence;

	@Reference
	protected PurchaseTypePersistence purchaseTypePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}