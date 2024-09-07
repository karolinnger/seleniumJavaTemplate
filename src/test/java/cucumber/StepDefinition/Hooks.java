package cucumber.StepDefinition;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import cucumber.util.WebDriverFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Hooks {

    public static WebDriver driver;
    public Scenario scenario;
    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser(Scenario scenario) {
        this.scenario = scenario;
        try {
            driver = WebDriverFactory.createWebDriver();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   

    }

    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.quit();
    }

    @AfterStep
    public void screenshot(Scenario scenario){
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
