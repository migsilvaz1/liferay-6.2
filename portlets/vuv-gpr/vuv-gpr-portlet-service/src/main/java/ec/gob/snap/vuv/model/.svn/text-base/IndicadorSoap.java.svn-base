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
public class IndicadorSoap implements Serializable {
    private long _id_indicador;
    private long _id_GPR_indicador;
    private long _content;
    private Date _timeStamp;
    private long _id_servicio;

    public IndicadorSoap() {
    }

    public static IndicadorSoap toSoapModel(Indicador model) {
        IndicadorSoap soapModel = new IndicadorSoap();

        soapModel.setId_indicador(model.getId_indicador());
        soapModel.setId_GPR_indicador(model.getId_GPR_indicador());
        soapModel.setContent(model.getContent());
        soapModel.setTimeStamp(model.getTimeStamp());
        soapModel.setId_servicio(model.getId_servicio());

        return soapModel;
    }

    public static IndicadorSoap[] toSoapModels(Indicador[] models) {
        IndicadorSoap[] soapModels = new IndicadorSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static IndicadorSoap[][] toSoapModels(Indicador[][] models) {
        IndicadorSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new IndicadorSoap[models.length][models[0].length];
        } else {
            soapModels = new IndicadorSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static IndicadorSoap[] toSoapModels(List<Indicador> models) {
        List<IndicadorSoap> soapModels = new ArrayList<IndicadorSoap>(models.size());

        for (Indicador model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new IndicadorSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id_indicador;
    }

    public void setPrimaryKey(long pk) {
        setId_indicador(pk);
    }

    public long getId_indicador() {
        return _id_indicador;
    }

    public void setId_indicador(long id_indicador) {
        _id_indicador = id_indicador;
    }

    public long getId_GPR_indicador() {
        return _id_GPR_indicador;
    }

    public void setId_GPR_indicador(long id_GPR_indicador) {
        _id_GPR_indicador = id_GPR_indicador;
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
