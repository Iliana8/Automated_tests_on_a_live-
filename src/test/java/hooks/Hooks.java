
package hooks;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup() {
        DriverManager.getDriver();
    }

    @After
    public void cleanup(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)
                    DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_step");
        }
        DriverManager.quitDriver();
    }
    @io.cucumber.java.AfterStep
    public void afterEachStep() throws InterruptedException {
        Thread.sleep(50); // 0.8 secunde
    }

}
