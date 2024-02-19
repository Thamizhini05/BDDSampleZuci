package runners;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		//features="src//test//resources//features//GooglePageSearch.feature", //to run GooglePageSearch.feature
//		features="src//test//resources//features//UserLogin.feature", // to run UserLogin.feature
		features="src//test//resources//features//", //to run more than one feature file, should give the folder name instead of feature file's name
		glue= {"stepDefinition"},
		dryRun=false,
		monochrome=true,
		plugin= {"pretty",
				"html:target/Reports/HtmlReport.html",
//				"json:target/Reports/JsonReport.json",
//				"usage:target/Reports/UsageReport",
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				
		}
		)
		//by default dryRun is false
public class GooglePageRunner extends AbstractTestNGCucumberTests{
	@DataProvider(parallel=true)//to run scenerios in parallel
	public Object[][] scenarios(){
		return super.scenarios();
	}
  
}

