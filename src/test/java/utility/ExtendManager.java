package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendManager {

    private static ExtentReports reports;

    public static ExtentReports getInstance() {

        if (reports == null) {
            ExtentSparkReporter htmlReport = new ExtentSparkReporter("target/ExtentReport.html");
            reports = new ExtentReports();
            reports.attachReporter(htmlReport);
        }
        return reports;
    }
}
