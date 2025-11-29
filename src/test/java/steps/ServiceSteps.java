package steps;

import driver.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ServiceSteps {

    WebDriver driver = DriverManager.getDriver();

    @Then("The service {string} should be displayed")
    public void serviceDisplayed(String service) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Așteptăm ca pagina să se încarce
        WebElement body = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.tagName("body"))
        );

        // Verificăm dacă textul apare în rezultate
        String pageText = body.getText().toLowerCase();
        String expected = service.toLowerCase();

        Assert.assertTrue(
                "Service '" + service + "' was NOT found in the results!",
                pageText.contains(expected)
        );
    }
}
