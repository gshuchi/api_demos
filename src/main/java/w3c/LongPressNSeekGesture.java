package w3c;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Collections;

public class LongPressNSeekGesture {

    AppiumDriver driver;

    public LongPressNSeekGesture(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void longPress(AppiumDriver driver, WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Point centerOfElement = getCenterOfElement(location, size);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(3)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(3000), PointerInput.Origin.viewport(), location.getX()-50, location.getY()))
                .addAction(new Pause(finger1, Duration.ofSeconds(3)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(3000), PointerInput.Origin.viewport(), location.getX()+1000, location.getY()))
                .addAction(new Pause(finger1, Duration.ofSeconds(3)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }
    public Point getCenterOfElement(Point location, Dimension size)
    {
        return new Point(location.getX() + size.getWidth()/2,
                location.getY() + size.getHeight()/2);
    }



}
