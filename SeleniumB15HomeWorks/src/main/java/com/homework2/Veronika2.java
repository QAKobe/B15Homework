package com.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Veronika2 {

    @Test
    public void validateTitleHeader() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);
        WebElement userName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        userName.sendKeys("Tester");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement title2 = driver.findElement(By.tagName("h1"));
        String actualTitle2 = title2.getText().trim();
        String expectedTitle2 = "Web Orders";
        Assert.assertEquals(actualTitle2, expectedTitle2);
        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(actualHeader, expectedHeader);
        driver.quit();
    }

    /*
    Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
    Input username "Tester"
    Input password "Test"
    Click login button
    Click "View all products" button
    Validate "View all products" is selected
    Validate header is equals to "List of Products"
    Validate the url has "Products" keyword
    */
    @Test
    public void validateTitleHeaderUrl() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        userName.sendKeys("Tester");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement allProductsButton = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        allProductsButton.click();
        Thread.sleep(2000);
        WebElement allProductsButtonClicked = driver.findElement(By.cssSelector(".selected"));
        Assert.assertTrue(allProductsButtonClicked.isDisplayed());
        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "List of Products";
        Assert.assertEquals(actualHeader, expectedHeader);
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("Products"));
    }

    /*
    Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
    Input username "Tester"
    Input password "Test"
    Click login button
    Find the links for:
    View all orders
    View all products
    Order
    Validate their href values are equals to : "Default.aspx"
            "Products.aspx"
            "Process.aspx"*/
    @Test
    public void validateHref() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        userName.sendKeys("Tester");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement allOrdersButton = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        WebElement allProductsButton = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        WebElement orderButton = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        Assert.assertTrue(allOrdersButton.getAttribute("href").contains("Default.aspx"));
        Assert.assertTrue(allProductsButton.getAttribute("href").contains("Products.aspx"));
        Assert.assertTrue(orderButton.getAttribute("href").contains("Process.aspx"));
    }

    /* Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11 /WebOrders/Login.aspx?"
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
    Click Process button
     */
    @Test
    public void testMakingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement orderButton = driver.findElement(By.xpath("//a[@ href='Process.aspx']"));
        orderButton.click();
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        if (product.isDisplayed() && !product.isSelected()) {
            product.click();
        }
        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");
        WebElement zip = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys("60018");
        Thread.sleep(2000);
        WebElement paymentMethod = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        if (paymentMethod.isDisplayed() && paymentMethod.isEnabled() && !paymentMethod.isSelected()) {
            paymentMethod.click();
        }
        WebElement cardNumber = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");
        WebElement expirationDate = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();
        Thread.sleep(2000);

    /*
    Validate text "New order has been successfully added." is displayed below the Process button.
    Click View all orders button
    Validate new order is added and all inputs are matching with new order
     */
        WebElement webOrderTitle = driver.findElement(By.xpath("//title"));
        Assert.assertFalse(webOrderTitle.isDisplayed());
        WebElement allOrdersButton = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        allOrdersButton.click();
        Thread.sleep(2000);
        List<WebElement> actualOrderInfo = driver.findElements(By.xpath("//tr[2]")); //td
        List<String> expectedOrderInfo = Arrays.asList("", "CodeFish IT School", "ScreenSaver", "5", "02/22/2023", "2200 E devon", "Des Plaines", "Illinois", "60018", "MasterCard", "444993876233", "03/24", "");
        for (int i = 1; i < actualOrderInfo.size() - 1; i++) {
            Assert.assertEquals(actualOrderInfo.get(i).getText().trim(), expectedOrderInfo.get(i));
        }
}}
