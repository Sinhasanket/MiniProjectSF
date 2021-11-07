package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utilities.Log;
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
		
		switch(browserName) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", TestUtils.CHROME_BROWSER);	
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options); 
				break;
				
			case "FF":
				System.setProperty("webdriver.gecko.driver", TestUtils.FIREFOX_BROWSER);	
				driver = new FirefoxDriver(); 
				break;
				
			case "Edge":
				System.setProperty("webdriver.edge.driver", TestUtils.EDGE_BROWSER);
				driver = new EdgeDriver();
				break;
		}
				
		eventDriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventDriver.register(eventListener);
		driver = eventDriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));	
		Log.info("initialization done");
	}
}