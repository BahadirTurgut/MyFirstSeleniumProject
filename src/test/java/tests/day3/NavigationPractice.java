package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) {
        // create webdriver object, to work with a browser
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();//to maximize browser window
        driver.get("http://google.com");
        // wait for 3 seconds, this is our custom method
        //since method is static, we use class name to call the method
        //as parameter , we provide number of seconds
        BrowserUtils.wait(3);
        //How to print title?
        System.out.println(driver.getTitle());
        driver.navigate().to("http://amazon.com");

        //navigate back to google (previous URL)
        driver.navigate().back();
        //move forward to amazon again
        driver.navigate().forward();
        // to refresh/reload a webpage
        driver.navigate().refresh();
        // shutdown browser
        driver.quit();
        //what will happen, if I call the driver again
       // driver.get("http://google.com");
        //you cannot call driver after quit() ,
    }
}
