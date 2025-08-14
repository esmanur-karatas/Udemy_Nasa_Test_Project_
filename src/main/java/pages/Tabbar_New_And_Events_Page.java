package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Tabbar_New_And_Events_Page {
    public Tabbar_New_And_Events_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//div/nav/div/ul/li[1]/button/span")
    private WebElement newAndEventsButton;

    @FindBy(xpath = "//*[@id=\"news-events-submenu\"]/a/h3")
    private WebElement  newAndEventsLinkButton;

    @FindBy(xpath = "//*[@id=\"news-events-submenu\"]/li[3]/a")
    private WebElement videoSeriesButton;




    public void clickNewAndEventsButton(){
        newAndEventsButton.click();
    }

    public void clickNewAndEventsLinkButton(){
        newAndEventsLinkButton.click();
    }

    public void clickvideoSeriesButton(){
        videoSeriesButton.click();
    }


}
