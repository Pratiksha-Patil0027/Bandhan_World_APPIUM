package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigReader;

public class BaseClassTest {

    protected AndroidDriver driver;
    protected ConfigReader configReader;

    @BeforeSuite(alwaysRun = true)
    public void launchApp() throws MalformedURLException {

        configReader = new ConfigReader();

        UiAutomator2Options options = new UiAutomator2Options()
       
                .setPlatformName(configReader.getProperty("PLATFORMNAME"))
                .setAutomationName(configReader.getProperty("AUTOMATIONNAME"))
                .setDeviceName(configReader.getProperty("DEVICENAME"))
               // .setUdid(configReader.getProperty("UDID")) // udid is mandatory for real devices"")
                 .setApp(System.getProperty("user.dir") + configReader.getProperty("APP"))
                // .setAppPackage("com.prowess.apps.bandhan.world")
                // .setAppActivity("com.prowess.apps.influencer.mvvm.presentation.activity.NewDashboardActivity")
                .setNoReset(false) // IMPORTANT
                .setFullReset(false)
                .setDisableWindowAnimation(true) // SPEED BOOST
               .setAutoGrantPermissions(true)
               .setGpsEnabled(true);


        options.setCapability("automationName", "UiAutomator2");
        

options.setCapability("uiautomator2ServerInstallTimeout", 120000);
options.setCapability("uiautomator2ServerLaunchTimeout", 120000);
options.setCapability("uiautomator2ServerReadTimeout", 120000);
options.setCapability("skipServerInstallation", false);

options.setCapability("adbExecTimeout", 120000);
// VERY IMPORTANT FOR STABILITY
options.setCapability("ignoreHiddenApiPolicyError", true);
options.setCapability("skipDeviceInitialization", false);


        // Optional but safe
       options.setCapability("appium:androidImageInjectionEnabled", true);

        driver = new AndroidDriver(
                new URL(configReader.getProperty("SERVERURL")),
                options);

        // Prevent idle session timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(" Driver started for test");
    }


    

     @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println(" Driver quit");
        }
    }

    public AndroidDriver getDriver() {
        return driver;
    }




}
