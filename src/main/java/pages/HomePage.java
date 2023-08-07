package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registerButton;
    public void openRegistrationPage() {
        registerButton.click();
    }

    @FindBy(linkText = "Log in")
    WebElement Login;
    public void openLoginPage() {
        Login.click();
    }




}

