
package locators;

import org.openqa.selenium.By;

public class GoogleLocators {

    public static final By searchBox = By.name("q");
    public static final By searchResults = By.id("search");
    public static final By googleHeader = By.id("logo");

    public static By serviceCard(String text) {
        return By.xpath("//*[contains(text(),'" + text + "')]");
    }
}
