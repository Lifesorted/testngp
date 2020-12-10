package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetexcelData {

	static File srcFile=new File("./TestData/testdata.xlsx");
	
	public static String getbrowser() throws IOException {
		FileInputStream fis=new FileInputStream(srcFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet1=workbook.getSheet("Data1");
		String browserval=sheet1.getRow(0).getCell(1).getStringCellValue();
		return browserval;
	}
	
	public static String getSiteUrl() throws Exception {
		FileInputStream fis=new FileInputStream(srcFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet1=workbook.getSheet("Data1");
		String siteurl=sheet1.getRow(1).getCell(1).getStringCellValue();
		return siteurl;
	}
	
	
}
