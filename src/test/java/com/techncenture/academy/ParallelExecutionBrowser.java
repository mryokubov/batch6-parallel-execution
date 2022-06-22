package com.techncenture.academy;

import com.techcenture.academy.utils.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;

public class ParallelExecutionBrowser {

    long start = 0;
    long end = 0;
    private ThreadLocal<WebDriver> driver =  new ThreadLocal<>();

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.set(ThreadGuard.protect(new ChromeDriver()));
        
    }

    @BeforeTest
    public void start(){
        System.out.println("starting to execute all test cases");
        start = Instant.now().getEpochSecond(); //recording the start time
    }


    @AfterTest
    public void end(){
        System.out.println("Finished running all test cases");
        end = Instant.now().getEpochSecond();

        System.out.println(end - start);
    }


    @Test(dataProvider = "customers1")
    public void test1(Map<String,String> data) throws InterruptedException {

        System.out.println("Test Case 1 is running");

        WebDriver driver2 = driver.get();

        driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //login
        driver2.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/Login.aspx");
        driver2.findElement(By.xpath("//input[contains(@id,'MainContent_username')]")).sendKeys("Tester");
        driver2.findElement(By.xpath("//input[contains(@id,'MainContent_password')]")).sendKeys("test");
        driver2.findElement(By.xpath("//input[@value='Login']")).click();

        //click on Order link
        try {

            driver2.findElement(By.xpath("//a[text()='Order']")).click();
            Select select = new Select(driver2.findElement(By.xpath("//select[contains(@id,'MainContent_fmwOrder_ddlProduct')]")));
            select.selectByVisibleText(data.get("product"));

            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_txtQuantity')]")).sendKeys(data.get("quantity"));

            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_txtName')]")).sendKeys(data.get("customerName"));
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox2')]")).sendKeys(data.get("street"));
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox3')]")).sendKeys(data.get("city"));
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox4')]")).sendKeys(data.get("state"));
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox5')]")).sendKeys(data.get("zip"));

            driver2.findElement(By.xpath("//input[@value='" + data.get("cardRadioBtn") + "']")).click();
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox6')]")).sendKeys("cardNumber");

            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox1')]")).sendKeys("expireDate");


            driver2.findElement(By.xpath("//a[text()='Process']")).click();

            //       WebElement success = driver2.findElement(By.xpath("//strong[contains(text(),'New order has been successfully added.')]"));

        }
        catch (Exception e){

        }
        finally {
            driver2.quit();
        }



    }

    @Test(dataProvider = "customers2")
    public void test2(Map<String,String> data) throws InterruptedException {

        System.out.println("Test Case 2 is running");
        WebDriver driver2 = driver.get();
        driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //login
        driver2.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/Login.aspx");
        driver2.findElement(By.xpath("//input[contains(@id,'MainContent_username')]")).sendKeys("Tester");
        driver2.findElement(By.xpath("//input[contains(@id,'MainContent_password')]")).sendKeys("test");
        driver2.findElement(By.xpath("//input[@value='Login']")).click();

        try {

            //click on Order link
            driver2.findElement(By.xpath("//a[text()='Order']")).click();
            Select select = new Select(driver2.findElement(By.xpath("//select[contains(@id,'MainContent_fmwOrder_ddlProduct')]")));
            select.selectByVisibleText(data.get("product"));

            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_txtQuantity')]")).sendKeys(data.get("quantity"));

            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_txtName')]")).sendKeys(data.get("customerName"));
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox2')]")).sendKeys(data.get("street"));
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox3')]")).sendKeys(data.get("city"));
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox4')]")).sendKeys(data.get("state"));
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox5')]")).sendKeys(data.get("zip"));

            driver2.findElement(By.xpath("//input[@value='" + data.get("cardRadioBtn") + "']")).click();
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox6')]")).sendKeys("cardNumber");

            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox1')]")).sendKeys("expireDate");


            driver2.findElement(By.xpath("//a[text()='Process']")).click();

            //    WebElement success = driver2.findElement(By.xpath("//strong[contains(text(),'New order has been successfully added.')]"));

        }catch (Exception e){

        }finally {
            driver2.quit();
        }

    }

    @Test(dataProvider = "customers3")
    public void test3(Map<String,String> data) throws InterruptedException {

        System.out.println("Test Case 3 is running");

        WebDriver driver2 = driver.get();


        driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //login
        driver2.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/Login.aspx");
        driver2.findElement(By.xpath("//input[contains(@id,'MainContent_username')]")).sendKeys("Tester");
        driver2.findElement(By.xpath("//input[contains(@id,'MainContent_password')]")).sendKeys("test");
        driver2.findElement(By.xpath("//input[@value='Login']")).click();

        try {

            //click on Order link
            driver2.findElement(By.xpath("//a[text()='Order']")).click();
            Select select = new Select(driver2.findElement(By.xpath("//select[contains(@id,'MainContent_fmwOrder_ddlProduct')]")));
            select.selectByVisibleText(data.get("product"));

            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_txtQuantity')]")).sendKeys(data.get("quantity"));

            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_txtName')]")).sendKeys(data.get("customerName"));
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox2')]")).sendKeys(data.get("street"));
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox3')]")).sendKeys(data.get("city"));
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox4')]")).sendKeys(data.get("state"));
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox5')]")).sendKeys(data.get("zip"));

            driver2.findElement(By.xpath("//input[@value='" + data.get("cardRadioBtn") + "']")).click();
            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox6')]")).sendKeys("cardNumber");

            driver2.findElement(By.xpath("//input[contains(@id,'MainContent_fmwOrder_TextBox1')]")).sendKeys("expireDate");


            driver2.findElement(By.xpath("//a[text()='Process']")).click();

            //    WebElement success = driver2.findElement(By.xpath("//strong[contains(text(),'New order has been successfully added.')]"));

        }catch (Exception e){

        }finally {
            driver2.quit();
        }

    }

    @DataProvider(name = "customers1")
    public Object[][] getData1(){
        ExcelReader reader = new ExcelReader("src/main/resources/testData/patients.xlsx", "customers1");
        return reader.getData();
    }

    @DataProvider(name = "customers2")
    public Object[][] getData2(){
        ExcelReader reader = new ExcelReader("src/main/resources/testData/patients.xlsx", "customers2");
        return reader.getData();
    }

    @DataProvider(name = "customers3")
    public Object[][] getData3(){
        ExcelReader reader = new ExcelReader("src/main/resources/testData/patients.xlsx", "customers3");
        return reader.getData();
    }
}
