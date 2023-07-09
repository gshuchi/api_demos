package w3c;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Collections;

public class ScrollGesture {

    private  AppiumDriver driver;

    public ScrollGesture(AppiumDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void performScrollDown(){
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int endX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endY = (int)(size.getHeight() * 0.25);
        scrollDownUsingSequence(startX,startY,endX,endY);
    }

    public void scrollDownUsingSequence(int startX, int startY, int endX, int endY){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"first-finger");
        Sequence sequence = new Sequence(finger,1);
        sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),startX,startY));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }




}
