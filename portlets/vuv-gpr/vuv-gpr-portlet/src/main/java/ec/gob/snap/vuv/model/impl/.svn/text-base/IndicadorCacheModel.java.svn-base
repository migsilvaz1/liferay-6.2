package ec.gob.snap.vuv.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import ec.gob.snap.vuv.model.Indicador;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Indicador in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Indicador
 * @generated
 */
public class IndicadorCacheModel implements CacheModel<Indicador>,
    Externalizable {
    public long id_indicador;
    public long id_GPR_indicador;
    public long content;
    public long timeStamp;
    public long id_servicio;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id_indicador=");
        sb.append(id_indicador);
        sb.append(", id_GPR_indicador=");
        sb.append(id_GPR_indicador);
        sb.append(", content=");
        sb.append(content);
        sb.append(", timeStamp=");
        sb.append(timeStamp);
        sb.append(", id_servicio=");
        sb.append(id_servicio);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Indicador toEntityModel() {
        IndicadorImpl indicadorImpl = new IndicadorImpl();

        indicadorImpl.setId_indicador(id_indicador);
        indicadorImpl.setId_GPR_indicador(id_GPR_indicador);
        indicadorImpl.setContent(content);

        if (timeStamp == Long.MIN_VALUE) {
            indicadorImpl.setTimeStamp(null);
        } else {
            indicadorImpl.setTimeStamp(new Date(timeStamp));
        }

        indicadorImpl.setId_servicio(id_servicio);

        indicadorImpl.resetOriginalValues();

        return indicadorImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id_indicador = objectInput.readLong();
        id_GPR_indicador = objectInput.readLong();
        content = objectInput.readLong();
        timeStamp = objectInput.readLong();
        id_servicio = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id_indicador);
        objectOutput.writeLong(id_GPR_indicador);
        objectOutput.writeLong(content);
        objectOutput.writeLong(timeStamp);
        objectOutput.writeLong(id_servicio);
    }
}
