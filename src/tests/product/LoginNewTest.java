package tests.product;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.Log;
import pages.ContactPage;
import pages.LoginPage;
import utilities.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
/*
 * Author Shweta
 */

public class LoginNewTest extends TestBase{
	
	TestUtils testUtils;
	ContactPage homePage;
	LoginPage loginPage;

	LoginNewTest(){
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email") , prop.getProperty("password"));
		driver.navigate().to("https://persistentsystems-3c7-dev-ed.lightning.force.com/lightning/o/Product2/list?filterName=Recent");

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
	public void loginNew() throws InterruptedException {
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("salesforceminipr@gmail.com");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("Hinjewadi99");
		driver.findElement(By.id("Login")).click();
		Log.info("logged into application");
		Thread.sleep(6000);
	}
}