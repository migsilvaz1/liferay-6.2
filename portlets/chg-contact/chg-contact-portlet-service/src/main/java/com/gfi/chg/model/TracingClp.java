package com.gfi.chg.model;

import com.gfi.chg.service.ClpSerializer;
import com.gfi.chg.service.TracingLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TracingClp extends BaseModelImpl<Tracing> implements Tracing {
    private long _tracingId;
    private long _areaId;
    private long _contactId;
    private int _status;
    private Date _modifiedDate;
    private String _comment;
    private BaseModel<?> _tracingRemoteModel;
    private Class<?> _clpSerializerClass = com.gfi.chg.service.ClpSerializer.class;

    public TracingClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Tracing.class;
    }

    @Override
    public String getModelClassName() {
        return Tracing.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _tracingId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setTracingId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _tracingId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("tracingId", getTracingId());
        attributes.put("areaId", getAreaId());
        attributes.put("contactId", getContactId());
        attributes.put("status", getStatus());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("comment", getComment());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long tracingId = (Long) attributes.get("tracingId");

        if (tracingId != null) {
            setTracingId(tracingId);
        }

        Long areaId = (Long) attributes.get("areaId");

        if (areaId != null) {
            setAreaId(areaId);
        }

        Long contactId = (Long) attributes.get("contactId");

        if (contactId != null) {
            setContactId(contactId);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String comment = (String) attributes.get("comment");

        if (comment != null) {
            setComment(comment);
        }
    }

    @Override
    public long getTracingId() {
        return _tracingId;
    }

    @Override
    public void setTracingId(long tracingId) {
        _tracingId = tracingId;

        if (_tracingRemoteModel != null) {
            try {
                Class<?> clazz = _tracingRemoteModel.getClass();

                Method method = clazz.getMethod("setTracingId", long.class);

                method.invoke(_tracingRemoteModel, tracingId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getAreaId() {
        return _areaId;
    }

    @Override
    public void setAreaId(long areaId) {
        _areaId = areaId;

        if (_tracingRemoteModel != null) {
            try {
                Class<?> clazz = _tracingRemoteModel.getClass();

                Method method = clazz.getMethod("setAreaId", long.class);

                method.invoke(_tracingRemoteModel, areaId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getContactId() {
        return _contactId;
    }

    @Override
    public void setContactId(long contactId) {
        _contactId = contactId;

        if (_tracingRemoteModel != null) {
            try {
                Class<?> clazz = _tracingRemoteModel.getClass();

                Method method = clazz.getMethod("setContactId", long.class);

                method.invoke(_tracingRemoteModel, contactId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;

        if (_tracingRemoteModel != null) {
            try {
                Class<?> clazz = _tracingRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_tracingRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_tracingRemoteModel != null) {
            try {
                Class<?> clazz = _tracingRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_tracingRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getComment() {
        return _comment;
    }

    @Override
    public void setComment(String comment) {
        _comment = comment;

        if (_tracingRemoteModel != null) {
            try {
                Class<?> clazz = _tracingRemoteModel.getClass();

                Method method = clazz.getMethod("setComment", String.class);

                method.invoke(_tracingRemoteModel, comment);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getTracingRemoteModel() {
        return _tracingRemoteModel;
    }

    public void setTracingRemoteModel(BaseModel<?> tracingRemoteModel) {
        _tracingRemoteModel = tracingRemoteModel;
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

        Class<?> remoteModelClass = _tracingRemoteModel.getClass();

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

        Object returnValue = method.invoke(_tracingRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            TracingLocalServiceUtil.addTracing(this);
        } else {
            TracingLocalServiceUtil.updateTracing(this);
        }
    }

    @Override
    public Tracing toEscapedModel() {
        return (Tracing) ProxyUtil.newProxyInstance(Tracing.class.getClassLoader(),
            new Class[] { Tracing.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        TracingClp clone = new TracingClp();

        clone.setTracingId(getTracingId());
        clone.setAreaId(getAreaId());
        clone.setContactId(getContactId());
        clone.setStatus(getStatus());
        clone.setModifiedDate(getModifiedDate());
        clone.setComment(getComment());

        return clone;
    }

    @Override
    public int compareTo(Tracing tracing) {
        long primaryKey = tracing.getPrimaryKey();

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

        if (!(obj instanceof TracingClp)) {
            return false;
        }

        TracingClp tracing = (TracingClp) obj;

        long primaryKey = tracing.getPrimaryKey();

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
        StringBundler sb = new StringBundler(13);

        sb.append("{tracingId=");
        sb.append(getTracingId());
        sb.append(", areaId=");
        sb.append(getAreaId());
        sb.append(", contactId=");
        sb.append(getContactId());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", comment=");
        sb.append(getComment());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.gfi.chg.model.Tracing");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>tracingId</column-name><column-value><![CDATA[");
        sb.append(getTracingId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>areaId</column-name><column-value><![CDATA[");
        sb.append(getAreaId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactId</column-name><column-value><![CDATA[");
        sb.append(getContactId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>comment</column-name><column-value><![CDATA[");
        sb.append(getComment());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
