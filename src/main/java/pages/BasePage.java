package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void waitForElementTobeClickable(WebElement element) {
        new WebDriverWait(driver, 20)
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementDisappear(By locator) {
        new WebDriverWait(driver, 20)
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForPageToLoad() {
        new WebDriverWait(driver, 30)
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class)
                .until(webDriver1 -> ((JavascriptExecutor) webDriver1).executeScript("return document.readyState").equals("complete"));
    }
}
