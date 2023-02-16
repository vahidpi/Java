package Selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumScript {

  public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/Users/piroova/Documents/chromedriver");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

//    driver.get("https://www.ebay.com/");
//    driver.findElement(By.id("gh-ac")).sendKeys("Mobiles");
//    driver.findElement(By.id("gh-btn")).click();

    driver.get("https://migri.fi/etusivu");
    driver.findElement(By.xpath("//div[@role='button']")).click();
    driver.findElement(By.xpath("//textarea[@placeholder='Kirjoita viestisi tähän.']"))
        .sendKeys("Check place in queue");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[@aria-label='Lähetä']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//textarea[@placeholder='Write your message here.']"))
        .sendKeys("2499/310/2020");
    driver.findElement(By.xpath("//button[@aria-label='Send']")).click();

  }
}
