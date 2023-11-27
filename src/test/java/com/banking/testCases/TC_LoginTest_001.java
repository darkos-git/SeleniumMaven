package com.banking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObejcts.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() {

		
		logger.info("Driver navigate to Main Pag ");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("userName entered");
		lp.setPassword(password);
logger.info("password entered");
		lp.clickSubmit();

		if (driver.getTitle().equals("GTPL Bank Manager HomePageeee")) 
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Login test fail");
		}

	}
}
