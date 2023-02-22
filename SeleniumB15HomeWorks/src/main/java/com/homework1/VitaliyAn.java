package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class VitaliyAn {

    @Test()
    public void VitaliyTC1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Vitaliy An");

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("anaplist@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("1075 Brighton Beach Avenue, Brooklyn NY");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("3250 Coney Island ave, Brooklyn NY");

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();

        List<WebElement> allInfo = driver.findElements(By.xpath("//p[@class='mb-1']"));
        for (WebElement each : allInfo) {
            if (each.isDisplayed() && each.equals(each)) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");
            }
        }
    }

    @Test()
    public void ViyaliyTC2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesButton.click();
        Thread.sleep(2000);

        WebElement textYes = driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println((textYes.getText().equals("You have selected Yes") ? "PASSED" : "FAILED"));

        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();

        WebElement textImpressive = driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println(textImpressive.getText().equals("You have selected Impressive") ? "PASSED" : "FAILED");

    }

    @Test()
    public void VitaliyTC3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement logIn = driver.findElement(By.xpath("//input[@id='login-button']"));
        logIn.click();

        WebElement headerIncorrect = driver.findElement(By.tagName("h3"));
        System.out.println(headerIncorrect.getText());
        System.out.println(headerIncorrect.getText().equals("Epic sadface: Username and password do not match any user in this service") ? "PASSED" : "FAILED");
    }

    @Test()
    public void VitaliyTC4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement logIn = driver.findElement(By.xpath("//input[@id='login-button']"));
        logIn.click();

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        System.out.println(currentUrl.equals(expectedUrl) ? "PASSED" : "FAILED");

    }
}
