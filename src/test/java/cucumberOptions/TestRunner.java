package cucumberOptions;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.Cucumber;

// @RunWith(Cucumber.class) we don't need since we use Testng
@CucumberOptions(
	features = "src/test/java/features",
	glue = "stepDefinitions"
	//plugin = {"pretty"}
	)
public class TestRunner extends AbstractTestNGCucumberTests  {

}
