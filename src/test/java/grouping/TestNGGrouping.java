package grouping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
@Test(groups= {"AllClassTests"})
public class TestNGGrouping {
	WebDriver driver;
	
	@Test(groups={"smoke","sanity"})
	public void launchChrome()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		System.out.println("Launch tested in Chrome browser");
		driver.close();
	}
	
	@Test(groups={"windows.regression"})
	public void launchFirefox()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.close();
		System.out.println("Launch Tested in FireFox");
	}
	
	@Test(groups={"linux.regression"})
	public void launchIE()
	{
		System.out.println("Launch Tested in IE");
	}
	
	@Test(groups= {"regression"})
	public void test1()
	{
		System.out.println("Test 1 is executed!");
	}
	
	@Test(groups= {"smoke45"})
	public void test2()
	{
		System.out.println("Test 2 is executed!");
	}
	
	//@AfterMethod(alwaysRun=true)
//	public void tearDown()
//	{
//		System.out.println("Closing browser");
//		if(driver!=null)
//		{
//			driver.quit();
//		}
//	}
	
}
