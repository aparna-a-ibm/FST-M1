package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println("Title of webpage:"+driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        System.out.println(driver.findElement(By.xpath("//h5")).getCssValue("color"));
        System.out.println(driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class"));
        System.out.println(driver.findElement(By.xpath("//button[text()='Grey']")).getText());
        driver.close();
    }
}
