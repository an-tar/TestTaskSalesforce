package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@href='/lightning/o/Account/home']/parent::*")
    private WebElement accountsLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openAccountsPage() {
        waitForPageToLoad();
        waitForElementTobeClickable(accountsLink);
        accountsLink.click();
    }
}
