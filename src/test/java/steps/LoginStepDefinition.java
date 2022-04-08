    package steps;

    import org.openqa.selenium.support.PageFactory;
    import cucumber.api.java.After;
    import cucumber.api.java.Before;
    import cucumber.api.java.en.Given;
    import cucumber.api.java.en.Then;
    import cucumber.api.java.en.When;
    import junit.framework.Assert;
    import pages.DataBasePage;
    import pages.LoginPage;
    import pages.TestBase;

    public class LoginStepDefinition extends TestBase {
    DataBasePage dataBasePage;
	LoginPage loginpage;

	@Before
	public void beforeRun() {
	initDriver();
	loginpage = PageFactory.initElements(driver, LoginPage.class);
	dataBasePage = new DataBasePage();
	}

	@Given("^User is on Techfios login page$")
	public void user_is_on_techfios_login_page() {
	initDriver();
	driver.get("https://techfios.com/billing/?ng=admin/");
	}

	@When("^User enters username as \"([^\"]*)\"$")
	public void user_enters_username_as(String username) {
	loginpage = PageFactory.initElements(driver, LoginPage.class);
    loginpage.enterUserName(username); 
	}
	@When("^User enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String password) {
	loginpage.enterPassword(password);
	
	}

	@When("^User clicks signin button$")
	public void user_clicks_signin_button() {
	loginpage.clickSignInButton();
  }
	@Then("^User should land on dashboard page$")
    public void user_should_land_on_dashboard_page()  {
	Assert.assertEquals("Dashboard- iBilling", LoginPage.getPageTitle());
	takeScreenshot(driver);	
	}
	@When("^User enters \"([^\"]*)\" from database$")
	 public void user_enters_from_database(String loginData)  {

	 switch (loginData) {
	  case "username":
	   loginpage.enterUserName(dataBasePage.getData("username"));
	   System.out.println("Username from DB: "+ dataBasePage.getData("username"));
	   break;
	  case "password":
	   loginpage.enterPassword(dataBasePage.getData("password"));
	   System.out.println("Password from DB: "+ dataBasePage.getData("password"));
	   break;

	  default:
	   System.out.println("Unable to extract login data " + loginData + "from DB");
	  
	  }  
	 }
	 @After
	 public void tearDown() {
	 driver.close();
	 driver.quit();
	}
}
