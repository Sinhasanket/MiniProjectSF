package tests;

import org.openqa.selenium.By;
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
public class DeletecontactTest extends TestBase{

	TestUtils testUtils;
	LoginPage loginPage;

	DeletecontactTest(){
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email") , prop.getProperty("password")); 	  
		driver.navigate().to("https://persistentsystems-3c7-dev-ed.lightning.force.com/lightning/o/Contact/list?filterName=00B5j000003dWwrEAE");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception{
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtils.takeScreenshotAtEndOfTest(result.getTestName());
		}
		driver.quit();
	}

	@Test
	public void deleteproduct() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[8]/span/div/a/span/span[1]")));

		driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[8]/span/div/a/span/span[1]")).click();

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Delete")));

		driver.findElement(By.linkText("Delete")).click();

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[2]/span")));

        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[2]/span")).click();
        Log.info("Product deleted");
	}
}