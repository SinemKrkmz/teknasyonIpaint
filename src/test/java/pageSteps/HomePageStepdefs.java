package pageSteps;

import backend.MobileAutomationException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.HomePage;

public class HomePageStepdefs {
    private static final HomePage homePage =  HomePage.getInstance();

    @Given("^User navigates to home page$")
    public void userNavigatesToIPaintHomePage() {
        homePage.closeLandingPage();
    }


    @When("User verify that Painting list is displayed")
    public void user_verif_that(){
        int elementSize = homePage.paintingListSize();
        if(elementSize < 6 ){
            throw new MobileAutomationException("DO NOT LISTING PAINTING");
        }
    }

    @And("Check that the home page navigation bottom icons has show")
    public void checkNavigationBottomIcon(){
        Assert.assertTrue(homePage.visibleHomeIcon());
        Assert.assertTrue(homePage.visibleCategoryIcon());
        Assert.assertTrue(homePage.visibleMyWorkIcon());
        Assert.assertTrue(homePage.visibleOthersIcon());
    }

    @And("Do it that scroll at home page")
    public void scrollHomePage(){
        Assert.assertTrue(homePage.scrollHomePage());
    }
}
