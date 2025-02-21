package sprint3;

import PageObjects.BaseTestParallel;
import PageObjects.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Parallel extends BaseTestParallel {

    HomePage homePage;

    @Test(priority = 1)
    public void LaunchApp() {
        homePage.checkContinueButton();
    }
}
