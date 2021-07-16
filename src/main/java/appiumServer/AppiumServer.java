package appiumServer;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.net.UrlChecker;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumServer {

    private AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();;

    public void startAppiumServer(){

        if (!service.isRunning())
        {
            service.start();
        }
    }

    public void stopAppiumServer(){
        service.stop();
    }

    private boolean waitUntilIsRunning() throws MalformedURLException {
        String SERVER_URL = String.format("http://127.0.0.1:%d/wd/hub", 4723);
        final URL status = new URL(SERVER_URL + "/sessions");
        try {
            new UrlChecker().waitUntilAvailable(3000, TimeUnit.MILLISECONDS, status);
            return true;
        } catch (UrlChecker.TimeoutException e) {
            return false;
        }
    }
}
