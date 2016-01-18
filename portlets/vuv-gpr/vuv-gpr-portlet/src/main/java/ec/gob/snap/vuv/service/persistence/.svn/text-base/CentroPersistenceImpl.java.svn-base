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

import ec.gob.snap.vuv.NoSuchCentroException;
import ec.gob.snap.vuv.model.Centro;
import ec.gob.snap.vuv.model.impl.CentroImpl;
import ec.gob.snap.vuv.model.impl.CentroModelImpl;
import ec.gob.snap.vuv.service.persistence.CentroPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the centro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CentroPersistence
 * @see CentroUtil
 * @generated
 */
public class CentroPersistenceImpl extends BasePersistenceImpl<Centro>
    implements CentroPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CentroUtil} to access the centro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CentroImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CentroModelImpl.ENTITY_CACHE_ENABLED,
            CentroModelImpl.FINDER_CACHE_ENABLED, CentroImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CentroModelImpl.ENTITY_CACHE_ENABLED,
            CentroModelImpl.FINDER_CACHE_ENABLED, CentroImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CentroModelImpl.ENTITY_CACHE_ENABLED,
            CentroModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_CENTRO = "SELECT centro FROM Centro centro";
    private static final String _SQL_COUNT_CENTRO = "SELECT COUNT(centro) FROM Centro centro";
    private static final String _ORDER_BY_ENTITY_ALIAS = "centro.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Centro exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CentroPersistenceImpl.class);
    private static Centro _nullCentro = new CentroImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Centro> toCacheModel() {
                return _nullCentroCacheModel;
            }
        };

    private static CacheModel<Centro> _nullCentroCacheModel = new CacheModel<Centro>() {
            @Override
            public Centro toEntityModel() {
                return _nullCentro;
            }
        };

    public CentroPersistenceImpl() {
        setModelClass(Centro.class);
    }

    /**
     * Caches the centro in the entity cache if it is enabled.
     *
     * @param centro the centro
     */
    @Override
    public void cacheResult(Centro centro) {
        EntityCacheUtil.putResult(CentroModelImpl.ENTITY_CACHE_ENABLED,
            CentroImpl.class, centro.getPrimaryKey(), centro);

        centro.resetOriginalValues();
    }

    /**
     * Caches the centros in the entity cache if it is enabled.
     *
     * @param centros the centros
     */
    @Override
    public void cacheResult(List<Centro> centros) {
        for (Centro centro : centros) {
            if (EntityCacheUtil.getResult(
                        CentroModelImpl.ENTITY_CACHE_ENABLED, CentroImpl.class,
                        centro.getPrimaryKey()) == null) {
                cacheResult(centro);
            } else {
                centro.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all centros.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CentroImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CentroImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the centro.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Centro centro) {
        EntityCacheUtil.removeResult(CentroModelImpl.ENTITY_CACHE_ENABLED,
            CentroImpl.class, centro.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Centro> centros) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Centro centro : centros) {
            EntityCacheUtil.removeResult(CentroModelImpl.ENTITY_CACHE_ENABLED,
                CentroImpl.class, centro.getPrimaryKey());
        }
    }

    /**
     * Creates a new centro with the primary key. Does not add the centro to the database.
     *
     * @param id_centro the primary key for the new centro
     * @return the new centro
     */
    @Override
    public Centro create(long id_centro) {
        Centro centro = new CentroImpl();

        centro.setNew(true);
        centro.setPrimaryKey(id_centro);

        return centro;
    }

    /**
     * Removes the centro with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id_centro the primary key of the centro
     * @return the centro that was removed
     * @throws ec.gob.snap.vuv.NoSuchCentroException if a centro with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Centro remove(long id_centro)
        throws NoSuchCentroException, SystemException {
        return remove((Serializable) id_centro);
    }

    /**
     * Removes the centro with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the centro
     * @return the centro that was removed
     * @throws ec.gob.snap.vuv.NoSuchCentroException if a centro with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Centro remove(Serializable primaryKey)
        throws NoSuchCentroException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Centro centro = (Centro) session.get(CentroImpl.class, primaryKey);

            if (centro == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCentroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(centro);
        } catch (NoSuchCentroException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Centro removeImpl(Centro centro) throws SystemException {
        centro = toUnwrappedModel(centro);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(centro)) {
                centro = (Centro) session.get(CentroImpl.class,
                        centro.getPrimaryKeyObj());
            }

            if (centro != null) {
                session.delete(centro);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (centro != null) {
            clearCache(centro);
        }

        return centro;
    }

    @Override
    public Centro updateImpl(ec.gob.snap.vuv.model.Centro centro)
        throws SystemException {
        centro = toUnwrappedModel(centro);

        boolean isNew = centro.isNew();

        Session session = null;

        try {
            session = openSession();

            if (centro.isNew()) {
                session.save(centro);

                centro.setNew(false);
            } else {
                session.merge(centro);
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

        EntityCacheUtil.putResult(CentroModelImpl.ENTITY_CACHE_ENABLED,
            CentroImpl.class, centro.getPrimaryKey(), centro);

        return centro;
    }

    protected Centro toUnwrappedModel(Centro centro) {
        if (centro instanceof CentroImpl) {
            return centro;
        }

        CentroImpl centroImpl = new CentroImpl();

        centroImpl.setNew(centro.isNew());
        centroImpl.setPrimaryKey(centro.getPrimaryKey());

        centroImpl.setId_centro(centro.getId_centro());
        centroImpl.setId_GPR_centro(centro.getId_GPR_centro());
        centroImpl.setContent(centro.getContent());
        centroImpl.setTimeStamp(centro.getTimeStamp());
        centroImpl.setId_caso(centro.getId_caso());

        return centroImpl;
    }

    /**
     * Returns the centro with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the centro
     * @return the centro
     * @throws ec.gob.snap.vuv.NoSuchCentroException if a centro with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Centro findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCentroException, SystemException {
        Centro centro = fetchByPrimaryKey(primaryKey);

        if (centro == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCentroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return centro;
    }

    /**
     * Returns the centro with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchCentroException} if it could not be found.
     *
     * @param id_centro the primary key of the centro
     * @return the centro
     * @throws ec.gob.snap.vuv.NoSuchCentroException if a centro with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Centro findByPrimaryKey(long id_centro)
        throws NoSuchCentroException, SystemException {
        return findByPrimaryKey((Serializable) id_centro);
    }

    /**
     * Returns the centro with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the centro
     * @return the centro, or <code>null</code> if a centro with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Centro fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Centro centro = (Centro) EntityCacheUtil.getResult(CentroModelImpl.ENTITY_CACHE_ENABLED,
                CentroImpl.class, primaryKey);

        if (centro == _nullCentro) {
            return null;
        }

        if (centro == null) {
            Session session = null;

            try {
                session = openSession();

                centro = (Centro) session.get(CentroImpl.class, primaryKey);

                if (centro != null) {
                    cacheResult(centro);
                } else {
                    EntityCacheUtil.putResult(CentroModelImpl.ENTITY_CACHE_ENABLED,
                        CentroImpl.class, primaryKey, _nullCentro);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(CentroModelImpl.ENTITY_CACHE_ENABLED,
                    CentroImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return centro;
    }

    /**
     * Returns the centro with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id_centro the primary key of the centro
     * @return the centro, or <code>null</code> if a centro with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Centro fetchByPrimaryKey(long id_centro) throws SystemException {
        return fetchByPrimaryKey((Serializable) id_centro);
    }

    /**
     * Returns all the centros.
     *
     * @return the centros
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Centro> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the centros.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.CentroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of centros
     * @param end the upper bound of the range of centros (not inclusive)
     * @return the range of centros
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Centro> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the centros.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.CentroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of centros
     * @param end the upper bound of the range of centros (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of centros
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Centro> findAll(int start, int end,
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

        List<Centro> list = (List<Centro>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CENTRO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CENTRO;

                if (pagination) {
                    sql = sql.concat(CentroModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Centro>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Centro>(list);
                } else {
                    list = (List<Centro>) QueryUtil.list(q, getDialect(),
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
     * Removes all the centros from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Centro centro : findAll()) {
            remove(centro);
        }
    }

    /**
     * Returns the number of centros.
     *
     * @return the number of centros
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

                Query q = session.createQuery(_SQL_COUNT_CENTRO);

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
     * Initializes the centro persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ec.gob.snap.vuv.model.Centro")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Centro>> listenersList = new ArrayList<ModelListener<Centro>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Centro>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CentroImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
