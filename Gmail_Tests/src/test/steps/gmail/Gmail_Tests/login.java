package gmail.Gmail_Tests;

import org.testng.Assert;
import gmail.Gmail_PageObjects.GmailInboxPage;
import gmail.Gmail_PageObjects.GmailLoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login extends GmailInboxPage{
	
	String to = "testuser@gmail.com";
	String subject = "This is a test mail composed";
	String mail = "This is a test mail composed to check the functionality of saving drafts";
	
	@Before("~@Login")
	public void BeforeMethod(){
		String URL = "http://www.gmail.com";
		launchApp(URL);
		Login("rtestuserlogin","rtestuser");
	}
	
	@Given("^I am in the gmail account page$")
	public void I_am_in_the_gmail_account_page() throws Throwable {
		String URL = "http://www.gmail.com";
		launchApp(URL);
	}

	@When("^I enter the valid username as \"([^\"]*)\"$")
	public void I_enter_the_valid_username_as(String userName) throws Throwable {
		enterUserName(userName);
	}

	@When("^I enter the valid password as \"([^\"]*)\"$")
	public void I_enter_the_valid_password_as(String passWord) throws Throwable {
		enterPassWord(passWord);
	}

	@When("^I click on the Sign in button$")
	public void I_click_on_the_Sign_in_button() throws Throwable {
		clickSignIn();
	}

	@Then("^I should be able to login to my gmail account$")
	public void I_should_be_able_to_login_to_my_gmail_account() throws Throwable {
		Assert.assertEquals(isMailBox(),true,"User Not Logged Into The Account");
	}

	@Given("^I am logged into my gmail account$")
	public void I_am_logged_into_my_gmail_account() throws Throwable {
		Assert.assertEquals(isMailBox(),true,"User Not Logged Into The Account");
	}

	@When("^I click on the sign out button$")
	public void I_click_on_the_sign_out_button() throws Throwable {
	    clickSignOut();
	}

	@Then("^I should be able to log out of my account$")
	public void I_should_be_able_to_log_out_of_my_account() throws Throwable {
	    Assert.assertEquals(isLoginPage(),true,"User Unable To Logout Of The Mail Account");
	}

	@When("^I click on the Compose button$")
	public void I_click_on_the_Compose_button() throws Throwable {
	    clickCompose();
	}

	@When("^I compose a mail$")
	public void I_compose_a_mail() throws Throwable {
	    composeMail(to, subject,mail);
	}

	@When("^I close the composed mail$")
	public void I_close_the_composed_mail() throws Throwable {
	    closeMail();
	}

	@When("^I navigate to drafts$")
	public void I_navigate_to_drafts() throws Throwable {
	    navigateToDrafts();
	}

	@Then("^I should be able to see tha mail in the drafts folder$")
	public void I_should_be_able_to_see_tha_mail_in_the_drafts_folder() throws Throwable {
	    Assert.assertEquals(isMailSavedAsDraft(), true,"Composed Mail Is Not Saved In Drafts");
	}
	
	@After()
	public void AfterMethod(){
		clearSession();
	}
}
