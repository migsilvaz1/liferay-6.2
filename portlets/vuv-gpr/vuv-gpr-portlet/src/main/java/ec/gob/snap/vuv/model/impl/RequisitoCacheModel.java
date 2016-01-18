package ec.gob.snap.vuv.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import ec.gob.snap.vuv.model.Requisito;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Requisito in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Requisito
 * @generated
 */
public class RequisitoCacheModel implements CacheModel<Requisito>,
    Externalizable {
    public long id_requisito;
    public long id_GPR_requisito;
    public long content;
    public long timeStamp;
    public long id_paso;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id_requisito=");
        sb.append(id_requisito);
        sb.append(", id_GPR_requisito=");
        sb.append(id_GPR_requisito);
        sb.append(", content=");
        sb.append(content);
        sb.append(", timeStamp=");
        sb.append(timeStamp);
        sb.append(", id_paso=");
        sb.append(id_paso);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Requisito toEntityModel() {
        RequisitoImpl requisitoImpl = new RequisitoImpl();

        requisitoImpl.setId_requisito(id_requisito);
        requisitoImpl.setId_GPR_requisito(id_GPR_requisito);
        requisitoImpl.setContent(content);

        if (timeStamp == Long.MIN_VALUE) {
            requisitoImpl.setTimeStamp(null);
        } else {
            requisitoImpl.setTimeStamp(new Date(timeStamp));
        }

        requisitoImpl.setId_paso(id_paso);

        requisitoImpl.resetOriginalValues();

        return requisitoImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id_requisito = objectInput.readLong();
        id_GPR_requisito = objectInput.readLong();
        content = objectInput.readLong();
        timeStamp = objectInput.readLong();
        id_paso = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id_requisito);
        objectOutput.writeLong(id_GPR_requisito);
        objectOutput.writeLong(content);
        objectOutput.writeLong(timeStamp);
        objectOutput.writeLong(id_paso);
    }
}
