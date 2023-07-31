package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        tags = "@SmokeTest",
        plugin = {"pretty","html:reports/test-reports"},
        monochrome = true
)
public class Activity6HTMLReport_Runner {
}
