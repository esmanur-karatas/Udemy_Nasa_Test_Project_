package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Images_Page {
    public Images_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"post-336989\"]/div/div[6]/div[1]/div/div[2]/a")
    private WebElement goToGalleryLink;

    @FindBy(xpath = "//*[@id=\"post-859828\"]/section/div/div[3]/div/div[1]/a/img")
    private WebElement firstImage;

    @FindBy(xpath = "//*[@id=\"post-859829\"]/section/div/div/div[2]/div[2]/a")
    private WebElement downloadButton;

    @FindBy(xpath = "//*[@id=\"social-share-button\"]")
    private WebElement shareButton;

    public void clickGoToGalleryLink() {
        goToGalleryLink.click();
    }

    public void clickFirstImage() {
        firstImage.click();
    }

    public WebElement verifyDownloadButton() {
        return downloadButton;
    }

    public WebElement verifyShareButton() {
        return shareButton;
    }

}
