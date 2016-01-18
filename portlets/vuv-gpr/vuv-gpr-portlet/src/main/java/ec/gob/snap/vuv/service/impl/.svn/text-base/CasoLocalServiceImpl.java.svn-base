package ec.gob.snap.vuv.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.journal.service.JournalArticleLocalService;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

import ec.gob.snap.vuv.NoSuchCasoException;
import ec.gob.snap.vuv.model.Caso;
import ec.gob.snap.vuv.model.Centro;
import ec.gob.snap.vuv.model.Paso;
import ec.gob.snap.vuv.service.CasoLocalServiceUtil;
import ec.gob.snap.vuv.service.CentroLocalServiceUtil;
import ec.gob.snap.vuv.service.PasoLocalServiceUtil;
import ec.gob.snap.vuv.service.base.CasoLocalServiceBaseImpl;
import ec.gob.snap.vuv.service.persistence.CasoPersistence;
import ec.gob.snap.vuv.service.persistence.CasoPersistenceImpl;
import ec.gob.snap.vuv.service.persistence.CentroPersistence;
import ec.gob.snap.vuv.service.persistence.CentroPersistenceImpl;
import ec.gob.snap.vuv.service.persistence.PasoPersistence;
import ec.gob.snap.vuv.service.persistence.PasoPersistenceImpl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The implementation of the caso local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ec.gob.snap.vuv.service.CasoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ec.gob.snap.vuv.service.base.CasoLocalServiceBaseImpl
 * @see ec.gob.snap.vuv.service.CasoLocalServiceUtil
 */
public class CasoLocalServiceImpl extends CasoLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link ec.gob.snap.vuv.service.CasoLocalServiceUtil} to access the caso local service.
     */
    CasoPersistence casoPersistence = new CasoPersistenceImpl();
    CentroPersistence centroPersistence = new CentroPersistenceImpl();
    PasoPersistence pasoPersistence = new PasoPersistenceImpl();

    public Caso addCaso(long gprId, long content, Date timeStamp){
	long casoId;
	try {
	    casoId = CounterLocalServiceUtil.increment(Caso.class.getName());

	    Caso caso = casoPersistence.create(casoId);
	    caso.setId_GPR_caso(gprId);
	    caso.setContent(content);
	    caso.setTimeStamp(timeStamp);

	    super.addCaso(caso);

	    return caso;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;
    }

    public Caso addCaso(long gprId, long content, Date timeStamp, long idServicio){
	long casoId;

	try {
	    casoId = CounterLocalServiceUtil.increment(Caso.class.getName());

	    Caso caso = casoPersistence.create(casoId);
	    caso.setId_GPR_caso(gprId);
	    caso.setContent(content);
	    caso.setTimeStamp(timeStamp);
	    caso.setId_servicio(idServicio);

	    super.addCaso(caso);

	    return caso;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;
    }

    public Caso deleteCaso(long casoId){

	try {
	    return casoPersistence.remove(casoId);
	} catch (NoSuchCasoException e) {
	    e.printStackTrace();
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public Caso updateCaso(Caso caso){

	try {
	    return casoPersistence.updateImpl(caso);
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public List<Caso> getAllCasos() {
	try {
	    return CasoLocalServiceUtil.getCasos(0, CasoLocalServiceUtil.getCasosCount());
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public long getIdCasoByContent(long content){
	long res = 0;
	List<Caso> casos = getAllCasos();
	for(Caso caso : casos){
	    if(caso.getContent()==content){
		return caso.getId_caso();
	    }
	}
	return res;
	
    }
    
    public List<Paso> getAllPasosByIdCaso(long casoId) {
	List<Paso> pasos;
	try {

	    pasos = PasoLocalServiceUtil.getPasos(0, PasoLocalServiceUtil.getPasosCount());
	    List<Paso> res = new LinkedList<Paso>();
	    for(Paso s : pasos){
		if(s.getId_caso() == casoId){
		    res.add(s);
		}
	    }
	    return res;
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;

    }

    public List<Centro> getAllCentrosByIdCaso(long casoId) {
	List<Centro> centros;
	List<Centro> res = new LinkedList<Centro>();
	try {
	    centros = CentroLocalServiceUtil.getCentros(0, CentroLocalServiceUtil.getCentrosCount());

	    for(Centro s : centros){
		res.add(s);
	    }
	    return res;
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public Caso getCasoBygprId(long gprId){
	List<Caso> act = getAllCasos();
	for(Caso a : act){
	    if(a.getId_GPR_caso() == gprId){
		return a;
	    }
	}
	return null;
    }
}
