package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Newsletters_Page {
    public Newsletters_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"post-40984\"]/div/figure[2]/table/tbody/tr[1]/td[1]/a")
    private WebElement signUpLink;

    public void clickSignUpLink(){
        signUpLink.click();
    }
}
