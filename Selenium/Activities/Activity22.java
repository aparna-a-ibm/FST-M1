package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity22 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions builder=new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/popups");
        System.out.println("Title of webpage:" + driver.getTitle());
        WebElement button=driver.findElement(By.xpath("//button[contains(@class,'orange button')]"));
        builder.moveToElement(button).build().perform();
        System.out.println("Tooltip message:"+button.getAttribute("data-tooltip"));

        button.click();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        System.out.println("Login message:"+driver.findElement(By.id("action-confirmation")).getText());
        driver.close();


    }
}
