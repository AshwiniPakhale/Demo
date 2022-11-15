package com.SwagLab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage
{
	WebDriver driver;
	public SwagLabHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(css="div[class='app_logo']")
	private WebElement homePageAppLogo;
	
	public WebElement getHomePageAppLogo()
	{
		return homePageAppLogo;
	}
	

}
