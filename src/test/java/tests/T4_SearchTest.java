package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class T4_SearchTest extends T0_BaseTest{

    SearchPage searchObject;
    String searchKey ="cam";
    int advancedSearchKey = 6;


    @Test
    public void userSearchOnProduct() {
        searchObject = new SearchPage(driver);
        searchObject.searchOnProduct(searchKey);
        Assert.assertTrue(searchObject.assertT(searchKey));
    }

    @Test (dependsOnMethods = {"userSearchOnProduct"})
    public void userApplyAdvancedSearch() {
        searchObject = new SearchPage(driver);
        searchObject.applyAdvancedSearch(advancedSearchKey);
    }

}
