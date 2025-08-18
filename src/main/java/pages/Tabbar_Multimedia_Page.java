package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Tabbar_Multimedia_Page {
    public Tabbar_Multimedia_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div/nav/div/ul/li[2]/button")
    private WebElement multimediaButton;

    @FindBy(xpath = "//*[@id=\"news-galleries-submenu\"]/li[2]/a")
    private WebElement imageLinkButton;

    @FindBy(xpath = "//*[@id=\"news-galleries-submenu\"]/li[7]/a")
    private WebElement eBooksButton;

    public void clickMultimediButton() {
        multimediaButton.click();
    }

    public void clickImageLinkButton() {
        imageLinkButton.click();
    }

    public void clickEBookButton() {
        eBooksButton.click();
    }
}
