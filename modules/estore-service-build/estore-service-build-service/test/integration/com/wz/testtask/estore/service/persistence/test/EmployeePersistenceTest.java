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
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.wz.testtask.estore.exception.NoSuchEmployeeException;
import com.wz.testtask.estore.model.Employee;
import com.wz.testtask.estore.service.EmployeeLocalServiceUtil;
import com.wz.testtask.estore.service.persistence.EmployeePersistence;
import com.wz.testtask.estore.service.persistence.EmployeeUtil;

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
public class EmployeePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.wz.testtask.estore.service"));

	@Before
	public void setUp() {
		_persistence = EmployeeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Employee> iterator = _employees.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Employee employee = _persistence.create(pk);

		Assert.assertNotNull(employee);

		Assert.assertEquals(employee.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Employee newEmployee = addEmployee();

		_persistence.remove(newEmployee);

		Employee existingEmployee = _persistence.fetchByPrimaryKey(
			newEmployee.getPrimaryKey());

		Assert.assertNull(existingEmployee);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEmployee();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Employee newEmployee = _persistence.create(pk);

		newEmployee.setMvccVersion(RandomTestUtil.nextLong());

		newEmployee.setUuid(RandomTestUtil.randomString());

		newEmployee.setGroupId(RandomTestUtil.nextLong());

		newEmployee.setCompanyId(RandomTestUtil.nextLong());

		newEmployee.setLastName(RandomTestUtil.randomString());

		newEmployee.setFirstName(RandomTestUtil.randomString());

		newEmployee.setPatronymic(RandomTestUtil.randomString());

		newEmployee.setBirthDate(RandomTestUtil.nextDate());

		newEmployee.setPositionId(RandomTestUtil.nextLong());

		newEmployee.setGender(RandomTestUtil.nextInt());

		_employees.add(_persistence.update(newEmployee));

		Employee existingEmployee = _persistence.findByPrimaryKey(
			newEmployee.getPrimaryKey());

		Assert.assertEquals(
			existingEmployee.getMvccVersion(), newEmployee.getMvccVersion());
		Assert.assertEquals(existingEmployee.getUuid(), newEmployee.getUuid());
		Assert.assertEquals(
			existingEmployee.getEmployeeId(), newEmployee.getEmployeeId());
		Assert.assertEquals(
			existingEmployee.getGroupId(), newEmployee.getGroupId());
		Assert.assertEquals(
			existingEmployee.getCompanyId(), newEmployee.getCompanyId());
		Assert.assertEquals(
			existingEmployee.getLastName(), newEmployee.getLastName());
		Assert.assertEquals(
			existingEmployee.getFirstName(), newEmployee.getFirstName());
		Assert.assertEquals(
			existingEmployee.getPatronymic(), newEmployee.getPatronymic());
		Assert.assertEquals(
			Time.getShortTimestamp(existingEmployee.getBirthDate()),
			Time.getShortTimestamp(newEmployee.getBirthDate()));
		Assert.assertEquals(
			existingEmployee.getPositionId(), newEmployee.getPositionId());
		Assert.assertEquals(
			existingEmployee.getGender(), newEmployee.getGender());
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
	public void testCountByByFullName() throws Exception {
		_persistence.countByByFullName(RandomTestUtil.nextLong(), "", "", "");

		_persistence.countByByFullName(0L, "null", "null", "null");

		_persistence.countByByFullName(
			0L, (String)null, (String)null, (String)null);
	}

	@Test
	public void testCountByGroupIdPositionId() throws Exception {
		_persistence.countByGroupIdPositionId(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByGroupIdPositionId(0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Employee newEmployee = addEmployee();

		Employee existingEmployee = _persistence.findByPrimaryKey(
			newEmployee.getPrimaryKey());

		Assert.assertEquals(existingEmployee, newEmployee);
	}

	@Test(expected = NoSuchEmployeeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Employee> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ESTORE_Employee", "mvccVersion", true, "uuid", true, "employeeId",
			true, "groupId", true, "companyId", true, "lastName", true,
			"firstName", true, "patronymic", true, "birthDate", true,
			"positionId", true, "gender", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Employee newEmployee = addEmployee();

		Employee existingEmployee = _persistence.fetchByPrimaryKey(
			newEmployee.getPrimaryKey());

		Assert.assertEquals(existingEmployee, newEmployee);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Employee missingEmployee = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEmployee);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Employee newEmployee1 = addEmployee();
		Employee newEmployee2 = addEmployee();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployee1.getPrimaryKey());
		primaryKeys.add(newEmployee2.getPrimaryKey());

		Map<Serializable, Employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, employees.size());
		Assert.assertEquals(
			newEmployee1, employees.get(newEmployee1.getPrimaryKey()));
		Assert.assertEquals(
			newEmployee2, employees.get(newEmployee2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(employees.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Employee newEmployee = addEmployee();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployee.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, employees.size());
		Assert.assertEquals(
			newEmployee, employees.get(newEmployee.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(employees.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Employee newEmployee = addEmployee();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployee.getPrimaryKey());

		Map<Serializable, Employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, employees.size());
		Assert.assertEquals(
			newEmployee, employees.get(newEmployee.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EmployeeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Employee>() {

				@Override
				public void performAction(Employee employee) {
					Assert.assertNotNull(employee);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Employee newEmployee = addEmployee();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Employee.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"employeeId", newEmployee.getEmployeeId()));

		List<Employee> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Employee existingEmployee = result.get(0);

		Assert.assertEquals(existingEmployee, newEmployee);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Employee.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"employeeId", RandomTestUtil.nextLong()));

		List<Employee> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Employee newEmployee = addEmployee();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Employee.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("employeeId"));

		Object newEmployeeId = newEmployee.getEmployeeId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"employeeId", new Object[] {newEmployeeId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEmployeeId = result.get(0);

		Assert.assertEquals(existingEmployeeId, newEmployeeId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Employee.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("employeeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"employeeId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Employee newEmployee = addEmployee();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newEmployee.getPrimaryKey()));
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

		Employee newEmployee = addEmployee();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Employee.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"employeeId", newEmployee.getEmployeeId()));

		List<Employee> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Employee employee) {
		Assert.assertEquals(
			employee.getUuid(),
			ReflectionTestUtil.invoke(
				employee, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(employee.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				employee, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));

		Assert.assertEquals(
			Long.valueOf(employee.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				employee, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
		Assert.assertEquals(
			employee.getFirstName(),
			ReflectionTestUtil.invoke(
				employee, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "firstName"));
		Assert.assertEquals(
			employee.getLastName(),
			ReflectionTestUtil.invoke(
				employee, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "lastName"));
		Assert.assertEquals(
			employee.getPatronymic(),
			ReflectionTestUtil.invoke(
				employee, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "patronymic"));
	}

	protected Employee addEmployee() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Employee employee = _persistence.create(pk);

		employee.setMvccVersion(RandomTestUtil.nextLong());

		employee.setUuid(RandomTestUtil.randomString());

		employee.setGroupId(RandomTestUtil.nextLong());

		employee.setCompanyId(RandomTestUtil.nextLong());

		employee.setLastName(RandomTestUtil.randomString());

		employee.setFirstName(RandomTestUtil.randomString());

		employee.setPatronymic(RandomTestUtil.randomString());

		employee.setBirthDate(RandomTestUtil.nextDate());

		employee.setPositionId(RandomTestUtil.nextLong());

		employee.setGender(RandomTestUtil.nextInt());

		_employees.add(_persistence.update(employee));

		return employee;
	}

	private List<Employee> _employees = new ArrayList<Employee>();
	private EmployeePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}