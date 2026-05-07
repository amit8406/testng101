package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestTrip {
	WebDriver driver = null;
    WebDriverWait wait;
    ExtentSparkReporter spark;
    ExtentReports extent;
	
	@BeforeTest
	public void setup()
	{
		spark = new ExtentSparkReporter("reports/ExtentT.html");
        spark.config().setReportName("Test Results");
        spark.config().setDocumentTitle("ExecutionReport");
        spark.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(spark);

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ✅ Initialize wait AFTER driver
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("ChromeBrowser is launched!!");

	}
	@Test
	public void launch() {

        ExtentTest test1 = extent.createTest("xPath Practice Page Check");

        driver.get("https://selectorshub.com/xpath-practice-page/");

        test1.info("Navigating to xPath practice page!");

        // ✅ Wait for page to load properly (IMPORTANT)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Find out')]")));

        test1.pass("xPath page loaded successfully");
	}
	@Test
	public void TestDropDownValue()
	{
		ExtentTest test2 = extent.createTest("Selection of value in DropDown");

	    driver.get("https://selectorshub.com/xpath-practice-page/");

	    test2.info("Selection of value in process.");

	    WebElement element = driver.findElement(By.xpath("//button[contains(text(), 'Checkout')]"));

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript("arguments[0].scrollIntoView(true);", element);

	    test2.info("Scrolled to dropdown section");

	    WebElement dropdown = driver.findElement(By.id("cars"));

	    Select select = new Select(dropdown);

	    select.selectByVisibleText("Volvo");

	    test2.pass("Dropdown value selected successfully");
		
		
		 
	}
	@AfterTest
	public void tearDown()
	{
	    extent.flush();

	    if(driver != null)
	    {
	        driver.quit();
	    }

	    System.out.println("Report Generated");
	}
	
}
