package com.gfi.chg.contact;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InitialConfigurationLoaderUtil {

	private static Log log = LogFactoryUtil.getLog(InitialConfigurationLoaderUtil.class);

	public static Map<String, String> loadAreas() {
		Map<String, String> map = new HashMap<String, String>();
		ClassLoader classLoader = InitialConfigurationLoaderUtil.class.getClassLoader();
		File file = new File(classLoader.getResource("areas.properties").getFile());
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;
			while ((text = reader.readLine()) != null) {
				String[] parts = text.split(" - ");
				map.put(parts[0], parts[1]);
			}
		} catch (FileNotFoundException e) {
			log.error(e,e);
		} catch (IOException e) {
			log.error(e,e);
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				log.error(e,e);
			}
		}
		return map;
	}

}
