package ec.gob.snap.vuv.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import ec.gob.snap.vuv.model.Institucion;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Institucion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Institucion
 * @generated
 */
public class InstitucionCacheModel implements CacheModel<Institucion>,
    Externalizable {
    public long id_institucion;
    public long id_GPR_institucion;
    public long content;
    public long timeStamp;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id_institucion=");
        sb.append(id_institucion);
        sb.append(", id_GPR_institucion=");
        sb.append(id_GPR_institucion);
        sb.append(", content=");
        sb.append(content);
        sb.append(", timeStamp=");
        sb.append(timeStamp);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Institucion toEntityModel() {
        InstitucionImpl institucionImpl = new InstitucionImpl();

        institucionImpl.setId_institucion(id_institucion);
        institucionImpl.setId_GPR_institucion(id_GPR_institucion);
        institucionImpl.setContent(content);

        if (timeStamp == Long.MIN_VALUE) {
            institucionImpl.setTimeStamp(null);
        } else {
            institucionImpl.setTimeStamp(new Date(timeStamp));
        }

        institucionImpl.resetOriginalValues();

        return institucionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id_institucion = objectInput.readLong();
        id_GPR_institucion = objectInput.readLong();
        content = objectInput.readLong();
        timeStamp = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id_institucion);
        objectOutput.writeLong(id_GPR_institucion);
        objectOutput.writeLong(content);
        objectOutput.writeLong(timeStamp);
    }
}
