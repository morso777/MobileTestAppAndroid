package sprint1;

import PageObjects.BaseTest;
import PageObjects.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchAppSauceLabs extends BaseTest {

    HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void LaunchApp() {
        homePage.checkContinueButton();
    }
}
