package negative_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Search_Page;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Nasa_Search_Negative_Test {
    Search_Page search_page;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void Setup() {
        //        1.	Go to https://www.nasa.gov/
        Driver.getDriver().get(url);
        search_page = new Search_Page();
    }

    @Test
    public void Missions_Page_Access_Test() {
//        2.	Search the search box on the homepage with nothing typed in and see if the text "Sorry"
        search_page.InputSearchBox(" ");
        String expectedText = "Sorry".toLowerCase();

        String actualText = search_page.VerifyErrorMessage().getText().toLowerCase();
        System.out.println(actualText);
        Assert.assertTrue(actualText.contains(expectedText),
                "Expected to find" + expectedText + "in the text, but got: " + actualText);
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}
