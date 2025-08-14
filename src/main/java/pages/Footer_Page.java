package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Footer_Page {
    public Footer_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div/div[2]/div/div[3]/div/div/ul/li[1]/a")
    private WebElement facebookIcon;

    @FindBy(xpath = "//div/div[2]/div/div[3]/div/div/ul/li[2]/a")
    private WebElement instagramIcon;

    @FindBy(xpath = "//div/div[2]/div/div[3]/div/div/ul/li[3]/a")
    private WebElement xIcon;

    @FindBy(xpath = "//div/div[2]/div/div[3]/div/div/ul/li[4]/a")
    private WebElement youtubeIcon;

    public void clickFacebookIcon() {
        facebookIcon.click();
    }

    public void clickInstagramIcon() {
        instagramIcon.click();
    }

    public void clickXIcon() {
        xIcon.click();
    }

    public void clickYoutubeIcon() {
        youtubeIcon.click();
    }
}
