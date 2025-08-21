package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")   // check DOM for correct attribute if needed
    WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    WebElement signInButton;

    @FindBy(id = "notification")
    WebElement emailErrorMessage;

    @FindBy(xpath = "//h1[contains(text(),'ShopHub Pro')]") // adjust for unique element on dashboard
    WebElement dashboardElement;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://bugbash.syook.com/");
    }

  
    public void enterCredentials(String email, String password) {
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

   
    public void clickLoginButton() {
        signInButton.click();
    }

    public boolean isDashboardDisplayed() {
        return dashboardElement.isDisplayed();
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }
}
