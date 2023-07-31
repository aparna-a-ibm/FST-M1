package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class AlertStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    @Given("^User is on the page$")
    public void user_is_on_the_page(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }
    @When("^User clicks the Simple Alert button$")
    public void user_clicks_the_simple_alert_button(){
        driver.findElement(By.id("simple")).click();
    }
    @When("^User clicks the Confirm Alert button$")
    public void user_clicks_the_confirm_alert_button(){
        driver.findElement(By.id("confirm")).click();

    }
    @When("^User clicks the Prompt Alert button$")
    public void user_clicks_the_prompt_alert_button(){
        driver.findElement(By.id("prompt")).click();

    }
    @Then("^Alert opens$")
    public void alert_opens(){
        driver.switchTo().alert();
    }
    @And("^Read the text from it and print it$")
    public void read_text(){
        System.out.println("Alert text:"+driver.switchTo().alert().getText());
    }
    @And("^Write a custom message in it$")
    public void write_custom_message(){
        driver.switchTo().alert().sendKeys("New message");
    }
    @And("^Close the alert$")
    public void close_alert(){
        driver.switchTo().alert().accept();
    }
    @And("^Close the alert with Cancel$")
    public void close_alert_with_cancel(){
        driver.switchTo().alert().dismiss();
    }
    @And("^Close Browser$")
    public void closeBrowser() {
        driver.close();
    }
}
