import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class demo1 extends BaseClass{

    AppiumDriver<MobileElement> driver;

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        startAppiumServer();
        driver = capabilities();
    }

    @Test
    public void TC001() throws InterruptedException {
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='Deutsch']").click();
        driver.findElementByXPath("//android.widget.Button[@text='Schliessen']").click();
        driver.findElementByXPath("//android.widget.CheckBox[@text='Gebraucht']").click();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
        stopAppiumServer();
    }
}
