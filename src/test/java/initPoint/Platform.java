package initPoint;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/*
 Platform class is a helper class. It helps to determine witch platform would be tested.
 Depending on the selected platform, the values for the driver are set here.
 */

public class Platform {
    public  String AppiumURL = "http://0.0.0.0:4723/wd/hub";
    public final String PLATFORM_IOS = "ios";
    public final String PLATFORM_ANDROID = "android";

    public AppiumDriver getDriver()throws Exception {
        URL URL = new URL(AppiumURL);
        if (this.isAndroid()){
            return new AndroidDriver(URL, this.getAndroidCapabilies());
        } else if (this.isIOS()){
            return new IOSDriver(URL,this.getiOSCapabilies());
        } else throw new Exception("Unknown driver " + this.getPlatformVar());
    }

    public boolean isAndroid() {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS() {
        return isPlatform(PLATFORM_IOS);
    }


    public DesiredCapabilities getAndroidCapabilies() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","TestDevice");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("automationName","UIAutomator2");
        capabilities.setCapability("appPackage","com.casparhealth.android.patient");
        capabilities.setCapability("appActivity","com.casparhealth.android.patient.splash.SplashActivity");
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("disableWindowAnimation",true);

        return capabilities;
    }

    public DesiredCapabilities getiOSCapabilies() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        return capabilities;
    }

    public boolean isPlatform(String my_platform) {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }


    public String getPlatformVar() {
        return System.getenv("PLATFORM");
    }
}