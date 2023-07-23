package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity19 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println("Title of webpage:" + driver.getTitle());

        driver.findElement(By.id("confirm")).click();
        System.out.println("Text from alert box:"+driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        System.out.println("Closed the alert with Ok");

        driver.findElement(By.id("confirm")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        System.out.println("Closed the alert with Cancel");
        driver.close();
    }
}
