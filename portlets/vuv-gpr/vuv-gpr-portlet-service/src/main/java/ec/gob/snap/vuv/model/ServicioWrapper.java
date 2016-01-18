package ec.gob.snap.vuv.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Servicio}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Servicio
 * @generated
 */
public class ServicioWrapper implements Servicio, ModelWrapper<Servicio> {
    private Servicio _servicio;

    public ServicioWrapper(Servicio servicio) {
        _servicio = servicio;
    }

    @Override
    public Class<?> getModelClass() {
        return Servicio.class;
    }

    @Override
    public String getModelClassName() {
        return Servicio.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id_GPR_servicio", getId_GPR_servicio());
        attributes.put("content", getContent());
        attributes.put("timeStamp", getTimeStamp());
        attributes.put("id_servicio", getId_servicio());
        attributes.put("id_institucion", getId_institucion());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id_GPR_servicio = (Long) attributes.get("id_GPR_servicio");

        if (id_GPR_servicio != null) {
            setId_GPR_servicio(id_GPR_servicio);
        }

        Long content = (Long) attributes.get("content");

        if (content != null) {
            setContent(content);
        }

        Date timeStamp = (Date) attributes.get("timeStamp");

        if (timeStamp != null) {
            setTimeStamp(timeStamp);
        }

        Long id_servicio = (Long) attributes.get("id_servicio");

        if (id_servicio != null) {
            setId_servicio(id_servicio);
        }

        Long id_institucion = (Long) attributes.get("id_institucion");

        if (id_institucion != null) {
            setId_institucion(id_institucion);
        }
    }

    /**
    * Returns the primary key of this servicio.
    *
    * @return the primary key of this servicio
    */
    @Override
    public long getPrimaryKey() {
        return _servicio.getPrimaryKey();
    }

    /**
    * Sets the primary key of this servicio.
    *
    * @param primaryKey the primary key of this servicio
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _servicio.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the id_ g p r_servicio of this servicio.
    *
    * @return the id_ g p r_servicio of this servicio
    */
    @Override
    public long getId_GPR_servicio() {
        return _servicio.getId_GPR_servicio();
    }

    /**
    * Sets the id_ g p r_servicio of this servicio.
    *
    * @param id_GPR_servicio the id_ g p r_servicio of this servicio
    */
    @Override
    public void setId_GPR_servicio(long id_GPR_servicio) {
        _servicio.setId_GPR_servicio(id_GPR_servicio);
    }

    /**
    * Returns the content of this servicio.
    *
    * @return the content of this servicio
    */
    @Override
    public long getContent() {
        return _servicio.getContent();
    }

    /**
    * Sets the content of this servicio.
    *
    * @param content the content of this servicio
    */
    @Override
    public void setContent(long content) {
        _servicio.setContent(content);
    }

    /**
    * Returns the time stamp of this servicio.
    *
    * @return the time stamp of this servicio
    */
    @Override
    public java.util.Date getTimeStamp() {
        return _servicio.getTimeStamp();
    }

    /**
    * Sets the time stamp of this servicio.
    *
    * @param timeStamp the time stamp of this servicio
    */
    @Override
    public void setTimeStamp(java.util.Date timeStamp) {
        _servicio.setTimeStamp(timeStamp);
    }

    /**
    * Returns the id_servicio of this servicio.
    *
    * @return the id_servicio of this servicio
    */
    @Override
    public long getId_servicio() {
        return _servicio.getId_servicio();
    }

    /**
    * Sets the id_servicio of this servicio.
    *
    * @param id_servicio the id_servicio of this servicio
    */
    @Override
    public void setId_servicio(long id_servicio) {
        _servicio.setId_servicio(id_servicio);
    }

    /**
    * Returns the id_institucion of this servicio.
    *
    * @return the id_institucion of this servicio
    */
    @Override
    public long getId_institucion() {
        return _servicio.getId_institucion();
    }

    /**
    * Sets the id_institucion of this servicio.
    *
    * @param id_institucion the id_institucion of this servicio
    */
    @Override
    public void setId_institucion(long id_institucion) {
        _servicio.setId_institucion(id_institucion);
    }

    @Override
    public boolean isNew() {
        return _servicio.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _servicio.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _servicio.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _servicio.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _servicio.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _servicio.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _servicio.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _servicio.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _servicio.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _servicio.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _servicio.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ServicioWrapper((Servicio) _servicio.clone());
    }

    @Override
    public int compareTo(Servicio servicio) {
        return _servicio.compareTo(servicio);
    }

    @Override
    public int hashCode() {
        return _servicio.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Servicio> toCacheModel() {
        return _servicio.toCacheModel();
    }

    @Override
    public Servicio toEscapedModel() {
        return new ServicioWrapper(_servicio.toEscapedModel());
    }

    @Override
    public Servicio toUnescapedModel() {
        return new ServicioWrapper(_servicio.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _servicio.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _servicio.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _servicio.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ServicioWrapper)) {
            return false;
        }

        ServicioWrapper servicioWrapper = (ServicioWrapper) obj;

        if (Validator.equals(_servicio, servicioWrapper._servicio)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Servicio getWrappedServicio() {
        return _servicio;
    }

    @Override
    public Servicio getWrappedModel() {
        return _servicio;
    }

    @Override
    public void resetOriginalValues() {
        _servicio.resetOriginalValues();
    }
}
