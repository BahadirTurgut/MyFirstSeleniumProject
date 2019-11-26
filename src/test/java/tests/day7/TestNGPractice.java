package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGPractice {

    @Test
    public void test(){
        // to verify that expected and actual are the same
        // if no it will throw exception and stop the program
        // also you will see in the console what was expected and what was actually
        Assert.assertEquals("appl","apple","Word is not correct!Should be apple");

    }

    @Test
    public void verifyTitle(){
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        String expected="Practice";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle, expected,"Title is wrong");
        driver.quit();
    }

    //let's verify that Test Automation Practice heading is displayed

    @Test(description = "Verify that heading is displayed")
    public void verifyHeadingIsDisplayed(){
        WebDriver driver=BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        // if there is no such element we will get NoSuchElementException
        // and our program will stop on the findEleemnt line
        WebElement heading=driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));
        // to make sure taht elemnt is visible to user because element can be present but not visible
        //we need to make sure that element is visible
        //assertTrue -method checks if something is true , if it's false you will get exception
        Assert.assertTrue(heading.isDisplayed(), "Element is not visible");
        driver.quit();

    }


}
