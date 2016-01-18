package com.gfi.chg.service.persistence;

import com.gfi.chg.model.Tracing;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the tracing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TracingPersistenceImpl
 * @see TracingUtil
 * @generated
 */
public interface TracingPersistence extends BasePersistence<Tracing> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link TracingUtil} to access the tracing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the tracings where areaId = &#63;.
    *
    * @param areaId the area ID
    * @return the matching tracings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.gfi.chg.model.Tracing> findByAreaId(long areaId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Tracing> findByAreaId(long areaId,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Tracing> findByAreaId(long areaId,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first tracing in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tracing
    * @throws com.gfi.chg.NoSuchTracingException if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Tracing findByAreaId_First(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first tracing in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tracing, or <code>null</code> if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Tracing fetchByAreaId_First(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last tracing in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tracing
    * @throws com.gfi.chg.NoSuchTracingException if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Tracing findByAreaId_Last(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last tracing in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tracing, or <code>null</code> if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Tracing fetchByAreaId_Last(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.gfi.chg.model.Tracing[] findByAreaId_PrevAndNext(
        long tracingId, long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the tracings where areaId = &#63; from the database.
    *
    * @param areaId the area ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByAreaId(long areaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of tracings where areaId = &#63;.
    *
    * @param areaId the area ID
    * @return the number of matching tracings
    * @throws SystemException if a system exception occurred
    */
    public int countByAreaId(long areaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the tracings where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @return the matching tracings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.gfi.chg.model.Tracing> findByContactId(
        long contactId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Tracing> findByContactId(
        long contactId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Tracing> findByContactId(
        long contactId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first tracing in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tracing
    * @throws com.gfi.chg.NoSuchTracingException if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Tracing findByContactId_First(long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first tracing in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tracing, or <code>null</code> if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Tracing fetchByContactId_First(long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last tracing in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tracing
    * @throws com.gfi.chg.NoSuchTracingException if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Tracing findByContactId_Last(long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last tracing in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tracing, or <code>null</code> if a matching tracing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Tracing fetchByContactId_Last(long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.gfi.chg.model.Tracing[] findByContactId_PrevAndNext(
        long tracingId, long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the tracings where contactId = &#63; from the database.
    *
    * @param contactId the contact ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByContactId(long contactId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of tracings where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @return the number of matching tracings
    * @throws SystemException if a system exception occurred
    */
    public int countByContactId(long contactId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the tracing in the entity cache if it is enabled.
    *
    * @param tracing the tracing
    */
    public void cacheResult(com.gfi.chg.model.Tracing tracing);

    /**
    * Caches the tracings in the entity cache if it is enabled.
    *
    * @param tracings the tracings
    */
    public void cacheResult(java.util.List<com.gfi.chg.model.Tracing> tracings);

    /**
    * Creates a new tracing with the primary key. Does not add the tracing to the database.
    *
    * @param tracingId the primary key for the new tracing
    * @return the new tracing
    */
    public com.gfi.chg.model.Tracing create(long tracingId);

    /**
    * Removes the tracing with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param tracingId the primary key of the tracing
    * @return the tracing that was removed
    * @throws com.gfi.chg.NoSuchTracingException if a tracing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Tracing remove(long tracingId)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.gfi.chg.model.Tracing updateImpl(
        com.gfi.chg.model.Tracing tracing)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the tracing with the primary key or throws a {@link com.gfi.chg.NoSuchTracingException} if it could not be found.
    *
    * @param tracingId the primary key of the tracing
    * @return the tracing
    * @throws com.gfi.chg.NoSuchTracingException if a tracing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Tracing findByPrimaryKey(long tracingId)
        throws com.gfi.chg.NoSuchTracingException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the tracing with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param tracingId the primary key of the tracing
    * @return the tracing, or <code>null</code> if a tracing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Tracing fetchByPrimaryKey(long tracingId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the tracings.
    *
    * @return the tracings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.gfi.chg.model.Tracing> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Tracing> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Tracing> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the tracings from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of tracings.
    *
    * @return the number of tracings
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
