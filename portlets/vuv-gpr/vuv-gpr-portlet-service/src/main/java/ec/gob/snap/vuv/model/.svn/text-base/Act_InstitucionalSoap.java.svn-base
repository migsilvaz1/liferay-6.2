package ec.gob.snap.vuv.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class Act_InstitucionalSoap implements Serializable {
    private long _id_act_institucional;
    private long _id_GPR_act_institucional;
    private long _content;
    private Date _timeStamp;
    private long _id_servicio;

    public Act_InstitucionalSoap() {
    }

    public static Act_InstitucionalSoap toSoapModel(Act_Institucional model) {
        Act_InstitucionalSoap soapModel = new Act_InstitucionalSoap();

        soapModel.setId_act_institucional(model.getId_act_institucional());
        soapModel.setId_GPR_act_institucional(model.getId_GPR_act_institucional());
        soapModel.setContent(model.getContent());
        soapModel.setTimeStamp(model.getTimeStamp());
        soapModel.setId_servicio(model.getId_servicio());

        return soapModel;
    }

    public static Act_InstitucionalSoap[] toSoapModels(
        Act_Institucional[] models) {
        Act_InstitucionalSoap[] soapModels = new Act_InstitucionalSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static Act_InstitucionalSoap[][] toSoapModels(
        Act_Institucional[][] models) {
        Act_InstitucionalSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new Act_InstitucionalSoap[models.length][models[0].length];
        } else {
            soapModels = new Act_InstitucionalSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static Act_InstitucionalSoap[] toSoapModels(
        List<Act_Institucional> models) {
        List<Act_InstitucionalSoap> soapModels = new ArrayList<Act_InstitucionalSoap>(models.size());

        for (Act_Institucional model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new Act_InstitucionalSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id_act_institucional;
    }

    public void setPrimaryKey(long pk) {
        setId_act_institucional(pk);
    }

    public long getId_act_institucional() {
        return _id_act_institucional;
    }

    public void setId_act_institucional(long id_act_institucional) {
        _id_act_institucional = id_act_institucional;
    }

    public long getId_GPR_act_institucional() {
        return _id_GPR_act_institucional;
    }

    public void setId_GPR_act_institucional(long id_GPR_act_institucional) {
        _id_GPR_act_institucional = id_GPR_act_institucional;
    }

    public long getContent() {
        return _content;
    }

    public void setContent(long content) {
        _content = content;
    }

    public Date getTimeStamp() {
        return _timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        _timeStamp = timeStamp;
    }

    public long getId_servicio() {
        return _id_servicio;
    }

    public void setId_servicio(long id_servicio) {
        _id_servicio = id_servicio;
    }
}
