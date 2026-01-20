package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.DriverManager;

public class mylistener implements ITestListener
{

	@Override
	public void onStart(ITestContext context)
	{
		System.out.println(context.getName()+ "test begin");
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		System.out.println(context.getName()+ "test completed");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+ "test started successfully");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+ "test completed successfully");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+ " test failed");
		
		TakesScreenshot ts=(TakesScreenshot) DriverManager.getDriver();
		File takescreenShot = ts.getScreenshotAs(OutputType.FILE);
		
//		store screenshot
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
		
	}

}
