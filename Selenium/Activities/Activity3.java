package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        //Activity1
        driver.get("https://v1.training-support.net");
        System.out.println("Title of webpage:"+ driver.getTitle());
        driver.findElement(By.xpath("//a[text()='About Us']")).click();
        System.out.println("Title of the webpage now:" + driver.getTitle());

        //Activity2
        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println("Navigated to webpage:"+driver.getTitle());
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        if(driver.findElement(By.xpath("//div[@id='action-confirmation']")).isDisplayed()){
            System.out.println("Login successful!");
        }
        driver.close();

    }
}
