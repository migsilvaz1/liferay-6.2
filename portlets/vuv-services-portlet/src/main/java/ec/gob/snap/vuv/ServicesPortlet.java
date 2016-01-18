
package ec.gob.snap.vuv;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * <b>File:</b><p>ec.gob.snap.vuv.ServicesPortlet.java.</p>
 * <b>Description:</b><p>Service MVC. Portlet implementation class
 * ServicesPortlet</p> <b>Project:</b><p>Platform of VUV.</p>
 * <b>Date:</b><p>27/5/2015.</p>
 * 
 * @version 1.0, 27/5/2015.
 */
public class ServicesPortlet extends MVCPortlet {

	/*******************************************************************
	 * ATTRIBUTES
	 ******************************************************************/
	/**
	 * Attribute that represents the log.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(ServicesPortlet.class);
	/**
	 * Constant that represents an empty string.
	 */
	private final String EMPTY = "";

	/*******************************************************************
	 * METHODS
	 ******************************************************************/
	/**
	 * Method for filtering the service list according to the parameters
	 * included in the resourceRequest of the AJAX call. {@inheritDoc}
	 * 
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest,
	 *      javax.portlet.ResourceResponse)
	 */
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		Boolean getAll = false;
		String htmlServicesList = EMPTY;
		ArrayList<Service> servLayoutFilter = new ArrayList<Service>();
		try {
			String keyword = resourceRequest.getParameter("keyword");
			String rangoInf = resourceRequest.getParameter("rangoInf");
			String rangoSup = resourceRequest.getParameter("rangoSup");
			String maleSelected = resourceRequest.getParameter("maleSelected");
			String femaleSelected =
				resourceRequest.getParameter("femaleSelected");

			if (keyword == null || keyword.equalsIgnoreCase(EMPTY)) {

				getAll = true;
				keyword = keyword.trim();
			}
			else {
				keyword = keyword.trim();
			}
			if (!getAll) {
				for (Service serviceItem : ServicesUtil.getServicesLayout()) {
					if (ServicesUtil.filterService(
						serviceItem, keyword, rangoInf, rangoSup, maleSelected,
						femaleSelected)) {
						servLayoutFilter.add(serviceItem);
					}
				}
			}
			else {
				// int inte = 0;
				// int exte = 0;
				for (Service serviceItem : ServicesUtil.getServicesLayout()) {
					if (ServicesUtil.filterService(
						serviceItem, keyword, rangoInf, rangoSup, maleSelected,
						femaleSelected)) {
						servLayoutFilter.add(serviceItem);
						// inte++;
					}
					// exte++;
				}
				// System.out.println(inte);
				// System.out.println(exte);
			}
			htmlServicesList =
				ServicesUtil.getAssertList2HTML(
					servLayoutFilter, resourceRequest.getContextPath());
			int numElems = servLayoutFilter.size();
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("html", htmlServicesList);
			jsonObject.put("numElems", numElems);
			PrintWriter out = resourceResponse.getWriter();
			out.print(jsonObject);

		}
		catch (IllegalArgumentException e) {
			LOG.error(e + "Error refreshing data");
		}
	}
}
