package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/searchandfilter.feature",
                "src/main/resources/wishandcart.feature",
                "src/main/resources/authorization.feature"},
        glue = "stepdefinitions"
)
public class RunnerTests {

}
