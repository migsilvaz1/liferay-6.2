package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ec.gob.snap.vuv.model.Indicador;
import ec.gob.snap.vuv.service.IndicadorLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class IndicadorActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public IndicadorActionableDynamicQuery() throws SystemException {
        setBaseLocalService(IndicadorLocalServiceUtil.getService());
        setClass(Indicador.class);

        setClassLoader(ec.gob.snap.vuv.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id_indicador");
    }
}
