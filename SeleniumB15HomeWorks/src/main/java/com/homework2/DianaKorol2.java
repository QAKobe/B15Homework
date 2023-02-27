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
import java.util.List;

public class DianaKorol2 {

    @Test
    public void TitleValidation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        String actualTitleSecondPage = driver.getTitle();
        Assert.assertEquals(actualTitleSecondPage, "Web Orders");

        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(BrowserUtils.getText(header), "List of All Orders");

    }


        //TEST CASE 2

    @Test
    public void validationListOfProducts() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement viewAllProductsButton = driver.findElement(By.linkText("View all products"));
        viewAllProductsButton.click();
        driver.navigate().back();
        List<WebElement> selectedProducts = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement products: selectedProducts){
            products.click();
            Assert.assertTrue(products.isSelected());
        }
        Thread.sleep(3000);
        driver.navigate().forward();
        WebElement header= driver.findElement(By.tagName("h2"));
        Assert.assertEquals(BrowserUtils.getText(header),"List of Products");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("Products"));


    }

    //TEST CASE 3
    @Test
    public void validationOfLinks(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();

        WebElement allOrdersLink = driver.findElement(By.linkText("View all orders"));
        Assert.assertTrue(allOrdersLink.getAttribute("href").contains("Default.aspx"));

        WebElement allProductsLink = driver.findElement(By.linkText("View all products"));
        Assert.assertTrue(allProductsLink.getAttribute("href").contains("Products.aspx"));

        WebElement orderLink = driver.findElement(By.linkText("Order"));
        Assert.assertTrue(orderLink.getAttribute("href").contains("Process.aspx"));

    }
    //  TEST CASE 4

    @Test
    public void validationOfProductScreenSaverAndMasterCard() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        WebElement orderButton = driver.findElement(By.linkText("Order"));
        orderButton.click();
        WebElement productBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        BrowserUtils.selectBy(productBox, "ScreenSaver", "text");

        WebElement quantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys("5");
        Thread.sleep(1000);
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();
        Thread.sleep(2000);
        WebElement customerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");

        WebElement street = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        city.sendKeys("Des Plaines");

        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");

        WebElement zipCode = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zipCode.sendKeys("60018");

        WebElement masterCardBox = driver.findElement(By.xpath("//input[@value='MasterCard']"));
        masterCardBox.click();
        Thread.sleep(1000);
        WebElement cardNumber = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");

        WebElement expirationDate = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.linkText("Process"));
        Thread.sleep(1000);
        processButton.click();
//PART 2
        WebElement textValidation = driver.findElement(By.xpath("//strong"));
        String actualText = BrowserUtils.getText(textValidation);
        String expectedText = "New order has been successfully added.";
        Assert.assertEquals(actualText, expectedText);

        WebElement viewAllOrder = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        viewAllOrder.click();
}}
