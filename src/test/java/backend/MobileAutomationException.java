package backend;

import cucumber.api.Scenario;
import hooks.CucumberHooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MobileAutomationException extends RuntimeException  {

    public MobileAutomationException (String message){
        super(message);
        String description = " EXCEPTION MESSAGE: " + message;

        File scrFile = ((TakesScreenshot) CucumberHooks.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String filePath = "reports/Report-" + sdf.format(Calendar.getInstance().getTime()) + "/screenshots/" + Scenario.class.getName() + ".png";

        try {
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        };

    }
}
