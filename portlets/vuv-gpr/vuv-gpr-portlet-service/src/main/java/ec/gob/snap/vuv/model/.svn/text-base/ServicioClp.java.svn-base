package ec.gob.snap.vuv.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ec.gob.snap.vuv.service.ClpSerializer;
import ec.gob.snap.vuv.service.ServicioLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ServicioClp extends BaseModelImpl<Servicio> implements Servicio {
    private long _id_GPR_servicio;
    private long _content;
    private Date _timeStamp;
    private long _id_servicio;
    private long _id_institucion;
    private BaseModel<?> _servicioRemoteModel;
    private Class<?> _clpSerializerClass = ec.gob.snap.vuv.service.ClpSerializer.class;

    public ServicioClp() {
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
    public long getPrimaryKey() {
        return _id_servicio;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId_servicio(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id_servicio;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getId_GPR_servicio() {
        return _id_GPR_servicio;
    }

    @Override
    public void setId_GPR_servicio(long id_GPR_servicio) {
        _id_GPR_servicio = id_GPR_servicio;

        if (_servicioRemoteModel != null) {
            try {
                Class<?> clazz = _servicioRemoteModel.getClass();

                Method method = clazz.getMethod("setId_GPR_servicio", long.class);

                method.invoke(_servicioRemoteModel, id_GPR_servicio);
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

        if (_servicioRemoteModel != null) {
            try {
                Class<?> clazz = _servicioRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", long.class);

                method.invoke(_servicioRemoteModel, content);
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

        if (_servicioRemoteModel != null) {
            try {
                Class<?> clazz = _servicioRemoteModel.getClass();

                Method method = clazz.getMethod("setTimeStamp", Date.class);

                method.invoke(_servicioRemoteModel, timeStamp);
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

        if (_servicioRemoteModel != null) {
            try {
                Class<?> clazz = _servicioRemoteModel.getClass();

                Method method = clazz.getMethod("setId_servicio", long.class);

                method.invoke(_servicioRemoteModel, id_servicio);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getId_institucion() {
        return _id_institucion;
    }

    @Override
    public void setId_institucion(long id_institucion) {
        _id_institucion = id_institucion;

        if (_servicioRemoteModel != null) {
            try {
                Class<?> clazz = _servicioRemoteModel.getClass();

                Method method = clazz.getMethod("setId_institucion", long.class);

                method.invoke(_servicioRemoteModel, id_institucion);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getServicioRemoteModel() {
        return _servicioRemoteModel;
    }

    public void setServicioRemoteModel(BaseModel<?> servicioRemoteModel) {
        _servicioRemoteModel = servicioRemoteModel;
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

        Class<?> remoteModelClass = _servicioRemoteModel.getClass();

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

        Object returnValue = method.invoke(_servicioRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ServicioLocalServiceUtil.addServicio(this);
        } else {
            ServicioLocalServiceUtil.updateServicio(this);
        }
    }

    @Override
    public Servicio toEscapedModel() {
        return (Servicio) ProxyUtil.newProxyInstance(Servicio.class.getClassLoader(),
            new Class[] { Servicio.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ServicioClp clone = new ServicioClp();

        clone.setId_GPR_servicio(getId_GPR_servicio());
        clone.setContent(getContent());
        clone.setTimeStamp(getTimeStamp());
        clone.setId_servicio(getId_servicio());
        clone.setId_institucion(getId_institucion());

        return clone;
    }

    @Override
    public int compareTo(Servicio servicio) {
        long primaryKey = servicio.getPrimaryKey();

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

        if (!(obj instanceof ServicioClp)) {
            return false;
        }

        ServicioClp servicio = (ServicioClp) obj;

        long primaryKey = servicio.getPrimaryKey();

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

        sb.append("{id_GPR_servicio=");
        sb.append(getId_GPR_servicio());
        sb.append(", content=");
        sb.append(getContent());
        sb.append(", timeStamp=");
        sb.append(getTimeStamp());
        sb.append(", id_servicio=");
        sb.append(getId_servicio());
        sb.append(", id_institucion=");
        sb.append(getId_institucion());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("ec.gob.snap.vuv.model.Servicio");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id_GPR_servicio</column-name><column-value><![CDATA[");
        sb.append(getId_GPR_servicio());
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
        sb.append(
            "<column><column-name>id_institucion</column-name><column-value><![CDATA[");
        sb.append(getId_institucion());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
