import appiumServer.AppiumServer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass extends AppiumServer{

    public static AppiumDriver<MobileElement> capabilities(String appName) throws MalformedURLException {

        AppiumDriver<MobileElement> driver;

        //File app = new File("sourceapp/ApiDemos-debug.apk");
        File app = new File("sourceapp/"+ getAppName(appName));

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "AutoTest");
        //cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");

        //cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 8");
        cap.setCapability(MobileCapabilityType.UDID, "05f0b23c");

        cap.setCapability("platformName", "Android");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability("appWaitActivity","*");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        //AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement> (url,cap);
        driver = new AppiumDriver<MobileElement> (url,cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }

    public static String getAppName(String appKey){
        try
        {
            String userDir = System.getProperty("user.dir");
            FileInputStream app = new FileInputStream(userDir + "/src/main/java/global.properties");
            Properties pros = new Properties();
            pros.load(app);
            return (String) pros.get(appKey);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
