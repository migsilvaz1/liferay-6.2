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
public class InstitucionSoap implements Serializable {
    private long _id_institucion;
    private long _id_GPR_institucion;
    private long _content;
    private Date _timeStamp;

    public InstitucionSoap() {
    }

    public static InstitucionSoap toSoapModel(Institucion model) {
        InstitucionSoap soapModel = new InstitucionSoap();

        soapModel.setId_institucion(model.getId_institucion());
        soapModel.setId_GPR_institucion(model.getId_GPR_institucion());
        soapModel.setContent(model.getContent());
        soapModel.setTimeStamp(model.getTimeStamp());

        return soapModel;
    }

    public static InstitucionSoap[] toSoapModels(Institucion[] models) {
        InstitucionSoap[] soapModels = new InstitucionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static InstitucionSoap[][] toSoapModels(Institucion[][] models) {
        InstitucionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new InstitucionSoap[models.length][models[0].length];
        } else {
            soapModels = new InstitucionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static InstitucionSoap[] toSoapModels(List<Institucion> models) {
        List<InstitucionSoap> soapModels = new ArrayList<InstitucionSoap>(models.size());

        for (Institucion model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new InstitucionSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id_institucion;
    }

    public void setPrimaryKey(long pk) {
        setId_institucion(pk);
    }

    public long getId_institucion() {
        return _id_institucion;
    }

    public void setId_institucion(long id_institucion) {
        _id_institucion = id_institucion;
    }

    public long getId_GPR_institucion() {
        return _id_GPR_institucion;
    }

    public void setId_GPR_institucion(long id_GPR_institucion) {
        _id_GPR_institucion = id_GPR_institucion;
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
}
