package ec.gob.snap.vuv.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Centro. This utility wraps
 * {@link ec.gob.snap.vuv.service.impl.CentroLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CentroLocalService
 * @see ec.gob.snap.vuv.service.base.CentroLocalServiceBaseImpl
 * @see ec.gob.snap.vuv.service.impl.CentroLocalServiceImpl
 * @generated
 */
public class CentroLocalServiceUtil {
    private static CentroLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link ec.gob.snap.vuv.service.impl.CentroLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the centro to the database. Also notifies the appropriate model listeners.
    *
    * @param centro the centro
    * @return the centro that was added
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Centro addCentro(
        ec.gob.snap.vuv.model.Centro centro)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addCentro(centro);
    }

    /**
    * Creates a new centro with the primary key. Does not add the centro to the database.
    *
    * @param id_centro the primary key for the new centro
    * @return the new centro
    */
    public static ec.gob.snap.vuv.model.Centro createCentro(long id_centro) {
        return getService().createCentro(id_centro);
    }

    /**
    * Deletes the centro with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_centro the primary key of the centro
    * @return the centro that was removed
    * @throws PortalException if a centro with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Centro deleteCentro(long id_centro)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCentro(id_centro);
    }

    /**
    * Deletes the centro from the database. Also notifies the appropriate model listeners.
    *
    * @param centro the centro
    * @return the centro that was removed
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Centro deleteCentro(
        ec.gob.snap.vuv.model.Centro centro)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCentro(centro);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.CentroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.CentroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static ec.gob.snap.vuv.model.Centro fetchCentro(long id_centro)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchCentro(id_centro);
    }

    /**
    * Returns the centro with the primary key.
    *
    * @param id_centro the primary key of the centro
    * @return the centro
    * @throws PortalException if a centro with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Centro getCentro(long id_centro)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCentro(id_centro);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<ec.gob.snap.vuv.model.Centro> getCentros(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCentros(start, end);
    }

    /**
    * Returns the number of centros.
    *
    * @return the number of centros
    * @throws SystemException if a system exception occurred
    */
    public static int getCentrosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCentrosCount();
    }

    /**
    * Updates the centro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param centro the centro
    * @return the centro that was updated
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Centro updateCentro(
        ec.gob.snap.vuv.model.Centro centro)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateCentro(centro);
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

    public static ec.gob.snap.vuv.model.Centro addCentro(long gprId,
        long content, java.util.Date timeStamp) {
        return getService().addCentro(gprId, content, timeStamp);
    }

    public static ec.gob.snap.vuv.model.Centro addCentro(long gprId,
        long content, java.util.Date timeStamp, long idCaso) {
        return getService().addCentro(gprId, content, timeStamp, idCaso);
    }

    public static java.util.List<ec.gob.snap.vuv.model.Centro> getAllCentros() {
        return getService().getAllCentros();
    }

    public static ec.gob.snap.vuv.model.Centro getCentroBygprId(long gprId) {
        return getService().getCentroBygprId(gprId);
    }

    public static void clearService() {
        _service = null;
    }

    public static CentroLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    CentroLocalService.class.getName());

            if (invokableLocalService instanceof CentroLocalService) {
                _service = (CentroLocalService) invokableLocalService;
            } else {
                _service = new CentroLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(CentroLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(CentroLocalService service) {
    }
}
