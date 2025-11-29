
package steps;

import driver.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LanguageSteps {

    WebDriver driver = DriverManager.getDriver();

    @Then("Results should contain keyword {string}")
    public void resultsShouldContain(String word) {
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains(word.toLowerCase()));
    }
}
