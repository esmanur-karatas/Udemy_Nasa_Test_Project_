package negative_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Search_Page;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Nasa_Search_Special_Char_Test {
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
//      2.	Enter a long 300+ character meaningless text like "asdqwezxc..." in the search box.
//      3.	Press Enter.
        search_page.inputSearchBox("eırjgıoergıeırjgıoergıeırjgıoergıeırjgıoergıeırjgıoergıeırjgıoergıeırjgıoergıeırjgıoergıeırjgıoergıeırjgıoergıeırjgıoergıeırjgıoergıeırjgıoergıeırjgıoergıeırjgıoergıeırjgıoergıeırjgıoergı");

//      4.	Check if the page shows the message "Too Many Special Characters".
        String expectedText = "Too Many Special Characters".toLowerCase();

        String actualText = search_page.verifyToManyErrorMessage().getText().toLowerCase();
        Assert.assertTrue(actualText.contains(expectedText),
                "Expected to find" + expectedText + "in the text, but got: " + actualText);
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}
