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

import com.wz.testtask.estore.exception.NoSuchPurchaseTypeException;
import com.wz.testtask.estore.model.PurchaseType;
import com.wz.testtask.estore.service.PurchaseTypeLocalServiceUtil;
import com.wz.testtask.estore.service.persistence.PurchaseTypePersistence;
import com.wz.testtask.estore.service.persistence.PurchaseTypeUtil;

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
public class PurchaseTypePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.wz.testtask.estore.service"));

	@Before
	public void setUp() {
		_persistence = PurchaseTypeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<PurchaseType> iterator = _purchaseTypes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PurchaseType purchaseType = _persistence.create(pk);

		Assert.assertNotNull(purchaseType);

		Assert.assertEquals(purchaseType.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		PurchaseType newPurchaseType = addPurchaseType();

		_persistence.remove(newPurchaseType);

		PurchaseType existingPurchaseType = _persistence.fetchByPrimaryKey(
			newPurchaseType.getPrimaryKey());

		Assert.assertNull(existingPurchaseType);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPurchaseType();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PurchaseType newPurchaseType = _persistence.create(pk);

		newPurchaseType.setMvccVersion(RandomTestUtil.nextLong());

		newPurchaseType.setUuid(RandomTestUtil.randomString());

		newPurchaseType.setGroupId(RandomTestUtil.nextLong());

		newPurchaseType.setCompanyId(RandomTestUtil.nextLong());

		newPurchaseType.setName(RandomTestUtil.randomString());

		_purchaseTypes.add(_persistence.update(newPurchaseType));

		PurchaseType existingPurchaseType = _persistence.findByPrimaryKey(
			newPurchaseType.getPrimaryKey());

		Assert.assertEquals(
			existingPurchaseType.getMvccVersion(),
			newPurchaseType.getMvccVersion());
		Assert.assertEquals(
			existingPurchaseType.getUuid(), newPurchaseType.getUuid());
		Assert.assertEquals(
			existingPurchaseType.getPurchaseTypeId(),
			newPurchaseType.getPurchaseTypeId());
		Assert.assertEquals(
			existingPurchaseType.getGroupId(), newPurchaseType.getGroupId());
		Assert.assertEquals(
			existingPurchaseType.getCompanyId(),
			newPurchaseType.getCompanyId());
		Assert.assertEquals(
			existingPurchaseType.getName(), newPurchaseType.getName());
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
		PurchaseType newPurchaseType = addPurchaseType();

		PurchaseType existingPurchaseType = _persistence.findByPrimaryKey(
			newPurchaseType.getPrimaryKey());

		Assert.assertEquals(existingPurchaseType, newPurchaseType);
	}

	@Test(expected = NoSuchPurchaseTypeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<PurchaseType> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ESTORE_PurchaseType", "mvccVersion", true, "uuid", true,
			"purchaseTypeId", true, "groupId", true, "companyId", true, "name",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		PurchaseType newPurchaseType = addPurchaseType();

		PurchaseType existingPurchaseType = _persistence.fetchByPrimaryKey(
			newPurchaseType.getPrimaryKey());

		Assert.assertEquals(existingPurchaseType, newPurchaseType);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PurchaseType missingPurchaseType = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPurchaseType);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		PurchaseType newPurchaseType1 = addPurchaseType();
		PurchaseType newPurchaseType2 = addPurchaseType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPurchaseType1.getPrimaryKey());
		primaryKeys.add(newPurchaseType2.getPrimaryKey());

		Map<Serializable, PurchaseType> purchaseTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, purchaseTypes.size());
		Assert.assertEquals(
			newPurchaseType1,
			purchaseTypes.get(newPurchaseType1.getPrimaryKey()));
		Assert.assertEquals(
			newPurchaseType2,
			purchaseTypes.get(newPurchaseType2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, PurchaseType> purchaseTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(purchaseTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		PurchaseType newPurchaseType = addPurchaseType();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPurchaseType.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, PurchaseType> purchaseTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, purchaseTypes.size());
		Assert.assertEquals(
			newPurchaseType,
			purchaseTypes.get(newPurchaseType.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, PurchaseType> purchaseTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(purchaseTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		PurchaseType newPurchaseType = addPurchaseType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPurchaseType.getPrimaryKey());

		Map<Serializable, PurchaseType> purchaseTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, purchaseTypes.size());
		Assert.assertEquals(
			newPurchaseType,
			purchaseTypes.get(newPurchaseType.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PurchaseTypeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<PurchaseType>() {

				@Override
				public void performAction(PurchaseType purchaseType) {
					Assert.assertNotNull(purchaseType);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		PurchaseType newPurchaseType = addPurchaseType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PurchaseType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"purchaseTypeId", newPurchaseType.getPurchaseTypeId()));

		List<PurchaseType> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		PurchaseType existingPurchaseType = result.get(0);

		Assert.assertEquals(existingPurchaseType, newPurchaseType);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PurchaseType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"purchaseTypeId", RandomTestUtil.nextLong()));

		List<PurchaseType> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		PurchaseType newPurchaseType = addPurchaseType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PurchaseType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("purchaseTypeId"));

		Object newPurchaseTypeId = newPurchaseType.getPurchaseTypeId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"purchaseTypeId", new Object[] {newPurchaseTypeId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingPurchaseTypeId = result.get(0);

		Assert.assertEquals(existingPurchaseTypeId, newPurchaseTypeId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PurchaseType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("purchaseTypeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"purchaseTypeId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		PurchaseType newPurchaseType = addPurchaseType();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newPurchaseType.getPrimaryKey()));
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

		PurchaseType newPurchaseType = addPurchaseType();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PurchaseType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"purchaseTypeId", newPurchaseType.getPurchaseTypeId()));

		List<PurchaseType> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(PurchaseType purchaseType) {
		Assert.assertEquals(
			purchaseType.getUuid(),
			ReflectionTestUtil.invoke(
				purchaseType, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(purchaseType.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				purchaseType, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected PurchaseType addPurchaseType() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PurchaseType purchaseType = _persistence.create(pk);

		purchaseType.setMvccVersion(RandomTestUtil.nextLong());

		purchaseType.setUuid(RandomTestUtil.randomString());

		purchaseType.setGroupId(RandomTestUtil.nextLong());

		purchaseType.setCompanyId(RandomTestUtil.nextLong());

		purchaseType.setName(RandomTestUtil.randomString());

		_purchaseTypes.add(_persistence.update(purchaseType));

		return purchaseType;
	}

	private List<PurchaseType> _purchaseTypes = new ArrayList<PurchaseType>();
	private PurchaseTypePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}