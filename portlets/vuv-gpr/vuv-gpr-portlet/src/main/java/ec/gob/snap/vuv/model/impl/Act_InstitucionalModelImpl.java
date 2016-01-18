package ec.gob.snap.vuv.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import ec.gob.snap.vuv.model.Act_Institucional;
import ec.gob.snap.vuv.model.Act_InstitucionalModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Act_Institucional service. Represents a row in the &quot;vuv_gpr_service_builder_Act_Institucional&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ec.gob.snap.vuv.model.Act_InstitucionalModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Act_InstitucionalImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Act_InstitucionalImpl
 * @see ec.gob.snap.vuv.model.Act_Institucional
 * @see ec.gob.snap.vuv.model.Act_InstitucionalModel
 * @generated
 */
public class Act_InstitucionalModelImpl extends BaseModelImpl<Act_Institucional>
    implements Act_InstitucionalModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a act_ institucional model instance should use the {@link ec.gob.snap.vuv.model.Act_Institucional} interface instead.
     */
    public static final String TABLE_NAME = "vuv_gpr_service_builder_Act_Institucional";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_act_institucional", Types.BIGINT },
            { "id_GPR_act_institucional", Types.BIGINT },
            { "content", Types.BIGINT },
            { "timeStamp", Types.TIMESTAMP },
            { "id_servicio", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table vuv_gpr_service_builder_Act_Institucional (id_act_institucional LONG not null primary key,id_GPR_act_institucional LONG,content LONG,timeStamp DATE null,id_servicio LONG)";
    public static final String TABLE_SQL_DROP = "drop table vuv_gpr_service_builder_Act_Institucional";
    public static final String ORDER_BY_JPQL = " ORDER BY act_Institucional.id_act_institucional ASC";
    public static final String ORDER_BY_SQL = " ORDER BY vuv_gpr_service_builder_Act_Institucional.id_act_institucional ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.ec.gob.snap.vuv.model.Act_Institucional"),
            false);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.ec.gob.snap.vuv.model.Act_Institucional"),
            false);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.ec.gob.snap.vuv.model.Act_Institucional"));
    private static ClassLoader _classLoader = Act_Institucional.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Act_Institucional.class
        };
    private long _id_act_institucional;
    private long _id_GPR_act_institucional;
    private long _content;
    private Date _timeStamp;
    private long _id_servicio;
    private Act_Institucional _escapedModel;

    public Act_InstitucionalModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _id_act_institucional;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId_act_institucional(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id_act_institucional;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Act_Institucional.class;
    }

    @Override
    public String getModelClassName() {
        return Act_Institucional.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id_act_institucional", getId_act_institucional());
        attributes.put("id_GPR_act_institucional", getId_GPR_act_institucional());
        attributes.put("content", getContent());
        attributes.put("timeStamp", getTimeStamp());
        attributes.put("id_servicio", getId_servicio());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id_act_institucional = (Long) attributes.get(
                "id_act_institucional");

        if (id_act_institucional != null) {
            setId_act_institucional(id_act_institucional);
        }

        Long id_GPR_act_institucional = (Long) attributes.get(
                "id_GPR_act_institucional");

        if (id_GPR_act_institucional != null) {
            setId_GPR_act_institucional(id_GPR_act_institucional);
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
    public long getId_act_institucional() {
        return _id_act_institucional;
    }

    @Override
    public void setId_act_institucional(long id_act_institucional) {
        _id_act_institucional = id_act_institucional;
    }

    @Override
    public long getId_GPR_act_institucional() {
        return _id_GPR_act_institucional;
    }

    @Override
    public void setId_GPR_act_institucional(long id_GPR_act_institucional) {
        _id_GPR_act_institucional = id_GPR_act_institucional;
    }

    @Override
    public long getContent() {
        return _content;
    }

    @Override
    public void setContent(long content) {
        _content = content;
    }

    @Override
    public Date getTimeStamp() {
        return _timeStamp;
    }

    @Override
    public void setTimeStamp(Date timeStamp) {
        _timeStamp = timeStamp;
    }

    @Override
    public long getId_servicio() {
        return _id_servicio;
    }

    @Override
    public void setId_servicio(long id_servicio) {
        _id_servicio = id_servicio;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            Act_Institucional.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Act_Institucional toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Act_Institucional) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        Act_InstitucionalImpl act_InstitucionalImpl = new Act_InstitucionalImpl();

        act_InstitucionalImpl.setId_act_institucional(getId_act_institucional());
        act_InstitucionalImpl.setId_GPR_act_institucional(getId_GPR_act_institucional());
        act_InstitucionalImpl.setContent(getContent());
        act_InstitucionalImpl.setTimeStamp(getTimeStamp());
        act_InstitucionalImpl.setId_servicio(getId_servicio());

        act_InstitucionalImpl.resetOriginalValues();

        return act_InstitucionalImpl;
    }

    @Override
    public int compareTo(Act_Institucional act_Institucional) {
        long primaryKey = act_Institucional.getPrimaryKey();

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

        if (!(obj instanceof Act_Institucional)) {
            return false;
        }

        Act_Institucional act_Institucional = (Act_Institucional) obj;

        long primaryKey = act_Institucional.getPrimaryKey();

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
    }

    @Override
    public CacheModel<Act_Institucional> toCacheModel() {
        Act_InstitucionalCacheModel act_InstitucionalCacheModel = new Act_InstitucionalCacheModel();

        act_InstitucionalCacheModel.id_act_institucional = getId_act_institucional();

        act_InstitucionalCacheModel.id_GPR_act_institucional = getId_GPR_act_institucional();

        act_InstitucionalCacheModel.content = getContent();

        Date timeStamp = getTimeStamp();

        if (timeStamp != null) {
            act_InstitucionalCacheModel.timeStamp = timeStamp.getTime();
        } else {
            act_InstitucionalCacheModel.timeStamp = Long.MIN_VALUE;
        }

        act_InstitucionalCacheModel.id_servicio = getId_servicio();

        return act_InstitucionalCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id_act_institucional=");
        sb.append(getId_act_institucional());
        sb.append(", id_GPR_act_institucional=");
        sb.append(getId_GPR_act_institucional());
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
        sb.append("ec.gob.snap.vuv.model.Act_Institucional");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id_act_institucional</column-name><column-value><![CDATA[");
        sb.append(getId_act_institucional());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id_GPR_act_institucional</column-name><column-value><![CDATA[");
        sb.append(getId_GPR_act_institucional());
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
