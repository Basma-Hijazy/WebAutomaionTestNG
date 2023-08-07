package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-female")
    WebElement genderRadio;

    @FindBy(id="FirstName")
    WebElement firstNameField;

    @FindBy(id="LastName")
    WebElement lastNameField;

    @FindBy(id="Email")
    WebElement emailField;

    @FindBy(id="Password")
    WebElement passwordField;

    @FindBy(id="ConfirmPassword")
    WebElement confirmPasswordField;

    @FindBy(id="register-button")
    WebElement registerBtn;

    @FindBy(className="result")
    WebElement successMsg;

    @FindBy(id="Email-error")
    WebElement errorMsg;

    @FindBy(xpath = "//form/div[1]/ul/li")//css= "div[class='message-error.validation-summary-errors']")//"message-error.validation-summary-errors")
    WebElement existingEmailMsg;
    public String aSuccessMsg,aErrorMsg,aExistingEmailMsg;
    public void registrationWithValidData (String fName,String lName, String mail,String pass){
        genderRadio.click();
        firstNameField.sendKeys(fName);
        lastNameField.sendKeys(lName);
        emailField.sendKeys(mail);
        passwordField.sendKeys(pass);
        confirmPasswordField.sendKeys(pass);
        registerBtn.click();
        aSuccessMsg = successMsg.getText();

    }
    public void registrationWithExistingEmail (String fName,String lName, String mail,String pass) {
        genderRadio.click();
        firstNameField.sendKeys(fName);
        lastNameField.sendKeys(lName);
        emailField.sendKeys(mail);
        passwordField.sendKeys(pass);
        confirmPasswordField.sendKeys(pass);
        registerBtn.click();
        aExistingEmailMsg = existingEmailMsg.getText();


    }
    public void registrationWithInvalidEmail (String fName,String lName, String mail,String pass){
        clearTxtElement(emailField);
        firstNameField.sendKeys(fName);
        lastNameField.sendKeys(lName);
        emailField.sendKeys(mail);
        passwordField.sendKeys(pass);
        confirmPasswordField.sendKeys(pass);
        registerBtn.click();
        aErrorMsg = errorMsg.getText();

    }

}
