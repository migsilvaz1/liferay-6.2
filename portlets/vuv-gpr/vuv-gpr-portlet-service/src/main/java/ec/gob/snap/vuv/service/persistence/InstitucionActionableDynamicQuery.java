package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ec.gob.snap.vuv.model.Institucion;
import ec.gob.snap.vuv.service.InstitucionLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class InstitucionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public InstitucionActionableDynamicQuery() throws SystemException {
        setBaseLocalService(InstitucionLocalServiceUtil.getService());
        setClass(Institucion.class);

        setClassLoader(ec.gob.snap.vuv.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id_institucion");
    }
}
