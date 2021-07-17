package pageElement;

import io.appium.java_client.MobileElement;

public class LabelActions extends PageElementModel{

    public LabelActions(selectorNames selectorName, String selectorValue) {
        super(selectorName, selectorValue);
    }

    public String getElementText(){

        String elementText;
        MobileElement me = getAnElement();
        elementText = me.getText();
        return  elementText;
    }
}
