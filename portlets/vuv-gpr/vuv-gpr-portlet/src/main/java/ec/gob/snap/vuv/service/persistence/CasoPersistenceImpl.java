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

import ec.gob.snap.vuv.NoSuchCasoException;
import ec.gob.snap.vuv.model.Caso;
import ec.gob.snap.vuv.model.impl.CasoImpl;
import ec.gob.snap.vuv.model.impl.CasoModelImpl;
import ec.gob.snap.vuv.service.persistence.CasoPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the caso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CasoPersistence
 * @see CasoUtil
 * @generated
 */
public class CasoPersistenceImpl extends BasePersistenceImpl<Caso>
    implements CasoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CasoUtil} to access the caso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CasoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CasoModelImpl.ENTITY_CACHE_ENABLED,
            CasoModelImpl.FINDER_CACHE_ENABLED, CasoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CasoModelImpl.ENTITY_CACHE_ENABLED,
            CasoModelImpl.FINDER_CACHE_ENABLED, CasoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CasoModelImpl.ENTITY_CACHE_ENABLED,
            CasoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_CASO = "SELECT caso FROM Caso caso";
    private static final String _SQL_COUNT_CASO = "SELECT COUNT(caso) FROM Caso caso";
    private static final String _ORDER_BY_ENTITY_ALIAS = "caso.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Caso exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CasoPersistenceImpl.class);
    private static Caso _nullCaso = new CasoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Caso> toCacheModel() {
                return _nullCasoCacheModel;
            }
        };

    private static CacheModel<Caso> _nullCasoCacheModel = new CacheModel<Caso>() {
            @Override
            public Caso toEntityModel() {
                return _nullCaso;
            }
        };

    public CasoPersistenceImpl() {
        setModelClass(Caso.class);
    }

    /**
     * Caches the caso in the entity cache if it is enabled.
     *
     * @param caso the caso
     */
    @Override
    public void cacheResult(Caso caso) {
        EntityCacheUtil.putResult(CasoModelImpl.ENTITY_CACHE_ENABLED,
            CasoImpl.class, caso.getPrimaryKey(), caso);

        caso.resetOriginalValues();
    }

    /**
     * Caches the casos in the entity cache if it is enabled.
     *
     * @param casos the casos
     */
    @Override
    public void cacheResult(List<Caso> casos) {
        for (Caso caso : casos) {
            if (EntityCacheUtil.getResult(CasoModelImpl.ENTITY_CACHE_ENABLED,
                        CasoImpl.class, caso.getPrimaryKey()) == null) {
                cacheResult(caso);
            } else {
                caso.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all casos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CasoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CasoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the caso.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Caso caso) {
        EntityCacheUtil.removeResult(CasoModelImpl.ENTITY_CACHE_ENABLED,
            CasoImpl.class, caso.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Caso> casos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Caso caso : casos) {
            EntityCacheUtil.removeResult(CasoModelImpl.ENTITY_CACHE_ENABLED,
                CasoImpl.class, caso.getPrimaryKey());
        }
    }

    /**
     * Creates a new caso with the primary key. Does not add the caso to the database.
     *
     * @param id_caso the primary key for the new caso
     * @return the new caso
     */
    @Override
    public Caso create(long id_caso) {
        Caso caso = new CasoImpl();

        caso.setNew(true);
        caso.setPrimaryKey(id_caso);

        return caso;
    }

    /**
     * Removes the caso with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id_caso the primary key of the caso
     * @return the caso that was removed
     * @throws ec.gob.snap.vuv.NoSuchCasoException if a caso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Caso remove(long id_caso)
        throws NoSuchCasoException, SystemException {
        return remove((Serializable) id_caso);
    }

    /**
     * Removes the caso with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the caso
     * @return the caso that was removed
     * @throws ec.gob.snap.vuv.NoSuchCasoException if a caso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Caso remove(Serializable primaryKey)
        throws NoSuchCasoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Caso caso = (Caso) session.get(CasoImpl.class, primaryKey);

            if (caso == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCasoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(caso);
        } catch (NoSuchCasoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Caso removeImpl(Caso caso) throws SystemException {
        caso = toUnwrappedModel(caso);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(caso)) {
                caso = (Caso) session.get(CasoImpl.class,
                        caso.getPrimaryKeyObj());
            }

            if (caso != null) {
                session.delete(caso);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (caso != null) {
            clearCache(caso);
        }

        return caso;
    }

    @Override
    public Caso updateImpl(ec.gob.snap.vuv.model.Caso caso)
        throws SystemException {
        caso = toUnwrappedModel(caso);

        boolean isNew = caso.isNew();

        Session session = null;

        try {
            session = openSession();

            if (caso.isNew()) {
                session.save(caso);

                caso.setNew(false);
            } else {
                session.merge(caso);
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

        EntityCacheUtil.putResult(CasoModelImpl.ENTITY_CACHE_ENABLED,
            CasoImpl.class, caso.getPrimaryKey(), caso);

        return caso;
    }

    protected Caso toUnwrappedModel(Caso caso) {
        if (caso instanceof CasoImpl) {
            return caso;
        }

        CasoImpl casoImpl = new CasoImpl();

        casoImpl.setNew(caso.isNew());
        casoImpl.setPrimaryKey(caso.getPrimaryKey());

        casoImpl.setId_caso(caso.getId_caso());
        casoImpl.setId_GPR_caso(caso.getId_GPR_caso());
        casoImpl.setContent(caso.getContent());
        casoImpl.setTimeStamp(caso.getTimeStamp());
        casoImpl.setId_servicio(caso.getId_servicio());

        return casoImpl;
    }

    /**
     * Returns the caso with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the caso
     * @return the caso
     * @throws ec.gob.snap.vuv.NoSuchCasoException if a caso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Caso findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCasoException, SystemException {
        Caso caso = fetchByPrimaryKey(primaryKey);

        if (caso == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCasoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return caso;
    }

    /**
     * Returns the caso with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchCasoException} if it could not be found.
     *
     * @param id_caso the primary key of the caso
     * @return the caso
     * @throws ec.gob.snap.vuv.NoSuchCasoException if a caso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Caso findByPrimaryKey(long id_caso)
        throws NoSuchCasoException, SystemException {
        return findByPrimaryKey((Serializable) id_caso);
    }

    /**
     * Returns the caso with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the caso
     * @return the caso, or <code>null</code> if a caso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Caso fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Caso caso = (Caso) EntityCacheUtil.getResult(CasoModelImpl.ENTITY_CACHE_ENABLED,
                CasoImpl.class, primaryKey);

        if (caso == _nullCaso) {
            return null;
        }

        if (caso == null) {
            Session session = null;

            try {
                session = openSession();

                caso = (Caso) session.get(CasoImpl.class, primaryKey);

                if (caso != null) {
                    cacheResult(caso);
                } else {
                    EntityCacheUtil.putResult(CasoModelImpl.ENTITY_CACHE_ENABLED,
                        CasoImpl.class, primaryKey, _nullCaso);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(CasoModelImpl.ENTITY_CACHE_ENABLED,
                    CasoImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return caso;
    }

    /**
     * Returns the caso with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id_caso the primary key of the caso
     * @return the caso, or <code>null</code> if a caso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Caso fetchByPrimaryKey(long id_caso) throws SystemException {
        return fetchByPrimaryKey((Serializable) id_caso);
    }

    /**
     * Returns all the casos.
     *
     * @return the casos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Caso> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the casos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.CasoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of casos
     * @param end the upper bound of the range of casos (not inclusive)
     * @return the range of casos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Caso> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the casos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.CasoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of casos
     * @param end the upper bound of the range of casos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of casos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Caso> findAll(int start, int end,
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

        List<Caso> list = (List<Caso>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CASO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CASO;

                if (pagination) {
                    sql = sql.concat(CasoModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Caso>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Caso>(list);
                } else {
                    list = (List<Caso>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Removes all the casos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Caso caso : findAll()) {
            remove(caso);
        }
    }

    /**
     * Returns the number of casos.
     *
     * @return the number of casos
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

                Query q = session.createQuery(_SQL_COUNT_CASO);

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
     * Initializes the caso persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ec.gob.snap.vuv.model.Caso")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Caso>> listenersList = new ArrayList<ModelListener<Caso>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Caso>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CasoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
