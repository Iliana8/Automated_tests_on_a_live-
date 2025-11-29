
package steps;

import driver.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenericValidationSteps {

    WebDriver driver = DriverManager.getDriver();

    @Then("I should see element {string}")
    public void iShouldSeeElement(String xpath) {
        Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
    }
}
