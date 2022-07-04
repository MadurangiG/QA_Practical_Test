package com.guru99.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterUserTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/index.php");
        driver.manage().window().maximize();

    }

    @Test
    public void testAddNewUser() {
        driver.findElement(By.linkText("REGISTER")).click();
        driver.findElement(By.name("firstName")).sendKeys("Madurangi");
        driver.findElement(By.name("lastName")).sendKeys("Guruge");
        driver.findElement(By.name("phone")).sendKeys("0712358967");
        driver.findElement(By.name("userName")).sendKeys("kpgmadurangi@gmail.com");
        driver.findElement(By.name("address1")).sendKeys("45,Katubedda,Moratuwa");
        driver.findElement(By.name("city")).sendKeys("Moratuwa");
        driver.findElement(By.name("state")).sendKeys("Western");
        driver.findElement(By.name("postalCode")).sendKeys("5225");
        Select countryDropDown = new Select(driver.findElement(By.name("country")));
        countryDropDown.selectByVisibleText("AUSTRIA");

        driver.findElement(By.id("email")).sendKeys("Madurangi");
        driver.findElement(By.name("password")).sendKeys("Mad@1234");
        driver.findElement(By.name("confirmPassword")).sendKeys("Mad@1234");
        driver.findElement(By.name("submit")).click();
    }
}
