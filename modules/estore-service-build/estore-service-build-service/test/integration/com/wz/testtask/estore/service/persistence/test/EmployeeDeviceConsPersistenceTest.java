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
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.wz.testtask.estore.exception.NoSuchEmployeeDeviceConsException;
import com.wz.testtask.estore.model.EmployeeDeviceCons;
import com.wz.testtask.estore.service.EmployeeDeviceConsLocalServiceUtil;
import com.wz.testtask.estore.service.persistence.EmployeeDeviceConsPK;
import com.wz.testtask.estore.service.persistence.EmployeeDeviceConsPersistence;
import com.wz.testtask.estore.service.persistence.EmployeeDeviceConsUtil;

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
public class EmployeeDeviceConsPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.wz.testtask.estore.service"));

	@Before
	public void setUp() {
		_persistence = EmployeeDeviceConsUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EmployeeDeviceCons> iterator =
			_employeeDeviceConses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		EmployeeDeviceConsPK pk = new EmployeeDeviceConsPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		EmployeeDeviceCons employeeDeviceCons = _persistence.create(pk);

		Assert.assertNotNull(employeeDeviceCons);

		Assert.assertEquals(employeeDeviceCons.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EmployeeDeviceCons newEmployeeDeviceCons = addEmployeeDeviceCons();

		_persistence.remove(newEmployeeDeviceCons);

		EmployeeDeviceCons existingEmployeeDeviceCons =
			_persistence.fetchByPrimaryKey(
				newEmployeeDeviceCons.getPrimaryKey());

		Assert.assertNull(existingEmployeeDeviceCons);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEmployeeDeviceCons();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		EmployeeDeviceConsPK pk = new EmployeeDeviceConsPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		EmployeeDeviceCons newEmployeeDeviceCons = _persistence.create(pk);

		newEmployeeDeviceCons.setMvccVersion(RandomTestUtil.nextLong());

		newEmployeeDeviceCons.setUuid(RandomTestUtil.randomString());

		_employeeDeviceConses.add(_persistence.update(newEmployeeDeviceCons));

		EmployeeDeviceCons existingEmployeeDeviceCons =
			_persistence.findByPrimaryKey(
				newEmployeeDeviceCons.getPrimaryKey());

		Assert.assertEquals(
			existingEmployeeDeviceCons.getMvccVersion(),
			newEmployeeDeviceCons.getMvccVersion());
		Assert.assertEquals(
			existingEmployeeDeviceCons.getUuid(),
			newEmployeeDeviceCons.getUuid());
		Assert.assertEquals(
			existingEmployeeDeviceCons.getEmployeeId(),
			newEmployeeDeviceCons.getEmployeeId());
		Assert.assertEquals(
			existingEmployeeDeviceCons.getDeviceTypeId(),
			newEmployeeDeviceCons.getDeviceTypeId());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EmployeeDeviceCons newEmployeeDeviceCons = addEmployeeDeviceCons();

		EmployeeDeviceCons existingEmployeeDeviceCons =
			_persistence.findByPrimaryKey(
				newEmployeeDeviceCons.getPrimaryKey());

		Assert.assertEquals(existingEmployeeDeviceCons, newEmployeeDeviceCons);
	}

	@Test(expected = NoSuchEmployeeDeviceConsException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		EmployeeDeviceConsPK pk = new EmployeeDeviceConsPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EmployeeDeviceCons newEmployeeDeviceCons = addEmployeeDeviceCons();

		EmployeeDeviceCons existingEmployeeDeviceCons =
			_persistence.fetchByPrimaryKey(
				newEmployeeDeviceCons.getPrimaryKey());

		Assert.assertEquals(existingEmployeeDeviceCons, newEmployeeDeviceCons);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		EmployeeDeviceConsPK pk = new EmployeeDeviceConsPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		EmployeeDeviceCons missingEmployeeDeviceCons =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEmployeeDeviceCons);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EmployeeDeviceCons newEmployeeDeviceCons1 = addEmployeeDeviceCons();
		EmployeeDeviceCons newEmployeeDeviceCons2 = addEmployeeDeviceCons();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeeDeviceCons1.getPrimaryKey());
		primaryKeys.add(newEmployeeDeviceCons2.getPrimaryKey());

		Map<Serializable, EmployeeDeviceCons> employeeDeviceConses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, employeeDeviceConses.size());
		Assert.assertEquals(
			newEmployeeDeviceCons1,
			employeeDeviceConses.get(newEmployeeDeviceCons1.getPrimaryKey()));
		Assert.assertEquals(
			newEmployeeDeviceCons2,
			employeeDeviceConses.get(newEmployeeDeviceCons2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		EmployeeDeviceConsPK pk1 = new EmployeeDeviceConsPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		EmployeeDeviceConsPK pk2 = new EmployeeDeviceConsPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EmployeeDeviceCons> employeeDeviceConses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(employeeDeviceConses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EmployeeDeviceCons newEmployeeDeviceCons = addEmployeeDeviceCons();

		EmployeeDeviceConsPK pk = new EmployeeDeviceConsPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeeDeviceCons.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EmployeeDeviceCons> employeeDeviceConses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, employeeDeviceConses.size());
		Assert.assertEquals(
			newEmployeeDeviceCons,
			employeeDeviceConses.get(newEmployeeDeviceCons.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EmployeeDeviceCons> employeeDeviceConses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(employeeDeviceConses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EmployeeDeviceCons newEmployeeDeviceCons = addEmployeeDeviceCons();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeeDeviceCons.getPrimaryKey());

		Map<Serializable, EmployeeDeviceCons> employeeDeviceConses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, employeeDeviceConses.size());
		Assert.assertEquals(
			newEmployeeDeviceCons,
			employeeDeviceConses.get(newEmployeeDeviceCons.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EmployeeDeviceConsLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<EmployeeDeviceCons>() {

				@Override
				public void performAction(
					EmployeeDeviceCons employeeDeviceCons) {

					Assert.assertNotNull(employeeDeviceCons);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EmployeeDeviceCons newEmployeeDeviceCons = addEmployeeDeviceCons();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeDeviceCons.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.employeeId", newEmployeeDeviceCons.getEmployeeId()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.deviceTypeId", newEmployeeDeviceCons.getDeviceTypeId()));

		List<EmployeeDeviceCons> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EmployeeDeviceCons existingEmployeeDeviceCons = result.get(0);

		Assert.assertEquals(existingEmployeeDeviceCons, newEmployeeDeviceCons);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeDeviceCons.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.employeeId", RandomTestUtil.nextLong()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.deviceTypeId", RandomTestUtil.nextLong()));

		List<EmployeeDeviceCons> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EmployeeDeviceCons newEmployeeDeviceCons = addEmployeeDeviceCons();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeDeviceCons.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("id.employeeId"));

		Object newEmployeeId = newEmployeeDeviceCons.getEmployeeId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.employeeId", new Object[] {newEmployeeId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEmployeeId = result.get(0);

		Assert.assertEquals(existingEmployeeId, newEmployeeId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeDeviceCons.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("id.employeeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.employeeId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected EmployeeDeviceCons addEmployeeDeviceCons() throws Exception {
		EmployeeDeviceConsPK pk = new EmployeeDeviceConsPK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		EmployeeDeviceCons employeeDeviceCons = _persistence.create(pk);

		employeeDeviceCons.setMvccVersion(RandomTestUtil.nextLong());

		employeeDeviceCons.setUuid(RandomTestUtil.randomString());

		_employeeDeviceConses.add(_persistence.update(employeeDeviceCons));

		return employeeDeviceCons;
	}

	private List<EmployeeDeviceCons> _employeeDeviceConses =
		new ArrayList<EmployeeDeviceCons>();
	private EmployeeDeviceConsPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}