package sprint2;

import PageObjects.BaseTest;
import PageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LaunchAppLocal extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void LaunchApp() {
        Assert.assertTrue(homePage.buttonIsDisplayed(),"Button is Displayed");
        homePage.clickContinueButton();
        homePage.clickAceptarButton();
    }


    @Test(priority = 2)
    public void App() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(homePage.buttonIsDisplayed(),"Button is not Displayed");
        softAssert.assertAll();
    }
}
