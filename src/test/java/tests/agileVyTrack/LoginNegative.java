package tests.agileVyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;

public class LoginNegative {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://google.com");
        driver.navigate().to("https://qa2.vytrack.com/user/login");
        WebElement email=driver.findElement(By.name("_username"));
        email.sendKeys("user188");
        WebElement  password= driver.findElement(By.name("_password"));
        password.sendKeys("UserUser124");
        BrowserUtils.wait(2);
        WebElement button=driver.findElement(By.id("_submit"));
        button.click();

        String expectedUrl="https://qa2.vytrack.com/";
        String actualUrl=driver.getCurrentUrl();
        if(expectedUrl.equals(actualUrl)){
            System.out.println("Test failed");
        }else{
            System.out.println("Test passed");
        }

        BrowserUtils.wait(2);
        driver.close();


    }
}
