package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Platform;

import java.net.URL;
import java.time.Duration;

public class AndroidManager {

    static AppiumDriver driver;
    private static final UiAutomator2Options androidOptions = new UiAutomator2Options();
    public static AppiumDriver createAndroidDriver() {
        try {
            androidOptions.setPlatformName(Platform.ANDROID.name())
                    .setPlatformVersion("13.0")
                    .setAutomationName("UiAutomator2")
                    .setApp(System.getProperty("user.dir") + "/src/main/resources/ApiDemos-debug.apk")
                    .setAppPackage("io.appium.android.apis")
                    .setAppActivity(".ApiDemos")
                    .setAvd("Pixel_3a")
                    .setDeviceName("emulator-5554")
                    .setFullReset(false)
                    .setNewCommandTimeout(Duration.ofSeconds(30))
                    .autoGrantPermissions();
            URL url = new URL("http://0.0.0.0:4723/");
            driver = new AndroidDriver(url, androidOptions);
        }catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return driver;
    }

    public static void wait(int timeout) throws InterruptedException {
        Thread.sleep(timeout);
    }



}
