package com.near.notificaciones.util;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public class UserRetriever {

	public static void putUsersJSON(ResourceRequest resourceRequest, ResourceResponse resourceResponse, List<User> userList) throws IOException, PortletException {
		JSONArray usersJSONArray = JSONFactoryUtil.createJSONArray();
		JSONObject userJSON=null;
		try {
			for(User user:userList){
				userJSON=JSONFactoryUtil.createJSONObject();
				userJSON.put("userId",user.getUserId());
				userJSON.put("nombreAutocompletar", user.getFullName());
				usersJSONArray.put(userJSON);
			}
		} catch (Exception e) {
			System.out.println("Excepción en UserRetriever línea 29 - " + e.toString() + ": " + e.getMessage());
		}
		PrintWriter printWriter=resourceResponse.getWriter();
		printWriter.println(usersJSONArray.toString());
	}
}
