package frameWork.Testrunner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import frameWork.Utility.FrameWorkBase;


//We Need Cucumber Options
@CucumberOptions(features = {"src/test/resourcess/frameWorkAllFeatures"},
plugin = {"json:target/cucumber.json"}, //html report/ test result
glue = "frameWorkStepDifinition")//tags = {"@Sanity"})

	public class FrameWorkTestRunner extends AbstractTestNGCucumberTests {
	//responsible for open the browser//TestNG is owner or responsible for BeforeTest and AfterTest
		@BeforeTest
		 public void FrameWorkStartURL() {
			 FrameWorkBase EStart = new  FrameWorkBase(); // FrameWorkBase coming from FrameWork.Utilitybase class
			 EStart.FrameWorkBrowserSetup(); 
			 
		 }
		//responsible for close browser
		 @AfterTest
		 public void FrameWorkCloseBrowser() {
			 FrameWorkBase EStart = new FrameWorkBase();
			 EStart.driver.quit();
			 
		 }
	
}
