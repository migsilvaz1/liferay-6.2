package ec.gob.snap.vuv.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ec.gob.snap.vuv.service.Act_InstitucionalLocalServiceUtil;
import ec.gob.snap.vuv.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Act_InstitucionalClp extends BaseModelImpl<Act_Institucional>
    implements Act_Institucional {
    private long _id_act_institucional;
    private long _id_GPR_act_institucional;
    private long _content;
    private Date _timeStamp;
    private long _id_servicio;
    private BaseModel<?> _act_InstitucionalRemoteModel;
    private Class<?> _clpSerializerClass = ec.gob.snap.vuv.service.ClpSerializer.class;

    public Act_InstitucionalClp() {
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
    public long getPrimaryKey() {
        return _id_act_institucional;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId_act_institucional(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id_act_institucional;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getId_act_institucional() {
        return _id_act_institucional;
    }

    @Override
    public void setId_act_institucional(long id_act_institucional) {
        _id_act_institucional = id_act_institucional;

        if (_act_InstitucionalRemoteModel != null) {
            try {
                Class<?> clazz = _act_InstitucionalRemoteModel.getClass();

                Method method = clazz.getMethod("setId_act_institucional",
                        long.class);

                method.invoke(_act_InstitucionalRemoteModel,
                    id_act_institucional);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getId_GPR_act_institucional() {
        return _id_GPR_act_institucional;
    }

    @Override
    public void setId_GPR_act_institucional(long id_GPR_act_institucional) {
        _id_GPR_act_institucional = id_GPR_act_institucional;

        if (_act_InstitucionalRemoteModel != null) {
            try {
                Class<?> clazz = _act_InstitucionalRemoteModel.getClass();

                Method method = clazz.getMethod("setId_GPR_act_institucional",
                        long.class);

                method.invoke(_act_InstitucionalRemoteModel,
                    id_GPR_act_institucional);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getContent() {
        return _content;
    }

    @Override
    public void setContent(long content) {
        _content = content;

        if (_act_InstitucionalRemoteModel != null) {
            try {
                Class<?> clazz = _act_InstitucionalRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", long.class);

                method.invoke(_act_InstitucionalRemoteModel, content);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getTimeStamp() {
        return _timeStamp;
    }

    @Override
    public void setTimeStamp(Date timeStamp) {
        _timeStamp = timeStamp;

        if (_act_InstitucionalRemoteModel != null) {
            try {
                Class<?> clazz = _act_InstitucionalRemoteModel.getClass();

                Method method = clazz.getMethod("setTimeStamp", Date.class);

                method.invoke(_act_InstitucionalRemoteModel, timeStamp);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getId_servicio() {
        return _id_servicio;
    }

    @Override
    public void setId_servicio(long id_servicio) {
        _id_servicio = id_servicio;

        if (_act_InstitucionalRemoteModel != null) {
            try {
                Class<?> clazz = _act_InstitucionalRemoteModel.getClass();

                Method method = clazz.getMethod("setId_servicio", long.class);

                method.invoke(_act_InstitucionalRemoteModel, id_servicio);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAct_InstitucionalRemoteModel() {
        return _act_InstitucionalRemoteModel;
    }

    public void setAct_InstitucionalRemoteModel(
        BaseModel<?> act_InstitucionalRemoteModel) {
        _act_InstitucionalRemoteModel = act_InstitucionalRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _act_InstitucionalRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_act_InstitucionalRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            Act_InstitucionalLocalServiceUtil.addAct_Institucional(this);
        } else {
            Act_InstitucionalLocalServiceUtil.updateAct_Institucional(this);
        }
    }

    @Override
    public Act_Institucional toEscapedModel() {
        return (Act_Institucional) ProxyUtil.newProxyInstance(Act_Institucional.class.getClassLoader(),
            new Class[] { Act_Institucional.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        Act_InstitucionalClp clone = new Act_InstitucionalClp();

        clone.setId_act_institucional(getId_act_institucional());
        clone.setId_GPR_act_institucional(getId_GPR_act_institucional());
        clone.setContent(getContent());
        clone.setTimeStamp(getTimeStamp());
        clone.setId_servicio(getId_servicio());

        return clone;
    }

    @Override
    public int compareTo(Act_Institucional act_Institucional) {
        long primaryKey = act_Institucional.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Act_InstitucionalClp)) {
            return false;
        }

        Act_InstitucionalClp act_Institucional = (Act_InstitucionalClp) obj;

        long primaryKey = act_Institucional.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id_act_institucional=");
        sb.append(getId_act_institucional());
        sb.append(", id_GPR_act_institucional=");
        sb.append(getId_GPR_act_institucional());
        sb.append(", content=");
        sb.append(getContent());
        sb.append(", timeStamp=");
        sb.append(getTimeStamp());
        sb.append(", id_servicio=");
        sb.append(getId_servicio());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("ec.gob.snap.vuv.model.Act_Institucional");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id_act_institucional</column-name><column-value><![CDATA[");
        sb.append(getId_act_institucional());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id_GPR_act_institucional</column-name><column-value><![CDATA[");
        sb.append(getId_GPR_act_institucional());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>content</column-name><column-value><![CDATA[");
        sb.append(getContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>timeStamp</column-name><column-value><![CDATA[");
        sb.append(getTimeStamp());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id_servicio</column-name><column-value><![CDATA[");
        sb.append(getId_servicio());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
