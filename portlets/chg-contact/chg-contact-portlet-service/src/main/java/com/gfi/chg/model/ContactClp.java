package com.gfi.chg.model;

import com.gfi.chg.service.ClpSerializer;
import com.gfi.chg.service.ContactLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ContactClp extends BaseModelImpl<Contact> implements Contact {
    private long _contactId;
    private long _areaId;
    private Date _createDate;
    private int _status;
    private String _name;
    private String _surname;
    private String _activity;
    private String _address;
    private String _city;
    private String _postalCode;
    private String _email;
    private String _telephone;
    private String _subject;
    private String _description;
    private String _response;
    private BaseModel<?> _contactRemoteModel;
    private Class<?> _clpSerializerClass = com.gfi.chg.service.ClpSerializer.class;

    public ContactClp() {
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
        _contactId = contactId;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setContactId", long.class);

                method.invoke(_contactRemoteModel, contactId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getAreaId() {
        return _areaId;
    }

    @Override
    public void setAreaId(long areaId) {
        _areaId = areaId;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setAreaId", long.class);

                method.invoke(_contactRemoteModel, areaId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_contactRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_contactRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_contactRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSurname() {
        return _surname;
    }

    @Override
    public void setSurname(String surname) {
        _surname = surname;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setSurname", String.class);

                method.invoke(_contactRemoteModel, surname);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getActivity() {
        return _activity;
    }

    @Override
    public void setActivity(String activity) {
        _activity = activity;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setActivity", String.class);

                method.invoke(_contactRemoteModel, activity);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAddress() {
        return _address;
    }

    @Override
    public void setAddress(String address) {
        _address = address;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setAddress", String.class);

                method.invoke(_contactRemoteModel, address);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCity() {
        return _city;
    }

    @Override
    public void setCity(String city) {
        _city = city;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setCity", String.class);

                method.invoke(_contactRemoteModel, city);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPostalCode() {
        return _postalCode;
    }

    @Override
    public void setPostalCode(String postalCode) {
        _postalCode = postalCode;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setPostalCode", String.class);

                method.invoke(_contactRemoteModel, postalCode);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmail() {
        return _email;
    }

    @Override
    public void setEmail(String email) {
        _email = email;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setEmail", String.class);

                method.invoke(_contactRemoteModel, email);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTelephone() {
        return _telephone;
    }

    @Override
    public void setTelephone(String telephone) {
        _telephone = telephone;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setTelephone", String.class);

                method.invoke(_contactRemoteModel, telephone);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSubject() {
        return _subject;
    }

    @Override
    public void setSubject(String subject) {
        _subject = subject;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setSubject", String.class);

                method.invoke(_contactRemoteModel, subject);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_contactRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getResponse() {
        return _response;
    }

    @Override
    public void setResponse(String response) {
        _response = response;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setResponse", String.class);

                method.invoke(_contactRemoteModel, response);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getContactRemoteModel() {
        return _contactRemoteModel;
    }

    public void setContactRemoteModel(BaseModel<?> contactRemoteModel) {
        _contactRemoteModel = contactRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _contactRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_contactRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ContactLocalServiceUtil.addContact(this);
        } else {
            ContactLocalServiceUtil.updateContact(this);
        }
    }

    @Override
    public Contact toEscapedModel() {
        return (Contact) ProxyUtil.newProxyInstance(Contact.class.getClassLoader(),
            new Class[] { Contact.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ContactClp clone = new ContactClp();

        clone.setContactId(getContactId());
        clone.setAreaId(getAreaId());
        clone.setCreateDate(getCreateDate());
        clone.setStatus(getStatus());
        clone.setName(getName());
        clone.setSurname(getSurname());
        clone.setActivity(getActivity());
        clone.setAddress(getAddress());
        clone.setCity(getCity());
        clone.setPostalCode(getPostalCode());
        clone.setEmail(getEmail());
        clone.setTelephone(getTelephone());
        clone.setSubject(getSubject());
        clone.setDescription(getDescription());
        clone.setResponse(getResponse());

        return clone;
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

        if (!(obj instanceof ContactClp)) {
            return false;
        }

        ContactClp contact = (ContactClp) obj;

        long primaryKey = contact.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
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
