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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.near.reynasa.masiveLoadUser.service.http.MasiveLoadUserServiceSoap}.
 *
 * @author near
 * @see com.near.reynasa.masiveLoadUser.service.http.MasiveLoadUserServiceSoap
 * @generated
 */
public class MasiveLoadUserSoap implements Serializable {
	public static MasiveLoadUserSoap toSoapModel(MasiveLoadUser model) {
		MasiveLoadUserSoap soapModel = new MasiveLoadUserSoap();

		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setSuccessFile(model.getSuccessFile());
		soapModel.setErrorFile(model.getErrorFile());
		soapModel.setStatusExecution(model.getStatusExecution());

		return soapModel;
	}

	public static MasiveLoadUserSoap[] toSoapModels(MasiveLoadUser[] models) {
		MasiveLoadUserSoap[] soapModels = new MasiveLoadUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MasiveLoadUserSoap[][] toSoapModels(MasiveLoadUser[][] models) {
		MasiveLoadUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MasiveLoadUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MasiveLoadUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MasiveLoadUserSoap[] toSoapModels(List<MasiveLoadUser> models) {
		List<MasiveLoadUserSoap> soapModels = new ArrayList<MasiveLoadUserSoap>(models.size());

		for (MasiveLoadUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MasiveLoadUserSoap[soapModels.size()]);
	}

	public MasiveLoadUserSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getSuccessFile() {
		return _successFile;
	}

	public void setSuccessFile(long successFile) {
		_successFile = successFile;
	}

	public long getErrorFile() {
		return _errorFile;
	}

	public void setErrorFile(long errorFile) {
		_errorFile = errorFile;
	}

	public int getStatusExecution() {
		return _statusExecution;
	}

	public void setStatusExecution(int statusExecution) {
		_statusExecution = statusExecution;
	}

	private long _id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private long _successFile;
	private long _errorFile;
	private int _statusExecution;
}