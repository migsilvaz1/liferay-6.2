package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ec.gob.snap.vuv.model.Servicio;
import ec.gob.snap.vuv.service.ServicioLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ServicioActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ServicioActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ServicioLocalServiceUtil.getService());
        setClass(Servicio.class);

        setClassLoader(ec.gob.snap.vuv.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id_servicio");
    }
}
