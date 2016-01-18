package com.near.reynasa.masiveLoadUser.portlet;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.near.reynasa.masiveLoadUser.portlet.model.CsvUserBean;

/**
 * @author 
 * 
 *
 */
public class UserCacheEngine {
	
	private static Log _log = LogFactoryUtil.getLog(UserCacheEngine.class);

	private UserCSVReader userReader = UserCSVReader.getInstance();

	private List<CsvUserBean> users = new ArrayList<CsvUserBean>();

	private static UserCacheEngine INSTANCE = new UserCacheEngine();

	private UserCacheEngine() {
		init();
	}

	private void init() {
	//	_log.info("Initialising users.");
	//	users = userReader.readUsers();
	}

	public static UserCacheEngine getInstance() {
		return INSTANCE;
	}

	public List<CsvUserBean> getUsers(String TheFile, String portletInstanceId, String csvSeparator, String birthdayCsvStatus, String birthdayCsvOptions) {
		if (_log.isDebugEnabled()){
			_log.debug("Initialising users.");
		}
		users = userReader.readUsers(TheFile, portletInstanceId, csvSeparator, birthdayCsvStatus, birthdayCsvOptions);
		return users;
	}

	public void setUsers(List<CsvUserBean> users) {
		this.users = users;
	}
	
}
