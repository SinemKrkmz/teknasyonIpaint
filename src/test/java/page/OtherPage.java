package page;


import hooks.CucumberHooks;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import pageElement.ButtonActions;
import pageElement.LabelActions;
import pageElement.PageElementModel;

public class OtherPage extends MasterPage{

    private static OtherPage instance;
    private static final LabelActions LBL_PAGE_TITLE = new LabelActions(PageElementModel.selectorNames.ID,"toolbarTitle");
    private static final ButtonActions BTN_LANGUAGE = new ButtonActions(PageElementModel.selectorNames.ID,"language");
    private static final ButtonActions BTN_PREMIUM = new ButtonActions(PageElementModel.selectorNames.ID,"goPremiumText1");

    public static synchronized OtherPage getInstance() {
        if (instance == null)
            instance = new OtherPage();
        return instance;
    }

    public String checkPageTitle(){
        LBL_PAGE_TITLE.waitUntilVisible();
        return LBL_PAGE_TITLE.getElementText();
    }

    public void goToLanguagePage(){
        BTN_LANGUAGE.waitUntilVisibleAndClick();
    }

    public void clickToPremium(){
        BTN_PREMIUM.waitUntilVisible();
        Point location = BTN_PREMIUM.getMobileElement().getLocation();
        TouchAction action= new TouchAction(CucumberHooks.getInstance().getDriver());
        action.tap(new PointOption().withCoordinates(location.getX(),location.getY())).perform();
        BTN_PREMIUM.waitFor(30);
    }

}
