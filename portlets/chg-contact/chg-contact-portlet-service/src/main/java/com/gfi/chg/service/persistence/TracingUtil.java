package com.gfi.chg.service.persistence;

import com.gfi.chg.model.Tracing;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the tracing service. This utility wraps {@link TracingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TracingPersistence
 * @see TracingPersistenceImpl
 * @generated
 */
public class TracingUtil {
    private static TracingPersistence _persistence;

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
    public static void clearCache(Tracing tracing) {
        getPersistence().clearCache(tracing);
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
    public static List<Tracing> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Tracing> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Tracing> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Tracing update(Tracing tracing) throws SystemException {
        return getPersistence().update(tracing);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Tracing update(Tracing tracing, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(tracing, serviceContext);
    }

    /**
    * Returns all the tracings where areaId = &#63;.
    *
    * @param areaId the area ID
    * @return the matching tracings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Tracing> findByAreaId(
        long areaId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAreaId(areaId);
    }

    /**
    * Returns a range of all the tracings where areaId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.TracingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param areaId the area ID
    * @param start the lower bound of the range of tracings
    * @param end the upper bound of the range of tracings (not inclusive)
    * @return the range of matching tracings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Tracing> findByAreaId(
        long areaId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAreaId(areaId, start, end);
    }

    /**
    * Returns an ordered range of all the tracings where areaId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.TracingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param areaId the area ID
    * @param start the lower bound of the range of tracings
    * @param end the upper bound of the range of tracings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching tracings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Tracing> findByAreaId(
        long areaId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAreaId(areaId, start, end, orderByComparator);
    }

    /**
    * Returns the first tracing in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tracing
    * @throws com.gfi.chg.NoSuchTracingException if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Tracing findByAreaId_First(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAreaId_First(areaId, orderByComparator);
    }

    /**
    * Returns the first tracing in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tracing, or <code>null</code> if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Tracing fetchByAreaId_First(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByAreaId_First(areaId, orderByComparator);
    }

    /**
    * Returns the last tracing in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tracing
    * @throws com.gfi.chg.NoSuchTracingException if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Tracing findByAreaId_Last(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAreaId_Last(areaId, orderByComparator);
    }

    /**
    * Returns the last tracing in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tracing, or <code>null</code> if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Tracing fetchByAreaId_Last(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByAreaId_Last(areaId, orderByComparator);
    }

    /**
    * Returns the tracings before and after the current tracing in the ordered set where areaId = &#63;.
    *
    * @param tracingId the primary key of the current tracing
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next tracing
    * @throws com.gfi.chg.NoSuchTracingException if a tracing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Tracing[] findByAreaId_PrevAndNext(
        long tracingId, long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAreaId_PrevAndNext(tracingId, areaId,
            orderByComparator);
    }

    /**
    * Removes all the tracings where areaId = &#63; from the database.
    *
    * @param areaId the area ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAreaId(long areaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAreaId(areaId);
    }

    /**
    * Returns the number of tracings where areaId = &#63;.
    *
    * @param areaId the area ID
    * @return the number of matching tracings
    * @throws SystemException if a system exception occurred
    */
    public static int countByAreaId(long areaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAreaId(areaId);
    }

    /**
    * Returns all the tracings where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @return the matching tracings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Tracing> findByContactId(
        long contactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByContactId(contactId);
    }

    /**
    * Returns a range of all the tracings where contactId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.TracingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param contactId the contact ID
    * @param start the lower bound of the range of tracings
    * @param end the upper bound of the range of tracings (not inclusive)
    * @return the range of matching tracings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Tracing> findByContactId(
        long contactId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByContactId(contactId, start, end);
    }

    /**
    * Returns an ordered range of all the tracings where contactId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.TracingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param contactId the contact ID
    * @param start the lower bound of the range of tracings
    * @param end the upper bound of the range of tracings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching tracings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Tracing> findByContactId(
        long contactId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactId(contactId, start, end, orderByComparator);
    }

    /**
    * Returns the first tracing in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tracing
    * @throws com.gfi.chg.NoSuchTracingException if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Tracing findByContactId_First(
        long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactId_First(contactId, orderByComparator);
    }

    /**
    * Returns the first tracing in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tracing, or <code>null</code> if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Tracing fetchByContactId_First(
        long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByContactId_First(contactId, orderByComparator);
    }

    /**
    * Returns the last tracing in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tracing
    * @throws com.gfi.chg.NoSuchTracingException if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Tracing findByContactId_Last(
        long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactId_Last(contactId, orderByComparator);
    }

    /**
    * Returns the last tracing in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tracing, or <code>null</code> if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Tracing fetchByContactId_Last(
        long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByContactId_Last(contactId, orderByComparator);
    }

    /**
    * Returns the tracings before and after the current tracing in the ordered set where contactId = &#63;.
    *
    * @param tracingId the primary key of the current tracing
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next tracing
    * @throws com.gfi.chg.NoSuchTracingException if a tracing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Tracing[] findByContactId_PrevAndNext(
        long tracingId, long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactId_PrevAndNext(tracingId, contactId,
            orderByComparator);
    }

    /**
    * Removes all the tracings where contactId = &#63; from the database.
    *
    * @param contactId the contact ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByContactId(long contactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByContactId(contactId);
    }

    /**
    * Returns the number of tracings where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @return the number of matching tracings
    * @throws SystemException if a system exception occurred
    */
    public static int countByContactId(long contactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByContactId(contactId);
    }

    /**
    * Caches the tracing in the entity cache if it is enabled.
    *
    * @param tracing the tracing
    */
    public static void cacheResult(com.gfi.chg.model.Tracing tracing) {
        getPersistence().cacheResult(tracing);
    }

    /**
    * Caches the tracings in the entity cache if it is enabled.
    *
    * @param tracings the tracings
    */
    public static void cacheResult(
        java.util.List<com.gfi.chg.model.Tracing> tracings) {
        getPersistence().cacheResult(tracings);
    }

    /**
    * Creates a new tracing with the primary key. Does not add the tracing to the database.
    *
    * @param tracingId the primary key for the new tracing
    * @return the new tracing
    */
    public static com.gfi.chg.model.Tracing create(long tracingId) {
        return getPersistence().create(tracingId);
    }

    /**
    * Removes the tracing with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param tracingId the primary key of the tracing
    * @return the tracing that was removed
    * @throws com.gfi.chg.NoSuchTracingException if a tracing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Tracing remove(long tracingId)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(tracingId);
    }

    public static com.gfi.chg.model.Tracing updateImpl(
        com.gfi.chg.model.Tracing tracing)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(tracing);
    }

    /**
    * Returns the tracing with the primary key or throws a {@link com.gfi.chg.NoSuchTracingException} if it could not be found.
    *
    * @param tracingId the primary key of the tracing
    * @return the tracing
    * @throws com.gfi.chg.NoSuchTracingException if a tracing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Tracing findByPrimaryKey(long tracingId)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(tracingId);
    }

    /**
    * Returns the tracing with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param tracingId the primary key of the tracing
    * @return the tracing, or <code>null</code> if a tracing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Tracing fetchByPrimaryKey(long tracingId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(tracingId);
    }

    /**
    * Returns all the tracings.
    *
    * @return the tracings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Tracing> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the tracings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.TracingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of tracings
    * @param end the upper bound of the range of tracings (not inclusive)
    * @return the range of tracings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Tracing> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the tracings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.TracingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of tracings
    * @param end the upper bound of the range of tracings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of tracings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Tracing> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the tracings from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of tracings.
    *
    * @return the number of tracings
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static TracingPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (TracingPersistence) PortletBeanLocatorUtil.locate(com.gfi.chg.service.ClpSerializer.getServletContextName(),
                    TracingPersistence.class.getName());

            ReferenceRegistry.registerReference(TracingUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(TracingPersistence persistence) {
    }
}
