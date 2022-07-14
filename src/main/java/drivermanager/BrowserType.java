package drivermanager;

import lombok.Getter;

public enum BrowserType {

    CHROME("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe"),
    FIREFOX("webdriver.gecko.driver", ".\\src\\main\\resources\\geckodriver.exe");

    @Getter
    private final String driverName;

    @Getter
    private final String driverPath;

    BrowserType(String driverName, String driverPath) {
        this.driverName = driverName;
        this.driverPath = driverPath;
    }
}
