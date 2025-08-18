package positive_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Filter_Page;
import pages.Search_Page;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class NASA_Search_Results_Advanced_Filtering_and_Cleaning_Test {
    Search_Page search_page;
    Filter_Page filter_page;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void SetUp() {
        Driver.getDriver().get(url);
        search_page = new Search_Page();
        filter_page = new Filter_Page();
    }

    @Test
    public void NASA_Search_Results_Advanced_Filtering_and_Cleaning_Test() throws InterruptedException {
//        1.	Go to https://www.nasa.gov/
//        2.	Type "Mars" in the search box at the top right of the page and press Enter
        search_page.inputSearchBox("Mars");

//        3.	On the search results page that opens, check if the text "Search Results for: Mars" text is displayed.
        String expectedTitle = "Search Results for: Mars";
        String actualTitle = search_page.verifyResultText().getText();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

//        4.	From the filter panel on the left side of the page, make the following selections respectively:
//•	 Content Type: "Articles"
//•	 Categories: "Mars"
//•	 Changed: "Last Year"
//•	 Language: "English"

        filter_page.clickContentTypeArticles();
        filter_page.clickCategoriesMars();
        filter_page.clickChangedLastYear();
        filter_page.clickLanguageEnglish();


//        5.	Click the Apply Filter button
        filter_page.clickApplyFilterButton();

//        6.	On the page, check that the applied filters are selected and visible.
        Assert.assertTrue(filter_page.verifyContentTypeFilter().isDisplayed());
        Assert.assertTrue(filter_page.verifyCategoriesFilter().isDisplayed());

//        7.	Click on the Clear Filters button.
        filter_page.clickclearFilterButton();

//        8.	Verify that filters are cleared and results are reloaded.
        ReusableMethod.sleep(5000);
    }

    @AfterMethod
    public void TearnDown() {
        Driver.closeDriver();
    }
}
