package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println("Title of webpage:" + driver.getTitle());
        driver.findElement(By.id("prompt")).click();
        System.out.println("Text from alert box:"+driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Awesome!");
        driver.switchTo().alert().accept();
        driver.close();
    }
}
