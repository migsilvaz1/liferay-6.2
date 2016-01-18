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

package com.near.reynasa.masiveLoadUser.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.near.reynasa.masiveLoadUser.service.ClpSerializer;
import com.near.reynasa.masiveLoadUser.service.MasiveLoadUserLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author near
 */
public class MasiveLoadUserClp extends BaseModelImpl<MasiveLoadUser>
	implements MasiveLoadUser {
	public MasiveLoadUserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MasiveLoadUser.class;
	}

	@Override
	public String getModelClassName() {
		return MasiveLoadUser.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("successFile", getSuccessFile());
		attributes.put("errorFile", getErrorFile());
		attributes.put("statusExecution", getStatusExecution());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long successFile = (Long)attributes.get("successFile");

		if (successFile != null) {
			setSuccessFile(successFile);
		}

		Long errorFile = (Long)attributes.get("errorFile");

		if (errorFile != null) {
			setErrorFile(errorFile);
		}

		Integer statusExecution = (Integer)attributes.get("statusExecution");

		if (statusExecution != null) {
			setStatusExecution(statusExecution);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_masiveLoadUserRemoteModel != null) {
			try {
				Class<?> clazz = _masiveLoadUserRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_masiveLoadUserRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_masiveLoadUserRemoteModel != null) {
			try {
				Class<?> clazz = _masiveLoadUserRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_masiveLoadUserRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_masiveLoadUserRemoteModel != null) {
			try {
				Class<?> clazz = _masiveLoadUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_masiveLoadUserRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_masiveLoadUserRemoteModel != null) {
			try {
				Class<?> clazz = _masiveLoadUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_masiveLoadUserRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_masiveLoadUserRemoteModel != null) {
			try {
				Class<?> clazz = _masiveLoadUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_masiveLoadUserRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_masiveLoadUserRemoteModel != null) {
			try {
				Class<?> clazz = _masiveLoadUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_masiveLoadUserRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSuccessFile() {
		return _successFile;
	}

	@Override
	public void setSuccessFile(long successFile) {
		_successFile = successFile;

		if (_masiveLoadUserRemoteModel != null) {
			try {
				Class<?> clazz = _masiveLoadUserRemoteModel.getClass();

				Method method = clazz.getMethod("setSuccessFile", long.class);

				method.invoke(_masiveLoadUserRemoteModel, successFile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getErrorFile() {
		return _errorFile;
	}

	@Override
	public void setErrorFile(long errorFile) {
		_errorFile = errorFile;

		if (_masiveLoadUserRemoteModel != null) {
			try {
				Class<?> clazz = _masiveLoadUserRemoteModel.getClass();

				Method method = clazz.getMethod("setErrorFile", long.class);

				method.invoke(_masiveLoadUserRemoteModel, errorFile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatusExecution() {
		return _statusExecution;
	}

	@Override
	public void setStatusExecution(int statusExecution) {
		_statusExecution = statusExecution;

		if (_masiveLoadUserRemoteModel != null) {
			try {
				Class<?> clazz = _masiveLoadUserRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusExecution", int.class);

				method.invoke(_masiveLoadUserRemoteModel, statusExecution);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMasiveLoadUserRemoteModel() {
		return _masiveLoadUserRemoteModel;
	}

	public void setMasiveLoadUserRemoteModel(
		BaseModel<?> masiveLoadUserRemoteModel) {
		_masiveLoadUserRemoteModel = masiveLoadUserRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _masiveLoadUserRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_masiveLoadUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MasiveLoadUserLocalServiceUtil.addMasiveLoadUser(this);
		}
		else {
			MasiveLoadUserLocalServiceUtil.updateMasiveLoadUser(this);
		}
	}

	@Override
	public MasiveLoadUser toEscapedModel() {
		return (MasiveLoadUser)ProxyUtil.newProxyInstance(MasiveLoadUser.class.getClassLoader(),
			new Class[] { MasiveLoadUser.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MasiveLoadUserClp clone = new MasiveLoadUserClp();

		clone.setId(getId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setSuccessFile(getSuccessFile());
		clone.setErrorFile(getErrorFile());
		clone.setStatusExecution(getStatusExecution());

		return clone;
	}

	@Override
	public int compareTo(MasiveLoadUser masiveLoadUser) {
		int value = 0;

		if (getCompanyId() < masiveLoadUser.getCompanyId()) {
			value = -1;
		}
		else if (getCompanyId() > masiveLoadUser.getCompanyId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getGroupId() < masiveLoadUser.getGroupId()) {
			value = -1;
		}
		else if (getGroupId() > masiveLoadUser.getGroupId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MasiveLoadUserClp)) {
			return false;
		}

		MasiveLoadUserClp masiveLoadUser = (MasiveLoadUserClp)obj;

		long primaryKey = masiveLoadUser.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", successFile=");
		sb.append(getSuccessFile());
		sb.append(", errorFile=");
		sb.append(getErrorFile());
		sb.append(", statusExecution=");
		sb.append(getStatusExecution());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.near.reynasa.masiveLoadUser.model.MasiveLoadUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>successFile</column-name><column-value><![CDATA[");
		sb.append(getSuccessFile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errorFile</column-name><column-value><![CDATA[");
		sb.append(getErrorFile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusExecution</column-name><column-value><![CDATA[");
		sb.append(getStatusExecution());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private long _successFile;
	private long _errorFile;
	private int _statusExecution;
	private BaseModel<?> _masiveLoadUserRemoteModel;
	private Class<?> _clpSerializerClass = com.near.reynasa.masiveLoadUser.service.ClpSerializer.class;
}