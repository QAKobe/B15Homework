package com.home_works_b15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alena {

    @Test()
    public void AlenaHW() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement loginButton=driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")?"PASSED":"FAILED");
        driver.quit();
    }

    @Test()
    public void AlenaHW2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement username= driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("Java");
        WebElement password= driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Selenium");
        WebElement clickButton= driver.findElement(By.xpath("//input[@id='login-button']"));
        clickButton.click();
        String error=driver.findElement(By.xpath("//h3[@data-test='error']")).getText().trim();
        System.out.println(error.equals("Epic sadface: Username and password do not match any user in this service")?"PASSED":"FAILED");
        driver.quit();
    }

    @Test()
    public void AlenaHW3(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/radio-button");
        WebElement radioB= driver.findElement(By.xpath("//label[@for='yesRadio']"));
        radioB.click();
        String checkYes=driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).getText();
        System.out.println(checkYes.equals("Yes")?"YES passed":"YES failed");
        WebElement impressiveB=driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveB.click();
        String impressiveCheck=driver.findElement(By.xpath("//span[contains(text(),'Impressive')]")).getText();
        System.out.println(impressiveCheck.equals("Impressive")?"Impressive PASSED":"Impressive FAILED");
        driver.quit();

    }

    @Test()
    public void AlenaHWFailed() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");
        WebElement userName= driver.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys("Alexa Belkin");
        WebElement email= driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("brownhorse12@gmail.com");
        WebElement currentAddress= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("1233 smith st");
        WebElement permanent= driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanent.sendKeys("2244 robot drive");
        WebElement clickButton=driver.findElement(By.xpath("//button[@id='submit']"));
        Thread.sleep(1000);
        clickButton.click();
    }

    @Test()
    public void AlenaHW4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");
        WebElement userName= driver.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys("Alexa Belkin");
        WebElement email= driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("brownhorse12@gmail.com");
        WebElement currentAddress= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("1233 smith st");
        WebElement permanent= driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanent.sendKeys("2244 robot drive");
        WebElement clickButton=driver.findElement(By.xpath("//button[@id='submit']"));
        Thread.sleep(1000);
        clickButton.click();
        WebElement line1=driver.findElement(By.xpath("//p[@id='name']"));
        String lineString=line1.getText();
        System.out.println(line1.isDisplayed()&&lineString.equals("Name:Alexa Belkin")?"PASSED":"FAILED");
        WebElement line2=driver.findElement(By.xpath("//p[@id='email']"));
        String line2String=line2.getText();
        System.out.println(line2.isDisplayed()&&line2String.equals("Email:brownhorse12@gmail.com")?"Emailed PASSED":"Email Failed");
        WebElement line3=driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String line3String=line3.getText();
        System.out.println(line3.isDisplayed()&&line3String.equals("Current Address :1233 smith st")?"Current address PASSED":"CURRENT address FAILED");
        WebElement line4=driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String line4String=line4.getText();
        System.out.println(line4.isDisplayed()&&line4String.equals("Permananet Address :2244 robot drive")?"Permanent address PASSED":"Permanent address FAILED");
        driver.quit();
    }
}
