package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class T3_ResetPasswordTest extends T0_BaseTest{

    MyAccountPage accountObject;
    T1_RegistrationTest registrationObj = new T1_RegistrationTest();
    String newPassword = "basmaM";
    String resetPassResult="Password was changed";


    HomePage homeObject ;
    LoginPage loginObject;
    String logoutTxt="Log out";


    @Test (priority = 1)
    public void userLoginWithValidData() {
        homeObject = new HomePage(driver);
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.loginWithValidData(registrationObj.email, registrationObj.password);
        Assert.assertEquals(loginObject.aLogout, logoutTxt);
    }


    @Test(priority = 2)
    public void userNavigateToAccountPage(){
        accountObject = new MyAccountPage(driver);
        accountObject.openAccountPage();
    }

    @Test(priority = 3)
    public void userChangePassWithValidData(){
        accountObject = new MyAccountPage(driver);
        accountObject.changePassWithValidData(registrationObj.password,newPassword);
        Assert.assertTrue(accountObject.aChangePassMsg.contains(resetPassResult), "Error in change password");
    }

}
