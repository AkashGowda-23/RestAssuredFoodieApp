package Automation;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.ExtentReport;

public class Listners  implements ITestListener{
	ExtentTest test;
	ExtentReports report=ExtentReport.getreport();
	public void onTestStart(ITestResult result) {
		test= report.createTest(result.getName());
		
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("this is fsiled test "+ result.getName());
		test.fail(result.getThrowable(),null);
		
		
	}
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS,"the test is passed");
		
	}
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	



}
