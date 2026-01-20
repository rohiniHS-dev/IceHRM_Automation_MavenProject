package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import listeners.mylistener;
import utility.BaseClass;

@Listeners(mylistener.class)
public class SocialMediaTesting extends BaseClass{

	//@Test(groups = {"Smoke", "Regression"}, retryAnalyzer = MyRetryLogic.class)
	@Test(groups = {"Smoke", "Regression"})
	public void facebooTest() throws InterruptedException
	{
		driver.get("https://facebook.com");
		Thread.sleep(3000);
		System.err.println("FaceBook Test---");
	}
	@Test(groups = {"Regression"})
	public void InstagramTest() throws InterruptedException
	{
		driver.get("https://instagram.com");
		Thread.sleep(3000);
		System.err.println("Instagram Test---");
//		
//		String expectedTitle = "Instagram";
//		
//		String actualTitle = driver.getTitle();
//		System.out.println(expectedTitle.equals(actualTitle));
//		System.out.println("Actual title: "+actualTitle);
		
//		Hard Assert
//		Assert.assertEquals(actualTitle, expectedTitle);
		
//		Soft assert
//		SoftAssert softassert = new SoftAssert();
//		softassert.assertEquals(actualTitle, expectedTitle);
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//title(text()='Search')")).click();
//		softassert.assertAll();
		
	}

}
