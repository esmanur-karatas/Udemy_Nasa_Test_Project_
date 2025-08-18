package positive_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Astronauts_Page;
import pages.Tabbar_Explorer_Page;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class NASA_Astronaut_Profile_and_PDF_Download_Test {
    Tabbar_Explorer_Page tabbar_explorer_page;
    Astronauts_Page astronauts_page;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void SetUp() {
        Driver.getDriver().get(url);
        tabbar_explorer_page = new Tabbar_Explorer_Page();
        astronauts_page = new Astronauts_Page();
    }

    @Test
    public void NASA_Astronaut_Profile_and_PDF_Download_Test() throws InterruptedException {
//        1.	Go to https://www.nasa.gov/
//        2.	Once the homepage has loaded, click on "Explore" in the top menu.
        tabbar_explorer_page.clickExplorerButton();

//        3.	Click on the "Humans in Space" link in the drop-down menu.
        tabbar_explorer_page.clickHumanInSpaceButton();

//        4.	Click on "Astronauts" in the drop-down menu.

        tabbar_explorer_page.clickAstrounutsButton();

//        5.	Once the page is fully loaded, select an astronaut profile (Don Petit).
        astronauts_page.clickAstrounutsText();

//        6.	Scroll down the page until " View Donald Pettit Biographyabout Donald Pettit " appears and click on it.
        ReusableMethod.scrollPageFour();
        astronauts_page.clickBiographyButton();

//        7.	Verify the "Summary" heading on the page that opens.
        String expectedTitle = "Summary";
        String actualTitle = astronauts_page.verifySummaryText().getText();
        Assert.assertEquals(actualTitle, expectedTitle);

//        8.	Scroll to the bottom of the page.
        ReusableMethod.scrollToFooter();
        ReusableMethod.sleep(6000);

//        9.	Click on the link "Wiseman, G. Reid (PDF 388 KB)"
        astronauts_page.clickPdfButton();
        ReusableMethod.sleep(10000);

//        10.	Check whether it has landed in your Downloads folder
        ReusableMethod.isFileDownloaded("kim-jb-1.pdf");
    }

    @AfterMethod
    public void TearnDown() {
        Driver.closeDriver();
    }
}
