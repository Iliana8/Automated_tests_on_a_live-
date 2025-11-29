package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverManager {

    private static WebDriver driver;

    private static class NoOutput extends java.io.OutputStream {
        @Override
        public void write(int b) {
        }
    }

    public static WebDriver getDriver() {

        if (driver == null) {

            Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

            System.setProperty("webdriver.chrome.silentOutput", "true");
            System.setProperty("webdriver.chrome.verboseLogging", "false");
            System.setProperty("webdriver.chrome.logfile", "NUL");

            WebDriverManager.chromedriver().setup();

            String chromePath = Paths.get("src/test/resources/drivers/chrome.exe")
                    .toAbsolutePath()
                    .toString();

            ChromeOptions options = new ChromeOptions();options.addArguments("--disable-infobars");

            options.setBinary(chromePath);

            options.addArguments("--start-maximized");
            options.addArguments("--disable-logging");
            options.addArguments("--log-level=3");
            options.addArguments("--disable-blink-features=AutomationControlled");

            options.setExperimentalOption("excludeSwitches", new String[] {
                    "enable-logging",
                    "enable-automation"
            });

            driver = new ChromeDriver(options);

            System.setOut(new java.io.PrintStream(new NoOutput()));
            System.setErr(new java.io.PrintStream(new NoOutput()));
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
