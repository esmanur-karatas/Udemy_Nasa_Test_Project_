package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Series_Page {
    public Series_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "page-title")
    private WebElement title;

    @FindBy(className = "series-grid--thumbnail")
    private List<WebElement> ourAlienEarth;



    public WebElement verifyTitle() {
        return title;
    }

    public void clickOurAlienEarth() {
        ourAlienEarth.get(1).click();
    }



}
