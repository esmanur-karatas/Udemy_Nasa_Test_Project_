package positive_Test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Series_Our_Alien_Earth_Page;
import pages.Series_Page;
import pages.Tabbar_New_And_Events_Page;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethod;


public class NASA_Video_Series_Access_and_Playback_Test {
    Tabbar_New_And_Events_Page tabbar_new_and_events_page;
    Series_Page series_page;
    Series_Our_Alien_Earth_Page series_our_alien_earth_page;
    String url = ConfigurationReader.getProperty("address");

    @Parameters("browser")
    @BeforeMethod
    public void Setup() {
        //        1.	Go to https://www.nasa.gov/
        Driver.getDriver().get(url);
        tabbar_new_and_events_page = new Tabbar_New_And_Events_Page();
        series_page = new Series_Page();
        series_our_alien_earth_page = new Series_Our_Alien_Earth_Page();
    }

    @Test
    public void NASA_Video_Series_Access_and_Playback_Test() throws InterruptedException {
//        2.	Once the homepage has loaded, click on "News & Events" in the top menu.
        tabbar_new_and_events_page.clickNewAndEventsButton();

//        3.	Click on the "Video Series on Nasa+" link in the drop-down menu.
        tabbar_new_and_events_page.clickvideoSeriesButton();

//        4.	On the page that opens, verify the title "Explore Series".
        String expectedTitle = "Explore Series";
        String actualTitle = series_page.verifyTitle().getText();
        Assert.assertEquals(actualTitle, expectedTitle, "Başlık Doğrulandı.");

//        5.	Click on "Our Alien Earth".
        series_page.clickOurAlienEarth();

//        6.	Click on the first video on the page that opens.
        series_our_alien_earth_page.clickFirstVideo();

//        7.	On the page that opens, click on the "Play video" button.
        series_our_alien_earth_page.clickPlayButton();

//        8.	Then press the play button again on the page that opens and check if the video is playing
        ReusableMethod.sleep(3000);
        series_our_alien_earth_page.clickPlaySeconButton();
        ReusableMethod.sleep(3000);

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}


