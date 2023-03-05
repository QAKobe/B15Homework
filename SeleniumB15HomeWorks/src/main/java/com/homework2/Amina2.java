package com.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Amina2 {

    @Test
    public void case1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        String actualTitle2 = driver.getTitle().trim();
        String expectedTitle2 = "Web Orders";
        Assert.assertEquals(actualTitle2, expectedTitle2);
        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
    public void case2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        WebElement allProducts = driver.findElement(By.xpath("//li[.='View all products']"));
        allProducts.click();
        WebElement allProductsSelected = driver.findElement(By.xpath("//li[@class='selected']"));
        Assert.assertFalse(allProductsSelected.isSelected());
        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "List of Products";
        Assert.assertEquals(actualHeader, expectedHeader);
        String actualUrl = driver.getCurrentUrl().toLowerCase();
        Assert.assertTrue(actualUrl.contains("products"));
    }

    @Test
    public void case3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        WebElement viewAllOrdersLink = driver.findElement(By.linkText("View all orders"));
        WebElement viewAllProductsLink = driver.findElement(By.linkText("View all products"));
        WebElement ordersLink = driver.findElement(By.linkText("Order"));
        String expectedHrefViewAllOrders = "Default.aspx";
        String expectedHrefViewAllProducts = "Products.aspx";
        String expectedHrefOrders = "Process.aspx";
        Assert.assertTrue(viewAllOrdersLink.getAttribute("href").contains(expectedHrefViewAllOrders));
        Assert.assertTrue(viewAllProductsLink.getAttribute("href").contains(expectedHrefViewAllProducts));
        Assert.assertTrue(ordersLink.getAttribute("href").contains(expectedHrefOrders));
    }

    @Test
    public void case4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        WebElement order = driver.findElement(By.linkText("Order"));
        order.click();
        WebElement select = driver.findElement(By.tagName("select"));
        select.findElement(By.xpath("//option[@value='ScreenSaver']")).click();
        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("Illinois");
        WebElement zip = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zip.sendKeys("60018");
        WebElement masterCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        masterCard.click();
        WebElement cardNum = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNum.sendKeys("444993876233");
        WebElement expDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expDate.sendKeys("03/24");
        WebElement process = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        process.click();
        WebElement orderAdded = driver.findElement(By.tagName("strong"));
        Assert.assertTrue(orderAdded.isDisplayed());
        WebElement viewAllOrdersLink = driver.findElement(By.linkText("View all orders"));
        viewAllOrdersLink.click();
        List<WebElement> newOrder = driver.findElements(By.tagName("tr[2]"));
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = new ArrayList<>();
        for (int i = 1; i < newOrder.size(); i++) {
            actualNames.add(newOrder.get(i).getText().trim());
            expectedNames.add(newOrder.get(i).getText().trim());
        }
        Assert.assertEquals(actualNames, expectedNames);
        driver.quit();
}}
