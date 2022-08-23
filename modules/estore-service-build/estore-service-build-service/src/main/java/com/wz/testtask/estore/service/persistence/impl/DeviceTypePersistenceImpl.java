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

package com.wz.testtask.estore.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.wz.testtask.estore.exception.NoSuchDeviceTypeException;
import com.wz.testtask.estore.model.DeviceType;
import com.wz.testtask.estore.model.Employee;
import com.wz.testtask.estore.model.impl.DeviceTypeImpl;
import com.wz.testtask.estore.model.impl.DeviceTypeModelImpl;
import com.wz.testtask.estore.service.persistence.DeviceTypePersistence;
import com.wz.testtask.estore.service.persistence.DeviceTypeUtil;
import com.wz.testtask.estore.service.persistence.impl.constants.ESTOREPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the device type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author wz
 * @generated
 */
@Component(service = DeviceTypePersistence.class)
public class DeviceTypePersistenceImpl
	extends BasePersistenceImpl<DeviceType> implements DeviceTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DeviceTypeUtil</code> to access the device type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DeviceTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the device types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching device types
	 */
	@Override
	public List<DeviceType> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the device types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @return the range of matching device types
	 */
	@Override
	public List<DeviceType> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the device types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching device types
	 */
	@Override
	public List<DeviceType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DeviceType> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the device types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching device types
	 */
	@Override
	public List<DeviceType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DeviceType> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<DeviceType> list = null;

		if (useFinderCache) {
			list = (List<DeviceType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DeviceType deviceType : list) {
					if (!uuid.equals(deviceType.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DEVICETYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DeviceTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<DeviceType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first device type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	@Override
	public DeviceType findByUuid_First(
			String uuid, OrderByComparator<DeviceType> orderByComparator)
		throws NoSuchDeviceTypeException {

		DeviceType deviceType = fetchByUuid_First(uuid, orderByComparator);

		if (deviceType != null) {
			return deviceType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDeviceTypeException(sb.toString());
	}

	/**
	 * Returns the first device type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type, or <code>null</code> if a matching device type could not be found
	 */
	@Override
	public DeviceType fetchByUuid_First(
		String uuid, OrderByComparator<DeviceType> orderByComparator) {

		List<DeviceType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last device type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	@Override
	public DeviceType findByUuid_Last(
			String uuid, OrderByComparator<DeviceType> orderByComparator)
		throws NoSuchDeviceTypeException {

		DeviceType deviceType = fetchByUuid_Last(uuid, orderByComparator);

		if (deviceType != null) {
			return deviceType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDeviceTypeException(sb.toString());
	}

	/**
	 * Returns the last device type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type, or <code>null</code> if a matching device type could not be found
	 */
	@Override
	public DeviceType fetchByUuid_Last(
		String uuid, OrderByComparator<DeviceType> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DeviceType> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the device types before and after the current device type in the ordered set where uuid = &#63;.
	 *
	 * @param deviceTypeId the primary key of the current device type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device type
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	@Override
	public DeviceType[] findByUuid_PrevAndNext(
			long deviceTypeId, String uuid,
			OrderByComparator<DeviceType> orderByComparator)
		throws NoSuchDeviceTypeException {

		uuid = Objects.toString(uuid, "");

		DeviceType deviceType = findByPrimaryKey(deviceTypeId);

		Session session = null;

		try {
			session = openSession();

			DeviceType[] array = new DeviceTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, deviceType, uuid, orderByComparator, true);

			array[1] = deviceType;

			array[2] = getByUuid_PrevAndNext(
				session, deviceType, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DeviceType getByUuid_PrevAndNext(
		Session session, DeviceType deviceType, String uuid,
		OrderByComparator<DeviceType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DEVICETYPE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DeviceTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(deviceType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DeviceType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the device types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DeviceType deviceType :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(deviceType);
		}
	}

	/**
	 * Returns the number of device types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching device types
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEVICETYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"deviceType.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(deviceType.uuid IS NULL OR deviceType.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the device type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDeviceTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	@Override
	public DeviceType findByUUID_G(String uuid, long groupId)
		throws NoSuchDeviceTypeException {

		DeviceType deviceType = fetchByUUID_G(uuid, groupId);

		if (deviceType == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDeviceTypeException(sb.toString());
		}

		return deviceType;
	}

	/**
	 * Returns the device type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching device type, or <code>null</code> if a matching device type could not be found
	 */
	@Override
	public DeviceType fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the device type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching device type, or <code>null</code> if a matching device type could not be found
	 */
	@Override
	public DeviceType fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof DeviceType) {
			DeviceType deviceType = (DeviceType)result;

			if (!Objects.equals(uuid, deviceType.getUuid()) ||
				(groupId != deviceType.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DEVICETYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<DeviceType> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DeviceType deviceType = list.get(0);

					result = deviceType;

					cacheResult(deviceType);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DeviceType)result;
		}
	}

	/**
	 * Removes the device type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the device type that was removed
	 */
	@Override
	public DeviceType removeByUUID_G(String uuid, long groupId)
		throws NoSuchDeviceTypeException {

		DeviceType deviceType = findByUUID_G(uuid, groupId);

		return remove(deviceType);
	}

	/**
	 * Returns the number of device types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching device types
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEVICETYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"deviceType.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(deviceType.uuid IS NULL OR deviceType.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"deviceType.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the device types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching device types
	 */
	@Override
	public List<DeviceType> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the device types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @return the range of matching device types
	 */
	@Override
	public List<DeviceType> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the device types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching device types
	 */
	@Override
	public List<DeviceType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DeviceType> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the device types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching device types
	 */
	@Override
	public List<DeviceType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DeviceType> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<DeviceType> list = null;

		if (useFinderCache) {
			list = (List<DeviceType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DeviceType deviceType : list) {
					if (!uuid.equals(deviceType.getUuid()) ||
						(companyId != deviceType.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DEVICETYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DeviceTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<DeviceType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first device type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	@Override
	public DeviceType findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DeviceType> orderByComparator)
		throws NoSuchDeviceTypeException {

		DeviceType deviceType = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (deviceType != null) {
			return deviceType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDeviceTypeException(sb.toString());
	}

	/**
	 * Returns the first device type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type, or <code>null</code> if a matching device type could not be found
	 */
	@Override
	public DeviceType fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DeviceType> orderByComparator) {

		List<DeviceType> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last device type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	@Override
	public DeviceType findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DeviceType> orderByComparator)
		throws NoSuchDeviceTypeException {

		DeviceType deviceType = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (deviceType != null) {
			return deviceType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDeviceTypeException(sb.toString());
	}

	/**
	 * Returns the last device type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type, or <code>null</code> if a matching device type could not be found
	 */
	@Override
	public DeviceType fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DeviceType> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DeviceType> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the device types before and after the current device type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param deviceTypeId the primary key of the current device type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device type
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	@Override
	public DeviceType[] findByUuid_C_PrevAndNext(
			long deviceTypeId, String uuid, long companyId,
			OrderByComparator<DeviceType> orderByComparator)
		throws NoSuchDeviceTypeException {

		uuid = Objects.toString(uuid, "");

		DeviceType deviceType = findByPrimaryKey(deviceTypeId);

		Session session = null;

		try {
			session = openSession();

			DeviceType[] array = new DeviceTypeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, deviceType, uuid, companyId, orderByComparator, true);

			array[1] = deviceType;

			array[2] = getByUuid_C_PrevAndNext(
				session, deviceType, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DeviceType getByUuid_C_PrevAndNext(
		Session session, DeviceType deviceType, String uuid, long companyId,
		OrderByComparator<DeviceType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DEVICETYPE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DeviceTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(deviceType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DeviceType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the device types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DeviceType deviceType :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(deviceType);
		}
	}

	/**
	 * Returns the number of device types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching device types
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEVICETYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"deviceType.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(deviceType.uuid IS NULL OR deviceType.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"deviceType.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the device types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching device types
	 */
	@Override
	public List<DeviceType> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the device types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @return the range of matching device types
	 */
	@Override
	public List<DeviceType> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the device types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching device types
	 */
	@Override
	public List<DeviceType> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DeviceType> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the device types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching device types
	 */
	@Override
	public List<DeviceType> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DeviceType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<DeviceType> list = null;

		if (useFinderCache) {
			list = (List<DeviceType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DeviceType deviceType : list) {
					if (groupId != deviceType.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DEVICETYPE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DeviceTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<DeviceType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first device type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	@Override
	public DeviceType findByGroupId_First(
			long groupId, OrderByComparator<DeviceType> orderByComparator)
		throws NoSuchDeviceTypeException {

		DeviceType deviceType = fetchByGroupId_First(
			groupId, orderByComparator);

		if (deviceType != null) {
			return deviceType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDeviceTypeException(sb.toString());
	}

	/**
	 * Returns the first device type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device type, or <code>null</code> if a matching device type could not be found
	 */
	@Override
	public DeviceType fetchByGroupId_First(
		long groupId, OrderByComparator<DeviceType> orderByComparator) {

		List<DeviceType> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last device type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	@Override
	public DeviceType findByGroupId_Last(
			long groupId, OrderByComparator<DeviceType> orderByComparator)
		throws NoSuchDeviceTypeException {

		DeviceType deviceType = fetchByGroupId_Last(groupId, orderByComparator);

		if (deviceType != null) {
			return deviceType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDeviceTypeException(sb.toString());
	}

	/**
	 * Returns the last device type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device type, or <code>null</code> if a matching device type could not be found
	 */
	@Override
	public DeviceType fetchByGroupId_Last(
		long groupId, OrderByComparator<DeviceType> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<DeviceType> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the device types before and after the current device type in the ordered set where groupId = &#63;.
	 *
	 * @param deviceTypeId the primary key of the current device type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device type
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	@Override
	public DeviceType[] findByGroupId_PrevAndNext(
			long deviceTypeId, long groupId,
			OrderByComparator<DeviceType> orderByComparator)
		throws NoSuchDeviceTypeException {

		DeviceType deviceType = findByPrimaryKey(deviceTypeId);

		Session session = null;

		try {
			session = openSession();

			DeviceType[] array = new DeviceTypeImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, deviceType, groupId, orderByComparator, true);

			array[1] = deviceType;

			array[2] = getByGroupId_PrevAndNext(
				session, deviceType, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DeviceType getByGroupId_PrevAndNext(
		Session session, DeviceType deviceType, long groupId,
		OrderByComparator<DeviceType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DEVICETYPE_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DeviceTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(deviceType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DeviceType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the device types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (DeviceType deviceType :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(deviceType);
		}
	}

	/**
	 * Returns the number of device types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching device types
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEVICETYPE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"deviceType.groupId = ?";

	private FinderPath _finderPathFetchByGroupIdName;
	private FinderPath _finderPathCountByGroupIdName;

	/**
	 * Returns the device type where groupId = &#63; and name = &#63; or throws a <code>NoSuchDeviceTypeException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching device type
	 * @throws NoSuchDeviceTypeException if a matching device type could not be found
	 */
	@Override
	public DeviceType findByGroupIdName(long groupId, String name)
		throws NoSuchDeviceTypeException {

		DeviceType deviceType = fetchByGroupIdName(groupId, name);

		if (deviceType == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDeviceTypeException(sb.toString());
		}

		return deviceType;
	}

	/**
	 * Returns the device type where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching device type, or <code>null</code> if a matching device type could not be found
	 */
	@Override
	public DeviceType fetchByGroupIdName(long groupId, String name) {
		return fetchByGroupIdName(groupId, name, true);
	}

	/**
	 * Returns the device type where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching device type, or <code>null</code> if a matching device type could not be found
	 */
	@Override
	public DeviceType fetchByGroupIdName(
		long groupId, String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByGroupIdName, finderArgs, this);
		}

		if (result instanceof DeviceType) {
			DeviceType deviceType = (DeviceType)result;

			if ((groupId != deviceType.getGroupId()) ||
				!Objects.equals(name, deviceType.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DEVICETYPE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDNAME_GROUPID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_GROUPIDNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_GROUPIDNAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindName) {
					queryPos.add(name);
				}

				List<DeviceType> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByGroupIdName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {groupId, name};
							}

							_log.warn(
								"DeviceTypePersistenceImpl.fetchByGroupIdName(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DeviceType deviceType = list.get(0);

					result = deviceType;

					cacheResult(deviceType);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DeviceType)result;
		}
	}

	/**
	 * Removes the device type where groupId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the device type that was removed
	 */
	@Override
	public DeviceType removeByGroupIdName(long groupId, String name)
		throws NoSuchDeviceTypeException {

		DeviceType deviceType = findByGroupIdName(groupId, name);

		return remove(deviceType);
	}

	/**
	 * Returns the number of device types where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching device types
	 */
	@Override
	public int countByGroupIdName(long groupId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByGroupIdName;

		Object[] finderArgs = new Object[] {groupId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEVICETYPE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDNAME_GROUPID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_GROUPIDNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_GROUPIDNAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPIDNAME_GROUPID_2 =
		"deviceType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPIDNAME_NAME_2 =
		"deviceType.name = ?";

	private static final String _FINDER_COLUMN_GROUPIDNAME_NAME_3 =
		"(deviceType.name IS NULL OR deviceType.name = '')";

	public DeviceTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DeviceType.class);

		setModelImplClass(DeviceTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the device type in the entity cache if it is enabled.
	 *
	 * @param deviceType the device type
	 */
	@Override
	public void cacheResult(DeviceType deviceType) {
		entityCache.putResult(
			DeviceTypeImpl.class, deviceType.getPrimaryKey(), deviceType);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {deviceType.getUuid(), deviceType.getGroupId()},
			deviceType);

		finderCache.putResult(
			_finderPathFetchByGroupIdName,
			new Object[] {deviceType.getGroupId(), deviceType.getName()},
			deviceType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the device types in the entity cache if it is enabled.
	 *
	 * @param deviceTypes the device types
	 */
	@Override
	public void cacheResult(List<DeviceType> deviceTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (deviceTypes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DeviceType deviceType : deviceTypes) {
			if (entityCache.getResult(
					DeviceTypeImpl.class, deviceType.getPrimaryKey()) == null) {

				cacheResult(deviceType);
			}
		}
	}

	/**
	 * Clears the cache for all device types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DeviceTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the device type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DeviceType deviceType) {
		entityCache.removeResult(DeviceTypeImpl.class, deviceType);
	}

	@Override
	public void clearCache(List<DeviceType> deviceTypes) {
		for (DeviceType deviceType : deviceTypes) {
			entityCache.removeResult(DeviceTypeImpl.class, deviceType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DeviceTypeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DeviceTypeModelImpl deviceTypeModelImpl) {

		Object[] args = new Object[] {
			deviceTypeModelImpl.getUuid(), deviceTypeModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, deviceTypeModelImpl, false);

		args = new Object[] {
			deviceTypeModelImpl.getGroupId(), deviceTypeModelImpl.getName()
		};

		finderCache.putResult(
			_finderPathCountByGroupIdName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByGroupIdName, args, deviceTypeModelImpl, false);
	}

	/**
	 * Creates a new device type with the primary key. Does not add the device type to the database.
	 *
	 * @param deviceTypeId the primary key for the new device type
	 * @return the new device type
	 */
	@Override
	public DeviceType create(long deviceTypeId) {
		DeviceType deviceType = new DeviceTypeImpl();

		deviceType.setNew(true);
		deviceType.setPrimaryKey(deviceTypeId);

		String uuid = PortalUUIDUtil.generate();

		deviceType.setUuid(uuid);

		deviceType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return deviceType;
	}

	/**
	 * Removes the device type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deviceTypeId the primary key of the device type
	 * @return the device type that was removed
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	@Override
	public DeviceType remove(long deviceTypeId)
		throws NoSuchDeviceTypeException {

		return remove((Serializable)deviceTypeId);
	}

	/**
	 * Removes the device type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the device type
	 * @return the device type that was removed
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	@Override
	public DeviceType remove(Serializable primaryKey)
		throws NoSuchDeviceTypeException {

		Session session = null;

		try {
			session = openSession();

			DeviceType deviceType = (DeviceType)session.get(
				DeviceTypeImpl.class, primaryKey);

			if (deviceType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDeviceTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(deviceType);
		}
		catch (NoSuchDeviceTypeException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DeviceType removeImpl(DeviceType deviceType) {
		deviceTypeToEmployeeTableMapper.deleteLeftPrimaryKeyTableMappings(
			deviceType.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(deviceType)) {
				deviceType = (DeviceType)session.get(
					DeviceTypeImpl.class, deviceType.getPrimaryKeyObj());
			}

			if (deviceType != null) {
				session.delete(deviceType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (deviceType != null) {
			clearCache(deviceType);
		}

		return deviceType;
	}

	@Override
	public DeviceType updateImpl(DeviceType deviceType) {
		boolean isNew = deviceType.isNew();

		if (!(deviceType instanceof DeviceTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(deviceType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(deviceType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in deviceType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DeviceType implementation " +
					deviceType.getClass());
		}

		DeviceTypeModelImpl deviceTypeModelImpl =
			(DeviceTypeModelImpl)deviceType;

		if (Validator.isNull(deviceType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			deviceType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(deviceType);
			}
			else {
				deviceType = (DeviceType)session.merge(deviceType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DeviceTypeImpl.class, deviceTypeModelImpl, false, true);

		cacheUniqueFindersCache(deviceTypeModelImpl);

		if (isNew) {
			deviceType.setNew(false);
		}

		deviceType.resetOriginalValues();

		return deviceType;
	}

	/**
	 * Returns the device type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the device type
	 * @return the device type
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	@Override
	public DeviceType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDeviceTypeException {

		DeviceType deviceType = fetchByPrimaryKey(primaryKey);

		if (deviceType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDeviceTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return deviceType;
	}

	/**
	 * Returns the device type with the primary key or throws a <code>NoSuchDeviceTypeException</code> if it could not be found.
	 *
	 * @param deviceTypeId the primary key of the device type
	 * @return the device type
	 * @throws NoSuchDeviceTypeException if a device type with the primary key could not be found
	 */
	@Override
	public DeviceType findByPrimaryKey(long deviceTypeId)
		throws NoSuchDeviceTypeException {

		return findByPrimaryKey((Serializable)deviceTypeId);
	}

	/**
	 * Returns the device type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deviceTypeId the primary key of the device type
	 * @return the device type, or <code>null</code> if a device type with the primary key could not be found
	 */
	@Override
	public DeviceType fetchByPrimaryKey(long deviceTypeId) {
		return fetchByPrimaryKey((Serializable)deviceTypeId);
	}

	/**
	 * Returns all the device types.
	 *
	 * @return the device types
	 */
	@Override
	public List<DeviceType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the device types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @return the range of device types
	 */
	@Override
	public List<DeviceType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the device types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of device types
	 */
	@Override
	public List<DeviceType> findAll(
		int start, int end, OrderByComparator<DeviceType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the device types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of device types
	 * @param end the upper bound of the range of device types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of device types
	 */
	@Override
	public List<DeviceType> findAll(
		int start, int end, OrderByComparator<DeviceType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<DeviceType> list = null;

		if (useFinderCache) {
			list = (List<DeviceType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DEVICETYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DEVICETYPE;

				sql = sql.concat(DeviceTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DeviceType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the device types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DeviceType deviceType : findAll()) {
			remove(deviceType);
		}
	}

	/**
	 * Returns the number of device types.
	 *
	 * @return the number of device types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DEVICETYPE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the primaryKeys of employees associated with the device type.
	 *
	 * @param pk the primary key of the device type
	 * @return long[] of the primaryKeys of employees associated with the device type
	 */
	@Override
	public long[] getEmployeePrimaryKeys(long pk) {
		long[] pks = deviceTypeToEmployeeTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the device type associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @return the device types associated with the employee
	 */
	@Override
	public List<DeviceType> getEmployeeDeviceTypes(long pk) {
		return getEmployeeDeviceTypes(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the device type associated with the employee.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the employee
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of device types associated with the employee
	 */
	@Override
	public List<DeviceType> getEmployeeDeviceTypes(
		long pk, int start, int end) {

		return getEmployeeDeviceTypes(pk, start, end, null);
	}

	/**
	 * Returns all the device type associated with the employee.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the employee
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of device types associated with the employee
	 */
	@Override
	public List<DeviceType> getEmployeeDeviceTypes(
		long pk, int start, int end,
		OrderByComparator<DeviceType> orderByComparator) {

		return deviceTypeToEmployeeTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employees associated with the device type.
	 *
	 * @param pk the primary key of the device type
	 * @return the number of employees associated with the device type
	 */
	@Override
	public int getEmployeesSize(long pk) {
		long[] pks = deviceTypeToEmployeeTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the employee is associated with the device type.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePK the primary key of the employee
	 * @return <code>true</code> if the employee is associated with the device type; <code>false</code> otherwise
	 */
	@Override
	public boolean containsEmployee(long pk, long employeePK) {
		return deviceTypeToEmployeeTableMapper.containsTableMapping(
			pk, employeePK);
	}

	/**
	 * Returns <code>true</code> if the device type has any employees associated with it.
	 *
	 * @param pk the primary key of the device type to check for associations with employees
	 * @return <code>true</code> if the device type has any employees associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsEmployees(long pk) {
		if (getEmployeesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the device type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePK the primary key of the employee
	 */
	@Override
	public void addEmployee(long pk, long employeePK) {
		DeviceType deviceType = fetchByPrimaryKey(pk);

		if (deviceType == null) {
			deviceTypeToEmployeeTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, employeePK);
		}
		else {
			deviceTypeToEmployeeTableMapper.addTableMapping(
				deviceType.getCompanyId(), pk, employeePK);
		}
	}

	/**
	 * Adds an association between the device type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employee the employee
	 */
	@Override
	public void addEmployee(long pk, Employee employee) {
		DeviceType deviceType = fetchByPrimaryKey(pk);

		if (deviceType == null) {
			deviceTypeToEmployeeTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				employee.getPrimaryKey());
		}
		else {
			deviceTypeToEmployeeTableMapper.addTableMapping(
				deviceType.getCompanyId(), pk, employee.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the device type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePKs the primary keys of the employees
	 */
	@Override
	public void addEmployees(long pk, long[] employeePKs) {
		long companyId = 0;

		DeviceType deviceType = fetchByPrimaryKey(pk);

		if (deviceType == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = deviceType.getCompanyId();
		}

		deviceTypeToEmployeeTableMapper.addTableMappings(
			companyId, pk, employeePKs);
	}

	/**
	 * Adds an association between the device type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employees the employees
	 */
	@Override
	public void addEmployees(long pk, List<Employee> employees) {
		addEmployees(
			pk, ListUtil.toLongArray(employees, Employee.EMPLOYEE_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the device type and its employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type to clear the associated employees from
	 */
	@Override
	public void clearEmployees(long pk) {
		deviceTypeToEmployeeTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the device type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePK the primary key of the employee
	 */
	@Override
	public void removeEmployee(long pk, long employeePK) {
		deviceTypeToEmployeeTableMapper.deleteTableMapping(pk, employeePK);
	}

	/**
	 * Removes the association between the device type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employee the employee
	 */
	@Override
	public void removeEmployee(long pk, Employee employee) {
		deviceTypeToEmployeeTableMapper.deleteTableMapping(
			pk, employee.getPrimaryKey());
	}

	/**
	 * Removes the association between the device type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePKs the primary keys of the employees
	 */
	@Override
	public void removeEmployees(long pk, long[] employeePKs) {
		deviceTypeToEmployeeTableMapper.deleteTableMappings(pk, employeePKs);
	}

	/**
	 * Removes the association between the device type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employees the employees
	 */
	@Override
	public void removeEmployees(long pk, List<Employee> employees) {
		removeEmployees(
			pk, ListUtil.toLongArray(employees, Employee.EMPLOYEE_ID_ACCESSOR));
	}

	/**
	 * Sets the employees associated with the device type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employeePKs the primary keys of the employees to be associated with the device type
	 */
	@Override
	public void setEmployees(long pk, long[] employeePKs) {
		Set<Long> newEmployeePKsSet = SetUtil.fromArray(employeePKs);
		Set<Long> oldEmployeePKsSet = SetUtil.fromArray(
			deviceTypeToEmployeeTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeEmployeePKsSet = new HashSet<Long>(oldEmployeePKsSet);

		removeEmployeePKsSet.removeAll(newEmployeePKsSet);

		deviceTypeToEmployeeTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeEmployeePKsSet));

		newEmployeePKsSet.removeAll(oldEmployeePKsSet);

		long companyId = 0;

		DeviceType deviceType = fetchByPrimaryKey(pk);

		if (deviceType == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = deviceType.getCompanyId();
		}

		deviceTypeToEmployeeTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newEmployeePKsSet));
	}

	/**
	 * Sets the employees associated with the device type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the device type
	 * @param employees the employees to be associated with the device type
	 */
	@Override
	public void setEmployees(long pk, List<Employee> employees) {
		try {
			long[] employeePKs = new long[employees.size()];

			for (int i = 0; i < employees.size(); i++) {
				Employee employee = employees.get(i);

				employeePKs[i] = employee.getPrimaryKey();
			}

			setEmployees(pk, employeePKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "deviceTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DEVICETYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DeviceTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the device type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new DeviceTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DeviceType.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		deviceTypeToEmployeeTableMapper = TableMapperFactory.getTableMapper(
			"ESTORE_EmployeeDeviceCons#deviceTypeId",
			"ESTORE_EmployeeDeviceCons", "companyId", "deviceTypeId",
			"employeeId", this, Employee.class);

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathFetchByGroupIdName = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByGroupIdName",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"groupId", "name"}, true);

		_finderPathCountByGroupIdName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupIdName",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"groupId", "name"}, false);

		_setDeviceTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDeviceTypeUtilPersistence(null);

		entityCache.removeCache(DeviceTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}

		TableMapperFactory.removeTableMapper(
			"ESTORE_EmployeeDeviceCons#deviceTypeId");
	}

	private void _setDeviceTypeUtilPersistence(
		DeviceTypePersistence deviceTypePersistence) {

		try {
			Field field = DeviceTypeUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, deviceTypePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = ESTOREPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ESTOREPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ESTOREPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	protected TableMapper<DeviceType, Employee> deviceTypeToEmployeeTableMapper;

	private static final String _SQL_SELECT_DEVICETYPE =
		"SELECT deviceType FROM DeviceType deviceType";

	private static final String _SQL_SELECT_DEVICETYPE_WHERE =
		"SELECT deviceType FROM DeviceType deviceType WHERE ";

	private static final String _SQL_COUNT_DEVICETYPE =
		"SELECT COUNT(deviceType) FROM DeviceType deviceType";

	private static final String _SQL_COUNT_DEVICETYPE_WHERE =
		"SELECT COUNT(deviceType) FROM DeviceType deviceType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "deviceType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DeviceType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DeviceType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DeviceTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class DeviceTypeModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			DeviceTypeModelImpl deviceTypeModelImpl =
				(DeviceTypeModelImpl)baseModel;

			long columnBitmask = deviceTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(deviceTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						deviceTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(deviceTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			DeviceTypeModelImpl deviceTypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = deviceTypeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = deviceTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}