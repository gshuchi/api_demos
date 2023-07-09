package features;

import config.AndroidManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import w3c.DragNDropGesture;
import java.time.Duration;

public class DragNDrop extends AndroidManager {

    private static AppiumDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void invokeApp()
    {
        driver = createAndroidDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        System.out.println("App Launched successfully");
    }

    @Test(enabled = true)
    public void invokeTest() throws InterruptedException {
        DragNDropGesture action = new DragNDropGesture(driver);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        wait(4000);
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        wait(4000);
        WebElement source =  driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement target = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));
        action.DragNDrop(source,target);
        wait(4000);
        System.out.println("Drag and Drop done successfully");

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }



}
