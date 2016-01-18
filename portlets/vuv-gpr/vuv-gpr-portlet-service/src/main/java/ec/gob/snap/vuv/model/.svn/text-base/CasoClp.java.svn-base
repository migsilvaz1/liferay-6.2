package ec.gob.snap.vuv.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ec.gob.snap.vuv.service.CasoLocalServiceUtil;
import ec.gob.snap.vuv.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class CasoClp extends BaseModelImpl<Caso> implements Caso {
    private long _id_caso;
    private long _id_GPR_caso;
    private long _content;
    private Date _timeStamp;
    private long _id_servicio;
    private BaseModel<?> _casoRemoteModel;
    private Class<?> _clpSerializerClass = ec.gob.snap.vuv.service.ClpSerializer.class;

    public CasoClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Caso.class;
    }

    @Override
    public String getModelClassName() {
        return Caso.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _id_caso;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId_caso(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id_caso;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id_caso", getId_caso());
        attributes.put("id_GPR_caso", getId_GPR_caso());
        attributes.put("content", getContent());
        attributes.put("timeStamp", getTimeStamp());
        attributes.put("id_servicio", getId_servicio());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id_caso = (Long) attributes.get("id_caso");

        if (id_caso != null) {
            setId_caso(id_caso);
        }

        Long id_GPR_caso = (Long) attributes.get("id_GPR_caso");

        if (id_GPR_caso != null) {
            setId_GPR_caso(id_GPR_caso);
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
    public long getId_caso() {
        return _id_caso;
    }

    @Override
    public void setId_caso(long id_caso) {
        _id_caso = id_caso;

        if (_casoRemoteModel != null) {
            try {
                Class<?> clazz = _casoRemoteModel.getClass();

                Method method = clazz.getMethod("setId_caso", long.class);

                method.invoke(_casoRemoteModel, id_caso);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getId_GPR_caso() {
        return _id_GPR_caso;
    }

    @Override
    public void setId_GPR_caso(long id_GPR_caso) {
        _id_GPR_caso = id_GPR_caso;

        if (_casoRemoteModel != null) {
            try {
                Class<?> clazz = _casoRemoteModel.getClass();

                Method method = clazz.getMethod("setId_GPR_caso", long.class);

                method.invoke(_casoRemoteModel, id_GPR_caso);
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

        if (_casoRemoteModel != null) {
            try {
                Class<?> clazz = _casoRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", long.class);

                method.invoke(_casoRemoteModel, content);
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

        if (_casoRemoteModel != null) {
            try {
                Class<?> clazz = _casoRemoteModel.getClass();

                Method method = clazz.getMethod("setTimeStamp", Date.class);

                method.invoke(_casoRemoteModel, timeStamp);
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

        if (_casoRemoteModel != null) {
            try {
                Class<?> clazz = _casoRemoteModel.getClass();

                Method method = clazz.getMethod("setId_servicio", long.class);

                method.invoke(_casoRemoteModel, id_servicio);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getCasoRemoteModel() {
        return _casoRemoteModel;
    }

    public void setCasoRemoteModel(BaseModel<?> casoRemoteModel) {
        _casoRemoteModel = casoRemoteModel;
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

        Class<?> remoteModelClass = _casoRemoteModel.getClass();

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

        Object returnValue = method.invoke(_casoRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CasoLocalServiceUtil.addCaso(this);
        } else {
            CasoLocalServiceUtil.updateCaso(this);
        }
    }

    @Override
    public Caso toEscapedModel() {
        return (Caso) ProxyUtil.newProxyInstance(Caso.class.getClassLoader(),
            new Class[] { Caso.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        CasoClp clone = new CasoClp();

        clone.setId_caso(getId_caso());
        clone.setId_GPR_caso(getId_GPR_caso());
        clone.setContent(getContent());
        clone.setTimeStamp(getTimeStamp());
        clone.setId_servicio(getId_servicio());

        return clone;
    }

    @Override
    public int compareTo(Caso caso) {
        long primaryKey = caso.getPrimaryKey();

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

        if (!(obj instanceof CasoClp)) {
            return false;
        }

        CasoClp caso = (CasoClp) obj;

        long primaryKey = caso.getPrimaryKey();

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

        sb.append("{id_caso=");
        sb.append(getId_caso());
        sb.append(", id_GPR_caso=");
        sb.append(getId_GPR_caso());
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
        sb.append("ec.gob.snap.vuv.model.Caso");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id_caso</column-name><column-value><![CDATA[");
        sb.append(getId_caso());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id_GPR_caso</column-name><column-value><![CDATA[");
        sb.append(getId_GPR_caso());
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
