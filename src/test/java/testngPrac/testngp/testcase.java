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
	 
	  
	
	  @Test(priority = 1,description = "Verify all lang option test") public void
	  getlangOptionsTest() { GoogleHome gHome=new GoogleHome(driver);
	  gHome.getlangOptions();
	  
	  }
	 
	 
}
