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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.near.reynasa.masiveLoadUser.model.MasiveLoadUser;

import java.util.List;

/**
 * The persistence utility for the masive load user service. This utility wraps {@link MasiveLoadUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author near
 * @see MasiveLoadUserPersistence
 * @see MasiveLoadUserPersistenceImpl
 * @generated
 */
public class MasiveLoadUserUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(MasiveLoadUser masiveLoadUser) {
		getPersistence().clearCache(masiveLoadUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasiveLoadUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasiveLoadUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasiveLoadUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MasiveLoadUser update(MasiveLoadUser masiveLoadUser)
		throws SystemException {
		return getPersistence().update(masiveLoadUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MasiveLoadUser update(MasiveLoadUser masiveLoadUser,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(masiveLoadUser, serviceContext);
	}

	/**
	* Returns all the masive load users where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching masive load users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> findBygroupIdAndCompanyId(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBygroupIdAndCompanyId(groupId, companyId);
	}

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
	public static java.util.List<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> findBygroupIdAndCompanyId(
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBygroupIdAndCompanyId(groupId, companyId, start, end);
	}

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
	public static java.util.List<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> findBygroupIdAndCompanyId(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBygroupIdAndCompanyId(groupId, companyId, start, end,
			orderByComparator);
	}

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
	public static com.near.reynasa.masiveLoadUser.model.MasiveLoadUser findBygroupIdAndCompanyId_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException {
		return getPersistence()
				   .findBygroupIdAndCompanyId_First(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first masive load user in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching masive load user, or <code>null</code> if a matching masive load user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.near.reynasa.masiveLoadUser.model.MasiveLoadUser fetchBygroupIdAndCompanyId_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBygroupIdAndCompanyId_First(groupId, companyId,
			orderByComparator);
	}

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
	public static com.near.reynasa.masiveLoadUser.model.MasiveLoadUser findBygroupIdAndCompanyId_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException {
		return getPersistence()
				   .findBygroupIdAndCompanyId_Last(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last masive load user in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching masive load user, or <code>null</code> if a matching masive load user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.near.reynasa.masiveLoadUser.model.MasiveLoadUser fetchBygroupIdAndCompanyId_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBygroupIdAndCompanyId_Last(groupId, companyId,
			orderByComparator);
	}

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
	public static com.near.reynasa.masiveLoadUser.model.MasiveLoadUser[] findBygroupIdAndCompanyId_PrevAndNext(
		long id, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException {
		return getPersistence()
				   .findBygroupIdAndCompanyId_PrevAndNext(id, groupId,
			companyId, orderByComparator);
	}

	/**
	* Removes all the masive load users where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBygroupIdAndCompanyId(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBygroupIdAndCompanyId(groupId, companyId);
	}

	/**
	* Returns the number of masive load users where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching masive load users
	* @throws SystemException if a system exception occurred
	*/
	public static int countBygroupIdAndCompanyId(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBygroupIdAndCompanyId(groupId, companyId);
	}

	/**
	* Caches the masive load user in the entity cache if it is enabled.
	*
	* @param masiveLoadUser the masive load user
	*/
	public static void cacheResult(
		com.near.reynasa.masiveLoadUser.model.MasiveLoadUser masiveLoadUser) {
		getPersistence().cacheResult(masiveLoadUser);
	}

	/**
	* Caches the masive load users in the entity cache if it is enabled.
	*
	* @param masiveLoadUsers the masive load users
	*/
	public static void cacheResult(
		java.util.List<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> masiveLoadUsers) {
		getPersistence().cacheResult(masiveLoadUsers);
	}

	/**
	* Creates a new masive load user with the primary key. Does not add the masive load user to the database.
	*
	* @param id the primary key for the new masive load user
	* @return the new masive load user
	*/
	public static com.near.reynasa.masiveLoadUser.model.MasiveLoadUser create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the masive load user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the masive load user
	* @return the masive load user that was removed
	* @throws com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException if a masive load user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.near.reynasa.masiveLoadUser.model.MasiveLoadUser remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException {
		return getPersistence().remove(id);
	}

	public static com.near.reynasa.masiveLoadUser.model.MasiveLoadUser updateImpl(
		com.near.reynasa.masiveLoadUser.model.MasiveLoadUser masiveLoadUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(masiveLoadUser);
	}

	/**
	* Returns the masive load user with the primary key or throws a {@link com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException} if it could not be found.
	*
	* @param id the primary key of the masive load user
	* @return the masive load user
	* @throws com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException if a masive load user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.near.reynasa.masiveLoadUser.model.MasiveLoadUser findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.near.reynasa.masiveLoadUser.NoSuchMasiveLoadUserException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the masive load user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the masive load user
	* @return the masive load user, or <code>null</code> if a masive load user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.near.reynasa.masiveLoadUser.model.MasiveLoadUser fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the masive load users.
	*
	* @return the masive load users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.near.reynasa.masiveLoadUser.model.MasiveLoadUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the masive load users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of masive load users.
	*
	* @return the number of masive load users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MasiveLoadUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MasiveLoadUserPersistence)PortletBeanLocatorUtil.locate(com.near.reynasa.masiveLoadUser.service.ClpSerializer.getServletContextName(),
					MasiveLoadUserPersistence.class.getName());

			ReferenceRegistry.registerReference(MasiveLoadUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MasiveLoadUserPersistence persistence) {
	}

	private static MasiveLoadUserPersistence _persistence;
}