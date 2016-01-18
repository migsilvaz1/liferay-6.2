package ec.gob.snap.vuv.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import ec.gob.snap.vuv.NoSuchRequisitoException;
import ec.gob.snap.vuv.model.Requisito;
import ec.gob.snap.vuv.service.RequisitoLocalServiceUtil;
import ec.gob.snap.vuv.service.base.RequisitoLocalServiceBaseImpl;
import ec.gob.snap.vuv.service.persistence.RequisitoPersistence;
import ec.gob.snap.vuv.service.persistence.RequisitoPersistenceImpl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The implementation of the requisito local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ec.gob.snap.vuv.service.RequisitoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ec.gob.snap.vuv.service.base.RequisitoLocalServiceBaseImpl
 * @see ec.gob.snap.vuv.service.RequisitoLocalServiceUtil
 */
public class RequisitoLocalServiceImpl extends RequisitoLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link ec.gob.snap.vuv.service.RequisitoLocalServiceUtil} to access the requisito local service.
     */

    RequisitoPersistence requisitoPersistence = new RequisitoPersistenceImpl();

    public Requisito addRequisito(long gprId, long content, Date timeStamp) {
	long requisitoId;

	try {
	    requisitoId = CounterLocalServiceUtil.increment(Requisito.class.getName());
	    Requisito requisito = requisitoPersistence.create(requisitoId);
	    requisito.setId_GPR_requisito(gprId);
	    requisito.setContent(content);
	    requisito.setTimeStamp(timeStamp);

	    super.addRequisito(requisito);

	    return requisito;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;

    }

    public Requisito addRequisito(long gprId, long content, Date timeStamp, long idPaso) {
	long requisitoId;

	try {
	    requisitoId = CounterLocalServiceUtil.increment(Requisito.class.getName());
	    Requisito requisito = requisitoPersistence.create(requisitoId);
	    requisito.setId_GPR_requisito(gprId);
	    requisito.setContent(content);
	    requisito.setTimeStamp(timeStamp);
	    requisito.setId_paso(idPaso);

	    super.addRequisito(requisito);

	    return requisito;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;

    }

    public Requisito deleteRequisito(long requisitoId) {

	try {
	    return requisitoPersistence.remove(requisitoId);
	} catch (NoSuchRequisitoException e) {
	    e.printStackTrace();
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public Requisito updateRequisito(Requisito requisito) {

	try {
	    return requisitoPersistence.updateImpl(requisito);
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public List<Requisito> getAllRequisitos() {
	try {
	    return RequisitoLocalServiceUtil.getRequisitos(0, RequisitoLocalServiceUtil.getRequisitosCount());

	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public List<Requisito> getAllRequisitosByIdPaso(long pasoId) {
	List<Requisito> requisitos;
	try {

	    requisitos = RequisitoLocalServiceUtil.getRequisitos(0, RequisitoLocalServiceUtil.getRequisitosCount());

	    List<Requisito> res = new LinkedList<Requisito>();
	    for(Requisito s : requisitos){
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

    public Requisito getRequisitoBygprId(long gprId){
	List<Requisito> act = getAllRequisitos();
	for(Requisito a : act){
	    if(a.getId_GPR_requisito() == gprId){
		return a;
	    }
	}
	return null;
    }
}
