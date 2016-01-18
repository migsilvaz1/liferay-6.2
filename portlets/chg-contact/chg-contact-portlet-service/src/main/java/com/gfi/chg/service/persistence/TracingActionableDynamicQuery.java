package com.gfi.chg.service.persistence;

import com.gfi.chg.model.Tracing;
import com.gfi.chg.service.TracingLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class TracingActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public TracingActionableDynamicQuery() throws SystemException {
        setBaseLocalService(TracingLocalServiceUtil.getService());
        setClass(Tracing.class);

        setClassLoader(com.gfi.chg.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("tracingId");
    }
}
