package ec.gob.snap.vuv.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import ec.gob.snap.vuv.NoSuchIndicadorException;
import ec.gob.snap.vuv.model.Indicador;
import ec.gob.snap.vuv.service.IndicadorLocalServiceUtil;
import ec.gob.snap.vuv.service.base.IndicadorLocalServiceBaseImpl;
import ec.gob.snap.vuv.service.persistence.IndicadorPersistence;
import ec.gob.snap.vuv.service.persistence.IndicadorPersistenceImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the indicador local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ec.gob.snap.vuv.service.IndicadorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ec.gob.snap.vuv.service.base.IndicadorLocalServiceBaseImpl
 * @see ec.gob.snap.vuv.service.IndicadorLocalServiceUtil
 */
public class IndicadorLocalServiceImpl extends IndicadorLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link ec.gob.snap.vuv.service.IndicadorLocalServiceUtil} to access the indicador local service.
     */
    IndicadorPersistence indicadorPersistence = new IndicadorPersistenceImpl();

    public Indicador addIndicador(long gprId, long content, Date timeStamp) {
	long indicadorId;

	try {
	    indicadorId = CounterLocalServiceUtil.increment(Indicador.class.getName());
	    Indicador indicador = indicadorPersistence.create(indicadorId);
	    indicador.setId_GPR_indicador(gprId);
	    indicador.setContent(content);
	    indicador.setTimeStamp(timeStamp);

	    super.addIndicador(indicador);

	    return indicador;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;

    }

    public Indicador addIndicador(long gprId, long content, Date timeStamp, long idServicio) {
	long indicadorId;

	try {
	    indicadorId = CounterLocalServiceUtil.increment(Indicador.class.getName());
	    Indicador indicador = indicadorPersistence.create(indicadorId);
	    indicador.setId_GPR_indicador(gprId);
	    indicador.setContent(content);
	    indicador.setTimeStamp(timeStamp);
	    indicador.setId_servicio(idServicio);

	    super.addIndicador(indicador);

	    return indicador;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;

    }

    public Indicador deleteIndicador(long indicadorId) {

	try {
	    return indicadorPersistence.remove(indicadorId);
	} catch (NoSuchIndicadorException e) {
	    e.printStackTrace();
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;
    }

    public Indicador updateIndicador(Indicador indicador) {

	try {
	    return indicadorPersistence.updateImpl(indicador);
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public List<Indicador> getAllIndicadores() {
	try {
	    return IndicadorLocalServiceUtil.getIndicadors(0, IndicadorLocalServiceUtil.getIndicadorsCount());

	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;
    }
    public Indicador getIndicadorBygprId(long gprId){
	List<Indicador> act = getAllIndicadores();
	for(Indicador a : act){
	    if(a.getId_GPR_indicador() == gprId){
		return a;
	    }
	}
	return null;
    }

}
