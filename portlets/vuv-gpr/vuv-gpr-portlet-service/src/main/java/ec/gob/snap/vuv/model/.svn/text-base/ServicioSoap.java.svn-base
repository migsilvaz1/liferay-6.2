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
public class ServicioSoap implements Serializable {
    private long _id_GPR_servicio;
    private long _content;
    private Date _timeStamp;
    private long _id_servicio;
    private long _id_institucion;

    public ServicioSoap() {
    }

    public static ServicioSoap toSoapModel(Servicio model) {
        ServicioSoap soapModel = new ServicioSoap();

        soapModel.setId_GPR_servicio(model.getId_GPR_servicio());
        soapModel.setContent(model.getContent());
        soapModel.setTimeStamp(model.getTimeStamp());
        soapModel.setId_servicio(model.getId_servicio());
        soapModel.setId_institucion(model.getId_institucion());

        return soapModel;
    }

    public static ServicioSoap[] toSoapModels(Servicio[] models) {
        ServicioSoap[] soapModels = new ServicioSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ServicioSoap[][] toSoapModels(Servicio[][] models) {
        ServicioSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ServicioSoap[models.length][models[0].length];
        } else {
            soapModels = new ServicioSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ServicioSoap[] toSoapModels(List<Servicio> models) {
        List<ServicioSoap> soapModels = new ArrayList<ServicioSoap>(models.size());

        for (Servicio model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ServicioSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id_servicio;
    }

    public void setPrimaryKey(long pk) {
        setId_servicio(pk);
    }

    public long getId_GPR_servicio() {
        return _id_GPR_servicio;
    }

    public void setId_GPR_servicio(long id_GPR_servicio) {
        _id_GPR_servicio = id_GPR_servicio;
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

    public long getId_institucion() {
        return _id_institucion;
    }

    public void setId_institucion(long id_institucion) {
        _id_institucion = id_institucion;
    }
}
