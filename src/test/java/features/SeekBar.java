package features;

import config.AndroidManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import w3c.LongPressNSeekGesture;
import w3c.ScrollGesture;

import java.time.Duration;

public class SeekBar extends AndroidManager {

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
        LongPressNSeekGesture longPressNSeek = new LongPressNSeekGesture(driver);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        for (int i = 0; i <5; i++) {
            scroll.performScrollDown();
            wait(4000);
        }
        driver.findElement(AppiumBy.accessibilityId("Seek Bar")).click();
        wait(4000);
        WebElement seekBar = driver.findElement(AppiumBy.id("io.appium.android.apis:id/seek"));
        longPressNSeek.longPress(driver,seekBar);
        System.out.println("SeekBar Done Successfully");

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
