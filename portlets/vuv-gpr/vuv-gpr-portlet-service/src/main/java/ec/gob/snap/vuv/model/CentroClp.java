package ec.gob.snap.vuv.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ec.gob.snap.vuv.service.CentroLocalServiceUtil;
import ec.gob.snap.vuv.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class CentroClp extends BaseModelImpl<Centro> implements Centro {
    private long _id_centro;
    private long _id_GPR_centro;
    private long _content;
    private Date _timeStamp;
    private long _id_caso;
    private BaseModel<?> _centroRemoteModel;
    private Class<?> _clpSerializerClass = ec.gob.snap.vuv.service.ClpSerializer.class;

    public CentroClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Centro.class;
    }

    @Override
    public String getModelClassName() {
        return Centro.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _id_centro;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId_centro(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id_centro;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id_centro", getId_centro());
        attributes.put("id_GPR_centro", getId_GPR_centro());
        attributes.put("content", getContent());
        attributes.put("timeStamp", getTimeStamp());
        attributes.put("id_caso", getId_caso());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id_centro = (Long) attributes.get("id_centro");

        if (id_centro != null) {
            setId_centro(id_centro);
        }

        Long id_GPR_centro = (Long) attributes.get("id_GPR_centro");

        if (id_GPR_centro != null) {
            setId_GPR_centro(id_GPR_centro);
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
    public long getId_centro() {
        return _id_centro;
    }

    @Override
    public void setId_centro(long id_centro) {
        _id_centro = id_centro;

        if (_centroRemoteModel != null) {
            try {
                Class<?> clazz = _centroRemoteModel.getClass();

                Method method = clazz.getMethod("setId_centro", long.class);

                method.invoke(_centroRemoteModel, id_centro);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getId_GPR_centro() {
        return _id_GPR_centro;
    }

    @Override
    public void setId_GPR_centro(long id_GPR_centro) {
        _id_GPR_centro = id_GPR_centro;

        if (_centroRemoteModel != null) {
            try {
                Class<?> clazz = _centroRemoteModel.getClass();

                Method method = clazz.getMethod("setId_GPR_centro", long.class);

                method.invoke(_centroRemoteModel, id_GPR_centro);
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

        if (_centroRemoteModel != null) {
            try {
                Class<?> clazz = _centroRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", long.class);

                method.invoke(_centroRemoteModel, content);
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

        if (_centroRemoteModel != null) {
            try {
                Class<?> clazz = _centroRemoteModel.getClass();

                Method method = clazz.getMethod("setTimeStamp", Date.class);

                method.invoke(_centroRemoteModel, timeStamp);
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

        if (_centroRemoteModel != null) {
            try {
                Class<?> clazz = _centroRemoteModel.getClass();

                Method method = clazz.getMethod("setId_caso", long.class);

                method.invoke(_centroRemoteModel, id_caso);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getCentroRemoteModel() {
        return _centroRemoteModel;
    }

    public void setCentroRemoteModel(BaseModel<?> centroRemoteModel) {
        _centroRemoteModel = centroRemoteModel;
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

        Class<?> remoteModelClass = _centroRemoteModel.getClass();

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

        Object returnValue = method.invoke(_centroRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CentroLocalServiceUtil.addCentro(this);
        } else {
            CentroLocalServiceUtil.updateCentro(this);
        }
    }

    @Override
    public Centro toEscapedModel() {
        return (Centro) ProxyUtil.newProxyInstance(Centro.class.getClassLoader(),
            new Class[] { Centro.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        CentroClp clone = new CentroClp();

        clone.setId_centro(getId_centro());
        clone.setId_GPR_centro(getId_GPR_centro());
        clone.setContent(getContent());
        clone.setTimeStamp(getTimeStamp());
        clone.setId_caso(getId_caso());

        return clone;
    }

    @Override
    public int compareTo(Centro centro) {
        long primaryKey = centro.getPrimaryKey();

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

        if (!(obj instanceof CentroClp)) {
            return false;
        }

        CentroClp centro = (CentroClp) obj;

        long primaryKey = centro.getPrimaryKey();

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

        sb.append("{id_centro=");
        sb.append(getId_centro());
        sb.append(", id_GPR_centro=");
        sb.append(getId_GPR_centro());
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
        sb.append("ec.gob.snap.vuv.model.Centro");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id_centro</column-name><column-value><![CDATA[");
        sb.append(getId_centro());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id_GPR_centro</column-name><column-value><![CDATA[");
        sb.append(getId_GPR_centro());
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
