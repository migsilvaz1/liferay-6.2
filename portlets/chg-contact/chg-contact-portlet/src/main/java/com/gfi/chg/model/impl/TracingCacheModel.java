package com.gfi.chg.model.impl;

import com.gfi.chg.model.Tracing;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Tracing in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Tracing
 * @generated
 */
public class TracingCacheModel implements CacheModel<Tracing>, Externalizable {
    public long tracingId;
    public long areaId;
    public long contactId;
    public int status;
    public long modifiedDate;
    public String comment;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{tracingId=");
        sb.append(tracingId);
        sb.append(", areaId=");
        sb.append(areaId);
        sb.append(", contactId=");
        sb.append(contactId);
        sb.append(", status=");
        sb.append(status);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", comment=");
        sb.append(comment);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Tracing toEntityModel() {
        TracingImpl tracingImpl = new TracingImpl();

        tracingImpl.setTracingId(tracingId);
        tracingImpl.setAreaId(areaId);
        tracingImpl.setContactId(contactId);
        tracingImpl.setStatus(status);

        if (modifiedDate == Long.MIN_VALUE) {
            tracingImpl.setModifiedDate(null);
        } else {
            tracingImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (comment == null) {
            tracingImpl.setComment(StringPool.BLANK);
        } else {
            tracingImpl.setComment(comment);
        }

        tracingImpl.resetOriginalValues();

        return tracingImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        tracingId = objectInput.readLong();
        areaId = objectInput.readLong();
        contactId = objectInput.readLong();
        status = objectInput.readInt();
        modifiedDate = objectInput.readLong();
        comment = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(tracingId);
        objectOutput.writeLong(areaId);
        objectOutput.writeLong(contactId);
        objectOutput.writeInt(status);
        objectOutput.writeLong(modifiedDate);

        if (comment == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(comment);
        }
    }
}
