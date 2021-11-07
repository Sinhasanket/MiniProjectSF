package tests.lead;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utilities.TestUtils;

public class VerifyAccountTest extends TestBase{
	
	TestUtils testUtils;
	LoginPage loginPage;
	
	VerifyAccountTest(){
		super();
	}
	
//	WebDriver driver;
	static String url,accountName="Jade Global",firstName="Ankita",lastName="Patil";
//	LoginObject loginobj;
	WebElement newlead,sal;
	WebElement contact,account;
	@BeforeMethod
	public void setUp() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
//		ChromeOptions o = new ChromeOptions();
//    	o.addArguments("--disable-notifications");
//		driver=new ChromeDriver(o);
//		url="https://persistentsystems-3c7-dev-ed.lightning.force.com/lightning/o/Lead/list?filterName=Recent";
//	    loginobj=new LoginObject(driver);
//		driver.get(url);
//		driver.manage().window().maximize();
//		Thread.sleep(200);
//		loginobj.setUsername("salesforceminipr@gmail.com");
//	    loginobj.setPassword("Hinjewadi99");
//	    loginobj.clickLogin();
//	    Thread.sleep(400);
	    
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email") , prop.getProperty("password"));
	}
	@Test
	public void verifyAccountDetails() {
		WebElement account=driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[8]"));
	    account.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement allaccounts;
        for(int i=1;;i++) {
        	try {
        		allaccounts=driver.findElement(By.xpath("//*[@id=\"brandBand_1\"]/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+i+"]/th/span/a"));
//        	    System.out.println(allaccounts.getText());
        		if(accountName.equals(allaccounts.getText())) {
        	    	Assert.assertEquals(allaccounts.getText(),accountName);
        		    break;
        		}
        	}catch(Exception e) {
        		break;
        	}
        }
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception{
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtils.takeScreenshotAtEndOfTest(result.getTestName());
		}
		driver.quit();
	}
}
