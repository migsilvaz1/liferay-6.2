package com.gfi.chg.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Contact}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Contact
 * @generated
 */
public class ContactWrapper implements Contact, ModelWrapper<Contact> {
    private Contact _contact;

    public ContactWrapper(Contact contact) {
        _contact = contact;
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

    /**
    * Returns the primary key of this contact.
    *
    * @return the primary key of this contact
    */
    @Override
    public long getPrimaryKey() {
        return _contact.getPrimaryKey();
    }

    /**
    * Sets the primary key of this contact.
    *
    * @param primaryKey the primary key of this contact
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _contact.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the contact ID of this contact.
    *
    * @return the contact ID of this contact
    */
    @Override
    public long getContactId() {
        return _contact.getContactId();
    }

    /**
    * Sets the contact ID of this contact.
    *
    * @param contactId the contact ID of this contact
    */
    @Override
    public void setContactId(long contactId) {
        _contact.setContactId(contactId);
    }

    /**
    * Returns the area ID of this contact.
    *
    * @return the area ID of this contact
    */
    @Override
    public long getAreaId() {
        return _contact.getAreaId();
    }

    /**
    * Sets the area ID of this contact.
    *
    * @param areaId the area ID of this contact
    */
    @Override
    public void setAreaId(long areaId) {
        _contact.setAreaId(areaId);
    }

    /**
    * Returns the create date of this contact.
    *
    * @return the create date of this contact
    */
    @Override
    public java.util.Date getCreateDate() {
        return _contact.getCreateDate();
    }

    /**
    * Sets the create date of this contact.
    *
    * @param createDate the create date of this contact
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _contact.setCreateDate(createDate);
    }

    /**
    * Returns the status of this contact.
    *
    * @return the status of this contact
    */
    @Override
    public int getStatus() {
        return _contact.getStatus();
    }

    /**
    * Sets the status of this contact.
    *
    * @param status the status of this contact
    */
    @Override
    public void setStatus(int status) {
        _contact.setStatus(status);
    }

    /**
    * Returns the name of this contact.
    *
    * @return the name of this contact
    */
    @Override
    public java.lang.String getName() {
        return _contact.getName();
    }

    /**
    * Sets the name of this contact.
    *
    * @param name the name of this contact
    */
    @Override
    public void setName(java.lang.String name) {
        _contact.setName(name);
    }

    /**
    * Returns the surname of this contact.
    *
    * @return the surname of this contact
    */
    @Override
    public java.lang.String getSurname() {
        return _contact.getSurname();
    }

    /**
    * Sets the surname of this contact.
    *
    * @param surname the surname of this contact
    */
    @Override
    public void setSurname(java.lang.String surname) {
        _contact.setSurname(surname);
    }

    /**
    * Returns the activity of this contact.
    *
    * @return the activity of this contact
    */
    @Override
    public java.lang.String getActivity() {
        return _contact.getActivity();
    }

    /**
    * Sets the activity of this contact.
    *
    * @param activity the activity of this contact
    */
    @Override
    public void setActivity(java.lang.String activity) {
        _contact.setActivity(activity);
    }

    /**
    * Returns the address of this contact.
    *
    * @return the address of this contact
    */
    @Override
    public java.lang.String getAddress() {
        return _contact.getAddress();
    }

    /**
    * Sets the address of this contact.
    *
    * @param address the address of this contact
    */
    @Override
    public void setAddress(java.lang.String address) {
        _contact.setAddress(address);
    }

    /**
    * Returns the city of this contact.
    *
    * @return the city of this contact
    */
    @Override
    public java.lang.String getCity() {
        return _contact.getCity();
    }

    /**
    * Sets the city of this contact.
    *
    * @param city the city of this contact
    */
    @Override
    public void setCity(java.lang.String city) {
        _contact.setCity(city);
    }

    /**
    * Returns the postal code of this contact.
    *
    * @return the postal code of this contact
    */
    @Override
    public java.lang.String getPostalCode() {
        return _contact.getPostalCode();
    }

    /**
    * Sets the postal code of this contact.
    *
    * @param postalCode the postal code of this contact
    */
    @Override
    public void setPostalCode(java.lang.String postalCode) {
        _contact.setPostalCode(postalCode);
    }

    /**
    * Returns the email of this contact.
    *
    * @return the email of this contact
    */
    @Override
    public java.lang.String getEmail() {
        return _contact.getEmail();
    }

    /**
    * Sets the email of this contact.
    *
    * @param email the email of this contact
    */
    @Override
    public void setEmail(java.lang.String email) {
        _contact.setEmail(email);
    }

    /**
    * Returns the telephone of this contact.
    *
    * @return the telephone of this contact
    */
    @Override
    public java.lang.String getTelephone() {
        return _contact.getTelephone();
    }

    /**
    * Sets the telephone of this contact.
    *
    * @param telephone the telephone of this contact
    */
    @Override
    public void setTelephone(java.lang.String telephone) {
        _contact.setTelephone(telephone);
    }

    /**
    * Returns the subject of this contact.
    *
    * @return the subject of this contact
    */
    @Override
    public java.lang.String getSubject() {
        return _contact.getSubject();
    }

    /**
    * Sets the subject of this contact.
    *
    * @param subject the subject of this contact
    */
    @Override
    public void setSubject(java.lang.String subject) {
        _contact.setSubject(subject);
    }

    /**
    * Returns the description of this contact.
    *
    * @return the description of this contact
    */
    @Override
    public java.lang.String getDescription() {
        return _contact.getDescription();
    }

    /**
    * Sets the description of this contact.
    *
    * @param description the description of this contact
    */
    @Override
    public void setDescription(java.lang.String description) {
        _contact.setDescription(description);
    }

    /**
    * Returns the response of this contact.
    *
    * @return the response of this contact
    */
    @Override
    public java.lang.String getResponse() {
        return _contact.getResponse();
    }

    /**
    * Sets the response of this contact.
    *
    * @param response the response of this contact
    */
    @Override
    public void setResponse(java.lang.String response) {
        _contact.setResponse(response);
    }

    @Override
    public boolean isNew() {
        return _contact.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _contact.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _contact.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _contact.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _contact.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _contact.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _contact.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _contact.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _contact.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _contact.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _contact.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ContactWrapper((Contact) _contact.clone());
    }

    @Override
    public int compareTo(com.gfi.chg.model.Contact contact) {
        return _contact.compareTo(contact);
    }

    @Override
    public int hashCode() {
        return _contact.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.gfi.chg.model.Contact> toCacheModel() {
        return _contact.toCacheModel();
    }

    @Override
    public com.gfi.chg.model.Contact toEscapedModel() {
        return new ContactWrapper(_contact.toEscapedModel());
    }

    @Override
    public com.gfi.chg.model.Contact toUnescapedModel() {
        return new ContactWrapper(_contact.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _contact.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _contact.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _contact.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContactWrapper)) {
            return false;
        }

        ContactWrapper contactWrapper = (ContactWrapper) obj;

        if (Validator.equals(_contact, contactWrapper._contact)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Contact getWrappedContact() {
        return _contact;
    }

    @Override
    public Contact getWrappedModel() {
        return _contact;
    }

    @Override
    public void resetOriginalValues() {
        _contact.resetOriginalValues();
    }
}
