package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Downloads\\pts-2023-2024-master\\pts-2023-2024-master\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Otvorime webovu stranku
        driver.get("https://ais2.ukf.sk/ais/start.do");

        try {
            Thread.sleep(1000);
            //odklikneme cookies
            WebElement cookiesButton = driver.findElement(By.id("accept-cookies"));
            cookiesButton.click();
            //zadame login a heslo do prislusnych policiek
            Thread.sleep(1000);
            WebElement login = driver.findElement(By.id("login"));
            login.sendKeys("******");
            WebElement password = driver.findElement(By.id("heslo"));
            password.sendKeys("**********");
            //klikneme na login
            WebElement loginButton = driver.findElement(By.id("login-form-submit-btn"));
            loginButton.click();
            //cakame aby sa stranka nacitala
            Thread.sleep(2000);
            //otvorimre rozvrh
            WebElement rozvrh = driver.findElement(By.xpath("/html/body/app-root/div/div[1]/div[3]/app-body/div[1]/div/app-rozvrh/div/div/button"));
            rozvrh.click();
            //urobime screenshot rozvrhu
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Uloženie sreenshotu
            FileUtils.copyFile(screenshot, new File("screenshot.png"));

            Thread.sleep(5000);

            WebElement midstep = driver.findElement(By.xpath("/html/body/app-root/lib-app-header/nav/div[3]"));
            midstep.click();
            Thread.sleep(500);
            WebElement odhlasenie = driver.findElement(By.xpath("/html/body/app-root/lib-app-header/nav/div[3]/div/a/span"));
            odhlasenie.click();
            Thread.sleep(2000);
            //zatvorime aktuálny tab
            driver.close();
        }  catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        //ukoncime test
        driver.quit();

    }
}
