package tests.product;
import org.testng.ITestResult;
/*
 * Author Shweta
 */
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utilities.Log;
import utilities.TestUtils;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewProductTest extends TestBase{
	
	TestUtils testUtils;
	LoginPage loginPage;

	NewProductTest(){
		super();
	}

	@BeforeMethod
	public void setUp() {	
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email") , prop.getProperty("password"));
		driver.navigate().to("https://persistentsystems-3c7-dev-ed.my.salesforce.com/?ec=302&startURL=%2Fvisualforce%2Fsession%3Furl%3Dhttps%253A%252F%252Fpersistentsystems-3c7-dev-ed.lightning.force.com%252Flightning%252Fo%252FProduct2%252Flist%253FfilterName%253DRecent");
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
	public void newProduct() {
//		driver.findElement(By.id("username")).click();
//		driver.findElement(By.id("username")).sendKeys("salesforceminipr@gmail.com");
//		driver.findElement(By.id("password")).click();
//		driver.findElement(By.id("password")).sendKeys("Hinjewadi99");
//		driver.findElement(By.id("Login")).click();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//click on new link tab
		WebElement p=driver.findElement(By.partialLinkText("New"));
		p.click();
		//type product name
		WebElement l=driver.findElement(By.cssSelector("input[class=' input']"));
		l.sendKeys("Dell");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//click on save button
		WebElement q = driver.findElement(By.cssSelector("#content_927\\:0 > div > div > div.inlineFooter > div > div > div.button-container-inner.slds-float_right > button.slds-button.slds-button--neutral.uiButton--brand.uiButton.forceActionButton"));
		q.click();	
	}
}
