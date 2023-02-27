package com.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OlgaM2 {

    @Test
    public void homeWork2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        Thread.sleep(2000);

        WebElement clickLogin = driver.findElement(By.xpath("//input[@value='Login']"));
        clickLogin.click();
        Thread.sleep(2000);

        WebElement title = driver.findElement(By.tagName("h1"));
        String actualTitle = title.getText().trim();
        String expectedTitle = "Web Orders";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(actualHeader,expectedHeader);

    }
    @Test
    public void homeWorlTask2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement clickLogin = driver.findElement(By.xpath("//input[@value='Login']"));
        clickLogin.click();

        WebElement allProduct = driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        allProduct.click();
        Thread.sleep(3000);

        WebElement allProductsSelected = driver.findElement(By.xpath("//li[@class='selected']"));
        Assert.assertEquals(allProductsSelected.getAttribute("class"),"selected");

        WebElement listOfProduct = driver.findElement(By.tagName("h2"));
        String actualList = listOfProduct.getText().trim();
        String expectedList = "List of Products";
        Assert.assertEquals(actualList,expectedList);

    }
    @Test
    public void homeWorkTask3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement clickLogin = driver.findElement(By.xpath("//input[@value='Login']"));
        clickLogin.click();

        WebElement viewAllOrders = driver.findElement(By.xpath("//a[.='View all orders']"));
        viewAllOrders.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("Default.aspx"));
        Thread.sleep(2000);

        WebElement viewAllProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        viewAllProducts.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("Products.aspx"));
        Thread.sleep(2000);

        WebElement orders = driver.findElement(By.xpath("//a[.='Order']"));
        orders.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("Process.aspx"));
        Thread.sleep(2000);

    }
    @Test
    public void homeWorkTask4() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement clickLogin = driver.findElement(By.xpath("//input[@value='Login']"));
        clickLogin.click();

        WebElement orders = driver.findElement(By.xpath("//a[.='Order']"));
        orders.click();

        WebElement screenSaver = driver.findElement(By.xpath("//option[contains(text(),'ScreenSaver')]"));
        screenSaver.click();
        Thread.sleep(2000);

        WebElement quality = driver.findElement(By.xpath("//input[@onchange='productsChanged()']"));
        quality.sendKeys("5");

        WebElement customerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");
        Thread.sleep(2000);

        WebElement streetName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        streetName.sendKeys("2200 E devon");
        Thread.sleep(2000);

        WebElement city = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        Thread.sleep(2000);

        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");
        Thread.sleep(2000);

        WebElement zip = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys("60018");
        Thread.sleep(2000);

        WebElement creditCard = driver.findElement(By.xpath("//input[@value='MasterCard']"));
        creditCard.click();
        Thread.sleep(2000);

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys("444993876233");
        Thread.sleep(2000);

        WebElement expirationDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expirationDate.sendKeys("03/24");
        Thread.sleep(2000);

        WebElement processClick = driver.findElement(By.xpath("//a[contains(text(),'Process')]"));
        processClick.click();

        //Case4SecondPart
        WebElement valideteText = driver.findElement(By.xpath("//strong['New order has been successfully added.']"));
        String actualText = valideteText.getText().trim();
        String expectedText = "New order has been successfully added.";
        Assert.assertEquals(actualText,expectedText);

        WebElement newOrder = driver.findElement(By.xpath("//a[.='View all orders']"));
        newOrder.click();

        List<WebElement> checkOrder = driver.findElements(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl02_OrderSelector']"));

        List<String> actualOrder = new ArrayList<>();
        List<String> expectedOreder = new ArrayList<>();

        for (int i = 1; i<checkOrder.size()-1;i++){
            actualOrder.add(checkOrder.get(i).getText().trim().toLowerCase());
            expectedOreder.add(checkOrder.get(i).getText().toLowerCase().trim());
        }
        Assert.assertEquals(actualOrder,expectedOreder);
    }

}
