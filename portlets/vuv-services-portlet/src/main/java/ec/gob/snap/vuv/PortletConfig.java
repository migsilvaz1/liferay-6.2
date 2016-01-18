/* 
* This file is part of the VUV Electronic Office of Government of Ecuador.
* Copyright 2015.
*/

/** 
 * <b>File:</b><p>ec.gob.snap.vuv.PortletConfig.java.</p>
 * <b>Description:</b><p> .</p>
 * <b>Project:</b><p>Platform of xxxxxxxxxx.</p>
 * <b>Date:</b><p>1/9/2015.</p>
 * @version 1.0, 1/9/2015.
 */
package ec.gob.snap.vuv;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


/**
 * <p>Class that implements the Portlet configuration.</p>
 * <b>Project:</b><p>VUV</p>
 * @version 1.0.
 */
public class PortletConfig implements ConfigurationAction{

	/**
	 * {@inheritDoc}
	 * @see com.liferay.portal.kernel.portlet.ConfigurationAction#processAction(javax.portlet.PortletConfig, javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	@Override
	public void processAction(javax.portlet.PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)throws Exception {
		String  numPerPage = ParamUtil.getString(actionRequest, "numPerPage");
		PortletPreferences preferences = actionRequest.getPreferences();
		preferences.setValue("numPerPage", numPerPage);
		preferences.store();
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + ".doConfigure");
	}

	/**
	 * {@inheritDoc}
	 * @see com.liferay.portal.kernel.portlet.ConfigurationAction#render(javax.portlet.PortletConfig, javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public String render(
		javax.portlet.PortletConfig portletConfigParam,
		RenderRequest renderRequestParam, RenderResponse renderResponseParam){
		PortletPreferences preferences = renderRequestParam.getPreferences();
		renderRequestParam.setAttribute("numPerPage", preferences.getValue("numPerPage", "1"));
		return "/html/services/config.jsp";
	}

}
