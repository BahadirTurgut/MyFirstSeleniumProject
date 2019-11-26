package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstAutomationScript {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://google.com");
        // to read page title, there is method .getTitle()

        //Test1. Verify that title of the page is a "Google"
        String actualResult=driver.getTitle();
        String expectedResult="Google";
        if (actualResult.equals(expectedResult)){
            System.out.println("Test pass");
        }
        else{
            System.out.println("Test failed");
        }

        //to close browser
        // at the end of execution
        // if we opened a gate- we need to close it
        driver.close();
    }
}