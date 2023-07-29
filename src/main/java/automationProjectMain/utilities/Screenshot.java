package automationProjectMain.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File fileSource = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File fileLocation = new File(System.getProperty("user.dir") + "//testScreenshots//" + testCaseName + ".png");
        FileUtils.copyFile(fileSource, fileLocation);
        return System.getProperty("user.dir") + "//testScreenshots//" + testCaseName + ".png";
    }
}
