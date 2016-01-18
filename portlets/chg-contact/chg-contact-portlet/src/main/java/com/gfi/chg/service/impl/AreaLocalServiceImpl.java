package com.gfi.chg.service.impl;

import com.gfi.chg.model.Area;
import com.gfi.chg.service.base.AreaLocalServiceBaseImpl;
import com.gfi.chg.service.persistence.AreaUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the area local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.gfi.chg.service.AreaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.gfi.chg.service.base.AreaLocalServiceBaseImpl
 * @see com.gfi.chg.service.AreaLocalServiceUtil
 */
public class AreaLocalServiceImpl extends AreaLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.gfi.chg.service.AreaLocalServiceUtil} to access the area local service.
     */
	public List<Area> findByAreaId(long areaId) throws SystemException{
		return AreaUtil.findByAreaId(areaId);
	}
	public Area findByName(String name) throws SystemException{
		List<Area> areas = AreaUtil.findByName(name);
		if(areas.size()>1){
			throw new SystemException("Not unique AREA name given: " + name);
		}
		return areas.get(0);
	}
	public List<Area> findByUserId(long userId) throws SystemException{
		return AreaUtil.findByUserId(userId);
	}
}
