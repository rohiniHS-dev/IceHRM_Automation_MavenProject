package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.DriverManager;
import utility.ExtentReportManager;

public class MyListenerReporting implements ITestListener
{


		@Override
		public void onStart(ITestContext context)
		{
			ExtentReportManager.createExtentReport();
		}
		
		
		@Override
		public void onTestStart(ITestResult result) {
			ExtentReports extentreport = ExtentReportManager.createExtentReport();
			ExtentTest test = extentreport.createTest(result.getName());
			ExtentReportManager.setTest(test);
		}
		
		@Override
		public void onTestSuccess(ITestResult result) {
			ExtentTest test = ExtentReportManager.getTest();
			test.log(Status.PASS, result.getName()+"test case passed");
		}
		
		@Override
		public void onTestFailure(ITestResult result) {
			System.out.println(result.getName()+ " test failed");
			
			TakesScreenshot ts=(TakesScreenshot) DriverManager.getDriver();
			File takescreenShot = ts.getScreenshotAs(OutputType.FILE);
			
//			store screenshot
			File destination = new File("./screenShotFolder/failureScreenshot.png");
			
			try 
			{
				FileHandler.copy(takescreenShot, destination);
			}
			catch (IOException e) 
			{
				
				e.printStackTrace();
			}
			
			System.err.println("--------Screenshot taken-------");
			
			ExtentTest test = ExtentReportManager.getTest();
			test.log(Status.FAIL, result.getThrowable()+"test case passed");
			
		}
		@Override
		public void onFinish(ITestContext context)
		{
			System.out.println(context.getName()+ "test completed");
			ExtentReportManager.flushreport();
		}

	

}
