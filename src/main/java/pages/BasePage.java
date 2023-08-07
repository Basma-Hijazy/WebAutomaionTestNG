package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver ;
    public Actions actions ;
    public void hoverOnElement(WebElement element){
        actions= new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    public BasePage(WebDriver driver ){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    protected static void clearTxtElement(WebElement element){
        element.clear();
    }



}
