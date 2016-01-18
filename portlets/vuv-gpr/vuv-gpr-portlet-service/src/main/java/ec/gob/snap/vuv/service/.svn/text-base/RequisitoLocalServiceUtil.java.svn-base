package ec.gob.snap.vuv.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Requisito. This utility wraps
 * {@link ec.gob.snap.vuv.service.impl.RequisitoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RequisitoLocalService
 * @see ec.gob.snap.vuv.service.base.RequisitoLocalServiceBaseImpl
 * @see ec.gob.snap.vuv.service.impl.RequisitoLocalServiceImpl
 * @generated
 */
public class RequisitoLocalServiceUtil {
    private static RequisitoLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link ec.gob.snap.vuv.service.impl.RequisitoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the requisito to the database. Also notifies the appropriate model listeners.
    *
    * @param requisito the requisito
    * @return the requisito that was added
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Requisito addRequisito(
        ec.gob.snap.vuv.model.Requisito requisito)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addRequisito(requisito);
    }

    /**
    * Creates a new requisito with the primary key. Does not add the requisito to the database.
    *
    * @param id_requisito the primary key for the new requisito
    * @return the new requisito
    */
    public static ec.gob.snap.vuv.model.Requisito createRequisito(
        long id_requisito) {
        return getService().createRequisito(id_requisito);
    }

    /**
    * Deletes the requisito with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_requisito the primary key of the requisito
    * @return the requisito that was removed
    * @throws PortalException if a requisito with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Requisito deleteRequisito(
        long id_requisito)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteRequisito(id_requisito);
    }

    /**
    * Deletes the requisito from the database. Also notifies the appropriate model listeners.
    *
    * @param requisito the requisito
    * @return the requisito that was removed
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Requisito deleteRequisito(
        ec.gob.snap.vuv.model.Requisito requisito)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteRequisito(requisito);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.RequisitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.RequisitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static ec.gob.snap.vuv.model.Requisito fetchRequisito(
        long id_requisito)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchRequisito(id_requisito);
    }

    /**
    * Returns the requisito with the primary key.
    *
    * @param id_requisito the primary key of the requisito
    * @return the requisito
    * @throws PortalException if a requisito with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Requisito getRequisito(
        long id_requisito)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getRequisito(id_requisito);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the requisitos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.RequisitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of requisitos
    * @param end the upper bound of the range of requisitos (not inclusive)
    * @return the range of requisitos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Requisito> getRequisitos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getRequisitos(start, end);
    }

    /**
    * Returns the number of requisitos.
    *
    * @return the number of requisitos
    * @throws SystemException if a system exception occurred
    */
    public static int getRequisitosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getRequisitosCount();
    }

    /**
    * Updates the requisito in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param requisito the requisito
    * @return the requisito that was updated
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Requisito updateRequisito(
        ec.gob.snap.vuv.model.Requisito requisito)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateRequisito(requisito);
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

    public static ec.gob.snap.vuv.model.Requisito addRequisito(long gprId,
        long content, java.util.Date timeStamp) {
        return getService().addRequisito(gprId, content, timeStamp);
    }

    public static ec.gob.snap.vuv.model.Requisito addRequisito(long gprId,
        long content, java.util.Date timeStamp, long idPaso) {
        return getService().addRequisito(gprId, content, timeStamp, idPaso);
    }

    public static java.util.List<ec.gob.snap.vuv.model.Requisito> getAllRequisitos() {
        return getService().getAllRequisitos();
    }

    public static java.util.List<ec.gob.snap.vuv.model.Requisito> getAllRequisitosByIdPaso(
        long pasoId) {
        return getService().getAllRequisitosByIdPaso(pasoId);
    }

    public static ec.gob.snap.vuv.model.Requisito getRequisitoBygprId(
        long gprId) {
        return getService().getRequisitoBygprId(gprId);
    }

    public static void clearService() {
        _service = null;
    }

    public static RequisitoLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    RequisitoLocalService.class.getName());

            if (invokableLocalService instanceof RequisitoLocalService) {
                _service = (RequisitoLocalService) invokableLocalService;
            } else {
                _service = new RequisitoLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(RequisitoLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(RequisitoLocalService service) {
    }
}
