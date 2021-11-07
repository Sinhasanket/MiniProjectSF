package tests;
/*
 * Author Pallavi
 */
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

public class GotoprojectTest extends TestBase{

	TestUtils testUtils;
	LoginPage loginPage;

	GotoprojectTest(){
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email") , prop.getProperty("password")); 	 
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
	public void gotoproject() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[1]/div/div/div[1]/button/div/div")));

		driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[1]/div/div/div[1]/button/div/div")).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='07p5j000000cEq2AAE']/div/lightning-formatted-rich-text/span/p")));

		driver.findElement(By.xpath("//a[@id='07p5j000000cEq2AAE']/div/lightning-formatted-rich-text/span/p")).click();
	}
}
