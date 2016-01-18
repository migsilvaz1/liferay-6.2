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

import ec.gob.snap.vuv.NoSuchPasoException;
import ec.gob.snap.vuv.model.Paso;
import ec.gob.snap.vuv.model.impl.PasoImpl;
import ec.gob.snap.vuv.model.impl.PasoModelImpl;
import ec.gob.snap.vuv.service.persistence.PasoPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the paso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PasoPersistence
 * @see PasoUtil
 * @generated
 */
public class PasoPersistenceImpl extends BasePersistenceImpl<Paso>
    implements PasoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PasoUtil} to access the paso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PasoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PasoModelImpl.ENTITY_CACHE_ENABLED,
            PasoModelImpl.FINDER_CACHE_ENABLED, PasoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PasoModelImpl.ENTITY_CACHE_ENABLED,
            PasoModelImpl.FINDER_CACHE_ENABLED, PasoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PasoModelImpl.ENTITY_CACHE_ENABLED,
            PasoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_PASO = "SELECT paso FROM Paso paso";
    private static final String _SQL_COUNT_PASO = "SELECT COUNT(paso) FROM Paso paso";
    private static final String _ORDER_BY_ENTITY_ALIAS = "paso.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Paso exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PasoPersistenceImpl.class);
    private static Paso _nullPaso = new PasoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Paso> toCacheModel() {
                return _nullPasoCacheModel;
            }
        };

    private static CacheModel<Paso> _nullPasoCacheModel = new CacheModel<Paso>() {
            @Override
            public Paso toEntityModel() {
                return _nullPaso;
            }
        };

    public PasoPersistenceImpl() {
        setModelClass(Paso.class);
    }

    /**
     * Caches the paso in the entity cache if it is enabled.
     *
     * @param paso the paso
     */
    @Override
    public void cacheResult(Paso paso) {
        EntityCacheUtil.putResult(PasoModelImpl.ENTITY_CACHE_ENABLED,
            PasoImpl.class, paso.getPrimaryKey(), paso);

        paso.resetOriginalValues();
    }

    /**
     * Caches the pasos in the entity cache if it is enabled.
     *
     * @param pasos the pasos
     */
    @Override
    public void cacheResult(List<Paso> pasos) {
        for (Paso paso : pasos) {
            if (EntityCacheUtil.getResult(PasoModelImpl.ENTITY_CACHE_ENABLED,
                        PasoImpl.class, paso.getPrimaryKey()) == null) {
                cacheResult(paso);
            } else {
                paso.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all pasos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PasoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PasoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the paso.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Paso paso) {
        EntityCacheUtil.removeResult(PasoModelImpl.ENTITY_CACHE_ENABLED,
            PasoImpl.class, paso.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Paso> pasos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Paso paso : pasos) {
            EntityCacheUtil.removeResult(PasoModelImpl.ENTITY_CACHE_ENABLED,
                PasoImpl.class, paso.getPrimaryKey());
        }
    }

    /**
     * Creates a new paso with the primary key. Does not add the paso to the database.
     *
     * @param id_paso the primary key for the new paso
     * @return the new paso
     */
    @Override
    public Paso create(long id_paso) {
        Paso paso = new PasoImpl();

        paso.setNew(true);
        paso.setPrimaryKey(id_paso);

        return paso;
    }

    /**
     * Removes the paso with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id_paso the primary key of the paso
     * @return the paso that was removed
     * @throws ec.gob.snap.vuv.NoSuchPasoException if a paso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Paso remove(long id_paso)
        throws NoSuchPasoException, SystemException {
        return remove((Serializable) id_paso);
    }

    /**
     * Removes the paso with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the paso
     * @return the paso that was removed
     * @throws ec.gob.snap.vuv.NoSuchPasoException if a paso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Paso remove(Serializable primaryKey)
        throws NoSuchPasoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Paso paso = (Paso) session.get(PasoImpl.class, primaryKey);

            if (paso == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchPasoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(paso);
        } catch (NoSuchPasoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Paso removeImpl(Paso paso) throws SystemException {
        paso = toUnwrappedModel(paso);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(paso)) {
                paso = (Paso) session.get(PasoImpl.class,
                        paso.getPrimaryKeyObj());
            }

            if (paso != null) {
                session.delete(paso);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (paso != null) {
            clearCache(paso);
        }

        return paso;
    }

    @Override
    public Paso updateImpl(ec.gob.snap.vuv.model.Paso paso)
        throws SystemException {
        paso = toUnwrappedModel(paso);

        boolean isNew = paso.isNew();

        Session session = null;

        try {
            session = openSession();

            if (paso.isNew()) {
                session.save(paso);

                paso.setNew(false);
            } else {
                session.merge(paso);
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

        EntityCacheUtil.putResult(PasoModelImpl.ENTITY_CACHE_ENABLED,
            PasoImpl.class, paso.getPrimaryKey(), paso);

        return paso;
    }

    protected Paso toUnwrappedModel(Paso paso) {
        if (paso instanceof PasoImpl) {
            return paso;
        }

        PasoImpl pasoImpl = new PasoImpl();

        pasoImpl.setNew(paso.isNew());
        pasoImpl.setPrimaryKey(paso.getPrimaryKey());

        pasoImpl.setId_paso(paso.getId_paso());
        pasoImpl.setId_GPR_paso(paso.getId_GPR_paso());
        pasoImpl.setContent(paso.getContent());
        pasoImpl.setTimeStamp(paso.getTimeStamp());
        pasoImpl.setId_caso(paso.getId_caso());

        return pasoImpl;
    }

    /**
     * Returns the paso with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the paso
     * @return the paso
     * @throws ec.gob.snap.vuv.NoSuchPasoException if a paso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Paso findByPrimaryKey(Serializable primaryKey)
        throws NoSuchPasoException, SystemException {
        Paso paso = fetchByPrimaryKey(primaryKey);

        if (paso == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchPasoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return paso;
    }

    /**
     * Returns the paso with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchPasoException} if it could not be found.
     *
     * @param id_paso the primary key of the paso
     * @return the paso
     * @throws ec.gob.snap.vuv.NoSuchPasoException if a paso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Paso findByPrimaryKey(long id_paso)
        throws NoSuchPasoException, SystemException {
        return findByPrimaryKey((Serializable) id_paso);
    }

    /**
     * Returns the paso with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the paso
     * @return the paso, or <code>null</code> if a paso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Paso fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Paso paso = (Paso) EntityCacheUtil.getResult(PasoModelImpl.ENTITY_CACHE_ENABLED,
                PasoImpl.class, primaryKey);

        if (paso == _nullPaso) {
            return null;
        }

        if (paso == null) {
            Session session = null;

            try {
                session = openSession();

                paso = (Paso) session.get(PasoImpl.class, primaryKey);

                if (paso != null) {
                    cacheResult(paso);
                } else {
                    EntityCacheUtil.putResult(PasoModelImpl.ENTITY_CACHE_ENABLED,
                        PasoImpl.class, primaryKey, _nullPaso);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(PasoModelImpl.ENTITY_CACHE_ENABLED,
                    PasoImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return paso;
    }

    /**
     * Returns the paso with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id_paso the primary key of the paso
     * @return the paso, or <code>null</code> if a paso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Paso fetchByPrimaryKey(long id_paso) throws SystemException {
        return fetchByPrimaryKey((Serializable) id_paso);
    }

    /**
     * Returns all the pasos.
     *
     * @return the pasos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Paso> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the pasos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.PasoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of pasos
     * @param end the upper bound of the range of pasos (not inclusive)
     * @return the range of pasos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Paso> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the pasos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.PasoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of pasos
     * @param end the upper bound of the range of pasos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of pasos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Paso> findAll(int start, int end,
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

        List<Paso> list = (List<Paso>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PASO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PASO;

                if (pagination) {
                    sql = sql.concat(PasoModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Paso>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Paso>(list);
                } else {
                    list = (List<Paso>) QueryUtil.list(q, getDialect(), start,
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
     * Removes all the pasos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Paso paso : findAll()) {
            remove(paso);
        }
    }

    /**
     * Returns the number of pasos.
     *
     * @return the number of pasos
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

                Query q = session.createQuery(_SQL_COUNT_PASO);

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
     * Initializes the paso persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ec.gob.snap.vuv.model.Paso")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Paso>> listenersList = new ArrayList<ModelListener<Paso>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Paso>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PasoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
