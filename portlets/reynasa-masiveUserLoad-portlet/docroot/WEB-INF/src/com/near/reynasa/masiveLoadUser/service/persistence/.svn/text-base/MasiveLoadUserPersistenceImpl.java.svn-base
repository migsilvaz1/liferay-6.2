/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.near.reynasa.masiveLoadUser.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException;
import com.near.reynasa.masiveLoadUser.model.MasiveLoadUser;
import com.near.reynasa.masiveLoadUser.model.impl.MasiveLoadUserImpl;
import com.near.reynasa.masiveLoadUser.model.impl.MasiveLoadUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the masive load user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author near
 * @see MasiveLoadUserPersistence
 * @see MasiveLoadUserUtil
 * @generated
 */
public class MasiveLoadUserPersistenceImpl extends BasePersistenceImpl<MasiveLoadUser>
	implements MasiveLoadUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MasiveLoadUserUtil} to access the masive load user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MasiveLoadUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MasiveLoadUserModelImpl.ENTITY_CACHE_ENABLED,
			MasiveLoadUserModelImpl.FINDER_CACHE_ENABLED,
			MasiveLoadUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MasiveLoadUserModelImpl.ENTITY_CACHE_ENABLED,
			MasiveLoadUserModelImpl.FINDER_CACHE_ENABLED,
			MasiveLoadUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MasiveLoadUserModelImpl.ENTITY_CACHE_ENABLED,
			MasiveLoadUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDCOMPANYID =
		new FinderPath(MasiveLoadUserModelImpl.ENTITY_CACHE_ENABLED,
			MasiveLoadUserModelImpl.FINDER_CACHE_ENABLED,
			MasiveLoadUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBygroupIdAndCompanyId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPANYID =
		new FinderPath(MasiveLoadUserModelImpl.ENTITY_CACHE_ENABLED,
			MasiveLoadUserModelImpl.FINDER_CACHE_ENABLED,
			MasiveLoadUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBygroupIdAndCompanyId",
			new String[] { Long.class.getName(), Long.class.getName() },
			MasiveLoadUserModelImpl.GROUPID_COLUMN_BITMASK |
			MasiveLoadUserModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDCOMPANYID = new FinderPath(MasiveLoadUserModelImpl.ENTITY_CACHE_ENABLED,
			MasiveLoadUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygroupIdAndCompanyId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the masive load users where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching masive load users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasiveLoadUser> findBygroupIdAndCompanyId(long groupId,
		long companyId) throws SystemException {
		return findBygroupIdAndCompanyId(groupId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the masive load users where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.near.reynasa.masiveLoadUser.model.impl.MasiveLoadUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of masive load users
	 * @param end the upper bound of the range of masive load users (not inclusive)
	 * @return the range of matching masive load users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasiveLoadUser> findBygroupIdAndCompanyId(long groupId,
		long companyId, int start, int end) throws SystemException {
		return findBygroupIdAndCompanyId(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the masive load users where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.near.reynasa.masiveLoadUser.model.impl.MasiveLoadUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of masive load users
	 * @param end the upper bound of the range of masive load users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching masive load users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasiveLoadUser> findBygroupIdAndCompanyId(long groupId,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPANYID;
			finderArgs = new Object[] { groupId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDCOMPANYID;
			finderArgs = new Object[] {
					groupId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<MasiveLoadUser> list = (List<MasiveLoadUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MasiveLoadUser masiveLoadUser : list) {
				if ((groupId != masiveLoadUser.getGroupId()) ||
						(companyId != masiveLoadUser.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_MASIVELOADUSER_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDCOMPANYID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDCOMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MasiveLoadUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<MasiveLoadUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasiveLoadUser>(list);
				}
				else {
					list = (List<MasiveLoadUser>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first masive load user in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching masive load user
	 * @throws com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException if a matching masive load user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasiveLoadUser findBygroupIdAndCompanyId_First(long groupId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchMasiveLoadUserException, SystemException {
		MasiveLoadUser masiveLoadUser = fetchBygroupIdAndCompanyId_First(groupId,
				companyId, orderByComparator);

		if (masiveLoadUser != null) {
			return masiveLoadUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasiveLoadUserException(msg.toString());
	}

	/**
	 * Returns the first masive load user in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching masive load user, or <code>null</code> if a matching masive load user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasiveLoadUser fetchBygroupIdAndCompanyId_First(long groupId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MasiveLoadUser> list = findBygroupIdAndCompanyId(groupId,
				companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last masive load user in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching masive load user
	 * @throws com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException if a matching masive load user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasiveLoadUser findBygroupIdAndCompanyId_Last(long groupId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchMasiveLoadUserException, SystemException {
		MasiveLoadUser masiveLoadUser = fetchBygroupIdAndCompanyId_Last(groupId,
				companyId, orderByComparator);

		if (masiveLoadUser != null) {
			return masiveLoadUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasiveLoadUserException(msg.toString());
	}

	/**
	 * Returns the last masive load user in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching masive load user, or <code>null</code> if a matching masive load user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasiveLoadUser fetchBygroupIdAndCompanyId_Last(long groupId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBygroupIdAndCompanyId(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<MasiveLoadUser> list = findBygroupIdAndCompanyId(groupId,
				companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the masive load users before and after the current masive load user in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current masive load user
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next masive load user
	 * @throws com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException if a masive load user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasiveLoadUser[] findBygroupIdAndCompanyId_PrevAndNext(long id,
		long groupId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchMasiveLoadUserException, SystemException {
		MasiveLoadUser masiveLoadUser = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			MasiveLoadUser[] array = new MasiveLoadUserImpl[3];

			array[0] = getBygroupIdAndCompanyId_PrevAndNext(session,
					masiveLoadUser, groupId, companyId, orderByComparator, true);

			array[1] = masiveLoadUser;

			array[2] = getBygroupIdAndCompanyId_PrevAndNext(session,
					masiveLoadUser, groupId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasiveLoadUser getBygroupIdAndCompanyId_PrevAndNext(
		Session session, MasiveLoadUser masiveLoadUser, long groupId,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MASIVELOADUSER_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDANDCOMPANYID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPIDANDCOMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MasiveLoadUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(masiveLoadUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MasiveLoadUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the masive load users where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBygroupIdAndCompanyId(long groupId, long companyId)
		throws SystemException {
		for (MasiveLoadUser masiveLoadUser : findBygroupIdAndCompanyId(
				groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(masiveLoadUser);
		}
	}

	/**
	 * Returns the number of masive load users where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching masive load users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBygroupIdAndCompanyId(long groupId, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDANDCOMPANYID;

		Object[] finderArgs = new Object[] { groupId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MASIVELOADUSER_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDCOMPANYID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDCOMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPIDANDCOMPANYID_GROUPID_2 = "masiveLoadUser.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDCOMPANYID_COMPANYID_2 = "masiveLoadUser.companyId = ?";

	public MasiveLoadUserPersistenceImpl() {
		setModelClass(MasiveLoadUser.class);
	}

	/**
	 * Caches the masive load user in the entity cache if it is enabled.
	 *
	 * @param masiveLoadUser the masive load user
	 */
	@Override
	public void cacheResult(MasiveLoadUser masiveLoadUser) {
		EntityCacheUtil.putResult(MasiveLoadUserModelImpl.ENTITY_CACHE_ENABLED,
			MasiveLoadUserImpl.class, masiveLoadUser.getPrimaryKey(),
			masiveLoadUser);

		masiveLoadUser.resetOriginalValues();
	}

	/**
	 * Caches the masive load users in the entity cache if it is enabled.
	 *
	 * @param masiveLoadUsers the masive load users
	 */
	@Override
	public void cacheResult(List<MasiveLoadUser> masiveLoadUsers) {
		for (MasiveLoadUser masiveLoadUser : masiveLoadUsers) {
			if (EntityCacheUtil.getResult(
						MasiveLoadUserModelImpl.ENTITY_CACHE_ENABLED,
						MasiveLoadUserImpl.class, masiveLoadUser.getPrimaryKey()) == null) {
				cacheResult(masiveLoadUser);
			}
			else {
				masiveLoadUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all masive load users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MasiveLoadUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MasiveLoadUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the masive load user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasiveLoadUser masiveLoadUser) {
		EntityCacheUtil.removeResult(MasiveLoadUserModelImpl.ENTITY_CACHE_ENABLED,
			MasiveLoadUserImpl.class, masiveLoadUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MasiveLoadUser> masiveLoadUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MasiveLoadUser masiveLoadUser : masiveLoadUsers) {
			EntityCacheUtil.removeResult(MasiveLoadUserModelImpl.ENTITY_CACHE_ENABLED,
				MasiveLoadUserImpl.class, masiveLoadUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new masive load user with the primary key. Does not add the masive load user to the database.
	 *
	 * @param id the primary key for the new masive load user
	 * @return the new masive load user
	 */
	@Override
	public MasiveLoadUser create(long id) {
		MasiveLoadUser masiveLoadUser = new MasiveLoadUserImpl();

		masiveLoadUser.setNew(true);
		masiveLoadUser.setPrimaryKey(id);

		return masiveLoadUser;
	}

	/**
	 * Removes the masive load user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the masive load user
	 * @return the masive load user that was removed
	 * @throws com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException if a masive load user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasiveLoadUser remove(long id)
		throws NoSuchMasiveLoadUserException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the masive load user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the masive load user
	 * @return the masive load user that was removed
	 * @throws com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException if a masive load user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasiveLoadUser remove(Serializable primaryKey)
		throws NoSuchMasiveLoadUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MasiveLoadUser masiveLoadUser = (MasiveLoadUser)session.get(MasiveLoadUserImpl.class,
					primaryKey);

			if (masiveLoadUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasiveLoadUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(masiveLoadUser);
		}
		catch (NoSuchMasiveLoadUserException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected MasiveLoadUser removeImpl(MasiveLoadUser masiveLoadUser)
		throws SystemException {
		masiveLoadUser = toUnwrappedModel(masiveLoadUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masiveLoadUser)) {
				masiveLoadUser = (MasiveLoadUser)session.get(MasiveLoadUserImpl.class,
						masiveLoadUser.getPrimaryKeyObj());
			}

			if (masiveLoadUser != null) {
				session.delete(masiveLoadUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (masiveLoadUser != null) {
			clearCache(masiveLoadUser);
		}

		return masiveLoadUser;
	}

	@Override
	public MasiveLoadUser updateImpl(
		com.near.reynasa.masiveLoadUser.model.MasiveLoadUser masiveLoadUser)
		throws SystemException {
		masiveLoadUser = toUnwrappedModel(masiveLoadUser);

		boolean isNew = masiveLoadUser.isNew();

		MasiveLoadUserModelImpl masiveLoadUserModelImpl = (MasiveLoadUserModelImpl)masiveLoadUser;

		Session session = null;

		try {
			session = openSession();

			if (masiveLoadUser.isNew()) {
				session.save(masiveLoadUser);

				masiveLoadUser.setNew(false);
			}
			else {
				session.merge(masiveLoadUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MasiveLoadUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((masiveLoadUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						masiveLoadUserModelImpl.getOriginalGroupId(),
						masiveLoadUserModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDCOMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPANYID,
					args);

				args = new Object[] {
						masiveLoadUserModelImpl.getGroupId(),
						masiveLoadUserModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDCOMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(MasiveLoadUserModelImpl.ENTITY_CACHE_ENABLED,
			MasiveLoadUserImpl.class, masiveLoadUser.getPrimaryKey(),
			masiveLoadUser);

		return masiveLoadUser;
	}

	protected MasiveLoadUser toUnwrappedModel(MasiveLoadUser masiveLoadUser) {
		if (masiveLoadUser instanceof MasiveLoadUserImpl) {
			return masiveLoadUser;
		}

		MasiveLoadUserImpl masiveLoadUserImpl = new MasiveLoadUserImpl();

		masiveLoadUserImpl.setNew(masiveLoadUser.isNew());
		masiveLoadUserImpl.setPrimaryKey(masiveLoadUser.getPrimaryKey());

		masiveLoadUserImpl.setId(masiveLoadUser.getId());
		masiveLoadUserImpl.setGroupId(masiveLoadUser.getGroupId());
		masiveLoadUserImpl.setCompanyId(masiveLoadUser.getCompanyId());
		masiveLoadUserImpl.setUserId(masiveLoadUser.getUserId());
		masiveLoadUserImpl.setUserName(masiveLoadUser.getUserName());
		masiveLoadUserImpl.setCreateDate(masiveLoadUser.getCreateDate());
		masiveLoadUserImpl.setSuccessFile(masiveLoadUser.getSuccessFile());
		masiveLoadUserImpl.setErrorFile(masiveLoadUser.getErrorFile());
		masiveLoadUserImpl.setStatusExecution(masiveLoadUser.getStatusExecution());

		return masiveLoadUserImpl;
	}

	/**
	 * Returns the masive load user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the masive load user
	 * @return the masive load user
	 * @throws com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException if a masive load user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasiveLoadUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasiveLoadUserException, SystemException {
		MasiveLoadUser masiveLoadUser = fetchByPrimaryKey(primaryKey);

		if (masiveLoadUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasiveLoadUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return masiveLoadUser;
	}

	/**
	 * Returns the masive load user with the primary key or throws a {@link com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException} if it could not be found.
	 *
	 * @param id the primary key of the masive load user
	 * @return the masive load user
	 * @throws com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException if a masive load user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasiveLoadUser findByPrimaryKey(long id)
		throws NoSuchMasiveLoadUserException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the masive load user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the masive load user
	 * @return the masive load user, or <code>null</code> if a masive load user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasiveLoadUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MasiveLoadUser masiveLoadUser = (MasiveLoadUser)EntityCacheUtil.getResult(MasiveLoadUserModelImpl.ENTITY_CACHE_ENABLED,
				MasiveLoadUserImpl.class, primaryKey);

		if (masiveLoadUser == _nullMasiveLoadUser) {
			return null;
		}

		if (masiveLoadUser == null) {
			Session session = null;

			try {
				session = openSession();

				masiveLoadUser = (MasiveLoadUser)session.get(MasiveLoadUserImpl.class,
						primaryKey);

				if (masiveLoadUser != null) {
					cacheResult(masiveLoadUser);
				}
				else {
					EntityCacheUtil.putResult(MasiveLoadUserModelImpl.ENTITY_CACHE_ENABLED,
						MasiveLoadUserImpl.class, primaryKey,
						_nullMasiveLoadUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MasiveLoadUserModelImpl.ENTITY_CACHE_ENABLED,
					MasiveLoadUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return masiveLoadUser;
	}

	/**
	 * Returns the masive load user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the masive load user
	 * @return the masive load user, or <code>null</code> if a masive load user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasiveLoadUser fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the masive load users.
	 *
	 * @return the masive load users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasiveLoadUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the masive load users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.near.reynasa.masiveLoadUser.model.impl.MasiveLoadUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of masive load users
	 * @param end the upper bound of the range of masive load users (not inclusive)
	 * @return the range of masive load users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasiveLoadUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the masive load users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.near.reynasa.masiveLoadUser.model.impl.MasiveLoadUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of masive load users
	 * @param end the upper bound of the range of masive load users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of masive load users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasiveLoadUser> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<MasiveLoadUser> list = (List<MasiveLoadUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MASIVELOADUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MASIVELOADUSER;

				if (pagination) {
					sql = sql.concat(MasiveLoadUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MasiveLoadUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasiveLoadUser>(list);
				}
				else {
					list = (List<MasiveLoadUser>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the masive load users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MasiveLoadUser masiveLoadUser : findAll()) {
			remove(masiveLoadUser);
		}
	}

	/**
	 * Returns the number of masive load users.
	 *
	 * @return the number of masive load users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MASIVELOADUSER);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the masive load user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.near.reynasa.masiveLoadUser.model.MasiveLoadUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MasiveLoadUser>> listenersList = new ArrayList<ModelListener<MasiveLoadUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MasiveLoadUser>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(MasiveLoadUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MASIVELOADUSER = "SELECT masiveLoadUser FROM MasiveLoadUser masiveLoadUser";
	private static final String _SQL_SELECT_MASIVELOADUSER_WHERE = "SELECT masiveLoadUser FROM MasiveLoadUser masiveLoadUser WHERE ";
	private static final String _SQL_COUNT_MASIVELOADUSER = "SELECT COUNT(masiveLoadUser) FROM MasiveLoadUser masiveLoadUser";
	private static final String _SQL_COUNT_MASIVELOADUSER_WHERE = "SELECT COUNT(masiveLoadUser) FROM MasiveLoadUser masiveLoadUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "masiveLoadUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MasiveLoadUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MasiveLoadUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MasiveLoadUserPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static MasiveLoadUser _nullMasiveLoadUser = new MasiveLoadUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MasiveLoadUser> toCacheModel() {
				return _nullMasiveLoadUserCacheModel;
			}
		};

	private static CacheModel<MasiveLoadUser> _nullMasiveLoadUserCacheModel = new CacheModel<MasiveLoadUser>() {
			@Override
			public MasiveLoadUser toEntityModel() {
				return _nullMasiveLoadUser;
			}
		};
}