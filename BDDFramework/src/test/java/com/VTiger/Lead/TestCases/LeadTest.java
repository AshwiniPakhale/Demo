package com.VTiger.Lead.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.VTiger.Lead.PageClasses.VTigerHome;
import com.VTiger.Lead.PageClasses.VTigerLead;
import com.VTiger.Lead.PageClasses.VTigerLogin;

import utility.SeleniumUtility;

public class LeadTest extends SeleniumUtility
{
	VTigerLogin vtLogin = null; 
	VTigerHome vtHome = null;
	VTigerLead vtLead = null;
	WebDriver driver;
	
	//@BeforeMethod
	@Test(priority = 0)
	public void preRequisite()
	{
		driver = setUp("Chrome", "https://demo.vtiger.com/vtigercrm/index.php");
		vtLogin = new VTigerLogin(driver);
		vtHome = new VTigerHome(driver);
		vtLead = new VTigerLead(driver);
		vtLogin.login("admin", "Test@123");
		vtHome.navigateToLeadsPage();		
	}
	
	@Test(priority = 1)
	public void createLeadTest()
	{
		vtLead.createLead("manya", "Lee", "Vtiger");
	}
	
	@Test(priority = 2)
	public void verifyCreatedLead()
	{
		Assert.assertTrue(vtLead.verifyCreatedLead());
	}
	
	@Test(priority = 3)
	public void deleteDeadTest()
	{
		vtLead.deleteCreatedLead();
	}
	
	@Test(priority = 4)
	public void verifyLeadDeletedTest()
	{
		Assert.assertTrue(vtLead.verifyDeletedLead());
	}
	
	//@AfterMethod
	@Test(priority = 5)
	public void tearDown()
	{
		vtLogin.logOut();
		cleanUp();
	}
	

}