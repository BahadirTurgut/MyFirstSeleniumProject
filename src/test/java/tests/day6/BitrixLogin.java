package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class BitrixLogin {

    public static void main(String[] args) {
        //getDriver() method returns object of webdriver
        // we need webdriver object to send commands to browser
        //left side is a reference variable to reuse the object
        //object can be used without reference variable
        //but it is gonna be impossible to use object more than once
        WebDriver driver= BrowserFactory.getDriver("chrome");
        //go to bitrix
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        //enter e-mail
        //WebElement email=driver.findElement
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk59@cybertekschool.com");
        //enter password
        // * matches any element but it's better to specify tag name to avoid issues with finding element
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();



    }
}
