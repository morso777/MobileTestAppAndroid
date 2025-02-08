package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePage extends BasePage{

    By byAccessibilityID = AppiumBy.accessibilityId("Accessibility");
    By byAccessibilityXPATH = AppiumBy.xpath("//android.widget.TextView[@content-desc='Accessibility']");

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public void clickAccessibilityID(){
        System.out.println("AccessibilityID");
        driver.findElement(byAccessibilityID).click();
        driver.navigate().back();
        takeScreenshot("_uno");
    }


    public void clickAccessibilityXPATH(){
        System.out.println("AccessibilityXPATH");
        driver.findElement(byAccessibilityXPATH).click();
        driver.navigate().back();
        takeScreenshot("_dos");
    }


}
