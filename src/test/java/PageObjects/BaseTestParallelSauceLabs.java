package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTestParallelSauceLabs {
    public static final String SL_username = System.getenv("Morso777");
    public static final String SL_accessKey = System.getenv("f516c32f-cf88-430f-a6bc-221b960ede3f");
    public ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public  void setDriver(AppiumDriver driver) {
        this.driver.set(driver);
    }

    public AppiumDriver getDriver(){
        return this.driver.get();
    }

    @BeforeMethod
    @Parameters({"deviceName", "platformVersion", "portNumber"})
    public void setupParallelSauceLabs(String deviceName, String platformVersion, String portNumber ) throws InterruptedException, MalformedURLException {
        startAppiumService(portNumber);
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=ApiDemos-debug.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", deviceName);
        caps.setCapability("appium:platformVersion", platformVersion);
        caps.setCapability("appium:automationName", "UiAutomator2");
        // Agregar capacidades adicionales para appPackage y appActivity
        caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", SL_username);
        sauceOptions.setCapability("accessKey", SL_accessKey);
        sauceOptions.setCapability("build", "appium-build-R0OJR");
        sauceOptions.setCapability("name", "<Test launch app>");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        setDriver(new AndroidDriver(new URL("https://ondemand.us-west-1.saucelabs.com::" + portNumber+ "/wd/hub"), desiredCapabilities));

        // replace with commands and assertions
        Thread.sleep(5000);

    }

    @AfterMethod
    public void tearDownParallelSauceLabs() {
        String jobStatus = "passed"; // or "failed"
        // end the session
        getDriver().executeScript("sauce:job-result=" + jobStatus);
        getDriver().quit();
    }

    public void startAppiumService (String portNumber){
        AppiumDriverLocalService service;
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.0.1");
        builder.usingPort(Integer.parseInt(portNumber));
        service= AppiumDriverLocalService.buildService(builder);
        service.start();
    }
}

