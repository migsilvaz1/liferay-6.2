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
public class TracingSoap implements Serializable {
    private long _tracingId;
    private long _areaId;
    private long _contactId;
    private int _status;
    private Date _modifiedDate;
    private String _comment;

    public TracingSoap() {
    }

    public static TracingSoap toSoapModel(Tracing model) {
        TracingSoap soapModel = new TracingSoap();

        soapModel.setTracingId(model.getTracingId());
        soapModel.setAreaId(model.getAreaId());
        soapModel.setContactId(model.getContactId());
        soapModel.setStatus(model.getStatus());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setComment(model.getComment());

        return soapModel;
    }

    public static TracingSoap[] toSoapModels(Tracing[] models) {
        TracingSoap[] soapModels = new TracingSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static TracingSoap[][] toSoapModels(Tracing[][] models) {
        TracingSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new TracingSoap[models.length][models[0].length];
        } else {
            soapModels = new TracingSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static TracingSoap[] toSoapModels(List<Tracing> models) {
        List<TracingSoap> soapModels = new ArrayList<TracingSoap>(models.size());

        for (Tracing model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new TracingSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _tracingId;
    }

    public void setPrimaryKey(long pk) {
        setTracingId(pk);
    }

    public long getTracingId() {
        return _tracingId;
    }

    public void setTracingId(long tracingId) {
        _tracingId = tracingId;
    }

    public long getAreaId() {
        return _areaId;
    }

    public void setAreaId(long areaId) {
        _areaId = areaId;
    }

    public long getContactId() {
        return _contactId;
    }

    public void setContactId(long contactId) {
        _contactId = contactId;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getComment() {
        return _comment;
    }

    public void setComment(String comment) {
        _comment = comment;
    }
}
