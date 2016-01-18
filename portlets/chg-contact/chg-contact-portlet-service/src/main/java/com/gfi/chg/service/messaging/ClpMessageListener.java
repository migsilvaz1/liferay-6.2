package com.gfi.chg.service.messaging;

import com.gfi.chg.service.AreaLocalServiceUtil;
import com.gfi.chg.service.ClpSerializer;
import com.gfi.chg.service.ContactLocalServiceUtil;
import com.gfi.chg.service.TracingLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


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
            AreaLocalServiceUtil.clearService();

            ContactLocalServiceUtil.clearService();

            TracingLocalServiceUtil.clearService();
        }
    }
}
