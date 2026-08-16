package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownlad {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://practice.expandtesting.com/upload");
		//Thread.sleep(5000);
		driver.findElement(By.id("fileInput")).sendKeys("D:\\event.png");
		driver.findElement(By.id("fileSubmit")).click();
		driver.close();
		System.out.println("File upploaded!!");
	}

}
