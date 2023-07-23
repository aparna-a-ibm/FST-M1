package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class Activity11 {
    public static void main(String[] args){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get(" https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of webpage:" + driver.getTitle());
        WebElement checkBox=driver.findElement(By.xpath("//input[@class='willDisappear']"));
        checkBox.click();
        boolean checkSelected=checkBox.isSelected();
        System.out.println("Checkbox selected="+checkSelected);
        checkBox.click();
        checkSelected=checkBox.isSelected();
        System.out.println("Checkbox selected="+checkSelected);
        driver.close();
    }
}
