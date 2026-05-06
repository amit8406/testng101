package listeners;


import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(listeners.TestNGListeners.class)

public class TestNGListenerDemo {
	@Test
	public void test1()
	{
		System.out.println("inside test 1");
		
	}
	@Test
	public void test2()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.close();
	}
	@Test
	public void test3()
	{
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		@Nullable
		String title = driver.getTitle();
		System.out.println("Page Title is: "+title);
	}
}
