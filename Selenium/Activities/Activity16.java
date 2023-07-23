package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity16 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Title of webpage:" + driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//input[contains(@class, '-username')]")).sendKeys("Aparna");
        driver.findElement(By.xpath("//input[contains(@class, '-password')]")).sendKeys("Aparna");
        driver.findElement(By.xpath("//label[text()='Confirm Password']/following-sibling::input")).sendKeys("Aparna");
        driver.findElement(By.xpath("//input[starts-with(@class, 'email-')]")).sendKeys("aparna.a4@ibm.com");

        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        System.out.println("Login message:"+driver.findElement(By.id("action-confirmation")).getText());

        driver.close();
    }
}
