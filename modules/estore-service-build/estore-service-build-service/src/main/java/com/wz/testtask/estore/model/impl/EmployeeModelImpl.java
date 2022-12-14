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

package com.wz.testtask.estore.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.wz.testtask.estore.model.Employee;
import com.wz.testtask.estore.model.EmployeeModel;
import com.wz.testtask.estore.model.EmployeeSoap;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Employee service. Represents a row in the &quot;ESTORE_Employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeImpl}.
 * </p>
 *
 * @author wz
 * @see EmployeeImpl
 * @generated
 */
@JSON(strict = true)
public class EmployeeModelImpl
	extends BaseModelImpl<Employee> implements EmployeeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee model instance should use the <code>Employee</code> interface instead.
	 */
	public static final String TABLE_NAME = "ESTORE_Employee";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"employeeId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"lastName", Types.VARCHAR},
		{"firstName", Types.VARCHAR}, {"patronymic", Types.VARCHAR},
		{"birthDate", Types.TIMESTAMP}, {"positionId", Types.BIGINT},
		{"gender", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("patronymic", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("birthDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("positionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("gender", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ESTORE_Employee (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,employeeId LONG not null primary key,groupId LONG,companyId LONG,lastName VARCHAR(100) null,firstName VARCHAR(100) null,patronymic VARCHAR(100) null,birthDate DATE null,positionId LONG,gender INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table ESTORE_Employee";

	public static final String ORDER_BY_JPQL =
		" ORDER BY employee.employeeId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ESTORE_Employee.employeeId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FIRSTNAME_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long LASTNAME_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PATRONYMIC_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long POSITIONID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EMPLOYEEID_COLUMN_BITMASK = 128L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static Employee toModel(EmployeeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Employee model = new EmployeeImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setLastName(soapModel.getLastName());
		model.setFirstName(soapModel.getFirstName());
		model.setPatronymic(soapModel.getPatronymic());
		model.setBirthDate(soapModel.getBirthDate());
		model.setPositionId(soapModel.getPositionId());
		model.setGender(soapModel.getGender());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<Employee> toModels(EmployeeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Employee> models = new ArrayList<Employee>(soapModels.length);

		for (EmployeeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final String MAPPING_TABLE_ESTORE_EMPLOYEEDEVICECONS_NAME =
		"ESTORE_EmployeeDeviceCons";

	public static final Object[][]
		MAPPING_TABLE_ESTORE_EMPLOYEEDEVICECONS_COLUMNS = {
			{"companyId", Types.BIGINT}, {"deviceTypeId", Types.BIGINT},
			{"employeeId", Types.BIGINT}
		};

	public static final String
		MAPPING_TABLE_ESTORE_EMPLOYEEDEVICECONS_SQL_CREATE =
			"create table ESTORE_EmployeeDeviceCons (companyId LONG not null,deviceTypeId LONG not null,employeeId LONG not null,primary key (deviceTypeId, employeeId))";

	public EmployeeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Employee.class;
	}

	@Override
	public String getModelClassName() {
		return Employee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Employee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Employee, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Employee)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Employee, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Employee, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Employee)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Employee, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Employee, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Employee, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Employee, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Employee, Object>>();
		Map<String, BiConsumer<Employee, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Employee, ?>>();

		attributeGetterFunctions.put("mvccVersion", Employee::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<Employee, Long>)Employee::setMvccVersion);
		attributeGetterFunctions.put("uuid", Employee::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Employee, String>)Employee::setUuid);
		attributeGetterFunctions.put("employeeId", Employee::getEmployeeId);
		attributeSetterBiConsumers.put(
			"employeeId", (BiConsumer<Employee, Long>)Employee::setEmployeeId);
		attributeGetterFunctions.put("groupId", Employee::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Employee, Long>)Employee::setGroupId);
		attributeGetterFunctions.put("companyId", Employee::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Employee, Long>)Employee::setCompanyId);
		attributeGetterFunctions.put("lastName", Employee::getLastName);
		attributeSetterBiConsumers.put(
			"lastName", (BiConsumer<Employee, String>)Employee::setLastName);
		attributeGetterFunctions.put("firstName", Employee::getFirstName);
		attributeSetterBiConsumers.put(
			"firstName", (BiConsumer<Employee, String>)Employee::setFirstName);
		attributeGetterFunctions.put("patronymic", Employee::getPatronymic);
		attributeSetterBiConsumers.put(
			"patronymic",
			(BiConsumer<Employee, String>)Employee::setPatronymic);
		attributeGetterFunctions.put("birthDate", Employee::getBirthDate);
		attributeSetterBiConsumers.put(
			"birthDate", (BiConsumer<Employee, Date>)Employee::setBirthDate);
		attributeGetterFunctions.put("positionId", Employee::getPositionId);
		attributeSetterBiConsumers.put(
			"positionId", (BiConsumer<Employee, Long>)Employee::setPositionId);
		attributeGetterFunctions.put("gender", Employee::getGender);
		attributeSetterBiConsumers.put(
			"gender", (BiConsumer<Employee, Integer>)Employee::setGender);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeId = employeeId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastName = lastName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalLastName() {
		return getColumnOriginalValue("lastName");
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return "";
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_firstName = firstName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalFirstName() {
		return getColumnOriginalValue("firstName");
	}

	@JSON
	@Override
	public String getPatronymic() {
		if (_patronymic == null) {
			return "";
		}
		else {
			return _patronymic;
		}
	}

	@Override
	public void setPatronymic(String patronymic) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_patronymic = patronymic;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalPatronymic() {
		return getColumnOriginalValue("patronymic");
	}

	@JSON
	@Override
	public Date getBirthDate() {
		return _birthDate;
	}

	@Override
	public void setBirthDate(Date birthDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_birthDate = birthDate;
	}

	@JSON
	@Override
	public long getPositionId() {
		return _positionId;
	}

	@Override
	public void setPositionId(long positionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_positionId = positionId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalPositionId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("positionId"));
	}

	@JSON
	@Override
	public int getGender() {
		return _gender;
	}

	@Override
	public void setGender(int gender) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_gender = gender;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Employee.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Employee toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Employee>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setMvccVersion(getMvccVersion());
		employeeImpl.setUuid(getUuid());
		employeeImpl.setEmployeeId(getEmployeeId());
		employeeImpl.setGroupId(getGroupId());
		employeeImpl.setCompanyId(getCompanyId());
		employeeImpl.setLastName(getLastName());
		employeeImpl.setFirstName(getFirstName());
		employeeImpl.setPatronymic(getPatronymic());
		employeeImpl.setBirthDate(getBirthDate());
		employeeImpl.setPositionId(getPositionId());
		employeeImpl.setGender(getGender());

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public int compareTo(Employee employee) {
		long primaryKey = employee.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Employee)) {
			return false;
		}

		Employee employee = (Employee)object;

		long primaryKey = employee.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Employee> toCacheModel() {
		EmployeeCacheModel employeeCacheModel = new EmployeeCacheModel();

		employeeCacheModel.mvccVersion = getMvccVersion();

		employeeCacheModel.uuid = getUuid();

		String uuid = employeeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			employeeCacheModel.uuid = null;
		}

		employeeCacheModel.employeeId = getEmployeeId();

		employeeCacheModel.groupId = getGroupId();

		employeeCacheModel.companyId = getCompanyId();

		employeeCacheModel.lastName = getLastName();

		String lastName = employeeCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			employeeCacheModel.lastName = null;
		}

		employeeCacheModel.firstName = getFirstName();

		String firstName = employeeCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			employeeCacheModel.firstName = null;
		}

		employeeCacheModel.patronymic = getPatronymic();

		String patronymic = employeeCacheModel.patronymic;

		if ((patronymic != null) && (patronymic.length() == 0)) {
			employeeCacheModel.patronymic = null;
		}

		Date birthDate = getBirthDate();

		if (birthDate != null) {
			employeeCacheModel.birthDate = birthDate.getTime();
		}
		else {
			employeeCacheModel.birthDate = Long.MIN_VALUE;
		}

		employeeCacheModel.positionId = getPositionId();

		employeeCacheModel.gender = getGender();

		return employeeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Employee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Employee, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Employee)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Employee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Employee, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Employee)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Employee>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Employee.class, ModelWrapper.class);

	}

	private long _mvccVersion;
	private String _uuid;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private String _lastName;
	private String _firstName;
	private String _patronymic;
	private Date _birthDate;
	private long _positionId;
	private int _gender;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Employee, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Employee)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("mvccVersion", _mvccVersion);
		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("employeeId", _employeeId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("lastName", _lastName);
		_columnOriginalValues.put("firstName", _firstName);
		_columnOriginalValues.put("patronymic", _patronymic);
		_columnOriginalValues.put("birthDate", _birthDate);
		_columnOriginalValues.put("positionId", _positionId);
		_columnOriginalValues.put("gender", _gender);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("uuid_", 2L);

		columnBitmasks.put("employeeId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("lastName", 32L);

		columnBitmasks.put("firstName", 64L);

		columnBitmasks.put("patronymic", 128L);

		columnBitmasks.put("birthDate", 256L);

		columnBitmasks.put("positionId", 512L);

		columnBitmasks.put("gender", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Employee _escapedModel;

}