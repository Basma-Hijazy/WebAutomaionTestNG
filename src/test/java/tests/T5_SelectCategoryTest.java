package tests;

import org.testng.annotations.Test;
import pages.CategoriesPage;

public class T5_SelectCategoryTest extends T0_BaseTest{
    CategoriesPage categoryObject;
    String k1="Computers", k2 = "Electronics",k3="Apparel";



    @Test(priority = 1)
    public void userChooseCategory() {
        categoryObject = new CategoriesPage(driver);
        categoryObject.chooseCategory();

    }

    @Test(priority = 2)
    public void userChooseSubCategory()  {
        categoryObject = new CategoriesPage(driver);
        categoryObject.chooseSubCategory();
    }

    @Test(priority = 3)
    public void userSelectTags() {
        categoryObject = new CategoriesPage(driver);
        categoryObject.selectTags();
    }

}
