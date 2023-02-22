package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YelenaK {

    @Test()
    public void YelenaKTC1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/text-box");

        WebElement UserName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        UserName.sendKeys("Ellen K.");
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("Ella@me.com");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("888 Arrowwood Dr, Cincinnati, OH 45040");
        Thread.sleep(1000);
        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("2317 62nd street Brooklyn, NY 11204");
        Thread.sleep(1000);
        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.sendKeys(Keys.DOWN);
        submit.sendKeys(Keys.DOWN);
        submit.sendKeys(Keys.DOWN);
        submit.sendKeys(Keys.DOWN);
        submit.sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        submit.click();
        Thread.sleep(1000);
        List<WebElement> AllInfo = driver.findElements(By.xpath("//p[@class='mb-1']"));
        List<String> actualInfo = new ArrayList<>();
        for (WebElement info : AllInfo) {
            actualInfo.add(info.getText());
        }
        List<String> expectedInfo = Arrays.asList("Name:Ellen K.", "Email:Ella@me.com",
                "Current Address :888 Arrowwood Dr, Cincinnati, OH 45040",
                "Permananet Address :2317 62nd street Brooklyn, NY 11204");
        System.out.println(actualInfo.equals(expectedInfo) ? "PASSED!" : "FAILED!");
        driver.close();
    }

    @Test()
    public void YelenaKTC2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/radio-button");
        WebElement yesButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        Thread.sleep(1000);
        yesButton.click();
        Thread.sleep(1000);
        WebElement SelectedText = driver.findElement(By.tagName("p"));
        System.out.println(SelectedText.getText().equals("You have selected Yes") ? "yes button Passed" : "Failed");
        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();
        Thread.sleep(1000);
        WebElement SelectedText2 = driver.findElement(By.tagName("p"));
        System.out.println(SelectedText2.getText().equals("You have selected Impressive") ? "impressive button Passed" : "FAILED");
        driver.close();

    }

    @Test()
    public void YelenaKTC3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");
        WebElement username = driver.findElement(By.xpath("//input[@data-test='username']"));
        username.sendKeys("Java");
        WebElement password = driver.findElement(By.xpath("//input[@data-test='password']"));
        password.sendKeys("Selenium");
        WebElement button = driver.findElement(By.xpath("//input[@type='submit']"));
        button.click();
        WebElement message = driver.findElement(By.tagName("h3"));
        System.out.println(message.getText().trim().equals("Epic sadface: Username and password do " +
                "not match any user in this service")
                ? "Passed" : "Failed");

        driver.close();

    }

    @Test()
    public void YelenaKTC4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement Username = driver.findElement(By.xpath("//input[@type='text']"));
        Username.sendKeys("standard_user");
        WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        Password.sendKeys("secret_sauce");
        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        Thread.sleep(1000);
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        System.out.println(actualURL.equals(expectedURL) ? "PASSED" : "FAILED");
        System.out.println(expectedURL);

        driver.close();
    }
}

