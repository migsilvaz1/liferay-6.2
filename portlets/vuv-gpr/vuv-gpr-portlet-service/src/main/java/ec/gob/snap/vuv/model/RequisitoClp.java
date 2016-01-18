package ec.gob.snap.vuv.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ec.gob.snap.vuv.service.ClpSerializer;
import ec.gob.snap.vuv.service.RequisitoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class RequisitoClp extends BaseModelImpl<Requisito> implements Requisito {
    private long _id_requisito;
    private long _id_GPR_requisito;
    private long _content;
    private Date _timeStamp;
    private long _id_paso;
    private BaseModel<?> _requisitoRemoteModel;
    private Class<?> _clpSerializerClass = ec.gob.snap.vuv.service.ClpSerializer.class;

    public RequisitoClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Requisito.class;
    }

    @Override
    public String getModelClassName() {
        return Requisito.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _id_requisito;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId_requisito(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id_requisito;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id_requisito", getId_requisito());
        attributes.put("id_GPR_requisito", getId_GPR_requisito());
        attributes.put("content", getContent());
        attributes.put("timeStamp", getTimeStamp());
        attributes.put("id_paso", getId_paso());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id_requisito = (Long) attributes.get("id_requisito");

        if (id_requisito != null) {
            setId_requisito(id_requisito);
        }

        Long id_GPR_requisito = (Long) attributes.get("id_GPR_requisito");

        if (id_GPR_requisito != null) {
            setId_GPR_requisito(id_GPR_requisito);
        }

        Long content = (Long) attributes.get("content");

        if (content != null) {
            setContent(content);
        }

        Date timeStamp = (Date) attributes.get("timeStamp");

        if (timeStamp != null) {
            setTimeStamp(timeStamp);
        }

        Long id_paso = (Long) attributes.get("id_paso");

        if (id_paso != null) {
            setId_paso(id_paso);
        }
    }

    @Override
    public long getId_requisito() {
        return _id_requisito;
    }

    @Override
    public void setId_requisito(long id_requisito) {
        _id_requisito = id_requisito;

        if (_requisitoRemoteModel != null) {
            try {
                Class<?> clazz = _requisitoRemoteModel.getClass();

                Method method = clazz.getMethod("setId_requisito", long.class);

                method.invoke(_requisitoRemoteModel, id_requisito);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getId_GPR_requisito() {
        return _id_GPR_requisito;
    }

    @Override
    public void setId_GPR_requisito(long id_GPR_requisito) {
        _id_GPR_requisito = id_GPR_requisito;

        if (_requisitoRemoteModel != null) {
            try {
                Class<?> clazz = _requisitoRemoteModel.getClass();

                Method method = clazz.getMethod("setId_GPR_requisito",
                        long.class);

                method.invoke(_requisitoRemoteModel, id_GPR_requisito);
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

        if (_requisitoRemoteModel != null) {
            try {
                Class<?> clazz = _requisitoRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", long.class);

                method.invoke(_requisitoRemoteModel, content);
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

        if (_requisitoRemoteModel != null) {
            try {
                Class<?> clazz = _requisitoRemoteModel.getClass();

                Method method = clazz.getMethod("setTimeStamp", Date.class);

                method.invoke(_requisitoRemoteModel, timeStamp);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getId_paso() {
        return _id_paso;
    }

    @Override
    public void setId_paso(long id_paso) {
        _id_paso = id_paso;

        if (_requisitoRemoteModel != null) {
            try {
                Class<?> clazz = _requisitoRemoteModel.getClass();

                Method method = clazz.getMethod("setId_paso", long.class);

                method.invoke(_requisitoRemoteModel, id_paso);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getRequisitoRemoteModel() {
        return _requisitoRemoteModel;
    }

    public void setRequisitoRemoteModel(BaseModel<?> requisitoRemoteModel) {
        _requisitoRemoteModel = requisitoRemoteModel;
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

        Class<?> remoteModelClass = _requisitoRemoteModel.getClass();

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

        Object returnValue = method.invoke(_requisitoRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            RequisitoLocalServiceUtil.addRequisito(this);
        } else {
            RequisitoLocalServiceUtil.updateRequisito(this);
        }
    }

    @Override
    public Requisito toEscapedModel() {
        return (Requisito) ProxyUtil.newProxyInstance(Requisito.class.getClassLoader(),
            new Class[] { Requisito.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        RequisitoClp clone = new RequisitoClp();

        clone.setId_requisito(getId_requisito());
        clone.setId_GPR_requisito(getId_GPR_requisito());
        clone.setContent(getContent());
        clone.setTimeStamp(getTimeStamp());
        clone.setId_paso(getId_paso());

        return clone;
    }

    @Override
    public int compareTo(Requisito requisito) {
        long primaryKey = requisito.getPrimaryKey();

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

        if (!(obj instanceof RequisitoClp)) {
            return false;
        }

        RequisitoClp requisito = (RequisitoClp) obj;

        long primaryKey = requisito.getPrimaryKey();

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

        sb.append("{id_requisito=");
        sb.append(getId_requisito());
        sb.append(", id_GPR_requisito=");
        sb.append(getId_GPR_requisito());
        sb.append(", content=");
        sb.append(getContent());
        sb.append(", timeStamp=");
        sb.append(getTimeStamp());
        sb.append(", id_paso=");
        sb.append(getId_paso());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("ec.gob.snap.vuv.model.Requisito");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id_requisito</column-name><column-value><![CDATA[");
        sb.append(getId_requisito());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id_GPR_requisito</column-name><column-value><![CDATA[");
        sb.append(getId_GPR_requisito());
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
            "<column><column-name>id_paso</column-name><column-value><![CDATA[");
        sb.append(getId_paso());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
