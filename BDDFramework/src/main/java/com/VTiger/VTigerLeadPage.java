package com.VTiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class VTigerLeadPage extends SeleniumUtility {
	WebDriver driver;
	
	public VTigerLeadPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, VTigerLead.class);
	}
	
	@FindBy(id="Leads_listView_basicAction_LBL_ADD_RECORD")
	private WebElement addLeadBtn;
	
	@FindBy(xpath="(//span[contains(text(), 'None')])[1]")
	private WebElement salutationDropdownForLead;
	
	//@FindBy(xpath="(//select[@class='inputElement select2 select2-offscreen'])[1]")
	@FindBy(xpath = "//div[@id='select2-drop']/ul/li[2]")
	private WebElement selectSalutationTypeForLead;
	
	@FindBy(id="Leads_editView_fieldName_firstname")
	private WebElement firstNameInputForLead;
	
	@FindBy(id="Leads_editView_fieldName_lastname")
	private WebElement lastNameInputForLead;
	
	@FindBy(id="Leads_editView_fieldName_company")
	private WebElement companyNameInputForLead;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveBtnForLead;
	
	@FindBy(xpath="(//a[@title='Leads'])[2]")
	private WebElement leadsHeaderLinkBtn;
	
	@FindBy(xpath="//span[contains(text(), 'Automation')]")
	private WebElement newlyCreatedLeadName ;
	
	@FindBy(xpath="//tr[td[span[span[contains(text(), 'Automation')]]]]//input[@type='checkbox']")
	private WebElement newlyCreatedLeadChkBox;
	
	@FindBy(id="Leads_listView_massAction_LBL_DELETE")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement confirmDeleteBtn;
	
	@FindBy(xpath="//span[@class='fa fa-user']")
	private WebElement logOutProfile;
	
	@FindBy(id="menubar_item_right_LBL_SIGN_OUT")
	private WebElement signOutBtn;
	
	public void createLead(String fName, String lName, String companyName)
	{
		clickOnElement(addLeadBtn);
		clickOnElement(salutationDropdownForLead);
		clickOnElement(selectSalutationTypeForLead);
		typeInput(firstNameInputForLead, fName);
		typeInput(lastNameInputForLead, lName );
		typeInput(companyNameInputForLead, companyName);
		clickOnElement(saveBtnForLead);	
	}
	
	public boolean verifyCreatedLead()
	{
		clickOnElement(leadsHeaderLinkBtn);
		return verifyUTElementDisplayed(newlyCreatedLeadName);
	}
	
	public void deleteCreatedLead()
	{
		clickOnElement(newlyCreatedLeadChkBox);
		clickOnElement(deleteBtn);
		clickOnElement(confirmDeleteBtn);
	}
	
	public void logout()
	{
		clickOnElement(logOutProfile);
		clickOnElement(signOutBtn);
		
	}
	

}
