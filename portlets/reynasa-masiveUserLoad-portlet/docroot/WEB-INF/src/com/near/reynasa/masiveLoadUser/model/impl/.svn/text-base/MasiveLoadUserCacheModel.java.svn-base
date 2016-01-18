/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.near.reynasa.masiveLoadUser.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.near.reynasa.masiveLoadUser.model.MasiveLoadUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MasiveLoadUser in entity cache.
 *
 * @author near
 * @see MasiveLoadUser
 * @generated
 */
public class MasiveLoadUserCacheModel implements CacheModel<MasiveLoadUser>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", successFile=");
		sb.append(successFile);
		sb.append(", errorFile=");
		sb.append(errorFile);
		sb.append(", statusExecution=");
		sb.append(statusExecution);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MasiveLoadUser toEntityModel() {
		MasiveLoadUserImpl masiveLoadUserImpl = new MasiveLoadUserImpl();

		masiveLoadUserImpl.setId(id);
		masiveLoadUserImpl.setGroupId(groupId);
		masiveLoadUserImpl.setCompanyId(companyId);
		masiveLoadUserImpl.setUserId(userId);

		if (userName == null) {
			masiveLoadUserImpl.setUserName(StringPool.BLANK);
		}
		else {
			masiveLoadUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			masiveLoadUserImpl.setCreateDate(null);
		}
		else {
			masiveLoadUserImpl.setCreateDate(new Date(createDate));
		}

		masiveLoadUserImpl.setSuccessFile(successFile);
		masiveLoadUserImpl.setErrorFile(errorFile);
		masiveLoadUserImpl.setStatusExecution(statusExecution);

		masiveLoadUserImpl.resetOriginalValues();

		return masiveLoadUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		successFile = objectInput.readLong();
		errorFile = objectInput.readLong();
		statusExecution = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(successFile);
		objectOutput.writeLong(errorFile);
		objectOutput.writeInt(statusExecution);
	}

	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long successFile;
	public long errorFile;
	public int statusExecution;
}