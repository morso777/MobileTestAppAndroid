package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {

    protected static AndroidDriver driver;
    public static final String SL_username = System.getenv("Morso777");
    public static final String SL_accessKey = System.getenv("f516c32f-cf88-430f-a6bc-221b960ede3f");






    @BeforeMethod
    public void setupSauceLabs() throws InterruptedException, MalformedURLException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=ApiDemos-debug.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", SL_username);
        sauceOptions.setCapability("accessKey", SL_accessKey);
        sauceOptions.setCapability("build", "appium-build-R0OJR");
        sauceOptions.setCapability("name", "<Test launch app>");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

        // Agregar capacidades adicionales para appPackage y appActivity
        caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

        // Start the session
        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        //AndroidDriver driver = new AndroidDriver(url, caps);
        driver = new AndroidDriver(url, caps);

        // replace with commands and assertions
        Thread.sleep(5000);

    }

    @AfterMethod
    public void tearDownSauceLabs() {
        String jobStatus = "passed"; // or "failed"
        // end the session
        driver.executeScript("sauce:job-result=" + jobStatus);
        driver.quit();
    }




/*
    @BeforeMethod
    public void setupLocal() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Motorola");
        caps.setCapability("udid", "ZY22H9J8L6");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        File appDir = new File("src");
        File app = new File(appDir, "ApiDemos-debug.apk");
        caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        // Agregar capacidades adicionales para appPackage y appActivity
        caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

        try {
            // Instantiate Android Driver
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            // Interact with the app (example)
            System.out.println("App launched successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDownLocal() {
        driver.quit();
    }
*/

}
