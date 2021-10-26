package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utilities.TestUtils;
import utilities.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver eventDriver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileReader read = new FileReader(TestUtils.FILE_READER_PATH);
	        prop.load(read);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sanket_sinha\\eclipse-workspace\\mini8x8Project\\src\\resources\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sanket_sinha\\eclipse-workspace\\mini8x8Project\\src\\resources\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		eventDriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventDriver.register(eventListener);
		driver = eventDriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));	
	}
}