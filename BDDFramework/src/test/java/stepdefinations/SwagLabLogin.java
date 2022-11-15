package stepdefinations;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.SwagLab.SwagLabHomePage;
import com.SwagLab.SwagLabLoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.SeleniumUtility;

public class SwagLabLogin extends SeleniumUtility {
	
	WebDriver driver;
	SwagLabLoginPage swagLogin = null;
	SwagLabHomePage swagHome = null;
	static Properties prop;
	
	
	@Given("user is on swaglab login page")
	public void user_is_on_swaglab_login_page() {
		driver = setUp("chrome", "https://www.saucedemo.com/");
		swagLogin = new SwagLabLoginPage(driver);	
		swagHome = new SwagLabHomePage(driver);
	   
	}

	@Given("user enters the following inputs")
	public void user_enters_the_followini_inputs(DataTable dataTable) {
		List<List<String>> userData = dataTable.asLists(String.class);
		List<String> firstUser = userData.get(0);
		swagLogin.swagLabEnterUserNameAndPwd(firstUser.get(0), firstUser.get(1));
		System.out.println("......."+ userData +"........");    
	}

	@Given("clicks on login button")
	public void clicks_on_login_button() {
		swagLogin.swagLabClickOnLoginBtn();
	   
	}

	@Then("user should be login")
	public void user_should_be_login() {
	   Assert.assertTrue(swagHome.getHomePageAppLogo().isDisplayed());
	}
	
	//@Given("User open the browser and open the swaglab")
	public void user_open_the_browser_and_open_the_swag_lab() {
	    prop = setUpPropertiesFileStream("./src/main/resources/SwagLabData.properties");		         
	    String browser = readPropertiesFileData("Browser");
	    String appUrl = readPropertiesFileData("AppUrl");
	    driver = setUp(browser, appUrl);
	    swagLogin = PageFactory.initElements(driver, SwagLabLoginPage.class);
	    swagHome = PageFactory.initElements(driver, SwagLabHomePage.class);
	    
	}
	
	// @When("user enters username and password")
	public void user_enters_username_and_password() {
	  String userName = readPropertiesFileData("Username");
	  String passWord = readPropertiesFileData("Password");
	  swagLogin.swagLabEnterUserNameAndPwd(userName, passWord);
	}


	@Then("close the browser")
	public void close_the_browser() {
	  cleanUp();
	}



}
