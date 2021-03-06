package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Enumeration;
import java.util.Properties;

public class getPropertyData {
	
	static File src=new File("./TestData/testdata.properties");
	FileInputStream fileInputStream;
	Properties prop;
	
	public getPropertyData() throws IOException {
		FileInputStream fileInputStream=new FileInputStream(src);
		prop=new Properties();
		prop.load(fileInputStream);
	}
	
	public static void getprojUrl() throws Exception {
		FileInputStream fileInputStream=new FileInputStream(src);
		Properties prop=new Properties();
		prop.load(fileInputStream);
		
		Enumeration<Object> keyval=prop.keys();
		while(keyval.hasMoreElements()) {
			String keyString=(String) keyval.nextElement();
			String valString=prop.getProperty(keyString);
			System.out.println(keyString+":-"+valString);
		}
	}
	public String getbrowser() {
		String browser=prop.getProperty("Browser");
		return browser;
	}

}
