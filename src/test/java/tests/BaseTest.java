package tests;

import drivermanager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.PropertyProvider;

public abstract class BaseTest {

    protected WebDriver driver;
    DriverFactory driverFactory = new DriverFactory();

    @BeforeSuite
    public void setUp() {
        driver = driverFactory.getInstance();
        driver.get(PropertyProvider.getConfigData("url"));
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
