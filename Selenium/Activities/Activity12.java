package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get(" https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of webpage:" + driver.getTitle());

        WebElement textField=driver.findElement(By.id("input-text"));
        boolean checkIfEnabled=textField.isEnabled();
        System.out.println("Text field enabled="+checkIfEnabled);

        driver.findElement(By.id("toggleInput")).click();
        checkIfEnabled=textField.isEnabled();
        System.out.println("Text field enabled="+checkIfEnabled);
        driver.close();
    }
}
