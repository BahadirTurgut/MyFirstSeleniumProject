package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class RadioButtons {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Radio Buttons")).click();
    }

    @Test(description = "Verify that blue button is selected")
    public void test1(){
        //to go to radio buttons page
        // <a href+"/radio_buttons">Radio Buttons</a>   this means a link, by text:Radio Buttons
        // linktext works only with <a> elements
        //
        // driver.findElement(By.linkText("Radio Buttons")).click();
        //find blue radio button
        WebElement blueButton=driver.findElement(By.id("blue"));
        //let's verify that radio button is selected, assert true that button is selected
        // if button selected it will return true, otherwise false
        Assert.assertTrue(blueButton.isSelected());
    }

    @Test(description = "Verify that red button is not selected")
    public void test2(){
        WebElement redButton=driver.findElement(By.id("red"));
        Assert.assertFalse(redButton.isSelected()); //assertFalse will expect that condition is false

    }

    @Test(description = "Verify that green button is not clickable")
    public void test3(){
        WebElement greenButton=driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());
    }

    @Test(description = "Click on all radio buttons")
    public void test4(){
        //how to find all radio buttons? find all radio buttons , will have type='radio'
        // input it as an element type
        List<WebElement> radioButtons=driver.findElements(By.cssSelector("input[type='radio']"));
        for(WebElement button: radioButtons){
            // if button is available for clicking and not clicked yet
            if(button.isEnabled() && !button.isSelected()){
                // then click on it
                button.click();
                // in this case , id attribute represents a name of the color, also there is no text in this element
                //that's why we use attribute value
                System.out.println("Button clicked: "+button.getAttribute("id"));
            }
            else{
                System.out.println("Button was not clicked: "+button.getAttribute("id"));
            }
        }

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
