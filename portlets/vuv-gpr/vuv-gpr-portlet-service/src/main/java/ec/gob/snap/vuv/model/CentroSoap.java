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
public class CentroSoap implements Serializable {
    private long _id_centro;
    private long _id_GPR_centro;
    private long _content;
    private Date _timeStamp;
    private long _id_caso;

    public CentroSoap() {
    }

    public static CentroSoap toSoapModel(Centro model) {
        CentroSoap soapModel = new CentroSoap();

        soapModel.setId_centro(model.getId_centro());
        soapModel.setId_GPR_centro(model.getId_GPR_centro());
        soapModel.setContent(model.getContent());
        soapModel.setTimeStamp(model.getTimeStamp());
        soapModel.setId_caso(model.getId_caso());

        return soapModel;
    }

    public static CentroSoap[] toSoapModels(Centro[] models) {
        CentroSoap[] soapModels = new CentroSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CentroSoap[][] toSoapModels(Centro[][] models) {
        CentroSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CentroSoap[models.length][models[0].length];
        } else {
            soapModels = new CentroSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CentroSoap[] toSoapModels(List<Centro> models) {
        List<CentroSoap> soapModels = new ArrayList<CentroSoap>(models.size());

        for (Centro model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CentroSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id_centro;
    }

    public void setPrimaryKey(long pk) {
        setId_centro(pk);
    }

    public long getId_centro() {
        return _id_centro;
    }

    public void setId_centro(long id_centro) {
        _id_centro = id_centro;
    }

    public long getId_GPR_centro() {
        return _id_GPR_centro;
    }

    public void setId_GPR_centro(long id_GPR_centro) {
        _id_GPR_centro = id_GPR_centro;
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
