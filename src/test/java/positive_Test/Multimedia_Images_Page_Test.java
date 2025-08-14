package positive_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Images_Page;
import pages.Tabbar_Multimedia_Page;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class Multimedia_Images_Page_Test {
    Images_Page images_page;
    Tabbar_Multimedia_Page tabbar_multimedia_page;

    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void SetUp() {
        Driver.getDriver().get(url);
        tabbar_multimedia_page = new Tabbar_Multimedia_Page();
        images_page = new Images_Page();
    }

    @Test
    public void Multimedia_Images_Page_Test() throws InterruptedException {
//        1.	Go to  https://www.nasa.gov/
//        2.	Click on the "Multimedia" button at the top right
        tabbar_multimedia_page.clickMultimediButton();

//        3.	Click on the "Images" link.
        tabbar_multimedia_page.clickImageLinkButton();

//        4.	Scroll down the page 5 times
        ReusableMethod.scrollPageFive();

//        5.	Click on the "Go To Gallery" button
        images_page.clickGoToGalleryLink();

//        6.	Click on a random image on the page that opens
        images_page.clickFirstImage();

//        7.	Verify that the "Download" and "Share" buttons are exist.
        Assert.assertTrue(images_page.verifyDownloadButton().isDisplayed());
        Assert.assertTrue(images_page.verifyShareButton().isDisplayed());
    }

    @AfterMethod
    public void TearnDown() {
        Driver.closeDriver();
    }

}
