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

public class Radostina2 {

    @Test
    public void testCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle= driver.getTitle().trim();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement userName= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");

        WebElement password=driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement loginButton=driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
        //->validate Title
        String actualTitle1= driver.getTitle();
        String expectedTitle1="Web Orders";
        Assert.assertEquals(actualTitle1,expectedTitle1);
        Thread.sleep(1000);
        //->Validate Header
        WebElement header=driver.findElement(By.tagName("h2"));
        String actualHeader= header.getText().trim();
        String expectedHeader="List of All Orders";
        Assert.assertEquals(actualHeader,expectedHeader);

    }

    @Test
    public void Task2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestCo\n" +
                "mplete11/WebOrders/Login.aspx?");

        WebElement username= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password=driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement logButton=driver.findElement(By.xpath("//input[@type='submit']"));
        logButton.click();
        Thread.sleep(2000);

        WebElement viewAllProducts=driver.findElement((By.linkText("View all products")));
        Assert.assertTrue(!viewAllProducts.isSelected()); ///!!!!!!!
        viewAllProducts.click();
        Thread.sleep(2000);


        WebElement headerListOfProduct=driver.findElement(By.tagName("h2"));
        String actualHeader=headerListOfProduct.getText().trim();
        String expectedHeader="List of Products";
        Assert.assertEquals(actualHeader,expectedHeader);

        String actualURL=driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains("Products"));

    }
    @Test
    public void Task3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestCo\n" +
                "mplete11/WebOrders/Login.aspx?");

        WebElement username= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password=driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement logButton=driver.findElement(By.xpath("//input[@type='submit']"));
        logButton.click();
        Thread.sleep(2000);

        WebElement viewAllOrders=driver.findElement(By.linkText("View all orders"));
        Assert.assertTrue(viewAllOrders.getAttribute("href").contains("Default.aspx"));
        viewAllOrders.click();
        Thread.sleep(1000);
        String actualUrlAllOrders= driver.getCurrentUrl();
        System.out.println(actualUrlAllOrders);

        WebElement viewAllProducts=driver.findElement(By.linkText("View all products"));
        Assert.assertTrue(viewAllProducts.getAttribute("href").contains("Products.aspx"));
        viewAllProducts.click();
        Thread.sleep(1000);
        String actualUrlProducts= driver.getCurrentUrl();
        System.out.println(actualUrlProducts);

        WebElement order=driver.findElement(By.linkText("Order"));
        Assert.assertTrue(order.getAttribute("href").contains("Process.aspx"));
        order.click();
        Thread.sleep(1000);
        String actualUrlOrder=driver.getCurrentUrl();
        System.out.println(actualUrlOrder);

    }

    @Test
    public void task4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestCo\n" +
                "mplete11/WebOrders/Login.aspx?");

        WebElement username= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password=driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement logButton=driver.findElement(By.xpath("//input[@type='submit']"));
        logButton.click();
        Thread.sleep(2000);

        WebElement order=driver.findElement(By.linkText("Order"));
        order.click();
        Thread.sleep(2000);

        WebElement product= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        Select option=new Select(product);
        option.selectByVisibleText("ScreenSaver");

        WebElement quantity=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys("5");

        WebElement customerName=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");
        WebElement city= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        WebElement state=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");
        WebElement zipCode=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zipCode.sendKeys("60018");
        WebElement masterCardButton=driver.findElement(By.xpath("//input[@value='MasterCard']"));
        masterCardButton.click();Thread.sleep(1000);
        WebElement cardNumber= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");
        WebElement expirationDate= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("03/24");Thread.sleep(1000);
        WebElement processButton= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        //Part2:
        WebElement messageNewOrder= driver.findElement(By.tagName("strong"));
        Assert.assertTrue(messageNewOrder.isDisplayed());
        String actualMessageText=messageNewOrder.getText().trim();
        String expectedMessageText="New order has been successfully added.";
        Assert.assertEquals(actualMessageText,expectedMessageText);

        WebElement viewAllOrders=driver.findElement(By.linkText("View all orders"));
        viewAllOrders.click();

        WebElement name=driver.findElement(By.xpath("//td[contains(text(),'CodeFish IT School')]"));
        Assert.assertTrue(name.isDisplayed());
        String actualNAme= name.getText().trim();
        String expectedName="CodeFish IT School";
        Assert.assertEquals(actualNAme,expectedName);

        ////table[@id='ctl00_MainContent_orderGrid'] the whole table
        ////table[contains(@id,'ctl00_MainContent_orderGrid')] the same
        //table[contains(@id,'ctl00_MainContent_orderGrid')]//th find colums
        //table[contains(@id,'ctl00_MainContent_orderGrid')]//tr all rows
        //table[contains(@id,'ctl00_MainContent_orderGrid')]//td  total count of data


        List<WebElement> allData=driver.findElements(By.xpath("//table[contains(@id,'ctl00_MainContent_orderGrid')]//td"));
        boolean status=false;
        for(WebElement element:allData){
            String value=element.getText();
            if(value.contains("CodeFish IT School")){
                status=true;
                System.out.println("We found order with name: " +value);
                break;
            }
        }
        Assert.assertTrue(status,"Record not find");


        List<WebElement> rowWithData=driver.findElements(By.xpath(" //table[contains(@id,'ctl00_MainContent_orderGrid')]//tr[2]"));
        List<String> expectedRowWithData= Arrays.asList("","CodeFish IT School","ScreenSaver","5","02/25/2023","2200 E devon","Des Plaines",
                "Illinois","60018","MasterCard","444993876233","03/24","");
        for(int i=1;i<rowWithData.size()-1;i++){
            Assert.assertEquals(rowWithData.get(i).getText().trim(),expectedRowWithData.get(i));
        }
}}
