package resources.ExtentReportTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ReportAuthorAndCategory {
    public static void main(String[] arg) {

        ExtentReports extentReports = new ExtentReports();
        File reportPath = new File(System.getProperty("user.dir") + "//testReports//Reports//ReportAuthorAndCategory.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        extentReports.attachReporter(sparkReporter);

        ExtentTest eTest1 = extentReports.createTest("Test One", "This is the description of Test One");
        eTest1.log(Status.INFO, "Test One Execution Started");
        eTest1.log(Status.PASS, "Test One got Successfully Passed");
        eTest1.log(Status.INFO, "Test One Execution Completed");
        eTest1.assignAuthor("Reddy");
        eTest1.assignCategory("Smoke");
        eTest1.assignDevice("FireFox");

        ExtentTest eTest2 = extentReports.createTest("Test Two", "This is the description of Test Two");
        eTest2.log(Status.INFO, "Test Two Execution Started");
        eTest2.log(Status.FAIL, "Test Two got Failed");
        eTest2.log(Status.INFO, "Test Two Execution Completed");
        eTest2.assignAuthor("KCR");
        eTest2.assignCategory("Sanity");
        eTest2.assignDevice("Chrome");

        ExtentTest eTest3 = extentReports.createTest("Test Two", "This is the description of Test Three");
        eTest3.log(Status.INFO, "Test Three Execution Started");
        eTest3.log(Status.FAIL, "Test Three got Failed");
        eTest3.log(Status.INFO, "Test Three Execution Completed");
        eTest3.assignAuthor("KCR","Reddy");
        eTest3.assignCategory("Sanity,Smoke,Regression");
        eTest3.assignDevice("Edge");

        ExtentTest eTest4 = extentReports.createTest("Test Four", "This is the description of Test Four");
        eTest4.log(Status.INFO, "Test Four Execution Started");
        eTest4.log(Status.FAIL, "Test Four got Failed");
        eTest4.log(Status.INFO, "Test Four Execution Completed");
        eTest4.assignAuthor(new String[]{"KCR","Reddy","Srikar","Monahor"});
        eTest4.assignCategory(new String[]{"Sanity,Smoke,Regression","UAT"});
        eTest4.assignDevice("FireFox");
    }
}
