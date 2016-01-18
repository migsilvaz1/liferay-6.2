package ec.gob.snap.vuv.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import ec.gob.snap.vuv.service.Act_InstitucionalLocalServiceUtil;
import ec.gob.snap.vuv.service.CasoLocalServiceUtil;
import ec.gob.snap.vuv.service.CentroLocalServiceUtil;
import ec.gob.snap.vuv.service.ClpSerializer;
import ec.gob.snap.vuv.service.IndicadorLocalServiceUtil;
import ec.gob.snap.vuv.service.InstitucionLocalServiceUtil;
import ec.gob.snap.vuv.service.PasoLocalServiceUtil;
import ec.gob.snap.vuv.service.RequisitoLocalServiceUtil;
import ec.gob.snap.vuv.service.ServicioLocalServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            Act_InstitucionalLocalServiceUtil.clearService();

            CasoLocalServiceUtil.clearService();

            CentroLocalServiceUtil.clearService();

            IndicadorLocalServiceUtil.clearService();

            InstitucionLocalServiceUtil.clearService();

            PasoLocalServiceUtil.clearService();

            RequisitoLocalServiceUtil.clearService();

            ServicioLocalServiceUtil.clearService();
        }
    }
}
