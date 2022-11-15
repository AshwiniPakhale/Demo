package stepdefinations;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.VTigerLeadBackgroundEx.VTigerHomePage;
import com.VTigerLeadBackgroundEx.VTigerLeadPage;
import com.VTigerLeadBackgroundEx.VTigerLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.SeleniumUtility;

public class VTigerLeadBackgrounExample extends SeleniumUtility {

	WebDriver driver;
	VTigerLoginPage vtLogin = null;
	VTigerHomePage vtHome = null;
	VTigerLeadPage vtLead = null;
	Logger log;

	@Given("user already in login page")
	public void user_already_in_login_page() {
		//System.out.println("Background started");
		log = initializerLogger();
		log.info("..........user_already_in_login_page(),Started..........");
		driver = setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");
		if(driver == null)
		{
			log.error("WebDriver not initialize");
		}
		else
		{
			log.info("WebDriver initialized, Chrome browser open");	
			
		}
		vtLogin = new VTigerLoginPage(driver);
		vtHome = new VTigerHomePage(driver);
		vtLead = new VTigerLeadPage(driver);
	}

	@Given("user login successfully with valid data")
	public void user_login_successfully_with_valid_data() {
		log.info("...........user login successfully with valid data(), Started.............");
		vtLogin.login("Admin", "Test@123");
		log.info("User login Successfully");
		
	}

	@Given("click on navigation bar")
	public void click_on_navigation_bar() {
		log.info("..............click on navigation bar(), Started...........");
		vtHome.openTheNavigation();
		log.info("User click on nevigation bar");
	}

	@Given("go to Marketing and select Leads")
	public void go_to_marketing_and_select_leads() {
		vtHome.openMarketingAndSelectLead();
	}

	@When("click on Add Leads button and enter firstname as {string} ,last as {string} ,company as {string} and click on save button")
	public void click_on_add_leads_button_and_enter_firstname_as_last_as_company_as_and_click_on_save_button(
			String firstName, String lastName, String companyName) {
		log.info(".........User perform correct opeation.........");
		vtLead.createLead(firstName, lastName, companyName);
	}

	@When("click on All link")
	public void click_on_all_link() {
		log.info("..........user click on link.........");
		vtLead.clickOnAllBtn();
	}

	@Then("varify lead is created with {string}")
	public void varify_lead_is_created_with(String string) {
		log.info("...........User verifies lead is created......");
		Assert.assertTrue(vtLead.verifyCreatedLead());
	}

	@When("click on select all leads checkbox")
	public void click_on_select_all_leads_checkbox() {
		log.info("..........Use click check box..........");
		vtLead.selectAllCreatedLeads();
	}

	@When("click on delete logo")
	public void click_on_delete_logo() {
		log.info("........User click delete button logo...........");
		vtLead.clickOnDeleteBtn();
		//Assert.assertTrue(false); 
	}

	@When("user will get a popup to comfirm deletion, select Yes")
	public void user_will_get_a_popup_to_comfirm_deletion_select_yes() {
		log.info("..........User delete all leads...........");
		vtLead.clickOnConfirmDeleteBtn();
	}

	@Then("varify that all leads deleted")
	public void varify_that_all_leads_deleted() {
		log.info(".......User confirms delete operation..........");
		Assert.assertTrue(vtLead.verifyDeletedLead());
	}

	@Then("close the Vtiger application browser")
	public void close_the_vtiger_application_browser() {
		log.info("..........User logout and close the browser.......");
		vtHome.logout();
		cleanUp();
	}
}
