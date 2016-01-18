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

import ec.gob.snap.vuv.NoSuchInstitucionException;
import ec.gob.snap.vuv.model.Institucion;
import ec.gob.snap.vuv.model.impl.InstitucionImpl;
import ec.gob.snap.vuv.model.impl.InstitucionModelImpl;
import ec.gob.snap.vuv.service.persistence.InstitucionPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the institucion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InstitucionPersistence
 * @see InstitucionUtil
 * @generated
 */
public class InstitucionPersistenceImpl extends BasePersistenceImpl<Institucion>
    implements InstitucionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link InstitucionUtil} to access the institucion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = InstitucionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InstitucionModelImpl.ENTITY_CACHE_ENABLED,
            InstitucionModelImpl.FINDER_CACHE_ENABLED, InstitucionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InstitucionModelImpl.ENTITY_CACHE_ENABLED,
            InstitucionModelImpl.FINDER_CACHE_ENABLED, InstitucionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InstitucionModelImpl.ENTITY_CACHE_ENABLED,
            InstitucionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_INSTITUCION = "SELECT institucion FROM Institucion institucion";
    private static final String _SQL_COUNT_INSTITUCION = "SELECT COUNT(institucion) FROM Institucion institucion";
    private static final String _ORDER_BY_ENTITY_ALIAS = "institucion.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Institucion exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(InstitucionPersistenceImpl.class);
    private static Institucion _nullInstitucion = new InstitucionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Institucion> toCacheModel() {
                return _nullInstitucionCacheModel;
            }
        };

    private static CacheModel<Institucion> _nullInstitucionCacheModel = new CacheModel<Institucion>() {
            @Override
            public Institucion toEntityModel() {
                return _nullInstitucion;
            }
        };

    public InstitucionPersistenceImpl() {
        setModelClass(Institucion.class);
    }

    /**
     * Caches the institucion in the entity cache if it is enabled.
     *
     * @param institucion the institucion
     */
    @Override
    public void cacheResult(Institucion institucion) {
        EntityCacheUtil.putResult(InstitucionModelImpl.ENTITY_CACHE_ENABLED,
            InstitucionImpl.class, institucion.getPrimaryKey(), institucion);

        institucion.resetOriginalValues();
    }

    /**
     * Caches the institucions in the entity cache if it is enabled.
     *
     * @param institucions the institucions
     */
    @Override
    public void cacheResult(List<Institucion> institucions) {
        for (Institucion institucion : institucions) {
            if (EntityCacheUtil.getResult(
                        InstitucionModelImpl.ENTITY_CACHE_ENABLED,
                        InstitucionImpl.class, institucion.getPrimaryKey()) == null) {
                cacheResult(institucion);
            } else {
                institucion.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all institucions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(InstitucionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(InstitucionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the institucion.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Institucion institucion) {
        EntityCacheUtil.removeResult(InstitucionModelImpl.ENTITY_CACHE_ENABLED,
            InstitucionImpl.class, institucion.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Institucion> institucions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Institucion institucion : institucions) {
            EntityCacheUtil.removeResult(InstitucionModelImpl.ENTITY_CACHE_ENABLED,
                InstitucionImpl.class, institucion.getPrimaryKey());
        }
    }

    /**
     * Creates a new institucion with the primary key. Does not add the institucion to the database.
     *
     * @param id_institucion the primary key for the new institucion
     * @return the new institucion
     */
    @Override
    public Institucion create(long id_institucion) {
        Institucion institucion = new InstitucionImpl();

        institucion.setNew(true);
        institucion.setPrimaryKey(id_institucion);

        return institucion;
    }

    /**
     * Removes the institucion with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id_institucion the primary key of the institucion
     * @return the institucion that was removed
     * @throws ec.gob.snap.vuv.NoSuchInstitucionException if a institucion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Institucion remove(long id_institucion)
        throws NoSuchInstitucionException, SystemException {
        return remove((Serializable) id_institucion);
    }

    /**
     * Removes the institucion with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the institucion
     * @return the institucion that was removed
     * @throws ec.gob.snap.vuv.NoSuchInstitucionException if a institucion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Institucion remove(Serializable primaryKey)
        throws NoSuchInstitucionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Institucion institucion = (Institucion) session.get(InstitucionImpl.class,
                    primaryKey);

            if (institucion == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchInstitucionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(institucion);
        } catch (NoSuchInstitucionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Institucion removeImpl(Institucion institucion)
        throws SystemException {
        institucion = toUnwrappedModel(institucion);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(institucion)) {
                institucion = (Institucion) session.get(InstitucionImpl.class,
                        institucion.getPrimaryKeyObj());
            }

            if (institucion != null) {
                session.delete(institucion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (institucion != null) {
            clearCache(institucion);
        }

        return institucion;
    }

    @Override
    public Institucion updateImpl(ec.gob.snap.vuv.model.Institucion institucion)
        throws SystemException {
        institucion = toUnwrappedModel(institucion);

        boolean isNew = institucion.isNew();

        Session session = null;

        try {
            session = openSession();

            if (institucion.isNew()) {
                session.save(institucion);

                institucion.setNew(false);
            } else {
                session.merge(institucion);
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

        EntityCacheUtil.putResult(InstitucionModelImpl.ENTITY_CACHE_ENABLED,
            InstitucionImpl.class, institucion.getPrimaryKey(), institucion);

        return institucion;
    }

    protected Institucion toUnwrappedModel(Institucion institucion) {
        if (institucion instanceof InstitucionImpl) {
            return institucion;
        }

        InstitucionImpl institucionImpl = new InstitucionImpl();

        institucionImpl.setNew(institucion.isNew());
        institucionImpl.setPrimaryKey(institucion.getPrimaryKey());

        institucionImpl.setId_institucion(institucion.getId_institucion());
        institucionImpl.setId_GPR_institucion(institucion.getId_GPR_institucion());
        institucionImpl.setContent(institucion.getContent());
        institucionImpl.setTimeStamp(institucion.getTimeStamp());

        return institucionImpl;
    }

    /**
     * Returns the institucion with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the institucion
     * @return the institucion
     * @throws ec.gob.snap.vuv.NoSuchInstitucionException if a institucion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Institucion findByPrimaryKey(Serializable primaryKey)
        throws NoSuchInstitucionException, SystemException {
        Institucion institucion = fetchByPrimaryKey(primaryKey);

        if (institucion == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchInstitucionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return institucion;
    }

    /**
     * Returns the institucion with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchInstitucionException} if it could not be found.
     *
     * @param id_institucion the primary key of the institucion
     * @return the institucion
     * @throws ec.gob.snap.vuv.NoSuchInstitucionException if a institucion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Institucion findByPrimaryKey(long id_institucion)
        throws NoSuchInstitucionException, SystemException {
        return findByPrimaryKey((Serializable) id_institucion);
    }

    /**
     * Returns the institucion with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the institucion
     * @return the institucion, or <code>null</code> if a institucion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Institucion fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Institucion institucion = (Institucion) EntityCacheUtil.getResult(InstitucionModelImpl.ENTITY_CACHE_ENABLED,
                InstitucionImpl.class, primaryKey);

        if (institucion == _nullInstitucion) {
            return null;
        }

        if (institucion == null) {
            Session session = null;

            try {
                session = openSession();

                institucion = (Institucion) session.get(InstitucionImpl.class,
                        primaryKey);

                if (institucion != null) {
                    cacheResult(institucion);
                } else {
                    EntityCacheUtil.putResult(InstitucionModelImpl.ENTITY_CACHE_ENABLED,
                        InstitucionImpl.class, primaryKey, _nullInstitucion);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(InstitucionModelImpl.ENTITY_CACHE_ENABLED,
                    InstitucionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return institucion;
    }

    /**
     * Returns the institucion with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id_institucion the primary key of the institucion
     * @return the institucion, or <code>null</code> if a institucion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Institucion fetchByPrimaryKey(long id_institucion)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id_institucion);
    }

    /**
     * Returns all the institucions.
     *
     * @return the institucions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Institucion> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the institucions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.InstitucionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of institucions
     * @param end the upper bound of the range of institucions (not inclusive)
     * @return the range of institucions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Institucion> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the institucions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.InstitucionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of institucions
     * @param end the upper bound of the range of institucions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of institucions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Institucion> findAll(int start, int end,
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

        List<Institucion> list = (List<Institucion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_INSTITUCION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_INSTITUCION;

                if (pagination) {
                    sql = sql.concat(InstitucionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Institucion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Institucion>(list);
                } else {
                    list = (List<Institucion>) QueryUtil.list(q, getDialect(),
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
     * Removes all the institucions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Institucion institucion : findAll()) {
            remove(institucion);
        }
    }

    /**
     * Returns the number of institucions.
     *
     * @return the number of institucions
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

                Query q = session.createQuery(_SQL_COUNT_INSTITUCION);

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
     * Initializes the institucion persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ec.gob.snap.vuv.model.Institucion")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Institucion>> listenersList = new ArrayList<ModelListener<Institucion>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Institucion>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(InstitucionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
