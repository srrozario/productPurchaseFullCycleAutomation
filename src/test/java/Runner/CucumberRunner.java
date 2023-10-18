package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(tags ="@orderPurchaseJourney" , features = {"src/test/resources/Feature/TC_001_ProductPurchaseFullCycleTest.feature"},
        glue = {"StepDefinition"},   monochrome = true,
        dryRun = false,
        plugin = {
                "pretty","html:build/reports/featureReport.html"
        })
@Test
public class CucumberRunner extends AbstractTestNGCucumberTests {
}