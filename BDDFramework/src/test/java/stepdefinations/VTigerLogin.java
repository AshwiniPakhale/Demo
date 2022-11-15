package stepdefinations;

import org.openqa.selenium.WebDriver;

import com.VTiger.VTigerHomePage;
import com.VTiger.VTigerLeadPage;
import com.VTiger.VTigerLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.SeleniumUtility;

public class VTigerLogin extends SeleniumUtility {
	
	WebDriver driver;
	VTigerLoginPage vLoginPage = null;
	VTigerHomePage vHomePage = null;
	VTigerLeadPage vLeadPage = null;

	@Given("user open browser and open application")
	public void user_open_browser_and_open_application() {
		driver = setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");
		vLoginPage = new VTigerLoginPage(driver);
		vHomePage = new VTigerHomePage(driver);
		vLeadPage = new VTigerLeadPage(driver);
	}

	@When("user enter username and password")
	public void user_enter_username_and_password() {
		vLoginPage.login("admin", "Test@123");
	}

	@When("click on login button")
	public void click_on_login_button() {
		vLoginPage.clickLoginBtn();
	}
	

	@When("user should click on burgur manu")
	public void user_should_click_on_burgur_manu() {
		vHomePage.burgurManu();
	}

	@When("user should click on markeing optionn")
	public void user_should_click_on_markeing_optionn() {
		vHomePage.marketingManu();
	}

	@When("user should click on lead option")
	public void user_should_click_on_lead_option() {
		vHomePage.leadsOption();
	}

	@When("user should create lead")
	public void user_should_create_lead() {
		vLeadPage.createLead("java", "developer", "Automation");
	}

	@Then("user should verify create lead and")
	public void user_should_verify_create_lead_and() {
		vLeadPage.verifyCreatedLead();
	}	

	@Then("delete created lead")
	public void delete_created_lead() {
		vLeadPage.deleteCreatedLead(); 
	}
	
	@Then("logout and close browser")
	public void logout_and_close_browser() {
		vLeadPage.logout();
		cleanUp();
	}


}
