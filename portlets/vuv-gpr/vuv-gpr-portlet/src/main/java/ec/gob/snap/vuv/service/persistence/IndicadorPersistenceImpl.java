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

import ec.gob.snap.vuv.NoSuchIndicadorException;
import ec.gob.snap.vuv.model.Indicador;
import ec.gob.snap.vuv.model.impl.IndicadorImpl;
import ec.gob.snap.vuv.model.impl.IndicadorModelImpl;
import ec.gob.snap.vuv.service.persistence.IndicadorPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the indicador service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IndicadorPersistence
 * @see IndicadorUtil
 * @generated
 */
public class IndicadorPersistenceImpl extends BasePersistenceImpl<Indicador>
    implements IndicadorPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link IndicadorUtil} to access the indicador persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = IndicadorImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IndicadorModelImpl.ENTITY_CACHE_ENABLED,
            IndicadorModelImpl.FINDER_CACHE_ENABLED, IndicadorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IndicadorModelImpl.ENTITY_CACHE_ENABLED,
            IndicadorModelImpl.FINDER_CACHE_ENABLED, IndicadorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IndicadorModelImpl.ENTITY_CACHE_ENABLED,
            IndicadorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_INDICADOR = "SELECT indicador FROM Indicador indicador";
    private static final String _SQL_COUNT_INDICADOR = "SELECT COUNT(indicador) FROM Indicador indicador";
    private static final String _ORDER_BY_ENTITY_ALIAS = "indicador.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Indicador exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(IndicadorPersistenceImpl.class);
    private static Indicador _nullIndicador = new IndicadorImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Indicador> toCacheModel() {
                return _nullIndicadorCacheModel;
            }
        };

    private static CacheModel<Indicador> _nullIndicadorCacheModel = new CacheModel<Indicador>() {
            @Override
            public Indicador toEntityModel() {
                return _nullIndicador;
            }
        };

    public IndicadorPersistenceImpl() {
        setModelClass(Indicador.class);
    }

    /**
     * Caches the indicador in the entity cache if it is enabled.
     *
     * @param indicador the indicador
     */
    @Override
    public void cacheResult(Indicador indicador) {
        EntityCacheUtil.putResult(IndicadorModelImpl.ENTITY_CACHE_ENABLED,
            IndicadorImpl.class, indicador.getPrimaryKey(), indicador);

        indicador.resetOriginalValues();
    }

    /**
     * Caches the indicadors in the entity cache if it is enabled.
     *
     * @param indicadors the indicadors
     */
    @Override
    public void cacheResult(List<Indicador> indicadors) {
        for (Indicador indicador : indicadors) {
            if (EntityCacheUtil.getResult(
                        IndicadorModelImpl.ENTITY_CACHE_ENABLED,
                        IndicadorImpl.class, indicador.getPrimaryKey()) == null) {
                cacheResult(indicador);
            } else {
                indicador.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all indicadors.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(IndicadorImpl.class.getName());
        }

        EntityCacheUtil.clearCache(IndicadorImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the indicador.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Indicador indicador) {
        EntityCacheUtil.removeResult(IndicadorModelImpl.ENTITY_CACHE_ENABLED,
            IndicadorImpl.class, indicador.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Indicador> indicadors) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Indicador indicador : indicadors) {
            EntityCacheUtil.removeResult(IndicadorModelImpl.ENTITY_CACHE_ENABLED,
                IndicadorImpl.class, indicador.getPrimaryKey());
        }
    }

    /**
     * Creates a new indicador with the primary key. Does not add the indicador to the database.
     *
     * @param id_indicador the primary key for the new indicador
     * @return the new indicador
     */
    @Override
    public Indicador create(long id_indicador) {
        Indicador indicador = new IndicadorImpl();

        indicador.setNew(true);
        indicador.setPrimaryKey(id_indicador);

        return indicador;
    }

    /**
     * Removes the indicador with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id_indicador the primary key of the indicador
     * @return the indicador that was removed
     * @throws ec.gob.snap.vuv.NoSuchIndicadorException if a indicador with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Indicador remove(long id_indicador)
        throws NoSuchIndicadorException, SystemException {
        return remove((Serializable) id_indicador);
    }

    /**
     * Removes the indicador with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the indicador
     * @return the indicador that was removed
     * @throws ec.gob.snap.vuv.NoSuchIndicadorException if a indicador with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Indicador remove(Serializable primaryKey)
        throws NoSuchIndicadorException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Indicador indicador = (Indicador) session.get(IndicadorImpl.class,
                    primaryKey);

            if (indicador == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchIndicadorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(indicador);
        } catch (NoSuchIndicadorException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Indicador removeImpl(Indicador indicador)
        throws SystemException {
        indicador = toUnwrappedModel(indicador);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(indicador)) {
                indicador = (Indicador) session.get(IndicadorImpl.class,
                        indicador.getPrimaryKeyObj());
            }

            if (indicador != null) {
                session.delete(indicador);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (indicador != null) {
            clearCache(indicador);
        }

        return indicador;
    }

    @Override
    public Indicador updateImpl(ec.gob.snap.vuv.model.Indicador indicador)
        throws SystemException {
        indicador = toUnwrappedModel(indicador);

        boolean isNew = indicador.isNew();

        Session session = null;

        try {
            session = openSession();

            if (indicador.isNew()) {
                session.save(indicador);

                indicador.setNew(false);
            } else {
                session.merge(indicador);
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

        EntityCacheUtil.putResult(IndicadorModelImpl.ENTITY_CACHE_ENABLED,
            IndicadorImpl.class, indicador.getPrimaryKey(), indicador);

        return indicador;
    }

    protected Indicador toUnwrappedModel(Indicador indicador) {
        if (indicador instanceof IndicadorImpl) {
            return indicador;
        }

        IndicadorImpl indicadorImpl = new IndicadorImpl();

        indicadorImpl.setNew(indicador.isNew());
        indicadorImpl.setPrimaryKey(indicador.getPrimaryKey());

        indicadorImpl.setId_indicador(indicador.getId_indicador());
        indicadorImpl.setId_GPR_indicador(indicador.getId_GPR_indicador());
        indicadorImpl.setContent(indicador.getContent());
        indicadorImpl.setTimeStamp(indicador.getTimeStamp());
        indicadorImpl.setId_servicio(indicador.getId_servicio());

        return indicadorImpl;
    }

    /**
     * Returns the indicador with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the indicador
     * @return the indicador
     * @throws ec.gob.snap.vuv.NoSuchIndicadorException if a indicador with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Indicador findByPrimaryKey(Serializable primaryKey)
        throws NoSuchIndicadorException, SystemException {
        Indicador indicador = fetchByPrimaryKey(primaryKey);

        if (indicador == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchIndicadorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return indicador;
    }

    /**
     * Returns the indicador with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchIndicadorException} if it could not be found.
     *
     * @param id_indicador the primary key of the indicador
     * @return the indicador
     * @throws ec.gob.snap.vuv.NoSuchIndicadorException if a indicador with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Indicador findByPrimaryKey(long id_indicador)
        throws NoSuchIndicadorException, SystemException {
        return findByPrimaryKey((Serializable) id_indicador);
    }

    /**
     * Returns the indicador with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the indicador
     * @return the indicador, or <code>null</code> if a indicador with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Indicador fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Indicador indicador = (Indicador) EntityCacheUtil.getResult(IndicadorModelImpl.ENTITY_CACHE_ENABLED,
                IndicadorImpl.class, primaryKey);

        if (indicador == _nullIndicador) {
            return null;
        }

        if (indicador == null) {
            Session session = null;

            try {
                session = openSession();

                indicador = (Indicador) session.get(IndicadorImpl.class,
                        primaryKey);

                if (indicador != null) {
                    cacheResult(indicador);
                } else {
                    EntityCacheUtil.putResult(IndicadorModelImpl.ENTITY_CACHE_ENABLED,
                        IndicadorImpl.class, primaryKey, _nullIndicador);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(IndicadorModelImpl.ENTITY_CACHE_ENABLED,
                    IndicadorImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return indicador;
    }

    /**
     * Returns the indicador with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id_indicador the primary key of the indicador
     * @return the indicador, or <code>null</code> if a indicador with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Indicador fetchByPrimaryKey(long id_indicador)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id_indicador);
    }

    /**
     * Returns all the indicadors.
     *
     * @return the indicadors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Indicador> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the indicadors.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.IndicadorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of indicadors
     * @param end the upper bound of the range of indicadors (not inclusive)
     * @return the range of indicadors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Indicador> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the indicadors.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.IndicadorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of indicadors
     * @param end the upper bound of the range of indicadors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of indicadors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Indicador> findAll(int start, int end,
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

        List<Indicador> list = (List<Indicador>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_INDICADOR);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_INDICADOR;

                if (pagination) {
                    sql = sql.concat(IndicadorModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Indicador>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Indicador>(list);
                } else {
                    list = (List<Indicador>) QueryUtil.list(q, getDialect(),
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
     * Removes all the indicadors from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Indicador indicador : findAll()) {
            remove(indicador);
        }
    }

    /**
     * Returns the number of indicadors.
     *
     * @return the number of indicadors
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

                Query q = session.createQuery(_SQL_COUNT_INDICADOR);

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
     * Initializes the indicador persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ec.gob.snap.vuv.model.Indicador")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Indicador>> listenersList = new ArrayList<ModelListener<Indicador>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Indicador>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(IndicadorImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
