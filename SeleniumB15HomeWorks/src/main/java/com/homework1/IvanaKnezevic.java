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

public class IvanaKnezevic {

    @Test()
    public void IvanaKnezevicTC1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    /*1. Navigate to "https://demoqa.com/text-box"
    Enter your full name, email, current and permanent address Click submit button.
    Validate that all of your information is displayed and matching correctly.
    TIPS:Think about if conditions.*/
        driver.navigate().to("https://demoqa.com/text-box");
        WebElement fullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        fullName.sendKeys("Ivana Knezevic");
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        email.sendKeys("ivanaknezevic81@gmail.com");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        currentAddress.sendKeys("415 Dempster street,Mount Prospect,IL 60056");
        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("910 W Olive, Chicago, IL 60654");
        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();
        Thread.sleep(2000);
        List<WebElement> AllInfo = driver.findElements(By.xpath("//p[@class='mb-1']"));
        List<String> actualInfo = new ArrayList<>();
        for (WebElement info : AllInfo) {
            actualInfo.add(info.getText());
        }
        List<String> expectedInfo = Arrays.asList("Name:Ivana Knezevic",
                "Email:ivanaknezevic81@gmail.com",
                "Current Address :415 Dempster street,Mount Prospect,IL 60056",
                "Permananet Address :910 W Olive, Chicago, IL 60654");
        System.out.println(actualInfo.equals(expectedInfo) ? "Passed" : "Failed");
    }

    @Test()
    public void IvanaKnezevicTC2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         /*2. Navigate to "https://demoqa.com/radio-button"
        Click Yes radio button
        Validate text is : You have selected Yes
        Click Impressive radio button
        Validate text is : You have selected Impressive
        TIPS: be careful about your xpath if you have any issue with getting the text.*/

        driver.navigate().to("https://demoqa.com/radio-button");
        WebElement yesButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesButton.click();

        WebElement selected = driver.findElement(By.tagName("p"));
        System.out.println(selected.getText().equals("You have selected Yes") ? "Passed yes button" : "Failed");
        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();
        Thread.sleep(2000);
        System.out.println(selected.getText().equals("You have selected Impressive") ? "Passed impressive Button" : "Failed");
    }

    @Test()
    public void IvanaKnezevicTC3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


         /*3. Navigate to "https://www.saucedemo.com/"
        Enter username "Java"
        Enter password "Selenium"
        Click Login button
        Validate "Epic sadface: Username and password do not match any user in this service" message */
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("Java");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Selenium");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement message = driver.findElement(By.tagName("h3"));
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(message.getText().equals(expectedMessage) ? "Passed" : "Failed");

         /*4. Navigate to "https://www.saucedemo.com/"
        Enter username "standard_user"
        Enter password "secret_sauce"
        Click Login button
        Validate current url is "https://www.saucedemo.com/inventory.html"*/
        driver.get("https://www.saucedemo.com/");
        WebElement username2 = driver.findElement(By.id("user-name"));
        username2.sendKeys("standard_user");
        WebElement password2 = driver.findElement(By.id("password"));
        password2.sendKeys("secret_sauce");
        WebElement loginButton2 = driver.findElement(By.id("login-button"));
        loginButton2.click();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        System.out.println(driver.getCurrentUrl().equals(expectedUrl) ? "Passed" : "Failed");
        //driver.close();


    }

//    @Test()
//    public void IvanaKnezevicTC4(){
//
//    }
}
