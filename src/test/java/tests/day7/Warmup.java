package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class Warmup {

    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");
        //how to find all links?
        // every link as a tag name <a>
        List<WebElement> links=driver.findElements(By.xpath("//a"));
        // findElement vs findElements
        // findElement =only 1 webelement ==> if there is no element found will get exception: NoSuchElemntExceptio
        //findElements=0 or more webelements ==> if list is empty there's no such element
        //size of the list =number of links
        System.out.println("Number of links: "+links.size());
        //What if I want you to print text of all links, one by one
        //loop through the collection of links
        for(WebElement webElement: links){
            if(!webElement.getText().isEmpty()) {
                System.out.println(webElement.getText());
            }
        }
        driver.quit();
    }
}
