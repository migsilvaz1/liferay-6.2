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

import ec.gob.snap.vuv.NoSuchServicioException;
import ec.gob.snap.vuv.model.Servicio;
import ec.gob.snap.vuv.model.impl.ServicioImpl;
import ec.gob.snap.vuv.model.impl.ServicioModelImpl;
import ec.gob.snap.vuv.service.persistence.ServicioPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the servicio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServicioPersistence
 * @see ServicioUtil
 * @generated
 */
public class ServicioPersistenceImpl extends BasePersistenceImpl<Servicio>
    implements ServicioPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ServicioUtil} to access the servicio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ServicioImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServicioModelImpl.ENTITY_CACHE_ENABLED,
            ServicioModelImpl.FINDER_CACHE_ENABLED, ServicioImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServicioModelImpl.ENTITY_CACHE_ENABLED,
            ServicioModelImpl.FINDER_CACHE_ENABLED, ServicioImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServicioModelImpl.ENTITY_CACHE_ENABLED,
            ServicioModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_SERVICIO = "SELECT servicio FROM Servicio servicio";
    private static final String _SQL_COUNT_SERVICIO = "SELECT COUNT(servicio) FROM Servicio servicio";
    private static final String _ORDER_BY_ENTITY_ALIAS = "servicio.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Servicio exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ServicioPersistenceImpl.class);
    private static Servicio _nullServicio = new ServicioImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Servicio> toCacheModel() {
                return _nullServicioCacheModel;
            }
        };

    private static CacheModel<Servicio> _nullServicioCacheModel = new CacheModel<Servicio>() {
            @Override
            public Servicio toEntityModel() {
                return _nullServicio;
            }
        };

    public ServicioPersistenceImpl() {
        setModelClass(Servicio.class);
    }

    /**
     * Caches the servicio in the entity cache if it is enabled.
     *
     * @param servicio the servicio
     */
    @Override
    public void cacheResult(Servicio servicio) {
        EntityCacheUtil.putResult(ServicioModelImpl.ENTITY_CACHE_ENABLED,
            ServicioImpl.class, servicio.getPrimaryKey(), servicio);

        servicio.resetOriginalValues();
    }

    /**
     * Caches the servicios in the entity cache if it is enabled.
     *
     * @param servicios the servicios
     */
    @Override
    public void cacheResult(List<Servicio> servicios) {
        for (Servicio servicio : servicios) {
            if (EntityCacheUtil.getResult(
                        ServicioModelImpl.ENTITY_CACHE_ENABLED,
                        ServicioImpl.class, servicio.getPrimaryKey()) == null) {
                cacheResult(servicio);
            } else {
                servicio.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all servicios.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ServicioImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ServicioImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the servicio.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Servicio servicio) {
        EntityCacheUtil.removeResult(ServicioModelImpl.ENTITY_CACHE_ENABLED,
            ServicioImpl.class, servicio.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Servicio> servicios) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Servicio servicio : servicios) {
            EntityCacheUtil.removeResult(ServicioModelImpl.ENTITY_CACHE_ENABLED,
                ServicioImpl.class, servicio.getPrimaryKey());
        }
    }

    /**
     * Creates a new servicio with the primary key. Does not add the servicio to the database.
     *
     * @param id_servicio the primary key for the new servicio
     * @return the new servicio
     */
    @Override
    public Servicio create(long id_servicio) {
        Servicio servicio = new ServicioImpl();

        servicio.setNew(true);
        servicio.setPrimaryKey(id_servicio);

        return servicio;
    }

    /**
     * Removes the servicio with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id_servicio the primary key of the servicio
     * @return the servicio that was removed
     * @throws ec.gob.snap.vuv.NoSuchServicioException if a servicio with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Servicio remove(long id_servicio)
        throws NoSuchServicioException, SystemException {
        return remove((Serializable) id_servicio);
    }

    /**
     * Removes the servicio with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the servicio
     * @return the servicio that was removed
     * @throws ec.gob.snap.vuv.NoSuchServicioException if a servicio with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Servicio remove(Serializable primaryKey)
        throws NoSuchServicioException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Servicio servicio = (Servicio) session.get(ServicioImpl.class,
                    primaryKey);

            if (servicio == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchServicioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(servicio);
        } catch (NoSuchServicioException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Servicio removeImpl(Servicio servicio) throws SystemException {
        servicio = toUnwrappedModel(servicio);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(servicio)) {
                servicio = (Servicio) session.get(ServicioImpl.class,
                        servicio.getPrimaryKeyObj());
            }

            if (servicio != null) {
                session.delete(servicio);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (servicio != null) {
            clearCache(servicio);
        }

        return servicio;
    }

    @Override
    public Servicio updateImpl(ec.gob.snap.vuv.model.Servicio servicio)
        throws SystemException {
        servicio = toUnwrappedModel(servicio);

        boolean isNew = servicio.isNew();

        Session session = null;

        try {
            session = openSession();

            if (servicio.isNew()) {
                session.save(servicio);

                servicio.setNew(false);
            } else {
                session.merge(servicio);
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

        EntityCacheUtil.putResult(ServicioModelImpl.ENTITY_CACHE_ENABLED,
            ServicioImpl.class, servicio.getPrimaryKey(), servicio);

        return servicio;
    }

    protected Servicio toUnwrappedModel(Servicio servicio) {
        if (servicio instanceof ServicioImpl) {
            return servicio;
        }

        ServicioImpl servicioImpl = new ServicioImpl();

        servicioImpl.setNew(servicio.isNew());
        servicioImpl.setPrimaryKey(servicio.getPrimaryKey());

        servicioImpl.setId_GPR_servicio(servicio.getId_GPR_servicio());
        servicioImpl.setContent(servicio.getContent());
        servicioImpl.setTimeStamp(servicio.getTimeStamp());
        servicioImpl.setId_servicio(servicio.getId_servicio());
        servicioImpl.setId_institucion(servicio.getId_institucion());

        return servicioImpl;
    }

    /**
     * Returns the servicio with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the servicio
     * @return the servicio
     * @throws ec.gob.snap.vuv.NoSuchServicioException if a servicio with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Servicio findByPrimaryKey(Serializable primaryKey)
        throws NoSuchServicioException, SystemException {
        Servicio servicio = fetchByPrimaryKey(primaryKey);

        if (servicio == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchServicioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return servicio;
    }

    /**
     * Returns the servicio with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchServicioException} if it could not be found.
     *
     * @param id_servicio the primary key of the servicio
     * @return the servicio
     * @throws ec.gob.snap.vuv.NoSuchServicioException if a servicio with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Servicio findByPrimaryKey(long id_servicio)
        throws NoSuchServicioException, SystemException {
        return findByPrimaryKey((Serializable) id_servicio);
    }

    /**
     * Returns the servicio with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the servicio
     * @return the servicio, or <code>null</code> if a servicio with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Servicio fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Servicio servicio = (Servicio) EntityCacheUtil.getResult(ServicioModelImpl.ENTITY_CACHE_ENABLED,
                ServicioImpl.class, primaryKey);

        if (servicio == _nullServicio) {
            return null;
        }

        if (servicio == null) {
            Session session = null;

            try {
                session = openSession();

                servicio = (Servicio) session.get(ServicioImpl.class, primaryKey);

                if (servicio != null) {
                    cacheResult(servicio);
                } else {
                    EntityCacheUtil.putResult(ServicioModelImpl.ENTITY_CACHE_ENABLED,
                        ServicioImpl.class, primaryKey, _nullServicio);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ServicioModelImpl.ENTITY_CACHE_ENABLED,
                    ServicioImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return servicio;
    }

    /**
     * Returns the servicio with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id_servicio the primary key of the servicio
     * @return the servicio, or <code>null</code> if a servicio with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Servicio fetchByPrimaryKey(long id_servicio)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id_servicio);
    }

    /**
     * Returns all the servicios.
     *
     * @return the servicios
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Servicio> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the servicios.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.ServicioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of servicios
     * @param end the upper bound of the range of servicios (not inclusive)
     * @return the range of servicios
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Servicio> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the servicios.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.ServicioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of servicios
     * @param end the upper bound of the range of servicios (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of servicios
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Servicio> findAll(int start, int end,
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

        List<Servicio> list = (List<Servicio>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SERVICIO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SERVICIO;

                if (pagination) {
                    sql = sql.concat(ServicioModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Servicio>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Servicio>(list);
                } else {
                    list = (List<Servicio>) QueryUtil.list(q, getDialect(),
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
     * Removes all the servicios from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Servicio servicio : findAll()) {
            remove(servicio);
        }
    }

    /**
     * Returns the number of servicios.
     *
     * @return the number of servicios
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

                Query q = session.createQuery(_SQL_COUNT_SERVICIO);

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
     * Initializes the servicio persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ec.gob.snap.vuv.model.Servicio")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Servicio>> listenersList = new ArrayList<ModelListener<Servicio>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Servicio>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ServicioImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
