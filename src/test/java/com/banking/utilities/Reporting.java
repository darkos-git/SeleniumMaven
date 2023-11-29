package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.banking.testCases.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

    public ExtentTest logger;
    Properties pro;
    private ExtentReports reports;

    public Reporting() {
        File src = new File("./Configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is" + e.getMessage());
        }
    }

    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repName = "Test-Report-" + timeStamp + ".html";
        System.out.println(repName);
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Log/" + repName);
        spark.config().setDocumentTitle("Inet Banking Test Project");
        spark.config().setReportName("Functional Test Report");
        spark.config().setTheme(Theme.DARK);
        spark.config().setEncoding("utf-8");

        this.reports = new ExtentReports();  // Use class-level variable
        this.reports.attachReporter(spark);

        this.reports.setSystemInfo("Host name", "localhost");
        this.reports.setSystemInfo("Environment", "QA");
        this.reports.setSystemInfo("user", "Darko");

        ExtentTest logger = this.reports.createTest("My Test");
        logger.log(Status.INFO, "Starting browser");
    }

    public void onTestSuccess(ITestResult tr) {
        logger = reports.createTest(tr.getName());
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
        reports.flush();
    }

    public void onTestFailure(ITestResult tr) {
        logger = reports.createTest(tr.getName());
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

        String screenshotPath = System.getProperty("user.dir") + "//Screenshot//" + tr.getName() + ".png";
        WebDriver drv = BaseClass.driver;
        File file = ((TakesScreenshot) drv).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(screenshotPath));
        } catch (Exception e) {
            System.err.println(e);
        }
        reports.flush();
    }

    public void onTestSkipped(ITestResult tr) {
        logger = reports.createTest(tr.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
        reports.flush();
    }

}
