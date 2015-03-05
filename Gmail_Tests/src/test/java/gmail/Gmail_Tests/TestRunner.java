package gmail.Gmail_Tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
format = {
"json:target/cucumber-report.json"
},
features = {
    "src/test/resources/"
} ,
glue = 
{
	"gmail.Gmail_Tests",
},

tags={
		
}
  
)

 

public class TestRunner {
}
