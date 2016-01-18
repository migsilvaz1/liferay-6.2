package ec.gob.snap.vuv.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Institucion. This utility wraps
 * {@link ec.gob.snap.vuv.service.impl.InstitucionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see InstitucionLocalService
 * @see ec.gob.snap.vuv.service.base.InstitucionLocalServiceBaseImpl
 * @see ec.gob.snap.vuv.service.impl.InstitucionLocalServiceImpl
 * @generated
 */
public class InstitucionLocalServiceUtil {
    private static InstitucionLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link ec.gob.snap.vuv.service.impl.InstitucionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the institucion to the database. Also notifies the appropriate model listeners.
    *
    * @param institucion the institucion
    * @return the institucion that was added
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Institucion addInstitucion(
        ec.gob.snap.vuv.model.Institucion institucion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addInstitucion(institucion);
    }

    /**
    * Creates a new institucion with the primary key. Does not add the institucion to the database.
    *
    * @param id_institucion the primary key for the new institucion
    * @return the new institucion
    */
    public static ec.gob.snap.vuv.model.Institucion createInstitucion(
        long id_institucion) {
        return getService().createInstitucion(id_institucion);
    }

    /**
    * Deletes the institucion with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_institucion the primary key of the institucion
    * @return the institucion that was removed
    * @throws PortalException if a institucion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Institucion deleteInstitucion(
        long id_institucion)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteInstitucion(id_institucion);
    }

    /**
    * Deletes the institucion from the database. Also notifies the appropriate model listeners.
    *
    * @param institucion the institucion
    * @return the institucion that was removed
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Institucion deleteInstitucion(
        ec.gob.snap.vuv.model.Institucion institucion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteInstitucion(institucion);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.InstitucionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.InstitucionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static ec.gob.snap.vuv.model.Institucion fetchInstitucion(
        long id_institucion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchInstitucion(id_institucion);
    }

    /**
    * Returns the institucion with the primary key.
    *
    * @param id_institucion the primary key of the institucion
    * @return the institucion
    * @throws PortalException if a institucion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Institucion getInstitucion(
        long id_institucion)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getInstitucion(id_institucion);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the institucions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.InstitucionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of institucions
    * @param end the upper bound of the range of institucions (not inclusive)
    * @return the range of institucions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Institucion> getInstitucions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getInstitucions(start, end);
    }

    /**
    * Returns the number of institucions.
    *
    * @return the number of institucions
    * @throws SystemException if a system exception occurred
    */
    public static int getInstitucionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getInstitucionsCount();
    }

    /**
    * Updates the institucion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param institucion the institucion
    * @return the institucion that was updated
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Institucion updateInstitucion(
        ec.gob.snap.vuv.model.Institucion institucion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateInstitucion(institucion);
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

    public static ec.gob.snap.vuv.model.Institucion addInstitucion(long gprId,
        long content, java.util.Date timeStamp) {
        return getService().addInstitucion(gprId, content, timeStamp);
    }

    public static java.util.List<ec.gob.snap.vuv.model.Institucion> getAllInstituciones() {
        return getService().getAllInstituciones();
    }

    public static java.util.List<ec.gob.snap.vuv.model.Servicio> getAllServiciosByIdInstitucion(
        long institucionId) {
        return getService().getAllServiciosByIdInstitucion(institucionId);
    }

    public static ec.gob.snap.vuv.model.Institucion getInstitucionBygprId(
        long gprId) {
        return getService().getInstitucionBygprId(gprId);
    }

    public static void clearService() {
        _service = null;
    }

    public static InstitucionLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    InstitucionLocalService.class.getName());

            if (invokableLocalService instanceof InstitucionLocalService) {
                _service = (InstitucionLocalService) invokableLocalService;
            } else {
                _service = new InstitucionLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(InstitucionLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(InstitucionLocalService service) {
    }
}
