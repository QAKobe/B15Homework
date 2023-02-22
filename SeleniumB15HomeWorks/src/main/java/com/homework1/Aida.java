package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Aida {

    @Test()
    public void AidaTC1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Aika Mambet");

        WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmail.sendKeys("aikamam@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("643 Mcculy st, Apt23, Honolulu, Hawaii 98168");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("643 Mcculy st, Apt23, Honolulu, Hawaii 98168");

        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        submitButton.click();
        Thread.sleep(2000);

        WebElement allInfo = driver.findElement(By.xpath("//p[@class='mb-1']"));
        String actualInfo = allInfo.getText().trim();

        String expectedInfo = "Name:Aika Mambet" + "Email:aikamam@gmail.com" +
                "Current Address :643 Mcculy st, Apt23, Honolulu, Hawaii 98168" +
                "Permananet Address :643 Mcculy st, Apt23, Honolulu, Hawaii 98168";

        System.out.println(actualInfo.equals(expectedInfo) ? "Passed" : "Failed");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test()
    public void AidaTC2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");

        WebElement yesBtn = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesBtn.click();
        WebElement selected = driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println(selected.getText().trim().equals("You have selected Yes") ? "Passed" : "Failed");
        Thread.sleep(3000);

        WebElement impressiveBtn = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveBtn.click();
        WebElement impressive = driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println(impressive.getText().trim().equals("You have selected Impressive") ? "Passed" : "Failed");
    }

    @Test()
    public void AidaTC3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginBtn.click();

        WebElement errorMessage = driver.findElement(By.tagName("h3"));
        System.out.println(errorMessage.getText().trim().equals("Epic sadface: Username and password do not match any user in this service") ?
                "Passed" : "Failed");
        Thread.sleep(2000);
        driver.close();
    }

    @Test()
    public void AidaTC4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginBtn.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        System.out.println(actualUrl.equals(expectedUrl) ? "Passed" : "Failed");
    }
}
