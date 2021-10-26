package tests;

import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase{

	TestUtils testUtils;
	HomePage homePage;
	LoginPage loginPage;

	HomePageTest(){
		super();
	}

	@Test
	public void f() {
		System.out.println("Working");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email") , prop.getProperty("password"));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}