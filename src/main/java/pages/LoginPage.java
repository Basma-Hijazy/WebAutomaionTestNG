package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="Email")
    WebElement emailField;
    @FindBy(id="Password")
    WebElement passwordField;
    @FindBy(xpath = "//div[2]/div[1]/div[2]/form/div[3]/button")
    WebElement loginBtn;

    @FindBy(className="ico-logout")
    WebElement logout;

    @FindBy(xpath="//div[2]/form/div[1]")
    WebElement errorMsg;

    public String aLogout,aErrorMsg;
    public void loginWithValidData (String mail,String pass){
        emailField.sendKeys(mail);
        passwordField.sendKeys(pass);
        loginBtn.sendKeys(Keys.ENTER);
        aLogout = logout.getText();
    }
    public void logout (){
        logout.click();
    }
    public void loginWithInvalidPass (String mail,String pass){
        emailField.clear();
        passwordField.clear();
        emailField.sendKeys(mail);
        passwordField.sendKeys(pass);
        loginBtn.submit();
        aErrorMsg = errorMsg.getText();
    }
}