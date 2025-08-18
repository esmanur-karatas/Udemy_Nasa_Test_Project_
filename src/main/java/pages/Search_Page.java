package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.xml.xpath.XPath;

public class Search_Page {
    public Search_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "search-field-en-small--desktop")
    private WebElement searchBox;

    @FindBy(xpath = "//div/div[2]/p[2]")
    private WebElement errorMessage;

    @FindBy(className = "wp-die-message")
    private WebElement toManyErrorMessage;

    @FindBy(xpath = "//*[@id=\"error-page\"]/div")
    private WebElement errorMessageSearchBox;

    @FindBy(xpath = "//*[@id=\"error-page\"]/p/a")
    private WebElement backButton;

    @FindBy(xpath = "//*[@id=\"primary\"]/div/div[1]/header/h1")
    private WebElement resultText;



    public void inputSearchBox(String searchText) {
        searchBox.sendKeys(searchText, Keys.ENTER);

    }

    public WebElement verifyErrorMessage() {
        return errorMessage;
    }

    public WebElement verifyErrorMessageSearchBox() {
        return errorMessageSearchBox;
    }

    public WebElement verifyToManyErrorMessage() {
        return toManyErrorMessage;
    }

    public void clickBackButton() {
        backButton.click();
    }

    public void clearSeacrhBox() {
        searchBox.clear();
    }

    public WebElement verifyResultText() {
        return resultText;
    }


}
