package com.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	ExtentReports extent;
	ExtentTest test;

	public ExtentReport() {
		
		String reportPath = System.getProperty("user.dir") + "/Reports/ECOM_App_Login_Report.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		// Setting environment for Extent report
		extent.setSystemInfo("Machine name:", "HP Pavillion");
		extent.setSystemInfo("Tester name:", "Swathi Acharya");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Google Chrome");
		
		// Configuration of the report
		spark.config().setDocumentTitle("ECOM_App_Login_Report");
		spark.config().setReportName("ECOM_App_Login Details");
		spark.config().setTheme(Theme.DARK);
		spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	
		test = extent.createTest("Login Test").assignCategory("Functional Testing");
	}

	public void logPass(String message) {
		test.info("Valid Login"); 
		test.log(Status.PASS, message);
	}

	public void logFail(String message) {
		test.info("Invalid Login"); 
		test.log(Status.FAIL, message);
	}

	public void generateReport() {
		extent.flush();
	}

}
