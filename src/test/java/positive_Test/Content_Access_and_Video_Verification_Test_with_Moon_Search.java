package positive_Test;

import org.apache.log4j.Logger;
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


    static Logger logger = Logger.getLogger(Content_Access_and_Video_Verification_Test_with_Moon_Search.class);

    @BeforeMethod
    public void SetUp() {
        Driver.getDriver().get(url);
        logger.info("NASA ana sayfasına gidildi.");
        search_page = new Search_Page();
        moon_page = new Moon_Page();
    }

    @Test
    public void content_Access_and_Video_Verification_Test_with_Moon_Search() throws InterruptedException {
        logger.info("Arama kutusuna 'Moon' yazılıyor...");
        search_page.inputSearchBox("Moon");

        String expectedTitle = "Search Results for: Moon";
        String actualTitle = moon_page.verifySearchResultTitle().getText();
        Assert.assertEquals(actualTitle, expectedTitle, "Search Result for Moon Passed!");
        logger.debug("Arama başlığı doğrulandı: " + actualTitle);

        String expectedText = "Moon".toLowerCase();
        String actualText = moon_page.verifyContainsSearchCheckedWord().getText().toLowerCase();
        Assert.assertTrue(actualText.contains(expectedText), "Moon failed!");
        logger.info("İlk arama sonucu doğrulandı: " + actualText);

        logger.info("İlk arama sonucu tıklanıyor...");
        moon_page.clickFirstContent();

        ReusableMethod.scrollPageThree();
        logger.debug("Sayfa aşağı kaydırıldı, video bulundu.");

        moon_page.clickPlayVideoButton();
        boolean isPlaying = moon_page.isYoutubeVideoPlaying();
        if (isPlaying) {
            logger.info("Video oynuyor.");
        } else {
            logger.warn("Video başlamadı!");
        }

        moon_page.clickPauseVideoButton();
        logger.info("Video durduruldu.");
    }

    @AfterMethod
    public void TearDown() {
        Driver.closeDriver();
        logger.info("Tarayıcı kapatıldı, test tamamlandı.");
    }
}
