package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net");
        String title=driver.getTitle();
        System.out.println("Title of webpage:"+title);
        WebElement aboutUsBtn=driver.findElement(By.id("about-link"));
        aboutUsBtn.click();
        System.out.println("Title of the webpage now:"+driver.getTitle());
        driver.close();
    }
}
