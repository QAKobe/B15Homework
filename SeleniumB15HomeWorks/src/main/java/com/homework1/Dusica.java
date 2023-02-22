package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dusica {

    @Test()
    public void DusicaTC1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/text-box");

        WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys("Dusica Ricabal");
        WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmail.sendKeys("dusica.su@gmail.com");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("708 Scarbrough Circle, Hoffman Estates,IL 60169");
        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("75 Kristin Circle apt 106, Schaumburg, IL 60195");

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();//Why my click() is not working?
        Thread.sleep(5000);

        WebElement outputBox = driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println(outputBox.getText());

        if (outputBox.getAttribute("userName").trim().equals("Dusica Ricabal")) ;
        System.out.println("Valid info");//I dont know this part
    }

    @Test()
    public void DusicaTC2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        Thread.sleep(2000);
        yesButton.click();//My click button is not working
        WebElement textYes = driver.findElement(By.xpath("//p[@class='mt-3']"));
        if (textYes.isDisplayed() && textYes.isSelected()) ;
        System.out.println("You have selected Yes");
        WebElement textImpressive = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        if (textImpressive.isDisplayed() && textImpressive.isSelected()) ;
        System.out.println("You have selected Impressive");
    }

    @Test()
    public void DusicaTC3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement messageEpicSadface = driver.findElement(By.xpath("//h3[@data-test='error']"));
        if (messageEpicSadface.isDisplayed()) ;
        System.out.println("Username and password do nog match any user in this service");
    }

    @Test()
    public void DusicaTC4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        String currentUrl = "https://www.saucedemo.com/inventory.html";
        String expectedUrl = "https://www.saucedemo.com/inventory.html";


        if (currentUrl.equals(expectedUrl)) {
            System.out.println("Url is passed");
        } else {
            System.out.println("Url is failed");
        }
    }
}
