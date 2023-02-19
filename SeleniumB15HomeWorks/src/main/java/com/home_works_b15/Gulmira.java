package com.home_works_b15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Gulmira {

    @Test()
    public void GumliraTC1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/text-box");
        Thread.sleep(3000);
        WebElement fullName = driver.findElement(By.xpath("//input[@id ='userName']"));
        fullName.sendKeys("Gulmira Ibraeva");
        WebElement email = driver.findElement(By.xpath("//input[@id ='userEmail']"));
        email.sendKeys("gucci1234@gmail.com");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id ='currentAddress']"));
        currentAddress.sendKeys("Des Plaines");
        currentAddress.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(3000);
        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id ='permanentAddress']"));
        permanentAddress.sendKeys("Des Plaines)");
        permanentAddress.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(3000);
        permanentAddress.sendKeys(Keys.ARROW_DOWN);
        permanentAddress.sendKeys(Keys.ARROW_DOWN);
        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.sendKeys(Keys.ARROW_DOWN);
        submit.click();
        Thread.sleep(3000);

        WebElement par = driver.findElement(By.xpath("//p[@id ='name']"));
        System.out.println(par.getText().trim().equals("Name:Gulmira Ibraeva") ? "PASSED": "FAILED");
        WebElement par2 = driver.findElement(By.xpath("//p[@id ='email']"));
        System.out.println(par2.getText().trim().equals("Email:gucci1234@gmail.com")? "PASSED" : "FAILED");
        WebElement par3 = driver.findElement(By.xpath("//p[@id ='currentAddress']"));
        System.out.println(par3.getText().trim().equals("Current Address :Des Plaines") ? "passed" : "failed");
        WebElement par4 = driver.findElement(By.xpath("//p[@id ='permanentAddress']"));
        System.out.println(par4.getText().trim().equals("Permananet Address :Des Plaines)") ? "Passed" : "failed");
    }

    @Test()
    public void GulmiraTC2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement yesButton = driver.findElement(By.xpath("//label[.='Yes']"));
        yesButton.click();
        WebElement text = driver.findElement(By.xpath("//p[@class = 'mt-3']"));
        System.out.println(text.getText().trim().equals("You have selected Yes")? "PASSED": "FAILED");
        Thread.sleep(3000);
        WebElement impressiveButton = driver.findElement(By.xpath("//label[.='Impressive']"));
        impressiveButton.click();
        WebElement text2 = driver.findElement(By.xpath("//p[@class = 'mt-3']"));
        System.out.println(text2.getText().trim().equals("You have selected Impressive")? "PASSED": "FAILED");
    }

    @Test()
    public void GulmiraTC3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id = 'user-name']"));
        userName.sendKeys("Java");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'password']"));
        password.sendKeys("Selenium");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id = 'login-button']"));
        loginButton.click();
        WebElement epicMessage = driver.findElement(By.tagName("h3"));
        String actualMessage = epicMessage.getText().trim();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(actualMessage.equals(expectedMessage)? "PASSED" : "FAILED");
    }

    @Test()
    public void GulmiraTC4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id = 'user-name']"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'password']"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id = 'login-button']"));
        loginButton.click();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        System.out.println(actualURL.equals(expectedURL)? "PASSED": "FAILED");
    }

}
