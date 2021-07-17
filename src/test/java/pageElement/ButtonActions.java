package pageElement;

import backend.MobileAutomationException;
import io.appium.java_client.MobileElement;

public class ButtonActions extends PageElementModel {

    public ButtonActions(selectorNames selectorName, String selectorValue) {
        super(selectorName, selectorValue);
    }

    public void click() {
        MobileElement me = getAnElement();
        try {
            me.click();
        } catch (Exception e) {
            String error = "COULD NOT CLICK BUTTON: " + getLoggingName() + " " + e.getMessage();

            throw new MobileAutomationException(error);
        }
    }

    public void waitUntilVisibleAndClick() {
        waitUntilVisible();
        click();
    }
}
