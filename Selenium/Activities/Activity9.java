package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) throws IOException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/ajax");
        System.out.println("Title of webpage:" + driver.getTitle());

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//button[@class='ui violet button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='HELLO!']")));
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"),"I'm late!"));
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        driver.close();
    }
}
