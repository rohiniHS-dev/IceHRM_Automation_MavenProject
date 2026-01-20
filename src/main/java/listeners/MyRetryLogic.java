package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryLogic  implements IRetryAnalyzer
{
	private int retryCount = 1;
	private static int maxRetry =2;
	public boolean retry(ITestResult arg0)
	{
		if(retryCount <= maxRetry)
		{
			retryCount++;
			return true;
		}
		return false;
	}
	

}
