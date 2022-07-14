package pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AccountsPage extends BasePage {

    @FindBy(css = ".forceActionLink div[title='New']")
    private WebElement newAccountButton;

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public void openNewAccountDialog() {
        waitForPageToLoad();
        waitForElementTobeClickable(newAccountButton);
        newAccountButton.click();
    }
}
