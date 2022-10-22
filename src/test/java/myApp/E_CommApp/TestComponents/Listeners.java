package myApp.E_CommApp.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseTest implements ITestListener {

    ExtentReports extent = ExtentReportsNG.getExtentReport();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    /**
     * Invoked each time a test succeeds.
     *
     * @param result <code>ITestResult</code> containing information about the run
     *               test
     * @see ITestResult#SUCCESS
     */
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "PASSED");
    }

    /**
     * Invoked each time a test fails.
     *
     * @param result <code>ITestResult</code> containing information about the run
     *               test
     * @see ITestResult#FAILURE
     */
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String path = null;
        try {
            path = getScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        extentTest.get().addScreenCaptureFromPath(path);
    }

    /**
     * Invoked each time a test is skipped.
     *
     * @param result <code>ITestResult</code> containing information about the run
     *               test
     * @see ITestResult#SKIP
     */
    public void onTestSkipped(ITestResult result) {
        // not implemented
    }

    /**
     * Invoked each time a method fails but has been annotated with
     * successPercentage and this failure
     * still keeps it within the success percentage requested.
     *
     * @param result <code>ITestResult</code> containing information about the run
     *               test
     * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
     */
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

    /**
     * Invoked each time a test fails due to a timeout.
     *
     * @param result <code>ITestResult</code> containing information about the run
     *               test
     */
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    /**
     * Invoked before running all the test methods belonging to the classes inside
     * the &lt;test&gt;
     * tag and calling all their Configuration methods.
     *
     * @param context The test context
     */
    public void onStart(ITestContext context) {
        // not implemented
    }

    /**
     * Invoked after all the test methods belonging to the classes inside the
     * &lt;test&gt; tag have
     * run and all their Configuration methods have been called.
     *
     * @param context The test context
     */
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
