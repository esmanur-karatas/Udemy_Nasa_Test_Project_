package negative_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Search_Page;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class Nasa_XSS_and_SQL_Injection_Test {
    Search_Page search_page;
    String url = ConfigurationReader.getProperty("address");

    @Parameters("browser")
    @BeforeMethod
    public void SetUp() {
        Driver.getDriver().get(url);
        search_page = new Search_Page();
    }

    @Test
    public void Nasa_XSS_and_SQL_Injection_Test() throws InterruptedException {
//        1.	Go to https://www.nasa.gov/
//        2.	Enter an XSS (Cross-Site Scripting) attack code like
//        < script> alert('XSS')</script> in the search box at the top right of the page and press Enter.
        search_page.inputSearchBox("< script> alert('XSS')</script>");

//        3.	Verify that this code is not executed on the search results page "Search term contains invalid character(s): < > ( )"
        String expectedErrorMessage = "Search term contains invalid character(s): < > ( )";
        String actualErrorMessage = search_page.verifyErrorMessageSearchBox().getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);


//        4.	In the search box on the search results page,
//        enter a potential SQL injection phrase such as 'sql injection attempt' and press Enter.
        search_page.clickBackButton();
        search_page.clearSeacrhBox();
        search_page.inputSearchBox("sql injection attempt");
        ReusableMethod.sleep(6000);

    }

    @AfterMethod
    public void TearnDown() {
        Driver.closeDriver();
    }
}
