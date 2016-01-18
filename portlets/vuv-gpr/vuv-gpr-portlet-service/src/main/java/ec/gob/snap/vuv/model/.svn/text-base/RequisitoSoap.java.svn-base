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
public class RequisitoSoap implements Serializable {
    private long _id_requisito;
    private long _id_GPR_requisito;
    private long _content;
    private Date _timeStamp;
    private long _id_paso;

    public RequisitoSoap() {
    }

    public static RequisitoSoap toSoapModel(Requisito model) {
        RequisitoSoap soapModel = new RequisitoSoap();

        soapModel.setId_requisito(model.getId_requisito());
        soapModel.setId_GPR_requisito(model.getId_GPR_requisito());
        soapModel.setContent(model.getContent());
        soapModel.setTimeStamp(model.getTimeStamp());
        soapModel.setId_paso(model.getId_paso());

        return soapModel;
    }

    public static RequisitoSoap[] toSoapModels(Requisito[] models) {
        RequisitoSoap[] soapModels = new RequisitoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static RequisitoSoap[][] toSoapModels(Requisito[][] models) {
        RequisitoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new RequisitoSoap[models.length][models[0].length];
        } else {
            soapModels = new RequisitoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static RequisitoSoap[] toSoapModels(List<Requisito> models) {
        List<RequisitoSoap> soapModels = new ArrayList<RequisitoSoap>(models.size());

        for (Requisito model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new RequisitoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id_requisito;
    }

    public void setPrimaryKey(long pk) {
        setId_requisito(pk);
    }

    public long getId_requisito() {
        return _id_requisito;
    }

    public void setId_requisito(long id_requisito) {
        _id_requisito = id_requisito;
    }

    public long getId_GPR_requisito() {
        return _id_GPR_requisito;
    }

    public void setId_GPR_requisito(long id_GPR_requisito) {
        _id_GPR_requisito = id_GPR_requisito;
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

    public long getId_paso() {
        return _id_paso;
    }

    public void setId_paso(long id_paso) {
        _id_paso = id_paso;
    }
}
