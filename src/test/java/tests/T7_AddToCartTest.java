package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class T7_AddToCartTest extends T0_BaseTest {

    CartPage cartObject;

    String quantity = "4",
            addedProductMsg= "The product has been added to your shopping cart",
            emptyMsg="Your Shopping Cart is empty!";

    @Test
    public void userAddProductToCart() {
        cartObject = new CartPage(driver);
        cartObject.addProductToCart();
        Assert.assertTrue(cartObject.aAddedProduct.contains(addedProductMsg));
    }

    @Test
    public void userEditShoppingCart() {
        cartObject = new CartPage(driver);
        cartObject.editShoppingCart(quantity);
        Assert.assertTrue(cartObject.aEmptyCartMsg.contains(emptyMsg));
    }


}
