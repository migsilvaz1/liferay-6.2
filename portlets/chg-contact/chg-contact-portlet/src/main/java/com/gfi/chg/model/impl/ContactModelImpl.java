package com.gfi.chg.model.impl;

import com.gfi.chg.model.Contact;
import com.gfi.chg.model.ContactModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Contact service. Represents a row in the &quot;chg_Contact&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.gfi.chg.model.ContactModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContactImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactImpl
 * @see com.gfi.chg.model.Contact
 * @see com.gfi.chg.model.ContactModel
 * @generated
 */
public class ContactModelImpl extends BaseModelImpl<Contact>
    implements ContactModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a contact model instance should use the {@link com.gfi.chg.model.Contact} interface instead.
     */
    public static final String TABLE_NAME = "chg_Contact";
    public static final Object[][] TABLE_COLUMNS = {
            { "contactId", Types.BIGINT },
            { "areaId", Types.BIGINT },
            { "createDate", Types.TIMESTAMP },
            { "status", Types.INTEGER },
            { "name", Types.VARCHAR },
            { "surname", Types.VARCHAR },
            { "activity", Types.VARCHAR },
            { "address", Types.VARCHAR },
            { "city", Types.VARCHAR },
            { "postalCode", Types.VARCHAR },
            { "email", Types.VARCHAR },
            { "telephone", Types.VARCHAR },
            { "subject", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "response", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table chg_Contact (contactId LONG not null primary key,areaId LONG,createDate DATE null,status INTEGER,name VARCHAR(250) null,surname VARCHAR(250) null,activity VARCHAR(250) null,address VARCHAR(500) null,city VARCHAR(75) null,postalCode VARCHAR(75) null,email VARCHAR(75) null,telephone VARCHAR(75) null,subject VARCHAR(250) null,description VARCHAR(500) null,response VARCHAR(500) null)";
    public static final String TABLE_SQL_DROP = "drop table chg_Contact";
    public static final String ORDER_BY_JPQL = " ORDER BY contact.contactId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY chg_Contact.contactId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.gfi.chg.model.Contact"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.gfi.chg.model.Contact"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.gfi.chg.model.Contact"),
            true);
    public static long AREAID_COLUMN_BITMASK = 1L;
    public static long CONTACTID_COLUMN_BITMASK = 2L;
    public static long CREATEDATE_COLUMN_BITMASK = 4L;
    public static long EMAIL_COLUMN_BITMASK = 8L;
    public static long STATUS_COLUMN_BITMASK = 16L;
    public static long SUBJECT_COLUMN_BITMASK = 32L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.gfi.chg.model.Contact"));
    private static ClassLoader _classLoader = Contact.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Contact.class
        };
    private long _contactId;
    private long _originalContactId;
    private boolean _setOriginalContactId;
    private long _areaId;
    private long _originalAreaId;
    private boolean _setOriginalAreaId;
    private Date _createDate;
    private Date _originalCreateDate;
    private int _status;
    private int _originalStatus;
    private boolean _setOriginalStatus;
    private String _name;
    private String _surname;
    private String _activity;
    private String _address;
    private String _city;
    private String _postalCode;
    private String _email;
    private String _originalEmail;
    private String _telephone;
    private String _subject;
    private String _originalSubject;
    private String _description;
    private String _response;
    private long _columnBitmask;
    private Contact _escapedModel;

    public ContactModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _contactId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setContactId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _contactId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Contact.class;
    }

    @Override
    public String getModelClassName() {
        return Contact.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("contactId", getContactId());
        attributes.put("areaId", getAreaId());
        attributes.put("createDate", getCreateDate());
        attributes.put("status", getStatus());
        attributes.put("name", getName());
        attributes.put("surname", getSurname());
        attributes.put("activity", getActivity());
        attributes.put("address", getAddress());
        attributes.put("city", getCity());
        attributes.put("postalCode", getPostalCode());
        attributes.put("email", getEmail());
        attributes.put("telephone", getTelephone());
        attributes.put("subject", getSubject());
        attributes.put("description", getDescription());
        attributes.put("response", getResponse());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long contactId = (Long) attributes.get("contactId");

        if (contactId != null) {
            setContactId(contactId);
        }

        Long areaId = (Long) attributes.get("areaId");

        if (areaId != null) {
            setAreaId(areaId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String surname = (String) attributes.get("surname");

        if (surname != null) {
            setSurname(surname);
        }

        String activity = (String) attributes.get("activity");

        if (activity != null) {
            setActivity(activity);
        }

        String address = (String) attributes.get("address");

        if (address != null) {
            setAddress(address);
        }

        String city = (String) attributes.get("city");

        if (city != null) {
            setCity(city);
        }

        String postalCode = (String) attributes.get("postalCode");

        if (postalCode != null) {
            setPostalCode(postalCode);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String telephone = (String) attributes.get("telephone");

        if (telephone != null) {
            setTelephone(telephone);
        }

        String subject = (String) attributes.get("subject");

        if (subject != null) {
            setSubject(subject);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String response = (String) attributes.get("response");

        if (response != null) {
            setResponse(response);
        }
    }

    @Override
    public long getContactId() {
        return _contactId;
    }

    @Override
    public void setContactId(long contactId) {
        _columnBitmask |= CONTACTID_COLUMN_BITMASK;

        if (!_setOriginalContactId) {
            _setOriginalContactId = true;

            _originalContactId = _contactId;
        }

        _contactId = contactId;
    }

    public long getOriginalContactId() {
        return _originalContactId;
    }

    @Override
    public long getAreaId() {
        return _areaId;
    }

    @Override
    public void setAreaId(long areaId) {
        _columnBitmask |= AREAID_COLUMN_BITMASK;

        if (!_setOriginalAreaId) {
            _setOriginalAreaId = true;

            _originalAreaId = _areaId;
        }

        _areaId = areaId;
    }

    public long getOriginalAreaId() {
        return _originalAreaId;
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _columnBitmask |= CREATEDATE_COLUMN_BITMASK;

        if (_originalCreateDate == null) {
            _originalCreateDate = _createDate;
        }

        _createDate = createDate;
    }

    public Date getOriginalCreateDate() {
        return _originalCreateDate;
    }

    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _columnBitmask |= STATUS_COLUMN_BITMASK;

        if (!_setOriginalStatus) {
            _setOriginalStatus = true;

            _originalStatus = _status;
        }

        _status = status;
    }

    public int getOriginalStatus() {
        return _originalStatus;
    }

    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @Override
    public String getSurname() {
        if (_surname == null) {
            return StringPool.BLANK;
        } else {
            return _surname;
        }
    }

    @Override
    public void setSurname(String surname) {
        _surname = surname;
    }

    @Override
    public String getActivity() {
        if (_activity == null) {
            return StringPool.BLANK;
        } else {
            return _activity;
        }
    }

    @Override
    public void setActivity(String activity) {
        _activity = activity;
    }

    @Override
    public String getAddress() {
        if (_address == null) {
            return StringPool.BLANK;
        } else {
            return _address;
        }
    }

    @Override
    public void setAddress(String address) {
        _address = address;
    }

    @Override
    public String getCity() {
        if (_city == null) {
            return StringPool.BLANK;
        } else {
            return _city;
        }
    }

    @Override
    public void setCity(String city) {
        _city = city;
    }

    @Override
    public String getPostalCode() {
        if (_postalCode == null) {
            return StringPool.BLANK;
        } else {
            return _postalCode;
        }
    }

    @Override
    public void setPostalCode(String postalCode) {
        _postalCode = postalCode;
    }

    @Override
    public String getEmail() {
        if (_email == null) {
            return StringPool.BLANK;
        } else {
            return _email;
        }
    }

    @Override
    public void setEmail(String email) {
        _columnBitmask |= EMAIL_COLUMN_BITMASK;

        if (_originalEmail == null) {
            _originalEmail = _email;
        }

        _email = email;
    }

    public String getOriginalEmail() {
        return GetterUtil.getString(_originalEmail);
    }

    @Override
    public String getTelephone() {
        if (_telephone == null) {
            return StringPool.BLANK;
        } else {
            return _telephone;
        }
    }

    @Override
    public void setTelephone(String telephone) {
        _telephone = telephone;
    }

    @Override
    public String getSubject() {
        if (_subject == null) {
            return StringPool.BLANK;
        } else {
            return _subject;
        }
    }

    @Override
    public void setSubject(String subject) {
        _columnBitmask |= SUBJECT_COLUMN_BITMASK;

        if (_originalSubject == null) {
            _originalSubject = _subject;
        }

        _subject = subject;
    }

    public String getOriginalSubject() {
        return GetterUtil.getString(_originalSubject);
    }

    @Override
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    @Override
    public void setDescription(String description) {
        _description = description;
    }

    @Override
    public String getResponse() {
        if (_response == null) {
            return StringPool.BLANK;
        } else {
            return _response;
        }
    }

    @Override
    public void setResponse(String response) {
        _response = response;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            Contact.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Contact toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Contact) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ContactImpl contactImpl = new ContactImpl();

        contactImpl.setContactId(getContactId());
        contactImpl.setAreaId(getAreaId());
        contactImpl.setCreateDate(getCreateDate());
        contactImpl.setStatus(getStatus());
        contactImpl.setName(getName());
        contactImpl.setSurname(getSurname());
        contactImpl.setActivity(getActivity());
        contactImpl.setAddress(getAddress());
        contactImpl.setCity(getCity());
        contactImpl.setPostalCode(getPostalCode());
        contactImpl.setEmail(getEmail());
        contactImpl.setTelephone(getTelephone());
        contactImpl.setSubject(getSubject());
        contactImpl.setDescription(getDescription());
        contactImpl.setResponse(getResponse());

        contactImpl.resetOriginalValues();

        return contactImpl;
    }

    @Override
    public int compareTo(Contact contact) {
        long primaryKey = contact.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Contact)) {
            return false;
        }

        Contact contact = (Contact) obj;

        long primaryKey = contact.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        ContactModelImpl contactModelImpl = this;

        contactModelImpl._originalContactId = contactModelImpl._contactId;

        contactModelImpl._setOriginalContactId = false;

        contactModelImpl._originalAreaId = contactModelImpl._areaId;

        contactModelImpl._setOriginalAreaId = false;

        contactModelImpl._originalCreateDate = contactModelImpl._createDate;

        contactModelImpl._originalStatus = contactModelImpl._status;

        contactModelImpl._setOriginalStatus = false;

        contactModelImpl._originalEmail = contactModelImpl._email;

        contactModelImpl._originalSubject = contactModelImpl._subject;

        contactModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Contact> toCacheModel() {
        ContactCacheModel contactCacheModel = new ContactCacheModel();

        contactCacheModel.contactId = getContactId();

        contactCacheModel.areaId = getAreaId();

        Date createDate = getCreateDate();

        if (createDate != null) {
            contactCacheModel.createDate = createDate.getTime();
        } else {
            contactCacheModel.createDate = Long.MIN_VALUE;
        }

        contactCacheModel.status = getStatus();

        contactCacheModel.name = getName();

        String name = contactCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            contactCacheModel.name = null;
        }

        contactCacheModel.surname = getSurname();

        String surname = contactCacheModel.surname;

        if ((surname != null) && (surname.length() == 0)) {
            contactCacheModel.surname = null;
        }

        contactCacheModel.activity = getActivity();

        String activity = contactCacheModel.activity;

        if ((activity != null) && (activity.length() == 0)) {
            contactCacheModel.activity = null;
        }

        contactCacheModel.address = getAddress();

        String address = contactCacheModel.address;

        if ((address != null) && (address.length() == 0)) {
            contactCacheModel.address = null;
        }

        contactCacheModel.city = getCity();

        String city = contactCacheModel.city;

        if ((city != null) && (city.length() == 0)) {
            contactCacheModel.city = null;
        }

        contactCacheModel.postalCode = getPostalCode();

        String postalCode = contactCacheModel.postalCode;

        if ((postalCode != null) && (postalCode.length() == 0)) {
            contactCacheModel.postalCode = null;
        }

        contactCacheModel.email = getEmail();

        String email = contactCacheModel.email;

        if ((email != null) && (email.length() == 0)) {
            contactCacheModel.email = null;
        }

        contactCacheModel.telephone = getTelephone();

        String telephone = contactCacheModel.telephone;

        if ((telephone != null) && (telephone.length() == 0)) {
            contactCacheModel.telephone = null;
        }

        contactCacheModel.subject = getSubject();

        String subject = contactCacheModel.subject;

        if ((subject != null) && (subject.length() == 0)) {
            contactCacheModel.subject = null;
        }

        contactCacheModel.description = getDescription();

        String description = contactCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            contactCacheModel.description = null;
        }

        contactCacheModel.response = getResponse();

        String response = contactCacheModel.response;

        if ((response != null) && (response.length() == 0)) {
            contactCacheModel.response = null;
        }

        return contactCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(31);

        sb.append("{contactId=");
        sb.append(getContactId());
        sb.append(", areaId=");
        sb.append(getAreaId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", surname=");
        sb.append(getSurname());
        sb.append(", activity=");
        sb.append(getActivity());
        sb.append(", address=");
        sb.append(getAddress());
        sb.append(", city=");
        sb.append(getCity());
        sb.append(", postalCode=");
        sb.append(getPostalCode());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", telephone=");
        sb.append(getTelephone());
        sb.append(", subject=");
        sb.append(getSubject());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", response=");
        sb.append(getResponse());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(49);

        sb.append("<model><model-name>");
        sb.append("com.gfi.chg.model.Contact");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>contactId</column-name><column-value><![CDATA[");
        sb.append(getContactId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>areaId</column-name><column-value><![CDATA[");
        sb.append(getAreaId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>surname</column-name><column-value><![CDATA[");
        sb.append(getSurname());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activity</column-name><column-value><![CDATA[");
        sb.append(getActivity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>address</column-name><column-value><![CDATA[");
        sb.append(getAddress());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>city</column-name><column-value><![CDATA[");
        sb.append(getCity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>postalCode</column-name><column-value><![CDATA[");
        sb.append(getPostalCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>telephone</column-name><column-value><![CDATA[");
        sb.append(getTelephone());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>subject</column-name><column-value><![CDATA[");
        sb.append(getSubject());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>response</column-name><column-value><![CDATA[");
        sb.append(getResponse());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
