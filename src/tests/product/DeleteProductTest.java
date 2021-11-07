package tests.product;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactPage;
import pages.LoginPage;
import utilities.Log;
import utilities.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DeleteProductTest extends TestBase{

	TestUtils testUtils;
	ContactPage contactPage;
	LoginPage loginPage;

	DeleteProductTest(){
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
	public void deleteProduct() {
//		driver.get("https://persistentsystems-3c7-dev-ed.my.salesforce.com/?ec=302&startURL=%2Fvisualforce%2Fsession%3Furl%3Dhttps%253A%252F%252Fpersistentsystems-3c7-dev-ed.lightning.force.com%252Flightning%252Fo%252FProduct2%252Flist%253FfilterName%253DRecent");
//		driver.manage().window().setSize(new Dimension(658, 680));
//		driver.findElement(By.id("username")).click();
//		driver.findElement(By.id("username")).sendKeys("salesforceminipr@gmail.com");
//		driver.findElement(By.id("password")).click();
//		driver.findElement(By.id("password")).sendKeys("Hinjewadi99");
//		driver.findElement(By.id("Login")).click();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//click on product options
		driver.findElement(By.cssSelector("#brandBand_1 > div > div > div > div > div.slds-grid.listDisplays.safari-workaround-anchor > div > div.slds-col.slds-no-space.forceListViewManagerPrimaryDisplayManager > div.undefined.forceListViewManagerGrid > div.listViewContent.slds-table--header-fixed_container > div.uiScroller.scroller-wrapper.scroll-bidirectional.native > div > div > table > tbody > tr:nth-child(1) > td:nth-child(7) > span > div > a > span > span:nth-child(1)")).click();
	   //select delete
		driver.findElement(By.linkText("Delete")).click();
		//delete button sure
		driver.findElement(By.cssSelector(".uiButton--brand:nth-child(2) > .label")).click();
	}
}
