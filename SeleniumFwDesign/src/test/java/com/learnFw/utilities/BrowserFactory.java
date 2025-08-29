package com.learnFw.utilities;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	
	public static WebDriver startBrowser(WebDriver webDriver,String browserName, String appUrl) {
		
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			 webDriver = new ChromeDriver();
			webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}else if (browserName.equals("Firefox")) {
			
			//System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
			// webDriver = new FirefoxDriver();
			 
		}else if (browserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver.exe");
			 webDriver = new EdgeDriver();
			 webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		else {
			System.out.println("Invalid browser ");
		}
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		webDriver.get(appUrl);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return webDriver;
	}
	
	public static void quitBrowser(WebDriver webDriver) {
		webDriver.quit();
	}
	
}
