package com.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Alena2 {

    @Test()
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String title = driver.getTitle().trim();
        String expected = "Web Orders Login";
        Assert.assertEquals(title, expected);
        WebElement login = driver.findElement(By.xpath("//input[@type='text']"));
        login.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        Thread.sleep(2000);
        password.sendKeys(Keys.ENTER);
        String title1 = driver.getTitle().trim();
        String expected1 = "Web Orders";
        Assert.assertEquals(title1, expected1);
        WebElement header = driver.findElement(By.tagName("h2"));
        String headerString = header.getText().trim();
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(headerString, expectedHeader);
        driver.quit();
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement login = driver.findElement(By.xpath("//input[@type='text']"));
        login.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        Thread.sleep(2000);
        password.sendKeys(Keys.ENTER);
        WebElement allProductsButton = driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        allProductsButton.click();
        Thread.sleep(3000);
        WebElement selected = driver.findElement(By.cssSelector(".selected"));
        String actual = selected.getText().trim();
        String expected = "View all products";
        Assert.assertEquals(actual, expected);
        WebElement header = driver.findElement(By.tagName("h2"));
        String headerString = header.getText().trim();
        String expectedHeader = "List of Products";
        Assert.assertEquals(headerString, expectedHeader);
        String url = driver.getCurrentUrl().trim();
        String keyword = "Products";
        Assert.assertTrue(url.contains(keyword));
        driver.quit();

    }

    @Test
    public void test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement login = driver.findElement(By.xpath("//input[@type='text']"));
        login.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        Thread.sleep(2000);
        password.sendKeys(Keys.ENTER);
        WebElement allOrders = driver.findElement(By.xpath("//a[.='View all orders']"));
        WebElement allProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        WebElement orders = driver.findElement(By.xpath("//a[.='Order']"));
        Thread.sleep(3000);
        String actualAllOrders = allOrders.getAttribute("href").trim();
        String expectedAllOrders = "Default.aspx";
        String actualAllProducts = allProducts.getAttribute("href").trim();
        String expectedAllProducts = "Products.aspx";
        String actualOrders = orders.getAttribute("href").trim();
        String expectedOrders = "Process.aspx";
        Assert.assertTrue(actualAllOrders.contains(expectedAllOrders));
        Assert.assertTrue(actualAllProducts.contains(expectedAllProducts));
        Assert.assertTrue(actualOrders.contains(expectedOrders));
        driver.quit();

    }

    @Test
    public void test4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement login = driver.findElement(By.xpath("//input[@type='text']"));
        login.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        Thread.sleep(2000);
        password.sendKeys(Keys.ENTER);
        WebElement orders = driver.findElement(By.xpath("//a[.='Order']"));
        orders.click();
        WebElement select = driver.findElement(By.tagName("select"));
        BrowserUtils.selectBy(select, "ScreenSaver", "value");
        WebElement quantity = driver.findElement(By.xpath("//input[@onchange='productsChanged()']"));
        quantity.clear();
        Thread.sleep(2000);
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");
        WebElement zipcode = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zipcode.sendKeys("60018");
        WebElement card = driver.findElement(By.xpath("//input[@value='MasterCard']"));
        Thread.sleep(3000);
        card.click();
        WebElement cardNumber = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");
        WebElement expDate = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.className("btn_light"));
        Thread.sleep(2000);
        processButton.click();
        WebElement sucAdded = driver.findElement(By.tagName("strong"));
        Assert.assertEquals(sucAdded.getText().trim(), "New order has been successfully added.");
        WebElement allOrders = driver.findElement(By.xpath("//a[.='View all orders']"));
        Thread.sleep(2000);
        allOrders.click();
        List<WebElement> validation = driver.findElements(By.xpath("//tr[2]//td"));
        List<String> actual = new ArrayList<>();
        List<String> expected = Arrays.asList("CodeFish IT School", "ScreenSaver", "5", "02/27/2023", "2200 E devon", "Des Plaines", "Illinois", "60018", "MasterCard", "444993876233", "03/24");
        Thread.sleep(3000);
        for (int i = 1; i < validation.size() - 1; i++) {
            actual.add(BrowserUtils.getText(validation.get(i)));
        }
        Collections.sort(actual);
        Collections.sort(expected);
        Thread.sleep(3000);
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(actual.get(i), expected.get(i));
        }
        driver.quit();
        // System.out.println(actual);
        // System.out.println(expected);

    }

}
