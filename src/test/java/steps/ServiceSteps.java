
package steps;

import driver.DriverManager;
import io.cucumber.java.en.Then;
import locators.GoogleLocators;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ServiceSteps {

    WebDriver driver = DriverManager.getDriver();

    @Then("The service {string} should be displayed")
    public void serviceDisplayed(String service) {
        Assert.assertTrue(driver.findElement(GoogleLocators.serviceCard(service)).isDisplayed());
    }
}
