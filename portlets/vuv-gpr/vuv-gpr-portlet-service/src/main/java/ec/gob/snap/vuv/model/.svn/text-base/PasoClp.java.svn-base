package ec.gob.snap.vuv.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ec.gob.snap.vuv.service.ClpSerializer;
import ec.gob.snap.vuv.service.PasoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class PasoClp extends BaseModelImpl<Paso> implements Paso {
    private long _id_paso;
    private long _id_GPR_paso;
    private long _content;
    private Date _timeStamp;
    private long _id_caso;
    private BaseModel<?> _pasoRemoteModel;
    private Class<?> _clpSerializerClass = ec.gob.snap.vuv.service.ClpSerializer.class;

    public PasoClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Paso.class;
    }

    @Override
    public String getModelClassName() {
        return Paso.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _id_paso;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId_paso(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id_paso;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id_paso", getId_paso());
        attributes.put("id_GPR_paso", getId_GPR_paso());
        attributes.put("content", getContent());
        attributes.put("timeStamp", getTimeStamp());
        attributes.put("id_caso", getId_caso());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id_paso = (Long) attributes.get("id_paso");

        if (id_paso != null) {
            setId_paso(id_paso);
        }

        Long id_GPR_paso = (Long) attributes.get("id_GPR_paso");

        if (id_GPR_paso != null) {
            setId_GPR_paso(id_GPR_paso);
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

    @Override
    public long getId_paso() {
        return _id_paso;
    }

    @Override
    public void setId_paso(long id_paso) {
        _id_paso = id_paso;

        if (_pasoRemoteModel != null) {
            try {
                Class<?> clazz = _pasoRemoteModel.getClass();

                Method method = clazz.getMethod("setId_paso", long.class);

                method.invoke(_pasoRemoteModel, id_paso);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getId_GPR_paso() {
        return _id_GPR_paso;
    }

    @Override
    public void setId_GPR_paso(long id_GPR_paso) {
        _id_GPR_paso = id_GPR_paso;

        if (_pasoRemoteModel != null) {
            try {
                Class<?> clazz = _pasoRemoteModel.getClass();

                Method method = clazz.getMethod("setId_GPR_paso", long.class);

                method.invoke(_pasoRemoteModel, id_GPR_paso);
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

        if (_pasoRemoteModel != null) {
            try {
                Class<?> clazz = _pasoRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", long.class);

                method.invoke(_pasoRemoteModel, content);
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

        if (_pasoRemoteModel != null) {
            try {
                Class<?> clazz = _pasoRemoteModel.getClass();

                Method method = clazz.getMethod("setTimeStamp", Date.class);

                method.invoke(_pasoRemoteModel, timeStamp);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getId_caso() {
        return _id_caso;
    }

    @Override
    public void setId_caso(long id_caso) {
        _id_caso = id_caso;

        if (_pasoRemoteModel != null) {
            try {
                Class<?> clazz = _pasoRemoteModel.getClass();

                Method method = clazz.getMethod("setId_caso", long.class);

                method.invoke(_pasoRemoteModel, id_caso);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getPasoRemoteModel() {
        return _pasoRemoteModel;
    }

    public void setPasoRemoteModel(BaseModel<?> pasoRemoteModel) {
        _pasoRemoteModel = pasoRemoteModel;
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

        Class<?> remoteModelClass = _pasoRemoteModel.getClass();

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

        Object returnValue = method.invoke(_pasoRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            PasoLocalServiceUtil.addPaso(this);
        } else {
            PasoLocalServiceUtil.updatePaso(this);
        }
    }

    @Override
    public Paso toEscapedModel() {
        return (Paso) ProxyUtil.newProxyInstance(Paso.class.getClassLoader(),
            new Class[] { Paso.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        PasoClp clone = new PasoClp();

        clone.setId_paso(getId_paso());
        clone.setId_GPR_paso(getId_GPR_paso());
        clone.setContent(getContent());
        clone.setTimeStamp(getTimeStamp());
        clone.setId_caso(getId_caso());

        return clone;
    }

    @Override
    public int compareTo(Paso paso) {
        long primaryKey = paso.getPrimaryKey();

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

        if (!(obj instanceof PasoClp)) {
            return false;
        }

        PasoClp paso = (PasoClp) obj;

        long primaryKey = paso.getPrimaryKey();

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

        sb.append("{id_paso=");
        sb.append(getId_paso());
        sb.append(", id_GPR_paso=");
        sb.append(getId_GPR_paso());
        sb.append(", content=");
        sb.append(getContent());
        sb.append(", timeStamp=");
        sb.append(getTimeStamp());
        sb.append(", id_caso=");
        sb.append(getId_caso());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("ec.gob.snap.vuv.model.Paso");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id_paso</column-name><column-value><![CDATA[");
        sb.append(getId_paso());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id_GPR_paso</column-name><column-value><![CDATA[");
        sb.append(getId_GPR_paso());
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
            "<column><column-name>id_caso</column-name><column-value><![CDATA[");
        sb.append(getId_caso());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
