package ec.gob.snap.vuv.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ServicioLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServicioLocalService
 * @generated
 */
public class ServicioLocalServiceWrapper implements ServicioLocalService,
    ServiceWrapper<ServicioLocalService> {
    private ServicioLocalService _servicioLocalService;

    public ServicioLocalServiceWrapper(
        ServicioLocalService servicioLocalService) {
        _servicioLocalService = servicioLocalService;
    }

    /**
    * Adds the servicio to the database. Also notifies the appropriate model listeners.
    *
    * @param servicio the servicio
    * @return the servicio that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Servicio addServicio(
        ec.gob.snap.vuv.model.Servicio servicio)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _servicioLocalService.addServicio(servicio);
    }

    /**
    * Creates a new servicio with the primary key. Does not add the servicio to the database.
    *
    * @param id_servicio the primary key for the new servicio
    * @return the new servicio
    */
    @Override
    public ec.gob.snap.vuv.model.Servicio createServicio(long id_servicio) {
        return _servicioLocalService.createServicio(id_servicio);
    }

    /**
    * Deletes the servicio with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_servicio the primary key of the servicio
    * @return the servicio that was removed
    * @throws PortalException if a servicio with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Servicio deleteServicio(long id_servicio)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _servicioLocalService.deleteServicio(id_servicio);
    }

    /**
    * Deletes the servicio from the database. Also notifies the appropriate model listeners.
    *
    * @param servicio the servicio
    * @return the servicio that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Servicio deleteServicio(
        ec.gob.snap.vuv.model.Servicio servicio)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _servicioLocalService.deleteServicio(servicio);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _servicioLocalService.dynamicQuery();
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
        return _servicioLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.ServicioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _servicioLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.ServicioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _servicioLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _servicioLocalService.dynamicQueryCount(dynamicQuery);
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
        return _servicioLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public ec.gob.snap.vuv.model.Servicio fetchServicio(long id_servicio)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _servicioLocalService.fetchServicio(id_servicio);
    }

    /**
    * Returns the servicio with the primary key.
    *
    * @param id_servicio the primary key of the servicio
    * @return the servicio
    * @throws PortalException if a servicio with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Servicio getServicio(long id_servicio)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _servicioLocalService.getServicio(id_servicio);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _servicioLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<ec.gob.snap.vuv.model.Servicio> getServicios(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _servicioLocalService.getServicios(start, end);
    }

    /**
    * Returns the number of servicios.
    *
    * @return the number of servicios
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getServiciosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _servicioLocalService.getServiciosCount();
    }

    /**
    * Updates the servicio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param servicio the servicio
    * @return the servicio that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Servicio updateServicio(
        ec.gob.snap.vuv.model.Servicio servicio)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _servicioLocalService.updateServicio(servicio);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _servicioLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _servicioLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _servicioLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public ec.gob.snap.vuv.model.Servicio addServicio(long gprId, long content,
        java.util.Date timeStamp) {
        return _servicioLocalService.addServicio(gprId, content, timeStamp);
    }

    @Override
    public ec.gob.snap.vuv.model.Servicio addServicio(long gprId, long content,
        java.util.Date timeStamp, long idInstitucion) {
        return _servicioLocalService.addServicio(gprId, content, timeStamp,
            idInstitucion);
    }

    @Override
    public java.util.List<ec.gob.snap.vuv.model.Servicio> getAllServicios() {
        return _servicioLocalService.getAllServicios();
    }

    @Override
    public java.util.List<ec.gob.snap.vuv.model.Indicador> getAllIndicadoresByIdServicio(
        long servicioId) {
        return _servicioLocalService.getAllIndicadoresByIdServicio(servicioId);
    }

    @Override
    public java.util.List<ec.gob.snap.vuv.model.Act_Institucional> getAllActInstByIdServicio(
        long servicioId) {
        return _servicioLocalService.getAllActInstByIdServicio(servicioId);
    }

    @Override
    public java.util.List<ec.gob.snap.vuv.model.Caso> getAllCasosByIdServicio(
        long servicioId) {
        return _servicioLocalService.getAllCasosByIdServicio(servicioId);
    }

    @Override
    public long getIdServicioByContent(long content) {
        return _servicioLocalService.getIdServicioByContent(content);
    }

    @Override
    public ec.gob.snap.vuv.model.Servicio getServicioBygprId(long gprId) {
        return _servicioLocalService.getServicioBygprId(gprId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ServicioLocalService getWrappedServicioLocalService() {
        return _servicioLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedServicioLocalService(
        ServicioLocalService servicioLocalService) {
        _servicioLocalService = servicioLocalService;
    }

    @Override
    public ServicioLocalService getWrappedService() {
        return _servicioLocalService;
    }

    @Override
    public void setWrappedService(ServicioLocalService servicioLocalService) {
        _servicioLocalService = servicioLocalService;
    }
}
