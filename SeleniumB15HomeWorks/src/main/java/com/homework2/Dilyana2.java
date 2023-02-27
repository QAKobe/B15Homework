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

public class Dilyana2 {

    @Test
    public void testTrue(){
        System.out.println("true");
    }

    @Test
    public void testFalse() {
        System.out.println("false");
    }

    @Test

    public void testCase1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle= driver.getTitle().trim();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement username= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");

        WebElement password= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        password.sendKeys("test");

        WebElement logInButton= driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        logInButton.click();

        String expectedTitle2= "Web Orders";
        Assert.assertEquals(driver.getTitle().trim(),expectedTitle2);

        WebElement header= driver.findElement(By.tagName("h2"));
        String actualHeader= header.getText().trim();
        String expectedHeader= "List of All Orders";
        Assert.assertEquals(actualHeader,expectedHeader);

    }

    @Test
    public void testCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");

        WebElement password= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        password.sendKeys("test");

        WebElement logInButton= driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        logInButton.click();
        Thread.sleep(3000);

        WebElement allProductsButton= driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        allProductsButton.click();



        WebElement productsHeader= driver.findElement(By.tagName("h2"));
        String actualProductsHeader= productsHeader.getText().trim();
        String expectedProductsHeader="List of Products";

        Assert.assertEquals(actualProductsHeader,expectedProductsHeader);

        String actualURL= driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains("Products"));


    }

    @Test
    public void testCase3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");

        WebElement password= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        password.sendKeys("test");

        WebElement logInButton= driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        logInButton.click();

        WebElement linkViewAllOrders= driver.findElement(By.linkText("View all orders"));
        Assert.assertTrue(linkViewAllOrders.getAttribute("href").contains("Default.aspx"));
        WebElement linkViewAllProducts= driver.findElement(By.linkText("View all products"));
        Assert.assertTrue(linkViewAllProducts.getAttribute("href").contains("Products.aspx"));
        WebElement linkOrder= driver.findElement(By.linkText("Order"));
        Assert.assertTrue(linkOrder.getAttribute("href").contains("Process.aspx"));


    }

    @Test
    public void testCase4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");

        WebElement password= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        password.sendKeys("test");

        WebElement logInButton= driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        logInButton.click();

        WebElement orderButton= driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        orderButton.click();

        WebElement product= driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']"));
        Select productOptions= new Select(product);
        productOptions.selectByValue("ScreenSaver");
        WebElement quantity= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys("5");
        WebElement customerName= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");
        WebElement city= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        WebElement state= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois ");
        WebElement xipCode= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        xipCode.sendKeys("60018");

        WebElement card= driver.findElement(By.xpath("//input[@value='MasterCard']"));
        card.click();
        WebElement cardNum= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNum.sendKeys("444993876233");

        WebElement expDate= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expDate.sendKeys("03/24");
        Thread.sleep(3000);

        WebElement processButton= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();







    }


    @Test
    public void testCase4Part2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");

        WebElement password= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        password.sendKeys("test");

        WebElement logInButton= driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        logInButton.click();

        WebElement orderButton= driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        orderButton.click();

        WebElement product= driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']"));
        Select productOptions= new Select(product);
        productOptions.selectByValue("ScreenSaver");
        WebElement quantity= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys("5");
        WebElement customerName= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");
        WebElement city= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        WebElement state= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois ");
        WebElement xipCode= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        xipCode.sendKeys("60018");

        WebElement card= driver.findElement(By.xpath("//input[@value='MasterCard']"));
        card.click();
        WebElement cardNum= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNum.sendKeys("444993876233");

        WebElement expDate= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expDate.sendKeys("03/24");
        Thread.sleep(3000);

        WebElement processButton= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        WebElement message = driver.findElement(By.tagName("strong"));
        String actualMessage= message.getText().trim();
        String expectedMessage="New order has been successfully added.";
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement allOrderButton= driver.findElement(By.xpath("//a[contains(text(),'View all orders')]"));
        allOrderButton.click();


        List<WebElement> listOfOrders= driver.findElements(By.cssSelector(".SampleTable"));


        List<String> expectedOrder= Arrays.asList("CodeFish IT School", "ScreenSaver", "5", "02/27/2023","2200 E devon", "Des Plaines", "Illinois",
                "60018","MasterCard","444993876233","03/24");

        for(int i=0; i<listOfOrders.size(); i++){
            for(int k=0; k<expectedOrder.size();k++){
                Thread.sleep(1000);
                Assert.assertTrue(listOfOrders.get(i).getText().contains(expectedOrder.get(k)));
            }
        }
}}
