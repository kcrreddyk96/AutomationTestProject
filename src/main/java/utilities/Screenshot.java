package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Screenshot {
    //TODO - Sending Screenshot file
    public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File fileSource = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File fileLocation = new File(System.getProperty("user.dir") + "//extentReports//Screenshots//" + testCaseName + ".png");
        FileUtils.copyFile(fileSource, fileLocation);
        return fileLocation.getAbsolutePath();
    }

    //TODO - Old Method
    public static String getBase64Screenshot(String testCaseName, WebDriver driver) throws IOException {
        String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        String destinationScreenshotFilePath = System.getProperty("user.dir") + "//extentReports//Screenshots//Base64//" + testCaseName + ".png";
        File destinationScreenshotFile = new File(destinationScreenshotFilePath);
        FileOutputStream fileOutputStream = new FileOutputStream(destinationScreenshotFile);
        fileOutputStream.write(Base64.getDecoder().decode(base64Screenshot));
        return destinationScreenshotFilePath;
    }

    //TODO - Simple Method for base64 format Screenshot
    public static String takesBase64Screenshot(WebDriver driver) {
        String base64ScreenshotCode = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        return base64ScreenshotCode;
    }
}
