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
public class CasoSoap implements Serializable {
    private long _id_caso;
    private long _id_GPR_caso;
    private long _content;
    private Date _timeStamp;
    private long _id_servicio;

    public CasoSoap() {
    }

    public static CasoSoap toSoapModel(Caso model) {
        CasoSoap soapModel = new CasoSoap();

        soapModel.setId_caso(model.getId_caso());
        soapModel.setId_GPR_caso(model.getId_GPR_caso());
        soapModel.setContent(model.getContent());
        soapModel.setTimeStamp(model.getTimeStamp());
        soapModel.setId_servicio(model.getId_servicio());

        return soapModel;
    }

    public static CasoSoap[] toSoapModels(Caso[] models) {
        CasoSoap[] soapModels = new CasoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CasoSoap[][] toSoapModels(Caso[][] models) {
        CasoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CasoSoap[models.length][models[0].length];
        } else {
            soapModels = new CasoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CasoSoap[] toSoapModels(List<Caso> models) {
        List<CasoSoap> soapModels = new ArrayList<CasoSoap>(models.size());

        for (Caso model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CasoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id_caso;
    }

    public void setPrimaryKey(long pk) {
        setId_caso(pk);
    }

    public long getId_caso() {
        return _id_caso;
    }

    public void setId_caso(long id_caso) {
        _id_caso = id_caso;
    }

    public long getId_GPR_caso() {
        return _id_GPR_caso;
    }

    public void setId_GPR_caso(long id_GPR_caso) {
        _id_GPR_caso = id_GPR_caso;
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
