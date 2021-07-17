package page;

import pageElement.ButtonActions;
import pageElement.PageElementModel;

public class HomePage extends MasterPage{

    private static HomePage instance;

    public static synchronized HomePage getInstance(){
        if (instance == null)
            instance = new HomePage();
        return instance;
    }
    private static final ButtonActions BTN_LANDING_PAGE_CLOSE = new ButtonActions(PageElementModel.selectorNames.XPATH,"(//android.view.ViewGroup[2])[2]");
    private static final ButtonActions BTN_PAINTING_LIST = new ButtonActions(PageElementModel.selectorNames.ID,"root");
    private static final ButtonActions BTN_PAINTING_EIGHT = new ButtonActions(PageElementModel.selectorNames.XPATH,"//android.widget.FrameLayout[8]");

    public void closeLandingPage(){
        //The functionality of the display elements should be checked. (Checkbox, Radio Button etc.)
        BTN_LANDING_PAGE_CLOSE.waitUntilVisibleAndClick();
    }

    public int paintingListSize(){
        //Waiting for the structure until the element to be controlled comes to the next screen.
        BTN_PAINTING_LIST.waitUntilVisible();
       int elementsSize = BTN_PAINTING_LIST.getElements().size();
       return elementsSize;
    }

    public boolean scrollHomePage(){
        BTN_PAINTING_EIGHT.swipeDown();
        BTN_PAINTING_EIGHT.waitUntilVisible();
        return BTN_PAINTING_EIGHT.isExist();

    }


}
