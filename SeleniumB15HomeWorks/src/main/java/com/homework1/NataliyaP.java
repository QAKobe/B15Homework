package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class NataliyaP {

    @Test()
    public void NataliaPTC1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys("Nat Nev");

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("natnev@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("555 West Ave, Chicago, IL, 60089");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("555 West Ave, Chicago, IL, 60089");

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        Thread.sleep(3000);
        submitButton.sendKeys(Keys.ARROW_DOWN);
        submitButton.sendKeys(Keys.ARROW_DOWN);
        submitButton.click();

        WebElement verifyName = driver.findElement(By.xpath("//p[@id='name']"));
        String actualUserName = verifyName.getText().trim();
        String expectedUserName = "Name:Nat Nev";
        System.out.println(actualUserName.equals(expectedUserName) ? "Passed" : "Failed");

        WebElement verifyEmail = driver.findElement(By.xpath("//p[@id='email']"));
        String actualEmail = verifyEmail.getText().trim();
        String expectedEmail = "Email:natnev@gmail.com";
        System.out.println(actualEmail.equals(expectedEmail) ? "Passed" : "Failed");

        WebElement verifyCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String actualCurrentAddress = verifyCurrentAddress.getText().trim();
        String expectedCurrentAddress = "Current Address :555 West Ave, Chicago, IL, 60089";
        System.out.println(actualCurrentAddress.equals(expectedCurrentAddress) ? "Passed" : "Failed");

        WebElement verifyPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String actualPermanentAddress = verifyPermanentAddress.getText().trim();
        String expectedPermanentAddress = "Permananet Address :555 West Ave, Chicago, IL, 60089";
        System.out.println(actualPermanentAddress.equals(expectedPermanentAddress) ? "Passed" : "Failed");
    }

    @Test()
    public void NataliaPTC2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//label[@class ='custom-control-label']"));

        if (!yesButton.isSelected() && yesButton.isDisplayed() && yesButton.isEnabled()) {
            yesButton.click();

        }
        WebElement validateYes = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualYesMessage = validateYes.getText().trim();
        String expectedYesMessage = "You have selected Yes";
        System.out.println(actualYesMessage.equals(expectedYesMessage) ? "Passed" : "Failed");

        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        if (!impressiveButton.isSelected() && impressiveButton.isDisplayed() && impressiveButton.isEnabled()) {
            impressiveButton.click();
        }

        WebElement validateImpressive = driver.findElement(By.xpath("//span[contains(text(),'Impressive')]"));
        String actualImpressiveButton = impressiveButton.getText().trim();
        String expectedImpressiveButton = "You have selected Impressive";
        System.out.println(actualImpressiveButton.equals(expectedImpressiveButton) ? "Passed" : "Failed");
    }

    @Test()
    public void NataliaPTC3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//h3"));
        String actualErrorMessage = errorMessage.getText().trim();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(actualErrorMessage.equals(expectedErrorMessage) ? "Passed" : "Failed");
    }

    @Test()
    public void NataliaPTC4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");


        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        String actualUrl = driver.getCurrentUrl().trim();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        System.out.println(actualUrl.equals(expectedUrl) ? "Passed" : "Failed");
    }
}
