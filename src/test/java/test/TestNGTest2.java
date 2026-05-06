package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testng.utility.ScreenshotUtil;

import config.PropertiesFile;

public class TestNGTest2 {

    WebDriver driver = null;
    public static String browserName=null;
    WebDriverWait wait;
    ExtentSparkReporter spark;
    ExtentReports extent;
    private By txt_username = By.id("username");
    private By txt_password = By.id("password");
    private By btn_login = By.id("submit");
 
    @BeforeTest
    public void setup() throws IOException {
    	
    	PropertiesFile.properties();
    	
    	if(browserName.equalsIgnoreCase("chrome")) {
    		driver = new ChromeDriver();
    		System.out.println("Chrome is launched!!");
    	}
    	
    	else if(browserName.equalsIgnoreCase("firefox")) {
    		driver = new FirefoxDriver();
    		System.out.println("Firefox is launched!!");
    	}

    	
  
    	
//        spark = new ExtentSparkReporter("reports/Extent.html");
//        spark.config().setReportName("Test Results");
//        spark.config().setDocumentTitle("ExecutionReport");
//        spark.config().setTheme(Theme.DARK);
//
//        extent = new ExtentReports();
//        extent.attachReporter(spark);
//
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        // ✅ Initialize wait AFTER driver
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        
    }

    @Test
    public void launch2() {

       // ExtentTest test1 = extent.createTest("Login Test Launch");

        driver.get("https://practicetestautomation.com/practice-test-login/");

        //test1.info("Navigating to Login");

        // ✅ Wait for page to load properly (IMPORTANT)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Test login']")));
        
        System.out.println("Naviagated to Website ");

        //test1.pass("LoginTest page loaded successfully");

        // ✅ Take screenshot AFTER page load
       // String path = ScreenshotUtil.capture(driver, "LoginPageTest");

        //test1.info("Screenshot captured",
         //       MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }
    
//    @Test(priority = 2)
//    public void login2() {
//    	ExtentTest test2 = extent.createTest("Login Check");
//    	driver.get("https://practicetestautomation.com/practice-test-login/");
//    	test2.info("Logging into system");
//    	
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(txt_username));
//    	
//    	WebElement userfield = driver.findElement(By.xpath("//input[@id='username']"));
//    	userfield.clear();
//    	userfield.sendKeys("student");
//    	test2.info("Entered username");
//    	
//    	
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(txt_password));
//    	WebElement passfield = driver.findElement(By.xpath("//input[@id='password']"));
//    	passfield.clear();
//    	passfield.sendKeys("Password123");
//    	test2.info("Entered Password");
//    	
//    	WebElement loginBtn = wait.until(
//                ExpectedConditions.elementToBeClickable(btn_login));
//
//        ((JavascriptExecutor) driver)
//                .executeScript("arguments[0].scrollIntoView(true);", loginBtn);
//
//        loginBtn.click();
//        String path = ScreenshotUtil.capture(driver, "Logintest");
//        test2.pass("student logged in successfully!");
//        test2.info("Screenshot captured",
//                MediaEntityBuilder.createScreenCaptureFromPath(path).build());
//    	
//    }
    
    @AfterTest
    public void teardown() throws IOException {

       // extent.flush();
        driver.quit();
        System.out.println("Teardown executed!!");
        PropertiesFile.setProperties();
    }
}
