package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.Log;
import utilities.TestUtils;
import base.TestBase;

public class ContactPage extends TestBase{

    @FindBy(xpath="//span[@class='slds-truncate']")
	static WebElement title;
    
    @FindBy(xpath="//a[@href='/lightning/o/Contact/home']/parent::*")
  	static WebElement contactsLink;
    
    @FindBy(xpath="//input[@name='Contact-search-input']")
    static WebElement searchInput;
    
	@FindBy(xpath=" //button[@name='refreshButton']")
    static WebElement refreshResultBtn; 
	
    public ContactPage() {
		PageFactory.initElements(driver, this);
	}
    
    public static void verifyTitleShopperStop() {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	String actualTitle = title.getText();
    	String expectedTitle = prop.getProperty("expected");
    	try {
        	Assert.assertEquals(expectedTitle,actualTitle);
    	}catch(Exception e) {
    		Log.info(expectedTitle+" did not matched with "+actualTitle);
    	}
    }
    
    public static void searchContacts() throws Exception{
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[5]/a")));
    	contactsLink.click();
    	driver.navigate().to(TestUtils.ALL_CONTACTS);

    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	searchInput.sendKeys(prop.getProperty("contactSearch"));
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	try {
        	refreshResultBtn.submit();
    	}catch(Exception e) {
   
    	}
    	//DEMO PURPOSE
    	Thread.sleep(5000);
    }
}











//List<WebElement> searchedContact = driver.findElements(By.xpath("//*[@id=\"brandBand_1\"]/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr"));    	

//List<WebElement> afterSearch = driver.findElements(By.xpath("//*[@id=\"brandBand_1\"]/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr"));    	
//Assert.assertFalse(searchedContact.size() == afterSearch.size());