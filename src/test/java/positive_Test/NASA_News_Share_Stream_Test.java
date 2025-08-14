package positive_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.News_Page;
import pages.Tabbar_New_And_Events_Page;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class NASA_News_Share_Stream_Test {
    Tabbar_New_And_Events_Page tabbar_new_and_events_page;
    News_Page news_page;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void Setup() {
        //        1.	Go to https://www.nasa.gov/
        Driver.getDriver().get(url);
        tabbar_new_and_events_page = new Tabbar_New_And_Events_Page();
        news_page = new News_Page();
    }

    @Test
    public void NASA_News_Share_Stream_Test() throws InterruptedException {

//        2.	Once the homepage has loaded, click on "News & Events" in the top menu.
        tabbar_new_and_events_page.clickNewAndEventsButton();

//        3.	Click on the "News & Events" link in the drop-down menu.
        tabbar_new_and_events_page.clickNewAndEventsLinkButton();

//        4.	Verify the "News Releases" heading on the page that opens.
        String expectedTitle = "News Releases";
        String actualTitle = news_page.verifyNewReleasesHead().getText();
        Assert.assertEquals(actualTitle, expectedTitle);

//        5.	Click on the first news item.
        news_page.clickFirstNew();

//        6.	When the news page opens, check for images or videos.
        news_page.isFirstImageVisible();

//        7.	Click on Linkdln from the sharing buttons on the left side of the page and verify the sharing screen.
        ReusableMethod.scrollToFooter();
        ReusableMethod.sleep(3000);
        news_page.clickLinkdlnButton();

        ReusableMethod.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }


}
