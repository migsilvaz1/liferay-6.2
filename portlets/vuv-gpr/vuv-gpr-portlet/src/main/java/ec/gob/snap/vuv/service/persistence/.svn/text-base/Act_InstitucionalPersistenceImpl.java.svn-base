package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ec.gob.snap.vuv.NoSuchAct_InstitucionalException;
import ec.gob.snap.vuv.model.Act_Institucional;
import ec.gob.snap.vuv.model.impl.Act_InstitucionalImpl;
import ec.gob.snap.vuv.model.impl.Act_InstitucionalModelImpl;
import ec.gob.snap.vuv.service.persistence.Act_InstitucionalPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the act_ institucional service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Act_InstitucionalPersistence
 * @see Act_InstitucionalUtil
 * @generated
 */
public class Act_InstitucionalPersistenceImpl extends BasePersistenceImpl<Act_Institucional>
    implements Act_InstitucionalPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link Act_InstitucionalUtil} to access the act_ institucional persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = Act_InstitucionalImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Act_InstitucionalModelImpl.ENTITY_CACHE_ENABLED,
            Act_InstitucionalModelImpl.FINDER_CACHE_ENABLED,
            Act_InstitucionalImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Act_InstitucionalModelImpl.ENTITY_CACHE_ENABLED,
            Act_InstitucionalModelImpl.FINDER_CACHE_ENABLED,
            Act_InstitucionalImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Act_InstitucionalModelImpl.ENTITY_CACHE_ENABLED,
            Act_InstitucionalModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_ACT_INSTITUCIONAL = "SELECT act_Institucional FROM Act_Institucional act_Institucional";
    private static final String _SQL_COUNT_ACT_INSTITUCIONAL = "SELECT COUNT(act_Institucional) FROM Act_Institucional act_Institucional";
    private static final String _ORDER_BY_ENTITY_ALIAS = "act_Institucional.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Act_Institucional exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(Act_InstitucionalPersistenceImpl.class);
    private static Act_Institucional _nullAct_Institucional = new Act_InstitucionalImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Act_Institucional> toCacheModel() {
                return _nullAct_InstitucionalCacheModel;
            }
        };

    private static CacheModel<Act_Institucional> _nullAct_InstitucionalCacheModel =
        new CacheModel<Act_Institucional>() {
            @Override
            public Act_Institucional toEntityModel() {
                return _nullAct_Institucional;
            }
        };

    public Act_InstitucionalPersistenceImpl() {
        setModelClass(Act_Institucional.class);
    }

    /**
     * Caches the act_ institucional in the entity cache if it is enabled.
     *
     * @param act_Institucional the act_ institucional
     */
    @Override
    public void cacheResult(Act_Institucional act_Institucional) {
        EntityCacheUtil.putResult(Act_InstitucionalModelImpl.ENTITY_CACHE_ENABLED,
            Act_InstitucionalImpl.class, act_Institucional.getPrimaryKey(),
            act_Institucional);

        act_Institucional.resetOriginalValues();
    }

    /**
     * Caches the act_ institucionals in the entity cache if it is enabled.
     *
     * @param act_Institucionals the act_ institucionals
     */
    @Override
    public void cacheResult(List<Act_Institucional> act_Institucionals) {
        for (Act_Institucional act_Institucional : act_Institucionals) {
            if (EntityCacheUtil.getResult(
                        Act_InstitucionalModelImpl.ENTITY_CACHE_ENABLED,
                        Act_InstitucionalImpl.class,
                        act_Institucional.getPrimaryKey()) == null) {
                cacheResult(act_Institucional);
            } else {
                act_Institucional.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all act_ institucionals.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(Act_InstitucionalImpl.class.getName());
        }

        EntityCacheUtil.clearCache(Act_InstitucionalImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the act_ institucional.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Act_Institucional act_Institucional) {
        EntityCacheUtil.removeResult(Act_InstitucionalModelImpl.ENTITY_CACHE_ENABLED,
            Act_InstitucionalImpl.class, act_Institucional.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Act_Institucional> act_Institucionals) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Act_Institucional act_Institucional : act_Institucionals) {
            EntityCacheUtil.removeResult(Act_InstitucionalModelImpl.ENTITY_CACHE_ENABLED,
                Act_InstitucionalImpl.class, act_Institucional.getPrimaryKey());
        }
    }

    /**
     * Creates a new act_ institucional with the primary key. Does not add the act_ institucional to the database.
     *
     * @param id_act_institucional the primary key for the new act_ institucional
     * @return the new act_ institucional
     */
    @Override
    public Act_Institucional create(long id_act_institucional) {
        Act_Institucional act_Institucional = new Act_InstitucionalImpl();

        act_Institucional.setNew(true);
        act_Institucional.setPrimaryKey(id_act_institucional);

        return act_Institucional;
    }

    /**
     * Removes the act_ institucional with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id_act_institucional the primary key of the act_ institucional
     * @return the act_ institucional that was removed
     * @throws ec.gob.snap.vuv.NoSuchAct_InstitucionalException if a act_ institucional with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Act_Institucional remove(long id_act_institucional)
        throws NoSuchAct_InstitucionalException, SystemException {
        return remove((Serializable) id_act_institucional);
    }

    /**
     * Removes the act_ institucional with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the act_ institucional
     * @return the act_ institucional that was removed
     * @throws ec.gob.snap.vuv.NoSuchAct_InstitucionalException if a act_ institucional with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Act_Institucional remove(Serializable primaryKey)
        throws NoSuchAct_InstitucionalException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Act_Institucional act_Institucional = (Act_Institucional) session.get(Act_InstitucionalImpl.class,
                    primaryKey);

            if (act_Institucional == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAct_InstitucionalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(act_Institucional);
        } catch (NoSuchAct_InstitucionalException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Act_Institucional removeImpl(Act_Institucional act_Institucional)
        throws SystemException {
        act_Institucional = toUnwrappedModel(act_Institucional);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(act_Institucional)) {
                act_Institucional = (Act_Institucional) session.get(Act_InstitucionalImpl.class,
                        act_Institucional.getPrimaryKeyObj());
            }

            if (act_Institucional != null) {
                session.delete(act_Institucional);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (act_Institucional != null) {
            clearCache(act_Institucional);
        }

        return act_Institucional;
    }

    @Override
    public Act_Institucional updateImpl(
        ec.gob.snap.vuv.model.Act_Institucional act_Institucional)
        throws SystemException {
        act_Institucional = toUnwrappedModel(act_Institucional);

        boolean isNew = act_Institucional.isNew();

        Session session = null;

        try {
            session = openSession();

            if (act_Institucional.isNew()) {
                session.save(act_Institucional);

                act_Institucional.setNew(false);
            } else {
                session.merge(act_Institucional);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(Act_InstitucionalModelImpl.ENTITY_CACHE_ENABLED,
            Act_InstitucionalImpl.class, act_Institucional.getPrimaryKey(),
            act_Institucional);

        return act_Institucional;
    }

    protected Act_Institucional toUnwrappedModel(
        Act_Institucional act_Institucional) {
        if (act_Institucional instanceof Act_InstitucionalImpl) {
            return act_Institucional;
        }

        Act_InstitucionalImpl act_InstitucionalImpl = new Act_InstitucionalImpl();

        act_InstitucionalImpl.setNew(act_Institucional.isNew());
        act_InstitucionalImpl.setPrimaryKey(act_Institucional.getPrimaryKey());

        act_InstitucionalImpl.setId_act_institucional(act_Institucional.getId_act_institucional());
        act_InstitucionalImpl.setId_GPR_act_institucional(act_Institucional.getId_GPR_act_institucional());
        act_InstitucionalImpl.setContent(act_Institucional.getContent());
        act_InstitucionalImpl.setTimeStamp(act_Institucional.getTimeStamp());
        act_InstitucionalImpl.setId_servicio(act_Institucional.getId_servicio());

        return act_InstitucionalImpl;
    }

    /**
     * Returns the act_ institucional with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the act_ institucional
     * @return the act_ institucional
     * @throws ec.gob.snap.vuv.NoSuchAct_InstitucionalException if a act_ institucional with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Act_Institucional findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAct_InstitucionalException, SystemException {
        Act_Institucional act_Institucional = fetchByPrimaryKey(primaryKey);

        if (act_Institucional == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAct_InstitucionalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return act_Institucional;
    }

    /**
     * Returns the act_ institucional with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchAct_InstitucionalException} if it could not be found.
     *
     * @param id_act_institucional the primary key of the act_ institucional
     * @return the act_ institucional
     * @throws ec.gob.snap.vuv.NoSuchAct_InstitucionalException if a act_ institucional with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Act_Institucional findByPrimaryKey(long id_act_institucional)
        throws NoSuchAct_InstitucionalException, SystemException {
        return findByPrimaryKey((Serializable) id_act_institucional);
    }

    /**
     * Returns the act_ institucional with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the act_ institucional
     * @return the act_ institucional, or <code>null</code> if a act_ institucional with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Act_Institucional fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Act_Institucional act_Institucional = (Act_Institucional) EntityCacheUtil.getResult(Act_InstitucionalModelImpl.ENTITY_CACHE_ENABLED,
                Act_InstitucionalImpl.class, primaryKey);

        if (act_Institucional == _nullAct_Institucional) {
            return null;
        }

        if (act_Institucional == null) {
            Session session = null;

            try {
                session = openSession();

                act_Institucional = (Act_Institucional) session.get(Act_InstitucionalImpl.class,
                        primaryKey);

                if (act_Institucional != null) {
                    cacheResult(act_Institucional);
                } else {
                    EntityCacheUtil.putResult(Act_InstitucionalModelImpl.ENTITY_CACHE_ENABLED,
                        Act_InstitucionalImpl.class, primaryKey,
                        _nullAct_Institucional);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(Act_InstitucionalModelImpl.ENTITY_CACHE_ENABLED,
                    Act_InstitucionalImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return act_Institucional;
    }

    /**
     * Returns the act_ institucional with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id_act_institucional the primary key of the act_ institucional
     * @return the act_ institucional, or <code>null</code> if a act_ institucional with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Act_Institucional fetchByPrimaryKey(long id_act_institucional)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id_act_institucional);
    }

    /**
     * Returns all the act_ institucionals.
     *
     * @return the act_ institucionals
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Act_Institucional> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the act_ institucionals.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.Act_InstitucionalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of act_ institucionals
     * @param end the upper bound of the range of act_ institucionals (not inclusive)
     * @return the range of act_ institucionals
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Act_Institucional> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the act_ institucionals.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.Act_InstitucionalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of act_ institucionals
     * @param end the upper bound of the range of act_ institucionals (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of act_ institucionals
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Act_Institucional> findAll(int start, int end,
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

        List<Act_Institucional> list = (List<Act_Institucional>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ACT_INSTITUCIONAL);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ACT_INSTITUCIONAL;

                if (pagination) {
                    sql = sql.concat(Act_InstitucionalModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Act_Institucional>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Act_Institucional>(list);
                } else {
                    list = (List<Act_Institucional>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the act_ institucionals from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Act_Institucional act_Institucional : findAll()) {
            remove(act_Institucional);
        }
    }

    /**
     * Returns the number of act_ institucionals.
     *
     * @return the number of act_ institucionals
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

                Query q = session.createQuery(_SQL_COUNT_ACT_INSTITUCIONAL);

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

    /**
     * Initializes the act_ institucional persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ec.gob.snap.vuv.model.Act_Institucional")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Act_Institucional>> listenersList = new ArrayList<ModelListener<Act_Institucional>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Act_Institucional>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(Act_InstitucionalImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
