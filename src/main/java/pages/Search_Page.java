package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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


    public void InputSearchBox(String searchText) {
        searchBox.sendKeys(searchText, Keys.ENTER);

    }

    public WebElement VerifyErrorMessage() {
        return errorMessage;
    }

    public WebElement VerifyToManyErrorMessage() {
        return toManyErrorMessage;
    }
}
