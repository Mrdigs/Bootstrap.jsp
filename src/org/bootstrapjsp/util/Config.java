/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Config {

	private static ResourceBundle properties  = null;
	
	static {
		try {
			Config.properties = ResourceBundle.getBundle("bootstrapjsp", new Locale("local"));
		} catch (MissingResourceException e) {
			// Nothing to do
		}
	}
	
	public static boolean useButtonIcons() {
		return !"false".equals(getProperty("button.use_icons"));
	}

	public static boolean validateParents() {
		return !"false".equals(getProperty("general.validate_parents"));
	}

	public static String getProperty(String key) {
		if (Config.properties != null) {
			if (Config.properties.containsKey(key)) {
				return Config.properties.getString(key);
			}
		}
		return null;
	}

	public static Map<String, String> getProperties(String key) {
		Map<String, String> matches = new HashMap<String, String>();
		if (Config.properties != null) {
			for (String property : Config.properties.keySet()) {
				if (property.startsWith(key + ".")) {
					final String value = Config.properties.getString(property);
					matches.put(property.replace(key + ".", ""), value);
				}
			}
		}
		return matches;
	}

}
