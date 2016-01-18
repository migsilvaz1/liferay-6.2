
package ec.gob.snap.vuv;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;
import com.liferay.portlet.journal.util.comparator.ArticleCreateDateComparator;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

/**
 * Portlet implementation class HighlightLinkPortlet.
 */
public class HighlightLinkPortlet extends LiferayPortlet {

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.liferay.portal.kernel.portlet.LiferayPortlet#init()
	 */
	public void init() {

		editTemplate = getInitParameter("edit-template");
		viewTemplate = getInitParameter("view-template");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see javax.portlet.GenericPortlet#doEdit(javax.portlet.RenderRequest,
	 *      javax.portlet.RenderResponse)
	 */
	public void doEdit(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		// Getting Portlet Preferences
		PortletPreferences portletPreferences = renderRequest.getPreferences();
		String intro =
			portletPreferences.getValue(
				HighlightLinkPortletUtil.PREF_INTRO, StringPool.BLANK);
		String stringvalFirstnumpag =
			portletPreferences.getValue(
				HighlightLinkPortletUtil.PREF_FIRST_NUM_PAG,
				HighlightLinkPortletUtil.DEF_NUMBER_PAG);
		Integer firstnumpag = Integer.valueOf(stringvalFirstnumpag);

		renderRequest.setAttribute("intro", intro);
		renderRequest.setAttribute("firstnumpag", firstnumpag);

		include(editTemplate, renderRequest, renderResponse);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest,
	 *      javax.portlet.RenderResponse)
	 */
	public void doView(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		// Getting Portlet Preferences
		PortletPreferences portletPreferences = renderRequest.getPreferences();
		String intro =
			portletPreferences.getValue(
				HighlightLinkPortletUtil.PREF_INTRO, StringPool.BLANK);
		String stringvalFirstnumpag =
			portletPreferences.getValue(
				HighlightLinkPortletUtil.PREF_FIRST_NUM_PAG,
				HighlightLinkPortletUtil.DEF_NUMBER_PAG);
		Integer firstnumpag = Integer.valueOf(stringvalFirstnumpag);

		// Getting content
		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		String locale = renderRequest.getLocale().toString();
		List<HighlightLink> items = getLinks(groupId, locale);
		Integer numres = items.size();
		renderRequest.setAttribute("items", items);
		renderRequest.setAttribute("intro", intro);
		renderRequest.setAttribute("firstnumpag", firstnumpag);
		renderRequest.setAttribute("numres", numres);
		include(viewTemplate, renderRequest, renderResponse);
	}

