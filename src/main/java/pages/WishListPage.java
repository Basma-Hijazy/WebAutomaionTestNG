package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WishListPage extends BasePage {
    public WishListPage(WebDriver driver) {
        super(driver);
    }


    public String aWishListMsg;

    @FindBy(xpath = "//div[6]/div[1]/div[2]/div[1]/a/img")
    WebElement goToHome;
    @FindBy(xpath = "//div[3]/div/div[2]/div[3]/div[2]/button[3]")
    WebElement wishlistBtn;
    @FindBy(css = "p[class=\"content\"]")
    WebElement productAddedToWishlist;


    public void addProductToWishList(){
        goToHome.click();
        wishlistBtn.click();
        aWishListMsg = productAddedToWishlist.getText();
    }
}
