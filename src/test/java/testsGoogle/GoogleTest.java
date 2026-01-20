package testsGoogle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleTest 
{
	@Test
	public void GoogleTestCase() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");
		Thread.sleep(3000);
		System.err.println("Google Test---");
		driver.close();
		

	}

}
