package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class CategoriesPage extends BasePage{
    public CategoriesPage(WebDriver driver) {
        super(driver);
    }
    BasePage baseObject;

    @FindBy( xpath = "//div[2]/ul[1]/li[1]/a")
    WebElement computers ;
    @FindBy( xpath = "//div[2]/ul[1]/li[2]/a")
    WebElement electronics ;
    @FindBy( xpath = "//div[2]/ul[1]/li[3]/a")
    WebElement apparel ;
    @FindBy( xpath = "//div[2]/ul[1]/li[4]/a")
    WebElement digitalDownloads ;
    @FindBy( xpath = "//div[2]/ul[1]/li[5]/a")
    WebElement books ;
    @FindBy( xpath = "//div[2]/ul[1]/li[6]/a")
    WebElement jewelry ;
    @FindBy( xpath = "//div[2]/ul[1]/li[7]/a")
    WebElement giftCards  ;
    @FindBy(linkText = "Computers")
    WebElement computerSubCategory;
    @FindBy(linkText = "Electronics")
    WebElement electronicsSubCategory;
     @FindBy(linkText = "Apparel")
     WebElement apparelSubCategory;
    @FindBy(linkText = "Desktops")
    WebElement desktop;
    @FindBy(linkText = "Others")
    WebElement others;
    @FindBy(linkText = "Clothing")
    WebElement clothing;
    @FindBys( @FindBy(xpath = "//div[4]/div[2]/div[1]"))
    List<WebElement> selectTag;

    public void chooseCategory() {
        computers.click();
        electronics.click();
        apparel.click();
        digitalDownloads.click();
        books.click();
        jewelry.click();
        giftCards.click();

    }

    public void chooseSubCategory()  {
        baseObject = new BasePage(driver);
        baseObject.hoverOnElement(computerSubCategory);
         desktop.click();
        baseObject.hoverOnElement(electronicsSubCategory);
        others.click();
        baseObject.hoverOnElement(apparelSubCategory);
        clothing.click();
    }

    public void selectTags(){

        int maxProducts = selectTag.size();
        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
        selectTag.get(randomProduct).click();
    }


}
