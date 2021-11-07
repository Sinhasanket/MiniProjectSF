package tests.product;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utilities.Log;

import base.TestBase;
import pages.LoginPage;
import utilities.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.*;

/*
 * Author Shweta
 */
public class CheckLinkTest extends TestBase{
	
	TestUtils testUtils;
	LoginPage loginPage;

	CheckLinkTest(){
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
	public void checkLink() throws InterruptedException {
//		Thread.sleep(6000);
		try{
			WebElement linkExistence= driver.findElement(By.cssSelector(".forceActionLink > div"));

			if (linkExistence.isEnabled()){
			    Log.info("New Link Exists – Passed");
			}
		}
		catch(NoSuchElementException e){
			Log.error("New Link Not Exists – Failed");
		}
	}
}