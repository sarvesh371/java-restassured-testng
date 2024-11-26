package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports report;
    public ExtentTest test;

    public void onStart(ITestContext context) {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports/test-report.html");
        report = new ExtentReports();
        report.attachReporter(sparkReporter);
    }

    public void onTestSuccess(ITestResult result) {
        test = report.createTest(result.getMethod().getMethodName());
        test.log(Status.PASS, "Test passed");
    }

    public void onTestFailure(ITestResult result) {
        test = report.createTest(result.getMethod().getMethodName());
        test.log(Status.FAIL, "Test passed");
    }

    public void onFinish(ITestContext context) {
        report.flush();
    }

}
