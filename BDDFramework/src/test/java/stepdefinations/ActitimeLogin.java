package stepdefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Actitime.ActitimeHomePage;
import com.Actitime.ActitimeLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.SeleniumUtility;

public class ActitimeLogin extends SeleniumUtility{
	WebDriver driver;
	ActitimeLoginPage alPage = null;
	ActitimeHomePage aHomePage = null;
	
	@Given("Open the browser and Enter correct Url")
	public void open_the_browser_and_enter_correct_url() {
	
	    driver = setUp("chrome", "https://demo.actitime.com/login.do"); 
	   // alPage = PageFactory.initElements(driver, ActitimeLoginPage.class);
	    alPage = new ActitimeLoginPage(driver);
	    aHomePage = new ActitimeHomePage(driver);
	}

	@When("user enter correct username")
	public void user_enter_correct_username() {
		alPage.enterUsernme("admin");
	}

	@When("correct password and click on login button")
	public void correct_password_and_click_on_login_button() {
		alPage.enterPassword("manager");
		alPage.clickOnLoginBtn();
	}

	@Then("user should login succesfully")
	public void user_should_login_succesfully() {
	    //Assert.assertTrue(aHomePage.getLogo().isDisplayed());
		//Assert.assertEquals(driver.getTitle(), "actiTIME -  Enter Time-Track", "Title not Matched");
		//verifyUTElementDisplayed(alHome.getLogo());
		getCurrentPageTitle("actiTIME - Enter Time-Track");
		
	}

	@Then("user logout and close the browser")
	public void user_logout_and_close_the_browser() {
		aHomePage.logout();
		cleanUp();
	}


}
