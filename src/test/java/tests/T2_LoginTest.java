package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class T2_LoginTest extends T0_BaseTest {
    HomePage homeObject ;
    LoginPage loginObject;
    T1_RegistrationTest registrationObj = new T1_RegistrationTest();
    String logoutTxt="Log out";
    String wrongPassword = "basma";
    String loginErrorMsg = "Login was unsuccessful. Please correct the errors and try again.";


    @Test
    public void userClickOnLogin(){
        homeObject = new HomePage(driver);
        homeObject.openLoginPage();
    }

    @Test (priority = 1)
    public void userLoginWithValidData() {
        loginObject = new LoginPage(driver);
        loginObject.loginWithValidData(registrationObj.email,registrationObj.password);
        Assert.assertEquals(loginObject.aLogout,logoutTxt);
    }
    @Test (priority = 2)
    public void userLogout() {
        loginObject = new LoginPage(driver);
        loginObject.logout();
    }
    @Test (priority = 3)
    public void userLoginWithInvalidPass() {
        loginObject = new LoginPage(driver);
        homeObject.openLoginPage();
        loginObject.loginWithInvalidPass(registrationObj.email,wrongPassword);
        Assert.assertTrue(loginObject.aErrorMsg.contains(loginErrorMsg),"Error in the assertion");
    }

}
