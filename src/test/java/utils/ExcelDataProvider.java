package utils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class ExcelDataProvider {
	WebDriver driver;
	WebDriverWait wait;
	private By txt_username = By.id("username");
    private By txt_password = By.id("password");
    //private By btn_login = By.id("submit");
	
	
	 @BeforeTest
	    public void setup() throws IOException {

		     driver = new ChromeDriver();   // ✅ FIRST
		     driver.manage().window().maximize();  // ✅ THEN use

		     wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ initialize wait
		 }

	        


	
	
	@Test(dataProvider="test1Data")
	public void test1(String username, String password)
	{
	    System.out.println(username + " | " + password);

	    driver.get("https://practicetestautomation.com/practice-test-login/");

	    wait.until(ExpectedConditions.visibilityOfElementLocated(txt_username));
	    driver.findElement(txt_username).sendKeys(username);

	    wait.until(ExpectedConditions.visibilityOfElementLocated(txt_password));
	    driver.findElement(txt_password).sendKeys(password);
	}

	
	@DataProvider(name= "test1Data")
	public Object[][] getData()
	{
		String excelPath = "D:\\Amit\\Java\\Basics\\testng101\\Excel\\data2.xlsx";
		Object data[][]=testData(excelPath,"Sheet1");
		return data;
	}
	
	
	
	public static Object[][] testData(String excelPath, String sheetName)
	{
		ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
			try
			{
			int rowCount = excel.getRowCount();
			int columnCount = excel.getColumnCount();
			
			Object data[][] = new Object[rowCount-1][columnCount];
			
			 for(int i=1; i< rowCount; i++)
			 {
				 for(int j=0;j<columnCount;j++)
				 {
					 String cellData=excel.getcellDataString(i,j);
					 //System.out.print(cellData+" | ");
					 data[i-1][j]= cellData;
					 
				 }
				 System.out.println();
			 }
			 return data;
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return null;
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
