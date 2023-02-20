package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Savva {

    @Test()
    public void SavvaHW() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        //1-Set up Chromedriver and add block extension(put it in comments)
       /* ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("/Users/savvapopovici/Downloads/extension_3_16_1_0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);*/

        ChromeDriver driver = new ChromeDriver(/*options*/);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        //2-Automation process Test Case 1
        WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys("Savelii Popovici");
        WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmail.sendKeys("p.savva24@gmail.com");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("10026 Holly Lane");
        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("935 W Golf Road");
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        button.click();

        WebElement validationName = driver.findElement(By.xpath("//p[@id='name']"));
        System.out.println(validationName.getText().trim());
        System.out.println(validationName.getText().trim().equals("Name:Savelii Popovici") ? "Name passed" : "Name failed");
        WebElement validationEmail = driver.findElement(By.xpath("//p[@id='email']"));
        System.out.println(validationEmail.getText().trim().equals("Email:p.savva24@gmail.com") ? "Email passed" : "Email failed");
        WebElement validationCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        System.out.println(validationCurrentAddress.getText().trim().equals("Current Address :10026 Holly Lane") ? "Current Address passed" : "Current Address failed");
        WebElement validationPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        System.out.println(validationPermanentAddress.getText().trim().equals("Permananet Address :935 W Golf Road") ? "Permanent Address passed" : "Permanent Address failed");

        Thread.sleep(2000);

        //3-Automation process Test Case 2
        driver.get("https://demoqa.com/radio-button");
        WebElement yesButton = driver.findElement(By.xpath("//label[@class = 'custom-control-label']"));
        if(yesButton.isEnabled() && yesButton.isDisplayed() && !yesButton.isSelected()){
            yesButton.click();
        }
        WebElement yesValidation = driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println(yesValidation.getText().trim());
        System.out.println(yesValidation.getText().trim().equals("You have selected Yes") ? "Yes validation passed" : "Yes validation failed");
        Thread.sleep(1000);

        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        if(impressiveButton.isEnabled() && impressiveButton.isDisplayed() && !impressiveButton.isSelected()){
            impressiveButton.click();
        }
        WebElement impressiveValidation = driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println(impressiveValidation.getText().trim());
        System.out.println(impressiveValidation.getText().trim().equals("You have selected Impressive") ? "Impressive validation passed" : "Impressive validation failed");
        Thread.sleep(1000);

        //4-Automation process Test Case 3
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1500);
        WebElement usernameCase3 = driver.findElement(By.xpath("//input[@id='user-name']")); // you can use any locator
        usernameCase3.sendKeys("java");
        WebElement passwordCase3 = driver.findElement(By.xpath("//input[@id='password']")); // you can use any locator
        passwordCase3.sendKeys("selenium");
        WebElement loginButton2 = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton2.click();

        Thread.sleep(1000);
        WebElement epicSadface = driver.findElement(By.xpath("//button[@class='error-button']"));
        String epicMessage = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(epicSadface.getText().trim().equals(epicMessage) ? "Epic validation success" : "Epic validation failed");

        //5-Automation process Test Case 4
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1500);
        WebElement usernameCase4 = driver.findElement(By.xpath("//input[@id='user-name']")); // you can use any locator
        usernameCase4.sendKeys("standard_user");
        WebElement passwordCase4 = driver.findElement(By.xpath("//input[@id='password']")); // you can use any locator
        passwordCase4.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        Thread.sleep(1000);
        String validationURL = driver.getCurrentUrl();
        System.out.println(validationURL.trim().equals("https://www.saucedemo.com/inventory.html") ? "URL Passed" : "URL Failed");
    }
}
