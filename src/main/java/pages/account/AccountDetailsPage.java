package pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AccountDetailsPage extends BasePage {

    @FindBy(xpath = "//*[@name='primaryField']//lightning-formatted-text")
    private WebElement accountNameLabel;

    @FindBy(xpath = "//button[@name='Edit']")
    private WebElement editButton;

    @FindBy(xpath = "//span[@data-aura-class='forceActionsText']")
    private WebElement popupMessage;

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountLabelText() {
        waitForPageToLoad();
        waitForElementTobeClickable(accountNameLabel);
        return accountNameLabel.getText();
    }

    public void openEditAccountDialog() {
        waitForPageToLoad();
        waitForElementTobeClickable(editButton);
        editButton.click();
    }

    public String getPopupMessageText() {
        waitForPageToLoad();
        waitForElementTobeClickable(popupMessage);
        return popupMessage.getText();
    }

    public void waitForPopupMessageDisappear() {
        waitForPageToLoad();
        waitForElementDisappear(By.xpath("//span[@data-aura-class='forceActionsText']"));
    }
}
