package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetexcelData {

	static File srcFile=new File("./TestData/testdata.xlsx");
	static FileInputStream fis;
	static XSSFWorkbook workbook;
	static XSSFSheet sheets;
	public static String getbrowser() throws IOException {
		fis=new FileInputStream(srcFile);
	    workbook=new XSSFWorkbook(fis);
	    sheets=workbook.getSheetAt(0);
		String browserval=sheets.getRow(0).getCell(1).getStringCellValue();
		return browserval;
	}
	
	public static String getSiteUrl() throws Exception {
		FileInputStream fis=new FileInputStream(srcFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet1=workbook.getSheet("Data1");
		String siteurl=sheet1.getRow(1).getCell(1).getStringCellValue();
		return siteurl;
	}
	
	public String getrowdata(int row) throws IOException {
		fis=new FileInputStream(srcFile);
		workbook=new XSSFWorkbook(fis);
		sheets=workbook.getSheetAt(0);
		String dataString=sheets.getRow(row).getCell(0).getStringCellValue();
		return dataString;
	}
	
	public void getalldata(int rownum) throws IOException {
		fis=new FileInputStream(srcFile);
		workbook=new XSSFWorkbook(fis);
		sheets=workbook.getSheetAt(0);
		//int rowcount=sheets.getLastRowNum()+1;
		int col=sheets.getRow(rownum).getPhysicalNumberOfCells();
		System.out.println("columns are:"+col);
		//String dataString="";
		for (int i = rownum; i <= rownum; i++) {
			for (int j = 0; j <= col; j++) {
				String dataString=sheets.getRow(i).getCell(j).getStringCellValue();
				System.out.println("Available data in sheet is="+dataString);
			}
			
		}
		//return dataString;
		workbook.close();
	}
	
	public static String getCellValue(int sheet,int row,int col) throws Exception {
		fis=new FileInputStream(srcFile);
		workbook=new XSSFWorkbook(fis);
		sheets=workbook.getSheetAt(sheet);
		String celldataString=sheets.getRow(row).getCell(col).getStringCellValue();
		workbook.close();
		return celldataString;
	
	}
	
}
