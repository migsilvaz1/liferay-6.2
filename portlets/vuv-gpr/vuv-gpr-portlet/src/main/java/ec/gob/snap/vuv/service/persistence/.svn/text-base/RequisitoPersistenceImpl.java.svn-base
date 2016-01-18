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

import ec.gob.snap.vuv.NoSuchRequisitoException;
import ec.gob.snap.vuv.model.Requisito;
import ec.gob.snap.vuv.model.impl.RequisitoImpl;
import ec.gob.snap.vuv.model.impl.RequisitoModelImpl;
import ec.gob.snap.vuv.service.persistence.RequisitoPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the requisito service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RequisitoPersistence
 * @see RequisitoUtil
 * @generated
 */
public class RequisitoPersistenceImpl extends BasePersistenceImpl<Requisito>
    implements RequisitoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link RequisitoUtil} to access the requisito persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = RequisitoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RequisitoModelImpl.ENTITY_CACHE_ENABLED,
            RequisitoModelImpl.FINDER_CACHE_ENABLED, RequisitoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RequisitoModelImpl.ENTITY_CACHE_ENABLED,
            RequisitoModelImpl.FINDER_CACHE_ENABLED, RequisitoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RequisitoModelImpl.ENTITY_CACHE_ENABLED,
            RequisitoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_REQUISITO = "SELECT requisito FROM Requisito requisito";
    private static final String _SQL_COUNT_REQUISITO = "SELECT COUNT(requisito) FROM Requisito requisito";
    private static final String _ORDER_BY_ENTITY_ALIAS = "requisito.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Requisito exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(RequisitoPersistenceImpl.class);
    private static Requisito _nullRequisito = new RequisitoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Requisito> toCacheModel() {
                return _nullRequisitoCacheModel;
            }
        };

    private static CacheModel<Requisito> _nullRequisitoCacheModel = new CacheModel<Requisito>() {
            @Override
            public Requisito toEntityModel() {
                return _nullRequisito;
            }
        };

    public RequisitoPersistenceImpl() {
        setModelClass(Requisito.class);
    }

    /**
     * Caches the requisito in the entity cache if it is enabled.
     *
     * @param requisito the requisito
     */
    @Override
    public void cacheResult(Requisito requisito) {
        EntityCacheUtil.putResult(RequisitoModelImpl.ENTITY_CACHE_ENABLED,
            RequisitoImpl.class, requisito.getPrimaryKey(), requisito);

        requisito.resetOriginalValues();
    }

    /**
     * Caches the requisitos in the entity cache if it is enabled.
     *
     * @param requisitos the requisitos
     */
    @Override
    public void cacheResult(List<Requisito> requisitos) {
        for (Requisito requisito : requisitos) {
            if (EntityCacheUtil.getResult(
                        RequisitoModelImpl.ENTITY_CACHE_ENABLED,
                        RequisitoImpl.class, requisito.getPrimaryKey()) == null) {
                cacheResult(requisito);
            } else {
                requisito.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all requisitos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(RequisitoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(RequisitoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the requisito.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Requisito requisito) {
        EntityCacheUtil.removeResult(RequisitoModelImpl.ENTITY_CACHE_ENABLED,
            RequisitoImpl.class, requisito.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Requisito> requisitos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Requisito requisito : requisitos) {
            EntityCacheUtil.removeResult(RequisitoModelImpl.ENTITY_CACHE_ENABLED,
                RequisitoImpl.class, requisito.getPrimaryKey());
        }
    }

    /**
     * Creates a new requisito with the primary key. Does not add the requisito to the database.
     *
     * @param id_requisito the primary key for the new requisito
     * @return the new requisito
     */
    @Override
    public Requisito create(long id_requisito) {
        Requisito requisito = new RequisitoImpl();

        requisito.setNew(true);
        requisito.setPrimaryKey(id_requisito);

        return requisito;
    }

    /**
     * Removes the requisito with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id_requisito the primary key of the requisito
     * @return the requisito that was removed
     * @throws ec.gob.snap.vuv.NoSuchRequisitoException if a requisito with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Requisito remove(long id_requisito)
        throws NoSuchRequisitoException, SystemException {
        return remove((Serializable) id_requisito);
    }

    /**
     * Removes the requisito with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the requisito
     * @return the requisito that was removed
     * @throws ec.gob.snap.vuv.NoSuchRequisitoException if a requisito with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Requisito remove(Serializable primaryKey)
        throws NoSuchRequisitoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Requisito requisito = (Requisito) session.get(RequisitoImpl.class,
                    primaryKey);

            if (requisito == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchRequisitoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(requisito);
        } catch (NoSuchRequisitoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Requisito removeImpl(Requisito requisito)
        throws SystemException {
        requisito = toUnwrappedModel(requisito);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(requisito)) {
                requisito = (Requisito) session.get(RequisitoImpl.class,
                        requisito.getPrimaryKeyObj());
            }

            if (requisito != null) {
                session.delete(requisito);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (requisito != null) {
            clearCache(requisito);
        }

        return requisito;
    }

    @Override
    public Requisito updateImpl(ec.gob.snap.vuv.model.Requisito requisito)
        throws SystemException {
        requisito = toUnwrappedModel(requisito);

        boolean isNew = requisito.isNew();

        Session session = null;

        try {
            session = openSession();

            if (requisito.isNew()) {
                session.save(requisito);

                requisito.setNew(false);
            } else {
                session.merge(requisito);
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

        EntityCacheUtil.putResult(RequisitoModelImpl.ENTITY_CACHE_ENABLED,
            RequisitoImpl.class, requisito.getPrimaryKey(), requisito);

        return requisito;
    }

    protected Requisito toUnwrappedModel(Requisito requisito) {
        if (requisito instanceof RequisitoImpl) {
            return requisito;
        }

        RequisitoImpl requisitoImpl = new RequisitoImpl();

        requisitoImpl.setNew(requisito.isNew());
        requisitoImpl.setPrimaryKey(requisito.getPrimaryKey());

        requisitoImpl.setId_requisito(requisito.getId_requisito());
        requisitoImpl.setId_GPR_requisito(requisito.getId_GPR_requisito());
        requisitoImpl.setContent(requisito.getContent());
        requisitoImpl.setTimeStamp(requisito.getTimeStamp());
        requisitoImpl.setId_paso(requisito.getId_paso());

        return requisitoImpl;
    }

    /**
     * Returns the requisito with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the requisito
     * @return the requisito
     * @throws ec.gob.snap.vuv.NoSuchRequisitoException if a requisito with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Requisito findByPrimaryKey(Serializable primaryKey)
        throws NoSuchRequisitoException, SystemException {
        Requisito requisito = fetchByPrimaryKey(primaryKey);

        if (requisito == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchRequisitoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return requisito;
    }

    /**
     * Returns the requisito with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchRequisitoException} if it could not be found.
     *
     * @param id_requisito the primary key of the requisito
     * @return the requisito
     * @throws ec.gob.snap.vuv.NoSuchRequisitoException if a requisito with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Requisito findByPrimaryKey(long id_requisito)
        throws NoSuchRequisitoException, SystemException {
        return findByPrimaryKey((Serializable) id_requisito);
    }

    /**
     * Returns the requisito with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the requisito
     * @return the requisito, or <code>null</code> if a requisito with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Requisito fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Requisito requisito = (Requisito) EntityCacheUtil.getResult(RequisitoModelImpl.ENTITY_CACHE_ENABLED,
                RequisitoImpl.class, primaryKey);

        if (requisito == _nullRequisito) {
            return null;
        }

        if (requisito == null) {
            Session session = null;

            try {
                session = openSession();

                requisito = (Requisito) session.get(RequisitoImpl.class,
                        primaryKey);

                if (requisito != null) {
                    cacheResult(requisito);
                } else {
                    EntityCacheUtil.putResult(RequisitoModelImpl.ENTITY_CACHE_ENABLED,
                        RequisitoImpl.class, primaryKey, _nullRequisito);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(RequisitoModelImpl.ENTITY_CACHE_ENABLED,
                    RequisitoImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return requisito;
    }

    /**
     * Returns the requisito with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id_requisito the primary key of the requisito
     * @return the requisito, or <code>null</code> if a requisito with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Requisito fetchByPrimaryKey(long id_requisito)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id_requisito);
    }

    /**
     * Returns all the requisitos.
     *
     * @return the requisitos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Requisito> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the requisitos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.RequisitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of requisitos
     * @param end the upper bound of the range of requisitos (not inclusive)
     * @return the range of requisitos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Requisito> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the requisitos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.RequisitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of requisitos
     * @param end the upper bound of the range of requisitos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of requisitos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Requisito> findAll(int start, int end,
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

        List<Requisito> list = (List<Requisito>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_REQUISITO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_REQUISITO;

                if (pagination) {
                    sql = sql.concat(RequisitoModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Requisito>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Requisito>(list);
                } else {
                    list = (List<Requisito>) QueryUtil.list(q, getDialect(),
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
     * Removes all the requisitos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Requisito requisito : findAll()) {
            remove(requisito);
        }
    }

    /**
     * Returns the number of requisitos.
     *
     * @return the number of requisitos
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

                Query q = session.createQuery(_SQL_COUNT_REQUISITO);

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
     * Initializes the requisito persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ec.gob.snap.vuv.model.Requisito")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Requisito>> listenersList = new ArrayList<ModelListener<Requisito>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Requisito>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(RequisitoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
