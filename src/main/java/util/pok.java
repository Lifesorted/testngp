package util;

import java.io.IOException;

public class pok {
	
	public static void main(String args[]) throws Exception {
		GetexcelData mmData=new GetexcelData();
		System.out.println(mmData.getdatafromNode(2, 2, 2));
		//mmData.getalldata(3);
		//getPropertyData gPropertyData=new getPropertyData();
		//System.out.println(gPropertyData.getbrowser());
		//System.out.println(GetexcelData.getbrowser());
		try {
			System.out.println(GetexcelData.getCellValue(0, 0, 3));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			getPropertyData.getprojUrl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
