package com.OrangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.SeleniumUtility;

public class OrangeHrmLoginPage extends SeleniumUtility {
	@FindBy(name = "username")
	private WebElement userInputField;

	@FindBy(name = "password")
	private WebElement pwdInputField;

	@FindBy(css = "button[type='submit']")
	private WebElement singInBtn;

	public void enterUserNameAndPassword(String userName, String pwd) {
		typeInput(userInputField, userName);
		typeInput(pwdInputField, pwd);
	}

	public void clickOnTheLoginBtn() {
		clickOnElement(singInBtn);
	}
}
