package tests;

import org.testng.annotations.Test;

import utilities.Log;
import base.TestBase;
import pages.ContactPage;
import pages.LoginPage;
import utilities.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
/*
 * Author Sanket
 */
public class ContactPageTest extends TestBase{

	TestUtils testUtils;
	ContactPage contactPage;
	LoginPage loginPage;

	ContactPageTest(){
		super();
	}

	@Test(priority=1)
	public void verifyTitle() throws Exception{
		ContactPage.verifyTitleShopperStop();
	}

	@Test
	public void searchContacts() throws Exception{
		ContactPage.searchContacts();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email") , prop.getProperty("password"));
		driver.navigate().to(TestUtils.SHOPPERSTOP_APP);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception{
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtils.takeScreenshotAtEndOfTest(result.getName());
			Log.error("Error in"+result.getName()+" Class");
		}
		driver.quit();
	}
}