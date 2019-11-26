package tests.day9_review;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGReview {
    //whatever is common among tests, can go into beforemethod or aftermethod
    // it helps to reduce code duplication

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.out.println("Before method!");
        driver= BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("After method!");
        driver.quit();
    }

    @Test(description = "Verify title of google.com", priority = 2)
    public void test1(){
        System.out.println("Test1");
        driver.get("http://google.com");
        String expectedTitle="Google";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle , expectedTitle ,"Title is not correct!");

    }

    //prioroty will cahnge the order of test execution
    //by default tests are running in alpahbetical order

    @Test(description = "Verify title of apple.com", priority = 1)
    public void verifyApplesPageTitle(){
        System.out.println("Test 2");
        driver.get("https://apple.com/");
        String expectedTitle="Apple";
        String actualTitle=driver.getTitle();
        //message will be printed if assertion failed!
        Assert.assertEquals(actualTitle,expectedTitle,"Title is not correct");
        // if assertion fails line below will not be reachable
        // if passed you will see message from below
        System.out.println("Test passed!");

    }

    //data provider can supply test with a test data.Also, it allows data driven testing.
    //What is this? It is when same test runs multiple times with different data
    @DataProvider (name = "testData")
    public static Object[][] testData(){
        return new Object[][]{{"https://www.apple.com/","Apple"},{"http://google.com", "Google"}};
    }

    //data proovider must return 2D array of Object
    //1st parameter = 1 object in th einner array
    @Test (dataProvider = "testData")
    public void testWithDatatProvider(String url, String title){
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), title);
    }
}
