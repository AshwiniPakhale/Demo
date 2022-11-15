package com.VTigerLeadBackgroundEx;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class VTigerLeadPage extends SeleniumUtility {
	
	WebDriver driver;

	public VTigerLeadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Leads_listView_basicAction_LBL_ADD_RECORD")
	private WebElement addLeadBtn;

	@FindBy(xpath = "(//span[contains(text(),'None')])[1]")
	private WebElement salutationDropDownForLead;

	@FindBy(xpath = "//div[@id='select2-drop']/ul/li[2]")
	private WebElement selectSalutationTypeForLead;

	@FindBy(id = "Leads_editView_fieldName_firstname")
	private WebElement firstNameInputForLead;

	@FindBy(id = "Leads_editView_fieldName_lastname")
	private WebElement lastNameInputForLead;

	@FindBy(id = "Leads_editView_fieldName_company")
	private WebElement companyInputForLead;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtnForLead;

	@FindBy(xpath = "//h4[contains(text(),'Leads')]")
	private WebElement leadHeaderLink;

	@FindBy(xpath = "//a[contains(text(),'All')]")
	private WebElement allBtn;

	@FindBy(xpath = "//a[contains(text(),'Smith')]")
	private WebElement newlyCreatedLeadName;

	@FindBy(xpath = "//tr[td[span[span[contains(text(),'TestForCucumber')]]]]/td[1]//input")
	private WebElement newlyCreatedLeadCheckBox;

	@FindBy(xpath = "//span[@title='Select all records in this page']/input")
	private WebElement selectAllCreatedLeads;

	@FindBy(id = "Leads_listView_massAction_LBL_DELETE")
	private WebElement deleteBtn;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement confirmDeleteBtn;

	public void createLead(String firstName, String lastName, String companyName) {
		clickOnElement(addLeadBtn);
		clickOnElement(salutationDropDownForLead);
		clickOnElement(selectSalutationTypeForLead);
		typeInput(firstNameInputForLead, firstName);
		typeInput(lastNameInputForLead, lastName);
		typeInput(companyInputForLead, companyName);
		clickOnElement(saveBtnForLead);
	}

	public void clickOnAllBtn() {
		clickOnElement(allBtn);
	}

	public boolean verifyCreatedLead() {
		clickOnElement(leadHeaderLink);
		return verifyUTElementDisplayed(newlyCreatedLeadName);
	}

	public void selectAllCreatedLeads() {
		clickOnElement(selectAllCreatedLeads);
	}

	public void clickOnDeleteBtn() {
		clickOnElement(deleteBtn);
	}

	public void clickOnConfirmDeleteBtn() {
		clickOnElement(confirmDeleteBtn);
	}

	public void deleteCreatedLead() {
		clickOnElement(selectAllCreatedLeads);
		clickOnElement(deleteBtn);
		clickOnElement(confirmDeleteBtn);
	}

	public boolean verifyDeletedLead() {
		clickOnElement(leadHeaderLink);
		try {
			return !(newlyCreatedLeadName.isDisplayed());
		} catch (NoSuchElementException e) {
			return true;
		}

	}

}
