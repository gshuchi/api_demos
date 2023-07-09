package w3c;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Collections;

    public class DragNDropGesture {
        AppiumDriver driver;

        public DragNDropGesture(AppiumDriver driver){
            this.driver = driver;
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }
        public void DragNDrop(WebElement source, WebElement target){

            Point sourceElementCenter = getCenterOfElement(source.getLocation(),source.getSize());
            Point targetElementCenter = getCenterOfElement(target.getLocation(),target.getSize());

            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence sequence = new Sequence(finger1,1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(500)))
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), targetElementCenter))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(sequence));
        }

        private Point getCenterOfElement(Point location, Dimension size){
            return new Point(location.getX() + size.getWidth()/2,
                    location.getY() + size.getHeight()/2);
        }


    }
