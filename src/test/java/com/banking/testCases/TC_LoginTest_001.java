package com.banking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObejcts.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		
		lp.clickSubmit();
		
		
		if(driver.getTitle().equals(" Guru99 Bank Home Page ")) {
			Assert.assertTrue(true);}else {Assert.assertTrue(false);}
			
			
		}
	}
	
	
	

