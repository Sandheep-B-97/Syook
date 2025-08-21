package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("I open the Bugbash login page")
    public void i_open_the_bugbash_login_page() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @When("I enter email as {string} and password as {string}")
    public void i_enter_email_as_and_password_as(String email, String password) {
        loginPage.enterCredentials(email, password);
    }

    @And("I click on login button")
    public void i_click_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the dashboard")
    public void i_should_see_the_dashboard() {
        Assert.assertTrue("Dashboard is not displayed!", loginPage.isDashboardDisplayed());
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMessage) {
        Assert.assertEquals("Error message mismatch!", expectedMessage, loginPage.getEmailErrorMessage());
    }
}
