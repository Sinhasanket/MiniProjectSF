package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utilities.Log;
import utilities.TestUtils;

/*
 * Author Pallavi
 */
public class NewbuttoncustomerTest extends TestBase{

	TestUtils testUtils;
	LoginPage loginPage;

	NewbuttoncustomerTest(){
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email") , prop.getProperty("password")); 	 
		driver.navigate().to("https://persistentsystems-3c7-dev-ed.lightning.force.com/lightning/o/Seller/list?filterName=Recent");
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
	public void Newbuttoncustomer() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/ul/li/a/div")));

		driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/ul/li/a/div")).click();
	}
}
