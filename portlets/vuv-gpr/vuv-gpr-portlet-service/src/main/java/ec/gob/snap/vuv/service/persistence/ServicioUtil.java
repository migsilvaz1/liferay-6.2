package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ec.gob.snap.vuv.model.Servicio;

import java.util.List;

/**
 * The persistence utility for the servicio service. This utility wraps {@link ServicioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServicioPersistence
 * @see ServicioPersistenceImpl
 * @generated
 */
public class ServicioUtil {
    private static ServicioPersistence _persistence;

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
    public static void clearCache(Servicio servicio) {
        getPersistence().clearCache(servicio);
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
    public static List<Servicio> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Servicio> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Servicio> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Servicio update(Servicio servicio) throws SystemException {
        return getPersistence().update(servicio);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Servicio update(Servicio servicio,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(servicio, serviceContext);
    }

    /**
    * Caches the servicio in the entity cache if it is enabled.
    *
    * @param servicio the servicio
    */
    public static void cacheResult(ec.gob.snap.vuv.model.Servicio servicio) {
        getPersistence().cacheResult(servicio);
    }

    /**
    * Caches the servicios in the entity cache if it is enabled.
    *
    * @param servicios the servicios
    */
    public static void cacheResult(
        java.util.List<ec.gob.snap.vuv.model.Servicio> servicios) {
        getPersistence().cacheResult(servicios);
    }

    /**
    * Creates a new servicio with the primary key. Does not add the servicio to the database.
    *
    * @param id_servicio the primary key for the new servicio
    * @return the new servicio
    */
    public static ec.gob.snap.vuv.model.Servicio create(long id_servicio) {
        return getPersistence().create(id_servicio);
    }

    /**
    * Removes the servicio with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_servicio the primary key of the servicio
    * @return the servicio that was removed
    * @throws ec.gob.snap.vuv.NoSuchServicioException if a servicio with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Servicio remove(long id_servicio)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchServicioException {
        return getPersistence().remove(id_servicio);
    }

    public static ec.gob.snap.vuv.model.Servicio updateImpl(
        ec.gob.snap.vuv.model.Servicio servicio)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(servicio);
    }

    /**
    * Returns the servicio with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchServicioException} if it could not be found.
    *
    * @param id_servicio the primary key of the servicio
    * @return the servicio
    * @throws ec.gob.snap.vuv.NoSuchServicioException if a servicio with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Servicio findByPrimaryKey(
        long id_servicio)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchServicioException {
        return getPersistence().findByPrimaryKey(id_servicio);
    }

    /**
    * Returns the servicio with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id_servicio the primary key of the servicio
    * @return the servicio, or <code>null</code> if a servicio with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Servicio fetchByPrimaryKey(
        long id_servicio)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id_servicio);
    }

    /**
    * Returns all the servicios.
    *
    * @return the servicios
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Servicio> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<ec.gob.snap.vuv.model.Servicio> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the servicios.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.ServicioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of servicios
    * @param end the upper bound of the range of servicios (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of servicios
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Servicio> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the servicios from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of servicios.
    *
    * @return the number of servicios
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ServicioPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ServicioPersistence) PortletBeanLocatorUtil.locate(ec.gob.snap.vuv.service.ClpSerializer.getServletContextName(),
                    ServicioPersistence.class.getName());

            ReferenceRegistry.registerReference(ServicioUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ServicioPersistence persistence) {
    }
}
