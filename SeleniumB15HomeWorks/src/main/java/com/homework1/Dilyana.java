package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dilyana {

    @Test()
    public void DilyanaTC1(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/text-box");


        WebElement fullName= driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Didi");

        WebElement email= driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("didi@gmail.com");

        WebElement currentAddress= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("1134 N.Eclute Ave. 60005 Arlington Heights");

        WebElement permanentAddress= driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("1111 New Wilke Rd. 60005 Arlington Heights");

        WebElement submitButton= driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();



        WebElement submmitedName= driver.findElement(By.xpath("//p[@id='name']"));
        String expectedName= submmitedName.getText();
        String actualName="Name:Didi";
        System.out.println(expectedName.equals(actualName)? "passed" : "failed");

        System.out.println(expectedName);

        List<WebElement> allInfo= driver.findElements(By.xpath("//p[@class='mb-1']"));
        List<String> actualInfo= new ArrayList<>();
        for(WebElement info: allInfo){
            actualInfo.add(info.getText());

        }System.out.println(actualInfo);
        List<String>expectedInfo= Arrays.asList("Name:Didi","Email:didi@gmail.com","Current Address :1134 N.Eclute Ave. 60005 Arlington Heights", "Permananet Address :1111 New Wilke Rd. 60005 Arlington Heights" );

        System.out.println(actualInfo.equals(expectedInfo) ? "passed" : "failed");

        driver.close();
    }

    @Test()
    public void DilyanaTC2(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://demoqa.com/radio-button");

        WebElement yesButton= driver.findElement(By.xpath("//label[@for='yesRadio']"));

        yesButton.click();

        WebElement textYes= driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualText= textYes.getText().trim();
        String expectedText="You have selected Yes";

        System.out.println(expectedText.equals(actualText) ? "passed" : "failed");

        WebElement impressiveButton= driver.findElement(By.xpath("//label[@for='impressiveRadio']"));

        impressiveButton.click();
        WebElement textImpressive= driver.findElement(By.xpath("//p[@class='mt-3']"));

        String actualTextImpressive= textImpressive.getText().trim();
        System.out.println(actualTextImpressive);
        String expectedTextImpressive="You have selected Impressive";
        System.out.println(expectedTextImpressive.equals(actualTextImpressive) ? "passed" : "failed");

        driver.close();
    }

    @Test()
    public void DilyanaTC3(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName= driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement loginButton= driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement text= driver.findElement(By.tagName("h3"));
        String actualText= text.getText().trim();
        String expected= "Epic sadface: Username and password do not match any user in this service";
        System.out.println(actualText.equals(expected) ? "passed" : "failed");

        driver.close();
    }

    @Test()
    public void DilyanaTC4(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName= driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton= driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        String expectedURL="https://www.saucedemo.com/inventory.html";
        System.out.println(driver.getCurrentUrl().equals(expectedURL) ? "passed": "failed");

        driver.quit();
    }

}
