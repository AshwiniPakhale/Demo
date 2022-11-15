package stepdefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.OrangeHRM.OrangeHrmHomePage;
import com.OrangeHRM.OrangeHrmLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.SeleniumUtility;

public class OrangeHrmLogin extends SeleniumUtility {

	WebDriver driver;
	OrangeHrmLoginPage ohLogin = null;
	OrangeHrmHomePage ohHome = null;
	String excelFilepath = "./src/main/resources/ApplicationData.xlsx";
	String browser, appUrl, userName, password;


	@Given("User open the browser and open the application")
	public void user_open_the_browser_and_open_the_application() {
		driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		ohLogin = PageFactory.initElements(driver, OrangeHrmLoginPage.class);
		ohHome = new OrangeHrmHomePage(driver);   
	}

	@When("User enters the username and password")
	public void user_enters_the_username_and_password() {
	    ohLogin.enterUserNameAndPassword("Admin", "admin123");
	   
	}

	@When("User click on the login button")
	public void user_click_on_the_login_button() {
		ohLogin.clickOnTheLoginBtn();   
	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {
		Assert.assertTrue(ohHome.getProfileBtn().isDisplayed());    
	}

	@Then("User logout and close the browser")
	public void user_logout_and_close_the_browser() {
		ohHome.logout();
		cleanUp();    
	}
	
	//@Given("application url is on {string} sheet and row no is {int}")
	public void application_url_is_on_sheet_and_row_no_is(String sheetName, Integer rownum) throws IOException {
	   getCellData(excelFilepath, sheetName, rownum, 0);
	   getCellData(excelFilepath, sheetName, rownum, 1);
	   
	}

	//@Given("login credentials is on {string} sheet and row no is {int}")
	public void login_credentials_is_on_sheet_and_row_no_is(String sheetName, Integer rownum) throws IOException {
		userName = getCellData(excelFilepath, sheetName, rownum, 2);
		password = getCellData(excelFilepath, sheetName, rownum, 3);
	}

	//@Given("user open the browser and application as per sheet data")
	public void user_open_the_browser_and_application_as_per_sheet_data() {
		driver = setUp(browser, appUrl);
		ohLogin = PageFactory.initElements(driver, OrangeHrmLoginPage.class);
		ohHome = new OrangeHrmHomePage(driver);  
	}

//	@When("user enters the username and password as per sheet data")
	public void user_enters_the_username_and_password_as_per_sheet_data() {
		ohLogin.enterUserNameAndPassword(userName, password);
	}


	
}