package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementsTest {

    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedTitle=driver.getTitle();

        //step1: open inspector in chrome and find locator for the element
        //step2: create object of WebElement
        //step3: use WebElement
        WebElement button= driver.findElement(By.id("form_submit"));
        // to click on the element
        button.click();
        //read title again, after clicking
        String actualTitle=driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected Title"+expectedTitle);
            System.out.println("Actual Title"+actualTitle);
        }

        BrowserUtils.wait(2);
        driver.close();

    }
}
