package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nataliia {

    @Test()
    public void NataliaTC1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/text-box");

        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        name.sendKeys("Nataliia");

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        email.sendKeys("nata.yatsishin@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("8564 W Lawrence Ave, Norridge");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("193 Vovchynetska St., Ivano-Frankivsk");

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        submitButton.click();

        List<WebElement> allInfo = driver.findElements(By.className("mb-1"));
        List<String> actualInfo = new ArrayList<>();

        for (WebElement info : allInfo) {
            actualInfo.add(info.getText());
        }

        List<String> expectedInfo = Arrays.asList("Name:Nataliia",
                "Email:nata.yatsishin@gmail.com",
                "Current Address :8564 W Lawrence Ave, Norridge",
                "Permananet Address :193 Vovchynetska St., Ivano-Frankivsk");

        System.out.println(actualInfo.equals(expectedInfo) ? "passed" : "failed");

    }

    @Test()
    public void NatliiaTC2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", yesButton);

        if (yesButton.isDisplayed() && !yesButton.isSelected()) {
            yesButton.click();
        }

        WebElement youHaveSelectedYes = driver.findElement(By.xpath("//p[.='You have selected Yes']"));
        //System.out.println(youHaveSelectedYes.getText());
        String actualSelectedYes = youHaveSelectedYes.getText().trim();
        String expectedSelectedTes = "You have selected Yes";
        System.out.println(actualSelectedYes.equals(expectedSelectedTes) ? "Passed" : "Failed");

        Thread.sleep(1000);
        WebElement impessiveButton = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        js.executeScript("arguments[0].click()", impessiveButton);

        if (!impessiveButton.isSelected() && impessiveButton.isDisplayed()) {
            impessiveButton.click();
        }

        WebElement youHaveSelectedImpressive = driver.findElement(By.xpath("//p[.='You have selected Impressive']"));
        String actualSelectedImpressive = youHaveSelectedImpressive.getText().trim();
        String expectedSelectedImpressive = "You have selected Impressive";
        System.out.println(actualSelectedImpressive.equals(expectedSelectedImpressive) ? "Passed" : "Failed");

    }

    @Test()
    public void NatliiaTC3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(actualMessage.equals(expectedMessage) ? "Passed" : "Failed");
    }

    @Test()
    public void NatliiaTC4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        System.out.println(actualUrl.equals(expectedUrl) ? "passed" : "failed");
    }
}
