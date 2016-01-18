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

package com.near.reynasa.masiveLoadUser.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.near.reynasa.masiveLoadUser.model.MasiveLoadUser;

/**
 * The persistence interface for the masive load user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author near
 * @see MasiveLoadUserPersistenceImpl
 * @see MasiveLoadUserUtil
 * @generated
 */
public interface MasiveLoadUserPersistence extends BasePersistence<MasiveLoadUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasiveLoadUserUtil} to access the masive load user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the masive load users where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching masive load users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> findBygroupIdAndCompanyId(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the masive load users where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.near.reynasa.masiveLoadUser.model.impl.MasiveLoadUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of masive load users
	* @param end the upper bound of the range of masive load users (not inclusive)
	* @return the range of matching masive load users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> findBygroupIdAndCompanyId(
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the masive load users where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.near.reynasa.masiveLoadUser.model.impl.MasiveLoadUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of masive load users
	* @param end the upper bound of the range of masive load users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching masive load users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> findBygroupIdAndCompanyId(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first masive load user in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching masive load user
	* @throws com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException if a matching masive load user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.near.reynasa.masiveLoadUser.model.MasiveLoadUser findBygroupIdAndCompanyId_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException;

	/**
	* Returns the first masive load user in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching masive load user, or <code>null</code> if a matching masive load user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.near.reynasa.masiveLoadUser.model.MasiveLoadUser fetchBygroupIdAndCompanyId_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last masive load user in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching masive load user
	* @throws com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException if a matching masive load user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.near.reynasa.masiveLoadUser.model.MasiveLoadUser findBygroupIdAndCompanyId_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException;

	/**
	* Returns the last masive load user in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching masive load user, or <code>null</code> if a matching masive load user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.near.reynasa.masiveLoadUser.model.MasiveLoadUser fetchBygroupIdAndCompanyId_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the masive load users before and after the current masive load user in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param id the primary key of the current masive load user
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next masive load user
	* @throws com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException if a masive load user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.near.reynasa.masiveLoadUser.model.MasiveLoadUser[] findBygroupIdAndCompanyId_PrevAndNext(
		long id, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException;

	/**
	* Removes all the masive load users where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBygroupIdAndCompanyId(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of masive load users where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching masive load users
	* @throws SystemException if a system exception occurred
	*/
	public int countBygroupIdAndCompanyId(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the masive load user in the entity cache if it is enabled.
	*
	* @param masiveLoadUser the masive load user
	*/
	public void cacheResult(
		com.near.reynasa.masiveLoadUser.model.MasiveLoadUser masiveLoadUser);

	/**
	* Caches the masive load users in the entity cache if it is enabled.
	*
	* @param masiveLoadUsers the masive load users
	*/
	public void cacheResult(
		java.util.List<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> masiveLoadUsers);

	/**
	* Creates a new masive load user with the primary key. Does not add the masive load user to the database.
	*
	* @param id the primary key for the new masive load user
	* @return the new masive load user
	*/
	public com.near.reynasa.masiveLoadUser.model.MasiveLoadUser create(long id);

	/**
	* Removes the masive load user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the masive load user
	* @return the masive load user that was removed
	* @throws com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException if a masive load user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.near.reynasa.masiveLoadUser.model.MasiveLoadUser remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException;

	public com.near.reynasa.masiveLoadUser.model.MasiveLoadUser updateImpl(
		com.near.reynasa.masiveLoadUser.model.MasiveLoadUser masiveLoadUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the masive load user with the primary key or throws a {@link com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException} if it could not be found.
	*
	* @param id the primary key of the masive load user
	* @return the masive load user
	* @throws com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException if a masive load user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.near.reynasa.masiveLoadUser.model.MasiveLoadUser findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException;

	/**
	* Returns the masive load user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the masive load user
	* @return the masive load user, or <code>null</code> if a masive load user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.near.reynasa.masiveLoadUser.model.MasiveLoadUser fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the masive load users.
	*
	* @return the masive load users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the masive load users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.near.reynasa.masiveLoadUser.model.impl.MasiveLoadUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of masive load users
	* @param end the upper bound of the range of masive load users (not inclusive)
	* @return the range of masive load users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the masive load users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.near.reynasa.masiveLoadUser.model.impl.MasiveLoadUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of masive load users
	* @param end the upper bound of the range of masive load users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of masive load users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the masive load users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of masive load users.
	*
	* @return the number of masive load users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}