import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.ChooseLanguagePage;

import java.net.MalformedURLException;


public class Testdemo1 extends BaseClass{

    AppiumDriver<MobileElement> driver;

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        System.out.println("Testdemo1");
        startAppiumServer();
        driver = capabilities("AS24");
    }

    @Test
    public void TC001() throws InterruptedException {
        ChooseLanguagePage clp = new ChooseLanguagePage(driver);
        //clp.chooseLanguage("Italiano");
        clp.chooseLanguage("Deutsch");
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
