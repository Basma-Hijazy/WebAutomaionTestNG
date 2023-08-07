package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy( css="a[class=\"ico-account\"]")
    WebElement goToAccount;
    @FindBy(css="a[href=\"/customer/changepassword\"]")
    WebElement changePass;
    @FindBy(id="OldPassword")
    WebElement oldPassField;
    @FindBy(id = "NewPassword")
    WebElement newPassField;
    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmPassField;
    @FindBy(css="button[class=\"button-1 change-password-button\"]")
    WebElement changePassBtn;
    @FindBy(css="p[class=\"content\"]")
    WebElement changePassSuccessfullyMsg;
    public String aChangePassMsg;

    public void openAccountPage(){
        goToAccount.click();
        changePass.click();
    }
    public void changePassWithValidData (String oldPass, String newPass){

        oldPassField.sendKeys(oldPass);
        newPassField.sendKeys(newPass);
        confirmPassField.sendKeys(newPass);
        changePassBtn.sendKeys(Keys.ENTER);
        aChangePassMsg = changePassSuccessfullyMsg.getText();
    }
}
