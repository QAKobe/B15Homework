package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Radostina {

    @Test()
    public void RadostinaTC1() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://demoqa.com/text-box");

        WebElement fullName=driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Radost Radost");

        WebElement email=driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        email.sendKeys("rtp@gmail.com");

        WebElement currentAddress=driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("123 New Wilke Rd, Arlington Hts, IL,60005");

        WebElement permanentAddress=driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("123 New Wilke Rd, Arlington Hts, IL,60005");


        WebElement submitButton=driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();

        WebElement displayAddress=driver.findElement(By.xpath("//p[@id='name']"));
        displayAddress.getText().contains("Radost Radost");

        List<WebElement> allInfo=driver.findElements(By.xpath("//p[@class='mb-1']"));
        List<String> actualInfo=new ArrayList<>();
        for(WebElement info:allInfo){
            actualInfo.add(info.getText());
        }
        List<String>expectedInfo= Arrays.asList("Name:Radost Radost","Email:rtp@gmail.com",
                "Current Address :123 New Wilke Rd, Arlington Hts, IL,60005",
                "Permananet Address :123 New Wilke Rd, Arlington Hts, IL,60005");

        System.out.println(actualInfo.equals(expectedInfo)?"Passed":"Faild");

        driver.close();

    }

    @Test()
    public void RadostinaTC2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("Java");

        WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Selenium");

        WebElement logButton=driver.findElement(By.xpath("//input[@id='login-button']"));
        logButton.click();

        WebElement massage=driver.findElement(By.tagName("h3"));
        System.out.println(massage.getText().trim().equals("Epic sadface: Username and password do not match any user in this service")?"Yes":"No");
    }

    @Test()
    public void RadostinaTC3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("Java");

        WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Selenium");

        WebElement logButton=driver.findElement(By.xpath("//input[@id='login-button']"));
        logButton.click();

        WebElement massage=driver.findElement(By.tagName("h3"));
        System.out.println(massage.getText().trim().equals("Epic sadface: Username and password do not match any user in this service")?"Yes":"No");
    }

    @Test()
    public void RadostinaTC4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        userName.sendKeys("standard_user");

        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement logInButton=driver.findElement(By.xpath("//input[@id='login-button']"));
        logInButton.click();


        System.out.println(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")?"url_passed":"url_Failed");
        driver.close();
    }
}

