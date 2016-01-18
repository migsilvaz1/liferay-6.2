package com.gfi.chg.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AreaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AreaLocalService
 * @generated
 */
public class AreaLocalServiceWrapper implements AreaLocalService,
    ServiceWrapper<AreaLocalService> {
    private AreaLocalService _areaLocalService;

    public AreaLocalServiceWrapper(AreaLocalService areaLocalService) {
        _areaLocalService = areaLocalService;
    }

    /**
    * Adds the area to the database. Also notifies the appropriate model listeners.
    *
    * @param area the area
    * @return the area that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.gfi.chg.model.Area addArea(com.gfi.chg.model.Area area)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _areaLocalService.addArea(area);
    }

    /**
    * Creates a new area with the primary key. Does not add the area to the database.
    *
    * @param areaId the primary key for the new area
    * @return the new area
    */
    @Override
    public com.gfi.chg.model.Area createArea(long areaId) {
        return _areaLocalService.createArea(areaId);
    }

    /**
    * Deletes the area with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param areaId the primary key of the area
    * @return the area that was removed
    * @throws PortalException if a area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.gfi.chg.model.Area deleteArea(long areaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _areaLocalService.deleteArea(areaId);
    }

    /**
    * Deletes the area from the database. Also notifies the appropriate model listeners.
    *
    * @param area the area
    * @return the area that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.gfi.chg.model.Area deleteArea(com.gfi.chg.model.Area area)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _areaLocalService.deleteArea(area);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _areaLocalService.dynamicQuery();
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
        return _areaLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _areaLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _areaLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _areaLocalService.dynamicQueryCount(dynamicQuery);
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
        return _areaLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.gfi.chg.model.Area fetchArea(long areaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _areaLocalService.fetchArea(areaId);
    }

    /**
    * Returns the area with the primary key.
    *
    * @param areaId the primary key of the area
    * @return the area
    * @throws PortalException if a area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.gfi.chg.model.Area getArea(long areaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _areaLocalService.getArea(areaId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _areaLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the areas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of areas
    * @param end the upper bound of the range of areas (not inclusive)
    * @return the range of areas
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.gfi.chg.model.Area> getAreas(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _areaLocalService.getAreas(start, end);
    }

    /**
    * Returns the number of areas.
    *
    * @return the number of areas
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAreasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _areaLocalService.getAreasCount();
    }

    /**
    * Updates the area in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param area the area
    * @return the area that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.gfi.chg.model.Area updateArea(com.gfi.chg.model.Area area)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _areaLocalService.updateArea(area);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _areaLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _areaLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _areaLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.gfi.chg.model.Area> findByAreaId(long areaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _areaLocalService.findByAreaId(areaId);
    }

    @Override
    public com.gfi.chg.model.Area findByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _areaLocalService.findByName(name);
    }

    @Override
    public java.util.List<com.gfi.chg.model.Area> findByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _areaLocalService.findByUserId(userId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AreaLocalService getWrappedAreaLocalService() {
        return _areaLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAreaLocalService(AreaLocalService areaLocalService) {
        _areaLocalService = areaLocalService;
    }

    @Override
    public AreaLocalService getWrappedService() {
        return _areaLocalService;
    }

    @Override
    public void setWrappedService(AreaLocalService areaLocalService) {
        _areaLocalService = areaLocalService;
    }
}
