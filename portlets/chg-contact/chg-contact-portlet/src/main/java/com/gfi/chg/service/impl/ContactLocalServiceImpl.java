package com.gfi.chg.service.impl;

import com.gfi.chg.model.Contact;
import com.gfi.chg.service.base.ContactLocalServiceBaseImpl;
import com.gfi.chg.service.persistence.ContactUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the contact local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.gfi.chg.service.ContactLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.gfi.chg.service.base.ContactLocalServiceBaseImpl
 * @see com.gfi.chg.service.ContactLocalServiceUtil
 */
public class ContactLocalServiceImpl extends ContactLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.gfi.chg.service.ContactLocalServiceUtil} to access the contact local service.
     */
	public List<Contact> findByContactId(long contactId) throws SystemException{
		return ContactUtil.findByContactId(contactId);
	}
	public List<Contact> findByCreateDate(Date createDate) throws SystemException{
		return ContactUtil.findByCreateDate(createDate);
	}
	public List<Contact> findByEmail(String email) throws SystemException{
		return ContactUtil.findByEmail(email);
	}
	public List<Contact> findBySubject(String subject) throws SystemException{
		return ContactUtil.findBySubject(subject);
	}
	public List<Contact> findByStatus(int status) throws SystemException{
		return ContactUtil.findByStatus(status);
	}
	public List<Contact> findByAreaId(long areaId) throws SystemException{
		return ContactUtil.findByAreaId(areaId);
	}
}
