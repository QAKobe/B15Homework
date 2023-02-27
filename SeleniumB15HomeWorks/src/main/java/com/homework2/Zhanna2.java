package com.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Zhanna2 {

    @Test
    public void TestCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actual= driver.getTitle();
        String expected="Web Orders Login";
        Assert.assertEquals(actual,expected);
        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement TitleValidate= driver.findElement(By.xpath("//h1"));
        String actualTitle=TitleValidate.getText().trim();
        String expectedTitle="Web Orders";
        Assert.assertEquals(actualTitle,expectedTitle);
        WebElement ListOfAllOrders= driver.findElement(By.xpath("//h2"));
        String actualListOfAllOrders=ListOfAllOrders.getText().trim();
        String expectedListOfAllOrders="List of All Orders";
        Assert.assertEquals(actualListOfAllOrders,expectedListOfAllOrders);
    }
    @Test
    public void TestCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actual= driver.getTitle();
        String expected="Web Orders Login";
        Assert.assertEquals(actual,expected);
        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement ViewAllProductsButton=driver.findElement(By.linkText("View all products"));
        Assert.assertFalse(ViewAllProductsButton.isSelected());//look at this one assertfalse or asserttrue should be
        ViewAllProductsButton.click();
        Thread.sleep(2000);
        WebElement listOfProducts=driver.findElement(By.xpath("//h2[contains(text(),'List of Products')]"));
        String actualHeader=listOfProducts.getText().trim();
        String expectedHeader="List of Products";
        Assert.assertEquals(actualHeader,expectedHeader);

        Assert.assertTrue(driver.getCurrentUrl().contains("Product"));

    }
    @Test
    public void TestCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actual = driver.getTitle();
        String expected = "Web Orders Login";
        Assert.assertEquals(actual, expected);
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement viewAllOrders= driver.findElement(By.linkText("View all orders"));
        String expectedHREF=viewAllOrders.getAttribute("href");
        Assert.assertTrue(expectedHREF.contains("Default.aspx"));
        WebElement viewAllProducts= driver.findElement(By.linkText("View all products"));
        String expectedHREF2=viewAllProducts.getAttribute("href");
        Assert.assertTrue(expectedHREF2.contains("Products.aspx"));
        WebElement orders= driver.findElement(By.linkText("Order"));
        String expectedHREF3=orders.getAttribute("href");
        Assert.assertTrue(expectedHREF3.contains("Process.aspx"));
    }
    @Test
    public void TestCase4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actual = driver.getTitle();
        String expected = "Web Orders Login";
        Assert.assertEquals(actual, expected);
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement orderButton = driver.findElement(By.linkText("Order"));
        orderButton.click();
        WebElement selectProduct=driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        BrowserUtils.selectBy(selectProduct,"ScreenSaver","text");
        WebElement quantity= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("5");
        WebElement name= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        name.sendKeys("CodeFish IT School");
        WebElement street= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E devon");
        WebElement city= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");
        WebElement state= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("illinois");
        WebElement zipcode= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipcode.sendKeys("60018");
        WebElement masterCardButton= driver.findElement(By.xpath("//input[@value='MasterCard']"));
        masterCardButton.click();
        Thread.sleep(10);
        WebElement card= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        card.sendKeys("444993876233");
        Thread.sleep(2000);
        WebElement expirationDate= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("03/24");
        WebElement processButton= driver.findElement(By.linkText("Process"));
        processButton.click();
        Thread.sleep(2000);



        WebElement OrdersButton= driver.findElement(By.linkText("View all orders"));
        OrdersButton.click();
        Thread.sleep(10);

    }}