	/**
	 * To include the elements.
	 * 
	 * @param path
	 *            the path.
	 * @param renderRequest
	 *            the request.
	 * @param renderResponse
	 *            the response.
	 */
	protected void include(
		String path, RenderRequest renderRequest, RenderResponse renderResponse) {

		PortletRequestDispatcher portletRequestDispatcher =
			getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			log.error(path + " is not a valid include");
		}
		else {
			try {
				portletRequestDispatcher.include(renderRequest, renderResponse);
			}
			catch (PortletException e) {
				log.error("Cannot include");
			}
			catch (IOException e) {
				log.error("Cannot include");
			}
		}
	}

	/**
	 * Method to save the portlet preferences.
	 * 
	 * @param request
	 *            the request.
	 * @param response
	 *            the response.
	 */
	@ProcessAction(name = "savePreferences")
	public void savePreferences(ActionRequest request, ActionResponse response) {

		String intro =
			ParamUtil.get(
				request, HighlightLinkPortletUtil.PREF_INTRO, StringPool.BLANK);
		String firstnumpag =
			ParamUtil.get(
				request, HighlightLinkPortletUtil.PREF_FIRST_NUM_PAG,
				HighlightLinkPortletUtil.DEF_NUMBER_PAG);
		PortletPreferences portletPreferences = request.getPreferences();
		try {
			portletPreferences.setValue(
				HighlightLinkPortletUtil.PREF_INTRO, intro);
			portletPreferences.setValue(
				HighlightLinkPortletUtil.PREF_FIRST_NUM_PAG, firstnumpag);
			portletPreferences.store();
			response.setPortletMode(PortletMode.VIEW);
		}
		catch (ReadOnlyException e) {
			log.error("Error storing preferences.");
		}
		catch (ValidatorException e) {
			log.error("Error storing preferences.");
		}
		catch (IOException e) {
			log.error("Error storing preferences.");
		}
		catch (PortletModeException e) {
			log.error("Error setting portlet to view mode.");
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.liferay.portal.kernel.portlet.LiferayPortlet#serveResource(javax.portlet.ResourceRequest,
	 *      javax.portlet.ResourceResponse)
	 */
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		try {
			String keyword = resourceRequest.getParameter("keyword");
			ThemeDisplay themeDisplay =
				(ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = themeDisplay.getLayout().getGroupId();
			String locale = resourceRequest.getLocale().toString();
			List<HighlightLink> links = getLinks(groupId, locale);
			List<HighlightLink> linksToShow = new ArrayList<HighlightLink>();
			if (keyword.isEmpty()) {
				linksToShow = links;
			}
			else {
				for (HighlightLink link : links) {
					if (link.getLink().contains(keyword) ||
						link.getCategory().contains(keyword) ||
						link.getDetail().contains(keyword)) {
						linksToShow.add(link);
					}
				}
			}
			JSONObject jsonLink = null;
			JSONArray linksJsonArray = JSONFactoryUtil.createJSONArray();
			for (HighlightLink link : linksToShow) {
				jsonLink = JSONFactoryUtil.createJSONObject();
				jsonLink.put("link", link.getLink());
				jsonLink.put("category", link.getCategory());
				jsonLink.put("details", link.getDetail());
				linksJsonArray.put(jsonLink);
			}
			PrintWriter out = resourceResponse.getWriter();
			out.print(linksJsonArray.toString());

		}
		catch (IllegalArgumentException e) {
			log.error(e + "Error refreshing data");
		}
	}

	/**
	 * Method that obtains the list of links.
	 * 
	 * @param groupId
	 *            the group id.
	 * @param locale
	 *            the actual locale.
	 * @return the list of links.
	 */
	private List<HighlightLink> getLinks(long groupId, String locale) {

		List<JournalArticle> content = new ArrayList<JournalArticle>();
		ArticleCreateDateComparator acdc =
			new ArticleCreateDateComparator(false);
		try {
			content =
				JournalArticleServiceUtil.getArticlesByStructureId(
					groupId, 0, PropsUtil.get("highlightlink.structure"), 0, 0,
					JournalArticleServiceUtil.getArticlesCountByStructureId(
						groupId, PropsUtil.get("highlightlink.structure")),
					acdc);
		}
		catch (SystemException e) {
			log.error(e + "Error retrieving the jurnal articles");
		}

		// Filtering by the expiration date
		List<HighlightLink> items = new ArrayList<HighlightLink>();
		Date now = new Date();
		Timestamp currentTime = new Timestamp(now.getTime());
		for (JournalArticle element : content) {
			if (element.getExpirationDate() == null ||
				element.getExpirationDate().after(currentTime)) {
				Document document = null;
				try {
					document =
						SAXReaderUtil.read(element.getContentByLocale(locale));

				}
				catch (DocumentException e) {
					log.error(e + "Error retrieving the content");
				}
				if (document != null) {
					List<AssetCategory> categoriesList = null;
					try {
						categoriesList =
							AssetCategoryLocalServiceUtil.getCategories(
								JournalArticle.class.getName(),
								element.getResourcePrimKey());
					}
					catch (SystemException e) {
						log.error(e + "Error retrieving the category");
					}
					String category = "";
					if (Validator.isNotNull(categoriesList) &&
						!categoriesList.isEmpty()) {
						category = categoriesList.get(0).getName();
					}
					String detail =
						document.selectSingleNode(
							"/root/dynamic-element[@name='" +
								HighlightLinkPortletUtil.STRUCTURE_DETAIL +
								"']/dynamic-content").getText();
					String link =
						document.selectSingleNode(
							"/root/dynamic-element[@name='" +
								HighlightLinkPortletUtil.STRUCTURE_LINK +
								"']/dynamic-content").getText();
					Integer detSize =
						(int) (detail.length() * HighlightLinkPortletUtil.PREVIEW_SIZE);
					String preview = detail.substring(0, detSize) + "...";
					items.add(new HighlightLink(category, preview, detail, link));
				}
			}
		}
		return items;
	}

	/**
	 * Attribute that represents editTemplate.
	 */
	private String editTemplate;
	/**
	 * Attribute that represents viewTemplate.
	 */
	private String viewTemplate;

	/**
	 * Getter for editTemplate.
	 * 
	 * @return the editTemplate.
	 */
	public String getEditTemplate() {

		return editTemplate;
	}

	/**
	 * Setter for editTemplate.
	 * 
	 * @param editTemplateParam
	 *            the TemplateParam.
	 */
	public void setEditTemplate(String editTemplateParam) {

		editTemplate = editTemplateParam;
	}

	/**
	 * Getter for viewTemplate.
	 * 
	 * @return the viewTemplate.
	 */
	public String getViewTemplate() {

		return viewTemplate;
	}

	/**
	 * Setter for viewTemplate.
	 * 
	 * @param viewTemplateParam
	 *            the viewTemplate.
	 */
	public void setViewTemplate(String viewTemplateParam) {

		viewTemplate = viewTemplateParam;
	}

	/**
	 * Attribute that represents the log.
	 */
	private static Log log = LogFactoryUtil.getLog(HighlightLinkPortlet.class);

}
