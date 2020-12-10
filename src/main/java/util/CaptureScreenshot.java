package util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
public class CaptureScreenshot {
	
	public static String getScreenshotas(WebDriver driver) {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/Appypie_"+getCurrentTime()+ ".png";
		try {
			FileUtils.copyFile(src, new File(screenshotpath));
			System.out.println("screenshot captured successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("unable to capture");
		}
		return screenshotpath;
	}
	
	public static String getCurrentTime() {
		DateFormat datetime=new SimpleDateFormat("dd_mm_yy_hh_mm_ss");
		Date currentdate=new Date();
		return datetime.format(currentdate);
	}

}
