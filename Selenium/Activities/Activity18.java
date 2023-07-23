package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity18 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Title of webpage:" + driver.getTitle());

        Select multiSelect= new Select(driver.findElement(By.id("multi-select")));
        multiSelect.selectByVisibleText("Javascript");

        multiSelect.selectByIndex(4);

        multiSelect.selectByIndex(5);

        multiSelect.selectByIndex(6);

        multiSelect.selectByValue("node");

        System.out.println("Selected options are: ");
        for(WebElement option : multiSelect.getAllSelectedOptions()) {
            System.out.println(option.getText());
        }

        multiSelect.deselectByIndex(5);
        System.out.println("\nSelected options after deselecting fifth option: ");
        for(WebElement option : multiSelect.getAllSelectedOptions()) {
            System.out.println(option.getText());
        }


    }
}
