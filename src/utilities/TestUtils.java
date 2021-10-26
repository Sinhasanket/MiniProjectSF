package utilities;

import java.io.*;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import base.TestBase;

import org.apache.commons.io.FileUtils;

public class TestUtils extends TestBase{
    public static long IMPLICIT_WAIT = 10;
    public static long PAGE_LOAD_TIMEOUT=10;
    public static String FILE_READER_PATH = "C:\\Users\\sanket_sinha\\eclipse-workspace\\mini8x8Project\\src\\files\\application.properties";

    public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}