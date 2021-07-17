package pageSteps;

import io.cucumber.java.en.And;
import org.testng.Assert;
import page.LanguagePage;
import page.OtherPage;

public class LanguagePageSteps {

    LanguagePage languagePage = LanguagePage.getInstance();
    OtherPage  otherPage = OtherPage.getInstance();

    @And("Select to language")
    public void selectLanguage(){
        String languageBase = languagePage.getLanguageText();
        String language = "English";
        if(languageBase.equals("English")){
            language ="Türkçe";
        }
        otherPage.goToLanguagePage();
        languagePage.selectLanguage(language);
        Assert.assertEquals(languagePage.getLanguageText(),language);

    }
}
