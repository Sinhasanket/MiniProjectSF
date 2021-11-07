package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePage {

	private WebDriver driver;
	private String title = "Home | Salesforce"; 

	@FindBy(xpath="//body[1]/div[4]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	private WebElement searchBox;

	@FindBy(xpath="//mark[contains(text(),'App Manager')]")
	private WebElement appManager;

	@FindBy(xpath="//body/div[4]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/div[1]/div[1]")
	private WebElement appLauncher;

	@FindBy(xpath="//body[1]/div[4]/div[2]/div[2]/div[1]/div[1]/one-app-launcher-menu[1]/div[1]/one-app-launcher-search-bar[1]/lightning-input[1]/div[1]/input[1]")
	private WebElement appLauncherSearchBox;



	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyTitle() {

		Assert.assertEquals(driver.getTitle(), title, "Title doesn't match");
	}

	public void open() {
		driver.get("https://persistentsystems-3c7-dev-ed.lightning.force.com/lightning/setup/SetupOneHome/home");
	}

	public void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(
				ExpectedConditions.and(
						ExpectedConditions.titleIs("Home | Salesforce"),
						ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Create')]")),
						ExpectedConditions.visibilityOf(searchBox)
						)); 
	}

	public void writeToSearchBox(String str) {
		searchBox.sendKeys(str);
	}

	public void writeToAppLauncherSearchBox(String str) {
		appLauncherSearchBox.sendKeys(str);
	}

	public void clickAppManager() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(appManager)); 
		appManager.click();
	}

	public void clickAppLauncher() {
		appLauncher.click();
	}
}
