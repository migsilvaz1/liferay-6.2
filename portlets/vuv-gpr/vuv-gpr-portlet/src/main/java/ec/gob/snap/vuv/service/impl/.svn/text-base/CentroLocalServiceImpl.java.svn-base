package ec.gob.snap.vuv.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import ec.gob.snap.vuv.NoSuchCentroException;
import ec.gob.snap.vuv.model.Centro;
import ec.gob.snap.vuv.service.CentroLocalServiceUtil;
import ec.gob.snap.vuv.service.base.CentroLocalServiceBaseImpl;
import ec.gob.snap.vuv.service.persistence.CentroPersistence;
import ec.gob.snap.vuv.service.persistence.CentroPersistenceImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the centro local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ec.gob.snap.vuv.service.CentroLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ec.gob.snap.vuv.service.base.CentroLocalServiceBaseImpl
 * @see ec.gob.snap.vuv.service.CentroLocalServiceUtil
 */
public class CentroLocalServiceImpl extends CentroLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link ec.gob.snap.vuv.service.CentroLocalServiceUtil} to access the centro local service.
     */
    CentroPersistence centroPersistence = new CentroPersistenceImpl();


    public Centro addCentro(long gprId, long content, Date timeStamp) {
	long centroId;

	try {
	    centroId = CounterLocalServiceUtil.increment(Centro.class.getName());
	    Centro centro = centroPersistence.create(centroId);
	    centro.setId_GPR_centro(gprId);
	    centro.setContent(content);
	    centro.setTimeStamp(timeStamp);

	    super.addCentro(centro);

	    return centro;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;

    }

    public Centro addCentro(long gprId, long content, Date timeStamp, long idCaso) {
	long centroId;

	try {
	    centroId = CounterLocalServiceUtil.increment(Centro.class.getName());
	    Centro centro = centroPersistence.create(centroId);
	    centro.setId_GPR_centro(gprId);
	    centro.setContent(content);
	    centro.setTimeStamp(timeStamp);
	    centro.setId_caso(idCaso);

	    super.addCentro(centro);

	    return centro;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;

    }

    public Centro deleteCentro(long centroId) {

	try {
	    return centroPersistence.remove(centroId);
	} catch (NoSuchCentroException e) {
	    e.printStackTrace();
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public Centro updateCentro(Centro centro) {

	try {
	    return centroPersistence.updateImpl(centro);
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public List<Centro> getAllCentros() {
	try {
	    return CentroLocalServiceUtil.getCentros(0, CentroLocalServiceUtil.getCentrosCount());

	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public Centro getCentroBygprId(long gprId){
	List<Centro> act = getAllCentros();
	for(Centro a : act){
	    if(a.getId_GPR_centro() == gprId){
		return a;
	    }
	}
	return null;
    }
}
