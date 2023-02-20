package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alia {

    @Test()
    public void AliaTC1() throws InterruptedException {
        /*
    }
        1-Navigate to "https://demoqa.com/text-box"
        2-Enter your full name,current and permanent address
        3-Click submit button
        4-Validate that all of your information is displayed and matching correctly.
        TIPS: Think about if conditions
        Example:
 *Name:David
                *Email:david@gmail.com
 *Current address: (random address)
 *Permanent address: (random address)

*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/text-box");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/text-box";
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Url passed");
        } else {
            System.out.println("Url failed");
        }

        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Alia Abiy");
        if (fullName.isDisplayed() && !fullName.isSelected()) {
            System.out.println("You name is passed");
        } else {
            System.out.println("You name did not passed");
        }

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("ala@gmail.com");
        if (email.isDisplayed() && !email.isSelected()) {
            System.out.println("email passed");
        } else {
            System.out.println("email failed");
        }

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        currentAddress.sendKeys("2222 W. Sunnyside Ave");
        if (currentAddress.isDisplayed() && !currentAddress.isSelected()) {
            System.out.println("Your current Address passed");
        } else {
            System.out.println("You current Address failed");
        }

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("1234 W. Devon Ave");
        if (permanentAddress.isDisplayed() && !permanentAddress.isSelected()) {
            System.out.println("You permanent address passed");
        } else {
            System.out.println("Your permanent address failed");
        }

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        Thread.sleep(4000);
        submitButton.click();

        if (submitButton.isDisplayed() && !submitButton.isSelected()) {
            System.out.println("You are good");
        } else {
            System.out.println("Try again");
            //  driver.close();
        }
       /*
        1-Navigate to "https://demoqa.com/radio-button"
       2-Click yes radio button
       3-Validate text is: You have selected Yes
       4-Click Impressive radio button
       5-Validate text is: You have selected Impressive
       TIPS: Be careful about your XPath if you have any issue with getting the text
        */
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesButton.click();
        WebElement youHaveSelectedYes = driver.findElement(By.tagName("p"));
        System.out.println(youHaveSelectedYes.getText().equals("You have selected Yes") ? "You have selected yes text passed!" :
                " You have selected yes text failed");
        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();
        WebElement selectedImpressive = driver.findElement(By.tagName("p"));
        System.out.println(selectedImpressive.getText().equals("You have selected Impressive") ? " You have selected Impressive text passed" :
                " You have selected Impressive text failed");
        driver.close();
    }

    @Test()
    public void AliaTC2() throws InterruptedException {
//        Navigate to "https://www.saucedemo.com/"
//        Enter username "Java"
//        Enter password "Selenium"
//        Click Login button
//        Validate "Epic sadface: Username and password do not match any user in this service" message

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        Thread.sleep(3000);
        loginButton.click();

        WebElement epicSadFace = driver.findElement(By.tagName("h3"));
        System.out.println(epicSadFace.getText().trim().equals("Epic sadface: Username and password do not match any user in this service") ?
                "Epic sadface message passed" : "Epic sadface message failed");
        //driver.close();


        /*
        1-Navigate to "https://www.saucedemo.com/"
        2-Enter username "standard_user"
        3-Enter password "secret_sauce"
        4-Click login button
        5-Validate current url is "https://www.saucedemo.com/inventory.html"
         */

        driver.get("https://www.saucedemo.com/");
        WebElement userName1 = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName1.sendKeys("standard_user");

        WebElement password1 = driver.findElement(By.xpath("//input[@id='password']"));
        password1.sendKeys("secret_sauce");

        WebElement loginButton1 = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton1.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        System.out.println(actualUrl.equals(expectedUrl) ? "Passed url" : "Failed url");
        driver.close();


    }


}


