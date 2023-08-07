package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage{
    public OrderPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "a[href=\"/cart\"]")
    WebElement openCart;
    @FindBy(id="termsofservice")
    WebElement acceptTerms;
    @FindBy(id="checkout")
    WebElement checkout;
    @FindBy(id="BillingNewAddress_CountryId")
    WebElement countryField;
    @FindBy(id="BillingNewAddress_City")
    WebElement cityField;
    @FindBy(id="BillingNewAddress_Address1")
    WebElement addressField;
    @FindBy(id="BillingNewAddress_ZipPostalCode")
    WebElement zipCodeField;
    @FindBy(id="BillingNewAddress_PhoneNumber")
    WebElement phoneField;
    @FindBy(xpath="//button[@class=\"button-1 new-address-next-step-button\"]")
    WebElement addressBtn;
    @FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/button")
    WebElement shippingMethod;
    @FindBy(xpath="//div/button[@class=\"button-1 payment-method-next-step-button\"] ")
    WebElement paymentMethod;
    @FindBy(xpath="//div/button[@class=\"button-1 payment-info-next-step-button\"]")
    WebElement paymentInfo;
    @FindBy(xpath="//div/button[@class=\"button-1 confirm-order-next-step-button\"]")
    WebElement confirmOrder;
    @FindBy(css="div[class=\"section order-completed\"]")
    WebElement orderCreated;
    public String aOrderCreatedMsg;


    public void manageCart (){
        openCart.click();
        acceptTerms.click();
        checkout.click();
    }

    public void manageAddress (String country, String city, String address, String zipCode, String phone){
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        addressField.sendKeys(address);
        zipCodeField.sendKeys(zipCode);
        phoneField.sendKeys(phone);
        addressBtn.click();
    }

  public void confirmOrder() {
        shippingMethod.click();
        paymentMethod.click();
        paymentInfo.click();
        confirmOrder.click();
        aOrderCreatedMsg = orderCreated.getText();
    }

}