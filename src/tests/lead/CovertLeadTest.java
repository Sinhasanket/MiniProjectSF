package tests.lead;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utilities.TestUtils;

public class CovertLeadTest extends TestBase{

	TestUtils testUtils;
	LoginPage loginPage;

	CovertLeadTest(){
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
	//This test method will convert the lead 
	@Test
	public void convertLead() throws InterruptedException {
		Actions action=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement lead;
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String leadname="Ankita Patil"; //firstName +" "+lastName;
		//		System.out.println("leadname:"+leadname);
		for(int i=1;;i++) {
			if(i>10)
				break;
			try {
				lead=driver.findElement(By.xpath("//*[@id=\"brandBand_1\"]/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+i+"]/th/span/a"));
				//				System.out.println(lead.getText());
				if(lead.getText().equals(leadname)) {
					lead.click();
					//					Thread.sleep(100);
					WebElement option=driver.findElement(By.xpath("//*[@id=\"brandBand_2\"]/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___runtime_sales_lead__-lead_rec_-l___-lead___-v-i-e-w/forcegenerated-flexipage_lead_rec_l_lead__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_lead___012000000000000aaa___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[3]/div/runtime_platform_actions-actions-ribbon/ul/li[4]/lightning-button-menu/button/lightning-primitive-icon"));
					option.click();
					//				    Thread.sleep(100);
					WebElement convert=driver.findElement(By.xpath("//*[@id=\"brandBand_2\"]/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___runtime_sales_lead__-lead_rec_-l___-lead___-v-i-e-w/forcegenerated-flexipage_lead_rec_l_lead__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_lead___012000000000000aaa___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[3]/div/runtime_platform_actions-actions-ribbon/ul/li[4]/lightning-button-menu/div/div/slot/runtime_platform_actions-action-renderer[7]/runtime_platform_actions-executor-aura-legacy/slot/slot/runtime_platform_actions-ribbon-menu-item/a"));
					convert.click();

					//  Thread.sleep(200);
					JavascriptExecutor j = (JavascriptExecutor)driver;
					if (j.executeScript("return document.readyState").toString().equals("complete")){
						//                    System.out.println("Page in ready state");
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div[1]/fieldset[1]/div/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/label/span[1]")));
						WebElement finalConvert=driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/button[2]"));
						Thread.sleep(300);
						action.moveToElement(finalConvert);
						action.click().perform();
						//                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   
					}
					break;
				}			
			}catch(ArrayIndexOutOfBoundsException e) {
				break;
			}catch(Exception e) {
				e.printStackTrace();
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
