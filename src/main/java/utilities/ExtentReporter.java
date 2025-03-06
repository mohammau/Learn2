package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	public static ExtentReports getExtentReport() {
		
		String FilePath = System.getProperty("user.dir") + "\\report\\extentreport.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(FilePath);
		
		reporter.config().setReportName("Name");
		reporter.config().setDocumentTitle("Title");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Operating System", "Sonoma");
		report.setSystemInfo("Tested by", "Ummar");
		
		return report ;
		
	}
	
}
