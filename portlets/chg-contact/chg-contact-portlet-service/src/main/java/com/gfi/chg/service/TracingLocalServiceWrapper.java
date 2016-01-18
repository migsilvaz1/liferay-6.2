package com.gfi.chg.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TracingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TracingLocalService
 * @generated
 */
public class TracingLocalServiceWrapper implements TracingLocalService,
    ServiceWrapper<TracingLocalService> {
    private TracingLocalService _tracingLocalService;

    public TracingLocalServiceWrapper(TracingLocalService tracingLocalService) {
        _tracingLocalService = tracingLocalService;
    }

    /**
    * Adds the tracing to the database. Also notifies the appropriate model listeners.
    *
    * @param tracing the tracing
    * @return the tracing that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.gfi.chg.model.Tracing addTracing(
        com.gfi.chg.model.Tracing tracing)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.addTracing(tracing);
    }

    /**
    * Creates a new tracing with the primary key. Does not add the tracing to the database.
    *
    * @param tracingId the primary key for the new tracing
    * @return the new tracing
    */
    @Override
    public com.gfi.chg.model.Tracing createTracing(long tracingId) {
        return _tracingLocalService.createTracing(tracingId);
    }

    /**
    * Deletes the tracing with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param tracingId the primary key of the tracing
    * @return the tracing that was removed
    * @throws PortalException if a tracing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.gfi.chg.model.Tracing deleteTracing(long tracingId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.deleteTracing(tracingId);
    }

    /**
    * Deletes the tracing from the database. Also notifies the appropriate model listeners.
    *
    * @param tracing the tracing
    * @return the tracing that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.gfi.chg.model.Tracing deleteTracing(
        com.gfi.chg.model.Tracing tracing)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.deleteTracing(tracing);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _tracingLocalService.dynamicQuery();
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.dynamicQuery(dynamicQuery);
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.dynamicQuery(dynamicQuery, start, end);
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.dynamicQueryCount(dynamicQuery);
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
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.gfi.chg.model.Tracing fetchTracing(long tracingId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.fetchTracing(tracingId);
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
    public com.gfi.chg.model.Tracing getTracing(long tracingId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.getTracing(tracingId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<com.gfi.chg.model.Tracing> getTracings(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.getTracings(start, end);
    }

    /**
    * Returns the number of tracings.
    *
    * @return the number of tracings
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getTracingsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.getTracingsCount();
    }

    /**
    * Updates the tracing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param tracing the tracing
    * @return the tracing that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.gfi.chg.model.Tracing updateTracing(
        com.gfi.chg.model.Tracing tracing)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.updateTracing(tracing);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _tracingLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _tracingLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _tracingLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.gfi.chg.model.Tracing> findByAreaId(long areaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.findByAreaId(areaId);
    }

    @Override
    public java.util.List<com.gfi.chg.model.Tracing> findByContactId(
        long contactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tracingLocalService.findByContactId(contactId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TracingLocalService getWrappedTracingLocalService() {
        return _tracingLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTracingLocalService(
        TracingLocalService tracingLocalService) {
        _tracingLocalService = tracingLocalService;
    }

    @Override
    public TracingLocalService getWrappedService() {
        return _tracingLocalService;
    }

    @Override
    public void setWrappedService(TracingLocalService tracingLocalService) {
        _tracingLocalService = tracingLocalService;
    }
}
