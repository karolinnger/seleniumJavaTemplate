package cucumber.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    // private String PATH_SAFARI_DRIVER = "/usr/bin/safaridriver";
    public static WebDriver createWebDriver() throws Exception {
        String webdriver = System.getProperty("browser", "chrome");
        switch(webdriver) {
            case "firefox":
                return new FirefoxDriver();
            case "chrome":
                return new ChromeDriver();
            case "safari":
                return new SafariDriver();
            default:
                throw new RuntimeException("Unsupported webdriver: " + webdriver);
        }
    }
}
