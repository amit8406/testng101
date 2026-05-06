package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
		
		spark.config().setReportName("Test Results");
		spark.config().setDocumentTitle("ExecutionReport");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		
		
		ExtentTest test1 = extent.createTest("GoogleLaunch");
		test1.info("Google launched!!");

		driver = new ChromeDriver();
		Thread.sleep(4000);
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(6000);
		test1.pass("Google browser is opened!");
		//input[@name='q']
		//driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Automation");
		//driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.ENTER);
		//test1.info("Browser is closed");
		driver.quit();
		test1.info("Driver is closed!");
		
		
		ExtentTest test2 = extent.createTest("GoogleLaunch2");
		test2.info("Google launched!!");
		driver = new ChromeDriver();
		Thread.sleep(4000);
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(6000);
		driver.quit();
		test2.fail("Google browser is opened!");
		
		
		
		extent.flush();
		
	}

}
