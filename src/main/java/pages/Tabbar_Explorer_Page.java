package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Tabbar_Explorer_Page {
    public Tabbar_Explorer_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"global-navigation-trigger\"]/span")
    private WebElement explorerButton;

    @FindBy(xpath = "//*[@id=\"global-navigation\"]/div/div/div[1]/div/ul/li[2]/a/span")
    private WebElement missionButton;

   @FindBy (xpath = "//div[3]/div/div[2]/a/h3")
   private WebElement missionText;

   @FindBy(id = "header-logo")
   private WebElement nasaLogo;


    public void clickExplorerButton(){
        explorerButton.click();
    }

    public void clickMissionButton(){
        missionButton.click();
    }

    public WebElement verifyMissionText(){
        return missionText;
    }

    public void clickMissionText(){
        missionText.click();
    }

    public WebElement verifyNasaLogo(){
        return nasaLogo;
    }

    public void clickNasaLogo(){
        nasaLogo.click();
    }
}
