package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderPage;

public class T8_CreateOrderTest extends T0_BaseTest{
    OrderPage orderObject;
    CartPage cartObject;
    static Faker faker = new Faker();   // to generates fake data
    String addedProductMsg= "The product has been added to your shopping cart";
    String orderCreatedMsg = "Your order has been successfully processed!";
    String country= faker.address().country();
    String city= faker.address().city();
    String address= faker.address().streetAddress();
    String zipCode= faker.address().zipCode();
    String phone= faker.phoneNumber().phoneNumber();

    HomePage homeObject ;
    LoginPage loginObject;
    T1_RegistrationTest registrationObj = new T1_RegistrationTest();
    String logoutTxt="Log out";


    @Test(priority = 1)
    public void userChooseProduct() {
        cartObject = new CartPage(driver);
        cartObject.addProductToCart();
        Assert.assertTrue(cartObject.aAddedProduct.contains(addedProductMsg));

    }

    @Test (priority = 2)
    public void userLoginWithValidData() {
        orderObject = new OrderPage(driver);
        orderObject.manageCart();
        loginObject = new LoginPage(driver);
        loginObject.loginWithValidData(registrationObj.email, registrationObj.newPassword);
        Assert.assertEquals(loginObject.aLogout, logoutTxt);
    }
    @Test(priority = 3)
    public void userManageCart () {
        orderObject = new OrderPage(driver);
        orderObject.manageCart();
    }
    @Test(priority = 4)
    public void userManageAddress() {
        orderObject = new OrderPage(driver);
        orderObject.manageAddress(country, city, address, zipCode, phone);
    }
    @Test(priority = 5)
    public void userConfirmOrder () {
        orderObject = new OrderPage(driver);
        orderObject.confirmOrder();
        Assert.assertTrue(orderObject.aOrderCreatedMsg.contains(orderCreatedMsg));
    }
}
