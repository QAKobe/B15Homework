package com.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class Amina3 {

    @Test
    public void task1and2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com/Students/Index");
        WebElement createNew = driver.findElement(By.xpath("//a[.='Create New']"));
        createNew.click();
        driver.switchTo().frame("aswift_2");
        driver.switchTo().frame("ad_iframe");
        WebElement ad = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
        ad.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Amina");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Adv");
        WebElement enrollmentDate = driver.findElement(By.xpath("//input[@id='EnrollmentDate']"));
        enrollmentDate.sendKeys("3/2/2023");
        WebElement create = driver.findElement(By.xpath("//input[@value='Create']"));
        create.click();
        WebElement searchName = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchName.sendKeys("Amina", Keys.ENTER);
        List<WebElement> infoValidation = driver.findElements(By.tagName("tr"));
        for (int i = 1; i < infoValidation.size(); ) {
            Assert.assertEquals(BrowserUtils.getText(infoValidation.get(i)), "Amina Adv 3/2/2023 12:00:00 AM EDIT DETAILS DELETE");
            break;
        }
        searchName = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchName.clear();
        searchName.sendKeys("Adv", Keys.ENTER);
        WebElement editButton = driver.findElement(By.xpath("//button[.='EDIT']"));
        editButton.click();
        firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.clear();
        firstName.sendKeys("A");
        WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save']"));
        saveButton.click();
        searchName = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchName.sendKeys("A", Keys.ENTER);
        List<WebElement> newNameValidation = driver.findElements(By.tagName("td"));
        for (int i = 0; i < newNameValidation.size();) {
            Assert.assertEquals(BrowserUtils.getText(newNameValidation.get(i)), "A");
            break;
        }
    }
    @Test
    public void task3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com/Students/Index");
        WebElement searchName = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchName.sendKeys("Adv", Keys.ENTER);
        Thread.sleep(2000);
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='DELETE']"));
        deleteButton.click();
        WebElement deleteConfirm = driver.findElement(By.xpath("//input[@value='Delete']"));
        deleteConfirm.click();
        searchName = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchName.sendKeys("Adv",Keys.ENTER);
        //VALIDATE TEXT!!!
        Thread.sleep(1000);
        WebElement message = driver.findElement(By.xpath("//div[@class='container body-content']"));
        Assert.assertTrue(BrowserUtils.getText(message).contains("There are zero students with this search text Page 0 of 0"));
    }
    @Test
    public void task4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com/");
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(droppable).release().perform();
        WebElement droppedText = driver.findElement(By.xpath("//div[@id='droppable']//p"));
        Assert.assertTrue(droppedText.isDisplayed());
    }
    @Test
    public void task5(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com/");
        WebElement doubleClick = driver.findElement(By.xpath("//button[@name='dblClick']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).perform();
        Assert.assertEquals(driver.switchTo().alert().getText().trim(),"Double Clicked !!");
        driver.switchTo().alert().accept();
    }
    @Test
    public void task6() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com/");
        driver.switchTo().frame("iframe_a");
        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys("Amina");
        driver.switchTo().defaultContent();
        WebElement link = driver.findElement(By.xpath("//a[.='uitestpractice.com']"));
        link.click();
        Thread.sleep(1000);
        driver.switchTo().frame("iframe_a");
        WebElement iframeBox = driver.findElement(By.xpath("//div[@class='icon icon-generic']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(iframeBox).perform();
        WebElement validationText = driver.findElement(By.xpath("//div[@id='sub-frame-error-details']"));
        Assert.assertTrue(validationText.isDisplayed());
    }
    @Test
    public void task7(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com/");
        WebElement clickButton = driver.findElement(By.xpath("//a[.='Click here to watch videos on C#']"));
        clickButton.click();
        BrowserUtils.switchByTitle(driver,"C# Beginner to advanced - Lesson 29 - Delegates - YouTube");
        Assert.assertTrue(driver.getTitle().trim().contains("C# Beginner to advanced"));
        Assert.assertTrue(driver.getCurrentUrl().contains("youtube"));
    }
}
