package com.learnFw.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	@FindBy(xpath = "//button[text()='Bank Manager Login']") WebElement mngrButton;
	@FindBy(xpath = "//button[normalize-space()='Add Customer']") WebElement addCustomer;
	@FindBy(xpath = "//input[@placeholder='First Name']") WebElement fName;
	@FindBy(xpath = "//input[@placeholder='Last Name']") WebElement lName;
	@FindBy(xpath = "//input[@placeholder='Post Code']") WebElement pstCode;
	@FindBy(xpath = "//button[text()='Add Customer']") WebElement addCustbtn;
	
	public LoginPage(WebDriver webDriver) {
		// TODO Auto-generated constructor stub
		this.driver=webDriver;
	}
	
	public void createCustomer(String firstName, String lastName, double postCode) {
		mngrButton.click();
		addCustomer.click();
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		String pst = ""+postCode;
		pstCode.sendKeys(pst);
		addCustbtn.click();
		Alert alert = driver.switchTo().alert();
        //Store the alert text in a variable and verify it
        String text = alert.getText();
      alert.accept();
	}
	
}
