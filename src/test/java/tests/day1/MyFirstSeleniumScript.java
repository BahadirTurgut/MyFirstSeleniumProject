package tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {



        public static void main(String[] args) {
            // we have to setup webdriver based on the browser we gonna use
            WebDriverManager.chromedriver().setup();
            // we need to create an object of appropriate class
            ChromeDriver driver=new ChromeDriver();
            //let's open google.com
            //.get() method allows to open some website
            driver.get("http://google.com");

        }
}


