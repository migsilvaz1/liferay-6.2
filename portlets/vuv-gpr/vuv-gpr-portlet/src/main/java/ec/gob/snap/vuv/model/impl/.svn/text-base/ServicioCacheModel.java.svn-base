package ec.gob.snap.vuv.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import ec.gob.snap.vuv.model.Servicio;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Servicio in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Servicio
 * @generated
 */
public class ServicioCacheModel implements CacheModel<Servicio>, Externalizable {
    public long id_GPR_servicio;
    public long content;
    public long timeStamp;
    public long id_servicio;
    public long id_institucion;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id_GPR_servicio=");
        sb.append(id_GPR_servicio);
        sb.append(", content=");
        sb.append(content);
        sb.append(", timeStamp=");
        sb.append(timeStamp);
        sb.append(", id_servicio=");
        sb.append(id_servicio);
        sb.append(", id_institucion=");
        sb.append(id_institucion);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Servicio toEntityModel() {
        ServicioImpl servicioImpl = new ServicioImpl();

        servicioImpl.setId_GPR_servicio(id_GPR_servicio);
        servicioImpl.setContent(content);

        if (timeStamp == Long.MIN_VALUE) {
            servicioImpl.setTimeStamp(null);
        } else {
            servicioImpl.setTimeStamp(new Date(timeStamp));
        }

        servicioImpl.setId_servicio(id_servicio);
        servicioImpl.setId_institucion(id_institucion);

        servicioImpl.resetOriginalValues();

        return servicioImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id_GPR_servicio = objectInput.readLong();
        content = objectInput.readLong();
        timeStamp = objectInput.readLong();
        id_servicio = objectInput.readLong();
        id_institucion = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id_GPR_servicio);
        objectOutput.writeLong(content);
        objectOutput.writeLong(timeStamp);
        objectOutput.writeLong(id_servicio);
        objectOutput.writeLong(id_institucion);
    }
}
