package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CssSelectorPractice {

    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //let's find all buttons and click on them one by one
        // why we put . instead of space? beacuse it is 2 class names .btn.btn-primary
        // in this case we will find all buttons that have : class="btn btn-primary'
        //or like this [class=btn btn-primary"], no need for .
        // . means class name , # means id
        List<WebElement> buttons=driver.findElements(By.cssSelector(".btn.btn-primary"));
        // loop through buttons
        for(WebElement button: buttons){
            // click on every button one by one
            button.click();
            BrowserUtils.wait(1);
            //get the message after click
            WebElement message=driver.findElement(By.cssSelector("#result"));
            //print the message
            System.out.println(message.getText());

        }

        //find elelement with a tag name h3, that has a parent element
        WebElement header=driver.findElement(By.cssSelector(".container>h3"));
        System.out.println(header.getText());

        WebElement p=driver.findElement(By.cssSelector(".container>p"));
        System.out.println(p.getText());

        driver.quit();
    }
}
