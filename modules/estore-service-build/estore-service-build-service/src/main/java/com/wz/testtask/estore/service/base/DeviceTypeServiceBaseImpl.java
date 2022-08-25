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
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import com.wz.testtask.estore.model.DeviceType;
import com.wz.testtask.estore.service.DeviceTypeService;
import com.wz.testtask.estore.service.DeviceTypeServiceUtil;
import com.wz.testtask.estore.service.persistence.DevicePersistence;
import com.wz.testtask.estore.service.persistence.DeviceTypePersistence;
import com.wz.testtask.estore.service.persistence.EmployeePersistence;
import com.wz.testtask.estore.service.persistence.EmployeePositionPersistence;
import com.wz.testtask.estore.service.persistence.EmployeeWithSummaryFinder;
import com.wz.testtask.estore.service.persistence.PurchasePersistence;
import com.wz.testtask.estore.service.persistence.PurchaseTypePersistence;
import com.wz.testtask.estore.service.persistence.StatisticsHolderFinder;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the device type remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.wz.testtask.estore.service.impl.DeviceTypeServiceImpl}.
 * </p>
 *
 * @author wz
 * @see com.wz.testtask.estore.service.impl.DeviceTypeServiceImpl
 * @generated
 */
public abstract class DeviceTypeServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, DeviceTypeService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DeviceTypeService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DeviceTypeServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DeviceTypeService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		deviceTypeService = (DeviceTypeService)aopProxy;

		_setServiceUtilService(deviceTypeService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DeviceTypeService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DeviceType.class;
	}

	protected String getModelClassName() {
		return DeviceType.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = deviceTypePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(DeviceTypeService deviceTypeService) {
		try {
			Field field = DeviceTypeServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, deviceTypeService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected DevicePersistence devicePersistence;

	@Reference
	protected com.wz.testtask.estore.service.DeviceTypeLocalService
		deviceTypeLocalService;

	protected DeviceTypeService deviceTypeService;

	@Reference
	protected DeviceTypePersistence deviceTypePersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected EmployeePositionPersistence employeePositionPersistence;

	@Reference
	protected EmployeeWithSummaryFinder employeeWithSummaryFinder;

	@Reference
	protected PurchasePersistence purchasePersistence;

	@Reference
	protected PurchaseTypePersistence purchaseTypePersistence;

	@Reference
	protected StatisticsHolderFinder statisticsHolderFinder;

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