package pageSteps;

import io.cucumber.java.en.And;
import org.testng.Assert;
import page.LanguagePage;
import page.OtherPage;

public class OtherPagesStep {
     OtherPage otherPage = OtherPage.getInstance();
     LanguagePage languagePage = LanguagePage.getInstance();


    @And("Go to Others Page")
    public void goToOtherPage(){
       otherPage.clickOthersIcon();
        if(languagePage.getLanguageText().equals("English")){
            Assert.assertEquals(otherPage.checkPageTitle(),"Others");
        }else {
            Assert.assertEquals(otherPage.checkPageTitle(),"Diğerleri");
        }

    }

    @And("Click Be Premium")
    public void clickPremium(){
        otherPage.clickToPremium();
    }

}
