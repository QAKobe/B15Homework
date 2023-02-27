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

public class IvanaKnezevic2 {

    @Test
    public void task1() throws InterruptedException {

       /* Test Scenario
        Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
        Validate the title is equals to "Web Orders Login" Input username "Tester"
        Input password "test"
        Click login button
        Validate the title is equals to "Web Orders"
        Validate header is equals to "List of All Orders"

        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        Thread.sleep(2000);

        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        Thread.sleep(2000);

        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement title= driver.findElement(By.tagName("h1"));
        String actualTitle=title.getText().trim();
        String expectedTitle="Web Orders";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement header= driver.findElement(By.tagName("h2"));
        String actualHeader=header.getText().trim();
        String expectedHeader="List of All Orders";
        Assert.assertEquals(actualHeader,expectedHeader);
    }

    @Test
    public void task2() throws InterruptedException {

        /*
        Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
        Input username "Tester"
        Input password "Test"
        Click login button
        Click "View all products" button
        Validate "View all products" is selected
        Validate header is equals to "List of Products"
        Validate the url has "Products" keyword
        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");

        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();


        WebElement allProduct= driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        allProduct.click();
        Thread.sleep(3000);

        WebElement allProductsSelected= driver.findElement(By.xpath("//li[@class='selected']"));
        Assert.assertEquals(allProductsSelected.getAttribute("class"),"selected");

        WebElement listOfProducts= driver.findElement(By.tagName("h2"));
        String actualList=listOfProducts.getText().trim();
        String expectedList="List of Products";
        Assert.assertEquals(actualList,expectedList);

    }

    @Test
    public void Task3() throws InterruptedException {
        /*
        Navigate to
       "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
        Input username "Tester"
        Input password "Test"
        Click login button
        Find the links for
        View all orders
        View all products
        Orders
        Validate their href values are equals to :
        "Default.aspx"
        "Products.aspx"
        "Process.aspx"
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");

        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        WebElement viewAllOrders= driver.findElement(By.xpath("//a[.='View all orders']"));
        viewAllOrders.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("Default.aspx"));
        Thread.sleep(2000);

        WebElement viewAllProducts= driver.findElement(By.xpath("//a[.='View all products']"));
        viewAllProducts.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("Products.aspx"));
        Thread.sleep(2000);

        WebElement orders= driver.findElement(By.xpath("//a[.='Order']"));
        orders.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("Process.aspx"));
        Thread.sleep(2000);

    }

    @Test
    public void Task4() throws InterruptedException {
        /*
        Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11
        /WebOrders/Login.aspx?"
        Input username "Tester"
        Input password "Test"
        Click login button
        Click "Order" button
        Select product "Screen Saver"
        Input quantity 5
        Input Customer name "CodeFish IT School"
        Input Street "2200 E devon"
        Input City "Des Plaines"
        Input State "Illinois"
        Input Zip "60018"
        Select MasterCard
        Input card number "444993876233"
        Input expiration date "03/24"
        Click Process button
        Validate text "New order has been successfully
added." is displayed below the Process button.
Click View all orders button
Validate new order is added and all inputs are
matching with new order
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");

        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        WebElement orders= driver.findElement(By.xpath("//a[.='Order']"));
        orders.click();

        WebElement screenSaver=driver.findElement(By.xpath("//option[contains(text(),'ScreenSaver')]"));
        screenSaver.click();
        Thread.sleep(2000);

        WebElement quality= driver.findElement(By.xpath("//input[@onchange='productsChanged()']"));
        quality.sendKeys("5");


        WebElement customerName= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");

        WebElement streetName= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        streetName.sendKeys("2200 E devon");

        WebElement city= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");

        WebElement state= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");

        WebElement zip= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys("60018");

        WebElement creditCard= driver.findElement(By.xpath("//input[@value='MasterCard']"));
        creditCard.click();

        WebElement cardNumber= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys("444993876233");

        WebElement expirationDate= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expirationDate.sendKeys("03/24");
        Thread.sleep(2000);

        WebElement processButton= driver.findElement(By.xpath("//a[contains(text(),'Process')]"));
        processButton.click();

        //part2

        WebElement validateText= driver.findElement(By.xpath("//strong['New order has been successfully added.']"));
        String actualText=validateText.getText().trim();
        String expectedText="New order has been successfully added.";
        Assert.assertEquals(actualText,expectedText);

        WebElement newOrder= driver.findElement(By.xpath("//a[.='View all orders']"));
        newOrder.click();

        List<WebElement>checkOrder=driver.findElements(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl02_OrderSelector']"));
        List<String> actualOrder=new ArrayList<>();
        List<String>expectedOrder=new ArrayList<>();

        for(int i=1;i<checkOrder.size();i++){
            actualOrder.add(checkOrder.get(i).getText().trim().toLowerCase());
            expectedOrder.add(checkOrder.get(i).getText().trim().toLowerCase());

        }
        Assert.assertEquals(actualOrder,expectedOrder);
    }
}
