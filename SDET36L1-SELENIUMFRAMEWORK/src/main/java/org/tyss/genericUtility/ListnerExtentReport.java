package org.tyss.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerExtentReport implements ITestListener{
	
	private ExtentReports report;
	private ExtentSparkReporter spark;
	private ExtentTest test ;
	private ExtentTest testlog;

	@Override
	public void onFinish(ITestContext context) {
report.flush();		
	}

	@Override
	public void onStart(ITestContext context) {
	 spark=new ExtentSparkReporter("./extentreport-output/emailable-extentreport.html");
	spark.config().setDocumentTitle("Extent Report");
	spark.config().setReportName("sms");
	spark.config().setTheme(Theme.STANDARD);
	
	 report=new ExtentReports() ;
		report.attachReporter(spark);
	report.setSystemInfo("os", "windows");
	
	report.setSystemInfo("browser", "chrome");
	
	report.setSystemInfo("versionofbrowser","103.0.1");
		
		
	}
	

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getMethod().getMethodName()+"yet to fail testcases");
		test.fail(result.getThrowable());
		String image = ThreadSafeClass.getDriver1().takescreenshot(ThreadSafeClass.getDriver());
		test.addScreenCaptureFromBase64String(image,result.getMethod().getMethodName());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		test = report.createTest(result.getMethod().getMethodName());
		test.assignAuthor("sowmya");
		test.assignCategory("all");
		 testlog = test;
		
		
	
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	

}
