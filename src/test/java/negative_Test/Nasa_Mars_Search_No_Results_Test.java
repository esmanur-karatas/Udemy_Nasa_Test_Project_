package negative_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Filter_Page;
import pages.Search_Page;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class Nasa_Mars_Search_No_Results_Test {
    Search_Page search_page;
    Filter_Page filter_page;
    String url = ConfigurationReader.getProperty("address");


    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(url);
        search_page = new Search_Page();
        filter_page = new Filter_Page();
    }

    @Test
    public void Nasa_Mars_Search_No_Results_Test() throws InterruptedException {
//        1.	Go to https://www.nasa.gov/
//        2.	Type "Mars" in the search box, press Enter.
        search_page.inputSearchBox("Mars");

//        3.	Set the filters on the left side like this:
//•	Content Type: "Gallery"
//•	Categories: "iss-researchiss-research
//•	Changed: "Last Year"
//•	Select Language: "Espanol"

        filter_page.clickContentTypeGallery();
        filter_page.clickCategoriesResearch();
        filter_page.clickChangedLastYear();
        filter_page.clickLanguageEspanol();


//        4.	Click on the "Apply Filter" button.
        ReusableMethod.scrollPageOne();
        filter_page.clickApplyFilterButton();

//        5.	"We're working continuously to improve our search results. If you aren't finding what you expect,
//        please use our feedback form to share the search query and expected result with us so we can improve.
//        " message.

        String expectedMessage = "We're working continuously to improve our search results. If you aren't finding what you expect, please use our feedback form to share the search query and expected result with us so we can improve.";
        String actualMessage = filter_page.verifyMessage().getText();

        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @AfterMethod
    public void TearnDown() {
        Driver.closeDriver();
    }
}
