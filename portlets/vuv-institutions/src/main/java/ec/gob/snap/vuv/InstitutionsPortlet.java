
package ec.gob.snap.vuv;

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
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.util.comparator.ArticleTitleComparator;
import com.liferay.util.bridges.mvc.MVCPortlet;

import ec.gob.snap.vuv.model.Institucion;
import ec.gob.snap.vuv.service.InstitucionLocalServiceUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * <p>Class for serving ajax resources to view.</p> <b>Project:</b><p>vuv</p>
 * 
 * @version 1.0, 27/5/2015.
 */
public class InstitutionsPortlet extends MVCPortlet {

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest,
	 *      javax.portlet.ResourceResponse)
	 */
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		try {
			String keyword = resourceRequest.getParameter("keyword");
			String locale = resourceRequest.getLocale().toString();
			ThemeDisplay themeDisplay =
				(ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			List<Institucion> instituciones = InstitucionLocalServiceUtil.getAllInstituciones();
			Map<Long, JournalArticle> institucionesMap = new HashMap<Long, JournalArticle>();
			for (Institucion institucion : instituciones) {
				JournalArticle ja = JournalArticleLocalServiceUtil.getLatestArticle(institucion.getContent());
				if (ja.isApproved() == true
						&& ja.isExpired() == false
						&& ja.isDenied() == false
						&& ja.isInactive() == false
						&& JournalArticleLocalServiceUtil.isLatestVersion(
								themeDisplay.getScopeGroupId(),
								ja.getArticleId(), ja.getVersion())
						&& !institucionesMap.keySet().contains(institucion.getId_institucion())) {
					institucionesMap.put(institucion.getId_institucion(), ja);
				}
			}
			JSONObject jsonObject = null;
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			List<String> included = new ArrayList<String>();
			for (Long institucionId : institucionesMap.keySet()) {
				JournalArticle ja = institucionesMap.get(institucionId);
				Document document =
					SAXReaderUtil.read(ja.getContentByLocale(locale));
				Element rootElement = document.getRootElement();
				XPath xPathSelectorname =
					SAXReaderUtil.createXPath("dynamic-element[@name='name']");
				String name =
					xPathSelectorname.selectSingleNode(rootElement).getStringValue();
				XPath xPathSelectordescription =
					SAXReaderUtil.createXPath("dynamic-element[@name='description']");
				String description =
					xPathSelectordescription.selectSingleNode(rootElement).getStringValue();

				if (description.toUpperCase().contains(keyword.toUpperCase()) &&
					ja.isApproved() && !included.contains(description)) {
					included.add(description);
					jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("institucionId", institucionId);
					jsonObject.put("name", name);
					jsonArray.put(jsonObject);
				}
			}
			PrintWriter out = resourceResponse.getWriter();
			out.print(jsonArray.toString());

		}
		catch (IllegalArgumentException e) {
			log.error(e + "Error refreshing data");
		}
		catch (SystemException e) {
			log.error(e + "Error refreshing data");
		}
		catch (DocumentException e) {
			log.error(e + "Error refreshing data");
		}
		catch (PortalException e) {
			log.error(e + "Error fetching articles");
		}
	}
	/**
	 * Attribute that represents the class log.
	 */
	private static Log log = LogFactoryUtil.getLog(InstitutionsPortlet.class);

}
