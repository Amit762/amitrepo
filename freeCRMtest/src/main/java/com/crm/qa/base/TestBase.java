package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase 
{
	//local variables of testbase of the class
	public static WebDriver driver;
	public static Properties prop;
public TestBase() 
{
	try
	{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\asah6\\eclipse-workspace\\freeCRMtest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}catch(IOException e)
	{
		e.printStackTrace();
	}
}
	public static void initialization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome "))
		{
			System.setProperty("WebDriver.chrome.driver", "C:\\Users\\asah6\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
			 driver= new ChromeDriver();
		}else if(browsername.equals("FF"))
		{
			System.setProperty("WebDriver.gecko.driver", "C:\\Users\\asah6\\Desktop\\Selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			 driver= new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeunt, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait_timeunit, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}
}
