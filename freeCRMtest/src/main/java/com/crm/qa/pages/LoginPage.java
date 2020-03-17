package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
//Page Factory or Oject Repositry
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signupbtn;
	
	@FindBy(xpath="//img[@class='img-responsive']//parent::a[@class='navbar-brand']")
	WebElement crmprologo;
	//Initialising the Page Objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Actions
	public  String testloginpagetitle()
	{
		return driver.getTitle();
	}
	public boolean validatecrmlogo()
	{
		return crmprologo.isDisplayed();
	}
	
	
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
