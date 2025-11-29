package steps;

import driver.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenericValidationSteps {

    WebDriver driver = DriverManager.getDriver();

    @Then("The text {string} should appear in results")
    public void textShouldAppearInResults(String expectedText) {

        String body = driver.findElement(By.tagName("body")).getText().toLowerCase();
        String text = expectedText.toLowerCase();

        Assert.assertTrue(
                "Textul '" + expectedText + "' NU apare în rezultate!",
                body.contains(text)
        );
    }
}
