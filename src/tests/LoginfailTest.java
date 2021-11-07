package tests;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utilities.TestUtils;
import utilities.Log;


/*
 * Author Pallavi
 */

public class LoginfailTest extends TestBase{

	TestUtils testUtils;
	LoginPage loginPage;

	LoginfailTest(){
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception{
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtils.takeScreenshotAtEndOfTest(result.getName());
			Log.error("Error in"+result.getName()+" Class");
		}
		driver.quit();
	}

	@Test
	public void loginfail() throws InterruptedException {
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("salesforceminipr@gmail.com");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("hinjewadi99");
		driver.findElement(By.id("Login")).click();
		Log.warn("Login failed");
		//JUST FOR DEMO PURPOSE
		Thread.sleep(5000);
	}
}
