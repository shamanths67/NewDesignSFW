package com.learnAutomation.NewFrameworkProject;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

public class NewClass {

	@Test
	public void login() throws InterruptedException {
		WebDriver  driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	//	driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	/*	driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Add Customer']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("FirstTester");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("QA");
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("123654");
		driver.findElement(By.xpath("//button[text()='Add Customer']")).click();
		driver.quit(); */
		 
		 //windows handling
		 driver.findElement(By.xpath("//button[@id='openwindow']")).click();
	/*	Set<String> child =  driver.getWindowHandles();

	driver.switchTo().window((String) child.toArray()[1]);
	System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Access all our Courses']")).click();
		driver.close();
		driver.switchTo().window((String) child.toArray()[0]);
		System.out.println(driver.getTitle());
		//tabs switching
		driver.findElement(By.xpath("//a[@id='opentab']")).click();
		Thread.sleep(5000);
		System.out.println(child);
		driver.switchTo().window((String) child.toArray()[1 ]);
		System.out.println(child);
		System.out.println(driver.getTitle());
			driver.findElement(By.xpath("//a[text()='Access all our Courses']")).click();
			System.out.println(driver.getTitle());
			
			String element = driver.findElement(By.xpath("//h1[contains(text(),'Corporate Trainings from Professionals')]")).getText();
			System.out.println(element);
			org.testng.Assert.assertEquals(element, "Corporate Trainings from Professionals')]");
			driver.switchTo().window((String) child.toArray()[0]);
			
			*/
		 
		 Set<String> handles =  driver.getWindowHandles();
		 Iterator<String> it = handles.iterator();
		String   parentWin = it.next();
		String  childwin= it.next();
		  System.out.println(parentWin);
		  driver.switchTo().window(childwin);
		  System.out.println(driver.getTitle());
		  System.out.println(childwin);
			driver.findElement(By.xpath("//a[text()='Access all our Courses']")).click();
			driver.close();
			
			driver.switchTo().window(parentWin);
			System.out.println(parentWin);
			driver.findElement(By.xpath("//a[@id='opentab']")).click();
		//	childwin= null;
			System.out.println(driver.getTitle());
			Set<String> handles1 =  driver.getWindowHandles();
			Iterator<String> it1 = handles1.iterator();
		String	parentWin1 = it.next();
			String child1 = it1.next();
			//tabs switching
			
			driver.switchTo().window(child1);
			System.out.println(child1);
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("//a[text()='Access all our Courses']")).click();
			System.out.println(driver.getTitle());
		/*	String element = driver.findElement(By.xpath("//h1[contains(text(),'Corporate Trainings from Professionals')]")).getText();
			System.out.println(element);
			org.testng.Assert.assertEquals(element, "Corporate Trainings from Professionals')]"); */
	}
	public static void main(String[] args) {
		
	}
}
