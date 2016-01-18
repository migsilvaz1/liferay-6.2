package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ec.gob.snap.vuv.model.Centro;
import ec.gob.snap.vuv.service.CentroLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class CentroActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public CentroActionableDynamicQuery() throws SystemException {
        setBaseLocalService(CentroLocalServiceUtil.getService());
        setClass(Centro.class);

        setClassLoader(ec.gob.snap.vuv.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id_centro");
    }
}
