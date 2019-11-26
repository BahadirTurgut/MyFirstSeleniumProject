package tests.day9_review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class LocatorsReview {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    // we have id, name, tag name, class name, link text, partial link text, Xpath, css selector
    @Test(description = "Verify Checkboxes")
    public void test1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        // [type='checkbox'] since tehre are 2 elelemts with same locastor
        // I need only first one ...I can use in css :nth-of-type(index)
        //  it is very useful if you have more than one element under same css selector
        WebElement checkbox1=driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)"));
        Assert.assertFalse(checkbox1.isSelected(), "checkbox 1 was selected"); // assert that checkbox is not selected
        //[index] to specify idex of element
        WebElement checkbox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 is not selected");
        // css selecetor is more preferable because of speed
    }
/*
    @Test(description = "Radio Buttons test")
    public void test2(){
        driver.findElement(By.linkText("Radio Buttons")).click();
        WebElement blueButton=driver.findElement(By.xpath("//*[text()='Blue']preceding-sibling::input[@type='radio']));


    }
*/
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
