package tests.agileVyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Login {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://google.com");
        driver.navigate().to("https://qa2.vytrack.com/user/login");
        WebElement email=driver.findElement(By.name("_username"));
        email.sendKeys("user189");
        WebElement  password= driver.findElement(By.name("_password"));
        password.sendKeys("UserUser123");
        BrowserUtils.wait(2);
        WebElement button=driver.findElement(By.id("_submit"));
        button.click();

        String expectedUrl="https://qa2.vytrack.com/";
        String actualUrl=driver.getCurrentUrl();
        if(expectedUrl.equals(actualUrl)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

        BrowserUtils.wait(2);
        driver.close();


    }
}
