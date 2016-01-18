package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ec.gob.snap.vuv.model.Caso;

import java.util.List;

/**
 * The persistence utility for the caso service. This utility wraps {@link CasoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CasoPersistence
 * @see CasoPersistenceImpl
 * @generated
 */
public class CasoUtil {
    private static CasoPersistence _persistence;

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
    public static void clearCache(Caso caso) {
        getPersistence().clearCache(caso);
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
    public static List<Caso> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Caso> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Caso> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Caso update(Caso caso) throws SystemException {
        return getPersistence().update(caso);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Caso update(Caso caso, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(caso, serviceContext);
    }

    /**
    * Caches the caso in the entity cache if it is enabled.
    *
    * @param caso the caso
    */
    public static void cacheResult(ec.gob.snap.vuv.model.Caso caso) {
        getPersistence().cacheResult(caso);
    }

    /**
    * Caches the casos in the entity cache if it is enabled.
    *
    * @param casos the casos
    */
    public static void cacheResult(
        java.util.List<ec.gob.snap.vuv.model.Caso> casos) {
        getPersistence().cacheResult(casos);
    }

    /**
    * Creates a new caso with the primary key. Does not add the caso to the database.
    *
    * @param id_caso the primary key for the new caso
    * @return the new caso
    */
    public static ec.gob.snap.vuv.model.Caso create(long id_caso) {
        return getPersistence().create(id_caso);
    }

    /**
    * Removes the caso with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_caso the primary key of the caso
    * @return the caso that was removed
    * @throws ec.gob.snap.vuv.NoSuchCasoException if a caso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Caso remove(long id_caso)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchCasoException {
        return getPersistence().remove(id_caso);
    }

    public static ec.gob.snap.vuv.model.Caso updateImpl(
        ec.gob.snap.vuv.model.Caso caso)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(caso);
    }

    /**
    * Returns the caso with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchCasoException} if it could not be found.
    *
    * @param id_caso the primary key of the caso
    * @return the caso
    * @throws ec.gob.snap.vuv.NoSuchCasoException if a caso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Caso findByPrimaryKey(long id_caso)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchCasoException {
        return getPersistence().findByPrimaryKey(id_caso);
    }

    /**
    * Returns the caso with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id_caso the primary key of the caso
    * @return the caso, or <code>null</code> if a caso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Caso fetchByPrimaryKey(long id_caso)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id_caso);
    }

    /**
    * Returns all the casos.
    *
    * @return the casos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Caso> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the casos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.CasoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of casos
    * @param end the upper bound of the range of casos (not inclusive)
    * @return the range of casos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Caso> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the casos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.CasoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of casos
    * @param end the upper bound of the range of casos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of casos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Caso> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the casos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of casos.
    *
    * @return the number of casos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static CasoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (CasoPersistence) PortletBeanLocatorUtil.locate(ec.gob.snap.vuv.service.ClpSerializer.getServletContextName(),
                    CasoPersistence.class.getName());

            ReferenceRegistry.registerReference(CasoUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(CasoPersistence persistence) {
    }
}
