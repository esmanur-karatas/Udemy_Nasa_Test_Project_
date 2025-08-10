package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class News_Page {
    public News_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "section-heading-md")
    private WebElement newReleasesHead;

    @FindBy(xpath = "//*[@id=\"post-128945\"]/div/div[3]/div/div[2]/div[1]/div[1]/a/div/div")
    private WebElement firstNew;

    @FindBy(css = "div img")
    private List<WebElement> images;

    @FindBy(xpath = "//*[@id=\"post-899212\"]/section/div[3]/section/div/div[1]/div/div[2]/ul/li[3]/a")
    private WebElement linkdlnButton;

    public WebElement verifyNewReleasesHead(){
        return newReleasesHead;
    }

    public void clickFirstNew(){
        firstNew.click();
    }

    public boolean isFirstImageVisible(){
        return images.get(0).isDisplayed();
    }

    public void clickLinkdlnButton(){
        linkdlnButton.click();
    }
}
