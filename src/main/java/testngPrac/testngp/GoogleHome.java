package testngPrac.testngp;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.xml.ws.WebEndpoint;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GoogleHome extends baseClass {

	GoogleHome(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class=\"iconz-globe\"]")
	WebElement langoptions;
	
	@FindBy(xpath = "//div[@class=\"diyChoice\"]/descendant::h3")
	WebElement diyoptions;
	
	@FindBy(xpath="//a[@class=\"diyBannerBtn\"]")
	WebElement crtrbtn1;
	
	@FindBy(xpath = "//div[@class=\"pos-rel\"]/child::input[@id=\"appName\"]")
	WebElement appnameinputElement;
	
	@FindBy(xpath = "//div[@class=\"top-box\"]/descendant::a[2]")
	WebElement nextbtn;
	
	@FindBy(xpath = "//div[@class=\"verticals-container\"]/descendant::a[9]")
	WebElement intentElement;
	
	@FindBy(xpath = "//div[@class=\"btn-group\"]/child::button[@ng-click=\"appArray.themeStyle='dark'\"]")
	WebElement darkbtnoptions;
	
	@FindBy(xpath = "//div[@class=\"themeColor-list\"]/child::ul/child::li[11]")
	WebElement selectcolortheme;
	
	@FindBy(xpath = "//div[@class=\"inner\"]/child::img[@src=\"https://d2wuvg8krwnvon.cloudfront.net/newui/images/ios-logo.svg\"]")
	WebElement selectdeviceenv;
	
	@FindBy(xpath = "//div[@class=\"ng-scope\"]/child::a[@class=\"btn-next btn\"]")
	WebElement clicknextbtn;
	
	@FindBy(xpath = "//div[@class=\"moreOption\"]/descendant::li[@class=\"emailbox\"]")
	WebElement emaillink;
	
	@FindBy(xpath = "//div[@class=\"offsetbottom10 clearfix\"]/child::a")
	WebElement clickloginlink;
	
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	WebElement LoginBtn;
	
	@FindBy(xpath="//input[@name='login_username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='login_password']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='submitme']")
	WebElement loginme;
	
	@FindBy(xpath = "//div[@class=\"col-sm-4 col-xs-4 pos-rel paddingLeft0\"]/child::a[@id=\"build_step4_app_feature_save_continue\"]")
	WebElement savecontinue;
	
	@FindBy(xpath="//ul[@class=\"nav navbar-nav s-nav de-home-menu\"]/child::li")
	WebElement allmenuElement;
	
	@FindBy(xpath = "//div[@class=\"search_myApp m-r-15 on pull-left flip\"]/child::input")
	WebElement searchFieldElement;
	
	@FindBy(xpath = "//div[@class=\"search_myApp m-r-15 on pull-left flip\"]/child::button")
	WebElement searchbtnElement;
	
	@FindBy(xpath = "//div[@class=\"appProductInfo\"]/child::h1[text()=\"Appium\"]/following-sibling::a")
	WebElement editapp;
	
	@FindBy(xpath = "//div[@class=\" activeditblank addAppPages\"]")
	WebElement addelement;
	
	@FindBy(xpath = "//button[text()=\"View All\"]")
	WebElement viewall;
	
	@FindBy(xpath = "//ul[@id=\"introStyle\"]/child::li[4]")
	WebElement elementtobeadd;
	
	@FindBy(xpath = "//ul[@class=\"app_info_list\"]/child::li[text()=\"BID: 54158ef6c991\"]")
	WebElement BID;
	
	@FindBy(xpath = "//li[@class=\"dropdown\"]/child::a")
	WebElement welcomeOptions;
	
	@FindBy(xpath = "//a[@id=\"logOutNavId\"]")
	WebElement logoutElement;
	
	@FindBy(xpath = "//a[@class=\"buttonbottom\"]")
	WebElement gotomyapps;
	
	@FindBy(xpath="//span[text()=\"Test app on device\"]")
	WebElement downloadlink;
	
	@FindBy(xpath = "//div[@class=\"app-share\"]/child::label/child::input[@value=\"https://snappy.appypie.com/index/app-download/appId/54158ef6c991\"]")
	WebElement copylink;
	
	protected void downloadLinkVerify() {
		loginToApp();
		searchFieldElement.sendKeys("appium");
		searchbtnElement.click();
		clickkeyswait(driver,downloadlink,30);
		//downloadlink.click();
		copylink.click();
		((SafariDriver) driver.switchTo()).newWindow(WindowType.TAB);
	}
	
	protected void editApp() {
		loginToApp();
		searchFieldElement.sendKeys("appium");
		searchbtnElement.click();
		clickkeyswait(driver,editapp,30);
		//editapp.click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-550)");
		clickkeyswait(driver,addelement,30);
		clickkeyswait(driver,viewall,30);
		//viewall.click();
		clickkeyswait(driver,elementtobeadd,30);
		//elementtobeadd.click();
		clickkeyswait(driver,savecontinue,30);
		//savecontinue.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		String updatedurl=driver.getCurrentUrl();
		System.out.println(updatedurl);
		Assert.assertTrue(gotomyapps.isDisplayed());
	}
	protected void loginToApp() {
		if(LoginBtn.isDisplayed()) {
			LoginBtn.click();
			username.sendKeys("shailendra@appypiellp.com");
			password.sendKeys("secure@web1");
			loginme.click();
		}else {
			System.out.println("Login button not displayed");
		}
	}
	
	protected void logoutToApp() {
		loginToApp();
		Actions actions=new Actions(driver);
		actions.moveToElement(welcomeOptions).perform();
		logoutElement.click();
		boolean b=LoginBtn.isDisplayed();
		Assert.assertTrue(b);
	}
	
	protected void searchAppTest() {
		loginToApp();
		searchFieldElement.sendKeys("appium");
		searchbtnElement.click();
		String bidString=BID.getText();
		Assert.assertEquals(bidString,"BID: 54158ef6c991");
	}
	
	protected void allMenuOptions() {
		List<WebElement>list=driver.findElements(By.xpath("//ul[@class=\"nav navbar-nav s-nav de-home-menu\"]/child::li"));
		for (WebElement webElement : list) {
			System.out.println(webElement.getText());
		}
	}
	
	protected void creatorProcess() {
		if (crtrbtn1.isDisplayed()) {
			crtrbtn1.click();
			appnameinputElement.sendKeys("youapp1");
			nextbtn.click();
			intentElement.click();
			clickkeyswait(driver,darkbtnoptions,30);
			//darkbtnoptions.click();
			clickkeyswait(driver,selectcolortheme,30);
			//selectcolortheme.click();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,350)");
			selectdeviceenv.click();
			clicknextbtn.click();
			clickloginlink.click();
			username.sendKeys("shailendra@appypiellp.com");
			password.sendKeys("secure@web1");
			loginme.click();
			savecontinue.click();
			//driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver.getCurrentUrl());
			JavascriptExecutor jse1 = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,550)");
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			emaillink.click();
			Assert.assertTrue(emaillink.isDisplayed());
			System.out.println("creator process working fine testcase passed");
		}else {
			System.out.println("Creator button not enable on wordpress website or not working");
		}
	}
	public void sgetSiteTitle() {
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(driver.getTitle().contains("Application"));
	}
	
	public void verifyCurrentUrl() {
		String currenturl=driver.getCurrentUrl();
		Assert.assertEquals(currenturl, "https://www.appypie.com/");
	}
	
	//method to get all options of language
	public void getlangOptions() {
		Actions actions=new Actions(driver);
		actions.moveToElement(langoptions).build().perform();
		List<WebElement> langoptionsElements=driver.findElements(By.xpath("//a[@rel=\"noopener noreferrer\"]"));
		System.out.println(langoptionsElements.size());
		for(WebElement lanopt:langoptionsElements) {
			System.out.println(lanopt.getText());
			
		}

	}
	
	protected void getDiyOptions() {
		List<WebElement> alldiyoptionsElements=driver.findElements(By.xpath("//div[@class=\"diyChoice\"]/descendant::h3"));
		for (WebElement webElement : alldiyoptionsElements) {
			System.out.println(webElement.getText());
		}
	}
	
	public static void clickkeyswait(WebDriver driver,WebElement element,int timeout) {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	
	
}
