package drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyProvider;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private WebDriver driver;

    public WebDriver getWebDriver() {
        String browserType = PropertyProvider.getConfigData("browser");
        BrowserType browser = BrowserType.valueOf(browserType.toUpperCase());

        switch (browser) {
            case CHROME:
                driver = createChromeDriver();
                break;

            case FIREFOX:
                driver = createFirefoxDriver();
                break;

            default:
                driver = createChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver getInstance() {
        if (driver == null) {
            getWebDriver();
        }
        return driver;
    }

    private WebDriver createChromeDriver() {
        System.setProperty(BrowserType.CHROME.getDriverName(), BrowserType.CHROME.getDriverPath());
        return new ChromeDriver();
    }

    private WebDriver createFirefoxDriver() {
        System.setProperty(BrowserType.FIREFOX.getDriverName(), BrowserType.FIREFOX.getDriverPath());
        return new FirefoxDriver();
    }
}
