package com.home_works_b15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.logging.Level;

public class Arthur {

    @Test
    public void ArthurHW() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//Navigate to "https://demoqa.com/text-box"
        driver.get("https://demoqa.com/text-box");

//Enter your full name, email, current and permanent address
        WebElement fullName = driver.findElement(By.xpath("//input[@id = 'userName']"));
        fullName.sendKeys("Artur");

        WebElement email = driver.findElement(By.xpath("//input[@id = 'userEmail']"));
        email.sendKeys("Artur1111@gmail.com");

        WebElement addressCurrent = driver.findElement(By.xpath("//textarea[@id = 'currentAddress']"));
        addressCurrent.sendKeys("7200 Devon Ave, Des Plains, IL, 60755");

        WebElement addressPermanent = driver.findElement(By.xpath("//textarea[@id = 'permanentAddress']"));
        addressPermanent.sendKeys("1000 Tech Ave, Des Plains, IL, 75456");

//Click submit button.

        WebElement submit = driver.findElement(By.xpath("//button[@id = 'submit']"));
        submit.click();
        Thread.sleep(1000);

//Validate that all of your information is displayed and matching correctly.

        WebElement nameCheck = driver.findElement(By.xpath("//p[@id = 'name']"));
        String nameValidation = nameCheck.getText().trim();
        System.out.println(nameValidation.equals("Name:Artur") ? "NAME PASSED" : "NAME FAILED");

        WebElement emailChecked = driver.findElement(By.xpath("//p[@id = 'email']"));
        String emailValidation = emailChecked.getText().trim();
        System.out.println(emailValidation.equals("Email:Artur1111@gmail.com") ? "EMAIL PASSED" : "EMAIL FAILED");


//checking if the same

        WebElement currentAddressValidation = driver.findElement(By.xpath("//p[@id = 'currentAddress']"));
        String addressTextCurrent = currentAddressValidation.getText().trim();
        String currentCut = (addressTextCurrent.substring(addressTextCurrent.indexOf(":") + 1));

        WebElement permanentAddressValidation = driver.findElement(By.xpath("//p[@id = 'permanentAddress']"));
        String addressTextPermanent = permanentAddressValidation.getText().trim();
        String permanentCut = (addressTextPermanent.substring(addressTextPermanent.indexOf(":") + 1));

        System.out.println(currentCut.equals(permanentCut) ? "Address if THE SAME :  PASSED" : "Address if THE SAME :FILED");

// validate address

        System.out.println(currentCut.equals("7200 Devon Ave, Des Plains, IL, 60755") ? "current address PASSED" : "current address FAILED");
        System.out.println(permanentCut.equals("1000 Tech Ave, Des Plains, IL, 75456") ? "Permanent address PASSED" : "Permanent address FAILED");

        Thread.sleep(10000);
        driver.quit();
    }

    @Test()
    public void ArthurHW2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//Navigate to "https://demoqa.com/radio-button"
        driver.get("https://demoqa.com/radio-button");

// Click Yes radio button
        WebElement radioButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        radioButton.click();
//Validate text is : You have selected Yes
        WebElement validationRadioButton = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String stringRadioButton = validationRadioButton.getText().trim();
        System.out.println(stringRadioButton.equals("You have selected Yes") ? "RadioButton PASSED" : "RadioButton FAILED");

        Thread.sleep(2000);
//Click Impressive radio button
        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();

//Validate text is : You have selected Impressive
        WebElement validationImpressiveButton = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String stringImpressiveButton = validationImpressiveButton.getText().trim();
        System.out.println(stringImpressiveButton.equals("You have selected Impressive") ? "ImpressiveButton PASSED" : "ImpressiveButton FAILED");
    }

    @Test()
    public void ArthurHW3() throws InterruptedException {

        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//Navigate to "https://www.saucedemo.com/"
        driver.navigate().to("https://www.saucedemo.com/");

//Enter username "Java"
        WebElement userName = driver.findElement(By.xpath("//input[@id= 'user-name']"));
        userName.sendKeys("Java");
//Enter password "Selenium"
        WebElement password = driver.findElement(By.xpath("//input[@id= 'password']"));
        password.sendKeys("Selenium");
//Click Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id= 'login-button']"));
        loginButton.click();

        Thread.sleep(2000);

        WebElement loginError = driver.findElement(By.xpath("//h3[@data-test = 'error']"));
        String ValidationLoginError = loginError.getText().trim();
        System.out.println(ValidationLoginError.equals("Epic sadface: Username and password do not match any user in this service") ? "PASSED" : "FAILED");
        Thread.sleep(10000);
        // driver.quit();
    }

    @Test()
    public void ArthurHW4() throws InterruptedException, FileNotFoundException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//Navigate to "https://www.saucedemo.com/"
        driver.navigate().to("https://www.saucedemo.com/");

//Enter username "standard_user"
        WebElement userName = driver.findElement(By.xpath("//input[@id= 'user-name']"));
        userName.sendKeys("standard_user");
//Enter password "secret_sauce"
        WebElement password = driver.findElement(By.xpath("//input[@id= 'password']"));
        password.sendKeys("secret_sauce");
//Click Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id= 'login-button']"));
        loginButton.click();

        String link = driver.getCurrentUrl().trim();
        System.out.println(link.equals("https://www.saucedemo.com/inventory.html") ? "PASSED" : "FAILED");
        Thread.sleep(10000);
        driver.quit();
    }
}
