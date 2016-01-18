package com.gfi.chg.service.base;

import com.gfi.chg.model.Tracing;
import com.gfi.chg.service.TracingLocalService;
import com.gfi.chg.service.persistence.AreaPersistence;
import com.gfi.chg.service.persistence.ContactPersistence;
import com.gfi.chg.service.persistence.TracingPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the tracing local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.gfi.chg.service.impl.TracingLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.gfi.chg.service.impl.TracingLocalServiceImpl
 * @see com.gfi.chg.service.TracingLocalServiceUtil
 * @generated
 */
public abstract class TracingLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements TracingLocalService, IdentifiableBean {
    @BeanReference(type = com.gfi.chg.service.AreaLocalService.class)
    protected com.gfi.chg.service.AreaLocalService areaLocalService;
    @BeanReference(type = AreaPersistence.class)
    protected AreaPersistence areaPersistence;
    @BeanReference(type = com.gfi.chg.service.ContactLocalService.class)
    protected com.gfi.chg.service.ContactLocalService contactLocalService;
    @BeanReference(type = ContactPersistence.class)
    protected ContactPersistence contactPersistence;
    @BeanReference(type = com.gfi.chg.service.TracingLocalService.class)
    protected com.gfi.chg.service.TracingLocalService tracingLocalService;
    @BeanReference(type = TracingPersistence.class)
    protected TracingPersistence tracingPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private TracingLocalServiceClpInvoker _clpInvoker = new TracingLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.gfi.chg.service.TracingLocalServiceUtil} to access the tracing local service.
     */

    /**
     * Adds the tracing to the database. Also notifies the appropriate model listeners.
     *
     * @param tracing the tracing
     * @return the tracing that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Tracing addTracing(Tracing tracing) throws SystemException {
        tracing.setNew(true);

        return tracingPersistence.update(tracing);
    }

    /**
     * Creates a new tracing with the primary key. Does not add the tracing to the database.
     *
     * @param tracingId the primary key for the new tracing
     * @return the new tracing
     */
    @Override
    public Tracing createTracing(long tracingId) {
        return tracingPersistence.create(tracingId);
    }

    /**
     * Deletes the tracing with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param tracingId the primary key of the tracing
     * @return the tracing that was removed
     * @throws PortalException if a tracing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Tracing deleteTracing(long tracingId)
        throws PortalException, SystemException {
        return tracingPersistence.remove(tracingId);
    }

    /**
     * Deletes the tracing from the database. Also notifies the appropriate model listeners.
     *
     * @param tracing the tracing
     * @return the tracing that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Tracing deleteTracing(Tracing tracing) throws SystemException {
        return tracingPersistence.remove(tracing);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Tracing.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return tracingPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.TracingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return tracingPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.TracingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return tracingPersistence.findWithDynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return tracingPersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return tracingPersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    @Override
    public Tracing fetchTracing(long tracingId) throws SystemException {
        return tracingPersistence.fetchByPrimaryKey(tracingId);
    }

    /**
     * Returns the tracing with the primary key.
     *
     * @param tracingId the primary key of the tracing
     * @return the tracing
     * @throws PortalException if a tracing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tracing getTracing(long tracingId)
        throws PortalException, SystemException {
        return tracingPersistence.findByPrimaryKey(tracingId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return tracingPersistence.findByPrimaryKey(primaryKeyObj);
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
    public List<Tracing> getTracings(int start, int end)
        throws SystemException {
        return tracingPersistence.findAll(start, end);
    }

    /**
     * Returns the number of tracings.
     *
     * @return the number of tracings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getTracingsCount() throws SystemException {
        return tracingPersistence.countAll();
    }

    /**
     * Updates the tracing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param tracing the tracing
     * @return the tracing that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Tracing updateTracing(Tracing tracing) throws SystemException {
        return tracingPersistence.update(tracing);
    }

    /**
     * Returns the area local service.
     *
     * @return the area local service
     */
    public com.gfi.chg.service.AreaLocalService getAreaLocalService() {
        return areaLocalService;
    }

    /**
     * Sets the area local service.
     *
     * @param areaLocalService the area local service
     */
    public void setAreaLocalService(
        com.gfi.chg.service.AreaLocalService areaLocalService) {
        this.areaLocalService = areaLocalService;
    }

    /**
     * Returns the area persistence.
     *
     * @return the area persistence
     */
    public AreaPersistence getAreaPersistence() {
        return areaPersistence;
    }

    /**
     * Sets the area persistence.
     *
     * @param areaPersistence the area persistence
     */
    public void setAreaPersistence(AreaPersistence areaPersistence) {
        this.areaPersistence = areaPersistence;
    }

    /**
     * Returns the contact local service.
     *
     * @return the contact local service
     */
    public com.gfi.chg.service.ContactLocalService getContactLocalService() {
        return contactLocalService;
    }

    /**
     * Sets the contact local service.
     *
     * @param contactLocalService the contact local service
     */
    public void setContactLocalService(
        com.gfi.chg.service.ContactLocalService contactLocalService) {
        this.contactLocalService = contactLocalService;
    }

    /**
     * Returns the contact persistence.
     *
     * @return the contact persistence
     */
    public ContactPersistence getContactPersistence() {
        return contactPersistence;
    }

    /**
     * Sets the contact persistence.
     *
     * @param contactPersistence the contact persistence
     */
    public void setContactPersistence(ContactPersistence contactPersistence) {
        this.contactPersistence = contactPersistence;
    }

    /**
     * Returns the tracing local service.
     *
     * @return the tracing local service
     */
    public com.gfi.chg.service.TracingLocalService getTracingLocalService() {
        return tracingLocalService;
    }

    /**
     * Sets the tracing local service.
     *
     * @param tracingLocalService the tracing local service
     */
    public void setTracingLocalService(
        com.gfi.chg.service.TracingLocalService tracingLocalService) {
        this.tracingLocalService = tracingLocalService;
    }

    /**
     * Returns the tracing persistence.
     *
     * @return the tracing persistence
     */
    public TracingPersistence getTracingPersistence() {
        return tracingPersistence;
    }

    /**
     * Sets the tracing persistence.
     *
     * @param tracingPersistence the tracing persistence
     */
    public void setTracingPersistence(TracingPersistence tracingPersistence) {
        this.tracingPersistence = tracingPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.gfi.chg.model.Tracing",
            tracingLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.gfi.chg.model.Tracing");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Tracing.class;
    }

    protected String getModelClassName() {
        return Tracing.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = tracingPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
