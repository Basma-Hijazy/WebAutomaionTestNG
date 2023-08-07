package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WishListPage;


public class T6_AddToWishListTest extends T0_BaseTest{
    WishListPage wishListObject;
    String productAddedToWishListMsg = "The product has been added to your wishlist";

    @Test
    public void userAddProductToWishList() {
        wishListObject = new WishListPage(driver);
        wishListObject.addProductToWishList();
        Assert.assertTrue(wishListObject.aWishListMsg.contains(productAddedToWishListMsg),"Assertion Error: product doesn't added to wishList");
    }
}
