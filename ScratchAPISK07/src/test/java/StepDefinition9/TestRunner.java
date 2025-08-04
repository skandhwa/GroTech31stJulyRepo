package StepDefinition9;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="src/test/java/FeatureFiles/",
		glue= {"StepDefinition9"},
		tags="@smoke or @sanity",
		monochrome=false,
		plugin= {"pretty","html:target/HtmlReports/index.html"
				,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				
		}
		
		
		
		
		
		
		)






public class TestRunner {

}
