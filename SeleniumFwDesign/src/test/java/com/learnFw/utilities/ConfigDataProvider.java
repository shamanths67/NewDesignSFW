package com.learnFw.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties properties;
	public ConfigDataProvider() {
		File file = new File("Config/Config.properties");
		
		try {
			FileInputStream inputStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(inputStream);
		} catch (Exception e) {
			System.out.println("Unable to get the properties"+e.getMessage());
		}
	}
	public String getaDataFromConfig(String keyToSearch) {
		return properties.getProperty(keyToSearch);
	}
	public String getBrowser() {
		return properties.getProperty("Browser");
	}
	public String getURL() {
		return properties.getProperty("qaUrl");
	}
}
