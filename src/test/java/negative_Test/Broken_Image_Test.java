package negative_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethod;

import javax.sound.midi.Soundbank;
import java.time.Duration;
import java.util.List;


public class Broken_Image_Test {
    WebDriver driver;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void setUp() {
//        2.	Disable image loading in your browser settings.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--blink-setting-imagesEnable=false");

        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        1.	Go to https://www.nasa.gov/.
        driver.get(url);
    }

    @Test
    public void Broken_Image_Test() throws InterruptedException {
//        3.	Navigate through various pages of the NASA website (homepage, news, missions, etc.).
//        4.	Verify that broken image icons or placeholders are displayed instead of actual images.
//        5.	Check if the "alt" text for each image is descriptive and provides context about the missing image.
        System.out.println("Hecking the images on the Nasa Website");

        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total number of image tags: " + images.size());

        for(WebElement image : images){
            String src = image.getAttribute("src");
            String alt = image.getAttribute("alt");

            if (src == null || src.isEmpty()){
                System.out.println("src emty");
            }

            if (alt == null || alt.isEmpty()){
                System.out.println("Missing alt Text -> src: "+ src);
            } else{
                System.out.println(" Alt Text: " + alt);
            }
        }


        ReusableMethod.sleep(6000);

    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }

}
