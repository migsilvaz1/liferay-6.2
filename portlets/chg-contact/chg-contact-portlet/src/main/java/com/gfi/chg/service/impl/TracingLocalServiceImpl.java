package com.gfi.chg.service.impl;

import com.gfi.chg.model.Tracing;
import com.gfi.chg.service.base.TracingLocalServiceBaseImpl;
import com.gfi.chg.service.persistence.TracingUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the tracing local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.gfi.chg.service.TracingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.gfi.chg.service.base.TracingLocalServiceBaseImpl
 * @see com.gfi.chg.service.TracingLocalServiceUtil
 */
public class TracingLocalServiceImpl extends TracingLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.gfi.chg.service.TracingLocalServiceUtil} to access the tracing local service.
     */
	public List<Tracing> findByAreaId(long areaId) throws SystemException{
		return TracingUtil.findByAreaId(areaId);
	}
	public List<Tracing> findByContactId(long contactId) throws SystemException{
		return TracingUtil.findByContactId(contactId);
	}
}
