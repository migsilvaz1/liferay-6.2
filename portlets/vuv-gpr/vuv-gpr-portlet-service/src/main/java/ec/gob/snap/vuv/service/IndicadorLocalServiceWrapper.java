package ec.gob.snap.vuv.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IndicadorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see IndicadorLocalService
 * @generated
 */
public class IndicadorLocalServiceWrapper implements IndicadorLocalService,
    ServiceWrapper<IndicadorLocalService> {
    private IndicadorLocalService _indicadorLocalService;

    public IndicadorLocalServiceWrapper(
        IndicadorLocalService indicadorLocalService) {
        _indicadorLocalService = indicadorLocalService;
    }

    /**
    * Adds the indicador to the database. Also notifies the appropriate model listeners.
    *
    * @param indicador the indicador
    * @return the indicador that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Indicador addIndicador(
        ec.gob.snap.vuv.model.Indicador indicador)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _indicadorLocalService.addIndicador(indicador);
    }

    /**
    * Creates a new indicador with the primary key. Does not add the indicador to the database.
    *
    * @param id_indicador the primary key for the new indicador
    * @return the new indicador
    */
    @Override
    public ec.gob.snap.vuv.model.Indicador createIndicador(long id_indicador) {
        return _indicadorLocalService.createIndicador(id_indicador);
    }

    /**
    * Deletes the indicador with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_indicador the primary key of the indicador
    * @return the indicador that was removed
    * @throws PortalException if a indicador with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Indicador deleteIndicador(long id_indicador)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _indicadorLocalService.deleteIndicador(id_indicador);
    }

    /**
    * Deletes the indicador from the database. Also notifies the appropriate model listeners.
    *
    * @param indicador the indicador
    * @return the indicador that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Indicador deleteIndicador(
        ec.gob.snap.vuv.model.Indicador indicador)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _indicadorLocalService.deleteIndicador(indicador);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _indicadorLocalService.dynamicQuery();
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
        return _indicadorLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.IndicadorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _indicadorLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.IndicadorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _indicadorLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _indicadorLocalService.dynamicQueryCount(dynamicQuery);
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
        return _indicadorLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public ec.gob.snap.vuv.model.Indicador fetchIndicador(long id_indicador)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _indicadorLocalService.fetchIndicador(id_indicador);
    }

    /**
    * Returns the indicador with the primary key.
    *
    * @param id_indicador the primary key of the indicador
    * @return the indicador
    * @throws PortalException if a indicador with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Indicador getIndicador(long id_indicador)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _indicadorLocalService.getIndicador(id_indicador);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _indicadorLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<ec.gob.snap.vuv.model.Indicador> getIndicadors(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _indicadorLocalService.getIndicadors(start, end);
    }

    /**
    * Returns the number of indicadors.
    *
    * @return the number of indicadors
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getIndicadorsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _indicadorLocalService.getIndicadorsCount();
    }

    /**
    * Updates the indicador in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param indicador the indicador
    * @return the indicador that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Indicador updateIndicador(
        ec.gob.snap.vuv.model.Indicador indicador)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _indicadorLocalService.updateIndicador(indicador);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _indicadorLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _indicadorLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _indicadorLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public ec.gob.snap.vuv.model.Indicador addIndicador(long gprId,
        long content, java.util.Date timeStamp) {
        return _indicadorLocalService.addIndicador(gprId, content, timeStamp);
    }

    @Override
    public ec.gob.snap.vuv.model.Indicador addIndicador(long gprId,
        long content, java.util.Date timeStamp, long idServicio) {
        return _indicadorLocalService.addIndicador(gprId, content, timeStamp,
            idServicio);
    }

    @Override
    public java.util.List<ec.gob.snap.vuv.model.Indicador> getAllIndicadores() {
        return _indicadorLocalService.getAllIndicadores();
    }

    @Override
    public ec.gob.snap.vuv.model.Indicador getIndicadorBygprId(long gprId) {
        return _indicadorLocalService.getIndicadorBygprId(gprId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public IndicadorLocalService getWrappedIndicadorLocalService() {
        return _indicadorLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedIndicadorLocalService(
        IndicadorLocalService indicadorLocalService) {
        _indicadorLocalService = indicadorLocalService;
    }

    @Override
    public IndicadorLocalService getWrappedService() {
        return _indicadorLocalService;
    }

    @Override
    public void setWrappedService(IndicadorLocalService indicadorLocalService) {
        _indicadorLocalService = indicadorLocalService;
    }
}
