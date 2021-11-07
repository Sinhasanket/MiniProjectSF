package tests.lead;

import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utilities.TestUtils;

public class CreateLeadTest extends TestBase{
	
	TestUtils testUtils;
	LoginPage loginPage;
	
	CreateLeadTest(){
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
		url="https://persistentsystems-3c7-dev-ed.lightning.force.com/lightning/o/Lead/list?filterName=Recent";
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
		driver.navigate().to(url);
	}
	//This test method will add new lead to the system
	@Test
	public void addLead() throws InterruptedException, MalformedURLException {
 		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		newlead=driver.findElement(By.xpath("//*[@id='brandBand_1']/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a"));
		String salutation="Dr";
		newlead.click();
//		Thread.sleep(100);
		Actions action=new Actions(driver);
        System.out.println(driver.getTitle());
		
 		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
         sal=driver.findElement(By.xpath("//*[@id=\"input-144\"]"));
         sal.click();
 		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 		 int pos=1;
 		 if(salutation.equals("Mr."))
 			 pos=2;
 		 else if(salutation.equals("Ms."))
 			 pos=3;
 		 else if(salutation.equals("Mrs."))
 			 pos=4;
 		 else if(salutation.equals("Dr"))
 			 pos=5;
 		 else
 			 pos=6;
 		for(int i = 0; i <= pos; i++){
 		    action.sendKeys(Keys.DOWN).build().perform();
 		}//press down arrow key
 	    action.sendKeys(Keys.ENTER).build().perform();//press enter
//        System.out.println(driver.getTitle());
        WebElement fname=driver.findElement(By.xpath("//*[@id=\"input-147\"]"));
        fname.sendKeys(firstName);
        WebElement lname=driver.findElement(By.xpath("//*[@id=\"input-148\"]"));
        lname.sendKeys(lastName);
        WebElement companyname=driver.findElement(By.xpath("//*[@id=\"input-154\"]"));
        companyname.sendKeys(accountName);
        
 		WebElement save=driver.findElement(By.xpath("//*[@title=\"Save\"]"));
 		
 		WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title=\"Save\"]")));
 		
    	save.click();
    	
    	WebElement newName = driver.findElement(By.xpath("//lightning-formatted-name[text()='Mrs. Ankita Patil']"));
    	
    	wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-formatted-name[text()='Mrs. Ankita Patil']")));
    	
    	String name = newName.getText();
    	String check = "Ankita Patil";
    	try {
        	Assert.assertTrue(name.contains(check));
    	}catch(Exception e) {
    		
    	}	
 		//Just for demo purpose
// 		Thread.sleep(100);
//		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}


	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception{
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtils.takeScreenshotAtEndOfTest(result.getTestName());
		}
//		driver.quit();
	}

}
