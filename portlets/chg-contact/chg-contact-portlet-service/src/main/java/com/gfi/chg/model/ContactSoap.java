package com.gfi.chg.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContactSoap implements Serializable {
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

    public ContactSoap() {
    }

    public static ContactSoap toSoapModel(Contact model) {
        ContactSoap soapModel = new ContactSoap();

        soapModel.setContactId(model.getContactId());
        soapModel.setAreaId(model.getAreaId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setStatus(model.getStatus());
        soapModel.setName(model.getName());
        soapModel.setSurname(model.getSurname());
        soapModel.setActivity(model.getActivity());
        soapModel.setAddress(model.getAddress());
        soapModel.setCity(model.getCity());
        soapModel.setPostalCode(model.getPostalCode());
        soapModel.setEmail(model.getEmail());
        soapModel.setTelephone(model.getTelephone());
        soapModel.setSubject(model.getSubject());
        soapModel.setDescription(model.getDescription());
        soapModel.setResponse(model.getResponse());

        return soapModel;
    }

    public static ContactSoap[] toSoapModels(Contact[] models) {
        ContactSoap[] soapModels = new ContactSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ContactSoap[][] toSoapModels(Contact[][] models) {
        ContactSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ContactSoap[models.length][models[0].length];
        } else {
            soapModels = new ContactSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ContactSoap[] toSoapModels(List<Contact> models) {
        List<ContactSoap> soapModels = new ArrayList<ContactSoap>(models.size());

        for (Contact model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ContactSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _contactId;
    }

    public void setPrimaryKey(long pk) {
        setContactId(pk);
    }

    public long getContactId() {
        return _contactId;
    }

    public void setContactId(long contactId) {
        _contactId = contactId;
    }

    public long getAreaId() {
        return _areaId;
    }

    public void setAreaId(long areaId) {
        _areaId = areaId;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getSurname() {
        return _surname;
    }

    public void setSurname(String surname) {
        _surname = surname;
    }

    public String getActivity() {
        return _activity;
    }

    public void setActivity(String activity) {
        _activity = activity;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        _city = city;
    }

    public String getPostalCode() {
        return _postalCode;
    }

    public void setPostalCode(String postalCode) {
        _postalCode = postalCode;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getTelephone() {
        return _telephone;
    }

    public void setTelephone(String telephone) {
        _telephone = telephone;
    }

    public String getSubject() {
        return _subject;
    }

    public void setSubject(String subject) {
        _subject = subject;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getResponse() {
        return _response;
    }

    public void setResponse(String response) {
        _response = response;
    }
}
