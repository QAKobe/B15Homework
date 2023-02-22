package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DianaKorol {

    @Test()
    public void NadiaKTC1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        fullName.sendKeys("Diana Korol");


        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("dianakorol@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("259 StoneyBrook Ln, Apt 7, Bloomingdale, 60108");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("Same as current");

        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        if (submitButton.isDisplayed()) {
            submitButton.sendKeys(Keys.ARROW_DOWN);
            submitButton.click();
        }

        WebElement element1 = driver.findElement(By.xpath("//p[@id='name']"));
        String actualHeader = element1.getText().trim();
        String expectedHeader = "Name:Diana Korol";
        if (actualHeader.equals(expectedHeader)) {

            System.out.println("Passed");
        } else {
            System.out.println("Failed");

        }



        WebElement element2 =driver.findElement(By.xpath("//p[@id='email']"));
        String actualHeader2 = element2.getText().trim();
        String expectedHeader2 = "Email:dianakorol@gmail.com";
        if (actualHeader2.equals(expectedHeader2)){
            System.out.println("Passed");
        }
        else {
            System.out.println("Failed");
        }
        WebElement element3 =driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String actualHeader3 = element3.getText().trim();
        String expectedHeader3 = "Current Address :259 StoneyBrook Ln, Apt 7, Bloomingdale, 60108";
        if (actualHeader3.equals(expectedHeader3)){
            System.out.println("Passed");
        }
        else {
            System.out.println("Failed");
        }

        WebElement element4 =driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String actualHeader4 = element4.getText().trim();
        String expectedHeader4 = "Permananet Address :Same as current";
        if (actualHeader4.equals(expectedHeader4)){
            System.out.println("Passed");
        }
        else {
            System.out.println("Failed");
        }


        List<WebElement> allElements = driver.findElements(By.xpath("//p[@class='mb-1']"));
        for (WebElement info: allElements){
            System.out.println(info.getText());
        }

        driver.quit();
    }

    @Test
    public void validationOfInfo() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        fullName.sendKeys("Diana Korol");


        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("dianakorol@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("259 StoneyBrook Ln, Apt 7, Bloomingdale, 60108");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("Same as current");
        Thread.sleep(1000);

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.sendKeys(Keys.ARROW_DOWN);


        submitButton.click();

        List<WebElement> headers = driver.findElements(By.xpath("//div[@class='border col-md-12 col-sm-12']"));

        List<String> actualHeaders=new ArrayList<>();
        List<String> expectedHeaders=new ArrayList<>();
        for (WebElement listOfHeaders:headers){
            System.out.println(listOfHeaders.getText().trim());
            actualHeaders.add(listOfHeaders.getText().trim());
            expectedHeaders.add(listOfHeaders.getText().trim());
            Assert.assertEquals(actualHeaders, expectedHeaders);

        }
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void validationOfMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("Selenium");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actualErrorMessage = errorMessage.getText().trim();
        System.out.println(errorMessage.getText().trim());
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Thread.sleep(2000);
        driver.quit();

    }

    @Test()
    public void DianaKorolTC4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@name='login-button']"));
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        System.out.println(currentUrl.trim().equals(expectedUrl));
    }
    //SECOND SOLUTION
    @Test
    public void validationOfUrl() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@name='login-button']"));
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
        Thread.sleep(2000);
        driver.close();
    }


}
