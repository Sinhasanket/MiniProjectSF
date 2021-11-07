package tests.product;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utilities.TestUtils;
import utilities.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.ITestResult;
/*
 * Author Shweta
 */
public class VerifyTitleTest extends TestBase{
	
	TestUtils testUtils;
	LoginPage loginPage;

	VerifyTitleTest(){
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
	public  void verifyTitle() throws InterruptedException {
		//verify page title
		driver.get("https://persistentsystems-3c7-dev-ed.lightning.force.com/lightning/o/Product2/list?filterName=Recent");
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Lightning Experience";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		Log.info("Title verified");
	}
}
