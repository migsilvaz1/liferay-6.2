package com.gfi.chg.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Tracing}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Tracing
 * @generated
 */
public class TracingWrapper implements Tracing, ModelWrapper<Tracing> {
    private Tracing _tracing;

    public TracingWrapper(Tracing tracing) {
        _tracing = tracing;
    }

    @Override
    public Class<?> getModelClass() {
        return Tracing.class;
    }

    @Override
    public String getModelClassName() {
        return Tracing.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("tracingId", getTracingId());
        attributes.put("areaId", getAreaId());
        attributes.put("contactId", getContactId());
        attributes.put("status", getStatus());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("comment", getComment());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long tracingId = (Long) attributes.get("tracingId");

        if (tracingId != null) {
            setTracingId(tracingId);
        }

        Long areaId = (Long) attributes.get("areaId");

        if (areaId != null) {
            setAreaId(areaId);
        }

        Long contactId = (Long) attributes.get("contactId");

        if (contactId != null) {
            setContactId(contactId);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String comment = (String) attributes.get("comment");

        if (comment != null) {
            setComment(comment);
        }
    }

    /**
    * Returns the primary key of this tracing.
    *
    * @return the primary key of this tracing
    */
    @Override
    public long getPrimaryKey() {
        return _tracing.getPrimaryKey();
    }

    /**
    * Sets the primary key of this tracing.
    *
    * @param primaryKey the primary key of this tracing
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _tracing.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the tracing ID of this tracing.
    *
    * @return the tracing ID of this tracing
    */
    @Override
    public long getTracingId() {
        return _tracing.getTracingId();
    }

    /**
    * Sets the tracing ID of this tracing.
    *
    * @param tracingId the tracing ID of this tracing
    */
    @Override
    public void setTracingId(long tracingId) {
        _tracing.setTracingId(tracingId);
    }

    /**
    * Returns the area ID of this tracing.
    *
    * @return the area ID of this tracing
    */
    @Override
    public long getAreaId() {
        return _tracing.getAreaId();
    }

    /**
    * Sets the area ID of this tracing.
    *
    * @param areaId the area ID of this tracing
    */
    @Override
    public void setAreaId(long areaId) {
        _tracing.setAreaId(areaId);
    }

    /**
    * Returns the contact ID of this tracing.
    *
    * @return the contact ID of this tracing
    */
    @Override
    public long getContactId() {
        return _tracing.getContactId();
    }

    /**
    * Sets the contact ID of this tracing.
    *
    * @param contactId the contact ID of this tracing
    */
    @Override
    public void setContactId(long contactId) {
        _tracing.setContactId(contactId);
    }

    /**
    * Returns the status of this tracing.
    *
    * @return the status of this tracing
    */
    @Override
    public int getStatus() {
        return _tracing.getStatus();
    }

    /**
    * Sets the status of this tracing.
    *
    * @param status the status of this tracing
    */
    @Override
    public void setStatus(int status) {
        _tracing.setStatus(status);
    }

    /**
    * Returns the modified date of this tracing.
    *
    * @return the modified date of this tracing
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _tracing.getModifiedDate();
    }

    /**
    * Sets the modified date of this tracing.
    *
    * @param modifiedDate the modified date of this tracing
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _tracing.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the comment of this tracing.
    *
    * @return the comment of this tracing
    */
    @Override
    public java.lang.String getComment() {
        return _tracing.getComment();
    }

    /**
    * Sets the comment of this tracing.
    *
    * @param comment the comment of this tracing
    */
    @Override
    public void setComment(java.lang.String comment) {
        _tracing.setComment(comment);
    }

    @Override
    public boolean isNew() {
        return _tracing.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _tracing.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _tracing.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _tracing.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _tracing.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _tracing.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _tracing.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _tracing.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _tracing.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _tracing.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _tracing.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new TracingWrapper((Tracing) _tracing.clone());
    }

    @Override
    public int compareTo(com.gfi.chg.model.Tracing tracing) {
        return _tracing.compareTo(tracing);
    }

    @Override
    public int hashCode() {
        return _tracing.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.gfi.chg.model.Tracing> toCacheModel() {
        return _tracing.toCacheModel();
    }

    @Override
    public com.gfi.chg.model.Tracing toEscapedModel() {
        return new TracingWrapper(_tracing.toEscapedModel());
    }

    @Override
    public com.gfi.chg.model.Tracing toUnescapedModel() {
        return new TracingWrapper(_tracing.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _tracing.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _tracing.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _tracing.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TracingWrapper)) {
            return false;
        }

        TracingWrapper tracingWrapper = (TracingWrapper) obj;

        if (Validator.equals(_tracing, tracingWrapper._tracing)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Tracing getWrappedTracing() {
        return _tracing;
    }

    @Override
    public Tracing getWrappedModel() {
        return _tracing;
    }

    @Override
    public void resetOriginalValues() {
        _tracing.resetOriginalValues();
    }
}
