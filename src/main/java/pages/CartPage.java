package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy( xpath= "//div[1]/a/img")
    WebElement navigateHomePageByLogo;
    @FindBy( linkText= "Apple MacBook Pro 13-inch")
    WebElement openProduct;
    @FindBy( id="add-to-cart-button-4")
    WebElement addProduct;
    @FindBy( css = "p[class=\"content\"]")
    WebElement addedSuccessfully;
    @FindBy( css = "a[href=\"/cart\"]")
    WebElement openCart;
    @FindBy( xpath = "//td[@class=\"quantity\"]/input[@class=\"qty-input\"] ")
    WebElement changeQuantity;
    @FindBy( xpath= "//table[@class=\"cart\"]/tbody/tr/td[@class=\"remove-from-cart\"]/button")
    WebElement delete;
    @FindBy( css = "div[class=\"no-data\"]")
    WebElement emptyCart;
    public String aAddedProduct,aEmptyCartMsg ;
    public void addProductToCart (){
        navigateHomePageByLogo.click();
        openProduct.click();
        addProduct.click();
        aAddedProduct = addedSuccessfully.getText();
    }

    public void editShoppingCart (String quantity){
        openCart.click();
        changeQuantity.clear();
        changeQuantity.click();
        changeQuantity.sendKeys(quantity);
        delete.click();
        aEmptyCartMsg = emptyCart.getText();
    }
}
