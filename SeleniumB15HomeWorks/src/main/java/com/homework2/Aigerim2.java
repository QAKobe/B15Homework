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
import java.util.Arrays;
import java.util.List;

public class Aigerim2 {

    @Test
    public void testCase1() {
        /*Navigate to "http://secure.smartbearsoftware.com/samples/Te stComplete11/WebOrders/Login.aspx?"
        Validate the title is equals to "Web Orders Login"
        Input username "Tester"
        Input password "test"
        Click login button
        Validate the title is equals to "Web Orders"
        Validate header is equals to "List of All Orders"*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(header.getText(), "List of All Orders");
    }

    @Test
    public void testCase2() throws InterruptedException {
        /*Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
         Input username "Tester"
         Input password "Test"
         Click login button
         Click "View all products" button
         Validate "View all products" is selected
         Validate header is equals to "List of Products"
         Validate the url has "Products" keyword*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        WebElement allProductsButton = driver.findElement(By.xpath("//li[.='View all products']"));
        allProductsButton.click();
        Thread.sleep(2000);

        WebElement allProductsButtonClicked = driver.findElement(By.xpath("//li[@class='selected']"));
        Assert.assertTrue(allProductsButtonClicked.isDisplayed());

        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(header.getText(), "List of Products");
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("Products"));
    }

    @Test
    public void testCase3() throws InterruptedException {
        /*Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
        Input username "Tester"
        Input password "Test"
        Click login button
        Find the links for:
          View all orders
          View all products
          Orders
        Validate their href values are equals to :
          "Default.aspx"
          "Products.aspx"
          "Process.aspx"*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        WebElement allOrdersButton = driver.findElement(By.xpath("//a[.='View all orders']"));
        allOrdersButton.click();
        WebElement allProductsButton = driver.findElement(By.xpath("//li[.='View all products']"));
        allProductsButton.click();
        WebElement orderButton = driver.findElement(By.xpath("//li[.='Order']"));
        orderButton.click();
        Thread.sleep(5000);
        Assert.assertTrue(allOrdersButton.getAttribute("href").contains("Default.aspx"));
        Assert.assertTrue(allProductsButton.getAttribute("href").contains("Products.aspx"));
        Assert.assertTrue(orderButton.getAttribute("href").contains("Process.aspx"));
    }

    @Test
    public void testCase4() {
        /*Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
        Input username "Tester"
        Input password "Test"
        Click login button
        Click "Order" button
        Select product "Screen Saver"
        Input quantity 5
        Input Customer name "CodeFish IT School"
        Input Street "2200 E devon"
        Input City "Des Plaines"
        Input State "Illinois"
        Input Zip "60018"
        Select MasterCard
        Input card number "444993876233"
        Input expiration date "03/24"
        Click process button*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        WebElement orderButton = driver.findElement(By.xpath("//li[.='Order']"));
        orderButton.click();
        WebElement product = driver.findElement(By.xpath("//select[@id=\"ctl00_MainContent_fmwOrder_ddlProduct\"]"));
        Select productSelect = new Select(product);
        productSelect.selectByVisibleText("ScreenSaver");
        WebElement quantity = driver.findElement(By.xpath("//input[@onchange=\"productsChanged()\"]"));
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_txtName\"]"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox3\"]"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]"));
        state.sendKeys("Illinois");
        WebElement zip = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]"));
        zip.sendKeys("60018");
        WebElement cardType = driver.findElement(By.xpath("//input[@value=\"MasterCard\"]"));
        cardType.click();
        WebElement cardNumber = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]"));
        cardNumber.sendKeys("444993876233");
        WebElement expirationDate = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]"));
        expirationDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.linkText("Process"));
        processButton.click();
        /*Validate text "New order has been successfully added." is displayed below the Process button.
        Click View all orders button
        Validate new order is added and all inputs are matching with new order*/
        WebElement text = driver.findElement(By.tagName("strong"));
        Assert.assertEquals(text.getText().trim(), "New order has been successfully added.");
        WebElement allOrdersButton = driver.findElement(By.xpath("//a[.='View all orders']"));
        allOrdersButton.click();

        List<String> expectedNewOrder = Arrays.asList("CodeFish IT School",
                "ScreenSaver",
                "5",
                "02/27/2023",
                "2200 E devon",
                "Des Plaines",
                "Illinois",
                "60018",
                "MasterCard",
                "444993876233",
                "03/24");
        List<WebElement> actualOrderInfo = driver.findElements(By.xpath("//tr[2]//td"));
        for (int i = 1; i < actualOrderInfo.size() - 2; i++) {
            Assert.assertEquals(actualOrderInfo.get(i + 1).getText().trim(), expectedNewOrder.get(i));
        }
    }
}
