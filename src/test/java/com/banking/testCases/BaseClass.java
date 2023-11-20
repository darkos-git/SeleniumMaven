package com.banking.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public String baseUrl = "https://demo.guru99.com/V1";
	public String username = "mngr539543";
	public String password = "dYpajun";
	public static WebDriver driver;
	
	@BeforeClass
	

	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver//chromedriver.exe");
//	System.setProperty("webdriver.chrome.driver","C:\\Users\\Jelena\\Desktop\\QA-TESTIRANJE\\Banking_V1\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
