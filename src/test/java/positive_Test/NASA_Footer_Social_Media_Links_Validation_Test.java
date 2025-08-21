package positive_Test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.Footer_Page;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class NASA_Footer_Social_Media_Links_Validation_Test {
    String facebookUrl = ConfigurationReader.getProperty("FacebookUrl");
    String instagramUrl = ConfigurationReader.getProperty("instagramUrl");
    String xUrl = ConfigurationReader.getProperty("XUrl");
    String youtubeUrl = ConfigurationReader.getProperty("YoutubeUrl");

    String url = ConfigurationReader.getProperty("address");

    Footer_Page footer_page;

    @BeforeClass
    public void SetUp() {
//        1.	Go to https://www.nasa.gov/
        Driver.getDriver().get(url);
        footer_page = new Footer_Page();
    }

    @Test
    public void NASA_Footer_Social_Media_Links_Validation_Test() throws InterruptedException {

//        2.	Go to the bottom of the page.
        ReusableMethod.scrollToFooter();

//        3.	Click on the facebook icon in the footer.
        ReusableMethod.sleep(6000);
        footer_page.clickFacebookIcon();

//        4. On the page that opens, verify that the url says "https://www.facebook.com/NASA”.
        ReusableMethod.sleep(6000);
        ReusableMethod.verifyNewTabUrlIs();

        String expectedUrl = facebookUrl;
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

//        5.	Close the tab.
//        6.	Go back to the previous tab.
        ReusableMethod.closeCurrentTabAndSwitchBack();

//        7.	Go to the bottom of the page. Click on the Instagram icon
        ReusableMethod.scrollToFooter();
        footer_page.clickInstagramIcon();

//        8.	On the page that opens, verify that the url is "https://www.instagram.com/nasa/".
        ReusableMethod.verifyNewTabUrlIs();

        String expectedUrl1 = instagramUrl;
        String actualUrl1 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl1, expectedUrl1);

//        9.	Close the tab.
        ReusableMethod.closeCurrentTabAndSwitchBack();


//        10.	Click the X icon, verify that the url is "https://x.com/NASA" on the page that opens and close the tab.
        ReusableMethod.scrollToFooter();
        footer_page.clickXIcon();
        ReusableMethod.verifyNewTabUrlIs();
        String expectedXUrl = xUrl;
        String actualXUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualXUrl, expectedXUrl);
        ReusableMethod.closeCurrentTabAndSwitchBack();


//        11.	Click the Youtube icon. on the page that opens, verify that the url is "https://www.youtube.com/@NASA" and close the tab.
        ReusableMethod.scrollPageTwice();
        footer_page.clickYoutubeIcon();
        ReusableMethod.verifyNewTabUrlIs();
        String expectedYoutubeUrl = youtubeUrl;
        String actualYoutubeUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualYoutubeUrl, expectedYoutubeUrl);
        ReusableMethod.closeCurrentTabAndSwitchBack();
    }

    @AfterClass
    public void TearnDown() {
        Driver.closeDriver();
    }
}
