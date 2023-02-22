package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class OlgaM {

    @Test()
    public void OlgaMTC1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        fullName.sendKeys("Muhamedowa Olga");

        WebElement eMail = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        eMail.sendKeys("jennet@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("44 Merw apt 28");


        WebElement checktAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        String actualAddress = checktAddress.getText().trim();
        String excpectAddress = "45 Mewr apt 25";

        if (actualAddress.equals(excpectAddress)) {
            System.out.println("Correct address");
        } else {
            System.out.println("Different address");
        }
    }

    @Test()
    public void OlgaMTC2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesButton.click();

        WebElement textCheck = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualText = textCheck.getText().trim();
        String excpectedText = "You have selected Yes";
        System.out.println(actualText.equals(excpectedText) ? "Passed" : "Failed");

        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();

        WebElement validateText = driver.findElement(By.xpath("//span[contains(text(),'Impressive')]"));
        String actualValidate = validateText.getText().trim();
        String exceptedValidate = "Impressive";
        System.out.println(actualValidate.equals(exceptedValidate) ? "Passed" : "Failed");

    }

    @Test()
    public void OlgaMTC3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

        WebElement textValidate = driver.findElement(By.tagName("h3"));
        String actualText = textValidate.getText().trim();
        String exceptedText = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(actualText.equals(exceptedText) ? "Passed" : "Failed");
    }

    @Test()
    public void OlgaMTC4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

    }
}
