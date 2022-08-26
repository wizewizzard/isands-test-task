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

package com.wz.testtask.estore.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.wz.testtask.estore.exception.NoSuchDeviceException;
import com.wz.testtask.estore.model.Device;
import com.wz.testtask.estore.service.DeviceLocalServiceUtil;
import com.wz.testtask.estore.service.persistence.DevicePersistence;
import com.wz.testtask.estore.service.persistence.DeviceUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class DevicePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.wz.testtask.estore.service"));

	@Before
	public void setUp() {
		_persistence = DeviceUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Device> iterator = _devices.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Device device = _persistence.create(pk);

		Assert.assertNotNull(device);

		Assert.assertEquals(device.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Device newDevice = addDevice();

		_persistence.remove(newDevice);

		Device existingDevice = _persistence.fetchByPrimaryKey(
			newDevice.getPrimaryKey());

		Assert.assertNull(existingDevice);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDevice();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Device newDevice = _persistence.create(pk);

		newDevice.setMvccVersion(RandomTestUtil.nextLong());

		newDevice.setUuid(RandomTestUtil.randomString());

		newDevice.setGroupId(RandomTestUtil.nextLong());

		newDevice.setCompanyId(RandomTestUtil.nextLong());

		newDevice.setName(RandomTestUtil.randomString());

		newDevice.setDeviceTypeId(RandomTestUtil.nextLong());

		newDevice.setPrice(RandomTestUtil.nextLong());

		newDevice.setCount(RandomTestUtil.nextInt());

		newDevice.setInStock(RandomTestUtil.randomBoolean());

		newDevice.setArchive(RandomTestUtil.randomBoolean());

		newDevice.setDescription(RandomTestUtil.randomString());

		_devices.add(_persistence.update(newDevice));

		Device existingDevice = _persistence.findByPrimaryKey(
			newDevice.getPrimaryKey());

		Assert.assertEquals(
			existingDevice.getMvccVersion(), newDevice.getMvccVersion());
		Assert.assertEquals(existingDevice.getUuid(), newDevice.getUuid());
		Assert.assertEquals(
			existingDevice.getDeviceId(), newDevice.getDeviceId());
		Assert.assertEquals(
			existingDevice.getGroupId(), newDevice.getGroupId());
		Assert.assertEquals(
			existingDevice.getCompanyId(), newDevice.getCompanyId());
		Assert.assertEquals(existingDevice.getName(), newDevice.getName());
		Assert.assertEquals(
			existingDevice.getDeviceTypeId(), newDevice.getDeviceTypeId());
		Assert.assertEquals(existingDevice.getPrice(), newDevice.getPrice());
		Assert.assertEquals(existingDevice.getCount(), newDevice.getCount());
		Assert.assertEquals(existingDevice.isInStock(), newDevice.isInStock());
		Assert.assertEquals(existingDevice.isArchive(), newDevice.isArchive());
		Assert.assertEquals(
			existingDevice.getDescription(), newDevice.getDescription());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testCountByName() throws Exception {
		_persistence.countByName(RandomTestUtil.nextLong(), "");

		_persistence.countByName(0L, "null");

		_persistence.countByName(0L, (String)null);
	}

	@Test
	public void testCountByDeviceType() throws Exception {
		_persistence.countByDeviceType(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByDeviceType(0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Device newDevice = addDevice();

		Device existingDevice = _persistence.findByPrimaryKey(
			newDevice.getPrimaryKey());

		Assert.assertEquals(existingDevice, newDevice);
	}

	@Test(expected = NoSuchDeviceException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Device> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ESTORE_Device", "mvccVersion", true, "uuid", true, "deviceId",
			true, "groupId", true, "companyId", true, "name", true,
			"deviceTypeId", true, "price", true, "count", true, "inStock", true,
			"archive", true, "description", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Device newDevice = addDevice();

		Device existingDevice = _persistence.fetchByPrimaryKey(
			newDevice.getPrimaryKey());

		Assert.assertEquals(existingDevice, newDevice);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Device missingDevice = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDevice);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Device newDevice1 = addDevice();
		Device newDevice2 = addDevice();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDevice1.getPrimaryKey());
		primaryKeys.add(newDevice2.getPrimaryKey());

		Map<Serializable, Device> devices = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, devices.size());
		Assert.assertEquals(
			newDevice1, devices.get(newDevice1.getPrimaryKey()));
		Assert.assertEquals(
			newDevice2, devices.get(newDevice2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Device> devices = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(devices.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Device newDevice = addDevice();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDevice.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Device> devices = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, devices.size());
		Assert.assertEquals(newDevice, devices.get(newDevice.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Device> devices = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(devices.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Device newDevice = addDevice();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDevice.getPrimaryKey());

		Map<Serializable, Device> devices = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, devices.size());
		Assert.assertEquals(newDevice, devices.get(newDevice.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DeviceLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Device>() {

				@Override
				public void performAction(Device device) {
					Assert.assertNotNull(device);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Device newDevice = addDevice();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Device.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("deviceId", newDevice.getDeviceId()));

		List<Device> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Device existingDevice = result.get(0);

		Assert.assertEquals(existingDevice, newDevice);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Device.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("deviceId", RandomTestUtil.nextLong()));

		List<Device> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Device newDevice = addDevice();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Device.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("deviceId"));

		Object newDeviceId = newDevice.getDeviceId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("deviceId", new Object[] {newDeviceId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDeviceId = result.get(0);

		Assert.assertEquals(existingDeviceId, newDeviceId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Device.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("deviceId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"deviceId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Device newDevice = addDevice();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newDevice.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		Device newDevice = addDevice();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Device.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("deviceId", newDevice.getDeviceId()));

		List<Device> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Device device) {
		Assert.assertEquals(
			device.getUuid(),
			ReflectionTestUtil.invoke(
				device, "getColumnOriginalValue", new Class<?>[] {String.class},
				"uuid_"));
		Assert.assertEquals(
			Long.valueOf(device.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				device, "getColumnOriginalValue", new Class<?>[] {String.class},
				"groupId"));

		Assert.assertEquals(
			Long.valueOf(device.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				device, "getColumnOriginalValue", new Class<?>[] {String.class},
				"groupId"));
		Assert.assertEquals(
			device.getName(),
			ReflectionTestUtil.invoke(
				device, "getColumnOriginalValue", new Class<?>[] {String.class},
				"name"));
	}

	protected Device addDevice() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Device device = _persistence.create(pk);

		device.setMvccVersion(RandomTestUtil.nextLong());

		device.setUuid(RandomTestUtil.randomString());

		device.setGroupId(RandomTestUtil.nextLong());

		device.setCompanyId(RandomTestUtil.nextLong());

		device.setName(RandomTestUtil.randomString());

		device.setDeviceTypeId(RandomTestUtil.nextLong());

		device.setPrice(RandomTestUtil.nextLong());

		device.setCount(RandomTestUtil.nextInt());

		device.setInStock(RandomTestUtil.randomBoolean());

		device.setArchive(RandomTestUtil.randomBoolean());

		device.setDescription(RandomTestUtil.randomString());

		_devices.add(_persistence.update(device));

		return device;
	}

	private List<Device> _devices = new ArrayList<Device>();
	private DevicePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}