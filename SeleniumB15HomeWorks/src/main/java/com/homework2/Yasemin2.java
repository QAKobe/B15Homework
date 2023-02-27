package com.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Yasemin2 {

    @Test
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        Thread.sleep(1000);
        loginButton.click();

        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Web Orders";
        Assert.assertEquals(actualTitle2, expectedTitle2);

        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'List of All Orders')]"));
        String actualHeaderText = header.getText().trim();
        String expectedHeaderText = "List of All Orders";
        Assert.assertEquals(actualHeaderText, expectedHeaderText);

    }

    @Test
    public void task2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        Thread.sleep(1000);
        loginButton.click();

        WebElement viewAllProductsButton = driver.findElement(By.xpath("//a[.='View all products']"));
        Assert.assertTrue(viewAllProductsButton.isDisplayed());
        Assert.assertTrue(viewAllProductsButton.isEnabled());
        Thread.sleep(3000);
        viewAllProductsButton.click();
        WebElement viewAllProducts = driver.findElement(By.xpath("//li[@class='selected']"));
        String actualProductIsSelected = viewAllProducts.getAttribute("class").trim();
        String expectedProductIsSelected = "selected";
        Assert.assertEquals(actualProductIsSelected, expectedProductIsSelected);

        WebElement listOfProducts = driver.findElement(By.xpath("//h2[contains(text(),'List of Products')]"));
        String actualText = listOfProducts.getText().trim();
        String expectedText = "List of Products";
        Assert.assertEquals(actualText, expectedText);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("Products"));

    }

    @Test
    public void task3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        Thread.sleep(1000);
        loginButton.click();


        Thread.sleep(1000);
        WebElement viewAllOrdersButton = driver.findElement(By.xpath("//a[.='View all orders']"));
        Assert.assertTrue(viewAllOrdersButton.getAttribute("href").contains("Default.aspx"));
        Thread.sleep(1000);
        WebElement viewAllProductsButton = driver.findElement(By.xpath("//a[.='View all products']"));
        Assert.assertTrue(viewAllProductsButton.getAttribute("href").contains("Products.aspx"));
        Thread.sleep(1000);
        WebElement orderButton = driver.findElement(By.xpath("//a[.='Order']"));
        Assert.assertTrue(orderButton.getAttribute("href").contains("Process.aspx"));
        Thread.sleep(1000);
    }

    @Test
    public void task4Part1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        Thread.sleep(1000);
        loginButton.click();
        WebElement orderButton = driver.findElement(By.xpath("//a[.='Order']"));
        Thread.sleep(1000);
        orderButton.click();
        WebElement productBox = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Select screenSaver = new Select(productBox);
        screenSaver.selectByVisibleText("ScreenSaver");
        WebElement quantityBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantityBox.sendKeys("5");
        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("CodeFish IT School");
        WebElement streetBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        streetBox.sendKeys("2200 E devon");
        WebElement cityBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        cityBox.sendKeys("Des Plaines");
        WebElement stateBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        stateBox.sendKeys("Illinois");
        WebElement zipBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipBox.sendKeys("60018");
        WebElement masterCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        masterCard.click();
        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys("444993876233");
        WebElement expireDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expireDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        Thread.sleep(3000);
        processButton.click();

    }

    @Test
    public void task4Part2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        Thread.sleep(1000);
        loginButton.click();
        WebElement orderButton = driver.findElement(By.xpath("//a[.='Order']"));
        Thread.sleep(1000);
        orderButton.click();
        WebElement productBox = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Select screenSaver = new Select(productBox);
        screenSaver.selectByVisibleText("ScreenSaver");
        WebElement quantityBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantityBox.sendKeys("5");
        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("CodeFish IT School");
        WebElement streetBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        streetBox.sendKeys("2200 E devon");
        WebElement cityBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        cityBox.sendKeys("Des Plaines");
        WebElement stateBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        stateBox.sendKeys("Illinois");
        WebElement zipBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipBox.sendKeys("60018");
        WebElement masterCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        masterCard.click();
        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys("444993876233");
        WebElement expireDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expireDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        Thread.sleep(3000);
        processButton.click();
        Thread.sleep(1000);
        WebElement message = driver.findElement(By.xpath("//strong[contains(text(),'New order has been successfully added.')]"));
        String actualMessage = message.getText().trim();
        String expectedMessage = "New order has been successfully added.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
