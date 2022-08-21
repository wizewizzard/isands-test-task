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

import com.wz.testtask.estore.exception.NoSuchDeviceTypeException;
import com.wz.testtask.estore.model.DeviceType;
import com.wz.testtask.estore.service.DeviceTypeLocalServiceUtil;
import com.wz.testtask.estore.service.persistence.DeviceTypePersistence;
import com.wz.testtask.estore.service.persistence.DeviceTypeUtil;

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
public class DeviceTypePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.wz.testtask.estore.service"));

	@Before
	public void setUp() {
		_persistence = DeviceTypeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DeviceType> iterator = _deviceTypes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DeviceType deviceType = _persistence.create(pk);

		Assert.assertNotNull(deviceType);

		Assert.assertEquals(deviceType.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DeviceType newDeviceType = addDeviceType();

		_persistence.remove(newDeviceType);

		DeviceType existingDeviceType = _persistence.fetchByPrimaryKey(
			newDeviceType.getPrimaryKey());

		Assert.assertNull(existingDeviceType);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDeviceType();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DeviceType newDeviceType = _persistence.create(pk);

		newDeviceType.setMvccVersion(RandomTestUtil.nextLong());

		newDeviceType.setUuid(RandomTestUtil.randomString());

		newDeviceType.setGroupId(RandomTestUtil.nextLong());

		newDeviceType.setCompanyId(RandomTestUtil.nextLong());

		newDeviceType.setName(RandomTestUtil.randomString());

		_deviceTypes.add(_persistence.update(newDeviceType));

		DeviceType existingDeviceType = _persistence.findByPrimaryKey(
			newDeviceType.getPrimaryKey());

		Assert.assertEquals(
			existingDeviceType.getMvccVersion(),
			newDeviceType.getMvccVersion());
		Assert.assertEquals(
			existingDeviceType.getUuid(), newDeviceType.getUuid());
		Assert.assertEquals(
			existingDeviceType.getDeviceTypeId(),
			newDeviceType.getDeviceTypeId());
		Assert.assertEquals(
			existingDeviceType.getGroupId(), newDeviceType.getGroupId());
		Assert.assertEquals(
			existingDeviceType.getCompanyId(), newDeviceType.getCompanyId());
		Assert.assertEquals(
			existingDeviceType.getName(), newDeviceType.getName());
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
	public void testFindByPrimaryKeyExisting() throws Exception {
		DeviceType newDeviceType = addDeviceType();

		DeviceType existingDeviceType = _persistence.findByPrimaryKey(
			newDeviceType.getPrimaryKey());

		Assert.assertEquals(existingDeviceType, newDeviceType);
	}

	@Test(expected = NoSuchDeviceTypeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<DeviceType> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ESTORE_DeviceType", "mvccVersion", true, "uuid", true,
			"deviceTypeId", true, "groupId", true, "companyId", true, "name",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DeviceType newDeviceType = addDeviceType();

		DeviceType existingDeviceType = _persistence.fetchByPrimaryKey(
			newDeviceType.getPrimaryKey());

		Assert.assertEquals(existingDeviceType, newDeviceType);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DeviceType missingDeviceType = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDeviceType);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DeviceType newDeviceType1 = addDeviceType();
		DeviceType newDeviceType2 = addDeviceType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDeviceType1.getPrimaryKey());
		primaryKeys.add(newDeviceType2.getPrimaryKey());

		Map<Serializable, DeviceType> deviceTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, deviceTypes.size());
		Assert.assertEquals(
			newDeviceType1, deviceTypes.get(newDeviceType1.getPrimaryKey()));
		Assert.assertEquals(
			newDeviceType2, deviceTypes.get(newDeviceType2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DeviceType> deviceTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(deviceTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DeviceType newDeviceType = addDeviceType();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDeviceType.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DeviceType> deviceTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, deviceTypes.size());
		Assert.assertEquals(
			newDeviceType, deviceTypes.get(newDeviceType.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DeviceType> deviceTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(deviceTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DeviceType newDeviceType = addDeviceType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDeviceType.getPrimaryKey());

		Map<Serializable, DeviceType> deviceTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, deviceTypes.size());
		Assert.assertEquals(
			newDeviceType, deviceTypes.get(newDeviceType.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DeviceTypeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DeviceType>() {

				@Override
				public void performAction(DeviceType deviceType) {
					Assert.assertNotNull(deviceType);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DeviceType newDeviceType = addDeviceType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DeviceType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"deviceTypeId", newDeviceType.getDeviceTypeId()));

		List<DeviceType> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		DeviceType existingDeviceType = result.get(0);

		Assert.assertEquals(existingDeviceType, newDeviceType);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DeviceType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"deviceTypeId", RandomTestUtil.nextLong()));

		List<DeviceType> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DeviceType newDeviceType = addDeviceType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DeviceType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("deviceTypeId"));

		Object newDeviceTypeId = newDeviceType.getDeviceTypeId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"deviceTypeId", new Object[] {newDeviceTypeId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDeviceTypeId = result.get(0);

		Assert.assertEquals(existingDeviceTypeId, newDeviceTypeId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DeviceType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("deviceTypeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"deviceTypeId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		DeviceType newDeviceType = addDeviceType();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newDeviceType.getPrimaryKey()));
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

		DeviceType newDeviceType = addDeviceType();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DeviceType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"deviceTypeId", newDeviceType.getDeviceTypeId()));

		List<DeviceType> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(DeviceType deviceType) {
		Assert.assertEquals(
			deviceType.getUuid(),
			ReflectionTestUtil.invoke(
				deviceType, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(deviceType.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				deviceType, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected DeviceType addDeviceType() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DeviceType deviceType = _persistence.create(pk);

		deviceType.setMvccVersion(RandomTestUtil.nextLong());

		deviceType.setUuid(RandomTestUtil.randomString());

		deviceType.setGroupId(RandomTestUtil.nextLong());

		deviceType.setCompanyId(RandomTestUtil.nextLong());

		deviceType.setName(RandomTestUtil.randomString());

		_deviceTypes.add(_persistence.update(deviceType));

		return deviceType;
	}

	private List<DeviceType> _deviceTypes = new ArrayList<DeviceType>();
	private DeviceTypePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}