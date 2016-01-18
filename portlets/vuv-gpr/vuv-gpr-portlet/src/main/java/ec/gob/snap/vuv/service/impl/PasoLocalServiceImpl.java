package ec.gob.snap.vuv.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import ec.gob.snap.vuv.NoSuchPasoException;
import ec.gob.snap.vuv.model.Paso;
import ec.gob.snap.vuv.model.Requisito;
import ec.gob.snap.vuv.service.PasoLocalServiceUtil;
import ec.gob.snap.vuv.service.RequisitoLocalServiceUtil;
import ec.gob.snap.vuv.service.base.PasoLocalServiceBaseImpl;
import ec.gob.snap.vuv.service.persistence.PasoPersistence;
import ec.gob.snap.vuv.service.persistence.PasoPersistenceImpl;
import ec.gob.snap.vuv.service.persistence.RequisitoPersistence;
import ec.gob.snap.vuv.service.persistence.RequisitoPersistenceImpl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The implementation of the paso local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ec.gob.snap.vuv.service.PasoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ec.gob.snap.vuv.service.base.PasoLocalServiceBaseImpl
 * @see ec.gob.snap.vuv.service.PasoLocalServiceUtil
 */
public class PasoLocalServiceImpl extends PasoLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link ec.gob.snap.vuv.service.PasoLocalServiceUtil} to access the paso local service.
     */

    PasoPersistence pasoPersistence = new PasoPersistenceImpl();
    RequisitoPersistence requisitoPersistence = new RequisitoPersistenceImpl();

    public Paso addPaso(long gprId, long content, Date timeStamp) {
	long pasoId;

	try {
	    pasoId = CounterLocalServiceUtil.increment(Paso.class.getName());
	    Paso paso = pasoPersistence.create(pasoId);
	    paso.setId_GPR_paso(gprId);
	    paso.setContent(content);
	    paso.setTimeStamp(timeStamp);
	    super.addPaso(paso);

	    return paso;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;

    }

    public Paso addPaso(long gprId, long content, Date timeStamp, long idCaso) {
	long pasoId;

	try {
	    pasoId = CounterLocalServiceUtil.increment(Paso.class.getName());
	    Paso paso = pasoPersistence.create(pasoId);
	    paso.setId_GPR_paso(gprId);
	    paso.setContent(content);
	    paso.setTimeStamp(timeStamp);
	    paso.setId_caso(idCaso);

	    super.addPaso(paso);

	    return paso;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;

    }

    public Paso deletePaso(long pasoId) {

	try {
	    return pasoPersistence.remove(pasoId);
	} catch (NoSuchPasoException e) {
	    e.printStackTrace();
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public Paso updatePaso(Paso paso) {

	try {
	    return pasoPersistence.updateImpl(paso);
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;

    }

    public List<Paso> getAllPasos() {
	try {
	    return PasoLocalServiceUtil.getPasos(0, PasoLocalServiceUtil.getPasosCount());

	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }


    public List<Requisito> getAllRequisitosByIdPaso(long pasoId) {
	List<Requisito> requisito;
	try {
	    requisito = RequisitoLocalServiceUtil.getRequisitos(0, RequisitoLocalServiceUtil.getRequisitosCount());

	    List<Requisito> res = new LinkedList<Requisito>();
	    for(Requisito s : requisito){
		if(s.getId_paso() == pasoId){
		    res.add(s);
		}
	    }
	    return res;
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public Paso getPasoBygprId(long gprId){
	List<Paso> act = getAllPasos();
	for(Paso a : act){
	    if(a.getId_GPR_paso() == gprId){
		return a;
	    }
	}
	return null;
    }
}
