package ec.gob.snap.vuv.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import ec.gob.snap.vuv.NoSuchAct_InstitucionalException;
import ec.gob.snap.vuv.model.Act_Institucional;
import ec.gob.snap.vuv.service.Act_InstitucionalLocalServiceUtil;
import ec.gob.snap.vuv.service.base.Act_InstitucionalLocalServiceBaseImpl;
import ec.gob.snap.vuv.service.persistence.Act_InstitucionalPersistence;
import ec.gob.snap.vuv.service.persistence.Act_InstitucionalPersistenceImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the act_ institucional local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ec.gob.snap.vuv.service.Act_InstitucionalLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ec.gob.snap.vuv.service.base.Act_InstitucionalLocalServiceBaseImpl
 * @see ec.gob.snap.vuv.service.Act_InstitucionalLocalServiceUtil
 */
public class Act_InstitucionalLocalServiceImpl
extends Act_InstitucionalLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link ec.gob.snap.vuv.service.Act_InstitucionalLocalServiceUtil} to access the act_ institucional local service.
     */

    Act_InstitucionalPersistence act_InstitucionalPersistence = new Act_InstitucionalPersistenceImpl();

    public Act_Institucional addAct_Institucional(long gprId, long content, Date timeStamp){
	long act_InstitucionalId;

	try {
	    act_InstitucionalId = CounterLocalServiceUtil.increment(Act_Institucional.class.getName());
	    Act_Institucional act_Institucional = act_InstitucionalPersistence.create(act_InstitucionalId);
	    act_Institucional.setId_GPR_act_institucional(gprId);
	    act_Institucional.setContent(content);
	    act_Institucional.setTimeStamp(timeStamp);

	    super.addAct_Institucional(act_Institucional);

	    return act_Institucional;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;

    }

    public Act_Institucional addAct_Institucional(long gprId, long content, Date timeStamp, long idServicio){
	long act_InstitucionalId;

	try {
	    act_InstitucionalId = CounterLocalServiceUtil.increment(Act_Institucional.class.getName());
	    Act_Institucional act_Institucional = act_InstitucionalPersistence.create(act_InstitucionalId);
	    act_Institucional.setId_GPR_act_institucional(gprId);
	    act_Institucional.setContent(content);
	    act_Institucional.setTimeStamp(timeStamp);
	    act_Institucional.setId_servicio(idServicio);

	    super.addAct_Institucional(act_Institucional);

	    return act_Institucional;
	} catch (SystemException e) {
	    e.printStackTrace();
	}

	return null;

    }

    public Act_Institucional deleteAct_Institucional(long act_InstitucionalId) {

	try {
	    return act_InstitucionalPersistence.remove(act_InstitucionalId);
	} catch (NoSuchAct_InstitucionalException e) {
	    e.printStackTrace();
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public Act_Institucional updateAct_Institucional(Act_Institucional act_Institucional){

	try {
	    return act_InstitucionalPersistence.updateImpl(act_Institucional);
	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;

    }

    public List<Act_Institucional> getAllAct_Institucionales(){
	try {
	    return Act_InstitucionalLocalServiceUtil.getAct_Institucionals(0, Act_InstitucionalLocalServiceUtil.getAct_InstitucionalsCount());

	} catch (SystemException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public Act_Institucional getAct_InstitucionalBygprId(long gprId){
	List<Act_Institucional> act = getAllAct_Institucionales();
	for(Act_Institucional a : act){
	    if(a.getId_GPR_act_institucional() == gprId){
		return a;
	    }
	}
	return null;
    }
}
