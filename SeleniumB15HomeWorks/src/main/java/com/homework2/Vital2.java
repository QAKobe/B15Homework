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

public class Vital2 {

    @Test
    public void validateLogin() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println(actualTitle.equals(expectedTitle) ? "True" : "False");

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        String actualTitle1 = driver.getTitle().trim();
        String expectedTitle2 = "Web Orders";
        Assert.assertEquals(actualTitle1, expectedTitle2);
        System.out.println(actualTitle1.equals(expectedTitle2) ? "True" : "False");

        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(actualHeader, expectedHeader);
        System.out.println(actualHeader.equals(expectedHeader) ? "True" : "False");
        driver.close();
    }

    @Test
    public void validateAllProducts() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        WebElement viewAllProducts = driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        viewAllProducts.click();
        Thread.sleep(2000);

        WebElement viewAllProductsIsSelected = driver.findElement(By.xpath("//li[@class='selected']"));
        String actualCondition = viewAllProductsIsSelected.getAttribute("class").trim();
        String expectedCondition = "selected";
        Assert.assertEquals(actualCondition, expectedCondition);
        System.out.println(actualCondition.equals(expectedCondition) ? "True" : "False");

        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "List of Products";
        Assert.assertEquals(actualHeader, expectedHeader);
        System.out.println(actualHeader.equals(expectedHeader) ? "True" : "False");

        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("Products"));
        System.out.println(actualUrl.contains("Products") ? "True" : "False");
        driver.close();
    }

    @Test
    public void testCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();

        WebElement viewAllOrdersLink = driver.findElement(By.xpath("//a[contains(text(),'View all orders')]"));
        String actualValueViewAllOrdersLink = viewAllOrdersLink.getAttribute("href");
        String expectedValueViewAllOrdersLink = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx";
        Assert.assertEquals(actualValueViewAllOrdersLink, expectedValueViewAllOrdersLink);
        System.out.println(actualValueViewAllOrdersLink.equals(expectedValueViewAllOrdersLink) ? "True" : "False");

        WebElement viewAllProductsLink = driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        Thread.sleep(2000);
        String actualValueViewAllProductsLink = viewAllProductsLink.getAttribute("href");
        String expectedValueViewAllProductsLink = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Products.aspx";
        Assert.assertEquals(actualValueViewAllProductsLink, expectedValueViewAllProductsLink);
        System.out.println(actualValueViewAllProductsLink.equals(expectedValueViewAllProductsLink) ? "True" : "False");

        WebElement orderLink = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        String actualValueOrderLink = orderLink.getAttribute("href");
        String expectedValueOrderLink = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Process.aspx";
        Assert.assertEquals(actualValueOrderLink, expectedValueOrderLink);
        System.out.println(actualValueOrderLink.equals(expectedValueOrderLink) ? "True" : "False");
        driver.close();

    }

    @Test
    public void TestCase4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        WebElement order = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        order.click();
        WebElement product = driver.findElement(By.xpath("//option[contains(text(),'ScreenSaver')]"));
        product.click();
        WebElement quantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");
        WebElement zip = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys("60018");
        WebElement card = driver.findElement(By.xpath("//input[@value='MasterCard']"));
        card.click();
        WebElement cardNumber = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");
        WebElement expireDate = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expireDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.xpath("//a[contains(text(),'Process')]"));
        processButton.click();

        //part2
        WebElement validateText = driver.findElement(By.tagName("strong"));
        String actualName = validateText.getText().trim();
        String expectedName = "New order has been successfully added.";
        Assert.assertEquals(actualName, expectedName);
        System.out.println(actualName.equals(expectedName) ? "True" : "False");

        WebElement viewAllOrders = driver.findElement(By.xpath("//a[contains(text(),'View all orders')]"));
        viewAllOrders.click();

        WebElement validateNameInput=driver.findElement(By.xpath("//td[contains(text(),'CodeFish IT School')]"));
        String actualNameInput= BrowserUtils.getText(validateNameInput);
        String expectedNameInput="CodeFish IT School";
        Assert.assertEquals(actualNameInput,expectedNameInput);
        System.out.println(actualNameInput.equals(expectedNameInput)? "True":"False");

        WebElement validateProductInput=driver.findElement(By.xpath("//td[contains(text(),'ScreenSaver')]"));
        String actualProductInput= BrowserUtils.getText(validateProductInput);
        String expectedProductInput="ScreenSaver";
        Assert.assertEquals(actualProductInput,expectedProductInput);
        System.out.println(actualProductInput.equals(expectedProductInput)? "True":"False");

        WebElement validateQuantityInput=driver.findElement(By.xpath("//td[contains(text(),'5')]"));
        String actualQuantityInput= BrowserUtils.getText(validateQuantityInput);
        String expectedQuantityInput="5";
        Assert.assertEquals(actualQuantityInput,expectedQuantityInput);
        System.out.println(actualQuantityInput.equals(expectedQuantityInput)? "True":"False");

        WebElement validateStreetInput=driver.findElement(By.xpath("//td[contains(text(),'2200 E devon')]"));
        String actualStreetInput= BrowserUtils.getText(validateStreetInput);
        String expectedStreetInput="2200 E devon";
        Assert.assertEquals(actualStreetInput,expectedStreetInput);
        System.out.println(actualStreetInput.equals(expectedStreetInput)? "True":"False");

        WebElement validateCityInput=driver.findElement(By.xpath("//td[contains(text(),'Des Plaines')]"));
        String actualCityInput= BrowserUtils.getText(validateCityInput);
        String expectedCityInput="Des Plaines";
        Assert.assertEquals(actualCityInput,expectedCityInput);
        System.out.println(actualCityInput.equals(expectedCityInput)? "True":"False");

        WebElement validateStateInput=driver.findElement(By.xpath("//td[contains(text(),'Illinois')]"));
        String actualStateInput= BrowserUtils.getText(validateStateInput);
        String expectedStateInput="Illinois";
        Assert.assertEquals(actualStateInput,expectedStateInput);
        System.out.println(actualStateInput.equals(expectedStateInput)? "True":"False");

        WebElement validateZipInput=driver.findElement(By.xpath("//td[contains(text(),'60018')]"));
        String actualZipInput= BrowserUtils.getText(validateZipInput);
        String expectedZipInput="60018";
        Assert.assertEquals(actualZipInput,expectedZipInput);
        System.out.println(actualZipInput.equals(expectedZipInput)? "True":"False");

        WebElement validateCardInput=driver.findElement(By.xpath("//td[contains(text(),'MasterCard')]"));
        String actualCardInput= BrowserUtils.getText(validateCardInput);
        String expectedCardInput="MasterCard";
        Assert.assertEquals(actualCardInput,expectedCardInput);
        System.out.println(actualCardInput.equals(expectedCardInput)? "True":"False");

        WebElement validateCardNumberInput=driver.findElement(By.xpath("//td[contains(text(),'444993876233')]"));
        String actualCardNumberInput= BrowserUtils.getText(validateCardNumberInput);
        String expectedCardNumberInput="444993876233";
        Assert.assertEquals(actualCardNumberInput,expectedCardNumberInput);
        System.out.println(actualCardNumberInput.equals(expectedCardNumberInput)? "True":"False");

        WebElement validateExpirationInput=driver.findElement(By.xpath("//td[contains(text(),'03/24')]"));
        String actualExpirationInput= BrowserUtils.getText(validateExpirationInput);
        String expectedExpirationInput="03/24";
        Assert.assertEquals(actualExpirationInput,expectedExpirationInput);
        System.out.println(actualExpirationInput.equals(expectedExpirationInput)? "True":"False");
        driver.close();
}}
