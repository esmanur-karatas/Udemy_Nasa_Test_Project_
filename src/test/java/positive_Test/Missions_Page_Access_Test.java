package positive_Test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.Tabbar_Explorer_Page;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class Missions_Page_Access_Test {
    Tabbar_Explorer_Page tabbar_explorer_page;

    String url = ConfigurationReader.getProperty("address");

    @BeforeClass
    public void Setup(){
        //        1.	Go to https://www.nasa.gov/
        Driver.getDriver().get(url);
        tabbar_explorer_page = new Tabbar_Explorer_Page();
    }

    @Test
    public void Missions_Page_Access_Test() throws InterruptedException {

//        2.	Once the homepage has loaded, click on the "Explore" button in the top right corner.
        tabbar_explorer_page.clickExplorerButton();

//        3.	Click on the "Missions" button in the drop-down menu.
        ReusableMethod.sleep(3000);
        tabbar_explorer_page.clickMissionButton();

//        4.	When the menu opens, check if the "Missions" link is displayed in it.
        String expectedText = "Missions";
        String actualText = tabbar_explorer_page.verifyMissionText().getText();

        Assert.assertEquals(actualText, expectedText);

//        5.	Click on the "Missions" link that appears.
        tabbar_explorer_page.clickMissionText();

//        6.	Once the "Missions" page is loaded, check that the NASA logo is visible at the top of the page.
        Assert.assertTrue(tabbar_explorer_page.verifyNasaLogo().isDisplayed());

    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }

}
