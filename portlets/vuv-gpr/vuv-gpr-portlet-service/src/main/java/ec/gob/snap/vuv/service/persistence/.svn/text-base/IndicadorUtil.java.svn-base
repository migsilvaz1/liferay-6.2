package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ec.gob.snap.vuv.model.Indicador;

import java.util.List;

/**
 * The persistence utility for the indicador service. This utility wraps {@link IndicadorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IndicadorPersistence
 * @see IndicadorPersistenceImpl
 * @generated
 */
public class IndicadorUtil {
    private static IndicadorPersistence _persistence;

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
    public static void clearCache(Indicador indicador) {
        getPersistence().clearCache(indicador);
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
    public static List<Indicador> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Indicador> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Indicador> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Indicador update(Indicador indicador)
        throws SystemException {
        return getPersistence().update(indicador);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Indicador update(Indicador indicador,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(indicador, serviceContext);
    }

    /**
    * Caches the indicador in the entity cache if it is enabled.
    *
    * @param indicador the indicador
    */
    public static void cacheResult(ec.gob.snap.vuv.model.Indicador indicador) {
        getPersistence().cacheResult(indicador);
    }

    /**
    * Caches the indicadors in the entity cache if it is enabled.
    *
    * @param indicadors the indicadors
    */
    public static void cacheResult(
        java.util.List<ec.gob.snap.vuv.model.Indicador> indicadors) {
        getPersistence().cacheResult(indicadors);
    }

    /**
    * Creates a new indicador with the primary key. Does not add the indicador to the database.
    *
    * @param id_indicador the primary key for the new indicador
    * @return the new indicador
    */
    public static ec.gob.snap.vuv.model.Indicador create(long id_indicador) {
        return getPersistence().create(id_indicador);
    }

    /**
    * Removes the indicador with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_indicador the primary key of the indicador
    * @return the indicador that was removed
    * @throws ec.gob.snap.vuv.NoSuchIndicadorException if a indicador with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Indicador remove(long id_indicador)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchIndicadorException {
        return getPersistence().remove(id_indicador);
    }

    public static ec.gob.snap.vuv.model.Indicador updateImpl(
        ec.gob.snap.vuv.model.Indicador indicador)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(indicador);
    }

    /**
    * Returns the indicador with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchIndicadorException} if it could not be found.
    *
    * @param id_indicador the primary key of the indicador
    * @return the indicador
    * @throws ec.gob.snap.vuv.NoSuchIndicadorException if a indicador with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Indicador findByPrimaryKey(
        long id_indicador)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchIndicadorException {
        return getPersistence().findByPrimaryKey(id_indicador);
    }

    /**
    * Returns the indicador with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id_indicador the primary key of the indicador
    * @return the indicador, or <code>null</code> if a indicador with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Indicador fetchByPrimaryKey(
        long id_indicador)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id_indicador);
    }

    /**
    * Returns all the indicadors.
    *
    * @return the indicadors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Indicador> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the indicadors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.IndicadorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of indicadors
    * @param end the upper bound of the range of indicadors (not inclusive)
    * @return the range of indicadors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Indicador> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the indicadors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.IndicadorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of indicadors
    * @param end the upper bound of the range of indicadors (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of indicadors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Indicador> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the indicadors from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of indicadors.
    *
    * @return the number of indicadors
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static IndicadorPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (IndicadorPersistence) PortletBeanLocatorUtil.locate(ec.gob.snap.vuv.service.ClpSerializer.getServletContextName(),
                    IndicadorPersistence.class.getName());

            ReferenceRegistry.registerReference(IndicadorUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(IndicadorPersistence persistence) {
    }
}
