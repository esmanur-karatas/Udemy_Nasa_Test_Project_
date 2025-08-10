package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Series_Our_Alien_Earth_Page {
    public Series_Our_Alien_Earth_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id=\"post-5863\"]/div/div[1]/a/figure")
    private WebElement firstVideo;

    @FindBy(xpath = "//*[@id=\"post-5863\"]/div/div/div[1]/div[2]/ul/li[1]/a")
    private WebElement playButton;

    @FindBy(xpath = "//*[@id=\"main-video\"]/button")
    private WebElement playSecondButton;

    public void clickFirstVideo(){
        firstVideo.click();
    }

    public void clickPlayButton(){
        playButton.click();
    }

    public void clickPlaySeconButton(){
        playSecondButton.click();
    }
}
