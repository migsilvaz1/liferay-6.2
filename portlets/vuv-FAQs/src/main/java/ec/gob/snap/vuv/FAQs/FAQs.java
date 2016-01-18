package ec.gob.snap.vuv.FAQs;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * <p>Portlet implementation class FAQs.</p>
 * <b>Project:</b><p>VUV</p>
 * @version 1.0.
 */
public class FAQs extends MVCPortlet {

    
    /**
     * Method serveResource.
     * @param resourceRequest.
     * @param resourceResponse.
     * @return void.
     * @throws IOException, PortletException.
     */
    /**
     * {@inheritDoc}
     * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
     */
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
	try {
	    String keyword = resourceRequest.getParameter("keyword");
	    String locale = resourceRequest.getLocale().toString();

	    ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
	    List<JournalArticle> structureArticlesInit = JournalArticleLocalServiceUtil.getStructureArticles(themeDisplay.getScopeGroupId(), PropsUtil.get("faq.structure"));
	    List<JournalArticle> structureArticles = new LinkedList<JournalArticle>();
	    for (JournalArticle ja: structureArticlesInit) {
		String content = JournalContentUtil.getContent(themeDisplay.getScopeGroupId(), ja.getArticleId(), PropsUtil.get("faq.template"), themeDisplay.getLocale().toString(), themeDisplay);
		boolean ifVble = content.toUpperCase().contains(keyword.toUpperCase());
		ifVble = ifVble && ja.isApproved() && !ja.isExpired() && !ja.isDenied() && !ja.isInactive() && JournalArticleLocalServiceUtil.isLatestVersion(themeDisplay.getScopeGroupId(), ja.getArticleId(), ja.getVersion());
		boolean elseVble = keyword.equals("") && ja.isApproved() && !ja.isExpired();
		elseVble = elseVble && !ja.isDenied() && !ja.isInactive() && JournalArticleLocalServiceUtil.isLatestVersion(themeDisplay.getScopeGroupId(), ja.getArticleId(), ja.getVersion());
		if (ifVble) {
		    structureArticles.add(ja);
		} else if (elseVble) {
		    structureArticles.add(ja);
		}
	    }
	    JSONObject jsonObject = null;
	    JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
	    for (JournalArticle ja: structureArticles) {
		Document document = null;
		document = SAXReaderUtil.read(ja.getContentByLocale(locale));
		Node node = document.selectSingleNode("/root/dynamic-element[@name='" + "faq" + "']/dynamic-content");
		List<AssetCategory> categoriesList = AssetCategoryLocalServiceUtil.getCategories(JournalArticle.class.getName(), ja.getResourcePrimKey());
		jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("object", JournalContentUtil.getContent(themeDisplay.getScopeGroupId(), ja.getArticleId(), PropsUtil.get("faq.template"), themeDisplay.getLocale().toString(), themeDisplay));
		jsonObject.put("articleId", ja.getArticleId());
		jsonObject.put("node", node.getText());
		jsonObject.put("category", categoriesList.size() > 0 ? categoriesList.get(0).getName() : "");
		jsonArray.put(jsonObject);
	    }
	    PrintWriter out = resourceResponse.getWriter();
	    out.print(jsonArray.toString());

	} catch (IllegalArgumentException e) {
	    log.error(e + "Error");
	} catch (SystemException e) {
	    log.error(e + "Error refreshing data");
	} catch (PortalException e) {
	    log.error(e + "Error refreshing data");
	} catch (DocumentException e) {
	    log.error(e + "Error refreshing data");
	}
    }

    /**
     * Attribute that represents log . 
     */
    private static Log log = LogFactoryUtil.getLog(FAQs.class);

}
