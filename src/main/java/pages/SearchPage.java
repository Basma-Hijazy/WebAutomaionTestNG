package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy( id = "small-searchterms")
    WebElement searchField;
    @FindBy( css = "button[class=\"button-1 search-box-button\"]")
    WebElement searchBtn;

    int count;
    private By result=  By.cssSelector("h2[class=\"product-title\"] a");
    public  int resultSize() {
        count = driver.findElements(result).size();
        return count;
    }
    public  boolean assertT(String searchKey) {
        boolean temp = true;
        for (int x = 0; x < count; x++) {
            temp = driver.findElements(result).get(x).getText().toLowerCase().contains(searchKey);
        }
        return temp;
    }

    @FindBy( xpath = "//div/input[@id=\"advs\"]")
    WebElement advancedSearch;
    @FindBy( xpath = "//div/select[@id=\"cid\"]")
    WebElement chooseCategory;
    @FindBy( xpath = "//div/select[@id=\"mid\"]")
    WebElement chooseManufacturer;
    @FindBy( css = "button[class=\"button-1 search-button\"]")
    WebElement advanceBtn;


    public void searchOnProduct (String searchKey){
        searchField.click();
        searchField.sendKeys(searchKey);
        searchBtn.click();
        resultSize();
    }
    public void applyAdvancedSearch (int advancedK){
        advancedSearch.click();
        chooseCategory.click();
        Select sel = new Select(chooseCategory);
        sel.selectByIndex(advancedK);
        advanceBtn.click();


    }
}
