package com.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class VitaliyAn2 {

    @Test
    public void TestCase1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        System.out.println(actualTitle.equals(expectedTitle) ? "TRUE" : "FALSE");
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement logInButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        logInButton.click();
        String actualTitleNextPage = driver.getTitle().trim();
        String expectedTitleNextPage = "Web Orders";
        System.out.println(actualTitleNextPage.equals(expectedTitleNextPage) ? "TRUE" : "FALSE");
        WebElement header = driver.findElement(By.xpath("//h2"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "List of All Orders";
        System.out.println(actualHeader.equals(expectedHeader) ? "TRUE" : "FALSE");
    }
    @Test
    public void TestCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestCo\n" +
                "mplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement logInButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        logInButton.click();
        WebElement viewAllProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        viewAllProducts.click();
        Thread.sleep(2000);
        String expectedUrl = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Products.aspx";
        if (driver.getCurrentUrl().equals(expectedUrl)) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
        WebElement header = driver.findElement(By.xpath("//h2"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "List of Products";
        System.out.println(actualHeader.equals(expectedHeader) ? "TRUE" : "FALSE");
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl.contains("Products") ? "TRUE" : "FALSE");
    }
    @Test
    public void TestCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestCo\n" +
                "mplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement logInButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        logInButton.click();
        Thread.sleep(2000);
        String viewAllOrdersUrl = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx";
        String allProductsUrl = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Products.aspx";
        String ordersUrl = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Process.aspx";
//        System.out.println(viewAllOrdersUrl.contains("Default.aspx")?"TRUE":"FALSE");
//        System.out.println(allProductsUrl.contains("Products.aspx")?"TRUE":"FALSE");
//        System.out.println(ordersUrl.contains("Process.aspx")?"TRUE":"FALSE");
        WebElement viewAllOrderButton = driver.findElement(By.xpath("//a[.='View all orders']"));
        WebElement viewAllProductsButton = driver.findElement(By.xpath("//a[.='View all products']"));
        WebElement orderButton = driver.findElement(By.xpath("//a[.='Order']"));
        System.out.println(viewAllOrderButton.getAttribute("href").contains("Default.aspx") ? "TRUE" : "FALSE");
        System.out.println(viewAllProductsButton.getAttribute("href").contains("Products.aspx") ? "TRUE" : "FALSE");
        System.out.println(orderButton.getAttribute("href").contains("Process.aspx") ? "TRUE" : "FALSE");
    }
    @Test
    public void TestCase4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestCo\n" +
                "mplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement logInButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        logInButton.click();
        Thread.sleep(2000);
        WebElement orderButton = driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();
        WebElement productBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        BrowserUtils.selectBy(productBox, "ScreenSaver", "value");
        WebElement screenSaver = driver.findElement(By.xpath("//option[.='ScreenSaver']"));
        WebElement quantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.clear();
        quantity.sendKeys("5");
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
        WebElement masterCardButton = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        masterCardButton.click();
        WebElement cardNumber = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");
        WebElement expirationDate = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        Thread.sleep(3000);
        processButton.click();
        Thread.sleep(2000);
        //Part2
        WebElement header = driver.findElement(By.xpath("//strong"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "New order has been successfully added.";
        System.out.println(actualHeader.equals(expectedHeader) ? "TRUE" : "FALSE");
        System.out.println(header.isDisplayed() ? "TRUE" : "FALSE");
        WebElement viewAllOrdersButton = driver.findElement(By.xpath("//a[.='View all orders']"));
        viewAllOrdersButton.click();
        WebElement nameCodeFish = driver.findElement(By.xpath("//td[.='CodeFish IT School']"));
        String nameOrder = BrowserUtils.getText(nameCodeFish);
        System.out.println(nameCodeFish.isDisplayed() ? "TRUE" : "FALSE");
        WebElement productOrder = driver.findElement(By.xpath("//td[.='ScreenSaver']"));
        WebElement quantityOrder = driver.findElement(By.xpath("//td[.='5']"));
        WebElement dateOrder = driver.findElement(By.xpath("//td[.='02/26/2023']"));
        WebElement streetOrder = driver.findElement(By.xpath("//td[.='2200 E devon']"));
        WebElement cityOrder = driver.findElement(By.xpath("//td[.='Des Plaines']"));
        WebElement stateOrder = driver.findElement(By.xpath("//td[.='Illinois']"));
        WebElement zipOrder = driver.findElement(By.xpath("//td[.='60018']"));
        WebElement cardOrder = driver.findElement(By.xpath("//td[.='MasterCard']"));
        WebElement cardNumberOrder = driver.findElement(By.xpath("//td[.='444993876233']"));
        WebElement expOrder = driver.findElement(By.xpath("//td[.='03/24']"));
        if (nameOrder.equals("CodeFish IT School") && BrowserUtils.getText(productOrder).equals("ScreenSaver") && BrowserUtils.getText(quantityOrder).equals("5")
                && BrowserUtils.getText(dateOrder).equals("02/26/2023")
                && BrowserUtils.getText(streetOrder).equals("2200 E devon")
                && BrowserUtils.getText(cityOrder).equals("Des Plaines")
                && BrowserUtils.getText(stateOrder).equals("Illinois")
                && BrowserUtils.getText(zipOrder).equals("60018")
                && BrowserUtils.getText(cardOrder).equals("MasterCard")
                && BrowserUtils.getText(cardNumberOrder).equals("444993876233")
                && BrowserUtils.getText(expOrder).equals("03/24")) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
}}

