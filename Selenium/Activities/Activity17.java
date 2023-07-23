package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Activity17 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Title of webpage:" + driver.getTitle());
        Select singleSelect= new Select(driver.findElement(By.id("single-select")));
        singleSelect.selectByVisibleText("Option 2");
        System.out.println("Selected the second option using visible text:"+singleSelect.getFirstSelectedOption().getText());
        singleSelect.selectByIndex(3);
        System.out.println("Selected the third option using index:"+singleSelect.getFirstSelectedOption().getText());
        singleSelect.selectByValue("4");
        System.out.println("Selected the fourth option using value:"+singleSelect.getFirstSelectedOption().getText());
        System.out.println("All items from select dropdown:");
        for(WebElement selectOption:singleSelect.getOptions()){
            System.out.println(selectOption.getText());

        }
        driver.close();
    }
}
