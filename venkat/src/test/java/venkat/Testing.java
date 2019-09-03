package venkat;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testing {
	public static WebDriver driver;

	@BeforeTest
	public void m1() {
		System.setProperty("webdriver.chrome.driver", "C:\\Jars\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.softwaretestingmaterial.com");
		driver.navigate().refresh();
		
	}

	@Test
	public static void captureScreenMethod() throws Exception {

		try {

//		    driver.findElement(By.xpath("//*[@id='cse-search-box']/div/input[4]")).sendKeys("agile"); //Statement with correct Xpath
			driver.findElement(By.xpath("//*[@id='cse']")).sendKeys("agile"); // Statement with incorrect Xpath
		} catch (Exception e) {
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("E:\\ScreenShots\\SC.png"));
		}
		driver.close();
		driver.quit();
	}

}