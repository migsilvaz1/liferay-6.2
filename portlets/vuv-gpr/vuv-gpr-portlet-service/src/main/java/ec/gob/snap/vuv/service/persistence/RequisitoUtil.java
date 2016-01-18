package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ec.gob.snap.vuv.model.Requisito;

import java.util.List;

/**
 * The persistence utility for the requisito service. This utility wraps {@link RequisitoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RequisitoPersistence
 * @see RequisitoPersistenceImpl
 * @generated
 */
public class RequisitoUtil {
    private static RequisitoPersistence _persistence;

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
    public static void clearCache(Requisito requisito) {
        getPersistence().clearCache(requisito);
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
    public static List<Requisito> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Requisito> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Requisito> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Requisito update(Requisito requisito)
        throws SystemException {
        return getPersistence().update(requisito);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Requisito update(Requisito requisito,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(requisito, serviceContext);
    }

    /**
    * Caches the requisito in the entity cache if it is enabled.
    *
    * @param requisito the requisito
    */
    public static void cacheResult(ec.gob.snap.vuv.model.Requisito requisito) {
        getPersistence().cacheResult(requisito);
    }

    /**
    * Caches the requisitos in the entity cache if it is enabled.
    *
    * @param requisitos the requisitos
    */
    public static void cacheResult(
        java.util.List<ec.gob.snap.vuv.model.Requisito> requisitos) {
        getPersistence().cacheResult(requisitos);
    }

    /**
    * Creates a new requisito with the primary key. Does not add the requisito to the database.
    *
    * @param id_requisito the primary key for the new requisito
    * @return the new requisito
    */
    public static ec.gob.snap.vuv.model.Requisito create(long id_requisito) {
        return getPersistence().create(id_requisito);
    }

    /**
    * Removes the requisito with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_requisito the primary key of the requisito
    * @return the requisito that was removed
    * @throws ec.gob.snap.vuv.NoSuchRequisitoException if a requisito with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Requisito remove(long id_requisito)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchRequisitoException {
        return getPersistence().remove(id_requisito);
    }

    public static ec.gob.snap.vuv.model.Requisito updateImpl(
        ec.gob.snap.vuv.model.Requisito requisito)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(requisito);
    }

    /**
    * Returns the requisito with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchRequisitoException} if it could not be found.
    *
    * @param id_requisito the primary key of the requisito
    * @return the requisito
    * @throws ec.gob.snap.vuv.NoSuchRequisitoException if a requisito with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Requisito findByPrimaryKey(
        long id_requisito)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchRequisitoException {
        return getPersistence().findByPrimaryKey(id_requisito);
    }

    /**
    * Returns the requisito with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id_requisito the primary key of the requisito
    * @return the requisito, or <code>null</code> if a requisito with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ec.gob.snap.vuv.model.Requisito fetchByPrimaryKey(
        long id_requisito)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id_requisito);
    }

    /**
    * Returns all the requisitos.
    *
    * @return the requisitos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Requisito> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<ec.gob.snap.vuv.model.Requisito> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the requisitos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.RequisitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of requisitos
    * @param end the upper bound of the range of requisitos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of requisitos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ec.gob.snap.vuv.model.Requisito> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the requisitos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of requisitos.
    *
    * @return the number of requisitos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static RequisitoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (RequisitoPersistence) PortletBeanLocatorUtil.locate(ec.gob.snap.vuv.service.ClpSerializer.getServletContextName(),
                    RequisitoPersistence.class.getName());

            ReferenceRegistry.registerReference(RequisitoUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(RequisitoPersistence persistence) {
    }
}
