package com.banking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObject.LoginPage;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {


    @Test
    public void loginTest() throws IOException {


        logger.info("Driver navigate to Main Page ");

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("userName entered");
        lp.setPassword(password);
        logger.info("password entered");
        lp.clickSubmit();

        if (driver.getTitle().equals("GTPL Bank Manager HomePage")) {
            Assert.assertTrue(true);
            logger.info("Login test passed");
        } else {
            captureScreenshot(driver,"loginTest");
            Assert.fail();
            logger.info("Login test fail");
        }

    }
}
