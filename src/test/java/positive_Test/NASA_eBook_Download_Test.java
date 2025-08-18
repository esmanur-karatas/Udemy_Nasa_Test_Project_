package positive_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EBooks_Page;
import pages.Tabbar_Multimedia_Page;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class NASA_eBook_Download_Test {
    Tabbar_Multimedia_Page tabbar_multimedia_page;
    EBooks_Page eBooks_page;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void SetUp() {
        Driver.getDriver().get(url);
        tabbar_multimedia_page = new Tabbar_Multimedia_Page();
        eBooks_page = new EBooks_Page();
    }

    @Test
    public void NASA_eBook_Download_Test() throws InterruptedException {
//        1.	Go to https://www.nasa.gov/
//        2.	Once the home page has loaded, click on "Multimedia" in the top menu.
        tabbar_multimedia_page.clickMultimediButton();

//        3.	Click on the "E-books" link in the drop-down menu.
        tabbar_multimedia_page.clickEBookButton();

//        4.	Verify that the title "NASA e-Books" appears on the page that opens.
        String expectedTitle = "NASA e-Books";
        String actualTitle = eBooks_page.verifyTitleText().getText();
        Assert.assertEquals(actualTitle, expectedTitle);

//        5.	Scroll until the book title "Archaeology, Anthropology, and Interstellar Communication" appears.
        ReusableMethod.scrollPageTwice();


//        6.	Click on the "Overview" button.
        eBooks_page.clickOverviewButton();

//        7.	Scroll until "E-pub format" on the page that opens.
        ReusableMethod.scrollPageTwice();

//        8.	Then click on the arrow button.
        eBooks_page.clickEPubDownload();
        ReusableMethod.sleep(3000);

//        9.	Check whether the Book has come down in the downloaded ones.
        ReusableMethod.isFileDownloaded("sp-4413-epub.epub");
    }

    @AfterMethod
    public void TearnDown() {
        Driver.closeDriver();
    }
}
