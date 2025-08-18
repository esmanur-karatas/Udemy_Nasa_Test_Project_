package positive_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Moon_Page;
import pages.Search_Page;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class Content_Access_and_Video_Verification_Test_with_Moon_Search {
    Search_Page search_page;
    Moon_Page moon_page;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void SetUp() {
//        1.	Go to https://www.nasa.gov/
        Driver.getDriver().get(url);
        search_page = new Search_Page();
        moon_page = new Moon_Page();
    }

    @Test
    public void content_Access_and_Video_Verification_Test_with_Moon_Search() throws InterruptedException {

//        2.	Type the word "Moon" in the search box at the top right of the home page and press Enter
        search_page.inputSearchBox("Moon");

//        3.	On the page that opens, check if "Search Results for: Moon" appears on the page.
        String expectedTitle = "Search Results for: Moon";
        String actualTitle = moon_page.verifySearchResultTitle().getText();
        Assert.assertEquals(actualTitle, expectedTitle, "Search Result for Moon Passed!");

//        4.	Check if the first search result that comes up has the word "Moon" in it.
        String expectedText = "Moon".toLowerCase();
        String actualText = moon_page.verifyContainsSearchCheckedWord().getText().toLowerCase();
        Assert.assertTrue(actualText.contains(expectedText),
                "Moon failed!");

//        5.	Click on the first search result.
        moon_page.clickFirstContent();

//        6.	On the page that opens, scroll down and keep scrolling until a video appears on the page.
        ReusableMethod.scrollPageThree();
        moon_page.clickPlayVideoButton();

//        7.	Check if it works by clicking on the video that appears.
        moon_page.isYoutubeVideoPlaying();
        ReusableMethod.sleep(6000);
        boolean isPlaying = moon_page.isYoutubeVideoPlaying();
        System.out.println("Is the video currently playing?" + isPlaying);

//        8.	Stop or close the video by clicking again.
        moon_page.clickPauseVideoButton();

    }

    @AfterMethod
    public void TearnDown() {
        Driver.closeDriver();
    }

}
