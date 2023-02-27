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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Saltanat {

    @Test
    public void testScenario1()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        String actualTitle= driver.getTitle().trim();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);
        Thread.sleep(3000);
        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton= driver.findElement(By.xpath("//input[@class='button']"));
        loginButton.click();
        WebElement validateTitle= driver.findElement(By.xpath("//h1"));
        String actualValidation=validateTitle.getText().trim();
        String expectedValidation="Web Orders";
        Assert.assertEquals(actualValidation,expectedValidation);

        WebElement validateListOfAllOrders= driver.findElement(By.xpath("//h2"));
        String actualValidate=validateListOfAllOrders.getText().trim();
        String expectedValidate="List of All Orders";
        Assert.assertEquals(actualValidate,expectedValidate);
    }
    @Test
    public void testScenario2()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        String actualTitle= driver.getTitle().trim();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);
        Thread.sleep(3000);
        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton= driver.findElement(By.xpath("//input[@class='button']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement viewAllProducts= driver.findElement(By.linkText("View all products"));
        Assert.assertFalse(viewAllProducts.isSelected());
        viewAllProducts.click();

        WebElement listOfProducts= driver.findElement(By.xpath("//h2"));
        String actualHeader=listOfProducts.getText().trim();
        String expectedHeader="List of Products";
        Assert.assertEquals(actualHeader,expectedHeader);

        Assert.assertTrue(driver.getCurrentUrl().contains("Products"));
    }
    @Test
    public void testScenario3()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        String actualTitle= driver.getTitle().trim();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);
        Thread.sleep(3000);
        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton= driver.findElement(By.xpath("//input[@class='button']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement viewAllOrders= driver.findElement(By.linkText("View all orders"));
        Assert.assertFalse(viewAllOrders.getText().trim().contains("Default.aspx"));
        WebElement viewAllProducts= driver.findElement(By.linkText("View all products"));
        Assert.assertFalse(viewAllProducts.getText().trim().contains("Products.aspx"));
        WebElement orders= driver.findElement(By.linkText("Order"));
        Assert.assertFalse(orders.getText().trim().contains("Process.aspx"));
    }
    @Test
    public void testScenario4()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        String actualTitle= driver.getTitle().trim();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);
        Thread.sleep(3000);
        WebElement userName= driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton= driver.findElement(By.xpath("//input[@class='button']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement orderButton= driver.findElement(By.linkText("Order"));
        orderButton.click();
        Thread.sleep(2000);

        WebElement selectScreenSaver= driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        BrowserUtils.selectBy(selectScreenSaver,"ScreenSaver","text");
        WebElement quantity= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("5");
        WebElement customerName= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("John Doe");
        WebElement street= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E devon");
        WebElement city= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("DesPlaines");
        WebElement state= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");
        WebElement zipCode= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zipCode.sendKeys("60018");
        WebElement masterCard= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        masterCard.click();
        WebElement masterCardNumber= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        masterCardNumber.sendKeys("444993876233");
        WebElement expirationDate= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("03/24");
        WebElement processButton= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();
        Thread.sleep(3000);

        String actualText= driver.getTitle().trim();
        String expectedText="New order has been successfully added.";
        Assert.assertFalse(actualText.isEmpty(),expectedText);
        Thread.sleep(3000);

        WebElement viewAllOrder= driver.findElement(By.cssSelector("View all orders"));
        viewAllOrder.click();

        List<WebElement> elements=driver.findElements(By.xpath("//table[@class='SampleTable']//tbody//tr[2]//td"));
        List<String> expected= Arrays.asList("John Doe","ScreenSaver","5","    02/25/2023","2200 E devon","DesPlaines",
                "Illinois","60018","MasterCard","444993876233","03/24" );
        List <String> actual= new ArrayList<>();
        for (int i=1; i< elements.size()-1;i++){
            actual.add(BrowserUtils.getText(elements.get(i)));
        }
        Assert.assertEquals(expected,actual);
}}
