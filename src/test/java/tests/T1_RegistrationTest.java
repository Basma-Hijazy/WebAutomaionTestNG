package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class T1_RegistrationTest extends T0_BaseTest{
    HomePage homeObject ;
    RegistrationPage regisPageObject;
    public String firstName = "Basma";
    public String lastName = "Hijazy";
    public String email = "basma@gmail.com";
    public String password = "BasmaM";
    public String newPassword = "basmaM";
    public String wrongEmail = "bbb.com";
    String registerSuccessMsg="Your registration completed";
    String registerEmailErrorMsg="Wrong email";
    String existingEmail ="The specified email already exists";


    @Test
    public void userClickOnRegistration(){
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
    }

    @Test(priority = 1)
    public void userRegisterWithValidData(){
        regisPageObject = new RegistrationPage(driver);
        regisPageObject.registrationWithValidData(firstName,lastName,email,password);
        Assert.assertEquals(regisPageObject.aSuccessMsg,registerSuccessMsg);

    }

    @Test (priority = 2)
    public void userRegisterWithExistingEmail() {
        regisPageObject = new RegistrationPage(driver);
        homeObject.openRegistrationPage();
        regisPageObject.registrationWithExistingEmail(firstName,lastName,email,password);
        Assert.assertTrue(regisPageObject.aExistingEmailMsg.contains(existingEmail),"Error: email already exists");
    }

    @Test (priority = 3)
    public void userRegisterWithInvalidEmail() {
        regisPageObject = new RegistrationPage(driver);
        homeObject.openRegistrationPage();
        regisPageObject.registrationWithInvalidEmail(firstName,lastName,wrongEmail,password);
        Assert.assertEquals(regisPageObject.aErrorMsg,registerEmailErrorMsg);
    }

}
