package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Zhanna {

    @Test()
    public void ZhannaTC1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.navigate().to("https://demoqa.com/text-box");
        WebElement name= driver.findElement(By.xpath("//input[@id='userName']"));
        name.sendKeys("Zhanna Karayeva");
        WebElement email= driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("karayevajanna@gmail.com");
        WebElement currentAddress= driver.findElement(By.xpath("//textarea"));
        currentAddress.sendKeys("1818 w Golf Rd");
        WebElement permanentAddress= driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("1800 w Golf Rd");
        WebElement button=driver.findElement(By.xpath("//button[@id='submit']"));
        button.click();
    }

    @Test
    public void yes() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/radio-button");
        Thread.sleep(10);
        WebElement yeButton=driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yeButton.click();
        String actual= yeButton.getText().trim();
        String expected="Yes";
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void Impressive() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/radio-button");
        Thread.sleep(10);
        WebElement impressiveButton=driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();
        String actualImpressive= impressiveButton.getText().trim();
        String expectedImpressive="Impressive";
        Assert.assertEquals(actualImpressive,expectedImpressive);

    }

    @Test
    public void Selenium() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");
        WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        WebElement error=driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actual=error.getText().trim();
        String expected="Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void fourthTask(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standart_user");
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        String actualCurrentUrl=driver.getCurrentUrl().trim();
        String expectedUrl="https://www.saucedemo.com/";
        Assert.assertEquals(actualCurrentUrl,expectedUrl);


}}
