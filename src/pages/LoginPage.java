package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;


public class LoginPage extends TestBase{

	@FindBy(name="username")
	WebElement email;
	
	@FindBy(className="password")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement signin;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement loginButton(WebDriver driver) {
		return signin;
	}

	public WebElement getUserEmail(WebDriver driver) {
		return email;
	}

	public WebElement getUserPassword(WebDriver driver) throws Exception{
		return password;
	}
	
	public HomePage login(String e, String pwd) {
		email.sendKeys(e);
		password.sendKeys(pwd);
		signin.click();
		return new HomePage();
	}
}