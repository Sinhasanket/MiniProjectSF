package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.Log;
import base.TestBase;
import pages.LoginPage;
import utilities.TestUtils;

/*
 * Author Pallavi
 */
public class DisplayproductdetailsTest extends TestBase{

	TestUtils testUtils;
	LoginPage loginPage;

	DisplayproductdetailsTest(){
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email") , prop.getProperty("password")); 	 
		driver.navigate().to("https://persistentsystems-3c7-dev-ed.lightning.force.com/lightning/o/Product2/list?filterName=00B5j000003dX0IEAU");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception{
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtils.takeScreenshotAtEndOfTest(result.getTestName());
		}
		driver.quit();
	}

	@Test
	public void Displayproductdetails() throws InterruptedException {
		Actions act = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span/a")));

		WebElement ele = driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span/a")); 
		act.doubleClick(ele).perform();
		Log.info("Product details displayed");
	}
}