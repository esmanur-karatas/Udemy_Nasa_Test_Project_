package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Moon_Page {
    public Moon_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"primary\"]/div/div[1]/header/h1")
    private WebElement searchResultTitle;

    @FindBy(xpath = "//*[@id=\"primary\"]/div/div[2]/div/div[2]/div[3]")
    private WebElement containsSearchCheckedWord;

    @FindBy(id = "RROlja1ob_4")
    private WebElement iframeElement;

    @FindBy(xpath = "//*[@id=\"movie_player\"]/div[5]/button")
    private WebElement playVideoButton;

    @FindBy(xpath = "//*[@id=\"primary\"]/div/div[2]/div/div[2]/div[3]/div/a/h3")
private WebElement firstContent;


    public WebElement verifySearchResultTitle() {
        return searchResultTitle;
    }

    public WebElement verifyContainsSearchCheckedWord() {
        return containsSearchCheckedWord;
    }

    public void clickFirstContent() {
        firstContent.click();
    }

    public void clickPlayVideoButton() {
        Driver.getDriver().switchTo().frame(iframeElement);
        playVideoButton.click();
        Driver.getDriver().switchTo().defaultContent();
    }

    public boolean isYoutubeVideoPlaying() {
        Driver.getDriver().switchTo().frame(iframeElement);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Long playerState = (Long) js.executeScript(
                "return document.querySelector('video').paused ? 2 : 1");
        Driver.getDriver().switchTo().defaultContent();
        return playerState == 1;
    }

    public void clickPauseVideoButton() {
        Driver.getDriver().switchTo().frame(iframeElement);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("document.querySelector('Video').pause();");
        Driver.getDriver().switchTo().defaultContent();
    }
}
