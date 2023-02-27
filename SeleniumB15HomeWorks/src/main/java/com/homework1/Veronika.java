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

public class Veronika {

    @Test()
    public void VerinkaHW() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver3 = new ChromeDriver();
        driver3.manage().window().maximize();
        driver3.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver3.navigate().to("https://demoqa.com/text-box");
        WebElement fullName = driver3.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Veronika");
        WebElement eMail = driver3.findElement(By.xpath("//input[@id='userEmail']"));
        eMail.sendKeys("vnikav@icloud.com");
        WebElement currentAddress = driver3.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        currentAddress.sendKeys("Chicago");
        WebElement permanentAddress = driver3.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("Istanbul");
        WebElement submitButton = driver3.findElement(By.xpath("//button[@id='submit']"));
        Thread.sleep(3000);
        submitButton.click();
        List<WebElement> allInfo = driver3.findElements(By.tagName("//p"));
        List<String> actualInfo = new ArrayList<>();
        for (WebElement info : allInfo) {
            actualInfo.add(info.getText());
        }
        List<String> expectedInfo = Arrays.asList("Name:Veronika",
                "Email:vnikav@icloud.com",
                "Current Address :Chicago",
                "Permanent Address :Istanbul");
        System.out.println(!actualInfo.equals(expectedInfo) ? "Passed" : "Failed");
        driver3.close();
    }

    /*
     STEP 2:
     1-Navigate to "https://demoqa.com/radio-button"
     2-Click yes radio button
     3-Validate text is: You have selected Yes
     4-Click Impressive radio button
     5-Validate text is: You have selected Impressive
     TIPS: Be careful about your XPath if you have any issue with getting the text */
    @Test()
    public void VeronikaTC2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver4 = new ChromeDriver();
        driver4.manage().window().maximize();
        driver4.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver4.navigate().to("https://demoqa.com/radio-button");
        WebElement radioButton = driver4.findElement(By.xpath("//label[@class='custom-control-label']"));
        if (radioButton.isDisplayed() && !radioButton.isSelected()) {
            radioButton.click();
            Thread.sleep(3000);
            WebElement validateText = driver4.findElement(By.tagName("p"));
            String actualMessage = validateText.getText().trim();
            String expectedMessage = "You have selected Yes";
            String result = actualMessage.equals(expectedMessage) ? "PASSED" : "FAILED";
            System.out.println(result);

            WebElement impressiveButton = driver4.findElement(By.xpath("//label[@for='impressiveRadio']"));
            if (impressiveButton.isDisplayed() && !radioButton.isSelected()) {
                impressiveButton.click();
                Thread.sleep(3000);
                WebElement impressiveText = driver4.findElement(By.xpath("//p[@class='mt-3']"));
                String actualImpressiveMessage = impressiveText.getText().trim();
                String expectedImpressiveMessage = "You have selected Impressive";
                if (actualImpressiveMessage.equals(expectedImpressiveMessage)) {
                    System.out.println("PASSED");
                } else {
                    System.out.println("FAILED");
                }
            }
        }
    }
        /*
         STEP 3:
      Navigate to "https://www.saucedemo.com/"
      Enter username "Java"
      Enter password "Selenium"
      Click Login button
      Validate "Epic sadface: Username and password do not
      match any user in this service" message
TIPS:to be able to see this message you need to first see this
message then try to inspect it. (it means at least run one time
with the username and password you provided above to see
the message then inspect the message.*be careful with it is
fully copied or not.
Steps
       */

    @Test()
    public void VeronikaTC3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("Java");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Selenium");
        //password.sendKeys("Selenium",Keys.ENTER);
        WebElement logInButton = driver.findElement(By.id("login-button"));
        logInButton.click();
        Thread.sleep(3000);
        WebElement message = driver.findElement(By.tagName("h3"));
        String expectedMessage2 = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(message.getText().equals(expectedMessage2) ? "Passed" : "Failed");
        driver.quit();
    }
        /*
         STEP 4:
        Navigate to "https://www.saucedemo.com/"
        Enter username "standard_user"
        Enter password "secret_sauce"
        Click Login button
        Validate current url is
        "https://www.saucedemo.com/inventory.html"
 */
        @Test()
        public void VEronikaTC4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement userName1 = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName1.sendKeys("standard_user");
        WebElement password1 = driver.findElement(By.xpath("//input[@id='password']"));
        password1.sendKeys("secret_sauce");
        WebElement accessButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        accessButton.click();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        System.out.println(driver.getCurrentUrl().trim().equals(expectedUrl) ? "Passed" : "Failed");
        driver.close();

    }}

