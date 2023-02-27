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

public class Aida2 {

    @Test
    public void validateWebLoginTestScenario1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector(".button"));
        loginButton.click();

        WebElement webTitle = driver.findElement(By.xpath("//h1"));
        String actual = webTitle.getText().trim();
        String expected = "Web Orders";
        Assert.assertEquals(actual, expected);

        WebElement listHeader = driver.findElement(By.xpath("//h2"));
        String actualHeader = listHeader.getText().trim();
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
    public void validateProductsTestScenario2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector(".button"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement viewAllProdButton = driver.findElement(By.linkText("View all products"));
        viewAllProdButton.click();
        WebElement viewAllProdButton1 = driver.findElement(By.cssSelector(".selected"));
        Assert.assertTrue(viewAllProdButton1.isDisplayed());

        Thread.sleep(2000);
        WebElement listHeader1 = driver.findElement(By.xpath("//h2"));
        String actualHeader1 = listHeader1.getText().trim();
        String expectedHeader1 = "List of Products";
        Assert.assertEquals(actualHeader1, expectedHeader1);

        String actualUrl = driver.getCurrentUrl().trim();
        String expectedUrl = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Products.aspx";
        System.out.println(actualUrl.equals(expectedUrl) ? "Passed" : "Failed");

    }

    @Test
    public void viewAllOrdersAndProductsScenario3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector(".button"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement viewAllOrdersBtn = driver.findElement(By.linkText("View all orders"));
        Thread.sleep(2000);
        WebElement viewAllProductBtn = driver.findElement(By.linkText("View all products"));
        Thread.sleep(2000);
        WebElement orderBtn = driver.findElement(By.xpath("//li/a[.='Order']"));

        List<WebElement> linkValues = driver.findElements(By.linkText(".menu"));
        List<String> expectedValues = Arrays.asList("Default.aspx", "Products.aspx", "Process.aspx");
        for (int i = 0; i < linkValues.size(); i++) {
            Assert.assertTrue(viewAllOrdersBtn.getAttribute("href").contains("Default.aspx"));
            Assert.assertTrue(viewAllProductBtn.getAttribute("href").contains("Products.aspx"));
            Assert.assertTrue(orderBtn.getAttribute("href").contains("Process.aspx"));
           // Assert.assertEquals(linkValues.get(i).getAttribute("href"), expectedValues.get(i));
        }
    }

    @Test
    public void inputOrderInfoScenario4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector(".button"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement orderBtn = driver.findElement(By.xpath("//li/a[.='Order']"));
        orderBtn.click();

        WebElement productInfo = driver.findElement(By.xpath("//select[@onchange='productsChanged()']"));
        Select product = new Select(productInfo);
        product.selectByValue("ScreenSaver");

        WebElement quantityInfo = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantityInfo.sendKeys("5");
        WebElement customerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");
        WebElement zipCode = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zipCode.sendKeys("60018");

        WebElement card = driver.findElement(By.xpath("//input[@value='MasterCard']"));
        card.click();

        WebElement cardNum = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNum.sendKeys("444993876233");
        Thread.sleep(2000);
        WebElement ExpireDate = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        ExpireDate.sendKeys("03/24");
        Thread.sleep(2000);
        WebElement processButton = driver.findElement(By.cssSelector(".btn_light"));
        processButton.click();
        Thread.sleep(2000);

        WebElement message = driver.findElement(By.tagName("strong"));
        String actualMessage = message.getText().trim();
        String expectedMessage = "New order has been successfully added.";
        Assert.assertEquals(actualMessage, expectedMessage);

        List<WebElement> actualOrderInfo = driver.findElements(By.cssSelector("#ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
        List<String> expectedOrderInfo = Arrays.asList("", "CodeFish IT School", "ScreenSaver", "5", "02/22/2023", "2200 E devon", "Des Plaines", "Illinois", "60018", "MasterCard", "444993876233", "03/24", "");
        for (int i = 1; i < actualOrderInfo.size() - 1; i++) {
            Assert.assertEquals(actualOrderInfo.get(i).getText().trim(), expectedOrderInfo.get(i));
        }


    }
}
