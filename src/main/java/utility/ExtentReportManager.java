package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager 
{
	private static ExtentReports extentReports ;
	private static ThreadLocal<ExtentTest> tests=new ThreadLocal<ExtentTest>();
	
	public static ExtentReports createExtentReport() 
	{
		if(extentReports == null)
		{
//		1. creating webpage
		ExtentSparkReporter extentSpark = new ExtentSparkReporter("./reportsFolder/extent_reports.html");
		extentSpark.config().setDocumentTitle("ICE HRM Automation");
		extentSpark.config().setTheme(Theme.DARK);
		
//		creating dashboard
		extentReports = new ExtentReports();
		extentReports.setSystemInfo("Suite Name", "Regression");
		
		extentReports.attachReporter(extentSpark);
		}
		return extentReports;
		
	}
	public static void setTest(ExtentTest extentTest) 
	{
		tests.set(extentTest);
		
	}
	public static ExtentTest getTest()
	{
		return tests.get();
	}
	public static void flushreport()
	{
		if(extentReports != null)
		{
			extentReports.flush();
		}
	}

}
