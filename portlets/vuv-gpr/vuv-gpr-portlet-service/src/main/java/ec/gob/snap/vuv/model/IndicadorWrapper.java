package ec.gob.snap.vuv.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Indicador}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Indicador
 * @generated
 */
public class IndicadorWrapper implements Indicador, ModelWrapper<Indicador> {
    private Indicador _indicador;

    public IndicadorWrapper(Indicador indicador) {
        _indicador = indicador;
    }

    @Override
    public Class<?> getModelClass() {
        return Indicador.class;
    }

    @Override
    public String getModelClassName() {
        return Indicador.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id_indicador", getId_indicador());
        attributes.put("id_GPR_indicador", getId_GPR_indicador());
        attributes.put("content", getContent());
        attributes.put("timeStamp", getTimeStamp());
        attributes.put("id_servicio", getId_servicio());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id_indicador = (Long) attributes.get("id_indicador");

        if (id_indicador != null) {
            setId_indicador(id_indicador);
        }

        Long id_GPR_indicador = (Long) attributes.get("id_GPR_indicador");

        if (id_GPR_indicador != null) {
            setId_GPR_indicador(id_GPR_indicador);
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
    }

    /**
    * Returns the primary key of this indicador.
    *
    * @return the primary key of this indicador
    */
    @Override
    public long getPrimaryKey() {
        return _indicador.getPrimaryKey();
    }

    /**
    * Sets the primary key of this indicador.
    *
    * @param primaryKey the primary key of this indicador
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _indicador.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the id_indicador of this indicador.
    *
    * @return the id_indicador of this indicador
    */
    @Override
    public long getId_indicador() {
        return _indicador.getId_indicador();
    }

    /**
    * Sets the id_indicador of this indicador.
    *
    * @param id_indicador the id_indicador of this indicador
    */
    @Override
    public void setId_indicador(long id_indicador) {
        _indicador.setId_indicador(id_indicador);
    }

    /**
    * Returns the id_ g p r_indicador of this indicador.
    *
    * @return the id_ g p r_indicador of this indicador
    */
    @Override
    public long getId_GPR_indicador() {
        return _indicador.getId_GPR_indicador();
    }

    /**
    * Sets the id_ g p r_indicador of this indicador.
    *
    * @param id_GPR_indicador the id_ g p r_indicador of this indicador
    */
    @Override
    public void setId_GPR_indicador(long id_GPR_indicador) {
        _indicador.setId_GPR_indicador(id_GPR_indicador);
    }

    /**
    * Returns the content of this indicador.
    *
    * @return the content of this indicador
    */
    @Override
    public long getContent() {
        return _indicador.getContent();
    }

    /**
    * Sets the content of this indicador.
    *
    * @param content the content of this indicador
    */
    @Override
    public void setContent(long content) {
        _indicador.setContent(content);
    }

    /**
    * Returns the time stamp of this indicador.
    *
    * @return the time stamp of this indicador
    */
    @Override
    public java.util.Date getTimeStamp() {
        return _indicador.getTimeStamp();
    }

    /**
    * Sets the time stamp of this indicador.
    *
    * @param timeStamp the time stamp of this indicador
    */
    @Override
    public void setTimeStamp(java.util.Date timeStamp) {
        _indicador.setTimeStamp(timeStamp);
    }

    /**
    * Returns the id_servicio of this indicador.
    *
    * @return the id_servicio of this indicador
    */
    @Override
    public long getId_servicio() {
        return _indicador.getId_servicio();
    }

    /**
    * Sets the id_servicio of this indicador.
    *
    * @param id_servicio the id_servicio of this indicador
    */
    @Override
    public void setId_servicio(long id_servicio) {
        _indicador.setId_servicio(id_servicio);
    }

    @Override
    public boolean isNew() {
        return _indicador.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _indicador.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _indicador.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _indicador.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _indicador.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _indicador.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _indicador.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _indicador.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _indicador.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _indicador.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _indicador.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new IndicadorWrapper((Indicador) _indicador.clone());
    }

    @Override
    public int compareTo(Indicador indicador) {
        return _indicador.compareTo(indicador);
    }

    @Override
    public int hashCode() {
        return _indicador.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Indicador> toCacheModel() {
        return _indicador.toCacheModel();
    }

    @Override
    public Indicador toEscapedModel() {
        return new IndicadorWrapper(_indicador.toEscapedModel());
    }

    @Override
    public Indicador toUnescapedModel() {
        return new IndicadorWrapper(_indicador.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _indicador.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _indicador.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _indicador.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof IndicadorWrapper)) {
            return false;
        }

        IndicadorWrapper indicadorWrapper = (IndicadorWrapper) obj;

        if (Validator.equals(_indicador, indicadorWrapper._indicador)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Indicador getWrappedIndicador() {
        return _indicador;
    }

    @Override
    public Indicador getWrappedModel() {
        return _indicador;
    }

    @Override
    public void resetOriginalValues() {
        _indicador.resetOriginalValues();
    }
}
