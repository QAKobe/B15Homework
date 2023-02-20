package com.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Munkhtuvshin {

    @Test()
    public void MunkhtuvshinHW1() throws InterruptedException {
        /*Navigate to "https://demoqa.com/text-box"
        Enter your full name, email, current and permanent address Click submit button.
        Validate that all of your information is displayed and matching correctly.
                TIPS:Think about if conditions.
                Example:
        Name:David
        Email: david@gmail.com
        Current Address :Random Address Permananet Address : different address
    */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");
        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Tuvshuu Ochirbat");
        Thread.sleep(3000);
        WebElement eMail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        eMail.sendKeys("tuvshuu@gmail.com");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("2200 Random Address");
        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("2200 Permanent Address");
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        submitButton.click();

        WebElement actualFullName = driver.findElement(By.xpath("//p[@id='name']"));
        String printedActualFullName = actualFullName.getText().trim();
        String expectedFullName = "Name:Tuvshuu Ochirbat";
        System.out.println(printedActualFullName.equals(expectedFullName) ? "Pass" : "Fail");

        WebElement actualeMail = driver.findElement(By.xpath("//p[@id='email']"));
        String printedActualeMail = actualeMail.getText().trim();
        String expectedeMail = "Email:tuvshuu@gmail.com";
        System.out.println(printedActualeMail.equals(expectedeMail) ? "Pass" : "Fail");

        WebElement actualCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String printedActualCurrentAddress = actualCurrentAddress.getText().trim();
        String expectedCurrentAddress = "Current Address :2200 Random Address";
        System.out.println(printedActualCurrentAddress.equals(expectedCurrentAddress) ? "Pass" : "Fail");

        WebElement actualPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String printedActualPermanentAddress = actualPermanentAddress.getText().trim();
        String expectedPermanentAddress = "Permananet Address :2200 Permanent Address";
        System.out.println(printedActualPermanentAddress.equals(expectedPermanentAddress) ? "Pass" : "Fail");

        driver.close();
    }

    @Test()
    public void MunkhtuvshinHW2() throws InterruptedException {

        /*
Navigate to "https://demoqa.com/radio-button" Click Yes radio button
Validate text is : You have selected Yes
Click Impressive radio button
Validate text is : You have selected Impressive
TIPS: be careful about your xpath if you have any issue with getting the text.
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement yes = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", yes);
        Thread.sleep(3000);

        if (yes.isDisplayed() && yes.isEnabled() && !yes.isSelected()) {
            yes.click();
        }

        String actualYes = driver.findElement(By.xpath("//p[@class='mt-3']")).getText().trim();

        String expectedYes = "You have selected Yes";
        System.out.println(actualYes.equals(expectedYes) ? "Pass" : "Fail");

        WebElement impressive = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));

        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", impressive);

        if (impressive.isDisplayed() && impressive.isEnabled() && !impressive.isSelected()) {
            impressive.click();
        }

        String actualImpressive = driver.findElement(By.xpath("//p[@class='mt-3']")).getText().trim();
        String expectedImpressive = "You have selected Impressive";
        System.out.println(actualImpressive.equals(expectedImpressive) ? "Pass" : "Fail");

        Thread.sleep(4000);

        driver.close();
    }

    @Test()
    public void MunkhtuvshinHW3() throws InterruptedException {

        /*
Navigate to "https://www.saucedemo.com/"
Enter username "Java"
Enter password "Selenium"
Click Login button
Validate "Epic sadface: Username and password do not match any user in this service" message
TIPS:to be able to see this message you need to first see this message then try to inspect it.
it means at least run one time with the username and password you provided above to see the
message then inspect the message.*be careful with it is fully copied or not.
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        Thread.sleep(4000);

        String actualMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText().trim();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(actualMessage.equals(expectedMessage) ? "Pass" : "Fail");

        driver.close();
    }

    @Test()
    public void MunkhtuvshinHW4() throws InterruptedException {


        /*
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Validate current url is "https://www.saucedemo.com/inventory.html"
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        String actualCurrentUrl = driver.getCurrentUrl().trim();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        System.out.println(actualCurrentUrl.equals(expectedUrl) ? "Pass" : "Fail");

        Thread.sleep(4000);

        driver.close();
    }
}
