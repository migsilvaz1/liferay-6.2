package ec.gob.snap.vuv.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Institucion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Institucion
 * @generated
 */
public class InstitucionWrapper implements Institucion,
    ModelWrapper<Institucion> {
    private Institucion _institucion;

    public InstitucionWrapper(Institucion institucion) {
        _institucion = institucion;
    }

    @Override
    public Class<?> getModelClass() {
        return Institucion.class;
    }

    @Override
    public String getModelClassName() {
        return Institucion.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id_institucion", getId_institucion());
        attributes.put("id_GPR_institucion", getId_GPR_institucion());
        attributes.put("content", getContent());
        attributes.put("timeStamp", getTimeStamp());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id_institucion = (Long) attributes.get("id_institucion");

        if (id_institucion != null) {
            setId_institucion(id_institucion);
        }

        Long id_GPR_institucion = (Long) attributes.get("id_GPR_institucion");

        if (id_GPR_institucion != null) {
            setId_GPR_institucion(id_GPR_institucion);
        }

        Long content = (Long) attributes.get("content");

        if (content != null) {
            setContent(content);
        }

        Date timeStamp = (Date) attributes.get("timeStamp");

        if (timeStamp != null) {
            setTimeStamp(timeStamp);
        }
    }

    /**
    * Returns the primary key of this institucion.
    *
    * @return the primary key of this institucion
    */
    @Override
    public long getPrimaryKey() {
        return _institucion.getPrimaryKey();
    }

    /**
    * Sets the primary key of this institucion.
    *
    * @param primaryKey the primary key of this institucion
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _institucion.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the id_institucion of this institucion.
    *
    * @return the id_institucion of this institucion
    */
    @Override
    public long getId_institucion() {
        return _institucion.getId_institucion();
    }

    /**
    * Sets the id_institucion of this institucion.
    *
    * @param id_institucion the id_institucion of this institucion
    */
    @Override
    public void setId_institucion(long id_institucion) {
        _institucion.setId_institucion(id_institucion);
    }

    /**
    * Returns the id_ g p r_institucion of this institucion.
    *
    * @return the id_ g p r_institucion of this institucion
    */
    @Override
    public long getId_GPR_institucion() {
        return _institucion.getId_GPR_institucion();
    }

    /**
    * Sets the id_ g p r_institucion of this institucion.
    *
    * @param id_GPR_institucion the id_ g p r_institucion of this institucion
    */
    @Override
    public void setId_GPR_institucion(long id_GPR_institucion) {
        _institucion.setId_GPR_institucion(id_GPR_institucion);
    }

    /**
    * Returns the content of this institucion.
    *
    * @return the content of this institucion
    */
    @Override
    public long getContent() {
        return _institucion.getContent();
    }

    /**
    * Sets the content of this institucion.
    *
    * @param content the content of this institucion
    */
    @Override
    public void setContent(long content) {
        _institucion.setContent(content);
    }

    /**
    * Returns the time stamp of this institucion.
    *
    * @return the time stamp of this institucion
    */
    @Override
    public java.util.Date getTimeStamp() {
        return _institucion.getTimeStamp();
    }

    /**
    * Sets the time stamp of this institucion.
    *
    * @param timeStamp the time stamp of this institucion
    */
    @Override
    public void setTimeStamp(java.util.Date timeStamp) {
        _institucion.setTimeStamp(timeStamp);
    }

    @Override
    public boolean isNew() {
        return _institucion.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _institucion.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _institucion.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _institucion.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _institucion.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _institucion.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _institucion.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _institucion.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _institucion.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _institucion.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _institucion.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new InstitucionWrapper((Institucion) _institucion.clone());
    }

    @Override
    public int compareTo(Institucion institucion) {
        return _institucion.compareTo(institucion);
    }

    @Override
    public int hashCode() {
        return _institucion.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Institucion> toCacheModel() {
        return _institucion.toCacheModel();
    }

    @Override
    public Institucion toEscapedModel() {
        return new InstitucionWrapper(_institucion.toEscapedModel());
    }

    @Override
    public Institucion toUnescapedModel() {
        return new InstitucionWrapper(_institucion.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _institucion.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _institucion.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _institucion.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof InstitucionWrapper)) {
            return false;
        }

        InstitucionWrapper institucionWrapper = (InstitucionWrapper) obj;

        if (Validator.equals(_institucion, institucionWrapper._institucion)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Institucion getWrappedInstitucion() {
        return _institucion;
    }

    @Override
    public Institucion getWrappedModel() {
        return _institucion;
    }

    @Override
    public void resetOriginalValues() {
        _institucion.resetOriginalValues();
    }
}
