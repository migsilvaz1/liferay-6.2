package com.gfi.chg.service.persistence;

import com.gfi.chg.model.Contact;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the contact service. This utility wraps {@link ContactPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactPersistence
 * @see ContactPersistenceImpl
 * @generated
 */
public class ContactUtil {
    private static ContactPersistence _persistence;

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
    public static void clearCache(Contact contact) {
        getPersistence().clearCache(contact);
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
    public static List<Contact> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Contact> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Contact> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Contact update(Contact contact) throws SystemException {
        return getPersistence().update(contact);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Contact update(Contact contact, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(contact, serviceContext);
    }

    /**
    * Returns all the contacts where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @return the matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByContactId(
        long contactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByContactId(contactId);
    }

    /**
    * Returns a range of all the contacts where contactId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param contactId the contact ID
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @return the range of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByContactId(
        long contactId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByContactId(contactId, start, end);
    }

    /**
    * Returns an ordered range of all the contacts where contactId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param contactId the contact ID
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByContactId(
        long contactId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactId(contactId, start, end, orderByComparator);
    }

    /**
    * Returns the first contact in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact findByContactId_First(
        long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactId_First(contactId, orderByComparator);
    }

    /**
    * Returns the first contact in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact fetchByContactId_First(
        long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByContactId_First(contactId, orderByComparator);
    }

    /**
    * Returns the last contact in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact findByContactId_Last(
        long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactId_Last(contactId, orderByComparator);
    }

    /**
    * Returns the last contact in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact fetchByContactId_Last(
        long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByContactId_Last(contactId, orderByComparator);
    }

    /**
    * Removes all the contacts where contactId = &#63; from the database.
    *
    * @param contactId the contact ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByContactId(long contactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByContactId(contactId);
    }

    /**
    * Returns the number of contacts where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countByContactId(long contactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByContactId(contactId);
    }

    /**
    * Returns all the contacts where createDate = &#63;.
    *
    * @param createDate the create date
    * @return the matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByCreateDate(
        java.util.Date createDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCreateDate(createDate);
    }

    /**
    * Returns a range of all the contacts where createDate = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param createDate the create date
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @return the range of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByCreateDate(
        java.util.Date createDate, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCreateDate(createDate, start, end);
    }

    /**
    * Returns an ordered range of all the contacts where createDate = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param createDate the create date
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByCreateDate(
        java.util.Date createDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCreateDate(createDate, start, end, orderByComparator);
    }

    /**
    * Returns the first contact in the ordered set where createDate = &#63;.
    *
    * @param createDate the create date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact findByCreateDate_First(
        java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCreateDate_First(createDate, orderByComparator);
    }

    /**
    * Returns the first contact in the ordered set where createDate = &#63;.
    *
    * @param createDate the create date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact fetchByCreateDate_First(
        java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCreateDate_First(createDate, orderByComparator);
    }

    /**
    * Returns the last contact in the ordered set where createDate = &#63;.
    *
    * @param createDate the create date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact findByCreateDate_Last(
        java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCreateDate_Last(createDate, orderByComparator);
    }

    /**
    * Returns the last contact in the ordered set where createDate = &#63;.
    *
    * @param createDate the create date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact fetchByCreateDate_Last(
        java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCreateDate_Last(createDate, orderByComparator);
    }

    /**
    * Returns the contacts before and after the current contact in the ordered set where createDate = &#63;.
    *
    * @param contactId the primary key of the current contact
    * @param createDate the create date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next contact
    * @throws com.gfi.chg.NoSuchContactException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact[] findByCreateDate_PrevAndNext(
        long contactId, java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCreateDate_PrevAndNext(contactId, createDate,
            orderByComparator);
    }

    /**
    * Removes all the contacts where createDate = &#63; from the database.
    *
    * @param createDate the create date
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCreateDate(java.util.Date createDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCreateDate(createDate);
    }

    /**
    * Returns the number of contacts where createDate = &#63;.
    *
    * @param createDate the create date
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countByCreateDate(java.util.Date createDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCreateDate(createDate);
    }

    /**
    * Returns all the contacts where email = &#63;.
    *
    * @param email the email
    * @return the matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByEmail(
        java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmail(email);
    }

    /**
    * Returns a range of all the contacts where email = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param email the email
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @return the range of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByEmail(
        java.lang.String email, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmail(email, start, end);
    }

    /**
    * Returns an ordered range of all the contacts where email = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param email the email
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByEmail(
        java.lang.String email, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmail(email, start, end, orderByComparator);
    }

    /**
    * Returns the first contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact findByEmail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmail_First(email, orderByComparator);
    }

    /**
    * Returns the first contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact fetchByEmail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEmail_First(email, orderByComparator);
    }

    /**
    * Returns the last contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact findByEmail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmail_Last(email, orderByComparator);
    }

    /**
    * Returns the last contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact fetchByEmail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEmail_Last(email, orderByComparator);
    }

    /**
    * Returns the contacts before and after the current contact in the ordered set where email = &#63;.
    *
    * @param contactId the primary key of the current contact
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next contact
    * @throws com.gfi.chg.NoSuchContactException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact[] findByEmail_PrevAndNext(
        long contactId, java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEmail_PrevAndNext(contactId, email, orderByComparator);
    }

    /**
    * Removes all the contacts where email = &#63; from the database.
    *
    * @param email the email
    * @throws SystemException if a system exception occurred
    */
    public static void removeByEmail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByEmail(email);
    }

    /**
    * Returns the number of contacts where email = &#63;.
    *
    * @param email the email
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countByEmail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByEmail(email);
    }

    /**
    * Returns all the contacts where subject = &#63;.
    *
    * @param subject the subject
    * @return the matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findBySubject(
        java.lang.String subject)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySubject(subject);
    }

    /**
    * Returns a range of all the contacts where subject = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param subject the subject
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @return the range of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findBySubject(
        java.lang.String subject, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySubject(subject, start, end);
    }

    /**
    * Returns an ordered range of all the contacts where subject = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param subject the subject
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findBySubject(
        java.lang.String subject, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySubject(subject, start, end, orderByComparator);
    }

    /**
    * Returns the first contact in the ordered set where subject = &#63;.
    *
    * @param subject the subject
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact findBySubject_First(
        java.lang.String subject,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySubject_First(subject, orderByComparator);
    }

    /**
    * Returns the first contact in the ordered set where subject = &#63;.
    *
    * @param subject the subject
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact fetchBySubject_First(
        java.lang.String subject,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBySubject_First(subject, orderByComparator);
    }

    /**
    * Returns the last contact in the ordered set where subject = &#63;.
    *
    * @param subject the subject
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact findBySubject_Last(
        java.lang.String subject,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySubject_Last(subject, orderByComparator);
    }

    /**
    * Returns the last contact in the ordered set where subject = &#63;.
    *
    * @param subject the subject
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact fetchBySubject_Last(
        java.lang.String subject,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBySubject_Last(subject, orderByComparator);
    }

    /**
    * Returns the contacts before and after the current contact in the ordered set where subject = &#63;.
    *
    * @param contactId the primary key of the current contact
    * @param subject the subject
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next contact
    * @throws com.gfi.chg.NoSuchContactException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact[] findBySubject_PrevAndNext(
        long contactId, java.lang.String subject,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySubject_PrevAndNext(contactId, subject,
            orderByComparator);
    }

    /**
    * Removes all the contacts where subject = &#63; from the database.
    *
    * @param subject the subject
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySubject(java.lang.String subject)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBySubject(subject);
    }

    /**
    * Returns the number of contacts where subject = &#63;.
    *
    * @param subject the subject
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countBySubject(java.lang.String subject)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySubject(subject);
    }

    /**
    * Returns all the contacts where status = &#63;.
    *
    * @param status the status
    * @return the matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByStatus(
        int status) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByStatus(status);
    }

    /**
    * Returns a range of all the contacts where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @return the range of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByStatus(
        int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByStatus(status, start, end);
    }

    /**
    * Returns an ordered range of all the contacts where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByStatus(
        int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByStatus(status, start, end, orderByComparator);
    }

    /**
    * Returns the first contact in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact findByStatus_First(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByStatus_First(status, orderByComparator);
    }

    /**
    * Returns the first contact in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact fetchByStatus_First(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByStatus_First(status, orderByComparator);
    }

    /**
    * Returns the last contact in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact findByStatus_Last(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByStatus_Last(status, orderByComparator);
    }

    /**
    * Returns the last contact in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact fetchByStatus_Last(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByStatus_Last(status, orderByComparator);
    }

    /**
    * Returns the contacts before and after the current contact in the ordered set where status = &#63;.
    *
    * @param contactId the primary key of the current contact
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next contact
    * @throws com.gfi.chg.NoSuchContactException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact[] findByStatus_PrevAndNext(
        long contactId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByStatus_PrevAndNext(contactId, status,
            orderByComparator);
    }

    /**
    * Removes all the contacts where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByStatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByStatus(status);
    }

    /**
    * Returns the number of contacts where status = &#63;.
    *
    * @param status the status
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countByStatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByStatus(status);
    }

    /**
    * Returns all the contacts where areaId = &#63;.
    *
    * @param areaId the area ID
    * @return the matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByAreaId(
        long areaId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAreaId(areaId);
    }

    /**
    * Returns a range of all the contacts where areaId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param areaId the area ID
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @return the range of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByAreaId(
        long areaId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAreaId(areaId, start, end);
    }

    /**
    * Returns an ordered range of all the contacts where areaId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param areaId the area ID
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findByAreaId(
        long areaId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAreaId(areaId, start, end, orderByComparator);
    }

    /**
    * Returns the first contact in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact findByAreaId_First(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAreaId_First(areaId, orderByComparator);
    }

    /**
    * Returns the first contact in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact fetchByAreaId_First(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByAreaId_First(areaId, orderByComparator);
    }

    /**
    * Returns the last contact in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact findByAreaId_Last(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAreaId_Last(areaId, orderByComparator);
    }

    /**
    * Returns the last contact in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact fetchByAreaId_Last(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByAreaId_Last(areaId, orderByComparator);
    }

    /**
    * Returns the contacts before and after the current contact in the ordered set where areaId = &#63;.
    *
    * @param contactId the primary key of the current contact
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next contact
    * @throws com.gfi.chg.NoSuchContactException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact[] findByAreaId_PrevAndNext(
        long contactId, long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAreaId_PrevAndNext(contactId, areaId,
            orderByComparator);
    }

    /**
    * Removes all the contacts where areaId = &#63; from the database.
    *
    * @param areaId the area ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAreaId(long areaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAreaId(areaId);
    }

    /**
    * Returns the number of contacts where areaId = &#63;.
    *
    * @param areaId the area ID
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countByAreaId(long areaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAreaId(areaId);
    }

    /**
    * Caches the contact in the entity cache if it is enabled.
    *
    * @param contact the contact
    */
    public static void cacheResult(com.gfi.chg.model.Contact contact) {
        getPersistence().cacheResult(contact);
    }

    /**
    * Caches the contacts in the entity cache if it is enabled.
    *
    * @param contacts the contacts
    */
    public static void cacheResult(
        java.util.List<com.gfi.chg.model.Contact> contacts) {
        getPersistence().cacheResult(contacts);
    }

    /**
    * Creates a new contact with the primary key. Does not add the contact to the database.
    *
    * @param contactId the primary key for the new contact
    * @return the new contact
    */
    public static com.gfi.chg.model.Contact create(long contactId) {
        return getPersistence().create(contactId);
    }

    /**
    * Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contactId the primary key of the contact
    * @return the contact that was removed
    * @throws com.gfi.chg.NoSuchContactException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact remove(long contactId)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(contactId);
    }

    public static com.gfi.chg.model.Contact updateImpl(
        com.gfi.chg.model.Contact contact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(contact);
    }

    /**
    * Returns the contact with the primary key or throws a {@link com.gfi.chg.NoSuchContactException} if it could not be found.
    *
    * @param contactId the primary key of the contact
    * @return the contact
    * @throws com.gfi.chg.NoSuchContactException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact findByPrimaryKey(long contactId)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(contactId);
    }

    /**
    * Returns the contact with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param contactId the primary key of the contact
    * @return the contact, or <code>null</code> if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.gfi.chg.model.Contact fetchByPrimaryKey(long contactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(contactId);
    }

    /**
    * Returns all the contacts.
    *
    * @return the contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the contacts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @return the range of contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the contacts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gfi.chg.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.gfi.chg.model.Contact> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the contacts from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of contacts.
    *
    * @return the number of contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ContactPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ContactPersistence) PortletBeanLocatorUtil.locate(com.gfi.chg.service.ClpSerializer.getServletContextName(),
                    ContactPersistence.class.getName());

            ReferenceRegistry.registerReference(ContactUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ContactPersistence persistence) {
    }
}
