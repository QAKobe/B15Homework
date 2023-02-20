package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amina {

    @Test()
    public void AminaHW() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");

        //TASK 1:
        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Amina Aidarova");

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("amina@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("Orange St, Los Angeles, CA");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("Orange St, Los Angeles, CA");

        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        Thread.sleep(3000);

        submit.sendKeys(Keys.ARROW_DOWN);
        submit.click();

        List<WebElement> AllInfo = driver.findElements(By.xpath("//p[@class='mb-1']"));
        List<String> actualInfo = new ArrayList<>();
        for (WebElement info : AllInfo) {
            actualInfo.add(info.getText());
        }
        List<String> expectedInfo = Arrays.asList("Name:Amina Aidarova",
                "Email:amina@gmail.com",
                "Current Address :Orange St, Los Angeles, CA",
                "Permananet Address :Orange St, Los Angeles, CA");
        System.out.println(actualInfo.equals(expectedInfo) ? "Passed!" : "Failed!");

        //TASK 2:
        driver.navigate().to("https://demoqa.com/radio-button");
        WebElement yesButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesButton.click();

        WebElement validation = driver.findElement(By.tagName("p"));
        System.out.println(validation.getText().equals("You have selected Yes") ? "Passed!" : "Failed!");

        WebElement impressive = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressive.click();
        System.out.println(validation.getText().equals("You have selected Impressive") ? "Passed!" : "Failed!");

        //TASK 3:
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

        WebElement fail = driver.findElement(By.xpath("//h3[@data-test='error']"));
        System.out.println(fail.getText().equals("Epic sadface: Username and password do not match any user in this service")
                ? "Passed!" : "Failed!");

        //TASK 4:
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement username2 = driver.findElement(By.xpath("//input[@id='user-name']"));
        username2.sendKeys("standard_user");

        WebElement password2 = driver.findElement(By.xpath("//input[@id='password']"));
        password2.sendKeys("secret_sauce");

        WebElement login2 = driver.findElement(By.xpath("//input[@id='login-button']"));
        login2.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        System.out.println(actualUrl.equals(expectedUrl) ? "Passed!" : "Failed!");

        driver.quit();
    }

}
