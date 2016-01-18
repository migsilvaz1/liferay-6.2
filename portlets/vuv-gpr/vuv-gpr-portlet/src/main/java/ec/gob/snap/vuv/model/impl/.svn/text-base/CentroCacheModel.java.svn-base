package ec.gob.snap.vuv.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import ec.gob.snap.vuv.model.Centro;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Centro in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Centro
 * @generated
 */
public class CentroCacheModel implements CacheModel<Centro>, Externalizable {
    public long id_centro;
    public long id_GPR_centro;
    public long content;
    public long timeStamp;
    public long id_caso;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id_centro=");
        sb.append(id_centro);
        sb.append(", id_GPR_centro=");
        sb.append(id_GPR_centro);
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
    public Centro toEntityModel() {
        CentroImpl centroImpl = new CentroImpl();

        centroImpl.setId_centro(id_centro);
        centroImpl.setId_GPR_centro(id_GPR_centro);
        centroImpl.setContent(content);

        if (timeStamp == Long.MIN_VALUE) {
            centroImpl.setTimeStamp(null);
        } else {
            centroImpl.setTimeStamp(new Date(timeStamp));
        }

        centroImpl.setId_caso(id_caso);

        centroImpl.resetOriginalValues();

        return centroImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id_centro = objectInput.readLong();
        id_GPR_centro = objectInput.readLong();
        content = objectInput.readLong();
        timeStamp = objectInput.readLong();
        id_caso = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id_centro);
        objectOutput.writeLong(id_GPR_centro);
        objectOutput.writeLong(content);
        objectOutput.writeLong(timeStamp);
        objectOutput.writeLong(id_caso);
    }
}
