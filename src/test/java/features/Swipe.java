package features;

import config.AndroidManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import w3c.ScrollGesture;

import java.time.Duration;

public class Swipe extends AndroidManager {

    private AppiumDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void invokeApp()
    {
        driver = createAndroidDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        System.out.println("App Launched successfully");
    }

    @Test(enabled = true)
    public void invokeTest() throws InterruptedException {
        ScrollGesture scroll = new ScrollGesture(driver);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        for (int i = 0; i <5; i++) {
            scroll.performScrollDown();
            wait(4000);
        }
        System.out.println("Scroll Down successfully");
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
