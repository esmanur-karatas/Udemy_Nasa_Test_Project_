package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Subscribe_Form_Page {
    public Subscribe_Form_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "button_link")
    private WebElement signUpButton;

    @FindBy(xpath = "//tbody/tr/td/form/fieldset/div[1]/div")
    private WebElement message;

    @FindBy(id = "email_address")
    private WebElement emailInput;

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public WebElement verifyMessage() {
        return message;
    }

    public void emailInput(String email) {
        emailInput.sendKeys(email);
    }
}
