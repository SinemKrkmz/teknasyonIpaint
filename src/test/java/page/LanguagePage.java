package page;

import pageElement.ButtonActions;
import pageElement.LabelActions;
import pageElement.PageElementModel;

public class LanguagePage extends MasterPage {

    private static LanguagePage instance;
    private static ButtonActions BTN_SELECT_LANGUAGE;
    private static LabelActions LBL_LANGUAGE = new LabelActions(PageElementModel.selectorNames.ID,"languageText");

    public static synchronized LanguagePage getInstance() {
        if (instance == null)
            instance = new LanguagePage();
        return instance;
    }

    public void selectLanguage(String language) {
        BTN_SELECT_LANGUAGE = new ButtonActions(PageElementModel.selectorNames.XPATH, "//android.widget.TextView[@text='" + language + "']");
        BTN_SELECT_LANGUAGE.waitUntilVisible(5);
        BTN_SELECT_LANGUAGE.click();
    }
    public String getLanguageText(){
        LBL_LANGUAGE.waitUntilVisible();
        LBL_LANGUAGE.waitFor(5);
        return LBL_LANGUAGE.getElementText();
    }
}
