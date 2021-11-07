package utilities;

import java.io.*;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import base.TestBase;

import org.apache.commons.io.FileUtils;

public class TestUtils extends TestBase{
    public static final long IMPLICIT_WAIT = 10;
    public static final long PAGE_LOAD_TIMEOUT=10;
    public static final String FILE_READER_PATH = "C:\\Users\\sanket_sinha\\eclipse-workspace\\mini8x8Project\\src\\files\\application.properties";
    public static final String CHROME_BROWSER = "C:\\Users\\sanket_sinha\\eclipse-workspace\\mini8x8Project\\src\\resources\\chromedriver.exe";
    public static final String FIREFOX_BROWSER = "C:\\Users\\sanket_sinha\\eclipse-workspace\\mini8x8Project\\src\\resources\\geckodriver.exe";
    public static final String EDGE_BROWSER = "C:\\Users\\sanket_sinha\\eclipse-workspace\\mini8x8Project\\src\\resources\\msedgedriver.exe";
    public static final String SHOPPERSTOP_APP = "https://persistentsystems-3c7-dev-ed.lightning.force.com/lightning/page/home";
    public static final String ALL_CONTACTS = "https://persistentsystems-3c7-dev-ed.lightning.force.com/lightning/o/Contact/list?filterName=00B5j000003dWwrEAE";
   
    public static void takeScreenshotAtEndOfTest(String name) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + name+" , "+System.currentTimeMillis() + ".png"));
	}
}