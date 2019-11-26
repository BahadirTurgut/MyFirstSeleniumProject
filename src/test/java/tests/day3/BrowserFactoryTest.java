package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class BrowserFactoryTest {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        // how we can print a source code of the page
        System.out.println(driver.getPageSource());
        // to finish the test execution
        driver.quit();

    }
}
