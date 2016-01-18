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

import ec.gob.snap.vuv.model.Requisito;
import ec.gob.snap.vuv.model.RequisitoModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Requisito service. Represents a row in the &quot;vuv_gpr_service_builder_Requisito&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ec.gob.snap.vuv.model.RequisitoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RequisitoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RequisitoImpl
 * @see ec.gob.snap.vuv.model.Requisito
 * @see ec.gob.snap.vuv.model.RequisitoModel
 * @generated
 */
public class RequisitoModelImpl extends BaseModelImpl<Requisito>
    implements RequisitoModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a requisito model instance should use the {@link ec.gob.snap.vuv.model.Requisito} interface instead.
     */
    public static final String TABLE_NAME = "vuv_gpr_service_builder_Requisito";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_requisito", Types.BIGINT },
            { "id_GPR_requisito", Types.BIGINT },
            { "content", Types.BIGINT },
            { "timeStamp", Types.TIMESTAMP },
            { "id_paso", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table vuv_gpr_service_builder_Requisito (id_requisito LONG not null primary key,id_GPR_requisito LONG,content LONG,timeStamp DATE null,id_paso LONG)";
    public static final String TABLE_SQL_DROP = "drop table vuv_gpr_service_builder_Requisito";
    public static final String ORDER_BY_JPQL = " ORDER BY requisito.id_requisito ASC";
    public static final String ORDER_BY_SQL = " ORDER BY vuv_gpr_service_builder_Requisito.id_requisito ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.ec.gob.snap.vuv.model.Requisito"),
            false);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.ec.gob.snap.vuv.model.Requisito"),
            false);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.ec.gob.snap.vuv.model.Requisito"));
    private static ClassLoader _classLoader = Requisito.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Requisito.class
        };
    private long _id_requisito;
    private long _id_GPR_requisito;
    private long _content;
    private Date _timeStamp;
    private long _id_paso;
    private Requisito _escapedModel;

    public RequisitoModelImpl() {
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
    public Class<?> getModelClass() {
        return Requisito.class;
    }

    @Override
    public String getModelClassName() {
        return Requisito.class.getName();
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
    }

    @Override
    public long getId_GPR_requisito() {
        return _id_GPR_requisito;
    }

    @Override
    public void setId_GPR_requisito(long id_GPR_requisito) {
        _id_GPR_requisito = id_GPR_requisito;
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
    public long getId_paso() {
        return _id_paso;
    }

    @Override
    public void setId_paso(long id_paso) {
        _id_paso = id_paso;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            Requisito.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Requisito toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Requisito) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        RequisitoImpl requisitoImpl = new RequisitoImpl();

        requisitoImpl.setId_requisito(getId_requisito());
        requisitoImpl.setId_GPR_requisito(getId_GPR_requisito());
        requisitoImpl.setContent(getContent());
        requisitoImpl.setTimeStamp(getTimeStamp());
        requisitoImpl.setId_paso(getId_paso());

        requisitoImpl.resetOriginalValues();

        return requisitoImpl;
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

        if (!(obj instanceof Requisito)) {
            return false;
        }

        Requisito requisito = (Requisito) obj;

        long primaryKey = requisito.getPrimaryKey();

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
    public CacheModel<Requisito> toCacheModel() {
        RequisitoCacheModel requisitoCacheModel = new RequisitoCacheModel();

        requisitoCacheModel.id_requisito = getId_requisito();

        requisitoCacheModel.id_GPR_requisito = getId_GPR_requisito();

        requisitoCacheModel.content = getContent();

        Date timeStamp = getTimeStamp();

        if (timeStamp != null) {
            requisitoCacheModel.timeStamp = timeStamp.getTime();
        } else {
            requisitoCacheModel.timeStamp = Long.MIN_VALUE;
        }

        requisitoCacheModel.id_paso = getId_paso();

        return requisitoCacheModel;
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
