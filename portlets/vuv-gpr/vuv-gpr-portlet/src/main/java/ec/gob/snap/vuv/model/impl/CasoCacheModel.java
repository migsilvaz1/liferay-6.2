package ec.gob.snap.vuv.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import ec.gob.snap.vuv.model.Caso;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Caso in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Caso
 * @generated
 */
public class CasoCacheModel implements CacheModel<Caso>, Externalizable {
    public long id_caso;
    public long id_GPR_caso;
    public long content;
    public long timeStamp;
    public long id_servicio;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id_caso=");
        sb.append(id_caso);
        sb.append(", id_GPR_caso=");
        sb.append(id_GPR_caso);
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
    public Caso toEntityModel() {
        CasoImpl casoImpl = new CasoImpl();

        casoImpl.setId_caso(id_caso);
        casoImpl.setId_GPR_caso(id_GPR_caso);
        casoImpl.setContent(content);

        if (timeStamp == Long.MIN_VALUE) {
            casoImpl.setTimeStamp(null);
        } else {
            casoImpl.setTimeStamp(new Date(timeStamp));
        }

        casoImpl.setId_servicio(id_servicio);

        casoImpl.resetOriginalValues();

        return casoImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id_caso = objectInput.readLong();
        id_GPR_caso = objectInput.readLong();
        content = objectInput.readLong();
        timeStamp = objectInput.readLong();
        id_servicio = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id_caso);
        objectOutput.writeLong(id_GPR_caso);
        objectOutput.writeLong(content);
        objectOutput.writeLong(timeStamp);
        objectOutput.writeLong(id_servicio);
    }
}
