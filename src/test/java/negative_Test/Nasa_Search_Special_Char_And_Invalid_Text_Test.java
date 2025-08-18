package negative_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Search_Page;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Nasa_Search_Special_Char_And_Invalid_Text_Test {
    Search_Page search_page;

    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void SetUp() {
        Driver.getDriver().get(url);
        search_page = new Search_Page();
    }

    @Test
    public void Nasa_Search_Special_Char_And_Invalid_Text_Test() {
//        1. Go to https://www.nasa.gov/
//        2. Type !@#$%^&*() in the search box.
//        Verify that the message "Search" Verify that the message is displayed.
        search_page.inputSearchBox("!@#$%^&*()");
        String expectedMessage = "Search".toLowerCase();
        String actualMessage = search_page.verifyErrorMessageSearchBox().getText().toLowerCase();

        Assert.assertTrue(actualMessage.contains(expectedMessage), "Sonuçlar eşleşmedi!");


//Back text click
search_page.clickBackButton();
search_page.clearSeacrhBox();

//        3. Type "mARSSSS" in the search box.”Search Result: mARSSSS" message is displayed.
        search_page.inputSearchBox("mARSSSS");
        String expectedResult = "Search".toLowerCase();
        String actualResult = search_page.verifyResultText().getText().toLowerCase();

        Assert.assertTrue(actualResult.contains(expectedResult), "Sonuçlar eşleşmedi!");

    }

    @AfterMethod
    public void TearnDown() {
        Driver.closeDriver();
    }
}
