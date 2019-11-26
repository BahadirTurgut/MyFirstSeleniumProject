package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitsPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void test1(){
        //this line should be before all findElement() methods
        //to wait within 10 seconds until element is present
        //we apply it once and it always works
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Dynamic Loading")).click();
        //partialLinkTest we match only part of the link text
        //it's like contains text
        //Example 2:Element on the page after the trigger -link text
        //Example 2 -only part of the link text
        driver.findElement(By.partialLinkText("Example 2")).click();

        driver.findElement(By.tagName("button")).click();
        // this is for "Hello World!"
        WebElement finishElement=driver.findElement(By.id("finish"));

        System.out.println(finishElement.getText());
    }

    @Test
    public void test2(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        //to find this by xpath //a[contains(text),'Example2']
        // you cannot do partial link text with css
        driver.findElement(By.partialLinkText("Example 1")).click();
        driver.findElement(By.tagName("button")).click();
        //enter username & explicit wait
        WebElement usernameInputBox=driver.findElement(By.id("username"));
        // we create object of WebdriverWait to apply explicit wait
        //we must provide webdriver object and period of time
        //within this period of time selenium will check every 500 milliseconds
        //if condition is true (condition met) no need to wait longer
        //your script will continue executing,in this case period 10 seconds
        WebDriverWait wait= new WebDriverWait(driver,10);
        //how to apply condition ==> ExpectedConditions.condition
        // in this example seleniumwebd will wait up to 10 seconds or until element is visible
        //within this time if element is unvisible, test will fail
        wait.until(ExpectedConditions.visibilityOf(usernameInputBox));
        usernameInputBox.sendKeys("tomsmith");

        WebElement passwordInputBox=driver.findElement(By.id("pwd"));
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");

        WebElement submit=driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

        WebElement message=driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(message));

        String expectedMessage="Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage=message.getText();
        Assert.assertEquals(actualMessage,expectedMessage);


    }

    @Test
    public void test3(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();
        WebDriverWait wait=new WebDriverWait(driver,15);

        WebElement overlayScreen=driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
        //wait until overlay screen to disappear
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));

        WebElement usernameInputBox=driver.findElement(By.id("username"));


        wait.until(ExpectedConditions.visibilityOf(usernameInputBox));
        usernameInputBox.sendKeys("tomsmith");

        WebElement passwordInputBox=driver.findElement(By.id("pwd"));
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");

        WebElement submit=driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

        WebElement message=driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(message));

        String expectedMessage="Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage=message.getText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test(description = "Fluent wait example")
    public void test4(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2")).click();
        driver.findElement(By.tagName("button")).click();
        Wait wait=new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(ElementNotVisibleException.class);
        WebElement message=(WebElement) wait.until(new Function<WebDriver,WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("finish"));
            }
        });




    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
