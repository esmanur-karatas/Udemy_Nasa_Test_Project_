package pages;

import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.BitSet;

public class Astronauts_Page {
    public Astronauts_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"post-128468\"]/div/div[4]/div/div[2]/div[1]/div/div/div[5]/div/div/a/h3")
    private WebElement astrounutsText;

    @FindBy(xpath = "//*[@id=\"post-278092\"]/div/div[5]/div/div/div[1]/a/span")
    private WebElement biographyButton;

    @FindBy(id = "hds-sidebar-nav-1")
    private WebElement summaryText;

    @FindBy(xpath = "//*[@id=\"primary\"]/div[2]/div/div[2]/div/p[7]/a")
    private WebElement pdfButton;


    public void clickAstrounutsText(){
        astrounutsText.click();
    }

    public void clickBiographyButton(){
        biographyButton.click();
    }

    public WebElement verifySummaryText(){
        return summaryText;
    }

    public void clickPdfButton(){
        pdfButton.click();
    }
}
