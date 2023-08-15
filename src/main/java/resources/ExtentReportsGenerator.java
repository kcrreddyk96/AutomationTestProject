package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ExtentReportsGenerator {
    public static ExtentReports getExtentReport() {
        ExtentReports report = new ExtentReports();
        File extentReportFile = new File(System.getProperty("user.dir") + "//extentReports/Reports//TestReport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
        report.attachReporter(sparkReporter);
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//configs//config.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException exception caught in initialize method: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException exception caught in initialize method: " + e.getMessage());
        }
        try {
            sparkReporter.loadJSONConfig(new File(System.getProperty("user.dir") + "//src//main//java//resources//ExtentConfig.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
      /*  sparkReporter.config().setReportName("Test Automation Report");
        sparkReporter.config().setDocumentTitle("Test Automation Reports");
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setCss(".badge-primary{background-color:#ed5045} .badge-success, .pass-bg, .avatar.pass{background-color:#28be3b}");
        sparkReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");*/
        sparkReporter.viewConfigurer().viewOrder().as(new ViewName[]{
                ViewName.DASHBOARD,
                ViewName.TEST,
                ViewName.EXCEPTION,
                ViewName.CATEGORY,
                ViewName.DEVICE,
                ViewName.AUTHOR,
                ViewName.LOG

        }).apply();
        report.attachReporter(sparkReporter);
        report.setSystemInfo("Test_Environment ", properties.getProperty("Test_Environment"));
        report.setSystemInfo("Application_Name ", properties.getProperty("Application_Name"));
        report.setSystemInfo("Application_URL ", properties.getProperty("webpageURL"));
        report.setSystemInfo("Browser_Name ", properties.getProperty("web_browser"));
        report.setSystemInfo("Operating_System ", System.getProperty("os.name"));
        report.setSystemInfo("Operating_Architecture ", System.getProperty("os.arch"));
        report.setSystemInfo("Java_Version ", System.getProperty("java.runtime.version"));
        report.setSystemInfo("File_Encoding ", System.getProperty("file.encoding"));
        report.setSystemInfo("Tester_Name ", System.getProperty("user.name"));
        //System.getProperties().list(System.out);
        return report;
    }
}
