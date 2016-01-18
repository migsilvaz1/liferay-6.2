package ec.gob.snap.vuv.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import ec.gob.snap.vuv.NoSuchInstitucionException;
import ec.gob.snap.vuv.model.Institucion;
import ec.gob.snap.vuv.model.Servicio;
import ec.gob.snap.vuv.service.InstitucionLocalServiceUtil;
import ec.gob.snap.vuv.service.ServicioLocalServiceUtil;
import ec.gob.snap.vuv.service.base.InstitucionLocalServiceBaseImpl;
import ec.gob.snap.vuv.service.persistence.InstitucionPersistence;
import ec.gob.snap.vuv.service.persistence.InstitucionPersistenceImpl;
import ec.gob.snap.vuv.service.persistence.ServicioPersistence;
import ec.gob.snap.vuv.service.persistence.ServicioPersistenceImpl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The implementation of the institucion local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ec.gob.snap.vuv.service.InstitucionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ec.gob.snap.vuv.service.base.InstitucionLocalServiceBaseImpl
 * @see ec.gob.snap.vuv.service.InstitucionLocalServiceUtil
 */
public class InstitucionLocalServiceImpl extends InstitucionLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link ec.gob.snap.vuv.service.InstitucionLocalServiceUtil} to access the institucion local service.
     */
    InstitucionPersistence institucionPersistence = new InstitucionPersistenceImpl();
    ServicioPersistence servicioPersistence = new ServicioPersistenceImpl();

    public Institucion addInstitucion(long gprId, long content, Date timeStamp){
	long institucionId;

	try {
	    institucionId = CounterLocalServiceUtil.increment(Institucion.class.getName());
	    Institucion institucion = institucionPersistence.create(institucionId);
	    institucion.setId_GPR_institucion(gprId);
	    institucion.setContent(content);
	    institucion.setTimeStamp(timeStamp);

	    super.addInstitucion(institucion);

	    return institucion;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;

    }

    public Institucion deleteInstitucion(long institucionId){

	try {
	    return institucionPersistence.remove(institucionId);
	} catch (NoSuchInstitucionException e) {
	    e.printStackTrace();
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public Institucion updateInstitucion(Institucion institucion) {

	try {
	    return institucionPersistence.updateImpl(institucion);
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;

    }

    public List<Institucion> getAllInstituciones(){
	try {
	    return InstitucionLocalServiceUtil.getInstitucions(0, InstitucionLocalServiceUtil.getInstitucionsCount());

	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public List<Servicio> getAllServiciosByIdInstitucion(long institucionId){
	List<Servicio> servicios;
	try {
	    servicios = ServicioLocalServiceUtil.getServicios(0, ServicioLocalServiceUtil.getServiciosCount());

	    List<Servicio> res = new LinkedList<Servicio>();
	    for(Servicio s : servicios){
		if(s.getId_institucion() == institucionId){
		    res.add(s);
		}
	    }
	    return res;
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public Institucion getInstitucionBygprId(long gprId){
	List<Institucion> act = getAllInstituciones();
	for(Institucion a : act){
	    if(a.getId_GPR_institucion() == gprId){
		return a;
	    }
	}
	return null;
    }
}
