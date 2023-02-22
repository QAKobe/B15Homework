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

public class JohnPak {

    @Test
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("John");

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("johnsemail@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("1234 random st, Romeoville, IL 60446");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("4321 other st, Schaumburg, IL 60194");

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.sendKeys(Keys.ARROW_DOWN);
        submitButton.sendKeys(Keys.ARROW_DOWN);
        // submitButton.sendKeys(Keys.ARROW_DOWN);
        submitButton.click();
        Thread.sleep(2000);

        List<WebElement> allInfo = driver.findElements(By.xpath("//p[@class='mb-1']"));

        List<String> actualInfo = new ArrayList<>();
        List<String> expectedInfo = new ArrayList<>();

        for (int i = 0; i < allInfo.size(); i++) {
            actualInfo.add(allInfo.get(i).getText().toLowerCase().trim());
            expectedInfo.add(allInfo.get(i).getText().toLowerCase().trim());
        }
        Assert.assertEquals(actualInfo, expectedInfo);
    }

    //TASK 2
    @Test
    public void task2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesButton.click();
        Thread.sleep(2000);

        WebElement yesSelected = driver.findElement(By.xpath("//p[@class='mt-3']"));
        Assert.assertTrue(yesSelected.isDisplayed());

        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();

        WebElement impressiveSelected = driver.findElement(By.xpath("//p[@class='mt-3']"));
        Assert.assertTrue(impressiveSelected.isDisplayed());
    }

    //TASK 3
    @Test
    public void task3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
        passWord.sendKeys("Selenium");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement sadFace = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface:')]"));
        Assert.assertTrue(sadFace.isDisplayed());
    }

    //TASK 4
    @Test
    public void task4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
        passWord.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        Thread.sleep(2000);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
