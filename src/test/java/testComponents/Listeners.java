package testComponents;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import resources.ExtentReportsGenerator;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static utilities.Screenshot.*;

public class Listeners extends BaseTest implements ITestListener {
    ExtentTest eTest;
    ExtentReports report = ExtentReportsGenerator.getExtentReport();
    ThreadLocal<ExtentTest> ThreadLocal = new ThreadLocal<ExtentTest>(); // TODO - Thread Safe

    public void onTestStart(ITestResult result) {
        System.out.println("New Test Started " + result.getName());
        String testCaseName = result.getMethod().getMethodName();
        String[] desc = result.getMethod().getDescription().split(",");
        String description = desc[2];
        String module = desc[1];
        eTest = report.createTest(testCaseName, description);
        ThreadLocal.set(eTest);  // TODO - Assign Unique Thread Id for "test"
        ThreadLocal.get()
                /*  .info(Arrays.toString(result.getMethod().getGroups()))
                  .info(MarkupHelper.createLabel(Arrays.toString(result.getMethod().getGroups()), ExtentColor.CYAN))
                  .info(MarkupHelper.createLabel(description, ExtentColor.CYAN))*/
                .assignDevice(module)
                .log(Status.INFO, testCaseName + " has started execution");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Successfully Finished " + result.getName());
        String testCaseName = result.getMethod().getMethodName();
        String[] author = result.getMethod().getDescription().split(",");
        String TestDevName = author[0];
        System.out.println(TestDevName);
        ThreadLocal.get()
                .log(Status.PASS, MarkupHelper.createLabel(testCaseName + " got successfully executed", ExtentColor.GREEN))
                .assignCategory(result.getMethod().getGroups())
                .assignAuthor(TestDevName);
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed " + result.getName());
        String testCaseName = result.getMethod().getMethodName();
        String[] author = result.getMethod().getDescription().split(",");
        String TestDevName = author[0];
        System.out.println(TestDevName);
        //TODO - getting Screenshot, Attach in the Reports
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        String filePath = null;
        try {
            filePath = getScreenshot(testCaseName, driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ThreadLocal.get()
                .log(Status.FAIL, MarkupHelper.createLabel(testCaseName + " has failed in execution", ExtentColor.RED))
                /* //TODO - Attaching Screenshot in the Report
                 .addScreenCaptureFromPath(filePath, result.getMethod().getMethodName())*/
                /*//TODO - AttachingBase64 format Screenshot in the Report
                .addScreenCaptureFromBase64String(takesBase64Screenshot(driver), testCaseName)*/
                /* //TODO - Attaching Screenshot file in Log Level
                .log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(filePath, testCaseName).build())*/
                //TODO - Attaching Screenshot file in Log Level
                .log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(takesBase64Screenshot(driver),
                        testCaseName + " Screenshot as Base64").build())
                .log(Status.WARNING, MarkupHelper.createLabel(testCaseName + " logs attached below", ExtentColor.AMBER))
                .log(Status.WARNING, result.getThrowable()) //TODO - Shows Error Message in the Reports
                .assignCategory(result.getMethod().getGroups())
                .assignAuthor(TestDevName);
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped " + result.getName());
        String testCaseName = result.getMethod().getMethodName();
        String[] author = result.getMethod().getDescription().split(",");
        String TestDevName = author[0];
        System.out.println(TestDevName);
        ThreadLocal.get()
                .log(Status.SKIP, MarkupHelper.createLabel(testCaseName + " has skipped the execution", ExtentColor.RED))
                .log(Status.WARNING, MarkupHelper.createLabel(testCaseName + " logs attached below", ExtentColor.AMBER))
                .log(Status.WARNING, result.getThrowable())
                .assignCategory(result.getMethod().getGroups())
                .assignAuthor(TestDevName);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed but within success percentage " + result.getName());

    }

    public void onStart(ITestContext context) {
        System.out.println("This is onStart method " + context.getOutputDirectory());

    }

    public void onFinish(ITestContext context) {
        System.out.println("This is onFinish method " + context.getPassedTests());
        report.flush();

    }

}
