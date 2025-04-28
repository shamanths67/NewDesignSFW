package com.learnFw.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	

	public static String captureScreenShot(WebDriver webDriver) {
	
	File src =	((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
	String sspath = System.getProperty("user.dir")+"/ScreenShots/Way2to"+getDateTimeFormat()+".png";
	try {
		FileHandler.copy(src, new File(sspath));
		System.out.println("CAPTURED SUCCESS");
	} catch (IOException e) {
		System.out.println("Unable to capture the screenshot"+e.getMessage());
	}
		return sspath;
	}	
	public static String getDateTimeFormat() {
		
		DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
	return	dateFormat.format(currentDate);
	}
}
