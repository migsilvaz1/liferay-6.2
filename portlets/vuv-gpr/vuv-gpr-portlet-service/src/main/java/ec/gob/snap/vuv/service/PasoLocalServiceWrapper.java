package ec.gob.snap.vuv.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PasoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PasoLocalService
 * @generated
 */
public class PasoLocalServiceWrapper implements PasoLocalService,
    ServiceWrapper<PasoLocalService> {
    private PasoLocalService _pasoLocalService;

    public PasoLocalServiceWrapper(PasoLocalService pasoLocalService) {
        _pasoLocalService = pasoLocalService;
    }

    /**
    * Adds the paso to the database. Also notifies the appropriate model listeners.
    *
    * @param paso the paso
    * @return the paso that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Paso addPaso(ec.gob.snap.vuv.model.Paso paso)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _pasoLocalService.addPaso(paso);
    }

    /**
    * Creates a new paso with the primary key. Does not add the paso to the database.
    *
    * @param id_paso the primary key for the new paso
    * @return the new paso
    */
    @Override
    public ec.gob.snap.vuv.model.Paso createPaso(long id_paso) {
        return _pasoLocalService.createPaso(id_paso);
    }

    /**
    * Deletes the paso with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_paso the primary key of the paso
    * @return the paso that was removed
    * @throws PortalException if a paso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Paso deletePaso(long id_paso)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _pasoLocalService.deletePaso(id_paso);
    }

    /**
    * Deletes the paso from the database. Also notifies the appropriate model listeners.
    *
    * @param paso the paso
    * @return the paso that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Paso deletePaso(
        ec.gob.snap.vuv.model.Paso paso)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _pasoLocalService.deletePaso(paso);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _pasoLocalService.dynamicQuery();
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
        return _pasoLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.PasoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _pasoLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.PasoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _pasoLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _pasoLocalService.dynamicQueryCount(dynamicQuery);
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
        return _pasoLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public ec.gob.snap.vuv.model.Paso fetchPaso(long id_paso)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _pasoLocalService.fetchPaso(id_paso);
    }

    /**
    * Returns the paso with the primary key.
    *
    * @param id_paso the primary key of the paso
    * @return the paso
    * @throws PortalException if a paso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Paso getPaso(long id_paso)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _pasoLocalService.getPaso(id_paso);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _pasoLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<ec.gob.snap.vuv.model.Paso> getPasos(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _pasoLocalService.getPasos(start, end);
    }

    /**
    * Returns the number of pasos.
    *
    * @return the number of pasos
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getPasosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _pasoLocalService.getPasosCount();
    }

    /**
    * Updates the paso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param paso the paso
    * @return the paso that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ec.gob.snap.vuv.model.Paso updatePaso(
        ec.gob.snap.vuv.model.Paso paso)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _pasoLocalService.updatePaso(paso);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _pasoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _pasoLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _pasoLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public ec.gob.snap.vuv.model.Paso addPaso(long gprId, long content,
        java.util.Date timeStamp) {
        return _pasoLocalService.addPaso(gprId, content, timeStamp);
    }

    @Override
    public ec.gob.snap.vuv.model.Paso addPaso(long gprId, long content,
        java.util.Date timeStamp, long idCaso) {
        return _pasoLocalService.addPaso(gprId, content, timeStamp, idCaso);
    }

    @Override
    public java.util.List<ec.gob.snap.vuv.model.Paso> getAllPasos() {
        return _pasoLocalService.getAllPasos();
    }

    @Override
    public java.util.List<ec.gob.snap.vuv.model.Requisito> getAllRequisitosByIdPaso(
        long pasoId) {
        return _pasoLocalService.getAllRequisitosByIdPaso(pasoId);
    }

    @Override
    public ec.gob.snap.vuv.model.Paso getPasoBygprId(long gprId) {
        return _pasoLocalService.getPasoBygprId(gprId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PasoLocalService getWrappedPasoLocalService() {
        return _pasoLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPasoLocalService(PasoLocalService pasoLocalService) {
        _pasoLocalService = pasoLocalService;
    }

    @Override
    public PasoLocalService getWrappedService() {
        return _pasoLocalService;
    }

    @Override
    public void setWrappedService(PasoLocalService pasoLocalService) {
        _pasoLocalService = pasoLocalService;
    }
}
