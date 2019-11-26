package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestsForNameLocator {
    public static void main(String[] args) {

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        //if you want to do in one line, without creatin webelemnt reference variable
        //enter full name
        driver.findElement(By.name("full_name")).sendKeys("Test User");
        //enter email
        driver.findElement(By.name("email")).sendKeys("test_email@email.com");
        //click signup
        driver.findElement(By.name("wooden_spoon")).click();
        //pause for 3 seconds
        BrowserUtils.wait(3);

        driver.quit();

    }
}
