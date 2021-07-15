import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import okio.Timeout;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class demo {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        File app = new File("sourceapp/as24-alpha-v4.4.2.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "AutoTest");
        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");

        //cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 7");
        //cap.setCapability(MobileCapabilityType.UDID, "05f0b23c");

        cap.setCapability("platformName", "Android");
        //cap.setCapability("platformVersion","10.0");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        //cap.setCapability("autoGrantPermissions",true);
        cap.setCapability("appWaitActivity","*");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        //AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement> (url,cap);
        AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement> (url,cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(10000);
        //driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='Deutsch']").click();
        driver.findElementByXPath("//android.widget.Button[@text='Schliessen']").click();
        driver.findElementByXPath("//android.widget.CheckBox[@text='Gebraucht']").click();
        Thread.sleep(3000);
        driver.quit();

    }
}
