package negative_Test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.Search_Page;
import pages.Tabbar_Explorer_Page;
import pages.Tabbar_New_And_Events_Page;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Nasa_404_Error_And_Home_Redirect_Test {
    Tabbar_Explorer_Page tabbar_explorer_page;
    String url = ConfigurationReader.getProperty("falseUrl");

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(url);
        tabbar_explorer_page = new Tabbar_Explorer_Page();
    }

    @Test
    public void Nasa_404_Error_And_Home_Redirect_Test() {
//        1.	Check if a "404" error page is displayed when the user tries to access an invalid URL, such as nasa.gov/abcxyz.
//        2.	Click on the NASA logo and go to the homepage.
        tabbar_explorer_page.clickNasaLogo();

//        3.	Once on the homepage, check if the URL is compatible with https://www.nasa.gov/.
        String expectedUrl = "https://www.nasa.gov/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }


}
