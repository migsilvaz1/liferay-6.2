package ec.gob.snap.vuv.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Servicio. This utility wraps
 * {@link ec.gob.snap.vuv.service.impl.ServicioLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ServicioLocalService
 * @see ec.gob.snap.vuv.service.base.ServicioLocalServiceBaseImpl
 * @see ec.gob.snap.vuv.service.impl.ServicioLocalServiceImpl
 * @generated
 */
public class ServicioLocalServiceUtil {
    private static ServicioLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link ec.gob.snap.vuv.service.impl.ServicioLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the servicio to the database. Also notifies the appropriate model listeners.
    *
    * @param servicio the servicio
    * @return the servicio that was added
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Servicio addServicio(
        ec.gob.snap.vuv.model.Servicio servicio)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addServicio(servicio);
    }

    /**
    * Creates a new servicio with the primary key. Does not add the servicio to the database.
    *
    * @param id_servicio the primary key for the new servicio
    * @return the new servicio
    */
    public static ec.gob.snap.vuv.model.Servicio createServicio(
        long id_servicio) {
        return getService().createServicio(id_servicio);
    }

    /**
    * Deletes the servicio with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_servicio the primary key of the servicio
    * @return the servicio that was removed
    * @throws PortalException if a servicio with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Servicio deleteServicio(
        long id_servicio)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteServicio(id_servicio);
    }

    /**
    * Deletes the servicio from the database. Also notifies the appropriate model listeners.
    *
    * @param servicio the servicio
    * @return the servicio that was removed
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Servicio deleteServicio(
        ec.gob.snap.vuv.model.Servicio servicio)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteServicio(servicio);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static ec.gob.snap.vuv.model.Servicio fetchServicio(long id_servicio)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchServicio(id_servicio);
    }

    /**
    * Returns the servicio with the primary key.
    *
    * @param id_servicio the primary key of the servicio
    * @return the servicio
    * @throws PortalException if a servicio with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Servicio getServicio(long id_servicio)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getServicio(id_servicio);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<ec.gob.snap.vuv.model.Servicio> getServicios(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getServicios(start, end);
    }

    /**
    * Returns the number of servicios.
    *
    * @return the number of servicios
    * @throws SystemException if a system exception occurred
    */
    public static int getServiciosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getServiciosCount();
    }

    /**
    * Updates the servicio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param servicio the servicio
    * @return the servicio that was updated
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Servicio updateServicio(
        ec.gob.snap.vuv.model.Servicio servicio)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateServicio(servicio);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static ec.gob.snap.vuv.model.Servicio addServicio(long gprId,
        long content, java.util.Date timeStamp) {
        return getService().addServicio(gprId, content, timeStamp);
    }

    public static ec.gob.snap.vuv.model.Servicio addServicio(long gprId,
        long content, java.util.Date timeStamp, long idInstitucion) {
        return getService().addServicio(gprId, content, timeStamp, idInstitucion);
    }

    public static java.util.List<ec.gob.snap.vuv.model.Servicio> getAllServicios() {
        return getService().getAllServicios();
    }

    public static java.util.List<ec.gob.snap.vuv.model.Indicador> getAllIndicadoresByIdServicio(
        long servicioId) {
        return getService().getAllIndicadoresByIdServicio(servicioId);
    }

    public static java.util.List<ec.gob.snap.vuv.model.Act_Institucional> getAllActInstByIdServicio(
        long servicioId) {
        return getService().getAllActInstByIdServicio(servicioId);
    }

    public static java.util.List<ec.gob.snap.vuv.model.Caso> getAllCasosByIdServicio(
        long servicioId) {
        return getService().getAllCasosByIdServicio(servicioId);
    }

    public static long getIdServicioByContent(long content) {
        return getService().getIdServicioByContent(content);
    }

    public static ec.gob.snap.vuv.model.Servicio getServicioBygprId(long gprId) {
        return getService().getServicioBygprId(gprId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ServicioLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ServicioLocalService.class.getName());

            if (invokableLocalService instanceof ServicioLocalService) {
                _service = (ServicioLocalService) invokableLocalService;
            } else {
                _service = new ServicioLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ServicioLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ServicioLocalService service) {
    }
}
