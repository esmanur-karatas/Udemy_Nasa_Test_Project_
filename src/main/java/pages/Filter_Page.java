package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Filter_Page {
    public Filter_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "content_typearticles")
    private WebElement contentTypeArticles;

    @FindBy(id = "marsmars")
    private WebElement cotegoriesMars;

    @FindBy(id = "last-yearlast-year")
    private WebElement changedLastYear;

    @FindBy(id = "languageenglish")
    private WebElement languageEnglish;

    @FindBy(xpath = "//*[@id=\"primary\"]/div/div[2]/div/div[1]/div[2]/button")
    private WebElement applyFilterButton;

    @FindBy(xpath = "//*[@id=\"primary\"]/div/div[2]/div/div[2]/div[1]/div/button[1]/span[1]")
    private WebElement articleIsDisplayed;

    @FindBy(xpath = "//*[@id=\"primary\"]/div/div[2]/div/div[2]/div[1]/div/button[2]")
    private WebElement categoriesIsDisplayed;

    @FindBy(xpath = "//div/div[2]/div[1]/div/button[3]")
    private WebElement clearFilterButton;

    @FindBy(id = "content_typegallery")
    private WebElement contentTypeGallery;

    @FindBy(id = "iss-researchiss-research")
    private WebElement categoriesResearch;

    @FindBy(id = "languageespanol")
    private WebElement languageEspanol;

    @FindBy(className = "hds-notice")
    private WebElement message;
    public void clickContentTypeArticles() {
        contentTypeArticles.click();
    }

    public void clickCategoriesMars() {
        cotegoriesMars.click();
    }

    public void clickChangedLastYear() {
        changedLastYear.click();
    }

    public void clickLanguageEnglish() {
        languageEnglish.click();
    }

    public void clickApplyFilterButton() {
        applyFilterButton.click();
    }

    public WebElement verifyCategoriesFilter() {
        return categoriesIsDisplayed;
    }

    public WebElement verifyContentTypeFilter() {
        return articleIsDisplayed;
    }


    public void clickclearFilterButton(){
        clearFilterButton.click();
    }

    public void clickContentTypeGallery() {
        contentTypeGallery.click();
    }

    public void clickCategoriesResearch() {
        categoriesResearch.click();
    }

    public void clickLanguageEspanol() {
        languageEspanol.click();
    }

    public WebElement verifyMessage(){
        return message;
    }
}
