package com.gfi.chg.model.impl;

import com.gfi.chg.model.Area;
import com.gfi.chg.model.AreaModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Area service. Represents a row in the &quot;chg_Area&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.gfi.chg.model.AreaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AreaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AreaImpl
 * @see com.gfi.chg.model.Area
 * @see com.gfi.chg.model.AreaModel
 * @generated
 */
public class AreaModelImpl extends BaseModelImpl<Area> implements AreaModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a area model instance should use the {@link com.gfi.chg.model.Area} interface instead.
     */
    public static final String TABLE_NAME = "chg_Area";
    public static final Object[][] TABLE_COLUMNS = {
            { "areaId", Types.BIGINT },
            { "name", Types.VARCHAR },
            { "mainEmail", Types.VARCHAR },
            { "userId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table chg_Area (areaId LONG not null primary key,name VARCHAR(250) null,mainEmail VARCHAR(75) null,userId LONG)";
    public static final String TABLE_SQL_DROP = "drop table chg_Area";
    public static final String ORDER_BY_JPQL = " ORDER BY area.areaId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY chg_Area.areaId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.gfi.chg.model.Area"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.gfi.chg.model.Area"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.gfi.chg.model.Area"),
            true);
    public static long AREAID_COLUMN_BITMASK = 1L;
    public static long NAME_COLUMN_BITMASK = 2L;
    public static long USERID_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.gfi.chg.model.Area"));
    private static ClassLoader _classLoader = Area.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] { Area.class };
    private long _areaId;
    private long _originalAreaId;
    private boolean _setOriginalAreaId;
    private String _name;
    private String _originalName;
    private String _mainEmail;
    private long _userId;
    private String _userUuid;
    private long _originalUserId;
    private boolean _setOriginalUserId;
    private long _columnBitmask;
    private Area _escapedModel;

    public AreaModelImpl() {
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
    public Class<?> getModelClass() {
        return Area.class;
    }

    @Override
    public String getModelClassName() {
        return Area.class.getName();
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
        _columnBitmask |= AREAID_COLUMN_BITMASK;

        if (!_setOriginalAreaId) {
            _setOriginalAreaId = true;

            _originalAreaId = _areaId;
        }

        _areaId = areaId;
    }

    public long getOriginalAreaId() {
        return _originalAreaId;
    }

    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _columnBitmask |= NAME_COLUMN_BITMASK;

        if (_originalName == null) {
            _originalName = _name;
        }

        _name = name;
    }

    public String getOriginalName() {
        return GetterUtil.getString(_originalName);
    }

    @Override
    public String getMainEmail() {
        if (_mainEmail == null) {
            return StringPool.BLANK;
        } else {
            return _mainEmail;
        }
    }

    @Override
    public void setMainEmail(String mainEmail) {
        _mainEmail = mainEmail;
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _columnBitmask |= USERID_COLUMN_BITMASK;

        if (!_setOriginalUserId) {
            _setOriginalUserId = true;

            _originalUserId = _userId;
        }

        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public long getOriginalUserId() {
        return _originalUserId;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            Area.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Area toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Area) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        AreaImpl areaImpl = new AreaImpl();

        areaImpl.setAreaId(getAreaId());
        areaImpl.setName(getName());
        areaImpl.setMainEmail(getMainEmail());
        areaImpl.setUserId(getUserId());

        areaImpl.resetOriginalValues();

        return areaImpl;
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

        if (!(obj instanceof Area)) {
            return false;
        }

        Area area = (Area) obj;

        long primaryKey = area.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        AreaModelImpl areaModelImpl = this;

        areaModelImpl._originalAreaId = areaModelImpl._areaId;

        areaModelImpl._setOriginalAreaId = false;

        areaModelImpl._originalName = areaModelImpl._name;

        areaModelImpl._originalUserId = areaModelImpl._userId;

        areaModelImpl._setOriginalUserId = false;

        areaModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Area> toCacheModel() {
        AreaCacheModel areaCacheModel = new AreaCacheModel();

        areaCacheModel.areaId = getAreaId();

        areaCacheModel.name = getName();

        String name = areaCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            areaCacheModel.name = null;
        }

        areaCacheModel.mainEmail = getMainEmail();

        String mainEmail = areaCacheModel.mainEmail;

        if ((mainEmail != null) && (mainEmail.length() == 0)) {
            areaCacheModel.mainEmail = null;
        }

        areaCacheModel.userId = getUserId();

        return areaCacheModel;
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
