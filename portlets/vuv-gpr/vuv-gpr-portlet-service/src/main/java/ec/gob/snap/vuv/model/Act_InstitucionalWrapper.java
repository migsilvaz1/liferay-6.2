package ec.gob.snap.vuv.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Act_Institucional}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Act_Institucional
 * @generated
 */
public class Act_InstitucionalWrapper implements Act_Institucional,
    ModelWrapper<Act_Institucional> {
    private Act_Institucional _act_Institucional;

    public Act_InstitucionalWrapper(Act_Institucional act_Institucional) {
        _act_Institucional = act_Institucional;
    }

    @Override
    public Class<?> getModelClass() {
        return Act_Institucional.class;
    }

    @Override
    public String getModelClassName() {
        return Act_Institucional.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id_act_institucional", getId_act_institucional());
        attributes.put("id_GPR_act_institucional", getId_GPR_act_institucional());
        attributes.put("content", getContent());
        attributes.put("timeStamp", getTimeStamp());
        attributes.put("id_servicio", getId_servicio());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id_act_institucional = (Long) attributes.get(
                "id_act_institucional");

        if (id_act_institucional != null) {
            setId_act_institucional(id_act_institucional);
        }

        Long id_GPR_act_institucional = (Long) attributes.get(
                "id_GPR_act_institucional");

        if (id_GPR_act_institucional != null) {
            setId_GPR_act_institucional(id_GPR_act_institucional);
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
    * Returns the primary key of this act_ institucional.
    *
    * @return the primary key of this act_ institucional
    */
    @Override
    public long getPrimaryKey() {
        return _act_Institucional.getPrimaryKey();
    }

    /**
    * Sets the primary key of this act_ institucional.
    *
    * @param primaryKey the primary key of this act_ institucional
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _act_Institucional.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the id_act_institucional of this act_ institucional.
    *
    * @return the id_act_institucional of this act_ institucional
    */
    @Override
    public long getId_act_institucional() {
        return _act_Institucional.getId_act_institucional();
    }

    /**
    * Sets the id_act_institucional of this act_ institucional.
    *
    * @param id_act_institucional the id_act_institucional of this act_ institucional
    */
    @Override
    public void setId_act_institucional(long id_act_institucional) {
        _act_Institucional.setId_act_institucional(id_act_institucional);
    }

    /**
    * Returns the id_ g p r_act_institucional of this act_ institucional.
    *
    * @return the id_ g p r_act_institucional of this act_ institucional
    */
    @Override
    public long getId_GPR_act_institucional() {
        return _act_Institucional.getId_GPR_act_institucional();
    }

    /**
    * Sets the id_ g p r_act_institucional of this act_ institucional.
    *
    * @param id_GPR_act_institucional the id_ g p r_act_institucional of this act_ institucional
    */
    @Override
    public void setId_GPR_act_institucional(long id_GPR_act_institucional) {
        _act_Institucional.setId_GPR_act_institucional(id_GPR_act_institucional);
    }

    /**
    * Returns the content of this act_ institucional.
    *
    * @return the content of this act_ institucional
    */
    @Override
    public long getContent() {
        return _act_Institucional.getContent();
    }

    /**
    * Sets the content of this act_ institucional.
    *
    * @param content the content of this act_ institucional
    */
    @Override
    public void setContent(long content) {
        _act_Institucional.setContent(content);
    }

    /**
    * Returns the time stamp of this act_ institucional.
    *
    * @return the time stamp of this act_ institucional
    */
    @Override
    public java.util.Date getTimeStamp() {
        return _act_Institucional.getTimeStamp();
    }

    /**
    * Sets the time stamp of this act_ institucional.
    *
    * @param timeStamp the time stamp of this act_ institucional
    */
    @Override
    public void setTimeStamp(java.util.Date timeStamp) {
        _act_Institucional.setTimeStamp(timeStamp);
    }

    /**
    * Returns the id_servicio of this act_ institucional.
    *
    * @return the id_servicio of this act_ institucional
    */
    @Override
    public long getId_servicio() {
        return _act_Institucional.getId_servicio();
    }

    /**
    * Sets the id_servicio of this act_ institucional.
    *
    * @param id_servicio the id_servicio of this act_ institucional
    */
    @Override
    public void setId_servicio(long id_servicio) {
        _act_Institucional.setId_servicio(id_servicio);
    }

    @Override
    public boolean isNew() {
        return _act_Institucional.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _act_Institucional.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _act_Institucional.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _act_Institucional.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _act_Institucional.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _act_Institucional.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _act_Institucional.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _act_Institucional.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _act_Institucional.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _act_Institucional.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _act_Institucional.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new Act_InstitucionalWrapper((Act_Institucional) _act_Institucional.clone());
    }

    @Override
    public int compareTo(Act_Institucional act_Institucional) {
        return _act_Institucional.compareTo(act_Institucional);
    }

    @Override
    public int hashCode() {
        return _act_Institucional.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Act_Institucional> toCacheModel() {
        return _act_Institucional.toCacheModel();
    }

    @Override
    public Act_Institucional toEscapedModel() {
        return new Act_InstitucionalWrapper(_act_Institucional.toEscapedModel());
    }

    @Override
    public Act_Institucional toUnescapedModel() {
        return new Act_InstitucionalWrapper(_act_Institucional.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _act_Institucional.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _act_Institucional.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _act_Institucional.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Act_InstitucionalWrapper)) {
            return false;
        }

        Act_InstitucionalWrapper act_InstitucionalWrapper = (Act_InstitucionalWrapper) obj;

        if (Validator.equals(_act_Institucional,
                    act_InstitucionalWrapper._act_Institucional)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Act_Institucional getWrappedAct_Institucional() {
        return _act_Institucional;
    }

    @Override
    public Act_Institucional getWrappedModel() {
        return _act_Institucional;
    }

    @Override
    public void resetOriginalValues() {
        _act_Institucional.resetOriginalValues();
    }
}
