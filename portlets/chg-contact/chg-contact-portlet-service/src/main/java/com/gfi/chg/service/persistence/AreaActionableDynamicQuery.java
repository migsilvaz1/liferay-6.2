package com.gfi.chg.service.persistence;

import com.gfi.chg.model.Area;
import com.gfi.chg.service.AreaLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AreaActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AreaActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AreaLocalServiceUtil.getService());
        setClass(Area.class);

        setClassLoader(com.gfi.chg.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("areaId");
    }
}
