package com.banking.testCases;

import com.banking.utilities.XMUtility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCasesLoginDDT002 extends BaseClass {
    @Test(dataProvider = "LoginData")
    public void loginDDT() {

    }

    @DataProvider(name = "LoginData")
    Object[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "SeleniumMaven\\src\\test\\java\\com\\banking\\testData";
        int rowNum = XMUtility.getRowCount(path, "Sheet1");
        int cellCount = XMUtility.getCellCount(path, "Sheet1", 1);

        String loginData[][] = new String[rowNum][cellCount];
        for (int i = 1; i <= rowNum; i++) {

            for (int j = 0; j < cellCount; j++) {
                loginData[i - 1][j] = XMUtility.getCellData(path, "Sheet1", i, j);
            }

        }
        return loginData;


    }


}
