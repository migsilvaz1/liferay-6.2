package ec.gob.snap.vuv.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import ec.gob.snap.vuv.model.Paso;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Paso in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Paso
 * @generated
 */
public class PasoCacheModel implements CacheModel<Paso>, Externalizable {
    public long id_paso;
    public long id_GPR_paso;
    public long content;
    public long timeStamp;
    public long id_caso;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id_paso=");
        sb.append(id_paso);
        sb.append(", id_GPR_paso=");
        sb.append(id_GPR_paso);
        sb.append(", content=");
        sb.append(content);
        sb.append(", timeStamp=");
        sb.append(timeStamp);
        sb.append(", id_caso=");
        sb.append(id_caso);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Paso toEntityModel() {
        PasoImpl pasoImpl = new PasoImpl();

        pasoImpl.setId_paso(id_paso);
        pasoImpl.setId_GPR_paso(id_GPR_paso);
        pasoImpl.setContent(content);

        if (timeStamp == Long.MIN_VALUE) {
            pasoImpl.setTimeStamp(null);
        } else {
            pasoImpl.setTimeStamp(new Date(timeStamp));
        }

        pasoImpl.setId_caso(id_caso);

        pasoImpl.resetOriginalValues();

        return pasoImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id_paso = objectInput.readLong();
        id_GPR_paso = objectInput.readLong();
        content = objectInput.readLong();
        timeStamp = objectInput.readLong();
        id_caso = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id_paso);
        objectOutput.writeLong(id_GPR_paso);
        objectOutput.writeLong(content);
        objectOutput.writeLong(timeStamp);
        objectOutput.writeLong(id_caso);
    }
}
