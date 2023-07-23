package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Activity21 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/tab-opener");
        System.out.println("Title of homepage:" + driver.getTitle());
        System.out.println("Parent tab: " + driver.getWindowHandle());
        driver.findElement(By.id("launcher")).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("Currently open windows: " + driver.getWindowHandles());
        for(String handle:driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        wait.until(ExpectedConditions.titleIs("Newtab"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("actionButton"))).click();
        System.out.println("Current tab: " + driver.getWindowHandle());
        System.out.println("Page title: " + driver.getTitle());
        System.out.println("Heading of web page:"+driver.findElement(By.xpath("//div[@class='content']")).getText());
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        wait.until(ExpectedConditions.titleIs("Newtab2"));
        System.out.println("Current tab: " + driver.getWindowHandle());
        System.out.println("Page title: " + driver.getTitle());
        System.out.println("Heading of web page:"+driver.findElement(By.xpath("//div[@class='content']")).getText());

        driver.quit();

    }
}
