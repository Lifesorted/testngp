package testngPrac.testngp;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.entity.EntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import net.bytebuddy.description.annotation.AnnotationDescription.Loadable;
import testngPrac.testngp.enums.Browser;
import testngPrac.testngp.enums.OS;
import util.CaptureScreenshot;
import util.GetexcelData;
import util.Reports;

public class baseClass {

	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() {
		String reportpath=System.getProperty("user.dir")+"/Reports/Appypie_Report_"+CaptureScreenshot.getCurrentTime()+".html";
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(reportpath);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		System.out.println("Report created");
	}
	
	@BeforeMethod
	public void launchApp() throws Exception {
		String browser=GetexcelData.getbrowser();
		if(System.getProperty("os.name").toLowerCase().contains(OS.WINDOW.name().toLowerCase())) {
		  if(browser.equalsIgnoreCase(Browser.FIREFOX.name())) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			//DesiredCapabilities capabilities = DesiredCapabilities.firefox(); 
	        //capabilities.setCapability("browser.privatebrowsing.autostart", true); 
			driver=new FirefoxDriver();
		   }else if (browser.equalsIgnoreCase(Browser.CHROME.name())) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			// ChromeOptions chromeOptions = new ChromeOptions();
			 //chromeOptions.addArguments("--headless");
			driver=new ChromeDriver();
		   }else {
			System.out.println("No driver found");
		   }
		}else if (System.getProperty("os.name").toLowerCase().contains(OS.MAC.name().toLowerCase())) {
			 if(browser.equalsIgnoreCase(Browser.FIREFOX.name())) {
					System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
					//DesiredCapabilities capabilities = DesiredCapabilities.firefox(); 
			        //capabilities.setCapability("browser.privatebrowsing.autostart", true); 
					driver=new FirefoxDriver();
				   }else if (browser.equalsIgnoreCase(Browser.CHROME.name())) {
					System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
					// ChromeOptions chromeOptions = new ChromeOptions();
					 //chromeOptions.addArguments("--headless");
					driver=new ChromeDriver();
				   }else if (browser.equalsIgnoreCase(Browser.SAFARI.name())) {
						System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
						// ChromeOptions chromeOptions = new ChromeOptions();
						 //chromeOptions.addArguments("--headless");
						driver=new ChromeDriver();
				   }else {
					System.out.println("No driver found");
				   }
		}else if (System.getProperty("os.name").toLowerCase().contains(OS.LINUX.name().toLowerCase())) {
			if(browser.equalsIgnoreCase(Browser.FIREFOX.name())) {
				System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
				//DesiredCapabilities capabilities = DesiredCapabilities.firefox(); 
		        //capabilities.setCapability("browser.privatebrowsing.autostart", true); 
				driver=new FirefoxDriver();
			   }else if (browser.equalsIgnoreCase(Browser.CHROME.name())) {
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				// ChromeOptions chromeOptions = new ChromeOptions();
				 //chromeOptions.addArguments("--headless");
				driver=new ChromeDriver();
			   }else if (browser.equalsIgnoreCase(Browser.OPERA.name())) {
					System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
					// ChromeOptions chromeOptions = new ChromeOptions();
					 //chromeOptions.addArguments("--headless");
					driver=new ChromeDriver();
			   }else {
				System.out.println("No driver found");
			   }
		}else {
			System.out.println("Operating System not supported");
		}
		driver.manage().window().maximize();
		driver.get(GetexcelData.getSiteUrl());
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			String pathString=CaptureScreenshot.getScreenshotas(driver);
			
			System.out.println(pathString);
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(pathString).build());
			
		}else if (result.getStatus()==ITestResult.SKIP) {
			
			logger.skip("Test Skipped",MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreenshot.getScreenshotas(driver)).build());
		
		}
		extent.flush();
		driver.close();
	}
		
}

