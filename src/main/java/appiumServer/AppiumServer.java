package appiumServer;

import org.openqa.selenium.net.UrlChecker;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumServer {

    public void startAppiumServer(){

        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
            Thread.sleep(8000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startAppiumServer(String http, String port){

        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a" + http + " -p "+ port +"\"");
            Thread.sleep(8000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopAppiumServer(){
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
            runtime.exec("taskkill /F /IM cmd.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
