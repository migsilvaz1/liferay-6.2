package com.gfi.chg.service.persistence;

import com.gfi.chg.NoSuchTracingException;
import com.gfi.chg.model.Tracing;
import com.gfi.chg.model.impl.TracingImpl;
import com.gfi.chg.model.impl.TracingModelImpl;
import com.gfi.chg.service.persistence.TracingPersistence;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the tracing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TracingPersistence
 * @see TracingUtil
 * @generated
 */
public class TracingPersistenceImpl extends BasePersistenceImpl<Tracing>
    implements TracingPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link TracingUtil} to access the tracing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = TracingImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TracingModelImpl.ENTITY_CACHE_ENABLED,
            TracingModelImpl.FINDER_CACHE_ENABLED, TracingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TracingModelImpl.ENTITY_CACHE_ENABLED,
            TracingModelImpl.FINDER_CACHE_ENABLED, TracingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TracingModelImpl.ENTITY_CACHE_ENABLED,
            TracingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AREAID = new FinderPath(TracingModelImpl.ENTITY_CACHE_ENABLED,
            TracingModelImpl.FINDER_CACHE_ENABLED, TracingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAreaId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREAID =
        new FinderPath(TracingModelImpl.ENTITY_CACHE_ENABLED,
            TracingModelImpl.FINDER_CACHE_ENABLED, TracingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAreaId",
            new String[] { Long.class.getName() },
            TracingModelImpl.AREAID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_AREAID = new FinderPath(TracingModelImpl.ENTITY_CACHE_ENABLED,
            TracingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAreaId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_AREAID_AREAID_2 = "tracing.areaId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTID =
        new FinderPath(TracingModelImpl.ENTITY_CACHE_ENABLED,
            TracingModelImpl.FINDER_CACHE_ENABLED, TracingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContactId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID =
        new FinderPath(TracingModelImpl.ENTITY_CACHE_ENABLED,
            TracingModelImpl.FINDER_CACHE_ENABLED, TracingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContactId",
            new String[] { Long.class.getName() },
            TracingModelImpl.CONTACTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTID = new FinderPath(TracingModelImpl.ENTITY_CACHE_ENABLED,
            TracingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContactId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_CONTACTID_CONTACTID_2 = "tracing.contactId = ?";
    private static final String _SQL_SELECT_TRACING = "SELECT tracing FROM Tracing tracing";
    private static final String _SQL_SELECT_TRACING_WHERE = "SELECT tracing FROM Tracing tracing WHERE ";
    private static final String _SQL_COUNT_TRACING = "SELECT COUNT(tracing) FROM Tracing tracing";
    private static final String _SQL_COUNT_TRACING_WHERE = "SELECT COUNT(tracing) FROM Tracing tracing WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "tracing.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Tracing exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Tracing exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(TracingPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "comment"
            });
    private static Tracing _nullTracing = new TracingImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Tracing> toCacheModel() {
                return _nullTracingCacheModel;
            }
        };

    private static CacheModel<Tracing> _nullTracingCacheModel = new CacheModel<Tracing>() {
            @Override
            public Tracing toEntityModel() {
                return _nullTracing;
            }
        };

    public TracingPersistenceImpl() {
        setModelClass(Tracing.class);
    }

    /**
     * Returns all the tracings where areaId = &#63;.
     *
     * @param areaId the area ID
     * @return the matching tracings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Tracing> findByAreaId(long areaId) throws SystemException {
        return findByAreaId(areaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the tracings where areaId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.TracingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param areaId the area ID
     * @param start the lower bound of the range of tracings
     * @param end the upper bound of the range of tracings (not inclusive)
     * @return the range of matching tracings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Tracing> findByAreaId(long areaId, int start, int end)
        throws SystemException {
        return findByAreaId(areaId, start, end, null);
    }

    /**
     * Returns an ordered range of all the tracings where areaId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.TracingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param areaId the area ID
     * @param start the lower bound of the range of tracings
     * @param end the upper bound of the range of tracings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching tracings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Tracing> findByAreaId(long areaId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREAID;
            finderArgs = new Object[] { areaId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AREAID;
            finderArgs = new Object[] { areaId, start, end, orderByComparator };
        }

        List<Tracing> list = (List<Tracing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Tracing tracing : list) {
                if ((areaId != tracing.getAreaId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_TRACING_WHERE);

            query.append(_FINDER_COLUMN_AREAID_AREAID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TracingModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(areaId);

                if (!pagination) {
                    list = (List<Tracing>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Tracing>(list);
                } else {
                    list = (List<Tracing>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first tracing in the ordered set where areaId = &#63;.
     *
     * @param areaId the area ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching tracing
     * @throws com.gfi.chg.NoSuchTracingException if a matching tracing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing findByAreaId_First(long areaId,
        OrderByComparator orderByComparator)
        throws NoSuchTracingException, SystemException {
        Tracing tracing = fetchByAreaId_First(areaId, orderByComparator);

        if (tracing != null) {
            return tracing;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("areaId=");
        msg.append(areaId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTracingException(msg.toString());
    }

    /**
     * Returns the first tracing in the ordered set where areaId = &#63;.
     *
     * @param areaId the area ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching tracing, or <code>null</code> if a matching tracing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing fetchByAreaId_First(long areaId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Tracing> list = findByAreaId(areaId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last tracing in the ordered set where areaId = &#63;.
     *
     * @param areaId the area ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching tracing
     * @throws com.gfi.chg.NoSuchTracingException if a matching tracing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing findByAreaId_Last(long areaId,
        OrderByComparator orderByComparator)
        throws NoSuchTracingException, SystemException {
        Tracing tracing = fetchByAreaId_Last(areaId, orderByComparator);

        if (tracing != null) {
            return tracing;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("areaId=");
        msg.append(areaId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTracingException(msg.toString());
    }

    /**
     * Returns the last tracing in the ordered set where areaId = &#63;.
     *
     * @param areaId the area ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching tracing, or <code>null</code> if a matching tracing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing fetchByAreaId_Last(long areaId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByAreaId(areaId);

        if (count == 0) {
            return null;
        }

        List<Tracing> list = findByAreaId(areaId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the tracings before and after the current tracing in the ordered set where areaId = &#63;.
     *
     * @param tracingId the primary key of the current tracing
     * @param areaId the area ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next tracing
     * @throws com.gfi.chg.NoSuchTracingException if a tracing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing[] findByAreaId_PrevAndNext(long tracingId, long areaId,
        OrderByComparator orderByComparator)
        throws NoSuchTracingException, SystemException {
        Tracing tracing = findByPrimaryKey(tracingId);

        Session session = null;

        try {
            session = openSession();

            Tracing[] array = new TracingImpl[3];

            array[0] = getByAreaId_PrevAndNext(session, tracing, areaId,
                    orderByComparator, true);

            array[1] = tracing;

            array[2] = getByAreaId_PrevAndNext(session, tracing, areaId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Tracing getByAreaId_PrevAndNext(Session session, Tracing tracing,
        long areaId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TRACING_WHERE);

        query.append(_FINDER_COLUMN_AREAID_AREAID_2);

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
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
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
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(TracingModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(areaId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(tracing);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Tracing> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the tracings where areaId = &#63; from the database.
     *
     * @param areaId the area ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAreaId(long areaId) throws SystemException {
        for (Tracing tracing : findByAreaId(areaId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(tracing);
        }
    }

    /**
     * Returns the number of tracings where areaId = &#63;.
     *
     * @param areaId the area ID
     * @return the number of matching tracings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAreaId(long areaId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_AREAID;

        Object[] finderArgs = new Object[] { areaId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_TRACING_WHERE);

            query.append(_FINDER_COLUMN_AREAID_AREAID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(areaId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the tracings where contactId = &#63;.
     *
     * @param contactId the contact ID
     * @return the matching tracings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Tracing> findByContactId(long contactId)
        throws SystemException {
        return findByContactId(contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the tracings where contactId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.TracingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param contactId the contact ID
     * @param start the lower bound of the range of tracings
     * @param end the upper bound of the range of tracings (not inclusive)
     * @return the range of matching tracings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Tracing> findByContactId(long contactId, int start, int end)
        throws SystemException {
        return findByContactId(contactId, start, end, null);
    }

    /**
     * Returns an ordered range of all the tracings where contactId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.TracingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param contactId the contact ID
     * @param start the lower bound of the range of tracings
     * @param end the upper bound of the range of tracings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching tracings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Tracing> findByContactId(long contactId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID;
            finderArgs = new Object[] { contactId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTID;
            finderArgs = new Object[] { contactId, start, end, orderByComparator };
        }

        List<Tracing> list = (List<Tracing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Tracing tracing : list) {
                if ((contactId != tracing.getContactId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_TRACING_WHERE);

            query.append(_FINDER_COLUMN_CONTACTID_CONTACTID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TracingModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(contactId);

                if (!pagination) {
                    list = (List<Tracing>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Tracing>(list);
                } else {
                    list = (List<Tracing>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first tracing in the ordered set where contactId = &#63;.
     *
     * @param contactId the contact ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching tracing
     * @throws com.gfi.chg.NoSuchTracingException if a matching tracing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing findByContactId_First(long contactId,
        OrderByComparator orderByComparator)
        throws NoSuchTracingException, SystemException {
        Tracing tracing = fetchByContactId_First(contactId, orderByComparator);

        if (tracing != null) {
            return tracing;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("contactId=");
        msg.append(contactId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTracingException(msg.toString());
    }

    /**
     * Returns the first tracing in the ordered set where contactId = &#63;.
     *
     * @param contactId the contact ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching tracing, or <code>null</code> if a matching tracing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing fetchByContactId_First(long contactId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Tracing> list = findByContactId(contactId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last tracing in the ordered set where contactId = &#63;.
     *
     * @param contactId the contact ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching tracing
     * @throws com.gfi.chg.NoSuchTracingException if a matching tracing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing findByContactId_Last(long contactId,
        OrderByComparator orderByComparator)
        throws NoSuchTracingException, SystemException {
        Tracing tracing = fetchByContactId_Last(contactId, orderByComparator);

        if (tracing != null) {
            return tracing;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("contactId=");
        msg.append(contactId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTracingException(msg.toString());
    }

    /**
     * Returns the last tracing in the ordered set where contactId = &#63;.
     *
     * @param contactId the contact ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching tracing, or <code>null</code> if a matching tracing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing fetchByContactId_Last(long contactId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByContactId(contactId);

        if (count == 0) {
            return null;
        }

        List<Tracing> list = findByContactId(contactId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the tracings before and after the current tracing in the ordered set where contactId = &#63;.
     *
     * @param tracingId the primary key of the current tracing
     * @param contactId the contact ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next tracing
     * @throws com.gfi.chg.NoSuchTracingException if a tracing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing[] findByContactId_PrevAndNext(long tracingId,
        long contactId, OrderByComparator orderByComparator)
        throws NoSuchTracingException, SystemException {
        Tracing tracing = findByPrimaryKey(tracingId);

        Session session = null;

        try {
            session = openSession();

            Tracing[] array = new TracingImpl[3];

            array[0] = getByContactId_PrevAndNext(session, tracing, contactId,
                    orderByComparator, true);

            array[1] = tracing;

            array[2] = getByContactId_PrevAndNext(session, tracing, contactId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Tracing getByContactId_PrevAndNext(Session session,
        Tracing tracing, long contactId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TRACING_WHERE);

        query.append(_FINDER_COLUMN_CONTACTID_CONTACTID_2);

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
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
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
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(TracingModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(contactId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(tracing);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Tracing> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the tracings where contactId = &#63; from the database.
     *
     * @param contactId the contact ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByContactId(long contactId) throws SystemException {
        for (Tracing tracing : findByContactId(contactId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(tracing);
        }
    }

    /**
     * Returns the number of tracings where contactId = &#63;.
     *
     * @param contactId the contact ID
     * @return the number of matching tracings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByContactId(long contactId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACTID;

        Object[] finderArgs = new Object[] { contactId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_TRACING_WHERE);

            query.append(_FINDER_COLUMN_CONTACTID_CONTACTID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(contactId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the tracing in the entity cache if it is enabled.
     *
     * @param tracing the tracing
     */
    @Override
    public void cacheResult(Tracing tracing) {
        EntityCacheUtil.putResult(TracingModelImpl.ENTITY_CACHE_ENABLED,
            TracingImpl.class, tracing.getPrimaryKey(), tracing);

        tracing.resetOriginalValues();
    }

    /**
     * Caches the tracings in the entity cache if it is enabled.
     *
     * @param tracings the tracings
     */
    @Override
    public void cacheResult(List<Tracing> tracings) {
        for (Tracing tracing : tracings) {
            if (EntityCacheUtil.getResult(
                        TracingModelImpl.ENTITY_CACHE_ENABLED,
                        TracingImpl.class, tracing.getPrimaryKey()) == null) {
                cacheResult(tracing);
            } else {
                tracing.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all tracings.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(TracingImpl.class.getName());
        }

        EntityCacheUtil.clearCache(TracingImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the tracing.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Tracing tracing) {
        EntityCacheUtil.removeResult(TracingModelImpl.ENTITY_CACHE_ENABLED,
            TracingImpl.class, tracing.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Tracing> tracings) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Tracing tracing : tracings) {
            EntityCacheUtil.removeResult(TracingModelImpl.ENTITY_CACHE_ENABLED,
                TracingImpl.class, tracing.getPrimaryKey());
        }
    }

    /**
     * Creates a new tracing with the primary key. Does not add the tracing to the database.
     *
     * @param tracingId the primary key for the new tracing
     * @return the new tracing
     */
    @Override
    public Tracing create(long tracingId) {
        Tracing tracing = new TracingImpl();

        tracing.setNew(true);
        tracing.setPrimaryKey(tracingId);

        return tracing;
    }

    /**
     * Removes the tracing with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param tracingId the primary key of the tracing
     * @return the tracing that was removed
     * @throws com.gfi.chg.NoSuchTracingException if a tracing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing remove(long tracingId)
        throws NoSuchTracingException, SystemException {
        return remove((Serializable) tracingId);
    }

    /**
     * Removes the tracing with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the tracing
     * @return the tracing that was removed
     * @throws com.gfi.chg.NoSuchTracingException if a tracing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing remove(Serializable primaryKey)
        throws NoSuchTracingException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Tracing tracing = (Tracing) session.get(TracingImpl.class,
                    primaryKey);

            if (tracing == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchTracingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(tracing);
        } catch (NoSuchTracingException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Tracing removeImpl(Tracing tracing) throws SystemException {
        tracing = toUnwrappedModel(tracing);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(tracing)) {
                tracing = (Tracing) session.get(TracingImpl.class,
                        tracing.getPrimaryKeyObj());
            }

            if (tracing != null) {
                session.delete(tracing);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (tracing != null) {
            clearCache(tracing);
        }

        return tracing;
    }

    @Override
    public Tracing updateImpl(com.gfi.chg.model.Tracing tracing)
        throws SystemException {
        tracing = toUnwrappedModel(tracing);

        boolean isNew = tracing.isNew();

        TracingModelImpl tracingModelImpl = (TracingModelImpl) tracing;

        Session session = null;

        try {
            session = openSession();

            if (tracing.isNew()) {
                session.save(tracing);

                tracing.setNew(false);
            } else {
                session.merge(tracing);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !TracingModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((tracingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREAID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        tracingModelImpl.getOriginalAreaId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AREAID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREAID,
                    args);

                args = new Object[] { tracingModelImpl.getAreaId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AREAID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREAID,
                    args);
            }

            if ((tracingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        tracingModelImpl.getOriginalContactId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID,
                    args);

                args = new Object[] { tracingModelImpl.getContactId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID,
                    args);
            }
        }

        EntityCacheUtil.putResult(TracingModelImpl.ENTITY_CACHE_ENABLED,
            TracingImpl.class, tracing.getPrimaryKey(), tracing);

        return tracing;
    }

    protected Tracing toUnwrappedModel(Tracing tracing) {
        if (tracing instanceof TracingImpl) {
            return tracing;
        }

        TracingImpl tracingImpl = new TracingImpl();

        tracingImpl.setNew(tracing.isNew());
        tracingImpl.setPrimaryKey(tracing.getPrimaryKey());

        tracingImpl.setTracingId(tracing.getTracingId());
        tracingImpl.setAreaId(tracing.getAreaId());
        tracingImpl.setContactId(tracing.getContactId());
        tracingImpl.setStatus(tracing.getStatus());
        tracingImpl.setModifiedDate(tracing.getModifiedDate());
        tracingImpl.setComment(tracing.getComment());

        return tracingImpl;
    }

    /**
     * Returns the tracing with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the tracing
     * @return the tracing
     * @throws com.gfi.chg.NoSuchTracingException if a tracing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing findByPrimaryKey(Serializable primaryKey)
        throws NoSuchTracingException, SystemException {
        Tracing tracing = fetchByPrimaryKey(primaryKey);

        if (tracing == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchTracingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return tracing;
    }

    /**
     * Returns the tracing with the primary key or throws a {@link com.gfi.chg.NoSuchTracingException} if it could not be found.
     *
     * @param tracingId the primary key of the tracing
     * @return the tracing
     * @throws com.gfi.chg.NoSuchTracingException if a tracing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing findByPrimaryKey(long tracingId)
        throws NoSuchTracingException, SystemException {
        return findByPrimaryKey((Serializable) tracingId);
    }

    /**
     * Returns the tracing with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the tracing
     * @return the tracing, or <code>null</code> if a tracing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Tracing tracing = (Tracing) EntityCacheUtil.getResult(TracingModelImpl.ENTITY_CACHE_ENABLED,
                TracingImpl.class, primaryKey);

        if (tracing == _nullTracing) {
            return null;
        }

        if (tracing == null) {
            Session session = null;

            try {
                session = openSession();

                tracing = (Tracing) session.get(TracingImpl.class, primaryKey);

                if (tracing != null) {
                    cacheResult(tracing);
                } else {
                    EntityCacheUtil.putResult(TracingModelImpl.ENTITY_CACHE_ENABLED,
                        TracingImpl.class, primaryKey, _nullTracing);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(TracingModelImpl.ENTITY_CACHE_ENABLED,
                    TracingImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return tracing;
    }

    /**
     * Returns the tracing with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param tracingId the primary key of the tracing
     * @return the tracing, or <code>null</code> if a tracing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing fetchByPrimaryKey(long tracingId) throws SystemException {
        return fetchByPrimaryKey((Serializable) tracingId);
    }

    /**
     * Returns all the tracings.
     *
     * @return the tracings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Tracing> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the tracings.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.TracingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of tracings
     * @param end the upper bound of the range of tracings (not inclusive)
     * @return the range of tracings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Tracing> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the tracings.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.TracingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of tracings
     * @param end the upper bound of the range of tracings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of tracings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Tracing> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Tracing> list = (List<Tracing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_TRACING);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_TRACING;

                if (pagination) {
                    sql = sql.concat(TracingModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Tracing>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Tracing>(list);
                } else {
                    list = (List<Tracing>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the tracings from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Tracing tracing : findAll()) {
            remove(tracing);
        }
    }

    /**
     * Returns the number of tracings.
     *
     * @return the number of tracings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_TRACING);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
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
     * Initializes the tracing persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.gfi.chg.model.Tracing")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Tracing>> listenersList = new ArrayList<ModelListener<Tracing>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Tracing>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(TracingImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
