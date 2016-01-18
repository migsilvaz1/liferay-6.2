package ec.gob.snap.vuv.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Centro}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Centro
 * @generated
 */
public class CentroWrapper implements Centro, ModelWrapper<Centro> {
    private Centro _centro;

    public CentroWrapper(Centro centro) {
        _centro = centro;
    }

    @Override
    public Class<?> getModelClass() {
        return Centro.class;
    }

    @Override
    public String getModelClassName() {
        return Centro.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id_centro", getId_centro());
        attributes.put("id_GPR_centro", getId_GPR_centro());
        attributes.put("content", getContent());
        attributes.put("timeStamp", getTimeStamp());
        attributes.put("id_caso", getId_caso());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id_centro = (Long) attributes.get("id_centro");

        if (id_centro != null) {
            setId_centro(id_centro);
        }

        Long id_GPR_centro = (Long) attributes.get("id_GPR_centro");

        if (id_GPR_centro != null) {
            setId_GPR_centro(id_GPR_centro);
        }

        Long content = (Long) attributes.get("content");

        if (content != null) {
            setContent(content);
        }

        Date timeStamp = (Date) attributes.get("timeStamp");

        if (timeStamp != null) {
            setTimeStamp(timeStamp);
        }

        Long id_caso = (Long) attributes.get("id_caso");

        if (id_caso != null) {
            setId_caso(id_caso);
        }
    }

    /**
    * Returns the primary key of this centro.
    *
    * @return the primary key of this centro
    */
    @Override
    public long getPrimaryKey() {
        return _centro.getPrimaryKey();
    }

    /**
    * Sets the primary key of this centro.
    *
    * @param primaryKey the primary key of this centro
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _centro.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the id_centro of this centro.
    *
    * @return the id_centro of this centro
    */
    @Override
    public long getId_centro() {
        return _centro.getId_centro();
    }

    /**
    * Sets the id_centro of this centro.
    *
    * @param id_centro the id_centro of this centro
    */
    @Override
    public void setId_centro(long id_centro) {
        _centro.setId_centro(id_centro);
    }

    /**
    * Returns the id_ g p r_centro of this centro.
    *
    * @return the id_ g p r_centro of this centro
    */
    @Override
    public long getId_GPR_centro() {
        return _centro.getId_GPR_centro();
    }

    /**
    * Sets the id_ g p r_centro of this centro.
    *
    * @param id_GPR_centro the id_ g p r_centro of this centro
    */
    @Override
    public void setId_GPR_centro(long id_GPR_centro) {
        _centro.setId_GPR_centro(id_GPR_centro);
    }

    /**
    * Returns the content of this centro.
    *
    * @return the content of this centro
    */
    @Override
    public long getContent() {
        return _centro.getContent();
    }

    /**
    * Sets the content of this centro.
    *
    * @param content the content of this centro
    */
    @Override
    public void setContent(long content) {
        _centro.setContent(content);
    }

    /**
    * Returns the time stamp of this centro.
    *
    * @return the time stamp of this centro
    */
    @Override
    public java.util.Date getTimeStamp() {
        return _centro.getTimeStamp();
    }

    /**
    * Sets the time stamp of this centro.
    *
    * @param timeStamp the time stamp of this centro
    */
    @Override
    public void setTimeStamp(java.util.Date timeStamp) {
        _centro.setTimeStamp(timeStamp);
    }

    /**
    * Returns the id_caso of this centro.
    *
    * @return the id_caso of this centro
    */
    @Override
    public long getId_caso() {
        return _centro.getId_caso();
    }

    /**
    * Sets the id_caso of this centro.
    *
    * @param id_caso the id_caso of this centro
    */
    @Override
    public void setId_caso(long id_caso) {
        _centro.setId_caso(id_caso);
    }

    @Override
    public boolean isNew() {
        return _centro.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _centro.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _centro.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _centro.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _centro.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _centro.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _centro.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _centro.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _centro.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _centro.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _centro.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new CentroWrapper((Centro) _centro.clone());
    }

    @Override
    public int compareTo(Centro centro) {
        return _centro.compareTo(centro);
    }

    @Override
    public int hashCode() {
        return _centro.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Centro> toCacheModel() {
        return _centro.toCacheModel();
    }

    @Override
    public Centro toEscapedModel() {
        return new CentroWrapper(_centro.toEscapedModel());
    }

    @Override
    public Centro toUnescapedModel() {
        return new CentroWrapper(_centro.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _centro.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _centro.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _centro.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CentroWrapper)) {
            return false;
        }

        CentroWrapper centroWrapper = (CentroWrapper) obj;

        if (Validator.equals(_centro, centroWrapper._centro)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Centro getWrappedCentro() {
        return _centro;
    }

    @Override
    public Centro getWrappedModel() {
        return _centro;
    }

    @Override
    public void resetOriginalValues() {
        _centro.resetOriginalValues();
    }
}
