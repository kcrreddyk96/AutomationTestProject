package automationProjectTest.testComponents;

import automationProjectMain.resources.ExtentReporter;
import automationProjectMain.utilities.Browser;
import automationProjectMain.utilities.Screenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends Browser implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporter.getReportObject();
    ThreadLocal<ExtentTest> ThreadLocal = new ThreadLocal<ExtentTest>(); // TODO - Thread Safe

    public void onTestStart(ITestResult result) {
        System.out.println("New Test Started " + result.getName());
        test = extent.createTest(result.getMethod().getMethodName());
        ThreadLocal.set(test);  // TODO - Assign Unique Thread Id for "test"
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Successfully Finished " + result.getName());
        // TODO - Shows Success Message
        ThreadLocal.get().log(Status.PASS, "Test has Passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed " + result.getName());
        //TODO - Shows Error Message in the Reports
        ThreadLocal.get().fail(result.getThrowable());

        //TODO - getScreenshot, Attach in the Reports
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }


        String filePath = null;
        try {
            filePath = Screenshot.getScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ThreadLocal.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped " + result.getName());

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed but within success percentage " + result.getName());

    }

    public void onStart(ITestContext context) {
        System.out.println("This is onStart method " + context.getOutputDirectory());

    }

    public void onFinish(ITestContext context) {
        System.out.println("This is onFinish method " + context.getPassedTests());
        System.out.println("This is onFinish method " + context.getFailedTests());
        extent.flush();

    }

}
