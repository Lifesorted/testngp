package testngPrac.testngp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GoogleHome extends baseClass {

	GoogleHome(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class=\"iconz-globe\"]")
	WebElement langoptions;
	
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
	
	
}
