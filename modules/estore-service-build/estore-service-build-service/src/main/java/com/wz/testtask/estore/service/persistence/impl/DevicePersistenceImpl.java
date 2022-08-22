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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.wz.testtask.estore.exception.NoSuchDeviceException;
import com.wz.testtask.estore.model.Device;
import com.wz.testtask.estore.model.impl.DeviceImpl;
import com.wz.testtask.estore.model.impl.DeviceModelImpl;
import com.wz.testtask.estore.service.persistence.DevicePersistence;
import com.wz.testtask.estore.service.persistence.DeviceUtil;
import com.wz.testtask.estore.service.persistence.impl.constants.ESTOREPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the device service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author wz
 * @generated
 */
@Component(service = DevicePersistence.class)
public class DevicePersistenceImpl
	extends BasePersistenceImpl<Device> implements DevicePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DeviceUtil</code> to access the device persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DeviceImpl.class.getName();

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
	 * Returns all the devices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching devices
	 */
	@Override
	public List<Device> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the devices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @return the range of matching devices
	 */
	@Override
	public List<Device> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the devices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching devices
	 */
	@Override
	public List<Device> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Device> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the devices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching devices
	 */
	@Override
	public List<Device> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Device> orderByComparator, boolean useFinderCache) {

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

		List<Device> list = null;

		if (useFinderCache) {
			list = (List<Device>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Device device : list) {
					if (!uuid.equals(device.getUuid())) {
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

			sb.append(_SQL_SELECT_DEVICE_WHERE);

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
				sb.append(DeviceModelImpl.ORDER_BY_JPQL);
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

				list = (List<Device>)QueryUtil.list(
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
	 * Returns the first device in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	@Override
	public Device findByUuid_First(
			String uuid, OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		Device device = fetchByUuid_First(uuid, orderByComparator);

		if (device != null) {
			return device;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDeviceException(sb.toString());
	}

	/**
	 * Returns the first device in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device, or <code>null</code> if a matching device could not be found
	 */
	@Override
	public Device fetchByUuid_First(
		String uuid, OrderByComparator<Device> orderByComparator) {

		List<Device> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last device in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	@Override
	public Device findByUuid_Last(
			String uuid, OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		Device device = fetchByUuid_Last(uuid, orderByComparator);

		if (device != null) {
			return device;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDeviceException(sb.toString());
	}

	/**
	 * Returns the last device in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device, or <code>null</code> if a matching device could not be found
	 */
	@Override
	public Device fetchByUuid_Last(
		String uuid, OrderByComparator<Device> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Device> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the devices before and after the current device in the ordered set where uuid = &#63;.
	 *
	 * @param deviceId the primary key of the current device
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	@Override
	public Device[] findByUuid_PrevAndNext(
			long deviceId, String uuid,
			OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		uuid = Objects.toString(uuid, "");

		Device device = findByPrimaryKey(deviceId);

		Session session = null;

		try {
			session = openSession();

			Device[] array = new DeviceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, device, uuid, orderByComparator, true);

			array[1] = device;

			array[2] = getByUuid_PrevAndNext(
				session, device, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Device getByUuid_PrevAndNext(
		Session session, Device device, String uuid,
		OrderByComparator<Device> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DEVICE_WHERE);

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
			sb.append(DeviceModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(device)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Device> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the devices where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Device device :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(device);
		}
	}

	/**
	 * Returns the number of devices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching devices
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEVICE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "device.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(device.uuid IS NULL OR device.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the device where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDeviceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	@Override
	public Device findByUUID_G(String uuid, long groupId)
		throws NoSuchDeviceException {

		Device device = fetchByUUID_G(uuid, groupId);

		if (device == null) {
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

			throw new NoSuchDeviceException(sb.toString());
		}

		return device;
	}

	/**
	 * Returns the device where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching device, or <code>null</code> if a matching device could not be found
	 */
	@Override
	public Device fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the device where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching device, or <code>null</code> if a matching device could not be found
	 */
	@Override
	public Device fetchByUUID_G(
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

		if (result instanceof Device) {
			Device device = (Device)result;

			if (!Objects.equals(uuid, device.getUuid()) ||
				(groupId != device.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DEVICE_WHERE);

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

				List<Device> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Device device = list.get(0);

					result = device;

					cacheResult(device);
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
			return (Device)result;
		}
	}

	/**
	 * Removes the device where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the device that was removed
	 */
	@Override
	public Device removeByUUID_G(String uuid, long groupId)
		throws NoSuchDeviceException {

		Device device = findByUUID_G(uuid, groupId);

		return remove(device);
	}

	/**
	 * Returns the number of devices where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching devices
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEVICE_WHERE);

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
		"device.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(device.uuid IS NULL OR device.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"device.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the devices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching devices
	 */
	@Override
	public List<Device> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the devices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @return the range of matching devices
	 */
	@Override
	public List<Device> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the devices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching devices
	 */
	@Override
	public List<Device> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Device> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the devices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching devices
	 */
	@Override
	public List<Device> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Device> orderByComparator, boolean useFinderCache) {

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

		List<Device> list = null;

		if (useFinderCache) {
			list = (List<Device>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Device device : list) {
					if (!uuid.equals(device.getUuid()) ||
						(companyId != device.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DEVICE_WHERE);

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
				sb.append(DeviceModelImpl.ORDER_BY_JPQL);
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

				list = (List<Device>)QueryUtil.list(
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
	 * Returns the first device in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	@Override
	public Device findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		Device device = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (device != null) {
			return device;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDeviceException(sb.toString());
	}

	/**
	 * Returns the first device in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device, or <code>null</code> if a matching device could not be found
	 */
	@Override
	public Device fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Device> orderByComparator) {

		List<Device> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last device in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	@Override
	public Device findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		Device device = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (device != null) {
			return device;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDeviceException(sb.toString());
	}

	/**
	 * Returns the last device in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device, or <code>null</code> if a matching device could not be found
	 */
	@Override
	public Device fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Device> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Device> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the devices before and after the current device in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param deviceId the primary key of the current device
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	@Override
	public Device[] findByUuid_C_PrevAndNext(
			long deviceId, String uuid, long companyId,
			OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		uuid = Objects.toString(uuid, "");

		Device device = findByPrimaryKey(deviceId);

		Session session = null;

		try {
			session = openSession();

			Device[] array = new DeviceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, device, uuid, companyId, orderByComparator, true);

			array[1] = device;

			array[2] = getByUuid_C_PrevAndNext(
				session, device, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Device getByUuid_C_PrevAndNext(
		Session session, Device device, String uuid, long companyId,
		OrderByComparator<Device> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DEVICE_WHERE);

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
			sb.append(DeviceModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(device)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Device> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the devices where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Device device :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(device);
		}
	}

	/**
	 * Returns the number of devices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching devices
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEVICE_WHERE);

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
		"device.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(device.uuid IS NULL OR device.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"device.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the devices where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching devices
	 */
	@Override
	public List<Device> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the devices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @return the range of matching devices
	 */
	@Override
	public List<Device> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the devices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching devices
	 */
	@Override
	public List<Device> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Device> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the devices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching devices
	 */
	@Override
	public List<Device> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Device> orderByComparator, boolean useFinderCache) {

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

		List<Device> list = null;

		if (useFinderCache) {
			list = (List<Device>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Device device : list) {
					if (groupId != device.getGroupId()) {
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

			sb.append(_SQL_SELECT_DEVICE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DeviceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Device>)QueryUtil.list(
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
	 * Returns the first device in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	@Override
	public Device findByGroupId_First(
			long groupId, OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		Device device = fetchByGroupId_First(groupId, orderByComparator);

		if (device != null) {
			return device;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDeviceException(sb.toString());
	}

	/**
	 * Returns the first device in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device, or <code>null</code> if a matching device could not be found
	 */
	@Override
	public Device fetchByGroupId_First(
		long groupId, OrderByComparator<Device> orderByComparator) {

		List<Device> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last device in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	@Override
	public Device findByGroupId_Last(
			long groupId, OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		Device device = fetchByGroupId_Last(groupId, orderByComparator);

		if (device != null) {
			return device;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDeviceException(sb.toString());
	}

	/**
	 * Returns the last device in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device, or <code>null</code> if a matching device could not be found
	 */
	@Override
	public Device fetchByGroupId_Last(
		long groupId, OrderByComparator<Device> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Device> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the devices before and after the current device in the ordered set where groupId = &#63;.
	 *
	 * @param deviceId the primary key of the current device
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	@Override
	public Device[] findByGroupId_PrevAndNext(
			long deviceId, long groupId,
			OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		Device device = findByPrimaryKey(deviceId);

		Session session = null;

		try {
			session = openSession();

			Device[] array = new DeviceImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, device, groupId, orderByComparator, true);

			array[1] = device;

			array[2] = getByGroupId_PrevAndNext(
				session, device, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Device getByGroupId_PrevAndNext(
		Session session, Device device, long groupId,
		OrderByComparator<Device> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DEVICE_WHERE);

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
			sb.append(DeviceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(device)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Device> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the devices where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Device device :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(device);
		}
	}

	/**
	 * Returns the number of devices where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching devices
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEVICE_WHERE);

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
		"device.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the devices where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching devices
	 */
	@Override
	public List<Device> findByName(long groupId, String name) {
		return findByName(
			groupId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the devices where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @return the range of matching devices
	 */
	@Override
	public List<Device> findByName(
		long groupId, String name, int start, int end) {

		return findByName(groupId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the devices where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching devices
	 */
	@Override
	public List<Device> findByName(
		long groupId, String name, int start, int end,
		OrderByComparator<Device> orderByComparator) {

		return findByName(groupId, name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the devices where groupId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching devices
	 */
	@Override
	public List<Device> findByName(
		long groupId, String name, int start, int end,
		OrderByComparator<Device> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName;
				finderArgs = new Object[] {groupId, name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName;
			finderArgs = new Object[] {
				groupId, name, start, end, orderByComparator
			};
		}

		List<Device> list = null;

		if (useFinderCache) {
			list = (List<Device>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Device device : list) {
					if ((groupId != device.getGroupId()) ||
						!name.equals(device.getName())) {

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

			sb.append(_SQL_SELECT_DEVICE_WHERE);

			sb.append(_FINDER_COLUMN_NAME_GROUPID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DeviceModelImpl.ORDER_BY_JPQL);
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

				list = (List<Device>)QueryUtil.list(
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
	 * Returns the first device in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	@Override
	public Device findByName_First(
			long groupId, String name,
			OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		Device device = fetchByName_First(groupId, name, orderByComparator);

		if (device != null) {
			return device;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDeviceException(sb.toString());
	}

	/**
	 * Returns the first device in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device, or <code>null</code> if a matching device could not be found
	 */
	@Override
	public Device fetchByName_First(
		long groupId, String name,
		OrderByComparator<Device> orderByComparator) {

		List<Device> list = findByName(groupId, name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last device in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	@Override
	public Device findByName_Last(
			long groupId, String name,
			OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		Device device = fetchByName_Last(groupId, name, orderByComparator);

		if (device != null) {
			return device;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDeviceException(sb.toString());
	}

	/**
	 * Returns the last device in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device, or <code>null</code> if a matching device could not be found
	 */
	@Override
	public Device fetchByName_Last(
		long groupId, String name,
		OrderByComparator<Device> orderByComparator) {

		int count = countByName(groupId, name);

		if (count == 0) {
			return null;
		}

		List<Device> list = findByName(
			groupId, name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the devices before and after the current device in the ordered set where groupId = &#63; and name = &#63;.
	 *
	 * @param deviceId the primary key of the current device
	 * @param groupId the group ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	@Override
	public Device[] findByName_PrevAndNext(
			long deviceId, long groupId, String name,
			OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		name = Objects.toString(name, "");

		Device device = findByPrimaryKey(deviceId);

		Session session = null;

		try {
			session = openSession();

			Device[] array = new DeviceImpl[3];

			array[0] = getByName_PrevAndNext(
				session, device, groupId, name, orderByComparator, true);

			array[1] = device;

			array[2] = getByName_PrevAndNext(
				session, device, groupId, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Device getByName_PrevAndNext(
		Session session, Device device, long groupId, String name,
		OrderByComparator<Device> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DEVICE_WHERE);

		sb.append(_FINDER_COLUMN_NAME_GROUPID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_2);
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
			sb.append(DeviceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(device)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Device> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the devices where groupId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 */
	@Override
	public void removeByName(long groupId, String name) {
		for (Device device :
				findByName(
					groupId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(device);
		}
	}

	/**
	 * Returns the number of devices where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching devices
	 */
	@Override
	public int countByName(long groupId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {groupId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEVICE_WHERE);

			sb.append(_FINDER_COLUMN_NAME_GROUPID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
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

	private static final String _FINDER_COLUMN_NAME_GROUPID_2 =
		"device.groupId = ? AND ";

	private static final String _FINDER_COLUMN_NAME_NAME_2 = "device.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(device.name IS NULL OR device.name = '')";

	private FinderPath _finderPathWithPaginationFindByDeviceType;
	private FinderPath _finderPathWithoutPaginationFindByDeviceType;
	private FinderPath _finderPathCountByDeviceType;

	/**
	 * Returns all the devices where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @return the matching devices
	 */
	@Override
	public List<Device> findByDeviceType(long groupId, long deviceTypeId) {
		return findByDeviceType(
			groupId, deviceTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the devices where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @return the range of matching devices
	 */
	@Override
	public List<Device> findByDeviceType(
		long groupId, long deviceTypeId, int start, int end) {

		return findByDeviceType(groupId, deviceTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the devices where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching devices
	 */
	@Override
	public List<Device> findByDeviceType(
		long groupId, long deviceTypeId, int start, int end,
		OrderByComparator<Device> orderByComparator) {

		return findByDeviceType(
			groupId, deviceTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the devices where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching devices
	 */
	@Override
	public List<Device> findByDeviceType(
		long groupId, long deviceTypeId, int start, int end,
		OrderByComparator<Device> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDeviceType;
				finderArgs = new Object[] {groupId, deviceTypeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDeviceType;
			finderArgs = new Object[] {
				groupId, deviceTypeId, start, end, orderByComparator
			};
		}

		List<Device> list = null;

		if (useFinderCache) {
			list = (List<Device>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Device device : list) {
					if ((groupId != device.getGroupId()) ||
						(deviceTypeId != device.getDeviceTypeId())) {

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

			sb.append(_SQL_SELECT_DEVICE_WHERE);

			sb.append(_FINDER_COLUMN_DEVICETYPE_GROUPID_2);

			sb.append(_FINDER_COLUMN_DEVICETYPE_DEVICETYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DeviceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(deviceTypeId);

				list = (List<Device>)QueryUtil.list(
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
	 * Returns the first device in the ordered set where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	@Override
	public Device findByDeviceType_First(
			long groupId, long deviceTypeId,
			OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		Device device = fetchByDeviceType_First(
			groupId, deviceTypeId, orderByComparator);

		if (device != null) {
			return device;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", deviceTypeId=");
		sb.append(deviceTypeId);

		sb.append("}");

		throw new NoSuchDeviceException(sb.toString());
	}

	/**
	 * Returns the first device in the ordered set where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device, or <code>null</code> if a matching device could not be found
	 */
	@Override
	public Device fetchByDeviceType_First(
		long groupId, long deviceTypeId,
		OrderByComparator<Device> orderByComparator) {

		List<Device> list = findByDeviceType(
			groupId, deviceTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last device in the ordered set where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device
	 * @throws NoSuchDeviceException if a matching device could not be found
	 */
	@Override
	public Device findByDeviceType_Last(
			long groupId, long deviceTypeId,
			OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		Device device = fetchByDeviceType_Last(
			groupId, deviceTypeId, orderByComparator);

		if (device != null) {
			return device;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", deviceTypeId=");
		sb.append(deviceTypeId);

		sb.append("}");

		throw new NoSuchDeviceException(sb.toString());
	}

	/**
	 * Returns the last device in the ordered set where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device, or <code>null</code> if a matching device could not be found
	 */
	@Override
	public Device fetchByDeviceType_Last(
		long groupId, long deviceTypeId,
		OrderByComparator<Device> orderByComparator) {

		int count = countByDeviceType(groupId, deviceTypeId);

		if (count == 0) {
			return null;
		}

		List<Device> list = findByDeviceType(
			groupId, deviceTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the devices before and after the current device in the ordered set where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * @param deviceId the primary key of the current device
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	@Override
	public Device[] findByDeviceType_PrevAndNext(
			long deviceId, long groupId, long deviceTypeId,
			OrderByComparator<Device> orderByComparator)
		throws NoSuchDeviceException {

		Device device = findByPrimaryKey(deviceId);

		Session session = null;

		try {
			session = openSession();

			Device[] array = new DeviceImpl[3];

			array[0] = getByDeviceType_PrevAndNext(
				session, device, groupId, deviceTypeId, orderByComparator,
				true);

			array[1] = device;

			array[2] = getByDeviceType_PrevAndNext(
				session, device, groupId, deviceTypeId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Device getByDeviceType_PrevAndNext(
		Session session, Device device, long groupId, long deviceTypeId,
		OrderByComparator<Device> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DEVICE_WHERE);

		sb.append(_FINDER_COLUMN_DEVICETYPE_GROUPID_2);

		sb.append(_FINDER_COLUMN_DEVICETYPE_DEVICETYPEID_2);

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
			sb.append(DeviceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(deviceTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(device)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Device> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the devices where groupId = &#63; and deviceTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 */
	@Override
	public void removeByDeviceType(long groupId, long deviceTypeId) {
		for (Device device :
				findByDeviceType(
					groupId, deviceTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(device);
		}
	}

	/**
	 * Returns the number of devices where groupId = &#63; and deviceTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceTypeId the device type ID
	 * @return the number of matching devices
	 */
	@Override
	public int countByDeviceType(long groupId, long deviceTypeId) {
		FinderPath finderPath = _finderPathCountByDeviceType;

		Object[] finderArgs = new Object[] {groupId, deviceTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEVICE_WHERE);

			sb.append(_FINDER_COLUMN_DEVICETYPE_GROUPID_2);

			sb.append(_FINDER_COLUMN_DEVICETYPE_DEVICETYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(deviceTypeId);

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

	private static final String _FINDER_COLUMN_DEVICETYPE_GROUPID_2 =
		"device.groupId = ? AND ";

	private static final String _FINDER_COLUMN_DEVICETYPE_DEVICETYPEID_2 =
		"device.deviceTypeId = ?";

	public DevicePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Device.class);

		setModelImplClass(DeviceImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the device in the entity cache if it is enabled.
	 *
	 * @param device the device
	 */
	@Override
	public void cacheResult(Device device) {
		entityCache.putResult(DeviceImpl.class, device.getPrimaryKey(), device);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {device.getUuid(), device.getGroupId()}, device);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the devices in the entity cache if it is enabled.
	 *
	 * @param devices the devices
	 */
	@Override
	public void cacheResult(List<Device> devices) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (devices.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Device device : devices) {
			if (entityCache.getResult(
					DeviceImpl.class, device.getPrimaryKey()) == null) {

				cacheResult(device);
			}
		}
	}

	/**
	 * Clears the cache for all devices.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DeviceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the device.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Device device) {
		entityCache.removeResult(DeviceImpl.class, device);
	}

	@Override
	public void clearCache(List<Device> devices) {
		for (Device device : devices) {
			entityCache.removeResult(DeviceImpl.class, device);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DeviceImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(DeviceModelImpl deviceModelImpl) {
		Object[] args = new Object[] {
			deviceModelImpl.getUuid(), deviceModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, deviceModelImpl, false);
	}

	/**
	 * Creates a new device with the primary key. Does not add the device to the database.
	 *
	 * @param deviceId the primary key for the new device
	 * @return the new device
	 */
	@Override
	public Device create(long deviceId) {
		Device device = new DeviceImpl();

		device.setNew(true);
		device.setPrimaryKey(deviceId);

		String uuid = PortalUUIDUtil.generate();

		device.setUuid(uuid);

		device.setCompanyId(CompanyThreadLocal.getCompanyId());

		return device;
	}

	/**
	 * Removes the device with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deviceId the primary key of the device
	 * @return the device that was removed
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	@Override
	public Device remove(long deviceId) throws NoSuchDeviceException {
		return remove((Serializable)deviceId);
	}

	/**
	 * Removes the device with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the device
	 * @return the device that was removed
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	@Override
	public Device remove(Serializable primaryKey) throws NoSuchDeviceException {
		Session session = null;

		try {
			session = openSession();

			Device device = (Device)session.get(DeviceImpl.class, primaryKey);

			if (device == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDeviceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(device);
		}
		catch (NoSuchDeviceException noSuchEntityException) {
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
	protected Device removeImpl(Device device) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(device)) {
				device = (Device)session.get(
					DeviceImpl.class, device.getPrimaryKeyObj());
			}

			if (device != null) {
				session.delete(device);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (device != null) {
			clearCache(device);
		}

		return device;
	}

	@Override
	public Device updateImpl(Device device) {
		boolean isNew = device.isNew();

		if (!(device instanceof DeviceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(device.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(device);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in device proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Device implementation " +
					device.getClass());
		}

		DeviceModelImpl deviceModelImpl = (DeviceModelImpl)device;

		if (Validator.isNull(device.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			device.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(device);
			}
			else {
				device = (Device)session.merge(device);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(DeviceImpl.class, deviceModelImpl, false, true);

		cacheUniqueFindersCache(deviceModelImpl);

		if (isNew) {
			device.setNew(false);
		}

		device.resetOriginalValues();

		return device;
	}

	/**
	 * Returns the device with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the device
	 * @return the device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	@Override
	public Device findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDeviceException {

		Device device = fetchByPrimaryKey(primaryKey);

		if (device == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDeviceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return device;
	}

	/**
	 * Returns the device with the primary key or throws a <code>NoSuchDeviceException</code> if it could not be found.
	 *
	 * @param deviceId the primary key of the device
	 * @return the device
	 * @throws NoSuchDeviceException if a device with the primary key could not be found
	 */
	@Override
	public Device findByPrimaryKey(long deviceId) throws NoSuchDeviceException {
		return findByPrimaryKey((Serializable)deviceId);
	}

	/**
	 * Returns the device with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deviceId the primary key of the device
	 * @return the device, or <code>null</code> if a device with the primary key could not be found
	 */
	@Override
	public Device fetchByPrimaryKey(long deviceId) {
		return fetchByPrimaryKey((Serializable)deviceId);
	}

	/**
	 * Returns all the devices.
	 *
	 * @return the devices
	 */
	@Override
	public List<Device> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the devices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @return the range of devices
	 */
	@Override
	public List<Device> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the devices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of devices
	 */
	@Override
	public List<Device> findAll(
		int start, int end, OrderByComparator<Device> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the devices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeviceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of devices
	 * @param end the upper bound of the range of devices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of devices
	 */
	@Override
	public List<Device> findAll(
		int start, int end, OrderByComparator<Device> orderByComparator,
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

		List<Device> list = null;

		if (useFinderCache) {
			list = (List<Device>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DEVICE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DEVICE;

				sql = sql.concat(DeviceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Device>)QueryUtil.list(
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
	 * Removes all the devices from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Device device : findAll()) {
			remove(device);
		}
	}

	/**
	 * Returns the number of devices.
	 *
	 * @return the number of devices
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DEVICE);

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
		return "deviceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DEVICE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DeviceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the device persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new DeviceModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Device.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

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

		_finderPathWithPaginationFindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "name"}, true);

		_finderPathWithoutPaginationFindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"groupId", "name"}, true);

		_finderPathCountByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"groupId", "name"}, false);

		_finderPathWithPaginationFindByDeviceType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDeviceType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "deviceTypeId"}, true);

		_finderPathWithoutPaginationFindByDeviceType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDeviceType",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "deviceTypeId"}, true);

		_finderPathCountByDeviceType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDeviceType",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "deviceTypeId"}, false);

		_setDeviceUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDeviceUtilPersistence(null);

		entityCache.removeCache(DeviceImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setDeviceUtilPersistence(
		DevicePersistence devicePersistence) {

		try {
			Field field = DeviceUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, devicePersistence);
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

	private static final String _SQL_SELECT_DEVICE =
		"SELECT device FROM Device device";

	private static final String _SQL_SELECT_DEVICE_WHERE =
		"SELECT device FROM Device device WHERE ";

	private static final String _SQL_COUNT_DEVICE =
		"SELECT COUNT(device) FROM Device device";

	private static final String _SQL_COUNT_DEVICE_WHERE =
		"SELECT COUNT(device) FROM Device device WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "device.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Device exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Device exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DevicePersistenceImpl.class);

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

	private static class DeviceModelArgumentsResolver
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

			DeviceModelImpl deviceModelImpl = (DeviceModelImpl)baseModel;

			long columnBitmask = deviceModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(deviceModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= deviceModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(deviceModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			DeviceModelImpl deviceModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = deviceModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = deviceModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}