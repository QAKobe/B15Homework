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

public class Alia2 {

    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);
        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector(".button"));
        loginButton.click();

        WebElement title = driver.findElement(By.tagName("h1"));
        String actualTitle1 = title.getText().trim();
        String expectedTitle1 = "Web Orders";
        Assert.assertEquals(actualTitle1, expectedTitle1);


        WebElement header2 = driver.findElement(By.xpath("//h2[contains(text(),'List of All Orders')]"));
        String actualHeader = BrowserUtils.getText(header2);
        String expectedHeader = "List of All Orders";

        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
    public void successfulLogin1() throws InterruptedException {
        /*
         Navigate.to "http:secure.smartbearssoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"

      Input username "Tester"
      Input password "test"
      Click login button
      Click "View all products" button
      Validate "View all products" is selected
      Validate the header is equals to "List of Products"
      Validate the url has "Products" keyword

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle().trim();
        String expecetdTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expecetdTitle);
        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector(".button"));
        loginButton.click();
        WebElement viewAllProductsButton = driver.findElement(By.linkText("View all products"));
        Thread.sleep(3000);
        viewAllProductsButton.click();
        Thread.sleep(3000);
        WebElement viewAllProducts = driver.findElement(By.linkText("View all products"));
//Validate "View all products" is selected
        String actualHeader = BrowserUtils.getText(viewAllProducts);
        String expectedHeader = "View all products";
        Assert.assertEquals(actualHeader, expectedHeader);


        WebElement listOfProducts = driver.findElement(By.tagName("h2"));
        String actualHeader1 = listOfProducts.getText().trim();
        String expectedHeader1 = "List of Products";
        Assert.assertEquals(actualHeader1, expectedHeader1);


        String currentUrl = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Products.aspx";
        if (currentUrl.contains("Products")) {
            System.out.println("Product is present");
        } else {
            System.out.println("Product is not present");
        }

    }


/*

Navigate.to "http:secure.smartbearssoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
Validate the title is equals to "Web Orders Login"
 Input username "Tester"
 Input password "test"
 Click login button
 Find the links for
 -View all orders
 -View all products
 -Orders
 Validate their href values are equals to:
 "Default.aspx"
  "Products.aspx"
  "Process.aspx"
 */
@Test
public void successfulLogin2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);
        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector(".button"));
        loginButton.click();

        WebElement viewallOrdersButton = driver.findElement(By.linkText("View all orders"));
        Assert.assertFalse(viewallOrdersButton.getText().trim().contains("Default.aspx"));

        WebElement viewAllProductsButton = driver.findElement(By.linkText("View all products"));
        Assert.assertFalse(viewAllProductsButton.getText().trim().contains("Products.aspx"));

        WebElement orderButton= driver.findElement(By.linkText("Order"));
        Assert.assertFalse(orderButton.getText().trim().contains("Process.aspx"));


        }

@Test
public void successfulLogin3() {
     /*  Navigate.to "http:secure.smartbearssoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"

       Input username "Tester"
       Input password "test"
       Click login button
       Click "Order" button
       Select product "Screen Saver"
       Input Quantity 5
       Input Customer name "CodeFish IT School"
        Input Street "2200 E devon"
        Input City "Des Plaines"
        Input State "Illinois"
        Input Zip "60018"
        Select MasterCard
        Input card number"444993876233"
        Input expiration date "03/24"
        Click Process button
      */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector(".button"));
        loginButton.click();
        WebElement orderButton = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        orderButton.click();
        WebElement screenSaverBox = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        BrowserUtils.selectBy(screenSaverBox, "ScreenSaver", "value");
        WebElement quantityBox = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
        quantityBox.sendKeys("5");
        WebElement customerNameBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerNameBox.sendKeys("CodeFishIT School");
        WebElement streetBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        streetBox.sendKeys("2200 E Devon");
        WebElement cityBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        cityBox.sendKeys("Des Plaines");
        WebElement stateBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        stateBox.sendKeys("Illinois");
        WebElement zipBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zipBox.sendKeys("60018");
        WebElement masterCardbox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        masterCardbox.click();
        WebElement cardNumber = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");
        WebElement expirationDate = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();

        }}
