package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ec.gob.snap.vuv.model.Caso;
import ec.gob.snap.vuv.service.CasoLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class CasoActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public CasoActionableDynamicQuery() throws SystemException {
        setBaseLocalService(CasoLocalServiceUtil.getService());
        setClass(Caso.class);

        setClassLoader(ec.gob.snap.vuv.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id_caso");
    }
}
