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
public class PasoSoap implements Serializable {
    private long _id_paso;
    private long _id_GPR_paso;
    private long _content;
    private Date _timeStamp;
    private long _id_caso;

    public PasoSoap() {
    }

    public static PasoSoap toSoapModel(Paso model) {
        PasoSoap soapModel = new PasoSoap();

        soapModel.setId_paso(model.getId_paso());
        soapModel.setId_GPR_paso(model.getId_GPR_paso());
        soapModel.setContent(model.getContent());
        soapModel.setTimeStamp(model.getTimeStamp());
        soapModel.setId_caso(model.getId_caso());

        return soapModel;
    }

    public static PasoSoap[] toSoapModels(Paso[] models) {
        PasoSoap[] soapModels = new PasoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PasoSoap[][] toSoapModels(Paso[][] models) {
        PasoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PasoSoap[models.length][models[0].length];
        } else {
            soapModels = new PasoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PasoSoap[] toSoapModels(List<Paso> models) {
        List<PasoSoap> soapModels = new ArrayList<PasoSoap>(models.size());

        for (Paso model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PasoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id_paso;
    }

    public void setPrimaryKey(long pk) {
        setId_paso(pk);
    }

    public long getId_paso() {
        return _id_paso;
    }

    public void setId_paso(long id_paso) {
        _id_paso = id_paso;
    }

    public long getId_GPR_paso() {
        return _id_GPR_paso;
    }

    public void setId_GPR_paso(long id_GPR_paso) {
        _id_GPR_paso = id_GPR_paso;
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

    public long getId_caso() {
        return _id_caso;
    }

    public void setId_caso(long id_caso) {
        _id_caso = id_caso;
    }
}
