package ec.gob.snap.vuv.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import ec.gob.snap.vuv.model.Act_Institucional;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Act_Institucional in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Act_Institucional
 * @generated
 */
public class Act_InstitucionalCacheModel implements CacheModel<Act_Institucional>,
    Externalizable {
    public long id_act_institucional;
    public long id_GPR_act_institucional;
    public long content;
    public long timeStamp;
    public long id_servicio;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id_act_institucional=");
        sb.append(id_act_institucional);
        sb.append(", id_GPR_act_institucional=");
        sb.append(id_GPR_act_institucional);
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
    public Act_Institucional toEntityModel() {
        Act_InstitucionalImpl act_InstitucionalImpl = new Act_InstitucionalImpl();

        act_InstitucionalImpl.setId_act_institucional(id_act_institucional);
        act_InstitucionalImpl.setId_GPR_act_institucional(id_GPR_act_institucional);
        act_InstitucionalImpl.setContent(content);

        if (timeStamp == Long.MIN_VALUE) {
            act_InstitucionalImpl.setTimeStamp(null);
        } else {
            act_InstitucionalImpl.setTimeStamp(new Date(timeStamp));
        }

        act_InstitucionalImpl.setId_servicio(id_servicio);

        act_InstitucionalImpl.resetOriginalValues();

        return act_InstitucionalImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id_act_institucional = objectInput.readLong();
        id_GPR_act_institucional = objectInput.readLong();
        content = objectInput.readLong();
        timeStamp = objectInput.readLong();
        id_servicio = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id_act_institucional);
        objectOutput.writeLong(id_GPR_act_institucional);
        objectOutput.writeLong(content);
        objectOutput.writeLong(timeStamp);
        objectOutput.writeLong(id_servicio);
    }
}
