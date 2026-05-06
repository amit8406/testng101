package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {
	By txt_username = By.name("username");
	By txt_password= By.name("password");
	By login_btn = By.xpath("//button[@type='submit']");
	WebDriver driver=null;
	WebDriverWait wait;
	
	
	public login(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void enter_username(String uname)
	{
		WebElement user=wait.until(ExpectedConditions.visibilityOfElementLocated(txt_username));
		user.clear();
		user.sendKeys(uname);
	}
	public void enter_password(String pass)
	{
		WebElement user=wait.until(ExpectedConditions.visibilityOfElementLocated(txt_password));
		user.clear();
		user.sendKeys(pass);
	}
	
	
	public void enter_username_and_password(String uname, String pass)
	{
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_username));
		user.sendKeys(uname);
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_password));
		password.sendKeys(pass);
	}
	
	public void click_login()
	{
		WebElement btn_click = wait.until(ExpectedConditions.visibilityOfElementLocated(login_btn));
		btn_click.click();
		
	}

}
