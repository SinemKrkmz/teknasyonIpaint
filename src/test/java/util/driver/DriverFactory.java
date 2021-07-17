package util.driver;

import backend.MobileAutomationException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverFactory {

    private static final String APPPACKAGE = "com.teknasyon.coloringbook" ;
    private static final String APPACTIVITY = "com.teknasyon.coloringbook.view.activity.SplashActivity";

    public static AppiumDriver getDriver() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Automation");
        capabilities.setCapability("udid", getDeviceId());
        capabilities.setCapability("appPackage", APPPACKAGE);
        capabilities.setCapability("appActivity", APPACTIVITY);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("autoWebView",true);
        capabilities.setCapability("setWebContentsDebuggingEnabled",true);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("newCommandTimeout", 0);


        try {
            return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {

            throw new MobileAutomationException(e.getMessage());
        }
    }


    private static String getDeviceId(){
        String deviceId = null;
        try {
            Process process = Runtime.getRuntime().exec("adb devices");
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while((line = input.readLine()) != null){
                String[] lineArr = line.split("\t");
                if(lineArr.length > 1 && lineArr[1].equalsIgnoreCase("device")) {
                    deviceId = lineArr[0];
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deviceId;
    }
}
