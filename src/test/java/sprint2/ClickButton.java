package sprint2;

import PageObjects.BaseTest;
import PageObjects.HomePage;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.time.Duration;

public class ClickButton extends BaseTest {

    HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void clickAccessibilityID() {
        homePage.clickAccessibilityID();
    }

    @Test(priority = 2)
    public void clickAccessibilityXPATH() {
        homePage.clickAccessibilityXPATH();
    }


}
