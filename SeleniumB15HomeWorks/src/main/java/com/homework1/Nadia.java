package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Nadia {

    @Test()
    public void NadiaTC1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Nadia Rudyk");

        WebElement userName = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userName.sendKeys("nadiia.rudyk@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("2177 N Dogwood Ln, Palatine, IL 60074");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("2129 N Dogwood Ln, Palatine, IL 60074");


        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));

        permanentAddress.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);

        if (fullName.isDisplayed() && userName.isDisplayed() && currentAddress.isDisplayed() && permanentAddress.isDisplayed()) {
            submitButton.click();
        }

        WebElement fullName1 = driver.findElement(By.xpath("//p[@id='name']"));
        if (fullName1.getText().contains(fullName.getText())) {
            System.out.println(fullName1.getText());
        }

        WebElement userName1 = driver.findElement(By.xpath("//p[@id='email']"));
        if (userName1.getText().contains(userName.getText())) {
            System.out.println(userName1.getText());
        }

        WebElement currentAddress1 = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        if (currentAddress1.getText().contains(currentAddress.getText())) {
            System.out.println(currentAddress1.getText());
        }

        WebElement permanentAddress1 = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        if (permanentAddress1.getText().contains(permanentAddress.getText())) {
            System.out.println(permanentAddress1.getText());
        }

        Thread.sleep(1000);
        driver.close();
    }

    @Test()
    public void NadiaTC2() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesRadioButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesRadioButton.click();

        WebElement messageYes = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String expected = "You have selected Yes";
        String actual = messageYes.getText();
        System.out.println(expected.equals(actual) ? "Passed" : "Failed");

        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();

        WebElement impressiveMessage = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String expected1 = "You have selected Impressive";
        String actual1 = impressiveMessage.getText();
        System.out.println(expected1.equals(actual1) ? "Passed" : "Failed");

        Thread.sleep(1000);

        driver.close();
    }

    @Test()
    public void NadiaTC3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Selenium");

        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(By.xpath("//input[@data-test='login-button']"));
        loginButton.click();

        WebElement message = driver.findElement(By.xpath("//h3[@data-test='error']"));

        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = message.getText().trim();
        System.out.println(actual.equals(expected) ? "Passed" : "Failed");

        driver.close();
    }

    @Test()
    public void NadiaTC4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("secret_sauce");

        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(By.xpath("//input[@data-test='login-button']"));
        loginButton.click();

        Thread.sleep(1000);

        String expected = "https://www.saucedemo.com/inventory.html";
        String actual = driver.getCurrentUrl();
        System.out.println(expected.equals(actual) ? "Passed" : "Failed");

        driver.close();
    }
}
