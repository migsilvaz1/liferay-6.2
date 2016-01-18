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

import ec.gob.snap.vuv.model.Institucion;
import ec.gob.snap.vuv.model.InstitucionModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Institucion service. Represents a row in the &quot;vuv_gpr_service_builder_Institucion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ec.gob.snap.vuv.model.InstitucionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link InstitucionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InstitucionImpl
 * @see ec.gob.snap.vuv.model.Institucion
 * @see ec.gob.snap.vuv.model.InstitucionModel
 * @generated
 */
public class InstitucionModelImpl extends BaseModelImpl<Institucion>
    implements InstitucionModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a institucion model instance should use the {@link ec.gob.snap.vuv.model.Institucion} interface instead.
     */
    public static final String TABLE_NAME = "vuv_gpr_service_builder_Institucion";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_institucion", Types.BIGINT },
            { "id_GPR_institucion", Types.BIGINT },
            { "content", Types.BIGINT },
            { "timeStamp", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table vuv_gpr_service_builder_Institucion (id_institucion LONG not null primary key,id_GPR_institucion LONG,content LONG,timeStamp DATE null)";
    public static final String TABLE_SQL_DROP = "drop table vuv_gpr_service_builder_Institucion";
    public static final String ORDER_BY_JPQL = " ORDER BY institucion.id_institucion ASC";
    public static final String ORDER_BY_SQL = " ORDER BY vuv_gpr_service_builder_Institucion.id_institucion ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.ec.gob.snap.vuv.model.Institucion"),
            false);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.ec.gob.snap.vuv.model.Institucion"),
            false);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.ec.gob.snap.vuv.model.Institucion"));
    private static ClassLoader _classLoader = Institucion.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Institucion.class
        };
    private long _id_institucion;
    private long _id_GPR_institucion;
    private long _content;
    private Date _timeStamp;
    private Institucion _escapedModel;

    public InstitucionModelImpl() {
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
    public Class<?> getModelClass() {
        return Institucion.class;
    }

    @Override
    public String getModelClassName() {
        return Institucion.class.getName();
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
    }

    @Override
    public long getId_GPR_institucion() {
        return _id_GPR_institucion;
    }

    @Override
    public void setId_GPR_institucion(long id_GPR_institucion) {
        _id_GPR_institucion = id_GPR_institucion;
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
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            Institucion.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Institucion toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Institucion) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        InstitucionImpl institucionImpl = new InstitucionImpl();

        institucionImpl.setId_institucion(getId_institucion());
        institucionImpl.setId_GPR_institucion(getId_GPR_institucion());
        institucionImpl.setContent(getContent());
        institucionImpl.setTimeStamp(getTimeStamp());

        institucionImpl.resetOriginalValues();

        return institucionImpl;
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

        if (!(obj instanceof Institucion)) {
            return false;
        }

        Institucion institucion = (Institucion) obj;

        long primaryKey = institucion.getPrimaryKey();

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
    public CacheModel<Institucion> toCacheModel() {
        InstitucionCacheModel institucionCacheModel = new InstitucionCacheModel();

        institucionCacheModel.id_institucion = getId_institucion();

        institucionCacheModel.id_GPR_institucion = getId_GPR_institucion();

        institucionCacheModel.content = getContent();

        Date timeStamp = getTimeStamp();

        if (timeStamp != null) {
            institucionCacheModel.timeStamp = timeStamp.getTime();
        } else {
            institucionCacheModel.timeStamp = Long.MIN_VALUE;
        }

        return institucionCacheModel;
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
