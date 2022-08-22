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

import com.wz.testtask.estore.exception.NoSuchPurchaseException;
import com.wz.testtask.estore.model.Purchase;
import com.wz.testtask.estore.model.impl.PurchaseImpl;
import com.wz.testtask.estore.model.impl.PurchaseModelImpl;
import com.wz.testtask.estore.service.persistence.PurchasePersistence;
import com.wz.testtask.estore.service.persistence.PurchaseUtil;
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
 * The persistence implementation for the purchase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author wz
 * @generated
 */
@Component(service = PurchasePersistence.class)
public class PurchasePersistenceImpl
	extends BasePersistenceImpl<Purchase> implements PurchasePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PurchaseUtil</code> to access the purchase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PurchaseImpl.class.getName();

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
	 * Returns all the purchases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching purchases
	 */
	@Override
	public List<Purchase> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	@Override
	public List<Purchase> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

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

		List<Purchase> list = null;

		if (useFinderCache) {
			list = (List<Purchase>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Purchase purchase : list) {
					if (!uuid.equals(purchase.getUuid())) {
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

			sb.append(_SQL_SELECT_PURCHASE_WHERE);

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
				sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
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

				list = (List<Purchase>)QueryUtil.list(
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
	 * Returns the first purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByUuid_First(
			String uuid, OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByUuid_First(uuid, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the first purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByUuid_First(
		String uuid, OrderByComparator<Purchase> orderByComparator) {

		List<Purchase> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByUuid_Last(
			String uuid, OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByUuid_Last(uuid, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the last purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByUuid_Last(
		String uuid, OrderByComparator<Purchase> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Purchase> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where uuid = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase[] findByUuid_PrevAndNext(
			long purchaseId, String uuid,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		uuid = Objects.toString(uuid, "");

		Purchase purchase = findByPrimaryKey(purchaseId);

		Session session = null;

		try {
			session = openSession();

			Purchase[] array = new PurchaseImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, purchase, uuid, orderByComparator, true);

			array[1] = purchase;

			array[2] = getByUuid_PrevAndNext(
				session, purchase, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Purchase getByUuid_PrevAndNext(
		Session session, Purchase purchase, String uuid,
		OrderByComparator<Purchase> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PURCHASE_WHERE);

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
			sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(purchase)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Purchase> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the purchases where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Purchase purchase :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(purchase);
		}
	}

	/**
	 * Returns the number of purchases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching purchases
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PURCHASE_WHERE);

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
		"purchase.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(purchase.uuid IS NULL OR purchase.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the purchase where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPurchaseException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByUUID_G(String uuid, long groupId)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByUUID_G(uuid, groupId);

		if (purchase == null) {
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

			throw new NoSuchPurchaseException(sb.toString());
		}

		return purchase;
	}

	/**
	 * Returns the purchase where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the purchase where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByUUID_G(
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

		if (result instanceof Purchase) {
			Purchase purchase = (Purchase)result;

			if (!Objects.equals(uuid, purchase.getUuid()) ||
				(groupId != purchase.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PURCHASE_WHERE);

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

				List<Purchase> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Purchase purchase = list.get(0);

					result = purchase;

					cacheResult(purchase);
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
			return (Purchase)result;
		}
	}

	/**
	 * Removes the purchase where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the purchase that was removed
	 */
	@Override
	public Purchase removeByUUID_G(String uuid, long groupId)
		throws NoSuchPurchaseException {

		Purchase purchase = findByUUID_G(uuid, groupId);

		return remove(purchase);
	}

	/**
	 * Returns the number of purchases where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching purchases
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PURCHASE_WHERE);

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
		"purchase.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(purchase.uuid IS NULL OR purchase.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"purchase.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the purchases where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching purchases
	 */
	@Override
	public List<Purchase> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchases where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	@Override
	public List<Purchase> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchases where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchases where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

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

		List<Purchase> list = null;

		if (useFinderCache) {
			list = (List<Purchase>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Purchase purchase : list) {
					if (!uuid.equals(purchase.getUuid()) ||
						(companyId != purchase.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PURCHASE_WHERE);

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
				sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
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

				list = (List<Purchase>)QueryUtil.list(
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
	 * Returns the first purchase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the first purchase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Purchase> orderByComparator) {

		List<Purchase> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last purchase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the last purchase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Purchase> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Purchase> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase[] findByUuid_C_PrevAndNext(
			long purchaseId, String uuid, long companyId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		uuid = Objects.toString(uuid, "");

		Purchase purchase = findByPrimaryKey(purchaseId);

		Session session = null;

		try {
			session = openSession();

			Purchase[] array = new PurchaseImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, purchase, uuid, companyId, orderByComparator, true);

			array[1] = purchase;

			array[2] = getByUuid_C_PrevAndNext(
				session, purchase, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Purchase getByUuid_C_PrevAndNext(
		Session session, Purchase purchase, String uuid, long companyId,
		OrderByComparator<Purchase> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PURCHASE_WHERE);

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
			sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(purchase)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Purchase> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the purchases where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Purchase purchase :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(purchase);
		}
	}

	/**
	 * Returns the number of purchases where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching purchases
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PURCHASE_WHERE);

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
		"purchase.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(purchase.uuid IS NULL OR purchase.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"purchase.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the purchases where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching purchases
	 */
	@Override
	public List<Purchase> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchases where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	@Override
	public List<Purchase> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

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

		List<Purchase> list = null;

		if (useFinderCache) {
			list = (List<Purchase>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Purchase purchase : list) {
					if (groupId != purchase.getGroupId()) {
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

			sb.append(_SQL_SELECT_PURCHASE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Purchase>)QueryUtil.list(
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
	 * Returns the first purchase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByGroupId_First(
			long groupId, OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByGroupId_First(groupId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByGroupId_First(
		long groupId, OrderByComparator<Purchase> orderByComparator) {

		List<Purchase> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByGroupId_Last(
			long groupId, OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByGroupId_Last(groupId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByGroupId_Last(
		long groupId, OrderByComparator<Purchase> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Purchase> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where groupId = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase[] findByGroupId_PrevAndNext(
			long purchaseId, long groupId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = findByPrimaryKey(purchaseId);

		Session session = null;

		try {
			session = openSession();

			Purchase[] array = new PurchaseImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, purchase, groupId, orderByComparator, true);

			array[1] = purchase;

			array[2] = getByGroupId_PrevAndNext(
				session, purchase, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Purchase getByGroupId_PrevAndNext(
		Session session, Purchase purchase, long groupId,
		OrderByComparator<Purchase> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PURCHASE_WHERE);

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
			sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(purchase)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Purchase> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the purchases where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Purchase purchase :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(purchase);
		}
	}

	/**
	 * Returns the number of purchases where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching purchases
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PURCHASE_WHERE);

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
		"purchase.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupIdEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByGroupIdEmployeeId;
	private FinderPath _finderPathCountByGroupIdEmployeeId;

	/**
	 * Returns all the purchases where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @return the matching purchases
	 */
	@Override
	public List<Purchase> findByGroupIdEmployeeId(
		long groupId, long employeeId) {

		return findByGroupIdEmployeeId(
			groupId, employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchases where groupId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	@Override
	public List<Purchase> findByGroupIdEmployeeId(
		long groupId, long employeeId, int start, int end) {

		return findByGroupIdEmployeeId(groupId, employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByGroupIdEmployeeId(
		long groupId, long employeeId, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return findByGroupIdEmployeeId(
			groupId, employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByGroupIdEmployeeId(
		long groupId, long employeeId, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroupIdEmployeeId;
				finderArgs = new Object[] {groupId, employeeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupIdEmployeeId;
			finderArgs = new Object[] {
				groupId, employeeId, start, end, orderByComparator
			};
		}

		List<Purchase> list = null;

		if (useFinderCache) {
			list = (List<Purchase>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Purchase purchase : list) {
					if ((groupId != purchase.getGroupId()) ||
						(employeeId != purchase.getEmployeeId())) {

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

			sb.append(_SQL_SELECT_PURCHASE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(employeeId);

				list = (List<Purchase>)QueryUtil.list(
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
	 * Returns the first purchase in the ordered set where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByGroupIdEmployeeId_First(
			long groupId, long employeeId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByGroupIdEmployeeId_First(
			groupId, employeeId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByGroupIdEmployeeId_First(
		long groupId, long employeeId,
		OrderByComparator<Purchase> orderByComparator) {

		List<Purchase> list = findByGroupIdEmployeeId(
			groupId, employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByGroupIdEmployeeId_Last(
			long groupId, long employeeId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByGroupIdEmployeeId_Last(
			groupId, employeeId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByGroupIdEmployeeId_Last(
		long groupId, long employeeId,
		OrderByComparator<Purchase> orderByComparator) {

		int count = countByGroupIdEmployeeId(groupId, employeeId);

		if (count == 0) {
			return null;
		}

		List<Purchase> list = findByGroupIdEmployeeId(
			groupId, employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase[] findByGroupIdEmployeeId_PrevAndNext(
			long purchaseId, long groupId, long employeeId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = findByPrimaryKey(purchaseId);

		Session session = null;

		try {
			session = openSession();

			Purchase[] array = new PurchaseImpl[3];

			array[0] = getByGroupIdEmployeeId_PrevAndNext(
				session, purchase, groupId, employeeId, orderByComparator,
				true);

			array[1] = purchase;

			array[2] = getByGroupIdEmployeeId_PrevAndNext(
				session, purchase, groupId, employeeId, orderByComparator,
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

	protected Purchase getByGroupIdEmployeeId_PrevAndNext(
		Session session, Purchase purchase, long groupId, long employeeId,
		OrderByComparator<Purchase> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PURCHASE_WHERE);

		sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEID_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEID_EMPLOYEEID_2);

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
			sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(employeeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(purchase)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Purchase> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the purchases where groupId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByGroupIdEmployeeId(long groupId, long employeeId) {
		for (Purchase purchase :
				findByGroupIdEmployeeId(
					groupId, employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(purchase);
		}
	}

	/**
	 * Returns the number of purchases where groupId = &#63; and employeeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @return the number of matching purchases
	 */
	@Override
	public int countByGroupIdEmployeeId(long groupId, long employeeId) {
		FinderPath finderPath = _finderPathCountByGroupIdEmployeeId;

		Object[] finderArgs = new Object[] {groupId, employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PURCHASE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(employeeId);

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

	private static final String _FINDER_COLUMN_GROUPIDEMPLOYEEID_GROUPID_2 =
		"purchase.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPIDEMPLOYEEID_EMPLOYEEID_2 =
		"purchase.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupIdDeviceId;
	private FinderPath _finderPathWithoutPaginationFindByGroupIdDeviceId;
	private FinderPath _finderPathCountByGroupIdDeviceId;

	/**
	 * Returns all the purchases where groupId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @return the matching purchases
	 */
	@Override
	public List<Purchase> findByGroupIdDeviceId(long groupId, long deviceId) {
		return findByGroupIdDeviceId(
			groupId, deviceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchases where groupId = &#63; and deviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	@Override
	public List<Purchase> findByGroupIdDeviceId(
		long groupId, long deviceId, int start, int end) {

		return findByGroupIdDeviceId(groupId, deviceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63; and deviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByGroupIdDeviceId(
		long groupId, long deviceId, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return findByGroupIdDeviceId(
			groupId, deviceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63; and deviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByGroupIdDeviceId(
		long groupId, long deviceId, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupIdDeviceId;
				finderArgs = new Object[] {groupId, deviceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupIdDeviceId;
			finderArgs = new Object[] {
				groupId, deviceId, start, end, orderByComparator
			};
		}

		List<Purchase> list = null;

		if (useFinderCache) {
			list = (List<Purchase>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Purchase purchase : list) {
					if ((groupId != purchase.getGroupId()) ||
						(deviceId != purchase.getDeviceId())) {

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

			sb.append(_SQL_SELECT_PURCHASE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDDEVICEID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDDEVICEID_DEVICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(deviceId);

				list = (List<Purchase>)QueryUtil.list(
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
	 * Returns the first purchase in the ordered set where groupId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByGroupIdDeviceId_First(
			long groupId, long deviceId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByGroupIdDeviceId_First(
			groupId, deviceId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", deviceId=");
		sb.append(deviceId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByGroupIdDeviceId_First(
		long groupId, long deviceId,
		OrderByComparator<Purchase> orderByComparator) {

		List<Purchase> list = findByGroupIdDeviceId(
			groupId, deviceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByGroupIdDeviceId_Last(
			long groupId, long deviceId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByGroupIdDeviceId_Last(
			groupId, deviceId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", deviceId=");
		sb.append(deviceId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByGroupIdDeviceId_Last(
		long groupId, long deviceId,
		OrderByComparator<Purchase> orderByComparator) {

		int count = countByGroupIdDeviceId(groupId, deviceId);

		if (count == 0) {
			return null;
		}

		List<Purchase> list = findByGroupIdDeviceId(
			groupId, deviceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where groupId = &#63; and deviceId = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase[] findByGroupIdDeviceId_PrevAndNext(
			long purchaseId, long groupId, long deviceId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = findByPrimaryKey(purchaseId);

		Session session = null;

		try {
			session = openSession();

			Purchase[] array = new PurchaseImpl[3];

			array[0] = getByGroupIdDeviceId_PrevAndNext(
				session, purchase, groupId, deviceId, orderByComparator, true);

			array[1] = purchase;

			array[2] = getByGroupIdDeviceId_PrevAndNext(
				session, purchase, groupId, deviceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Purchase getByGroupIdDeviceId_PrevAndNext(
		Session session, Purchase purchase, long groupId, long deviceId,
		OrderByComparator<Purchase> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PURCHASE_WHERE);

		sb.append(_FINDER_COLUMN_GROUPIDDEVICEID_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUPIDDEVICEID_DEVICEID_2);

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
			sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(deviceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(purchase)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Purchase> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the purchases where groupId = &#63; and deviceId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 */
	@Override
	public void removeByGroupIdDeviceId(long groupId, long deviceId) {
		for (Purchase purchase :
				findByGroupIdDeviceId(
					groupId, deviceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(purchase);
		}
	}

	/**
	 * Returns the number of purchases where groupId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deviceId the device ID
	 * @return the number of matching purchases
	 */
	@Override
	public int countByGroupIdDeviceId(long groupId, long deviceId) {
		FinderPath finderPath = _finderPathCountByGroupIdDeviceId;

		Object[] finderArgs = new Object[] {groupId, deviceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PURCHASE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDDEVICEID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDDEVICEID_DEVICEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(deviceId);

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

	private static final String _FINDER_COLUMN_GROUPIDDEVICEID_GROUPID_2 =
		"purchase.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPIDDEVICEID_DEVICEID_2 =
		"purchase.deviceId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupIdEmployeeIdDeviceId;
	private FinderPath
		_finderPathWithoutPaginationFindByGroupIdEmployeeIdDeviceId;
	private FinderPath _finderPathCountByGroupIdEmployeeIdDeviceId;

	/**
	 * Returns all the purchases where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @return the matching purchases
	 */
	@Override
	public List<Purchase> findByGroupIdEmployeeIdDeviceId(
		long groupId, long employeeId, long deviceId) {

		return findByGroupIdEmployeeIdDeviceId(
			groupId, employeeId, deviceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the purchases where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	@Override
	public List<Purchase> findByGroupIdEmployeeIdDeviceId(
		long groupId, long employeeId, long deviceId, int start, int end) {

		return findByGroupIdEmployeeIdDeviceId(
			groupId, employeeId, deviceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByGroupIdEmployeeIdDeviceId(
		long groupId, long employeeId, long deviceId, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return findByGroupIdEmployeeIdDeviceId(
			groupId, employeeId, deviceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchases where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByGroupIdEmployeeIdDeviceId(
		long groupId, long employeeId, long deviceId, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroupIdEmployeeIdDeviceId;
				finderArgs = new Object[] {groupId, employeeId, deviceId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGroupIdEmployeeIdDeviceId;
			finderArgs = new Object[] {
				groupId, employeeId, deviceId, start, end, orderByComparator
			};
		}

		List<Purchase> list = null;

		if (useFinderCache) {
			list = (List<Purchase>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Purchase purchase : list) {
					if ((groupId != purchase.getGroupId()) ||
						(employeeId != purchase.getEmployeeId()) ||
						(deviceId != purchase.getDeviceId())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_PURCHASE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEIDDEVICEID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEIDDEVICEID_EMPLOYEEID_2);

			sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEIDDEVICEID_DEVICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(employeeId);

				queryPos.add(deviceId);

				list = (List<Purchase>)QueryUtil.list(
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
	 * Returns the first purchase in the ordered set where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByGroupIdEmployeeIdDeviceId_First(
			long groupId, long employeeId, long deviceId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByGroupIdEmployeeIdDeviceId_First(
			groupId, employeeId, deviceId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", employeeId=");
		sb.append(employeeId);

		sb.append(", deviceId=");
		sb.append(deviceId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the first purchase in the ordered set where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByGroupIdEmployeeIdDeviceId_First(
		long groupId, long employeeId, long deviceId,
		OrderByComparator<Purchase> orderByComparator) {

		List<Purchase> list = findByGroupIdEmployeeIdDeviceId(
			groupId, employeeId, deviceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByGroupIdEmployeeIdDeviceId_Last(
			long groupId, long employeeId, long deviceId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByGroupIdEmployeeIdDeviceId_Last(
			groupId, employeeId, deviceId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", employeeId=");
		sb.append(employeeId);

		sb.append(", deviceId=");
		sb.append(deviceId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the last purchase in the ordered set where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByGroupIdEmployeeIdDeviceId_Last(
		long groupId, long employeeId, long deviceId,
		OrderByComparator<Purchase> orderByComparator) {

		int count = countByGroupIdEmployeeIdDeviceId(
			groupId, employeeId, deviceId);

		if (count == 0) {
			return null;
		}

		List<Purchase> list = findByGroupIdEmployeeIdDeviceId(
			groupId, employeeId, deviceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase[] findByGroupIdEmployeeIdDeviceId_PrevAndNext(
			long purchaseId, long groupId, long employeeId, long deviceId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = findByPrimaryKey(purchaseId);

		Session session = null;

		try {
			session = openSession();

			Purchase[] array = new PurchaseImpl[3];

			array[0] = getByGroupIdEmployeeIdDeviceId_PrevAndNext(
				session, purchase, groupId, employeeId, deviceId,
				orderByComparator, true);

			array[1] = purchase;

			array[2] = getByGroupIdEmployeeIdDeviceId_PrevAndNext(
				session, purchase, groupId, employeeId, deviceId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Purchase getByGroupIdEmployeeIdDeviceId_PrevAndNext(
		Session session, Purchase purchase, long groupId, long employeeId,
		long deviceId, OrderByComparator<Purchase> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_PURCHASE_WHERE);

		sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEIDDEVICEID_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEIDDEVICEID_EMPLOYEEID_2);

		sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEIDDEVICEID_DEVICEID_2);

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
			sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(employeeId);

		queryPos.add(deviceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(purchase)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Purchase> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the purchases where groupId = &#63; and employeeId = &#63; and deviceId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 */
	@Override
	public void removeByGroupIdEmployeeIdDeviceId(
		long groupId, long employeeId, long deviceId) {

		for (Purchase purchase :
				findByGroupIdEmployeeIdDeviceId(
					groupId, employeeId, deviceId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(purchase);
		}
	}

	/**
	 * Returns the number of purchases where groupId = &#63; and employeeId = &#63; and deviceId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeId the employee ID
	 * @param deviceId the device ID
	 * @return the number of matching purchases
	 */
	@Override
	public int countByGroupIdEmployeeIdDeviceId(
		long groupId, long employeeId, long deviceId) {

		FinderPath finderPath = _finderPathCountByGroupIdEmployeeIdDeviceId;

		Object[] finderArgs = new Object[] {groupId, employeeId, deviceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PURCHASE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEIDDEVICEID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEIDDEVICEID_EMPLOYEEID_2);

			sb.append(_FINDER_COLUMN_GROUPIDEMPLOYEEIDDEVICEID_DEVICEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(employeeId);

				queryPos.add(deviceId);

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

	private static final String
		_FINDER_COLUMN_GROUPIDEMPLOYEEIDDEVICEID_GROUPID_2 =
			"purchase.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPIDEMPLOYEEIDDEVICEID_EMPLOYEEID_2 =
			"purchase.employeeId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPIDEMPLOYEEIDDEVICEID_DEVICEID_2 =
			"purchase.deviceId = ?";

	public PurchasePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Purchase.class);

		setModelImplClass(PurchaseImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the purchase in the entity cache if it is enabled.
	 *
	 * @param purchase the purchase
	 */
	@Override
	public void cacheResult(Purchase purchase) {
		entityCache.putResult(
			PurchaseImpl.class, purchase.getPrimaryKey(), purchase);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {purchase.getUuid(), purchase.getGroupId()}, purchase);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the purchases in the entity cache if it is enabled.
	 *
	 * @param purchases the purchases
	 */
	@Override
	public void cacheResult(List<Purchase> purchases) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (purchases.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Purchase purchase : purchases) {
			if (entityCache.getResult(
					PurchaseImpl.class, purchase.getPrimaryKey()) == null) {

				cacheResult(purchase);
			}
		}
	}

	/**
	 * Clears the cache for all purchases.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PurchaseImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the purchase.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Purchase purchase) {
		entityCache.removeResult(PurchaseImpl.class, purchase);
	}

	@Override
	public void clearCache(List<Purchase> purchases) {
		for (Purchase purchase : purchases) {
			entityCache.removeResult(PurchaseImpl.class, purchase);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PurchaseImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PurchaseModelImpl purchaseModelImpl) {

		Object[] args = new Object[] {
			purchaseModelImpl.getUuid(), purchaseModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, purchaseModelImpl, false);
	}

	/**
	 * Creates a new purchase with the primary key. Does not add the purchase to the database.
	 *
	 * @param purchaseId the primary key for the new purchase
	 * @return the new purchase
	 */
	@Override
	public Purchase create(long purchaseId) {
		Purchase purchase = new PurchaseImpl();

		purchase.setNew(true);
		purchase.setPrimaryKey(purchaseId);

		String uuid = PortalUUIDUtil.generate();

		purchase.setUuid(uuid);

		purchase.setCompanyId(CompanyThreadLocal.getCompanyId());

		return purchase;
	}

	/**
	 * Removes the purchase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase that was removed
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase remove(long purchaseId) throws NoSuchPurchaseException {
		return remove((Serializable)purchaseId);
	}

	/**
	 * Removes the purchase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the purchase
	 * @return the purchase that was removed
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase remove(Serializable primaryKey)
		throws NoSuchPurchaseException {

		Session session = null;

		try {
			session = openSession();

			Purchase purchase = (Purchase)session.get(
				PurchaseImpl.class, primaryKey);

			if (purchase == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPurchaseException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(purchase);
		}
		catch (NoSuchPurchaseException noSuchEntityException) {
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
	protected Purchase removeImpl(Purchase purchase) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(purchase)) {
				purchase = (Purchase)session.get(
					PurchaseImpl.class, purchase.getPrimaryKeyObj());
			}

			if (purchase != null) {
				session.delete(purchase);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (purchase != null) {
			clearCache(purchase);
		}

		return purchase;
	}

	@Override
	public Purchase updateImpl(Purchase purchase) {
		boolean isNew = purchase.isNew();

		if (!(purchase instanceof PurchaseModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(purchase.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(purchase);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in purchase proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Purchase implementation " +
					purchase.getClass());
		}

		PurchaseModelImpl purchaseModelImpl = (PurchaseModelImpl)purchase;

		if (Validator.isNull(purchase.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			purchase.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(purchase);
			}
			else {
				purchase = (Purchase)session.merge(purchase);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PurchaseImpl.class, purchaseModelImpl, false, true);

		cacheUniqueFindersCache(purchaseModelImpl);

		if (isNew) {
			purchase.setNew(false);
		}

		purchase.resetOriginalValues();

		return purchase;
	}

	/**
	 * Returns the purchase with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the purchase
	 * @return the purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByPrimaryKey(primaryKey);

		if (purchase == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPurchaseException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return purchase;
	}

	/**
	 * Returns the purchase with the primary key or throws a <code>NoSuchPurchaseException</code> if it could not be found.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase findByPrimaryKey(long purchaseId)
		throws NoSuchPurchaseException {

		return findByPrimaryKey((Serializable)purchaseId);
	}

	/**
	 * Returns the purchase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase, or <code>null</code> if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase fetchByPrimaryKey(long purchaseId) {
		return fetchByPrimaryKey((Serializable)purchaseId);
	}

	/**
	 * Returns all the purchases.
	 *
	 * @return the purchases
	 */
	@Override
	public List<Purchase> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of purchases
	 */
	@Override
	public List<Purchase> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of purchases
	 */
	@Override
	public List<Purchase> findAll(
		int start, int end, OrderByComparator<Purchase> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of purchases
	 */
	@Override
	public List<Purchase> findAll(
		int start, int end, OrderByComparator<Purchase> orderByComparator,
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

		List<Purchase> list = null;

		if (useFinderCache) {
			list = (List<Purchase>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PURCHASE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PURCHASE;

				sql = sql.concat(PurchaseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Purchase>)QueryUtil.list(
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
	 * Removes all the purchases from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Purchase purchase : findAll()) {
			remove(purchase);
		}
	}

	/**
	 * Returns the number of purchases.
	 *
	 * @return the number of purchases
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PURCHASE);

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
		return "purchaseId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PURCHASE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PurchaseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the purchase persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PurchaseModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Purchase.class.getName()));

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

		_finderPathWithPaginationFindByGroupIdEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdEmployeeId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "employeeId"}, true);

		_finderPathWithoutPaginationFindByGroupIdEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdEmployeeId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "employeeId"}, true);

		_finderPathCountByGroupIdEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdEmployeeId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "employeeId"}, false);

		_finderPathWithPaginationFindByGroupIdDeviceId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdDeviceId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "deviceId"}, true);

		_finderPathWithoutPaginationFindByGroupIdDeviceId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupIdDeviceId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "deviceId"}, true);

		_finderPathCountByGroupIdDeviceId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupIdDeviceId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "deviceId"}, false);

		_finderPathWithPaginationFindByGroupIdEmployeeIdDeviceId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGroupIdEmployeeIdDeviceId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"groupId", "employeeId", "deviceId"}, true);

		_finderPathWithoutPaginationFindByGroupIdEmployeeIdDeviceId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroupIdEmployeeIdDeviceId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {"groupId", "employeeId", "deviceId"}, true);

		_finderPathCountByGroupIdEmployeeIdDeviceId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdEmployeeIdDeviceId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"groupId", "employeeId", "deviceId"}, false);

		_setPurchaseUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPurchaseUtilPersistence(null);

		entityCache.removeCache(PurchaseImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPurchaseUtilPersistence(
		PurchasePersistence purchasePersistence) {

		try {
			Field field = PurchaseUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, purchasePersistence);
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

	private static final String _SQL_SELECT_PURCHASE =
		"SELECT purchase FROM Purchase purchase";

	private static final String _SQL_SELECT_PURCHASE_WHERE =
		"SELECT purchase FROM Purchase purchase WHERE ";

	private static final String _SQL_COUNT_PURCHASE =
		"SELECT COUNT(purchase) FROM Purchase purchase";

	private static final String _SQL_COUNT_PURCHASE_WHERE =
		"SELECT COUNT(purchase) FROM Purchase purchase WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "purchase.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Purchase exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Purchase exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PurchasePersistenceImpl.class);

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

	private static class PurchaseModelArgumentsResolver
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

			PurchaseModelImpl purchaseModelImpl = (PurchaseModelImpl)baseModel;

			long columnBitmask = purchaseModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(purchaseModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						purchaseModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(purchaseModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PurchaseModelImpl purchaseModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = purchaseModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = purchaseModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}