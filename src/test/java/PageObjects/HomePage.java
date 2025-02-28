package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePage extends BasePage {

    By byContinuarButtonID = AppiumBy.id("com.android.permissioncontroller:id/continue_button");
    By byContinuarButtonXPATH = AppiumBy.id("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/continue_button']");
    Boolean button;

    By byAceptarButtonID=AppiumBy.id("android:id/button1");
    By byAceptarButtonXPATH = AppiumBy.id("//android.widget.Button[@resource-id='android:id/button1']");

    By byCancelarButtonID = AppiumBy.id("com.android.permissioncontroller:id/cancel_button");
    By byAccessibilityID = AppiumBy.accessibilityId("Accessibility");
    By byAccessibilityXPATH = AppiumBy.xpath("//android.widget.TextView[@content-desc='Accessibility']");

    public HomePage(AndroidDriver driver) {
        super(driver);
    }


    public void checkContinueButton() {
        System.out.println("Check Continue Button");
        driver.findElement(byContinuarButtonID).isDisplayed();
    }

    public boolean buttonIsDisplayed() {
        button = driver.findElement(byContinuarButtonID).isDisplayed();
        return button;
    }

    public void clickContinueButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(byContinuarButtonID));
        driver.findElement(byContinuarButtonID).click();
    }

    public void clickAceptarButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(byAceptarButtonID));
        driver.findElement(byAceptarButtonID).click();
    }



    public void clickAccessibilityID() {
        System.out.println("AccessibilityID");
        driver.findElement(byAccessibilityID).click();
        driver.navigate().back();
        takeScreenshot("_uno");
    }


    public void clickAccessibilityXPATH() {
        System.out.println("AccessibilityXPATH");
        driver.findElement(byAccessibilityXPATH).click();
        driver.navigate().back();
        takeScreenshot("_dos");
    }

    public void click() {
        System.out.println("AccessibilityXPATH");
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"\")")).isEnabled();
        driver.navigate().back();
        takeScreenshot("_dos");
    }


}
