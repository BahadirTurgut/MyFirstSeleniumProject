package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import javax.swing.plaf.basic.BasicListUI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WebTablesPractice {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait=new WebDriverWait(driver,15);
        //wait for presence of table 1
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));
    }

    @Test(description = "Print table 1 data")
    public void test1(){
        // <table> stands for web table in HTML
        // table is id of first table
        // once we find this table as web element, we can print all text from there
        // if you are getting NoSuchelementException, use of wait is recommended
        WebElement table=driver.findElement(By.id("table1"));
        System.out.println(table.getText());

    }

    @Test(description = "Verify that number of columns in the first table equals to 6")
    public void test2(){
        //size is equal to number of elements
        int actualColumnNummber=driver.findElements(By.xpath("//table[@id='table1']//th")).size();
        int expectedColumnNumber=6;
        Assert.assertEquals(actualColumnNummber,expectedColumnNumber);
    }

    //to exclude first row(header row)= //table[@id='table1']//tbody//tr
    @Test(description = "Verify that number of rows equals to 5")
    public void test3(){
        int expectedRowCount=5;
        int actualRowCount=driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
        Assert.assertEquals(actualRowCount,expectedRowCount);
    }

    @Test(description = "Print all values from the 2nd row (excluding table header")
    public void test4() {
        // if index=1 , then 1st row , if index 2 then it's second row
        //if we dont specify td index , it will take all td elements
        //in css we use space " ", in xpath // to get any child
        //in css we use > for direct child, in xpath /
        int index = 1;
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td"));
        for (WebElement cell : row) {
            System.out.println(cell.getText());
        }
    }

    @Test(description = "Print all values from the n-th row (excluding header row)")
    public void test5() {
        // if index=1 , then 1st row , if index 2 then it's second row
        //if we dont specify td index , it will take all td elements
        //in css we use space " ", in xpath // to get any child
        //in css we use > for direct child, in xpath /
        int index = 1;
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td"));
        for (WebElement cell : row) {
            System.out.println(cell.getText());
        }
    }

    @Test (description = "Verify that easmil in the third row equals to jdoe@hotmail.com")
    public void test6(){
        int row=3;
        int column=3;
        WebElement cell=driver.findElement(By.xpath("//table[@id='table1']//tbody//tr["+row+"]//td["+column+"]"));
        String expectedEmail="jdoe@hotmail.com";
        String actualEmail=cell.getText();
        Assert.assertEquals(actualEmail,expectedEmail);

    }

    @Test (description = "Verify that every e-mail contains '@' ")
    public void test7(){
        //get all emails
        //td[3] ==> means third column , we are skipping tr, because we need only column
        List<WebElement> emails=driver.findElements(By.xpath("//table[@id='table1']//tbody/tr//td[3]"));
        // loop through collection of emails
        for(WebElement email:emails){
            System.out.println(email.getText());
            Assert.assertTrue(email.getText().contains("@"));
        }

    }

    @Test (description = "Verify that after click on last name, values will be sorted in alphabetical order")
    public void test8(){
        WebElement lastNameElement=driver.findElement(By.xpath("//table[@id='table1']//th[1]"));
        lastNameElement.click();
        List<WebElement> names=driver.findElements(By.xpath("//table[@id='table1']//tbody//td[1]"));
        List<WebElement> names1= names.sort();

        Assert.assertEquals(names,names1);

    }





    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
