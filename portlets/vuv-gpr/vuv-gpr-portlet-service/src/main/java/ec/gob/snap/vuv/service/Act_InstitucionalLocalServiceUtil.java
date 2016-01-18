package ec.gob.snap.vuv.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Act_Institucional. This utility wraps
 * {@link ec.gob.snap.vuv.service.impl.Act_InstitucionalLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see Act_InstitucionalLocalService
 * @see ec.gob.snap.vuv.service.base.Act_InstitucionalLocalServiceBaseImpl
 * @see ec.gob.snap.vuv.service.impl.Act_InstitucionalLocalServiceImpl
 * @generated
 */
public class Act_InstitucionalLocalServiceUtil {
    private static Act_InstitucionalLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link ec.gob.snap.vuv.service.impl.Act_InstitucionalLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the act_ institucional to the database. Also notifies the appropriate model listeners.
    *
    * @param act_Institucional the act_ institucional
    * @return the act_ institucional that was added
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Act_Institucional addAct_Institucional(
        ec.gob.snap.vuv.model.Act_Institucional act_Institucional)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addAct_Institucional(act_Institucional);
    }

    /**
    * Creates a new act_ institucional with the primary key. Does not add the act_ institucional to the database.
    *
    * @param id_act_institucional the primary key for the new act_ institucional
    * @return the new act_ institucional
    */
    public static ec.gob.snap.vuv.model.Act_Institucional createAct_Institucional(
        long id_act_institucional) {
        return getService().createAct_Institucional(id_act_institucional);
    }

    /**
    * Deletes the act_ institucional with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_act_institucional the primary key of the act_ institucional
    * @return the act_ institucional that was removed
    * @throws PortalException if a act_ institucional with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Act_Institucional deleteAct_Institucional(
        long id_act_institucional)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAct_Institucional(id_act_institucional);
    }

    /**
    * Deletes the act_ institucional from the database. Also notifies the appropriate model listeners.
    *
    * @param act_Institucional the act_ institucional
    * @return the act_ institucional that was removed
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Act_Institucional deleteAct_Institucional(
        ec.gob.snap.vuv.model.Act_Institucional act_Institucional)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAct_Institucional(act_Institucional);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.Act_InstitucionalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.Act_InstitucionalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static ec.gob.snap.vuv.model.Act_Institucional fetchAct_Institucional(
        long id_act_institucional)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchAct_Institucional(id_act_institucional);
    }

    /**
    * Returns the act_ institucional with the primary key.
    *
    * @param id_act_institucional the primary key of the act_ institucional
    * @return the act_ institucional
    * @throws PortalException if a act_ institucional with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Act_Institucional getAct_Institucional(
        long id_act_institucional)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAct_Institucional(id_act_institucional);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the act_ institucionals.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.Act_InstitucionalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of act_ institucionals
    * @param end the upper bound of the range of act_ institucionals (not inclusive)
    * @return the range of act_ institucionals
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Act_Institucional> getAct_Institucionals(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAct_Institucionals(start, end);
    }

    /**
    * Returns the number of act_ institucionals.
    *
    * @return the number of act_ institucionals
    * @throws SystemException if a system exception occurred
    */
    public static int getAct_InstitucionalsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAct_InstitucionalsCount();
    }

    /**
    * Updates the act_ institucional in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param act_Institucional the act_ institucional
    * @return the act_ institucional that was updated
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Act_Institucional updateAct_Institucional(
        ec.gob.snap.vuv.model.Act_Institucional act_Institucional)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateAct_Institucional(act_Institucional);
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

    public static ec.gob.snap.vuv.model.Act_Institucional addAct_Institucional(
        long gprId, long content, java.util.Date timeStamp) {
        return getService().addAct_Institucional(gprId, content, timeStamp);
    }

    public static ec.gob.snap.vuv.model.Act_Institucional addAct_Institucional(
        long gprId, long content, java.util.Date timeStamp, long idServicio) {
        return getService()
                   .addAct_Institucional(gprId, content, timeStamp, idServicio);
    }

    public static java.util.List<ec.gob.snap.vuv.model.Act_Institucional> getAllAct_Institucionales() {
        return getService().getAllAct_Institucionales();
    }

    public static ec.gob.snap.vuv.model.Act_Institucional getAct_InstitucionalBygprId(
        long gprId) {
        return getService().getAct_InstitucionalBygprId(gprId);
    }

    public static void clearService() {
        _service = null;
    }

    public static Act_InstitucionalLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    Act_InstitucionalLocalService.class.getName());

            if (invokableLocalService instanceof Act_InstitucionalLocalService) {
                _service = (Act_InstitucionalLocalService) invokableLocalService;
            } else {
                _service = new Act_InstitucionalLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(Act_InstitucionalLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(Act_InstitucionalLocalService service) {
    }
}
