package ec.gob.snap.vuv.FAQs;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

/**
 * <p>Class that implements the Portlet configuration.</p>
 * <b>Project:</b><p>VUV</p>
 * @version 1.0.
 */
public class PortletConfig implements ConfigurationAction {

    /**
     * {@inheritDoc}
     * @throws ReadOnlyException
     * @see com.liferay.portal.kernel.portlet.ConfigurationAction#processAction(javax.portlet.PortletConfig, javax.portlet.ActionRequest, javax.portlet.ActionResponse)
     */
    /**
     * Method that process action.
     * @param portletConfig.
     * @param actionRequest.
     * @param arg2 Parameter that represents ActionResponse.
     * @return void.
     * @throws ReadOnlyException, PortalException, SystemException, ValidatorException, IOException.
     */
    @Override
    public void processAction(javax.portlet.PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse arg2) throws ReadOnlyException, PortalException, SystemException, ValidatorException, IOException {
	String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

	if (!cmd.equals(Constants.UPDATE)) {
	    return;
	}

	String htmlCodeFromEditorPlacedHere = ParamUtil.getString(actionRequest, "htmlCodeFromEditorPlacedHere");
	String pageElements = ParamUtil.getString(actionRequest, "pageElements");
	String searchResults = ParamUtil.getString(actionRequest, "searchResults");
	String viewContentTable = ParamUtil.getString(actionRequest, "viewContentTable");
	String portletResource = ParamUtil.getString(actionRequest, "portletResource");
	PortletPreferences preferences;

	preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);

	preferences.setValue("htmlCodeFromEditorPlacedHere", htmlCodeFromEditorPlacedHere);
	preferences.setValue("pageElements", pageElements);
	preferences.setValue("searchResults", searchResults);
	preferences.setValue("viewContentTable", viewContentTable);
	preferences.store();

	SessionMessages.add(actionRequest, portletConfig.getPortletName() + ".doConfigure");

    }

    /**
     * {@inheritDoc}
     * @see com.liferay.portal.kernel.portlet.ConfigurationAction#render(javax.portlet.PortletConfig, javax.portlet.RenderRequest, javax.portlet.RenderResponse)
     */
    /**
     * Method render.
     * @param arg0 Parameter that represents PortletConfig.
     * @param arg1 Parameter that represents ActionRequest.
     * @param arg2 Parameter that represents ActionResponse.
     * @return void.
     * @throws ReadOnlyException, PortalException, SystemException, ValidatorException, IOException.
     */
    @Override
    public String render(javax.portlet.PortletConfig arg0, RenderRequest arg1, RenderResponse arg2) {
	return "/html/config.jsp";
    }

}
