package myApp.E_CommApp.TestComponents;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {

    public static ExtentReports getExtentReport() {

        File filePath = new File(System.getProperty("user.dir") + "/reports/index.html");
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filePath);
        extentSparkReporter.config().setDocumentTitle(" Automation Results");
        extentSparkReporter.config().setReportName("E-Comm Web Automation Results");

        ExtentReports extentReport = new ExtentReports();
        extentReport.attachReporter(extentSparkReporter);
        extentReport.setSystemInfo("Tester", "Suhail");
        return extentReport;
    }

}
