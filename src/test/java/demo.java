import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class demo {

    public static void main(String[] args) throws MalformedURLException {

        File appDir = new File("sourceapp");
        File app = new File(appDir,"ApiDemos-debug.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "AutoTest");
        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        //cap.setCapability("platformName", "Android");
        //cap.setCapability("platformVersion","10.0");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        //cap.setCapability("appPackage","com.google.android.calculator");
        //cap.setCapability("appActivity","com.google.calculator2.Calculator");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement> (url,cap);
        //AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement> (url,cap);
        driver.quit();

    }
}
