package com.learnFw.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnFw.pages.BaseTest;
import com.learnFw.pages.LoginPage;
import com.learnFw.utilities.BrowserFactory;
import com.learnFw.utilities.Helper;

public class LoginTestCRM extends BaseTest{

	
	@Test
	public void Login() {
	extentTest=	extentReports.createTest("Test created");
	LoginPage loginPage =	PageFactory.initElements(webDriver, LoginPage.class);
	extentTest.info("Starting Test");
	loginPage.createCustomer(dataProvider.getStringData("CreateCust", 0, 0), dataProvider.getStringData("CreateCust", 0, 1), dataProvider.getNumetricData("CreateCust", 0, 2));
	extentTest.pass("success");
	}
}
