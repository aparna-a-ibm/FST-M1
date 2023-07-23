package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity15 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Title of webpage:" + driver.getTitle());
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//input[starts-with(@class, 'username-')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[starts-with(@class, 'password-')]")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        System.out.println("Login message:"+driver.findElement(By.id("action-confirmation")).getText());
        driver.close();
    }
}
