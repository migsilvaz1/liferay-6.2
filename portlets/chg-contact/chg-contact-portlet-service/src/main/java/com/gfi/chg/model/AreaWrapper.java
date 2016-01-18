package com.gfi.chg.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Area}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Area
 * @generated
 */
public class AreaWrapper implements Area, ModelWrapper<Area> {
    private Area _area;

    public AreaWrapper(Area area) {
        _area = area;
    }

    @Override
    public Class<?> getModelClass() {
        return Area.class;
    }

    @Override
    public String getModelClassName() {
        return Area.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("areaId", getAreaId());
        attributes.put("name", getName());
        attributes.put("mainEmail", getMainEmail());
        attributes.put("userId", getUserId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long areaId = (Long) attributes.get("areaId");

        if (areaId != null) {
            setAreaId(areaId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String mainEmail = (String) attributes.get("mainEmail");

        if (mainEmail != null) {
            setMainEmail(mainEmail);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }
    }

    /**
    * Returns the primary key of this area.
    *
    * @return the primary key of this area
    */
    @Override
    public long getPrimaryKey() {
        return _area.getPrimaryKey();
    }

    /**
    * Sets the primary key of this area.
    *
    * @param primaryKey the primary key of this area
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _area.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the area ID of this area.
    *
    * @return the area ID of this area
    */
    @Override
    public long getAreaId() {
        return _area.getAreaId();
    }

    /**
    * Sets the area ID of this area.
    *
    * @param areaId the area ID of this area
    */
    @Override
    public void setAreaId(long areaId) {
        _area.setAreaId(areaId);
    }

    /**
    * Returns the name of this area.
    *
    * @return the name of this area
    */
    @Override
    public java.lang.String getName() {
        return _area.getName();
    }

    /**
    * Sets the name of this area.
    *
    * @param name the name of this area
    */
    @Override
    public void setName(java.lang.String name) {
        _area.setName(name);
    }

    /**
    * Returns the main email of this area.
    *
    * @return the main email of this area
    */
    @Override
    public java.lang.String getMainEmail() {
        return _area.getMainEmail();
    }

    /**
    * Sets the main email of this area.
    *
    * @param mainEmail the main email of this area
    */
    @Override
    public void setMainEmail(java.lang.String mainEmail) {
        _area.setMainEmail(mainEmail);
    }

    /**
    * Returns the user ID of this area.
    *
    * @return the user ID of this area
    */
    @Override
    public long getUserId() {
        return _area.getUserId();
    }

    /**
    * Sets the user ID of this area.
    *
    * @param userId the user ID of this area
    */
    @Override
    public void setUserId(long userId) {
        _area.setUserId(userId);
    }

    /**
    * Returns the user uuid of this area.
    *
    * @return the user uuid of this area
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _area.getUserUuid();
    }

    /**
    * Sets the user uuid of this area.
    *
    * @param userUuid the user uuid of this area
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _area.setUserUuid(userUuid);
    }

    @Override
    public boolean isNew() {
        return _area.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _area.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _area.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _area.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _area.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _area.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _area.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _area.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _area.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _area.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _area.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AreaWrapper((Area) _area.clone());
    }

    @Override
    public int compareTo(com.gfi.chg.model.Area area) {
        return _area.compareTo(area);
    }

    @Override
    public int hashCode() {
        return _area.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.gfi.chg.model.Area> toCacheModel() {
        return _area.toCacheModel();
    }

    @Override
    public com.gfi.chg.model.Area toEscapedModel() {
        return new AreaWrapper(_area.toEscapedModel());
    }

    @Override
    public com.gfi.chg.model.Area toUnescapedModel() {
        return new AreaWrapper(_area.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _area.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _area.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _area.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AreaWrapper)) {
            return false;
        }

        AreaWrapper areaWrapper = (AreaWrapper) obj;

        if (Validator.equals(_area, areaWrapper._area)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Area getWrappedArea() {
        return _area;
    }

    @Override
    public Area getWrappedModel() {
        return _area;
    }

    @Override
    public void resetOriginalValues() {
        _area.resetOriginalValues();
    }
}
