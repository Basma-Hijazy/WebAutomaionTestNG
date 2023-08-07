package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class T0_BaseTest {

    WebDriver driver = null;

    @BeforeClass
    public void openBrowser() throws InterruptedException {

        //1 bridge between test scripts and browser
        String chromeBath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";//the best way to reach the bath if any change happen to the user name.
        System.setProperty("webdriver.chrome.driver",chromeBath);
        //2 choose the browser
        driver = new ChromeDriver();
        //manage the browser
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    //the amount of time the driver should wait when searching for an element if it is not immediately present
        driver.manage().window().maximize();
        Thread.sleep(1500);
        //3 navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {

        //4 close the browser (from backend also)
        Thread.sleep(300);
        driver.quit();

    }


}
