package ec.gob.snap.vuv.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ec.gob.snap.vuv.service.ClpSerializer;
import ec.gob.snap.vuv.service.IndicadorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class IndicadorClp extends BaseModelImpl<Indicador> implements Indicador {
    private long _id_indicador;
    private long _id_GPR_indicador;
    private long _content;
    private Date _timeStamp;
    private long _id_servicio;
    private BaseModel<?> _indicadorRemoteModel;
    private Class<?> _clpSerializerClass = ec.gob.snap.vuv.service.ClpSerializer.class;

    public IndicadorClp() {
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
    public long getPrimaryKey() {
        return _id_indicador;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId_indicador(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id_indicador;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getId_indicador() {
        return _id_indicador;
    }

    @Override
    public void setId_indicador(long id_indicador) {
        _id_indicador = id_indicador;

        if (_indicadorRemoteModel != null) {
            try {
                Class<?> clazz = _indicadorRemoteModel.getClass();

                Method method = clazz.getMethod("setId_indicador", long.class);

                method.invoke(_indicadorRemoteModel, id_indicador);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getId_GPR_indicador() {
        return _id_GPR_indicador;
    }

    @Override
    public void setId_GPR_indicador(long id_GPR_indicador) {
        _id_GPR_indicador = id_GPR_indicador;

        if (_indicadorRemoteModel != null) {
            try {
                Class<?> clazz = _indicadorRemoteModel.getClass();

                Method method = clazz.getMethod("setId_GPR_indicador",
                        long.class);

                method.invoke(_indicadorRemoteModel, id_GPR_indicador);
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

        if (_indicadorRemoteModel != null) {
            try {
                Class<?> clazz = _indicadorRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", long.class);

                method.invoke(_indicadorRemoteModel, content);
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

        if (_indicadorRemoteModel != null) {
            try {
                Class<?> clazz = _indicadorRemoteModel.getClass();

                Method method = clazz.getMethod("setTimeStamp", Date.class);

                method.invoke(_indicadorRemoteModel, timeStamp);
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

        if (_indicadorRemoteModel != null) {
            try {
                Class<?> clazz = _indicadorRemoteModel.getClass();

                Method method = clazz.getMethod("setId_servicio", long.class);

                method.invoke(_indicadorRemoteModel, id_servicio);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getIndicadorRemoteModel() {
        return _indicadorRemoteModel;
    }

    public void setIndicadorRemoteModel(BaseModel<?> indicadorRemoteModel) {
        _indicadorRemoteModel = indicadorRemoteModel;
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

        Class<?> remoteModelClass = _indicadorRemoteModel.getClass();

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

        Object returnValue = method.invoke(_indicadorRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            IndicadorLocalServiceUtil.addIndicador(this);
        } else {
            IndicadorLocalServiceUtil.updateIndicador(this);
        }
    }

    @Override
    public Indicador toEscapedModel() {
        return (Indicador) ProxyUtil.newProxyInstance(Indicador.class.getClassLoader(),
            new Class[] { Indicador.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        IndicadorClp clone = new IndicadorClp();

        clone.setId_indicador(getId_indicador());
        clone.setId_GPR_indicador(getId_GPR_indicador());
        clone.setContent(getContent());
        clone.setTimeStamp(getTimeStamp());
        clone.setId_servicio(getId_servicio());

        return clone;
    }

    @Override
    public int compareTo(Indicador indicador) {
        long primaryKey = indicador.getPrimaryKey();

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

        if (!(obj instanceof IndicadorClp)) {
            return false;
        }

        IndicadorClp indicador = (IndicadorClp) obj;

        long primaryKey = indicador.getPrimaryKey();

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

        sb.append("{id_indicador=");
        sb.append(getId_indicador());
        sb.append(", id_GPR_indicador=");
        sb.append(getId_GPR_indicador());
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
        sb.append("ec.gob.snap.vuv.model.Indicador");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id_indicador</column-name><column-value><![CDATA[");
        sb.append(getId_indicador());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id_GPR_indicador</column-name><column-value><![CDATA[");
        sb.append(getId_GPR_indicador());
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
