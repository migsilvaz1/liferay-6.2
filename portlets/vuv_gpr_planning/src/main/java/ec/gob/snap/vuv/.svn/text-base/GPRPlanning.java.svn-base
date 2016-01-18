package ec.gob.snap.vuv;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.BackgroundTaskLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalFolder;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class GPRPlanning.
 */
public class GPRPlanning extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		long groupId = LiferayPersistence.getStructure("").getGroupId();
		try {
			long insFolId = -1;
			long serFolId = -1;
			Integer numInstitutions = 0;
			Integer numServices = 0;
			for(JournalFolder folder: JournalFolderLocalServiceUtil.getCompanyFolders(companyId, 0, JournalFolderLocalServiceUtil.getCompanyFoldersCount(companyId))){
				if(folder.getName().equals("Instituciones")){
					insFolId = folder.getFolderId();
				}
				if(folder.getName().equals("Servicios")){
					serFolId = folder.getFolderId();
				}
			}
			if(insFolId != -1){
				numInstitutions = JournalArticleLocalServiceUtil.searchCount(groupId, insFolId, WorkflowConstants.STATUS_APPROVED);
			}
			if(serFolId != -1){
				numServices = JournalArticleLocalServiceUtil.searchCount(groupId, serFolId, WorkflowConstants.STATUS_APPROVED);
			}
			renderRequest.setAttribute("numInstitutions", numInstitutions);
			renderRequest.setAttribute("numServices", numServices);
		} catch (SystemException e) {
			log.error(e);
		}
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * 
	 * @param actionRequest Action Request.
	 * @param actionResponse Action Response.
	 * @throws IOException IOException.
	 * @throws PortletException PortletException.
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public void sincronize(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException, SystemException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		Map<String, Serializable> taskContextMap = new HashMap<String, Serializable>();
		String[] servletContext = {actionRequest.getPortletSession().getPortletContext().getPortletContextName()};
		BackgroundTaskLocalServiceUtil.addBackgroundTask(user.getUserId(), themeDisplay.getScopeGroupId(),
			StringPool.BLANK, servletContext, GPRExecute.class, taskContextMap, serviceContext);
	}
	
	/**
	 * Attribute that represents log . 
	 */
	    private static Log log = LogFactoryUtil.getLog(GPRPlanning.class);
	
}
