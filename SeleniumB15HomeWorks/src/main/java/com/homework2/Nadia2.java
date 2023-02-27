package com.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Nadia2 {

    @Test
    public void testCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        String title = driver.getTitle();
        String expected = "Web Orders Login";
        Assert.assertEquals(title, expected);
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        Thread.sleep(500);
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        Thread.sleep(500);
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();
        Thread.sleep(500);
        String title2 = driver.getTitle();
        String expectedTitle = "Web Orders";
        Assert.assertEquals(title2, expectedTitle);
        Thread.sleep(500);
        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = header.getText();
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(actualHeader, expectedHeader);
        driver.close();
    }

    @Test
    public void testCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        Thread.sleep(1000);
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        Thread.sleep(1000);
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();
        Thread.sleep(1000);

        WebElement viewAllProductsButton = driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        viewAllProductsButton.click();
        WebElement viewAllProductsClicked = driver.findElement(By.xpath("//li[@class='selected']"));
        Assert.assertTrue(viewAllProductsClicked.isDisplayed());
        Thread.sleep(1000);

        WebElement headerProducts = driver.findElement(By.tagName("h2"));
        String actualHeader = headerProducts.getText();
        String expectedHeader = "List of Products";
        Assert.assertEquals(actualHeader, expectedHeader);

        Assert.assertTrue(driver.getCurrentUrl().contains("Products"), "Products");

        driver.close();
    }

    @Test
    public void testCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        Thread.sleep(1000);
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        Thread.sleep(1000);
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();
        Thread.sleep(1000);

        WebElement viewAllOrdersLink = driver.findElement(By.xpath("//a[contains(text(),'View all orders')]"));
        System.out.println(viewAllOrdersLink.getAttribute("href"));
        Assert.assertEquals(true, viewAllOrdersLink.getAttribute("href").contains("Default.aspx"));

        WebElement viewAllProductsButton = driver.findElement(By.xpath("//a[contains(text(), 'View all products')]"));
        System.out.println(viewAllProductsButton.getAttribute("href"));
        ;
        Assert.assertEquals(true, viewAllProductsButton.getAttribute("href").contains("Products.aspx"));

        WebElement orders = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        System.out.println(orders.getAttribute("href"));
        ;
        Assert.assertEquals(true, orders.getAttribute("href").contains("Process.aspx"));

        driver.close();
    }

    @Test
    public void testCase4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();
        Thread.sleep(1000);

        WebElement orderButton = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        orderButton.click();

        WebElement productSelectionBox = driver.findElement(By.tagName("select"));
        Select productSelection = new Select(productSelectionBox);
        productSelection.selectByVisibleText("ScreenSaver");
        Thread.sleep(1000);

        WebElement quantity = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
        quantity.clear();
        quantity.sendKeys("5");
        Thread.sleep(1000);

        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("Code Fish IT School");
        Thread.sleep(1000);

        WebElement address = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        address.sendKeys("2200E Devon");
        Thread.sleep(1000);

        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");
        Thread.sleep(1000);

        WebElement state = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        state.sendKeys("Illinois");
        Thread.sleep(1000);

        WebElement zipcode = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        zipcode.sendKeys("60018");
        Thread.sleep(1000);

        WebElement paymentSelection = driver.findElement(By.xpath("//label[@for='ctl00_MainContent_fmwOrder_cardList_1']"));
        paymentSelection.click();
        Thread.sleep(1000);

        WebElement cardNumber = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
        cardNumber.sendKeys("444993876233");
        Thread.sleep(1000);


        WebElement expirationDate = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
        expirationDate.sendKeys("03/24");
        Thread.sleep(1000);

        WebElement processButton = driver.findElement(By.xpath("//a[@class='btn_light']"));
        processButton.click();
        Thread.sleep(1000);

        WebElement message = driver.findElement(By.tagName("strong"));
        String expectedMessage = "New order has been successfully added.";
        Assert.assertEquals(expectedMessage, message.getText());

        WebElement viewAllOrdersLink = driver.findElement(By.xpath("//a[contains(text(),'View all orders')]"));
        viewAllOrdersLink.click();
        Thread.sleep(1000);


        List<WebElement> actualOrderInfo = driver.findElements(By.xpath("//tr[2]//td"));
        List<String> expectedOrderInfo = Arrays.asList("", "Code Fish IT School", "ScreenSaver", "5", "02/27/2023", "2200E Devon", "Des Plaines", "Illinois", "60018", "MasterCard", "444993876233", "03/24", "");
        for (int i = 1; i < actualOrderInfo.size() - 1; i++) {
            Assert.assertEquals(actualOrderInfo.get(i).getText().trim(), expectedOrderInfo.get(i));
        }
    }
}