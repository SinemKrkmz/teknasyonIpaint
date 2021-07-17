import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import util.driver.DriverFactory;

import java.io.IOException;


@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "pageSteps" ,
        plugin = {"html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class TestRunner extends AbstractTestNGCucumberTests {
        private static AppiumDriver driver;

        public static AppiumDriver getDriver(){
                return driver;
        }
        @BeforeTest //this method gets run first
        public void setUpTest() throws IOException {
                DriverFactory.getDriver();

        }

        @AfterTest //tearDown of AppDriver method happens at very end
        public void tearDownTest() {
                getDriver().quit();
        }
}