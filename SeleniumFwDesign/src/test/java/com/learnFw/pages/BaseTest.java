package com.learnFw.pages;

import java.io.File;



import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnFw.utilities.BrowserFactory;
import com.learnFw.utilities.ConfigDataProvider;
import com.learnFw.utilities.ExcelDataProvider;
import com.learnFw.utilities.Helper;



public class BaseTest {

	public WebDriver webDriver;
	public ExcelDataProvider dataProvider;
	public ConfigDataProvider configDataProvider;
	public ExtentReports extentReports;
	public ExtentTest extentTest;
	
	@BeforeSuite
	public void setUpSuite() {
		dataProvider = new ExcelDataProvider();
		configDataProvider = new ConfigDataProvider();
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(new File("Reports/W2A_"+Helper.getDateTimeFormat()+".html"));
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}
	@Parameters({"browser","testUrl"})
	@BeforeClass
	public void setup(String browser, String url) {
		webDriver = BrowserFactory.startBrowser(webDriver, browser, url);
	}
	@AfterClass
	public void tear() {
		BrowserFactory.quitBrowser(webDriver);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult iTestResult) {
		if(iTestResult.getStatus()==ITestResult.FAILURE) {
			extentTest.fail("test Fail", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(webDriver)).build());
		} else if(iTestResult.getStatus()==ITestResult.SUCCESS) {
			extentTest.pass("test Pass", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(webDriver)).build());
		}
		
		extentReports.flush();
	}
}
