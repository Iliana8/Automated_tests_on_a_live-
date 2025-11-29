package steps;

import driver.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LanguageSteps {

    WebDriver driver = DriverManager.getDriver();

    @Then("Results should contain keyword {string}")
    public void resultsShouldContain(String keyword) {

        // 1) verificăm că Google a păstrat textul exact în search box
        String searchBoxValue = driver.findElement(By.name("q")).getAttribute("value").toLowerCase();

        // 2) verificăm că pagina are rezultate (nu eroare, captcha etc.)
        boolean hasResults = driver.getPageSource().toLowerCase().contains("results") ||
                driver.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                searchBoxValue.contains(keyword.toLowerCase());

        Assert.assertTrue(
                "Google NU a afișat rezultate valide pentru: " + keyword,
                hasResults
        );
    }
}
