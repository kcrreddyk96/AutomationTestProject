package automationProjectMain.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
    static String path = System.getProperty("user.dir") + "//testReports//index.html";
    static ExtentSparkReporter reporter = new ExtentSparkReporter(path);
    static ExtentReports extentreports = new ExtentReports();

    public static ExtentReports getReportObject() {
        reporter.config().setReportName("Test Automation Report");
        reporter.config().setDocumentTitle("Test Automation Reports");
        reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        reporter.config().setTheme(Theme.DARK);
        extentreports.attachReporter(reporter);
        extentreports.attachReporter(reporter);
        extentreports.setSystemInfo("Host", "Local_Host");
        extentreports.setSystemInfo("Application Type", "Web Application");
        extentreports.setSystemInfo("Application Name", "Project Name");
        extentreports.setSystemInfo("System_Environment", "Windows");
        extentreports.setSystemInfo("Test_Environment", "Test");
        extentreports.setSystemInfo("Tester_Name", "Chandra Shekar Reddy");
        return extentreports;
    }
}
