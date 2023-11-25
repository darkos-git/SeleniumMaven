package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());

		}

	}

	public String getAplicationUrl() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUserName() {
		String userName = pro.getProperty("username");
		return userName;
	}
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromepath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getIePath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
	
	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getOperaPath() {
		String operapath = pro.getProperty("operapath");
		return operapath;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}