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

public class Savva2 {

    @Test
    public void case1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Thread.sleep(1000);

        WebElement title = driver.findElement(By.xpath("//title"));
        System.out.println(BrowserUtils.getText(title).equals("Web Orders Login") ? "Main title validation passed!" : "Main title validation failed");

        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        WebElement submitButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        submitButton.click();
        Thread.sleep(2000);

        WebElement webOrderTitle = driver.findElement(By.xpath("//title"));
        System.out.println(BrowserUtils.getText(webOrderTitle).equals("Web Orders") ?
                "Web Orders title validation passed" : "Web Orders title validation failed");

        WebElement ordersList = driver.findElement(By.xpath("//h2[contains(text(),'List of All Orders')]"));
        System.out.println(BrowserUtils.getText(ordersList).equals("List of All Orders") ?
                "Order List validation passed" : "Order List validation failed");
    }

    @Test
    public void case2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Thread.sleep(1000);

        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        WebElement submitButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        submitButton.click();
        Thread.sleep(2000);

        WebElement viewAllProducts = driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        viewAllProducts.click();
        Thread.sleep(1000);
        WebElement viewAllProductsValidation = driver.findElement(By.xpath("//li[@class='selected']"));
        System.out.println(BrowserUtils.getText(viewAllProductsValidation).equals("View all products") ?
                "View all products validation passed" : "View all products validation failed");

        WebElement listOfProductsHeader = driver.findElement(By.xpath("//h2[contains(text(),'List of Products')]"));
        System.out.println(BrowserUtils.getText(listOfProductsHeader).equals("List of Products") ?
                "List of Products header validation passed" : "List of Products header validation failed");

        String urlProductsValidation = driver.getCurrentUrl();
        System.out.println(urlProductsValidation.contains("Products") ? "URL 'Products' validation passed" :
                "URL 'Products' validation failed");

    }

    @Test
    public void case3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Thread.sleep(1000);

        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        WebElement submitButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        submitButton.click();
        Thread.sleep(2000);

        List<WebElement> actualHrefValues = driver.findElements(By.xpath("//li"));
        List<String> expectedHrefValues = Arrays.asList("Default.aspx", "Products.aspx", "Process.aspx");
        for (int x = 0; x < actualHrefValues.size(); x++) {
            String value = actualHrefValues.get(x).findElement(By.xpath("//a")).getCssValue("href");
            if (expectedHrefValues.contains(expectedHrefValues.get(x))) {
                System.out.println("Href value :" + expectedHrefValues.get(x) + " - validation passed");
            } else {
                System.out.println(x + "Validation failed");
            }
        }

    }

    @Test
    public void case4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Thread.sleep(1000);

        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        WebElement submitButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        submitButton.click();
        Thread.sleep(2000);

        WebElement orderLink = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        orderLink.click();
        Thread.sleep(2000);

        WebElement productDropDown = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        BrowserUtils.selectBy(productDropDown, "ScreenSaver", "value");

        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("5");
        Thread.sleep(1000);

        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("CodeFish IT School");
        Thread.sleep(1000);

        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E devon");
        Thread.sleep(1000);

        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");
        Thread.sleep(1000);

        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("Illinois");
        Thread.sleep(1000);

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipCode.sendKeys("60018");
        Thread.sleep(1000);

        WebElement selectCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        selectCard.click();

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys("444993876233");
        Thread.sleep(1000);

        WebElement expirationDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expirationDate.sendKeys("03/24");
        Thread.sleep(1000);

        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();
        Thread.sleep(1000);
        WebElement processSuccessfull = driver.findElement(By.xpath("//strong"));
        System.out.println(BrowserUtils.getText(processSuccessfull).equals("New order has been successfully added.") ? "'Process' text validation passed" :
                "'Process' text validation failed");

        WebElement myOrders = driver.findElement(By.xpath("//a[contains(text(),'View all orders')]"));
        myOrders.click();
        Thread.sleep(2000);

        WebElement addOrder = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl02_OrderSelector']"));
        addOrder.click();
        System.out.println(addOrder.isSelected() ? "Order select validation passed" : "Order select validation failed");

        List<WebElement> actualOrderInfo=driver.findElements(By.xpath("//tr[2]//td"));
        List<String> expectedOrderInfo = Arrays.asList("","CodeFish IT School","ScreenSaver","5","02/26/2023","2200 E devon","Des Plaines","Illinois","60018","MasterCard","444993876233","03/24","");
        for (int i = 1; i <actualOrderInfo.size()-1 ; i++) {
            Assert.assertEquals(actualOrderInfo.get(i).getText().trim(),expectedOrderInfo.get(i));
        }
        System.out.println("All inputs are matching with new order");
    }
}
