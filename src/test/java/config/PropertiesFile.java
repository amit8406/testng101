package config;

import java.util.Properties;

import test.TestNGTest2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class PropertiesFile {
	static String projectPath = "D:\\\\Amit\\\\Java\\\\Basics\\\\testng101\\\\src\\\\test\\\\java\\\\config\\\\config.properties";
	static Properties prop = new Properties();
	public static void main(String[] args) throws IOException {
		properties();
		setProperties();
		properties();
	}
	public static void properties() throws IOException
	{
		
		InputStream input = new FileInputStream("D:\\Amit\\Java\\Basics\\testng101\\src\\test\\java\\config\\config.properties");

		prop.load(input);
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		TestNGTest2.browserName= browser;
	}

	public static void setProperties() throws IOException
	{
		OutputStream output = new FileOutputStream(projectPath); 
		prop.setProperty("result", "pass");
		prop.store(output, null);
	}
}
