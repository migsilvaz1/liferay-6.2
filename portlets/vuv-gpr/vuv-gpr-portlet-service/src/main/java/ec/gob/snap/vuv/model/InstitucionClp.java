package ec.gob.snap.vuv.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ec.gob.snap.vuv.service.ClpSerializer;
import ec.gob.snap.vuv.service.InstitucionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class InstitucionClp extends BaseModelImpl<Institucion>
    implements Institucion {
    private long _id_institucion;
    private long _id_GPR_institucion;
    private long _content;
    private Date _timeStamp;
    private BaseModel<?> _institucionRemoteModel;
    private Class<?> _clpSerializerClass = ec.gob.snap.vuv.service.ClpSerializer.class;

    public InstitucionClp() {
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
    public long getPrimaryKey() {
        return _id_institucion;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId_institucion(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id_institucion;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getId_institucion() {
        return _id_institucion;
    }

    @Override
    public void setId_institucion(long id_institucion) {
        _id_institucion = id_institucion;

        if (_institucionRemoteModel != null) {
            try {
                Class<?> clazz = _institucionRemoteModel.getClass();

                Method method = clazz.getMethod("setId_institucion", long.class);

                method.invoke(_institucionRemoteModel, id_institucion);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getId_GPR_institucion() {
        return _id_GPR_institucion;
    }

    @Override
    public void setId_GPR_institucion(long id_GPR_institucion) {
        _id_GPR_institucion = id_GPR_institucion;

        if (_institucionRemoteModel != null) {
            try {
                Class<?> clazz = _institucionRemoteModel.getClass();

                Method method = clazz.getMethod("setId_GPR_institucion",
                        long.class);

                method.invoke(_institucionRemoteModel, id_GPR_institucion);
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

        if (_institucionRemoteModel != null) {
            try {
                Class<?> clazz = _institucionRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", long.class);

                method.invoke(_institucionRemoteModel, content);
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

        if (_institucionRemoteModel != null) {
            try {
                Class<?> clazz = _institucionRemoteModel.getClass();

                Method method = clazz.getMethod("setTimeStamp", Date.class);

                method.invoke(_institucionRemoteModel, timeStamp);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getInstitucionRemoteModel() {
        return _institucionRemoteModel;
    }

    public void setInstitucionRemoteModel(BaseModel<?> institucionRemoteModel) {
        _institucionRemoteModel = institucionRemoteModel;
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

        Class<?> remoteModelClass = _institucionRemoteModel.getClass();

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

        Object returnValue = method.invoke(_institucionRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            InstitucionLocalServiceUtil.addInstitucion(this);
        } else {
            InstitucionLocalServiceUtil.updateInstitucion(this);
        }
    }

    @Override
    public Institucion toEscapedModel() {
        return (Institucion) ProxyUtil.newProxyInstance(Institucion.class.getClassLoader(),
            new Class[] { Institucion.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        InstitucionClp clone = new InstitucionClp();

        clone.setId_institucion(getId_institucion());
        clone.setId_GPR_institucion(getId_GPR_institucion());
        clone.setContent(getContent());
        clone.setTimeStamp(getTimeStamp());

        return clone;
    }

    @Override
    public int compareTo(Institucion institucion) {
        long primaryKey = institucion.getPrimaryKey();

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

        if (!(obj instanceof InstitucionClp)) {
            return false;
        }

        InstitucionClp institucion = (InstitucionClp) obj;

        long primaryKey = institucion.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{id_institucion=");
        sb.append(getId_institucion());
        sb.append(", id_GPR_institucion=");
        sb.append(getId_GPR_institucion());
        sb.append(", content=");
        sb.append(getContent());
        sb.append(", timeStamp=");
        sb.append(getTimeStamp());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("ec.gob.snap.vuv.model.Institucion");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id_institucion</column-name><column-value><![CDATA[");
        sb.append(getId_institucion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id_GPR_institucion</column-name><column-value><![CDATA[");
        sb.append(getId_GPR_institucion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>content</column-name><column-value><![CDATA[");
        sb.append(getContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>timeStamp</column-name><column-value><![CDATA[");
        sb.append(getTimeStamp());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
