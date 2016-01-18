package com.gfi.chg.model.impl;

import com.gfi.chg.model.Contact;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Contact in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Contact
 * @generated
 */
public class ContactCacheModel implements CacheModel<Contact>, Externalizable {
    public long contactId;
    public long areaId;
    public long createDate;
    public int status;
    public String name;
    public String surname;
    public String activity;
    public String address;
    public String city;
    public String postalCode;
    public String email;
    public String telephone;
    public String subject;
    public String description;
    public String response;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(31);

        sb.append("{contactId=");
        sb.append(contactId);
        sb.append(", areaId=");
        sb.append(areaId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", status=");
        sb.append(status);
        sb.append(", name=");
        sb.append(name);
        sb.append(", surname=");
        sb.append(surname);
        sb.append(", activity=");
        sb.append(activity);
        sb.append(", address=");
        sb.append(address);
        sb.append(", city=");
        sb.append(city);
        sb.append(", postalCode=");
        sb.append(postalCode);
        sb.append(", email=");
        sb.append(email);
        sb.append(", telephone=");
        sb.append(telephone);
        sb.append(", subject=");
        sb.append(subject);
        sb.append(", description=");
        sb.append(description);
        sb.append(", response=");
        sb.append(response);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Contact toEntityModel() {
        ContactImpl contactImpl = new ContactImpl();

        contactImpl.setContactId(contactId);
        contactImpl.setAreaId(areaId);

        if (createDate == Long.MIN_VALUE) {
            contactImpl.setCreateDate(null);
        } else {
            contactImpl.setCreateDate(new Date(createDate));
        }

        contactImpl.setStatus(status);

        if (name == null) {
            contactImpl.setName(StringPool.BLANK);
        } else {
            contactImpl.setName(name);
        }

        if (surname == null) {
            contactImpl.setSurname(StringPool.BLANK);
        } else {
            contactImpl.setSurname(surname);
        }

        if (activity == null) {
            contactImpl.setActivity(StringPool.BLANK);
        } else {
            contactImpl.setActivity(activity);
        }

        if (address == null) {
            contactImpl.setAddress(StringPool.BLANK);
        } else {
            contactImpl.setAddress(address);
        }

        if (city == null) {
            contactImpl.setCity(StringPool.BLANK);
        } else {
            contactImpl.setCity(city);
        }

        if (postalCode == null) {
            contactImpl.setPostalCode(StringPool.BLANK);
        } else {
            contactImpl.setPostalCode(postalCode);
        }

        if (email == null) {
            contactImpl.setEmail(StringPool.BLANK);
        } else {
            contactImpl.setEmail(email);
        }

        if (telephone == null) {
            contactImpl.setTelephone(StringPool.BLANK);
        } else {
            contactImpl.setTelephone(telephone);
        }

        if (subject == null) {
            contactImpl.setSubject(StringPool.BLANK);
        } else {
            contactImpl.setSubject(subject);
        }

        if (description == null) {
            contactImpl.setDescription(StringPool.BLANK);
        } else {
            contactImpl.setDescription(description);
        }

        if (response == null) {
            contactImpl.setResponse(StringPool.BLANK);
        } else {
            contactImpl.setResponse(response);
        }

        contactImpl.resetOriginalValues();

        return contactImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        contactId = objectInput.readLong();
        areaId = objectInput.readLong();
        createDate = objectInput.readLong();
        status = objectInput.readInt();
        name = objectInput.readUTF();
        surname = objectInput.readUTF();
        activity = objectInput.readUTF();
        address = objectInput.readUTF();
        city = objectInput.readUTF();
        postalCode = objectInput.readUTF();
        email = objectInput.readUTF();
        telephone = objectInput.readUTF();
        subject = objectInput.readUTF();
        description = objectInput.readUTF();
        response = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(contactId);
        objectOutput.writeLong(areaId);
        objectOutput.writeLong(createDate);
        objectOutput.writeInt(status);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (surname == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(surname);
        }

        if (activity == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(activity);
        }

        if (address == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(address);
        }

        if (city == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(city);
        }

        if (postalCode == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(postalCode);
        }

        if (email == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(email);
        }

        if (telephone == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(telephone);
        }

        if (subject == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(subject);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (response == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(response);
        }
    }
}
