package com.home_works_b15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Vital {

    @Test()
    public void VitalTC1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("John Smith");
        System.out.println(fullName.getText().trim());

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("johnsmith@gmail.com");
        System.out.println(email.getText().trim());

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("1635 Downing Ave");
        System.out.println(currentAddress.getText().trim());

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("1223 Sunnyside Rd");
        System.out.println(permanentAddress.getText().trim());

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        Thread.sleep(3000);
        submitButton.click();

        WebElement confirmationName = driver.findElement(By.xpath("//p[@id='name']"));
        String actualName = confirmationName.getText().trim();
        String expectedName = "Name:John Smith";
        System.out.println(actualName.equals(expectedName) ? "Passed" : "Failed");

        WebElement confirmationEmail = driver.findElement(By.xpath("//p[@id='email']"));
        String actualEmail = confirmationEmail.getText().trim();
        String expectedEmail = "Email:johnsmith@gmail.com";
        System.out.println(actualName.equals(expectedName) ? "Passed" : "Failed");

        WebElement confirmationCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String actualCurrentAddress = confirmationCurrentAddress.getText().trim();
        String expectedCurrentAddress = "Current Address :1635 Downing Ave";
        System.out.println(actualName.equals(expectedName) ? "Passed" : "Failed");

        WebElement confirmationPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String actualPermanentAddress = confirmationPermanentAddress.getText().trim();
        String expectedPermanentAddress = "Permananet Address :1223 Sunnyside Rd";
        System.out.println(actualName.equals(expectedName) ? "Passed" : "Failed");
    }
    @Test()
    public void VitalTC2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton= driver.findElement(By.xpath("//label[contains(text(),'Yes')]"));
        yesButton.click();

        WebElement validateYes=driver.findElement(By.xpath("//span[@class='text-success']"));
        String actualWord = validateYes.getText().trim();
        String expectedWord = "Yes";
        System.out.println(actualWord.equals(expectedWord) ? "Passed" : "Failed");
        Thread.sleep(3000);

        WebElement impressiveButton= driver.findElement(By.xpath("//label[contains(text(),'Impressive')]"));
        impressiveButton.click();

        WebElement validateWord=driver.findElement(By.xpath("//span[@class='text-success']"));
        String actualWord2 = validateWord.getText().trim();
        String expectedWord2 = "Impressive";
        System.out.println(actualWord2.equals(expectedWord2) ? "Passed" : "Failed");

    }
    @Test()
    public void VitalTC3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");

        WebElement userName=driver.findElement(By.cssSelector("#user-name"));
        userName.sendKeys("Java");
        WebElement password=driver.findElement(By.cssSelector("#password"));
        password.sendKeys("Selenium");
        WebElement loginButton=driver.findElement(By.cssSelector("#login-button"));
        Thread.sleep(2000);
        loginButton.click();


        WebElement validateMessage=driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actualMessage = validateMessage.getText().trim();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(actualMessage.equals(expectedMessage) ? "Passed" : "Failed");
    }
    @Test()
    public void VitalTC4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");

        WebElement userName=driver.findElement(By.cssSelector("#user-name"));
        userName.sendKeys("standard_user");
        WebElement password=driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton=driver.findElement(By.cssSelector("#login-button"));
        Thread.sleep(2000);
        loginButton.click();

        System.out.println(driver.getCurrentUrl());
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.saucedemo.com/inventory.html";
        System.out.println(actualUrl.equals(expectedUrl)? "Passed" : "Failed" );
    }
}
