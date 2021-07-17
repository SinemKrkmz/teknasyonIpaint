package hooks;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import util.driver.DriverFactory;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.instanceOf;

public class CucumberHooks {

    private static CucumberHooks instance;
    private static AppiumDriver driver;

    public static synchronized CucumberHooks getInstance(){
        if(instance == null){
            instance = new CucumberHooks();
        }
        return instance;
    }

    public static AppiumDriver getDriver(){
        return driver;
    }

    @Before
    public void beforeNexus5xOreo() throws IOException {
        driver = DriverFactory.getDriver(); //start our Android driver and device when we run a test with "Nexus5xOreo" as the tag
    }

    @After
    public void stopAppDriver() {
        if(getDriver() != null)
            getDriver().quit();
    }
}