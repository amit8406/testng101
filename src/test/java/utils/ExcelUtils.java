package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName)
	{
		 try {
			workbook = new XSSFWorkbook(excelPath);  //"D:\\Amit\\Java\\Basics\\testng101\\Excel\\data2.xlsx"
			sheet = workbook.getSheet(sheetName);
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
			
	}
	
	public static void main(String[] args) throws IOException {
		//getRowCount();
		//getcellData();
		getcellDataNumber(1,1);
		getcellDataString(0,0);
	}
	public static int getRowCount() throws IOException
	{
		int rowCount=0;
		try
		{
		   
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Row Count: "+rowCount);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.getClass();
			e.getCause();
		}
		return rowCount;
	}
	
	public static int getColumnCount() throws IOException
	{
		int columnCount=0;
		try
		{
		   
			columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Column Count: "+columnCount);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.getClass();
			e.getCause();
		}
		return columnCount;
	}
	
	
	
	
	public static String getcellDataString(int rowNum, int colNum)
	{
		String cellData = null;
		try
		{
			
			    //workbook = new XSSFWorkbook("D:\\Amit\\Java\\Basics\\testng101\\Excel\\data2.xlsx");
				//sheet = workbook.getSheet("Sheet1");
				cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
				//System.out.println("Cell Data: "+cellData);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.getClass();
			e.getCause();
		}
		return cellData;
	}
	
	public static double getcellDataNumber(int rowNum, int colNum)
	{
		double cellData1 = 0.0;
		try
		{
			    workbook = new XSSFWorkbook("D:\\Amit\\Java\\Basics\\testng101\\Excel\\data2.xlsx");
				sheet = workbook.getSheet("Sheet1");
				cellData1 = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
				System.out.println("Cell Data: "+cellData1);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.getClass();
			e.getCause();
		}
		return cellData1;
	}

}
