package testngPrac.testngp;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import util.CaptureScreenshot;

public class testcase extends baseClass {
	
	
	/*
	 * @Test(priority = 1,description = "verify title test") public void
	 * verifyTitleTest() { GoogleHome gHome=new GoogleHome(driver);
	 * gHome.sgetSiteTitle(); extent.createTest("Verify title test"); }
	 */
	
	/*
	 * @Test(priority = 2,description = "verify current url test") public void
	 * verifyCurrentUrlTest() { GoogleHome gHome=new GoogleHome(driver);
	 * gHome.verifyCurrentUrl(); extent.createTest("Verify currenturl test");
	 * 
	 * }
	 */
	 
	  
	//test
	/*
	 * @Test(priority = 1,description = "Verify all lang option test") public void
	 * getlangOptionsTest() { GoogleHome gHome=new GoogleHome(driver);
	 * gHome.getlangOptions();
	 * 
	 * }
	 */
	  
	/*
	 * @Test public void getAllDiyOptions() { GoogleHome gHome=new
	 * GoogleHome(driver); gHome.getDiyOptions(); }
	 */
	 
	/*
	 * @Test public void creatorProcessTest() { GoogleHome gHome=new
	 * GoogleHome(driver); gHome.creatorProcess(); }
	 */
	  
	/*
	 * @Test public void AllMenuOptionTest() { GoogleHome gHome=new
	 * GoogleHome(driver); gHome.allMenuOptions(); }
	 */
	
	  @Test public void searchAppTest() { GoogleHome gHome=new GoogleHome(driver);
	  gHome.searchAppTest(); }
	 
	
	/*
	 * @Test public void logoutAppTest() { GoogleHome gHome=new GoogleHome(driver);
	 * gHome.logoutToApp(); }
	 */
	
	/*
	 * @Test public void addFeatureTest() { GoogleHome gHome=new GoogleHome(driver);
	 * gHome.editApp(); }
	 */
	
	/*
	 * @Test public void addFeatureTest() { GoogleHome gHome=new GoogleHome(driver);
	 * gHome.downloadLinkVerify(); }
	 */
}
