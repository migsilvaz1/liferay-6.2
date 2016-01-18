package com.gfi.chg.service.persistence;

import com.gfi.chg.model.Contact;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactPersistenceImpl
 * @see ContactUtil
 * @generated
 */
public interface ContactPersistence extends BasePersistence<Contact> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ContactUtil} to access the contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the contacts where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @return the matching contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.gfi.chg.model.Contact> findByContactId(
        long contactId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Contact> findByContactId(
        long contactId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Contact> findByContactId(
        long contactId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contact in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact findByContactId_First(long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contact in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact fetchByContactId_First(long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contact in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact findByContactId_Last(long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contact in the ordered set where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact fetchByContactId_Last(long contactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the contacts where contactId = &#63; from the database.
    *
    * @param contactId the contact ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByContactId(long contactId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contacts where contactId = &#63;.
    *
    * @param contactId the contact ID
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public int countByContactId(long contactId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the contacts where createDate = &#63;.
    *
    * @param createDate the create date
    * @return the matching contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.gfi.chg.model.Contact> findByCreateDate(
        java.util.Date createDate)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Contact> findByCreateDate(
        java.util.Date createDate, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Contact> findByCreateDate(
        java.util.Date createDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contact in the ordered set where createDate = &#63;.
    *
    * @param createDate the create date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact findByCreateDate_First(
        java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contact in the ordered set where createDate = &#63;.
    *
    * @param createDate the create date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact fetchByCreateDate_First(
        java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contact in the ordered set where createDate = &#63;.
    *
    * @param createDate the create date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact findByCreateDate_Last(
        java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contact in the ordered set where createDate = &#63;.
    *
    * @param createDate the create date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact fetchByCreateDate_Last(
        java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.gfi.chg.model.Contact[] findByCreateDate_PrevAndNext(
        long contactId, java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the contacts where createDate = &#63; from the database.
    *
    * @param createDate the create date
    * @throws SystemException if a system exception occurred
    */
    public void removeByCreateDate(java.util.Date createDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contacts where createDate = &#63;.
    *
    * @param createDate the create date
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public int countByCreateDate(java.util.Date createDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the contacts where email = &#63;.
    *
    * @param email the email
    * @return the matching contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.gfi.chg.model.Contact> findByEmail(
        java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Contact> findByEmail(
        java.lang.String email, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Contact> findByEmail(
        java.lang.String email, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact findByEmail_First(java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact fetchByEmail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact findByEmail_Last(java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact fetchByEmail_Last(java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.gfi.chg.model.Contact[] findByEmail_PrevAndNext(long contactId,
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the contacts where email = &#63; from the database.
    *
    * @param email the email
    * @throws SystemException if a system exception occurred
    */
    public void removeByEmail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contacts where email = &#63;.
    *
    * @param email the email
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public int countByEmail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the contacts where subject = &#63;.
    *
    * @param subject the subject
    * @return the matching contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.gfi.chg.model.Contact> findBySubject(
        java.lang.String subject)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Contact> findBySubject(
        java.lang.String subject, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Contact> findBySubject(
        java.lang.String subject, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contact in the ordered set where subject = &#63;.
    *
    * @param subject the subject
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact findBySubject_First(
        java.lang.String subject,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contact in the ordered set where subject = &#63;.
    *
    * @param subject the subject
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact fetchBySubject_First(
        java.lang.String subject,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contact in the ordered set where subject = &#63;.
    *
    * @param subject the subject
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact findBySubject_Last(
        java.lang.String subject,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contact in the ordered set where subject = &#63;.
    *
    * @param subject the subject
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact fetchBySubject_Last(
        java.lang.String subject,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.gfi.chg.model.Contact[] findBySubject_PrevAndNext(
        long contactId, java.lang.String subject,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the contacts where subject = &#63; from the database.
    *
    * @param subject the subject
    * @throws SystemException if a system exception occurred
    */
    public void removeBySubject(java.lang.String subject)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contacts where subject = &#63;.
    *
    * @param subject the subject
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public int countBySubject(java.lang.String subject)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the contacts where status = &#63;.
    *
    * @param status the status
    * @return the matching contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.gfi.chg.model.Contact> findByStatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Contact> findByStatus(int status,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Contact> findByStatus(int status,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contact in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact findByStatus_First(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contact in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact fetchByStatus_First(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contact in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact findByStatus_Last(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contact in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact fetchByStatus_Last(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.gfi.chg.model.Contact[] findByStatus_PrevAndNext(
        long contactId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the contacts where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByStatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contacts where status = &#63;.
    *
    * @param status the status
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public int countByStatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the contacts where areaId = &#63;.
    *
    * @param areaId the area ID
    * @return the matching contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.gfi.chg.model.Contact> findByAreaId(long areaId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Contact> findByAreaId(long areaId,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Contact> findByAreaId(long areaId,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contact in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact findByAreaId_First(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contact in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact fetchByAreaId_First(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contact in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact
    * @throws com.gfi.chg.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact findByAreaId_Last(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contact in the ordered set where areaId = &#63;.
    *
    * @param areaId the area ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact fetchByAreaId_Last(long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.gfi.chg.model.Contact[] findByAreaId_PrevAndNext(
        long contactId, long areaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the contacts where areaId = &#63; from the database.
    *
    * @param areaId the area ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByAreaId(long areaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contacts where areaId = &#63;.
    *
    * @param areaId the area ID
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public int countByAreaId(long areaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the contact in the entity cache if it is enabled.
    *
    * @param contact the contact
    */
    public void cacheResult(com.gfi.chg.model.Contact contact);

    /**
    * Caches the contacts in the entity cache if it is enabled.
    *
    * @param contacts the contacts
    */
    public void cacheResult(java.util.List<com.gfi.chg.model.Contact> contacts);

    /**
    * Creates a new contact with the primary key. Does not add the contact to the database.
    *
    * @param contactId the primary key for the new contact
    * @return the new contact
    */
    public com.gfi.chg.model.Contact create(long contactId);

    /**
    * Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contactId the primary key of the contact
    * @return the contact that was removed
    * @throws com.gfi.chg.NoSuchContactException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact remove(long contactId)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.gfi.chg.model.Contact updateImpl(
        com.gfi.chg.model.Contact contact)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contact with the primary key or throws a {@link com.gfi.chg.NoSuchContactException} if it could not be found.
    *
    * @param contactId the primary key of the contact
    * @return the contact
    * @throws com.gfi.chg.NoSuchContactException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact findByPrimaryKey(long contactId)
        throws com.gfi.chg.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contact with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param contactId the primary key of the contact
    * @return the contact, or <code>null</code> if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.gfi.chg.model.Contact fetchByPrimaryKey(long contactId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the contacts.
    *
    * @return the contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.gfi.chg.model.Contact> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Contact> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.gfi.chg.model.Contact> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the contacts from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contacts.
    *
    * @return the number of contacts
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
