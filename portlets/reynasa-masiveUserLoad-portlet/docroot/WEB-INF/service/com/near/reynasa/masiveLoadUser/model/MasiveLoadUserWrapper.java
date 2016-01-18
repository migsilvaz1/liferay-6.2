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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MasiveLoadUser}.
 * </p>
 *
 * @author near
 * @see MasiveLoadUser
 * @generated
 */
public class MasiveLoadUserWrapper implements MasiveLoadUser,
	ModelWrapper<MasiveLoadUser> {
	public MasiveLoadUserWrapper(MasiveLoadUser masiveLoadUser) {
		_masiveLoadUser = masiveLoadUser;
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

	/**
	* Returns the primary key of this masive load user.
	*
	* @return the primary key of this masive load user
	*/
	@Override
	public long getPrimaryKey() {
		return _masiveLoadUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this masive load user.
	*
	* @param primaryKey the primary key of this masive load user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_masiveLoadUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this masive load user.
	*
	* @return the ID of this masive load user
	*/
	@Override
	public long getId() {
		return _masiveLoadUser.getId();
	}

	/**
	* Sets the ID of this masive load user.
	*
	* @param id the ID of this masive load user
	*/
	@Override
	public void setId(long id) {
		_masiveLoadUser.setId(id);
	}

	/**
	* Returns the group ID of this masive load user.
	*
	* @return the group ID of this masive load user
	*/
	@Override
	public long getGroupId() {
		return _masiveLoadUser.getGroupId();
	}

	/**
	* Sets the group ID of this masive load user.
	*
	* @param groupId the group ID of this masive load user
	*/
	@Override
	public void setGroupId(long groupId) {
		_masiveLoadUser.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this masive load user.
	*
	* @return the company ID of this masive load user
	*/
	@Override
	public long getCompanyId() {
		return _masiveLoadUser.getCompanyId();
	}

	/**
	* Sets the company ID of this masive load user.
	*
	* @param companyId the company ID of this masive load user
	*/
	@Override
	public void setCompanyId(long companyId) {
		_masiveLoadUser.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this masive load user.
	*
	* @return the user ID of this masive load user
	*/
	@Override
	public long getUserId() {
		return _masiveLoadUser.getUserId();
	}

	/**
	* Sets the user ID of this masive load user.
	*
	* @param userId the user ID of this masive load user
	*/
	@Override
	public void setUserId(long userId) {
		_masiveLoadUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this masive load user.
	*
	* @return the user uuid of this masive load user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masiveLoadUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this masive load user.
	*
	* @param userUuid the user uuid of this masive load user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_masiveLoadUser.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this masive load user.
	*
	* @return the user name of this masive load user
	*/
	@Override
	public java.lang.String getUserName() {
		return _masiveLoadUser.getUserName();
	}

	/**
	* Sets the user name of this masive load user.
	*
	* @param userName the user name of this masive load user
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_masiveLoadUser.setUserName(userName);
	}

	/**
	* Returns the create date of this masive load user.
	*
	* @return the create date of this masive load user
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _masiveLoadUser.getCreateDate();
	}

	/**
	* Sets the create date of this masive load user.
	*
	* @param createDate the create date of this masive load user
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_masiveLoadUser.setCreateDate(createDate);
	}

	/**
	* Returns the success file of this masive load user.
	*
	* @return the success file of this masive load user
	*/
	@Override
	public long getSuccessFile() {
		return _masiveLoadUser.getSuccessFile();
	}

	/**
	* Sets the success file of this masive load user.
	*
	* @param successFile the success file of this masive load user
	*/
	@Override
	public void setSuccessFile(long successFile) {
		_masiveLoadUser.setSuccessFile(successFile);
	}

	/**
	* Returns the error file of this masive load user.
	*
	* @return the error file of this masive load user
	*/
	@Override
	public long getErrorFile() {
		return _masiveLoadUser.getErrorFile();
	}

	/**
	* Sets the error file of this masive load user.
	*
	* @param errorFile the error file of this masive load user
	*/
	@Override
	public void setErrorFile(long errorFile) {
		_masiveLoadUser.setErrorFile(errorFile);
	}

	/**
	* Returns the status execution of this masive load user.
	*
	* @return the status execution of this masive load user
	*/
	@Override
	public int getStatusExecution() {
		return _masiveLoadUser.getStatusExecution();
	}

	/**
	* Sets the status execution of this masive load user.
	*
	* @param statusExecution the status execution of this masive load user
	*/
	@Override
	public void setStatusExecution(int statusExecution) {
		_masiveLoadUser.setStatusExecution(statusExecution);
	}

	@Override
	public boolean isNew() {
		return _masiveLoadUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_masiveLoadUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _masiveLoadUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_masiveLoadUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _masiveLoadUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _masiveLoadUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_masiveLoadUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _masiveLoadUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_masiveLoadUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_masiveLoadUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_masiveLoadUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MasiveLoadUserWrapper((MasiveLoadUser)_masiveLoadUser.clone());
	}

	@Override
	public int compareTo(
		com.near.reynasa.masiveLoadUser.model.MasiveLoadUser masiveLoadUser) {
		return _masiveLoadUser.compareTo(masiveLoadUser);
	}

	@Override
	public int hashCode() {
		return _masiveLoadUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> toCacheModel() {
		return _masiveLoadUser.toCacheModel();
	}

	@Override
	public com.near.reynasa.masiveLoadUser.model.MasiveLoadUser toEscapedModel() {
		return new MasiveLoadUserWrapper(_masiveLoadUser.toEscapedModel());
	}

	@Override
	public com.near.reynasa.masiveLoadUser.model.MasiveLoadUser toUnescapedModel() {
		return new MasiveLoadUserWrapper(_masiveLoadUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _masiveLoadUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _masiveLoadUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_masiveLoadUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MasiveLoadUserWrapper)) {
			return false;
		}

		MasiveLoadUserWrapper masiveLoadUserWrapper = (MasiveLoadUserWrapper)obj;

		if (Validator.equals(_masiveLoadUser,
					masiveLoadUserWrapper._masiveLoadUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MasiveLoadUser getWrappedMasiveLoadUser() {
		return _masiveLoadUser;
	}

	@Override
	public MasiveLoadUser getWrappedModel() {
		return _masiveLoadUser;
	}

	@Override
	public void resetOriginalValues() {
		_masiveLoadUser.resetOriginalValues();
	}

	private MasiveLoadUser _masiveLoadUser;
}