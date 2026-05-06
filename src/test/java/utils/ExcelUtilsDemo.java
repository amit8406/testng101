package utils;

import java.io.IOException;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectPath+"\\Excel\\data2.xlsx", "Sheet1");
		try {
			excel.getRowCount();
			excel.getColumnCount();
			excel.getcellDataString(0,0);
			excel.getcellDataNumber(1,1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
