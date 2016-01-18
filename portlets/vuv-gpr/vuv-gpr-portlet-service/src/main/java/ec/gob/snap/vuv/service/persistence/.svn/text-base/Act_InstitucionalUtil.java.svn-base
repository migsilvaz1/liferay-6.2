package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ec.gob.snap.vuv.model.Act_Institucional;

import java.util.List;

/**
 * The persistence utility for the act_ institucional service. This utility wraps {@link Act_InstitucionalPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Act_InstitucionalPersistence
 * @see Act_InstitucionalPersistenceImpl
 * @generated
 */
public class Act_InstitucionalUtil {
    private static Act_InstitucionalPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Act_Institucional act_Institucional) {
        getPersistence().clearCache(act_Institucional);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Act_Institucional> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Act_Institucional> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Act_Institucional> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Act_Institucional update(Act_Institucional act_Institucional)
        throws SystemException {
        return getPersistence().update(act_Institucional);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Act_Institucional update(
        Act_Institucional act_Institucional, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(act_Institucional, serviceContext);
    }

    /**
    * Caches the act_ institucional in the entity cache if it is enabled.
    *
    * @param act_Institucional the act_ institucional
    */
    public static void cacheResult(
        ec.gob.snap.vuv.model.Act_Institucional act_Institucional) {
        getPersistence().cacheResult(act_Institucional);
    }

    /**
    * Caches the act_ institucionals in the entity cache if it is enabled.
    *
    * @param act_Institucionals the act_ institucionals
    */
    public static void cacheResult(
        java.util.List<ec.gob.snap.vuv.model.Act_Institucional> act_Institucionals) {
        getPersistence().cacheResult(act_Institucionals);
    }

    /**
    * Creates a new act_ institucional with the primary key. Does not add the act_ institucional to the database.
    *
    * @param id_act_institucional the primary key for the new act_ institucional
    * @return the new act_ institucional
    */
    public static ec.gob.snap.vuv.model.Act_Institucional create(
        long id_act_institucional) {
        return getPersistence().create(id_act_institucional);
    }

    /**
    * Removes the act_ institucional with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_act_institucional the primary key of the act_ institucional
    * @return the act_ institucional that was removed
    * @throws ec.gob.snap.vuv.NoSuchAct_InstitucionalException if a act_ institucional with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Act_Institucional remove(
        long id_act_institucional)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchAct_InstitucionalException {
        return getPersistence().remove(id_act_institucional);
    }

    public static ec.gob.snap.vuv.model.Act_Institucional updateImpl(
        ec.gob.snap.vuv.model.Act_Institucional act_Institucional)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(act_Institucional);
    }

    /**
    * Returns the act_ institucional with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchAct_InstitucionalException} if it could not be found.
    *
    * @param id_act_institucional the primary key of the act_ institucional
    * @return the act_ institucional
    * @throws ec.gob.snap.vuv.NoSuchAct_InstitucionalException if a act_ institucional with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Act_Institucional findByPrimaryKey(
        long id_act_institucional)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchAct_InstitucionalException {
        return getPersistence().findByPrimaryKey(id_act_institucional);
    }

    /**
    * Returns the act_ institucional with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id_act_institucional the primary key of the act_ institucional
    * @return the act_ institucional, or <code>null</code> if a act_ institucional with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Act_Institucional fetchByPrimaryKey(
        long id_act_institucional)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id_act_institucional);
    }

    /**
    * Returns all the act_ institucionals.
    *
    * @return the act_ institucionals
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Act_Institucional> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<ec.gob.snap.vuv.model.Act_Institucional> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the act_ institucionals.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.Act_InstitucionalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of act_ institucionals
    * @param end the upper bound of the range of act_ institucionals (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of act_ institucionals
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Act_Institucional> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the act_ institucionals from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of act_ institucionals.
    *
    * @return the number of act_ institucionals
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static Act_InstitucionalPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (Act_InstitucionalPersistence) PortletBeanLocatorUtil.locate(ec.gob.snap.vuv.service.ClpSerializer.getServletContextName(),
                    Act_InstitucionalPersistence.class.getName());

            ReferenceRegistry.registerReference(Act_InstitucionalUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(Act_InstitucionalPersistence persistence) {
    }
}
