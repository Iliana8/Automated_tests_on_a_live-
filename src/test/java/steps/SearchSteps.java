
package steps;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import locators.GoogleLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchSteps {

    WebDriver driver = DriverManager.getDriver();

    @Given("I open Google")
    public void iOpenGoogle() {
        driver.get("https://www.google.com/");
    }

    @When("I search for {string}")
    public void iSearchFor(String keyword) {
        WebElement box = driver.findElement(GoogleLocators.searchBox);
        box.sendKeys(keyword);
        box.submit();
    }
}
