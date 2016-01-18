package com.gfi.chg.model.impl;

import com.gfi.chg.model.Area;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Area in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Area
 * @generated
 */
public class AreaCacheModel implements CacheModel<Area>, Externalizable {
    public long areaId;
    public String name;
    public String mainEmail;
    public long userId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{areaId=");
        sb.append(areaId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", mainEmail=");
        sb.append(mainEmail);
        sb.append(", userId=");
        sb.append(userId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Area toEntityModel() {
        AreaImpl areaImpl = new AreaImpl();

        areaImpl.setAreaId(areaId);

        if (name == null) {
            areaImpl.setName(StringPool.BLANK);
        } else {
            areaImpl.setName(name);
        }

        if (mainEmail == null) {
            areaImpl.setMainEmail(StringPool.BLANK);
        } else {
            areaImpl.setMainEmail(mainEmail);
        }

        areaImpl.setUserId(userId);

        areaImpl.resetOriginalValues();

        return areaImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        areaId = objectInput.readLong();
        name = objectInput.readUTF();
        mainEmail = objectInput.readUTF();
        userId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(areaId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (mainEmail == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mainEmail);
        }

        objectOutput.writeLong(userId);
    }
}
