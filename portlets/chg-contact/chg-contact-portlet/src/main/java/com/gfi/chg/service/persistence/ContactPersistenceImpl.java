package com.gfi.chg.service.persistence;

import com.gfi.chg.NoSuchContactException;
import com.gfi.chg.model.Contact;
import com.gfi.chg.model.impl.ContactImpl;
import com.gfi.chg.model.impl.ContactModelImpl;
import com.gfi.chg.service.persistence.ContactPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactPersistence
 * @see ContactUtil
 * @generated
 */
public class ContactPersistenceImpl extends BasePersistenceImpl<Contact>
    implements ContactPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ContactUtil} to access the contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ContactImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTID =
        new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContactId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID =
        new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContactId",
            new String[] { Long.class.getName() },
            ContactModelImpl.CONTACTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTID = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContactId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_CONTACTID_CONTACTID_2 = "contact.contactId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDATE =
        new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreateDate",
            new String[] {
                Date.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE =
        new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreateDate",
            new String[] { Date.class.getName() },
            ContactModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATE = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreateDate",
            new String[] { Date.class.getName() });
    private static final String _FINDER_COLUMN_CREATEDATE_CREATEDATE_1 = "contact.createDate IS NULL";
    private static final String _FINDER_COLUMN_CREATEDATE_CREATEDATE_2 = "contact.createDate = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmail",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmail",
            new String[] { String.class.getName() },
            ContactModelImpl.EMAIL_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "contact.email IS NULL";
    private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "contact.email = ?";
    private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(contact.email IS NULL OR contact.email = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBJECT = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySubject",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBJECT =
        new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySubject",
            new String[] { String.class.getName() },
            ContactModelImpl.SUBJECT_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SUBJECT = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySubject",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_SUBJECT_SUBJECT_1 = "contact.subject IS NULL";
    private static final String _FINDER_COLUMN_SUBJECT_SUBJECT_2 = "contact.subject = ?";
    private static final String _FINDER_COLUMN_SUBJECT_SUBJECT_3 = "(contact.subject IS NULL OR contact.subject = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
        new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
            new String[] { Integer.class.getName() },
            ContactModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "contact.status = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AREAID = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAreaId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREAID =
        new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAreaId",
            new String[] { Long.class.getName() },
            ContactModelImpl.AREAID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_AREAID = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAreaId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_AREAID_AREAID_2 = "contact.areaId = ?";
    private static final String _SQL_SELECT_CONTACT = "SELECT contact FROM Contact contact";
    private static final String _SQL_SELECT_CONTACT_WHERE = "SELECT contact FROM Contact contact WHERE ";
    private static final String _SQL_COUNT_CONTACT = "SELECT COUNT(contact) FROM Contact contact";
    private static final String _SQL_COUNT_CONTACT_WHERE = "SELECT COUNT(contact) FROM Contact contact WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "contact.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Contact exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Contact exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ContactPersistenceImpl.class);
    private static Contact _nullContact = new ContactImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Contact> toCacheModel() {
                return _nullContactCacheModel;
            }
        };

    private static CacheModel<Contact> _nullContactCacheModel = new CacheModel<Contact>() {
            @Override
            public Contact toEntityModel() {
                return _nullContact;
            }
        };

    public ContactPersistenceImpl() {
        setModelClass(Contact.class);
    }

    /**
     * Returns all the contacts where contactId = &#63;.
     *
     * @param contactId the contact ID
     * @return the matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Contact> findByContactId(long contactId)
        throws SystemException {
        return findByContactId(contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<Contact> findByContactId(long contactId, int start, int end)
        throws SystemException {
        return findByContactId(contactId, start, end, null);
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
    @Override
    public List<Contact> findByContactId(long contactId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID;
            finderArgs = new Object[] { contactId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTID;
            finderArgs = new Object[] { contactId, start, end, orderByComparator };
        }

        List<Contact> list = (List<Contact>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Contact contact : list) {
                if ((contactId != contact.getContactId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CONTACT_WHERE);

            query.append(_FINDER_COLUMN_CONTACTID_CONTACTID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ContactModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(contactId);

                if (!pagination) {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Contact>(list);
                } else {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Contact findByContactId_First(long contactId,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchByContactId_First(contactId, orderByComparator);

        if (contact != null) {
            return contact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("contactId=");
        msg.append(contactId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactException(msg.toString());
    }

    /**
     * Returns the first contact in the ordered set where contactId = &#63;.
     *
     * @param contactId the contact ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching contact, or <code>null</code> if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByContactId_First(long contactId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Contact> list = findByContactId(contactId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Contact findByContactId_Last(long contactId,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchByContactId_Last(contactId, orderByComparator);

        if (contact != null) {
            return contact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("contactId=");
        msg.append(contactId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactException(msg.toString());
    }

    /**
     * Returns the last contact in the ordered set where contactId = &#63;.
     *
     * @param contactId the contact ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching contact, or <code>null</code> if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByContactId_Last(long contactId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByContactId(contactId);

        if (count == 0) {
            return null;
        }

        List<Contact> list = findByContactId(contactId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Removes all the contacts where contactId = &#63; from the database.
     *
     * @param contactId the contact ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByContactId(long contactId) throws SystemException {
        for (Contact contact : findByContactId(contactId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(contact);
        }
    }

    /**
     * Returns the number of contacts where contactId = &#63;.
     *
     * @param contactId the contact ID
     * @return the number of matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByContactId(long contactId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACTID;

        Object[] finderArgs = new Object[] { contactId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CONTACT_WHERE);

            query.append(_FINDER_COLUMN_CONTACTID_CONTACTID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(contactId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the contacts where createDate = &#63;.
     *
     * @param createDate the create date
     * @return the matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Contact> findByCreateDate(Date createDate)
        throws SystemException {
        return findByCreateDate(createDate, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Contact> findByCreateDate(Date createDate, int start, int end)
        throws SystemException {
        return findByCreateDate(createDate, start, end, null);
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
    @Override
    public List<Contact> findByCreateDate(Date createDate, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE;
            finderArgs = new Object[] { createDate };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDATE;
            finderArgs = new Object[] { createDate, start, end, orderByComparator };
        }

        List<Contact> list = (List<Contact>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Contact contact : list) {
                if (!Validator.equals(createDate, contact.getCreateDate())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CONTACT_WHERE);

            boolean bindCreateDate = false;

            if (createDate == null) {
                query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
            } else {
                bindCreateDate = true;

                query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ContactModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCreateDate) {
                    qPos.add(CalendarUtil.getTimestamp(createDate));
                }

                if (!pagination) {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Contact>(list);
                } else {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Contact findByCreateDate_First(Date createDate,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchByCreateDate_First(createDate, orderByComparator);

        if (contact != null) {
            return contact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("createDate=");
        msg.append(createDate);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactException(msg.toString());
    }

    /**
     * Returns the first contact in the ordered set where createDate = &#63;.
     *
     * @param createDate the create date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching contact, or <code>null</code> if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByCreateDate_First(Date createDate,
        OrderByComparator orderByComparator) throws SystemException {
        List<Contact> list = findByCreateDate(createDate, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Contact findByCreateDate_Last(Date createDate,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchByCreateDate_Last(createDate, orderByComparator);

        if (contact != null) {
            return contact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("createDate=");
        msg.append(createDate);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactException(msg.toString());
    }

    /**
     * Returns the last contact in the ordered set where createDate = &#63;.
     *
     * @param createDate the create date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching contact, or <code>null</code> if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByCreateDate_Last(Date createDate,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCreateDate(createDate);

        if (count == 0) {
            return null;
        }

        List<Contact> list = findByCreateDate(createDate, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Contact[] findByCreateDate_PrevAndNext(long contactId,
        Date createDate, OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = findByPrimaryKey(contactId);

        Session session = null;

        try {
            session = openSession();

            Contact[] array = new ContactImpl[3];

            array[0] = getByCreateDate_PrevAndNext(session, contact,
                    createDate, orderByComparator, true);

            array[1] = contact;

            array[2] = getByCreateDate_PrevAndNext(session, contact,
                    createDate, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Contact getByCreateDate_PrevAndNext(Session session,
        Contact contact, Date createDate, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONTACT_WHERE);

        boolean bindCreateDate = false;

        if (createDate == null) {
            query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
        } else {
            bindCreateDate = true;

            query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ContactModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindCreateDate) {
            qPos.add(CalendarUtil.getTimestamp(createDate));
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(contact);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Contact> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the contacts where createDate = &#63; from the database.
     *
     * @param createDate the create date
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCreateDate(Date createDate) throws SystemException {
        for (Contact contact : findByCreateDate(createDate, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(contact);
        }
    }

    /**
     * Returns the number of contacts where createDate = &#63;.
     *
     * @param createDate the create date
     * @return the number of matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCreateDate(Date createDate) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATEDATE;

        Object[] finderArgs = new Object[] { createDate };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CONTACT_WHERE);

            boolean bindCreateDate = false;

            if (createDate == null) {
                query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
            } else {
                bindCreateDate = true;

                query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCreateDate) {
                    qPos.add(CalendarUtil.getTimestamp(createDate));
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the contacts where email = &#63;.
     *
     * @param email the email
     * @return the matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Contact> findByEmail(String email) throws SystemException {
        return findByEmail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Contact> findByEmail(String email, int start, int end)
        throws SystemException {
        return findByEmail(email, start, end, null);
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
    @Override
    public List<Contact> findByEmail(String email, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL;
            finderArgs = new Object[] { email };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL;
            finderArgs = new Object[] { email, start, end, orderByComparator };
        }

        List<Contact> list = (List<Contact>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Contact contact : list) {
                if (!Validator.equals(email, contact.getEmail())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CONTACT_WHERE);

            boolean bindEmail = false;

            if (email == null) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
            } else if (email.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
            } else {
                bindEmail = true;

                query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ContactModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEmail) {
                    qPos.add(email);
                }

                if (!pagination) {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Contact>(list);
                } else {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Contact findByEmail_First(String email,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchByEmail_First(email, orderByComparator);

        if (contact != null) {
            return contact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("email=");
        msg.append(email);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactException(msg.toString());
    }

    /**
     * Returns the first contact in the ordered set where email = &#63;.
     *
     * @param email the email
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching contact, or <code>null</code> if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByEmail_First(String email,
        OrderByComparator orderByComparator) throws SystemException {
        List<Contact> list = findByEmail(email, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Contact findByEmail_Last(String email,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchByEmail_Last(email, orderByComparator);

        if (contact != null) {
            return contact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("email=");
        msg.append(email);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactException(msg.toString());
    }

    /**
     * Returns the last contact in the ordered set where email = &#63;.
     *
     * @param email the email
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching contact, or <code>null</code> if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByEmail_Last(String email,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByEmail(email);

        if (count == 0) {
            return null;
        }

        List<Contact> list = findByEmail(email, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Contact[] findByEmail_PrevAndNext(long contactId, String email,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = findByPrimaryKey(contactId);

        Session session = null;

        try {
            session = openSession();

            Contact[] array = new ContactImpl[3];

            array[0] = getByEmail_PrevAndNext(session, contact, email,
                    orderByComparator, true);

            array[1] = contact;

            array[2] = getByEmail_PrevAndNext(session, contact, email,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Contact getByEmail_PrevAndNext(Session session, Contact contact,
        String email, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONTACT_WHERE);

        boolean bindEmail = false;

        if (email == null) {
            query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
        } else if (email.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
        } else {
            bindEmail = true;

            query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ContactModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindEmail) {
            qPos.add(email);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(contact);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Contact> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the contacts where email = &#63; from the database.
     *
     * @param email the email
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByEmail(String email) throws SystemException {
        for (Contact contact : findByEmail(email, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(contact);
        }
    }

    /**
     * Returns the number of contacts where email = &#63;.
     *
     * @param email the email
     * @return the number of matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByEmail(String email) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAIL;

        Object[] finderArgs = new Object[] { email };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CONTACT_WHERE);

            boolean bindEmail = false;

            if (email == null) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
            } else if (email.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
            } else {
                bindEmail = true;

                query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEmail) {
                    qPos.add(email);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the contacts where subject = &#63;.
     *
     * @param subject the subject
     * @return the matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Contact> findBySubject(String subject)
        throws SystemException {
        return findBySubject(subject, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Contact> findBySubject(String subject, int start, int end)
        throws SystemException {
        return findBySubject(subject, start, end, null);
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
    @Override
    public List<Contact> findBySubject(String subject, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBJECT;
            finderArgs = new Object[] { subject };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBJECT;
            finderArgs = new Object[] { subject, start, end, orderByComparator };
        }

        List<Contact> list = (List<Contact>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Contact contact : list) {
                if (!Validator.equals(subject, contact.getSubject())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CONTACT_WHERE);

            boolean bindSubject = false;

            if (subject == null) {
                query.append(_FINDER_COLUMN_SUBJECT_SUBJECT_1);
            } else if (subject.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SUBJECT_SUBJECT_3);
            } else {
                bindSubject = true;

                query.append(_FINDER_COLUMN_SUBJECT_SUBJECT_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ContactModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindSubject) {
                    qPos.add(subject);
                }

                if (!pagination) {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Contact>(list);
                } else {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Contact findBySubject_First(String subject,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchBySubject_First(subject, orderByComparator);

        if (contact != null) {
            return contact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("subject=");
        msg.append(subject);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactException(msg.toString());
    }

    /**
     * Returns the first contact in the ordered set where subject = &#63;.
     *
     * @param subject the subject
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching contact, or <code>null</code> if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchBySubject_First(String subject,
        OrderByComparator orderByComparator) throws SystemException {
        List<Contact> list = findBySubject(subject, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Contact findBySubject_Last(String subject,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchBySubject_Last(subject, orderByComparator);

        if (contact != null) {
            return contact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("subject=");
        msg.append(subject);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactException(msg.toString());
    }

    /**
     * Returns the last contact in the ordered set where subject = &#63;.
     *
     * @param subject the subject
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching contact, or <code>null</code> if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchBySubject_Last(String subject,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySubject(subject);

        if (count == 0) {
            return null;
        }

        List<Contact> list = findBySubject(subject, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Contact[] findBySubject_PrevAndNext(long contactId, String subject,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = findByPrimaryKey(contactId);

        Session session = null;

        try {
            session = openSession();

            Contact[] array = new ContactImpl[3];

            array[0] = getBySubject_PrevAndNext(session, contact, subject,
                    orderByComparator, true);

            array[1] = contact;

            array[2] = getBySubject_PrevAndNext(session, contact, subject,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Contact getBySubject_PrevAndNext(Session session,
        Contact contact, String subject, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONTACT_WHERE);

        boolean bindSubject = false;

        if (subject == null) {
            query.append(_FINDER_COLUMN_SUBJECT_SUBJECT_1);
        } else if (subject.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_SUBJECT_SUBJECT_3);
        } else {
            bindSubject = true;

            query.append(_FINDER_COLUMN_SUBJECT_SUBJECT_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ContactModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindSubject) {
            qPos.add(subject);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(contact);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Contact> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the contacts where subject = &#63; from the database.
     *
     * @param subject the subject
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySubject(String subject) throws SystemException {
        for (Contact contact : findBySubject(subject, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(contact);
        }
    }

    /**
     * Returns the number of contacts where subject = &#63;.
     *
     * @param subject the subject
     * @return the number of matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySubject(String subject) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SUBJECT;

        Object[] finderArgs = new Object[] { subject };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CONTACT_WHERE);

            boolean bindSubject = false;

            if (subject == null) {
                query.append(_FINDER_COLUMN_SUBJECT_SUBJECT_1);
            } else if (subject.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SUBJECT_SUBJECT_3);
            } else {
                bindSubject = true;

                query.append(_FINDER_COLUMN_SUBJECT_SUBJECT_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindSubject) {
                    qPos.add(subject);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the contacts where status = &#63;.
     *
     * @param status the status
     * @return the matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Contact> findByStatus(int status) throws SystemException {
        return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Contact> findByStatus(int status, int start, int end)
        throws SystemException {
        return findByStatus(status, start, end, null);
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
    @Override
    public List<Contact> findByStatus(int status, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
            finderArgs = new Object[] { status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
            finderArgs = new Object[] { status, start, end, orderByComparator };
        }

        List<Contact> list = (List<Contact>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Contact contact : list) {
                if ((status != contact.getStatus())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CONTACT_WHERE);

            query.append(_FINDER_COLUMN_STATUS_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ContactModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Contact>(list);
                } else {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Contact findByStatus_First(int status,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchByStatus_First(status, orderByComparator);

        if (contact != null) {
            return contact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactException(msg.toString());
    }

    /**
     * Returns the first contact in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching contact, or <code>null</code> if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByStatus_First(int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Contact> list = findByStatus(status, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Contact findByStatus_Last(int status,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchByStatus_Last(status, orderByComparator);

        if (contact != null) {
            return contact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactException(msg.toString());
    }

    /**
     * Returns the last contact in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching contact, or <code>null</code> if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByStatus_Last(int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByStatus(status);

        if (count == 0) {
            return null;
        }

        List<Contact> list = findByStatus(status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Contact[] findByStatus_PrevAndNext(long contactId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = findByPrimaryKey(contactId);

        Session session = null;

        try {
            session = openSession();

            Contact[] array = new ContactImpl[3];

            array[0] = getByStatus_PrevAndNext(session, contact, status,
                    orderByComparator, true);

            array[1] = contact;

            array[2] = getByStatus_PrevAndNext(session, contact, status,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Contact getByStatus_PrevAndNext(Session session, Contact contact,
        int status, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONTACT_WHERE);

        query.append(_FINDER_COLUMN_STATUS_STATUS_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ContactModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(contact);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Contact> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the contacts where status = &#63; from the database.
     *
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByStatus(int status) throws SystemException {
        for (Contact contact : findByStatus(status, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(contact);
        }
    }

    /**
     * Returns the number of contacts where status = &#63;.
     *
     * @param status the status
     * @return the number of matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByStatus(int status) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

        Object[] finderArgs = new Object[] { status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CONTACT_WHERE);

            query.append(_FINDER_COLUMN_STATUS_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(status);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the contacts where areaId = &#63;.
     *
     * @param areaId the area ID
     * @return the matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Contact> findByAreaId(long areaId) throws SystemException {
        return findByAreaId(areaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Contact> findByAreaId(long areaId, int start, int end)
        throws SystemException {
        return findByAreaId(areaId, start, end, null);
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
    @Override
    public List<Contact> findByAreaId(long areaId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREAID;
            finderArgs = new Object[] { areaId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AREAID;
            finderArgs = new Object[] { areaId, start, end, orderByComparator };
        }

        List<Contact> list = (List<Contact>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Contact contact : list) {
                if ((areaId != contact.getAreaId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CONTACT_WHERE);

            query.append(_FINDER_COLUMN_AREAID_AREAID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ContactModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(areaId);

                if (!pagination) {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Contact>(list);
                } else {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Contact findByAreaId_First(long areaId,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchByAreaId_First(areaId, orderByComparator);

        if (contact != null) {
            return contact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("areaId=");
        msg.append(areaId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactException(msg.toString());
    }

    /**
     * Returns the first contact in the ordered set where areaId = &#63;.
     *
     * @param areaId the area ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching contact, or <code>null</code> if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByAreaId_First(long areaId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Contact> list = findByAreaId(areaId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Contact findByAreaId_Last(long areaId,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchByAreaId_Last(areaId, orderByComparator);

        if (contact != null) {
            return contact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("areaId=");
        msg.append(areaId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactException(msg.toString());
    }

    /**
     * Returns the last contact in the ordered set where areaId = &#63;.
     *
     * @param areaId the area ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching contact, or <code>null</code> if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByAreaId_Last(long areaId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByAreaId(areaId);

        if (count == 0) {
            return null;
        }

        List<Contact> list = findByAreaId(areaId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Contact[] findByAreaId_PrevAndNext(long contactId, long areaId,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = findByPrimaryKey(contactId);

        Session session = null;

        try {
            session = openSession();

            Contact[] array = new ContactImpl[3];

            array[0] = getByAreaId_PrevAndNext(session, contact, areaId,
                    orderByComparator, true);

            array[1] = contact;

            array[2] = getByAreaId_PrevAndNext(session, contact, areaId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Contact getByAreaId_PrevAndNext(Session session, Contact contact,
        long areaId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONTACT_WHERE);

        query.append(_FINDER_COLUMN_AREAID_AREAID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ContactModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(areaId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(contact);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Contact> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the contacts where areaId = &#63; from the database.
     *
     * @param areaId the area ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAreaId(long areaId) throws SystemException {
        for (Contact contact : findByAreaId(areaId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(contact);
        }
    }

    /**
     * Returns the number of contacts where areaId = &#63;.
     *
     * @param areaId the area ID
     * @return the number of matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAreaId(long areaId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_AREAID;

        Object[] finderArgs = new Object[] { areaId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CONTACT_WHERE);

            query.append(_FINDER_COLUMN_AREAID_AREAID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(areaId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the contact in the entity cache if it is enabled.
     *
     * @param contact the contact
     */
    @Override
    public void cacheResult(Contact contact) {
        EntityCacheUtil.putResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactImpl.class, contact.getPrimaryKey(), contact);

        contact.resetOriginalValues();
    }

    /**
     * Caches the contacts in the entity cache if it is enabled.
     *
     * @param contacts the contacts
     */
    @Override
    public void cacheResult(List<Contact> contacts) {
        for (Contact contact : contacts) {
            if (EntityCacheUtil.getResult(
                        ContactModelImpl.ENTITY_CACHE_ENABLED,
                        ContactImpl.class, contact.getPrimaryKey()) == null) {
                cacheResult(contact);
            } else {
                contact.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all contacts.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ContactImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ContactImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the contact.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Contact contact) {
        EntityCacheUtil.removeResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactImpl.class, contact.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Contact> contacts) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Contact contact : contacts) {
            EntityCacheUtil.removeResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
                ContactImpl.class, contact.getPrimaryKey());
        }
    }

    /**
     * Creates a new contact with the primary key. Does not add the contact to the database.
     *
     * @param contactId the primary key for the new contact
     * @return the new contact
     */
    @Override
    public Contact create(long contactId) {
        Contact contact = new ContactImpl();

        contact.setNew(true);
        contact.setPrimaryKey(contactId);

        return contact;
    }

    /**
     * Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param contactId the primary key of the contact
     * @return the contact that was removed
     * @throws com.gfi.chg.NoSuchContactException if a contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact remove(long contactId)
        throws NoSuchContactException, SystemException {
        return remove((Serializable) contactId);
    }

    /**
     * Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the contact
     * @return the contact that was removed
     * @throws com.gfi.chg.NoSuchContactException if a contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact remove(Serializable primaryKey)
        throws NoSuchContactException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Contact contact = (Contact) session.get(ContactImpl.class,
                    primaryKey);

            if (contact == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(contact);
        } catch (NoSuchContactException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Contact removeImpl(Contact contact) throws SystemException {
        contact = toUnwrappedModel(contact);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(contact)) {
                contact = (Contact) session.get(ContactImpl.class,
                        contact.getPrimaryKeyObj());
            }

            if (contact != null) {
                session.delete(contact);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (contact != null) {
            clearCache(contact);
        }

        return contact;
    }

    @Override
    public Contact updateImpl(com.gfi.chg.model.Contact contact)
        throws SystemException {
        contact = toUnwrappedModel(contact);

        boolean isNew = contact.isNew();

        ContactModelImpl contactModelImpl = (ContactModelImpl) contact;

        Session session = null;

        try {
            session = openSession();

            if (contact.isNew()) {
                session.save(contact);

                contact.setNew(false);
            } else {
                session.merge(contact);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ContactModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((contactModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        contactModelImpl.getOriginalContactId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID,
                    args);

                args = new Object[] { contactModelImpl.getContactId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID,
                    args);
            }

            if ((contactModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        contactModelImpl.getOriginalCreateDate()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDATE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE,
                    args);

                args = new Object[] { contactModelImpl.getCreateDate() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDATE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE,
                    args);
            }

            if ((contactModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { contactModelImpl.getOriginalEmail() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
                    args);

                args = new Object[] { contactModelImpl.getEmail() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
                    args);
            }

            if ((contactModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBJECT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        contactModelImpl.getOriginalSubject()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBJECT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBJECT,
                    args);

                args = new Object[] { contactModelImpl.getSubject() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBJECT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBJECT,
                    args);
            }

            if ((contactModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        contactModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
                    args);

                args = new Object[] { contactModelImpl.getStatus() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
                    args);
            }

            if ((contactModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREAID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        contactModelImpl.getOriginalAreaId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AREAID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREAID,
                    args);

                args = new Object[] { contactModelImpl.getAreaId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AREAID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREAID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactImpl.class, contact.getPrimaryKey(), contact);

        return contact;
    }

    protected Contact toUnwrappedModel(Contact contact) {
        if (contact instanceof ContactImpl) {
            return contact;
        }

        ContactImpl contactImpl = new ContactImpl();

        contactImpl.setNew(contact.isNew());
        contactImpl.setPrimaryKey(contact.getPrimaryKey());

        contactImpl.setContactId(contact.getContactId());
        contactImpl.setAreaId(contact.getAreaId());
        contactImpl.setCreateDate(contact.getCreateDate());
        contactImpl.setStatus(contact.getStatus());
        contactImpl.setName(contact.getName());
        contactImpl.setSurname(contact.getSurname());
        contactImpl.setActivity(contact.getActivity());
        contactImpl.setAddress(contact.getAddress());
        contactImpl.setCity(contact.getCity());
        contactImpl.setPostalCode(contact.getPostalCode());
        contactImpl.setEmail(contact.getEmail());
        contactImpl.setTelephone(contact.getTelephone());
        contactImpl.setSubject(contact.getSubject());
        contactImpl.setDescription(contact.getDescription());
        contactImpl.setResponse(contact.getResponse());

        return contactImpl;
    }

    /**
     * Returns the contact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the contact
     * @return the contact
     * @throws com.gfi.chg.NoSuchContactException if a contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact findByPrimaryKey(Serializable primaryKey)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchByPrimaryKey(primaryKey);

        if (contact == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return contact;
    }

    /**
     * Returns the contact with the primary key or throws a {@link com.gfi.chg.NoSuchContactException} if it could not be found.
     *
     * @param contactId the primary key of the contact
     * @return the contact
     * @throws com.gfi.chg.NoSuchContactException if a contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact findByPrimaryKey(long contactId)
        throws NoSuchContactException, SystemException {
        return findByPrimaryKey((Serializable) contactId);
    }

    /**
     * Returns the contact with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the contact
     * @return the contact, or <code>null</code> if a contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Contact contact = (Contact) EntityCacheUtil.getResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
                ContactImpl.class, primaryKey);

        if (contact == _nullContact) {
            return null;
        }

        if (contact == null) {
            Session session = null;

            try {
                session = openSession();

                contact = (Contact) session.get(ContactImpl.class, primaryKey);

                if (contact != null) {
                    cacheResult(contact);
                } else {
                    EntityCacheUtil.putResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
                        ContactImpl.class, primaryKey, _nullContact);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
                    ContactImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return contact;
    }

    /**
     * Returns the contact with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param contactId the primary key of the contact
     * @return the contact, or <code>null</code> if a contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByPrimaryKey(long contactId) throws SystemException {
        return fetchByPrimaryKey((Serializable) contactId);
    }

    /**
     * Returns all the contacts.
     *
     * @return the contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Contact> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Contact> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Contact> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Contact> list = (List<Contact>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CONTACT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CONTACT;

                if (pagination) {
                    sql = sql.concat(ContactModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Contact>(list);
                } else {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the contacts from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Contact contact : findAll()) {
            remove(contact);
        }
    }

    /**
     * Returns the number of contacts.
     *
     * @return the number of contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CONTACT);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the contact persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.gfi.chg.model.Contact")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Contact>> listenersList = new ArrayList<ModelListener<Contact>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Contact>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ContactImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
