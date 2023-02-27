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
import java.util.Arrays;
import java.util.List;

public class JohnPak2 {

    @Test
    public void Task1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String title= driver.getTitle();
        String actualTitle=title.trim();
        System.out.println(actualTitle);
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");

        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        WebElement title2= driver.findElement(By.tagName("title"));
        String actualTitle2=title2.getText().trim();
        String expectedTitle2="Web Orders";

        WebElement header= driver.findElement(By.tagName("h2"));
        String actualHeader= header.getText().trim();
        String expectedHeader="List of All Orders";
    }

    @Test
    public void task2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");

        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        WebElement viewAllProducts= driver.findElement(By.linkText("View all products"));
        viewAllProducts.click();

        WebElement viewAllProductsIsSelected= driver.findElement(By.xpath("//li[@class='selected']"));
        Assert.assertTrue(viewAllProductsIsSelected.isDisplayed());

        WebElement header= driver.findElement(By.tagName("h2"));
        String actualHeader=header.getText().trim();
        String expectedHeader="List of Products";
        Assert.assertEquals(actualHeader,expectedHeader);

        String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("Products"));
    }

    @Test
    public void task3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");

        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        WebElement viewAllOrdersHREF= driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        Assert.assertTrue(viewAllOrdersHREF.getAttribute("href").contains("Default.aspx"));

        WebElement viewAllProductsHREF= driver.findElement(By.linkText("View all products"));
        Assert.assertTrue(viewAllProductsHREF.getAttribute("href").contains("Products.aspx"));

        WebElement orderHREF= driver.findElement(By.linkText("Order"));
        Assert.assertTrue(orderHREF.getAttribute("href").contains("Process.aspx"));
    }

    @Test
    public void task4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");

        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        WebElement orderButton= driver.findElement(By.linkText("Order"));
        orderButton.click();

        WebElement productBox= driver.findElement(By.xpath("//select[@onchange='productsChanged()']"));
        BrowserUtils.selectBy(productBox,"ScreenSaver","value");

        WebElement quantityBox= driver.findElement(By.xpath("//input[@onchange='productsChanged()']"));
        quantityBox.sendKeys("5");

        WebElement customerNameBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerNameBox.sendKeys("CodeFish IT School");

        WebElement streetBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        streetBox.sendKeys("2200 E devon");

        WebElement cityBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        cityBox.sendKeys("Des Plaines");

        WebElement stateBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        stateBox.sendKeys("Illinois");

        WebElement zipBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipBox.sendKeys("60018");

        WebElement card= driver.findElement(By.xpath("//input[@value='MasterCard']"));
        card.click();

        WebElement cardNumber= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys("444993876233");

        WebElement expDate= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expDate.sendKeys("03/24");

        WebElement processButton= driver.findElement(By.xpath("//a[contains(text(),'Process')]"));
        processButton.click();

        // part 2

        WebElement newOrderDisplayed= driver.findElement(By.xpath("//strong[contains(text(),'New order has been successfully added.')]"));
        Assert.assertTrue(newOrderDisplayed.isDisplayed());

        WebElement viewAllOrders= driver.findElement(By.linkText("View all orders"));
        viewAllOrders.click();

        WebElement name= driver.findElement(By.xpath("//td[contains(text(),'CodeFish IT School')]"));
        Assert.assertTrue(name.isDisplayed());

        WebElement product= driver.findElement(By.xpath("//td[contains(text(),'ScreenSaver')]"));
        Assert.assertTrue(product.isDisplayed());

        WebElement numberOfOrders= driver.findElement(By.xpath("//td[contains(text(),'5')]"));
        Assert.assertTrue(numberOfOrders.isDisplayed());

        WebElement date= driver.findElement(By.xpath("//td[contains(text(),'02/27/2023')]"));
        Assert.assertTrue(date.isDisplayed());

        List<WebElement> actualOrderInfo=driver.findElements(By.xpath("//tr[2]//td"));
        List<String> expectedOrderInfo = Arrays.asList("","CodeFish IT School","ScreenSaver","5","02/27/2023","2200 E devon","Des Plaines","Illinois","60018","MasterCard","444993876233","03/24","");
        for (int i = 1; i <actualOrderInfo.size()-1 ; i++) {
            Assert.assertEquals(actualOrderInfo.get(i).getText().trim(),expectedOrderInfo.get(i));
        }
}}
