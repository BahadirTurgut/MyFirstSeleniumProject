package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FramesPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/frames");
    }

    @Test(description = "iFrame example")
    public void test1(){
        driver.findElement(By.linkText("iFrame")).click();
        //since element inside frame is not visible for sleenium without switching to the frame
        // we can switch to frame based on id, name, index(starting from 0), webelement
        driver.switchTo().frame("mce_0_ifr");
        //without switching we cannot see inner html document
        // try to get it by: id, name, index, webelement or index
        WebElement inputArea=driver.findElement(By.id("tinymce"));
        String expectedText="Your content goes here.";
        String actualText=inputArea.getText();
        Assert.assertEquals(actualText , expectedText);

        BrowserUtils.wait(2);
        inputArea.clear();
        inputArea.sendKeys("Java is fun!");

        //to exit from the frame
        driver.switchTo().defaultContent();

    }

    @Test(description = "Nested Frames example")
    public void test2(){
        // it's not switch to frame, it's a navigation action
        driver.findElement(By.linkText("Nested Frames")).click();
        //we switch to frame based on webelement
        driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));
        //the reason for switching:content inside the frame isn't visible to selenium
        WebElement content=driver.findElement(By.tagName("body"));
        System.out.println(content.getText());

        driver.switchTo().defaultContent();// to exit from all frames, go to lobby
        driver.switchTo().frame("frame-top"); //second floor
        driver.switchTo().frame("frame-left");//third floor

        System.out.println(driver.findElement(By.tagName("body")).getText()); //print text
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
