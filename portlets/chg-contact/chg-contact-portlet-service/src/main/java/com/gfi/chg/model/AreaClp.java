package com.gfi.chg.model;

import com.gfi.chg.service.AreaLocalServiceUtil;
import com.gfi.chg.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class AreaClp extends BaseModelImpl<Area> implements Area {
    private long _areaId;
    private String _name;
    private String _mainEmail;
    private long _userId;
    private String _userUuid;
    private BaseModel<?> _areaRemoteModel;
    private Class<?> _clpSerializerClass = com.gfi.chg.service.ClpSerializer.class;

    public AreaClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Area.class;
    }

    @Override
    public String getModelClassName() {
        return Area.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _areaId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setAreaId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _areaId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("areaId", getAreaId());
        attributes.put("name", getName());
        attributes.put("mainEmail", getMainEmail());
        attributes.put("userId", getUserId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long areaId = (Long) attributes.get("areaId");

        if (areaId != null) {
            setAreaId(areaId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String mainEmail = (String) attributes.get("mainEmail");

        if (mainEmail != null) {
            setMainEmail(mainEmail);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }
    }

    @Override
    public long getAreaId() {
        return _areaId;
    }

    @Override
    public void setAreaId(long areaId) {
        _areaId = areaId;

        if (_areaRemoteModel != null) {
            try {
                Class<?> clazz = _areaRemoteModel.getClass();

                Method method = clazz.getMethod("setAreaId", long.class);

                method.invoke(_areaRemoteModel, areaId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_areaRemoteModel != null) {
            try {
                Class<?> clazz = _areaRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_areaRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMainEmail() {
        return _mainEmail;
    }

    @Override
    public void setMainEmail(String mainEmail) {
        _mainEmail = mainEmail;

        if (_areaRemoteModel != null) {
            try {
                Class<?> clazz = _areaRemoteModel.getClass();

                Method method = clazz.getMethod("setMainEmail", String.class);

                method.invoke(_areaRemoteModel, mainEmail);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_areaRemoteModel != null) {
            try {
                Class<?> clazz = _areaRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_areaRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public BaseModel<?> getAreaRemoteModel() {
        return _areaRemoteModel;
    }

    public void setAreaRemoteModel(BaseModel<?> areaRemoteModel) {
        _areaRemoteModel = areaRemoteModel;
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

        Class<?> remoteModelClass = _areaRemoteModel.getClass();

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

        Object returnValue = method.invoke(_areaRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AreaLocalServiceUtil.addArea(this);
        } else {
            AreaLocalServiceUtil.updateArea(this);
        }
    }

    @Override
    public Area toEscapedModel() {
        return (Area) ProxyUtil.newProxyInstance(Area.class.getClassLoader(),
            new Class[] { Area.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AreaClp clone = new AreaClp();

        clone.setAreaId(getAreaId());
        clone.setName(getName());
        clone.setMainEmail(getMainEmail());
        clone.setUserId(getUserId());

        return clone;
    }

    @Override
    public int compareTo(Area area) {
        long primaryKey = area.getPrimaryKey();

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

        if (!(obj instanceof AreaClp)) {
            return false;
        }

        AreaClp area = (AreaClp) obj;

        long primaryKey = area.getPrimaryKey();

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

        sb.append("{areaId=");
        sb.append(getAreaId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", mainEmail=");
        sb.append(getMainEmail());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.gfi.chg.model.Area");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>areaId</column-name><column-value><![CDATA[");
        sb.append(getAreaId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mainEmail</column-name><column-value><![CDATA[");
        sb.append(getMainEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
