package com.banking.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public String baseUrl = "https://demo.guru99.com/V1";
	public String username = "mngr539543";
	public String password = "dYpajun";
	public static WebDriver driver;
	public String baseDriverLocation =System.getProperty("user.dir");
	public static Logger logger;
	
	@BeforeClass
	

	public void setup() {

		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		 logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
