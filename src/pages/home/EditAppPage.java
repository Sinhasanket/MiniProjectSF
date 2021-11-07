package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditAppPage {

	private WebDriver driver;

	@FindBy(xpath="//body[1]/div[4]/div[1]/div[1]/div[2]/section[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/lightning-input[1]/div[1]/input[1]")
	private WebElement newAppTextBox;

	@FindBy(xpath="//body[1]/div[4]/div[1]/div[1]/div[2]/section[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/lightning-input[1]/div[1]/input[1]")
	private WebElement newDevTextBox;

	@FindBy(xpath="//body[1]/div[4]/div[1]/div[1]/div[2]/section[1]/div[1]/div[2]/div[1]/div[3]/div[1]/button[2]")
	private WebElement saveButton;

	public EditAppPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForPageLoad(String appName) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(
				ExpectedConditions.and(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/div[4]/div[1]/div[1]/div[2]/section[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/lightning-input[1]/div[1]/input[1]")),
						ExpectedConditions.titleIs(appName + " | Lightning App Builder")
						));
	}

	public void changeAppName(String newAppName) {
		newAppTextBox.clear();
		newAppTextBox.sendKeys(newAppName);
	}

	public void changeDevName(String newDevName) {
		newDevTextBox.clear();
		newDevTextBox.sendKeys(newDevName);
	}

	public void clickSave() {
		saveButton.click();
	}

	public void checkMsg() {

	}

}
