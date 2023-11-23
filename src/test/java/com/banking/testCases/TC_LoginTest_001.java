package com.banking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObejcts.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() {

		driver.get(baseUrl);
		logger.info("Driver navigate to Main Page");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("userName entered");
		lp.setPassword(password);
logger.info("password entered");
		lp.clickSubmit();

		if (driver.getTitle().equals("GTPL Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
			Assert.assertTrue(false);
		}

	}
}
