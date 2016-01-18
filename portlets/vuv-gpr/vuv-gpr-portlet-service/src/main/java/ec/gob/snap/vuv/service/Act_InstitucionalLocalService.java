package ec.gob.snap.vuv.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for Act_Institucional. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see Act_InstitucionalLocalServiceUtil
 * @see ec.gob.snap.vuv.service.base.Act_InstitucionalLocalServiceBaseImpl
 * @see ec.gob.snap.vuv.service.impl.Act_InstitucionalLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface Act_InstitucionalLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link Act_InstitucionalLocalServiceUtil} to access the act_ institucional local service. Add custom service methods to {@link ec.gob.snap.vuv.service.impl.Act_InstitucionalLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the act_ institucional to the database. Also notifies the appropriate model listeners.
    *
    * @param act_Institucional the act_ institucional
    * @return the act_ institucional that was added
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public ec.gob.snap.vuv.model.Act_Institucional addAct_Institucional(
        ec.gob.snap.vuv.model.Act_Institucional act_Institucional)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new act_ institucional with the primary key. Does not add the act_ institucional to the database.
    *
    * @param id_act_institucional the primary key for the new act_ institucional
    * @return the new act_ institucional
    */
    public ec.gob.snap.vuv.model.Act_Institucional createAct_Institucional(
        long id_act_institucional);

    /**
    * Deletes the act_ institucional with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_act_institucional the primary key of the act_ institucional
    * @return the act_ institucional that was removed
    * @throws PortalException if a act_ institucional with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public ec.gob.snap.vuv.model.Act_Institucional deleteAct_Institucional(
        long id_act_institucional)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the act_ institucional from the database. Also notifies the appropriate model listeners.
    *
    * @param act_Institucional the act_ institucional
    * @return the act_ institucional that was removed
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public ec.gob.snap.vuv.model.Act_Institucional deleteAct_Institucional(
        ec.gob.snap.vuv.model.Act_Institucional act_Institucional)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public ec.gob.snap.vuv.model.Act_Institucional fetchAct_Institucional(
        long id_act_institucional)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the act_ institucional with the primary key.
    *
    * @param id_act_institucional the primary key of the act_ institucional
    * @return the act_ institucional
    * @throws PortalException if a act_ institucional with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public ec.gob.snap.vuv.model.Act_Institucional getAct_Institucional(
        long id_act_institucional)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<ec.gob.snap.vuv.model.Act_Institucional> getAct_Institucionals(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of act_ institucionals.
    *
    * @return the number of act_ institucionals
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getAct_InstitucionalsCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the act_ institucional in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param act_Institucional the act_ institucional
    * @return the act_ institucional that was updated
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public ec.gob.snap.vuv.model.Act_Institucional updateAct_Institucional(
        ec.gob.snap.vuv.model.Act_Institucional act_Institucional)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public ec.gob.snap.vuv.model.Act_Institucional addAct_Institucional(
        long gprId, long content, java.util.Date timeStamp);

    public ec.gob.snap.vuv.model.Act_Institucional addAct_Institucional(
        long gprId, long content, java.util.Date timeStamp, long idServicio);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<ec.gob.snap.vuv.model.Act_Institucional> getAllAct_Institucionales();

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public ec.gob.snap.vuv.model.Act_Institucional getAct_InstitucionalBygprId(
        long gprId);
}
