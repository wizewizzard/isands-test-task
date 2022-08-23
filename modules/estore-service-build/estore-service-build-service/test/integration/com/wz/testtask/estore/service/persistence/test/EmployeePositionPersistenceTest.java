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

import com.wz.testtask.estore.exception.NoSuchEmployeePositionException;
import com.wz.testtask.estore.model.EmployeePosition;
import com.wz.testtask.estore.service.EmployeePositionLocalServiceUtil;
import com.wz.testtask.estore.service.persistence.EmployeePositionPersistence;
import com.wz.testtask.estore.service.persistence.EmployeePositionUtil;

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
public class EmployeePositionPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.wz.testtask.estore.service"));

	@Before
	public void setUp() {
		_persistence = EmployeePositionUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EmployeePosition> iterator = _employeePositions.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeePosition employeePosition = _persistence.create(pk);

		Assert.assertNotNull(employeePosition);

		Assert.assertEquals(employeePosition.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EmployeePosition newEmployeePosition = addEmployeePosition();

		_persistence.remove(newEmployeePosition);

		EmployeePosition existingEmployeePosition =
			_persistence.fetchByPrimaryKey(newEmployeePosition.getPrimaryKey());

		Assert.assertNull(existingEmployeePosition);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEmployeePosition();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeePosition newEmployeePosition = _persistence.create(pk);

		newEmployeePosition.setMvccVersion(RandomTestUtil.nextLong());

		newEmployeePosition.setUuid(RandomTestUtil.randomString());

		newEmployeePosition.setGroupId(RandomTestUtil.nextLong());

		newEmployeePosition.setCompanyId(RandomTestUtil.nextLong());

		newEmployeePosition.setName(RandomTestUtil.randomString());

		_employeePositions.add(_persistence.update(newEmployeePosition));

		EmployeePosition existingEmployeePosition =
			_persistence.findByPrimaryKey(newEmployeePosition.getPrimaryKey());

		Assert.assertEquals(
			existingEmployeePosition.getMvccVersion(),
			newEmployeePosition.getMvccVersion());
		Assert.assertEquals(
			existingEmployeePosition.getUuid(), newEmployeePosition.getUuid());
		Assert.assertEquals(
			existingEmployeePosition.getPositionId(),
			newEmployeePosition.getPositionId());
		Assert.assertEquals(
			existingEmployeePosition.getGroupId(),
			newEmployeePosition.getGroupId());
		Assert.assertEquals(
			existingEmployeePosition.getCompanyId(),
			newEmployeePosition.getCompanyId());
		Assert.assertEquals(
			existingEmployeePosition.getName(), newEmployeePosition.getName());
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
	public void testCountByGroupIdName() throws Exception {
		_persistence.countByGroupIdName(RandomTestUtil.nextLong(), "");

		_persistence.countByGroupIdName(0L, "null");

		_persistence.countByGroupIdName(0L, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EmployeePosition newEmployeePosition = addEmployeePosition();

		EmployeePosition existingEmployeePosition =
			_persistence.findByPrimaryKey(newEmployeePosition.getPrimaryKey());

		Assert.assertEquals(existingEmployeePosition, newEmployeePosition);
	}

	@Test(expected = NoSuchEmployeePositionException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EmployeePosition> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ESTORE_EmployeePosition", "mvccVersion", true, "uuid", true,
			"positionId", true, "groupId", true, "companyId", true, "name",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EmployeePosition newEmployeePosition = addEmployeePosition();

		EmployeePosition existingEmployeePosition =
			_persistence.fetchByPrimaryKey(newEmployeePosition.getPrimaryKey());

		Assert.assertEquals(existingEmployeePosition, newEmployeePosition);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeePosition missingEmployeePosition =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEmployeePosition);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EmployeePosition newEmployeePosition1 = addEmployeePosition();
		EmployeePosition newEmployeePosition2 = addEmployeePosition();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeePosition1.getPrimaryKey());
		primaryKeys.add(newEmployeePosition2.getPrimaryKey());

		Map<Serializable, EmployeePosition> employeePositions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, employeePositions.size());
		Assert.assertEquals(
			newEmployeePosition1,
			employeePositions.get(newEmployeePosition1.getPrimaryKey()));
		Assert.assertEquals(
			newEmployeePosition2,
			employeePositions.get(newEmployeePosition2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EmployeePosition> employeePositions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(employeePositions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EmployeePosition newEmployeePosition = addEmployeePosition();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeePosition.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EmployeePosition> employeePositions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, employeePositions.size());
		Assert.assertEquals(
			newEmployeePosition,
			employeePositions.get(newEmployeePosition.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EmployeePosition> employeePositions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(employeePositions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EmployeePosition newEmployeePosition = addEmployeePosition();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeePosition.getPrimaryKey());

		Map<Serializable, EmployeePosition> employeePositions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, employeePositions.size());
		Assert.assertEquals(
			newEmployeePosition,
			employeePositions.get(newEmployeePosition.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EmployeePositionLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<EmployeePosition>() {

				@Override
				public void performAction(EmployeePosition employeePosition) {
					Assert.assertNotNull(employeePosition);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EmployeePosition newEmployeePosition = addEmployeePosition();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeePosition.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"positionId", newEmployeePosition.getPositionId()));

		List<EmployeePosition> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EmployeePosition existingEmployeePosition = result.get(0);

		Assert.assertEquals(existingEmployeePosition, newEmployeePosition);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeePosition.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"positionId", RandomTestUtil.nextLong()));

		List<EmployeePosition> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EmployeePosition newEmployeePosition = addEmployeePosition();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeePosition.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("positionId"));

		Object newPositionId = newEmployeePosition.getPositionId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"positionId", new Object[] {newPositionId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingPositionId = result.get(0);

		Assert.assertEquals(existingPositionId, newPositionId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeePosition.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("positionId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"positionId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		EmployeePosition newEmployeePosition = addEmployeePosition();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newEmployeePosition.getPrimaryKey()));
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

		EmployeePosition newEmployeePosition = addEmployeePosition();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeePosition.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"positionId", newEmployeePosition.getPositionId()));

		List<EmployeePosition> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(EmployeePosition employeePosition) {
		Assert.assertEquals(
			employeePosition.getUuid(),
			ReflectionTestUtil.invoke(
				employeePosition, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(employeePosition.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				employeePosition, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected EmployeePosition addEmployeePosition() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeePosition employeePosition = _persistence.create(pk);

		employeePosition.setMvccVersion(RandomTestUtil.nextLong());

		employeePosition.setUuid(RandomTestUtil.randomString());

		employeePosition.setGroupId(RandomTestUtil.nextLong());

		employeePosition.setCompanyId(RandomTestUtil.nextLong());

		employeePosition.setName(RandomTestUtil.randomString());

		_employeePositions.add(_persistence.update(employeePosition));

		return employeePosition;
	}

	private List<EmployeePosition> _employeePositions =
		new ArrayList<EmployeePosition>();
	private EmployeePositionPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}