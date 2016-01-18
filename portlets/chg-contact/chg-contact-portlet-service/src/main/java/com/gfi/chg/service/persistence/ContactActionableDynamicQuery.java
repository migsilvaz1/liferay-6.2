package com.gfi.chg.service.persistence;

import com.gfi.chg.model.Contact;
import com.gfi.chg.service.ContactLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ContactActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ContactActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ContactLocalServiceUtil.getService());
        setClass(Contact.class);

        setClassLoader(com.gfi.chg.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("contactId");
    }
}
