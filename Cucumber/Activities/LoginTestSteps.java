package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTestSteps {
    WebDriver driver;
    WebDriverWait wait;
    @Given("User is on Login page")
    public void user_is_on_login_page(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @When("^User enters username and password$")
    public void user_enters_username_and_password(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }
    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_username_and_password_parameterized(String username,String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }
    @Then("^Read the page title and confirmation message$")
    public void read_the_page_title_and_confirmation_message(){
        System.out.println("Title of page:"+driver.getTitle());
        String loginMessage=driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message:"+loginMessage);
        if(loginMessage.contains("admin")) {
            assertEquals( "Welcome Back, admin",loginMessage);
        } else {
            assertEquals("Invalid Credentials",loginMessage);
        }

    }

    @And("^Close the Browser$")
    public void closeTheBrowser() {
        driver.close();
    }

}
