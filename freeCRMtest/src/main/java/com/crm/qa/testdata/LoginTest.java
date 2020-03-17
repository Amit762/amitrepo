package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends TestBase
{
	LoginPage loginpage;
	HomePage  homepage;
public LoginTest()
{
	super();
}
	@BeforeMethod
	
	public void setUp()
	{
		initialization();
		
		 loginpage= new LoginPage();	
	}
	@Test(priority = 1)
	public void loginpagetitleTest()
	{
		String title=loginpage.testloginpagetitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test(priority = 2)
	public void crmlogoImageTest()
	{
		boolean flag=loginpage.validatecrmlogo();
		Assert.assertTrue(flag);
	}
	@Test(priority = 3)
	public void loginTest()
	{
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
