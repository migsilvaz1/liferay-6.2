package ec.gob.snap.vuv.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import ec.gob.snap.vuv.NoSuchServicioException;
import ec.gob.snap.vuv.model.Act_Institucional;
import ec.gob.snap.vuv.model.Caso;
import ec.gob.snap.vuv.model.Indicador;
import ec.gob.snap.vuv.model.Servicio;
import ec.gob.snap.vuv.service.Act_InstitucionalLocalServiceUtil;
import ec.gob.snap.vuv.service.CasoLocalServiceUtil;
import ec.gob.snap.vuv.service.IndicadorLocalServiceUtil;
import ec.gob.snap.vuv.service.ServicioLocalServiceUtil;
import ec.gob.snap.vuv.service.base.ServicioLocalServiceBaseImpl;
import ec.gob.snap.vuv.service.persistence.Act_InstitucionalPersistence;
import ec.gob.snap.vuv.service.persistence.Act_InstitucionalPersistenceImpl;
import ec.gob.snap.vuv.service.persistence.CasoPersistence;
import ec.gob.snap.vuv.service.persistence.CasoPersistenceImpl;
import ec.gob.snap.vuv.service.persistence.IndicadorPersistence;
import ec.gob.snap.vuv.service.persistence.IndicadorPersistenceImpl;
import ec.gob.snap.vuv.service.persistence.ServicioPersistence;
import ec.gob.snap.vuv.service.persistence.ServicioPersistenceImpl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The implementation of the servicio local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ec.gob.snap.vuv.service.ServicioLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ec.gob.snap.vuv.service.base.ServicioLocalServiceBaseImpl
 * @see ec.gob.snap.vuv.service.ServicioLocalServiceUtil
 */
public class ServicioLocalServiceImpl extends ServicioLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link ec.gob.snap.vuv.service.ServicioLocalServiceUtil} to access the servicio local service.
     */

    ServicioPersistence servicioPersistence = new ServicioPersistenceImpl();
    IndicadorPersistence indicadorPersistence = new IndicadorPersistenceImpl();
    Act_InstitucionalPersistence act_InstitucionalPersistence = new Act_InstitucionalPersistenceImpl();
    CasoPersistence casoPersistence = new CasoPersistenceImpl();


    public Servicio addServicio(long gprId, long content, Date timeStamp) {
	long servicioId;

	try {
	    servicioId = CounterLocalServiceUtil.increment(Servicio.class.getName());
	    Servicio servicio = servicioPersistence.create(servicioId);
	    servicio.setId_GPR_servicio(gprId);
	    servicio.setContent(content);
	    servicio.setTimeStamp(timeStamp);

	    super.addServicio(servicio);

	    return servicio;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;

    }

    public Servicio addServicio(long gprId, long content, Date timeStamp, long idInstitucion) {
	long servicioId;

	try {
	    servicioId = CounterLocalServiceUtil.increment(Servicio.class.getName());
	    Servicio servicio = servicioPersistence.create(servicioId);
	    servicio.setId_GPR_servicio(gprId);
	    servicio.setContent(content);
	    servicio.setTimeStamp(timeStamp);
	    servicio.setId_institucion(idInstitucion);

	    super.addServicio(servicio);

	    return servicio;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;

    }

    public Servicio deleteServicio(long servicioId) {

	try {
	    return servicioPersistence.remove(servicioId);
	} catch (NoSuchServicioException e) {
	    e.printStackTrace();
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public Servicio updateServicio(Servicio servicio) {

	try {
	    return servicioPersistence.updateImpl(servicio);
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public List<Servicio> getAllServicios() {
	try {
	    return ServicioLocalServiceUtil.getServicios(0, ServicioLocalServiceUtil.getServiciosCount());

	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public List<Indicador> getAllIndicadoresByIdServicio(long servicioId) {
	List<Indicador> indicadores;
	try {
	    indicadores = IndicadorLocalServiceUtil.getIndicadors(0, IndicadorLocalServiceUtil.getIndicadorsCount());

	    List<Indicador> res = new LinkedList<Indicador>();
	    for(Indicador i : indicadores){
		if(i.getId_servicio() == servicioId){
		    res.add(i);
		}
	    }
	    return res;
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }


    public List<Act_Institucional> getAllActInstByIdServicio(long servicioId) {
	List<Act_Institucional> actInst;
	try {
	    actInst = Act_InstitucionalLocalServiceUtil.getAct_Institucionals(0, Act_InstitucionalLocalServiceUtil.getAct_InstitucionalsCount());

	    List<Act_Institucional> res = new LinkedList<Act_Institucional>();
	    for(Act_Institucional a : actInst){
		if(a.getId_servicio() == servicioId){
		    res.add(a);
		}
	    }
	    return res;
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public List<Caso> getAllCasosByIdServicio(long servicioId) {
	List<Caso> casos;
	try {
	    casos = CasoLocalServiceUtil.getCasos(0, CasoLocalServiceUtil.getCasosCount());

	    List<Caso> res = new LinkedList<Caso>();
	    for(Caso c : casos){
		if(c.getId_servicio() == servicioId){
		    res.add(c);
		}
	    }
	    return res;
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    public long getIdServicioByContent(long content){
	long res = 0;
	List<Servicio> servicios = getAllServicios();
	for(Servicio servicio : servicios){
	    if(servicio.getContent()==content){
		return servicio.getId_servicio();
	    }
	}
	return res;
	
    }

    public Servicio getServicioBygprId(long gprId){
	List<Servicio> act = getAllServicios();
	for(Servicio a : act){
	    if(a.getId_GPR_servicio() == gprId){
		return a;
	    }
	}
	return null;
    }

}
