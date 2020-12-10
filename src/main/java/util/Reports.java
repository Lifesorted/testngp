package util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	

	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeMethod
	public static void generateReport() {
		String reportpath=System.getProperty("user.dir")+"/Reports/Appypie_Report_"+CaptureScreenshot.getCurrentTime()+ ".html";
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(reportpath);
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@Test
	public void launchApp() throws Exception {
		String browser="chrome";
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			//DesiredCapabilities capabilities = DesiredCapabilities.firefox(); 
	        //capabilities.setCapability("browser.privatebrowsing.autostart", true); 
			driver=new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			 //ChromeOptions chromeOptions = new ChromeOptions();
			    //chromeOptions.addArguments("--headless");
			driver=new ChromeDriver();
		}else {
			System.out.println("No driver found");
		}
		driver.manage().window().maximize();
		driver.get(GetexcelData.getSiteUrl());
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertTrue(driver.getTitle().contains("appypieaa"));
	}

	
	@AfterMethod
	public void closeApp(ITestResult result)throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail(result.getThrowable().getMessage());
			String tempString=CaptureScreenshot.getScreenshotas(driver);
		    logger.addScreenCaptureFromPath(tempString);	    
	}
		extent.flush();
		driver.close();
	}

}
