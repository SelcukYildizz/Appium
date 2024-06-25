package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReusableMethods {

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tiklamaMethodu(int x, int y, int secondToWait) {
        TouchAction touchAction = new TouchAction(Driver.getAndroidDriver());

        touchAction.press(PointOption.point(x, y))
                .release()
                .perform();
        wait(secondToWait);
    }

    public static void dropDownKaydırma(String text) {
        WebElement element = (WebElement) Driver.getAndroidDriver().findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0));");
        element.click();
    }

    public static String getScreenshot(String name) throws IOException {

        SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String timeStamp = date.format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot)Driver.getAndroidDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("ScreenShot") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);
        return target;
    }





}
