package pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class NewAccountDialog extends BasePage {

    @FindBy(xpath = "//span[text()='Account Name']/parent::label/following-sibling::div//input")
    private WebElement accountNameField;

    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveButton;

    public NewAccountDialog(WebDriver driver) {
        super(driver);
    }

    public void createAccount(String name) {
        waitForPageToLoad();
        waitForElementTobeClickable(accountNameField);
        accountNameField.click();
        accountNameField.clear();
        accountNameField.sendKeys(name);
        waitForElementTobeClickable(saveButton);
        saveButton.click();
    }
}
