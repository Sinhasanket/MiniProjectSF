package pages.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.Log;

public class AppManagerPage {

	private WebDriver driver;
	private EditAppPage editApp;

	@FindBy(xpath="//span[contains(text(),'New Lightning App')]")
	private WebElement newAppButton;

	@FindBy(xpath="//tbody[1]/tr")
	private List<WebElement> trList;

	@FindBy(xpath="//body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/lightning-input[1]/div[1]/input[1]")
	private WebElement newAppNameTextBox;

	@FindBy(xpath="//body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/lightning-input[1]/div[1]/input[1]")
	private WebElement newDeveloperNameTextBox;

	public AppManagerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyTitle() {
		Assert.assertEquals(driver.getTitle(), "App Manager | Salesforce");
	}

	public void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.titleIs("App Manager | Salesforce"));
		wait.until(
				ExpectedConditions.and(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[1]")),
						ExpectedConditions.titleIs("App Manager | Salesforce")
						));
	}

	public void createNewApp(String appName, String devName, String duplicate) {

		newAppButton.click();

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(newAppNameTextBox));

		//newAppNameTextBox.click();
		newAppNameTextBox.clear();
		newAppNameTextBox.sendKeys(appName);

		wait.until(ExpectedConditions.visibilityOf(newDeveloperNameTextBox));

		newDeveloperNameTextBox.click();
		newDeveloperNameTextBox.clear();
		newDeveloperNameTextBox.sendKeys(devName);

		driver.findElement(By.xpath("//body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/button[2]")).click();

		if(duplicate.equals("no")) {
			driver.findElement(By.xpath("//body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/button[2]")).click();
			driver.findElement(By.xpath("//body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/button[2]")).click();
			driver.findElement(By.xpath("//body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/button[2]")).click();
			driver.findElement(By.xpath("//body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/button[2]")).click();	
		}

		else if(duplicate.equals("yes")){
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/lightning-input[1]/div[2]")));
				WebElement help = driver.findElement(By.xpath("//body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/lightning-input[1]/div[2]"));
				Assert.assertEquals(help.getText(), "Name must be unique.");
			}
			catch(NoSuchElementException e) {
				Log.error(e.getMessage());
//				System.out.println(e);
				Assert.fail();
			}
		}
		else {
			Log.info("Value of duplicate should be yes or no.");
//			System.out.println();
			Assert.fail();
		}

	}

	public boolean checkAppCreate(String dev) {

		Log.info("Inside check create App method");

		try {
//			System.out.println("Waiting for 5s");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int numOfApps = trList.size();

		for(int i = 1; i<=numOfApps; i++) {
			String devName =  driver.findElement(By.xpath("//tbody[1]/tr[" + i + "]/td[2]/span[1]")).getText();
//			System.out.println(devName);
			if(devName.equals(dev)) {
				return true;
			}
		}
		return false;
	}

	public void editApp(String app, String dev, String newApp, String newDev, String duplicate) {

		WebDriverWait wait = new WebDriverWait(driver,30);

		int found = 0;
//		System.out.println("Inside edit app method"); 
		int numOfApps = trList.size();
//		System.out.println("number of apps="+numOfApps);

		for(int i = 1; i<=numOfApps; i++) {

			String devName =  driver.findElement(By.xpath("//tbody[1]/tr[" + i + "]/td[2]/span[1]")).getText();
//			System.out.println(devName);

			if(devName.equals(dev)) {
//				System.out.println("App to be edited found");
				found = 1;
				WebElement dropdownButton = driver.findElement(By.xpath("//tbody[1]/tr[" + i + "]/td[7]/span[1]/div[1]/a[1]/span[1]/span[1]"));
				dropdownButton.click();

				if(duplicate.equals("no")) {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/div[8]/div[1]/ul[1]/li[2]/a[1]")));

					driver.findElement(By.xpath("//body[1]/div[8]/div[1]/ul[1]/li[1]/a[1]")).click();

					editApp = new EditAppPage(driver);
					editApp.waitForPageLoad(app);
					editApp.changeAppName(newApp);
					editApp.changeDevName(devName);
					editApp.clickSave();
				}

				//			    else if(appType.equals("default")) {
				//			    		//Wait for edit button
				//						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/div[8]/div[1]/ul[1]/li[1]/a[1]")));
				//						
				//						driver.findElement(By.xpath("//body[1]/div[8]/div[1]/ul[1]/li[1]/a[1]")).click();
				//						
				//						editApp = new EditAppPage(driver);
				//					    editApp.waitForPageLoad(app);
				//					    editApp.checkMsg();
				//			    }
				else {
//					System.out.println("Wrong data. duplicate should be yes or no.");
					Assert.fail();
				}
				break;
			}
		}

		if(found == 0) {
			System.out.println("App doesn't exist");
		}
		//body/div[4]/div[1]/section[1]/div[1]/div[1]/div[2]/div[2]/section[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[i]/th[1]/span[1]
	}

	public boolean checkAppEdit(String app, String dev) {

		System.out.println("Inside check create App method");

		try {
			System.out.println("Waiting for 5s");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int numOfApps = trList.size();

		for(int i = 1; i<=numOfApps; i++) {

			String appName =  driver.findElement(By.xpath("//tbody[1]/tr[" + i + "]/th[1]/span[1]")).getText();
			String devName =  driver.findElement(By.xpath("//tbody[1]/tr[" + i + "]/td[2]/span[1]")).getText();
			System.out.println(devName);

			if(devName.equals(dev) && appName.equals(app)) {
				return true;
			}
		}
		return false;
	}


	public void deleteApp(String dev, String appType) {

		int found = 0;
		System.out.println("Inside delete App method"); 
		int numOfApps = trList.size();
		System.out.println("number of apps="+numOfApps);

		for(int i = 1; i<=numOfApps; i++) {

			String devName =  driver.findElement(By.xpath("//tbody[1]/tr[" + i + "]/td[2]/span[1]")).getText();
			System.out.println(devName);

			if(devName.equals(dev)) {
				System.out.println("App to be deleted found");
				found = 1;
				WebElement deleteButton = driver.findElement(By.xpath("//tbody[1]/tr[" + i + "]/td[7]/span[1]/div[1]/a[1]/span[1]/span[1]"));
				deleteButton.click();

				if(appType.equals("non-default")) {
					WebDriverWait wait = new WebDriverWait(driver,30);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/div[8]/div[1]/ul[1]/li[2]/a[1]")));

					driver.findElement(By.xpath("//body[1]/div[8]/div[1]/ul[1]/li[2]/a[1]")).click();
					driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();	
				}

				else if(appType.equals("default")) {
					try {
						//Wait for edit button
						WebDriverWait wait = new WebDriverWait(driver,30);
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/div[8]/div[1]/ul[1]/li[1]/a[1]")));

						driver.findElement(By.xpath("//body[1]/div[8]/div[1]/ul[1]/li[2]/a[1]")).click();
						Assert.fail();

					}
					catch(NoSuchElementException e){
						System.out.println(e);
					}
				}
				else {
					System.out.println("Wrong data. Type of app should be default or non-default.");
					Assert.fail();
				}
				break;
			}
		}

		if(found == 0) {
			System.out.println("App doesn't exist");
		}
		//body/div[4]/div[1]/section[1]/div[1]/div[1]/div[2]/div[2]/section[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[i]/th[1]/span[1]
	}

	public boolean checkAppDelete(String dev) {

		System.out.println("Inside check delete App method");

		try {
			System.out.println("Waiting for 5s");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int numOfApps = trList.size();

		for(int i = 1; i<=numOfApps; i++) {

			String devName =  driver.findElement(By.xpath("//tbody[1]/tr[" + i + "]/td[2]/span[1]")).getText();
			System.out.println(devName);

			if(devName.equals(dev)) {
				return false;
			}
		}
		return true;
	}
}
